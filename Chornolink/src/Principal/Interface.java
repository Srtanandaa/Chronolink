package Principal;

import java.awt.*;
import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class Interface extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Cadastro cadastro;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Interface frame = new Interface();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Interface() {
        try {
            cadastro = new Cadastro(); // Inicializa a instância do Cadastro
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 310);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBackground(new Color(137, 207, 240)); // Azul #89CFF0

        // Título
        GridBagConstraints gbcTitle = new GridBagConstraints();
        gbcTitle.insets = new Insets(10, 10, 10, 10);
        gbcTitle.gridx = 0;
        gbcTitle.gridy = 0;
        JLabel lblBemVindo = new JLabel("Bem-vindo ao ChronoLink");
        lblBemVindo.setFont(lblBemVindo.getFont().deriveFont(23f)); // Aumenta a fonte do título
        contentPane.add(lblBemVindo, gbcTitle);

        // Subtítulo
        GridBagConstraints gbcSubtitle = new GridBagConstraints();
        gbcSubtitle.insets = new Insets(5, 10, 20, 10); // Aumenta o espaçamento
        gbcSubtitle.gridx = 0;
        gbcSubtitle.gridy = 1;
        JLabel lblSelecionarOpcao = new JLabel("Selecione a opção desejada:");
        lblSelecionarOpcao.setFont(lblSelecionarOpcao.getFont().deriveFont(18f)); // Aumenta a fonte do subtítulo
        contentPane.add(lblSelecionarOpcao, gbcSubtitle);

        // Botão Cadastrar Evento
        GridBagConstraints gbcButton1 = new GridBagConstraints();
        gbcButton1.fill = GridBagConstraints.HORIZONTAL; // Faz o botão ocupar toda a largura
        gbcButton1.insets = new Insets(5, 10, 5, 10); // Espaçamento entre os botões
        gbcButton1.gridx = 0; // coluna
        gbcButton1.gridy = 2; // linha
        JButton btnCadastrar = new JButton("Cadastrar Evento");
        btnCadastrar.setFont(btnCadastrar.getFont().deriveFont(15f)); // Define a fonte do botão
        btnCadastrar.addActionListener(e -> mostrarCadastro()); // Chama o método para mostrar o painel de cadastro
        contentPane.add(btnCadastrar, gbcButton1);

        // Botão Consultar Eventos Agendados
        GridBagConstraints gbcButton2 = new GridBagConstraints();
        gbcButton2.fill = GridBagConstraints.HORIZONTAL;
        gbcButton2.insets = new Insets(5, 10, 5, 10);
        gbcButton2.gridx = 0;
        gbcButton2.gridy = 3;
        JButton btnConsultarEventos = new JButton("Consultar Eventos Agendados");
        btnConsultarEventos.setFont(btnConsultarEventos.getFont().deriveFont(15f));
        btnConsultarEventos.addActionListener(e -> mostrarConsultaEventos()); // Adiciona ação para consulta de eventos
        contentPane.add(btnConsultarEventos, gbcButton2);

        // Botão Consultar Datas Disponíveis
        GridBagConstraints gbcButton3 = new GridBagConstraints();
        gbcButton3.fill = GridBagConstraints.HORIZONTAL;
        gbcButton3.insets = new Insets(5, 10, 5, 10);
        gbcButton3.gridx = 0;
        gbcButton3.gridy = 4;
        JButton btnConsultarDatas = new JButton("Consultar Datas Disponíveis");
        btnConsultarDatas.setFont(btnConsultarDatas.getFont().deriveFont(15f));
        btnConsultarDatas.addActionListener(e -> mostrarConsultaDatas()); // Adiciona ação para consultar datas
        contentPane.add(btnConsultarDatas, gbcButton3);

        // Botão Editar Evento
        GridBagConstraints gbcButton4 = new GridBagConstraints();
        gbcButton4.fill = GridBagConstraints.HORIZONTAL;
        gbcButton4.insets = new Insets(5, 10, 5, 10);
        gbcButton4.gridx = 0;
        gbcButton4.gridy = 5;
        JButton btnEditarEvento = new JButton("Editar Evento");
        btnEditarEvento.setFont(btnEditarEvento.getFont().deriveFont(15f));
        btnEditarEvento.addActionListener(e -> System.out.println("Editar Evento clicado"));
        contentPane.add(btnEditarEvento, gbcButton4);

        // Botão Fechar Programa
        GridBagConstraints gbcButton5 = new GridBagConstraints();
        gbcButton5.fill = GridBagConstraints.HORIZONTAL;
        gbcButton5.insets = new Insets(5, 10, 5, 10);
        gbcButton5.gridx = 0;
        gbcButton5.gridy = 6;
        JButton btnFechar = new JButton("Fechar o Programa");
        btnFechar.setFont(btnFechar.getFont().deriveFont(15f));
        btnFechar.addActionListener(e -> System.exit(0));
        contentPane.add(btnFechar, gbcButton5);
    }

    private void mostrarCadastro() {
        // Remove o conteúdo atual
        contentPane.removeAll();
        
        // Adiciona o painel de cadastro
        CadastroEventoPanel cadastroPanel = new CadastroEventoPanel(this);
        contentPane.setLayout(new BorderLayout()); // Layout para o novo painel
        contentPane.add(cadastroPanel, BorderLayout.CENTER);
        
        // Atualiza a interface
        contentPane.revalidate();
        contentPane.repaint();
    }

    private void mostrarConsultaEventos() {
        // Remove o conteúdo atual
        contentPane.removeAll();
        
        // Adiciona o painel de consulta de eventos
        ConsultaEventosPanel consultaPanel = new ConsultaEventosPanel(this);
        contentPane.setLayout(new BorderLayout()); // Layout para o novo painel
        contentPane.add(consultaPanel, BorderLayout.CENTER);
        
        // Atualiza a interface
        contentPane.revalidate();
        contentPane.repaint();
    }

    private void mostrarConsultaDatas() {
        // Remove o conteúdo atual
        contentPane.removeAll();

        // Adiciona o painel de consulta de datas disponíveis
        ConsultaDatasPanel consultaDatasPanel = new ConsultaDatasPanel(this);
        contentPane.setLayout(new BorderLayout()); // Layout para o novo painel
        contentPane.add(consultaDatasPanel, BorderLayout.CENTER);
        
        // Atualiza a interface
        contentPane.revalidate();
        contentPane.repaint();
    }

    private class CadastroEventoPanel extends JPanel {
        
        private JTextField txtNome;
        private JTextField txtTema;
        private JTextField txtEndereco;
        private JTextField txtDataEvento;
        private JButton btnCadastrar;
        private JButton btnVoltar;
        
        public CadastroEventoPanel(JFrame parentFrame) {
            setLayout(new GridBagLayout());
            setBackground(new Color(137, 207, 240));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            
            // Título
            GridBagConstraints gbcTitle = new GridBagConstraints();
            gbcTitle.insets = new Insets(10, 10, 10, 10);
            gbcTitle.gridx = 0;
            gbcTitle.gridy = 0;
            JLabel lblTitulo = new JLabel("Cadastrar Evento");
            lblTitulo.setFont(lblTitulo.getFont().deriveFont(23f)); 
            gbcTitle.gridwidth = 2; 
            add(lblTitulo, gbcTitle);
            
            // Campos de entrada
            gbc.gridwidth = 1;
            gbc.gridx = 0; gbc.gridy = 1;
            JLabel lblNome = new JLabel("Nome do Cliente:");
            lblNome.setFont(lblNome.getFont().deriveFont(18f)); 
            add(lblNome, gbc);
            txtNome = new JTextField(20);
            gbc.gridx = 1; gbc.gridy = 1;
            add(txtNome, gbc);

            gbc.gridx = 0; gbc.gridy = 2;
            JLabel lblTema = new JLabel("Tema do Evento:");
            lblTema.setFont(lblTema.getFont().deriveFont(18f)); 
            add(lblTema, gbc);
            txtTema = new JTextField(20);
            gbc.gridx = 1; gbc.gridy = 2;
            add(txtTema, gbc);

            gbc.gridx = 0; gbc.gridy = 3;
            JLabel lblEndereco = new JLabel("Endereço do Evento:");
            lblEndereco.setFont(lblEndereco.getFont().deriveFont(18f)); 
            add(lblEndereco, gbc);
            txtEndereco = new JTextField(20);
            gbc.gridx = 1; gbc.gridy = 3;
            add(txtEndereco, gbc);

            gbc.gridx = 0; gbc.gridy = 4;
            JLabel lblDataEvento = new JLabel("Data do Evento:");
            lblDataEvento.setFont(lblDataEvento.getFont().deriveFont(18f)); 
            add(lblDataEvento, gbc);
            txtDataEvento = new JTextField(20);
            gbc.gridx = 1; gbc.gridy = 4;
            add(txtDataEvento, gbc);

            // Botão Cadastrar
            btnCadastrar = new JButton("Cadastrar");
            btnCadastrar.addActionListener(e -> cadastrarEvento());
            gbc.gridx = 0; gbc.gridy = 5;
            gbc.gridwidth = 2;
            add(btnCadastrar, gbc);

            // Botão Voltar
            btnVoltar = new JButton("Voltar ao Menu Principal");
            btnVoltar.addActionListener(e -> voltarMenu(parentFrame));
            gbc.gridy = 6;
            add(btnVoltar, gbc);
        }

        private void cadastrarEvento() {
            String nome = txtNome.getText();
            String tema = txtTema.getText();
            String endereco = txtEndereco.getText();
            String dataEvento = txtDataEvento.getText();
            
            JOptionPane.showMessageDialog(this, "Evento cadastrado com sucesso!");
        }

        private void voltarMenu(JFrame parentFrame) {
            parentFrame.setContentPane(new Interface().contentPane);
            parentFrame.revalidate();
            parentFrame.repaint();
        }
    }

    private class ConsultaEventosPanel extends JPanel {
        
        private JComboBox<String> cbConsulta;
        private JTextField txtBusca;
        private JButton btnBuscar;
        private JTextArea taResultados;
        private JButton btnVoltar;
        
        public ConsultaEventosPanel(JFrame parentFrame) {
            setLayout(new GridBagLayout());
            setBackground(new Color(137, 207, 240));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            
            // Título
            GridBagConstraints gbcTitle = new GridBagConstraints();
            gbcTitle.insets = new Insets(10, 10, 10, 10);
            gbcTitle.gridx = 0;
            gbcTitle.gridy = 0;
            JLabel lblTitulo = new JLabel("Consultar Eventos Agendados");
            lblTitulo.setFont(lblTitulo.getFont().deriveFont(23f)); 
            gbcTitle.gridwidth = 2; 
            add(lblTitulo, gbcTitle);
            
            // ComboBox para selecionar o tipo de consulta
            gbc.gridwidth = 1;
            gbc.gridx = 0; gbc.gridy = 1;
            JLabel lblTipoConsulta = new JLabel("Selecione o tipo de consulta:");
            lblTipoConsulta.setFont(lblTipoConsulta.getFont().deriveFont(18f)); 
            add(lblTipoConsulta, gbc);

            String[] opcoes = {"Por Nome", "Por Tema", "Por Endereço", "Por Data"};
            cbConsulta = new JComboBox<>(opcoes);
            gbc.gridx = 1; gbc.gridy = 1;
            add(cbConsulta, gbc);

            // Campo de texto para busca
            gbc.gridx = 0; gbc.gridy = 2;
            JLabel lblBusca = new JLabel("Digite o valor:");
            lblBusca.setFont(lblBusca.getFont().deriveFont(18f)); 
            add(lblBusca, gbc);
            txtBusca = new JTextField(15);
            gbc.gridx = 1; gbc.gridy = 2;
            add(txtBusca, gbc);
            
            // Botão Buscar
            gbc.gridx = 0; gbc.gridy = 3;
            btnBuscar = new JButton("Buscar");
            btnBuscar.addActionListener(e -> buscarEventos());
            add(btnBuscar, gbc);

            // Área de resultados
            taResultados = new JTextArea(10, 30);
            taResultados.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(taResultados);
            gbc.gridx = 0; gbc.gridy = 4;
            gbc.gridwidth = 2;
            add(scrollPane, gbc);

            // Botão Voltar
            gbc.gridwidth = 1;
            gbc.gridx = 0; gbc.gridy = 5;
            btnVoltar = new JButton("Voltar ao Menu");
            btnVoltar.addActionListener(e -> voltarMenu(parentFrame));
            add(btnVoltar, gbc);
        }

        private void buscarEventos() {
            String tipoConsulta = (String) cbConsulta.getSelectedItem();
            String valorBusca = txtBusca.getText();

            
            StringBuilder resultados = new StringBuilder();
            resultados.append("Resultados da consulta para: ").append(tipoConsulta).append(" - ").append(valorBusca).append("\n");
            
            taResultados.setText(resultados.toString());
        }

        private void voltarMenu(JFrame parentFrame) {
            
            parentFrame.setContentPane(new Interface().contentPane);
            parentFrame.revalidate();
            parentFrame.repaint();
        }
    }

    private class ConsultaDatasPanel extends JPanel {
        private JTextField txtMes;
        private JTextField txtAno;
        private JButton btnConsultar;
        private JButton btnVoltar;

        public ConsultaDatasPanel(JFrame parentFrame) {
            setLayout(new GridBagLayout());
            setBackground(new Color(137, 207, 240));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            
            // Título
            JLabel lblTitulo = new JLabel("Consultar Datas Disponíveis");
            lblTitulo.setFont(lblTitulo.getFont().deriveFont(23f)); 
            gbc.gridwidth = 2; 
            add(lblTitulo, gbc);

            // Campos para mês e ano
            gbc.gridwidth = 1;
            gbc.gridx = 0; gbc.gridy = 1;
            add(new JLabel("Mês (1-12):"), gbc);
            txtMes = new JTextField(10);
            gbc.gridx = 1; 
            add(txtMes, gbc);

            gbc.gridx = 0; gbc.gridy = 2;
            add(new JLabel("Ano (2023-2030):"), gbc);
            txtAno = new JTextField(10);
            gbc.gridx = 1; 
            add(txtAno, gbc);

            // Botão Consultar
            btnConsultar = new JButton("Consultar");
            btnConsultar.addActionListener(e -> consultarDatas());
            gbc.gridwidth = 2;
            gbc.gridx = 0; 
            gbc.gridy = 3; 
            add(btnConsultar, gbc);

            // Botão Voltar
            btnVoltar = new JButton("Voltar ao Menu Principal");
            btnVoltar.addActionListener(e -> voltarMenu(parentFrame));
            gbc.gridy = 4; 
            add(btnVoltar, gbc);
        }

        private void consultarDatas() {
            try {
                int mes = Integer.parseInt(txtMes.getText());
                int ano = Integer.parseInt(txtAno.getText());

                if (mes < 1 || mes > 12) {
                    JOptionPane.showMessageDialog(this, "Entrada inválida. O mês deve ser entre 1 e 12.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (ano < 2023 || ano > 2030) {
                    JOptionPane.showMessageDialog(this, "Ano inválido. O ano deve estar entre 2023 e 2030.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                
                cadastro.consultarDatasDisponiveis(mes, ano);
                JOptionPane.showMessageDialog(this, "Consulta realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Por favor, insira números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao consultar datas disponíveis: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void voltarMenu(JFrame parentFrame) {
            parentFrame.setContentPane(new Interface().contentPane);
            parentFrame.revalidate();
            parentFrame.repaint();
        }
    }
}
