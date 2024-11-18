package Principal;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cadastro cadastro = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            cadastro = new Cadastro(); 
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            e.printStackTrace(); 
            scanner.close();
            return; 
        }

        while (true) {
            System.out.println("\n Bem-vindo ao Chronolink!\n");
            System.out.println("\n Digite a opção desejada:\n");
            System.out.println(" 1. Cadastrar evento");
            System.out.println(" 2. Consultar eventos agendados");
            System.out.println(" 3. Consultar datas disponíveis");
            System.out.println(" 4. Editar evento");
            System.out.println(" 5. Fechar o programa");
            int opcao = -1; 
          
            while (true) {   
                try {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); 
                    break; 
                } catch (InputMismatchException e) {
                    System.out.println("\n Digite apenas números para selecionar uma opção.");
                    scanner.nextLine(); 
                    System.out.print("\n Digite a opção desejada: "); 
                }
            }
            
            
            if (opcao == -1) {
                continue; 
            }
    

            switch (opcao) {
            case 1:
                System.out.print("Digite o nome do cliente: ");
                String nome = scanner.nextLine();

                System.out.print("Digite o tema do evento: ");
                String tema = scanner.nextLine();

                System.out.print("Digite o endereço do evento: ");
                String endereco = scanner.nextLine();

                Date dataEvento = null;
                boolean dataValida = false; 

                while (!dataValida) {
                    System.out.print("Digite a data do evento (dd/MM/yyyy): ");
                    String dataEventoStr = scanner.nextLine();

                    try {
                        dataEvento = sdf.parse(dataEventoStr);
                        dataValida = true; 
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido. Tente novamente.");
                    }
                }

                Cliente cliente = new Cliente(nome, tema, endereco, dataEvento);
                
                try {
                    cadastro.adicionarCliente(cliente);
                } catch (SQLException e) {
                    System.out.println("Erro ao cadastrar evento: " + e.getMessage());
                }

                System.out.print("\nDeseja retornar para o menu principal? (S/N) (Digite S para voltar ao menu principal, ou N para encerrar o programa): ");
                String resposta = scanner.nextLine().trim().toLowerCase();

                if (resposta.equals("n")) {
                    System.out.println("Programa encerrado.");
                    scanner.close();
                    return; 
                } else if (!resposta.equals("s")) {
                    System.out.println("Opção inválida.");
                }
                break;

                
                //CONSULTAR EVENTOS AGENDADAS
                    
            case 2:
                boolean sairDoMenu = false;

                while (!sairDoMenu) {
                    System.out.println("\nSelecione como deseja consultar:\n");
                    System.out.println("1. Por nome");
                    System.out.println("2. Por tema");
                    System.out.println("3. Por endereço");
                    System.out.println("4. Pela data do Evento");
                    System.out.println("5. Sair para o menu principal");

                    int criterioOpcao = -1;
                    boolean entradaValida = false;

                    while (!entradaValida) {
                        System.out.print("\nEscolha uma opção (1 à 5): ");
                        String entrada = scanner.nextLine();

                        try {
                            criterioOpcao = Integer.parseInt(entrada); 
                            if (criterioOpcao < 1 || criterioOpcao > 5) {
                                throw new NumberFormatException(); 
                            }
                            entradaValida = true; 
                        } catch (NumberFormatException e) {
                            System.out.println("\nOpção inválida, digite apenas números entre 1 e 5.");
                            System.out.print("\nDeseja tentar novamente ou sair para o menu principal? (S/N) (S para tentar novamente / N para sair para o menu principal): ");
                            String resp = scanner.nextLine().toUpperCase();
                            if (resp.equals("N")) {
                                sairDoMenu = true; 
                                entradaValida = true; 
                            }
                        }
                    }

                    if (criterioOpcao == 5) {
                        System.out.println("Voltando ao menu principal");
                        sairDoMenu = true; 
                        break; 
                    }

                    String criterio = "";
                    String valorBusca = ""; 

                    switch (criterioOpcao) {
                        case 1:
                            criterio = "nome";
                            System.out.print("Digite o nome do cliente: ");
                            valorBusca = scanner.nextLine();
                            break;
                        case 2:
                            criterio = "tema";
                            System.out.print("Digite o tema do evento: ");
                            valorBusca = scanner.nextLine();
                            break;
                        case 3:
                            criterio = "endereco";
                            System.out.print("Digite o endereço do evento: ");
                            valorBusca = scanner.nextLine();
                            break;
                        case 4:
                            criterio = "data";
                            boolean continuar = true;

                            while (continuar) {
                                System.out.print("Digite a data do evento (dd/MM/yyyy): ");
                                valorBusca = scanner.nextLine();

                                try {
                                    SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");

                                    Date dataFormatada = inputFormat.parse(valorBusca);
                                    valorBusca = dbFormat.format(dataFormatada);

                                    continuar = false; 

                                } catch (ParseException e) {
                                    System.out.println("Formato de data inválido.");
                                    System.out.print("Deseja tentar novamente? (S/N) (S para tentar novamente / N para voltar ao menu principal): ");
                                    String novaOpcao = scanner.nextLine().toUpperCase();

                                    if (novaOpcao.equals("N")) {
                                        sairDoMenu = true; 
                                        continuar = false;
                                    }
                                }
                            }
                            break;
                    }

                    if (!criterio.isEmpty() && !sairDoMenu) {
                        try {
                            cadastro.consultarEventos(criterio, valorBusca);
                        } catch (SQLException e) {
                            System.out.println("Erro ao consultar eventos: " + e.getMessage());
                        }

                        System.out.print("\nDeseja realizar uma nova consulta ou sair para o menu principal? (S/N) (S para nova consulta / N para sair para o menu principal): ");
                        String respostaFinal = scanner.nextLine().trim().toUpperCase();

                        if (respostaFinal.equals("N")) {
                            sairDoMenu = true;
                        } 
                    }
                }
                break;



                    
                    
               //CONSULTAR DATAS DISPONIVEIS
                    
                case 3:
                    boolean continuarConsulta = true;

                    while (continuarConsulta) {
                        try {
                            System.out.print("Digite o mês (1-12): ");
                            int mes = scanner.nextInt();
                            System.out.print("Digite o ano (2023-2030): ");
                            int ano = scanner.nextInt();
                            scanner.nextLine(); 

                            
                            if (mes < 1 || mes > 12) {
                                System.out.println("Entrada inválida. O mês deve ser escrito entre 1 e 12.");
                                throw new IllegalArgumentException("Mês inválido");
                            }
                            
                            if (ano < 2023 || ano > 2030) {
                                System.out.println("Ano inválido. O ano deve estar entre 2023 e 2030.");
                                throw new IllegalArgumentException("Ano inválido");
                            }
                            
                            cadastro.consultarDatasDisponiveis(mes, ano);
                            continuarConsulta = false; 

                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida.");
                            scanner.nextLine(); 
                            System.out.print("Deseja tentar novamente? (S/N) (Digite S para tentar novamente/ N para voltar ao menu principal): ");
                            String responder = scanner.nextLine().trim().toUpperCase();
                            if (responder.equals("N")) {
                                System.out.println("Voltando ao menu principal...");
                                continuarConsulta = false; 
                            }
                        } catch (IllegalArgumentException e) {
                        	 System.out.print("Deseja tentar novamente? (S/N) (Digite S para tentar novamente/ N para voltar ao menu principal): ");
                            String responder = scanner.nextLine().trim().toUpperCase();
                            if (responder.equals("N")) {
                                System.out.println("Voltando ao menu principal...");
                                continuarConsulta = false; 
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao consultar datas disponíveis: " + e.getMessage());
                            continuarConsulta = false; 
                        }
                    }
                    
                    break;


                    
               // EDITAR EVENTOS AGENDADOS

                 
                case 4:
                    boolean tentarNovamente = true;

                    while (tentarNovamente) {
                        System.out.print("Digite o nome, tema, data ou endereço do evento que deseja editar: ");
                        String valorBuscaEdicao = scanner.nextLine();

                        List<Evento> eventosEncontrados = null;
                        try {
                            eventosEncontrados = cadastro.buscarEventos("nome", valorBuscaEdicao);
                            if (eventosEncontrados.isEmpty()) {
                                eventosEncontrados = cadastro.buscarEventos("tema", valorBuscaEdicao);
                            }
                            if (eventosEncontrados.isEmpty()) {
                                eventosEncontrados = cadastro.buscarEventos("endereco", valorBuscaEdicao);
                            }
                            if (eventosEncontrados.isEmpty()) {
                                eventosEncontrados = cadastro.buscarEventos("data", valorBuscaEdicao);
                            }
                        } catch (SQLException e) {
                            System.out.println("Erro ao buscar eventos: " + e.getMessage());
                            continue; 
                        }

                        if (eventosEncontrados.isEmpty()) {
                            System.out.println(" Nenhum evento encontrado.");
                            System.out.print("\n Deseja tentar novamente ou sair para o menu principal? (S/N) (Digite S para tentar novamente / N para sair para o menu principal): ");
                            String resp = scanner.nextLine().trim().toLowerCase();

                            if (resp.equals("n")) {
                                System.out.println("\n Voltando ao menu principal.");
                                tentarNovamente = false; 
                            }
                        } else {
                            System.out.println("\nEventos encontrados:\n");
                            for (Evento evento : eventosEncontrados) {
                                System.out.println("\nID: " + evento.getId() + ", Nome: " + evento.getNome() +
                                                   ", Tema: " + evento.getTema() + ", Endereço: " + evento.getEndereco() +
                                                   ", Data: " + evento.getData());
                            }

                            boolean idValido = false;
                            int idSelecionado = -1;

                            while (!idValido) {
                                try {
                                    System.out.print("\nSelecione a ID correspondente que deseja editar:\n ");
                                    idSelecionado = scanner.nextInt();
                                    scanner.nextLine(); 
                                    idValido = true; 
                                } catch (InputMismatchException e) {
                                    System.out.println("\n Opção inválida. Digite somente o número correspondente a ID desejada.");
                                    scanner.nextLine(); 
                                    System.out.print("\n Deseja tentar novamente ou sair para o menu principal? (S/N) (Digite S para tentar novamente / N para sair para o menu principal): ");
                                    String tentarNovamenteInput = scanner.nextLine().trim().toLowerCase();
                                    if (tentarNovamenteInput.equals("n")) {
                                        tentarNovamente = false; 
                                        break; 
                                    }
                                }
                            }

                            if (idValido) {
                               
                                String[] camposValidos = {"nome", "tema", "endereco", "data_evento"}; 
                                boolean campoValido = false;
                                String campo = "";

                                while (!campoValido) {
                                    System.out.print(" O que você deseja alterar? (nome, tema, endereco, data): ");
                                    campo = scanner.nextLine().toLowerCase();

                                    
                                    if (campo.equals("data")) {
                                        campo = "data_evento";
                                    }

                                    for (String campoPermitido : camposValidos) {
                                        if (campo.equals(campoPermitido)) {
                                            campoValido = true;
                                            break;
                                        }
                                    }

                                    if (!campoValido) {
                                        System.out.println(" Resposta inválida. Digite corretamente a escolha desejada (nome, tema, endereco, ou data).");
                                        System.out.print("\n Deseja tentar novamente ou sair para o menu principal? (S/N) (Digite S para tentar novamente / N para sair para o menu principal): ");
                                        String tentarNovamenteInput = scanner.nextLine().trim().toLowerCase();
                                        if (tentarNovamenteInput.equals("n")) {
                                            tentarNovamente = false; 
                                            break; 
                                        }
                                    }
                                }

                                if (campoValido) {
                                    System.out.print("Digite o novo valor para " + campo + ": ");
                                    String novoValor = scanner.nextLine();

                                    
                                    if (campo.equals("data_evento")) {
                                        try {
                                           
                                            LocalDate dataConvertida = LocalDate.parse(novoValor, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                            novoValor = dataConvertida.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
                                        } catch (DateTimeParseException e) {
                                            System.out.println("Formato de data inválido. Use DD/MM/YYYY.");
                                            continue; 
                                        }
                                    }

                                    try {
                                        cadastro.editarEvento(idSelecionado, campo, novoValor);
                                    } catch (SQLException e) {
                                        System.out.println("Erro ao editar evento: " + e.getMessage());
                                    }

                                    
                                    System.out.print("\n Deseja sair para o menu principal ou encerrar o programa? (S/N) (Digite S para sair para o menu principal / Digite N para encerrar o programa): ");
                                    String respost = scanner.nextLine().trim().toLowerCase();

                                    if (respost.equals("n")) {
                                        System.out.println("Programa encerrado.");
                                        scanner.close();
                                        return;
                                    } else if (!respost.equals("s")) {
                                        System.out.println("\n Opção inválida. Voltando ao menu principal.");
                                    }
                                    tentarNovamente = false; 
                                }
                            }
                        }
                    }
                    break;

               // SAIR DO SISTEMA / FECHAR
                    
                case 5:
                    System.out.println("Programa encerrado.");
                    scanner.close();
                    return; 

                default:
                    System.out.println("Opção inválida. Tente novamente escolhendo una opção de 1 à 5");
            }
        }
    }
}