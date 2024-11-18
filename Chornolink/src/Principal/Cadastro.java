package Principal;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Principal.conexaoBD; 
import java.util.Calendar;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import Visualização.menu;

public class Cadastro {
    private List<Cliente> clientes;
    private Connection con;

    // Construtor que inicia a lista e a conexao com BD
    
    public Cadastro() throws SQLException {
        this.con = conexaoBD.getConnection(); 
        this.clientes = new ArrayList<>(); 
    }

    // Cadastrar evento
    
    public void adicionarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO eventos (nome, tema, endereco, data_evento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTema());
            stmt.setString(3, cliente.getEndereco());
            stmt.setDate(4, new java.sql.Date(cliente.getDataEvento().getTime()));
            stmt.executeUpdate();
            System.out.println("\nEvento cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new SQLException("Erro ao adicionar cliente: " + e.getMessage());
        }
    }
    
  

    public String consultarEventos(String criterio, String valor) throws SQLException {
        StringBuilder resultado = new StringBuilder();
        String sql = "";
        
        switch (criterio.toLowerCase()) {
            case "nome":
                sql = "SELECT * FROM eventos WHERE nome LIKE ?";
                break;
            case "tema":
                sql = "SELECT * FROM eventos WHERE tema LIKE ?";
                break;
            case "endereco":
                sql = "SELECT * FROM eventos WHERE endereco LIKE ?";
                break;
            case "data":
                sql = "SELECT * FROM eventos WHERE data_evento = ?";
                break;
            default:
                System.out.println("Critério de consulta inválido.");
                return "Critério de consulta inválido.";
        }

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            if (criterio.equals("data")) {
                stmt.setDate(1, java.sql.Date.valueOf(valor));
            } else {
                stmt.setString(1, "%" + valor + "%");
            }

            var rs = stmt.executeQuery();
            if (!rs.isBeforeFirst()) { 
                return "Nenhum evento encontrado.";
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String tema = rs.getString("tema");
                    String endereco = rs.getString("endereco");
                    Date dataEvento = rs.getDate("data_evento");
                    String dataFormatada = sdf.format(dataEvento);
                    resultado.append("Cliente: ").append(nome)
                            .append(", Tema: ").append(tema)
                            .append(", Endereço: ").append(endereco)
                            .append(", Data do Evento: ").append(dataFormatada)
                            .append("\n");
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao consultar evento: " + e.getMessage());
        }
        return resultado.toString();
    }



    //consultar datas disponiveis 
    
    public void consultarDatasDisponiveis(int mes, int ano) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes - 1, 1);
        int diasNoMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        Set<String> datasOcupadas = new HashSet<>();

        String sql = "SELECT DATE_FORMAT(data_evento, '%d/%m/%Y') AS data_evento FROM eventos WHERE MONTH(data_evento) = ? AND YEAR(data_evento) = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, mes);
            stmt.setInt(2, ano);
            var rs = stmt.executeQuery();
            
            while (rs.next()) {
                String dataOcupada = rs.getString("data_evento");
                datasOcupadas.add(dataOcupada);
                System.out.println("Data ocupada: " + dataOcupada);  
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao consultar datas ocupadas: " + e.getMessage());
        }

        System.out.println("Datas disponíveis em " + mes + "/" + ano + ":");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int dia = 1; dia <= diasNoMes; dia++) {
            calendar.set(ano, mes - 1, dia);
            String dataAtual = sdf.format(calendar.getTime());

            if (!datasOcupadas.contains(dataAtual)) {
                System.out.println(dataAtual); 
            }
        }
        
    }

    //editar evento
    	
    public void editarEvento(int idSelecionado, String campo, String novoValor) throws SQLException {
        String sql = "UPDATE eventos SET " + campo + " = ? WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, novoValor);
            stmt.setInt(2, idSelecionado);
            stmt.executeUpdate();
            System.out.println("Evento atualizado com sucesso!");
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar evento: " + e.getMessage());
        }
    }

    public List<Evento> buscarEventos(String criterio, String valor) throws SQLException {
        List<Evento> eventos = new ArrayList<>();
        String sql = "";

        switch (criterio.toLowerCase()) {
            case "nome":
                sql = "SELECT id, nome, tema, endereco, data_evento FROM eventos WHERE nome LIKE ?";
                break;
            case "tema":
                sql = "SELECT id, nome, tema, endereco, data_evento FROM eventos WHERE tema LIKE ?";
                break;
            case "endereco":
                sql = "SELECT id, nome, tema, endereco, data_evento FROM eventos WHERE endereco LIKE ?";
                break;
            case "data":
                sql = "SELECT id, nome, tema, endereco, data_evento FROM eventos WHERE data_evento = ?";
                break;
            default:
                System.out.println("Critério de busca inválido.");
                return eventos; 
        }

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            if (criterio.equals("data")) {
                
                try {
                    stmt.setDate(1, Date.valueOf(valor)); 
                } catch (IllegalArgumentException e) {
                    System.out.println("Opção inválida: " + valor);
                    return eventos; 
                }
            } else {
                stmt.setString(1, "%" + valor + "%");
            }

            var rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String tema = rs.getString("tema");
                String endereco = rs.getString("endereco");
                String dataEvento = rs.getString("data_evento");
                eventos.add(new Evento(id, nome, tema, endereco, dataEvento));
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar eventos: " + e.getMessage());
        }

        return eventos;
    }
    
    private String formatarData(String dataOriginal) {
        String[] partes = dataOriginal.split("-");
        return partes[2] + "/" + partes[1] + "/" + partes[0];  
    }

}

