package Visualização;

import java.awt.EventQueue;
import javax.swing.text.MaskFormatter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.text.ParseException;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import Principal.Cliente;
import Principal.Evento;
import Principal.Cadastro;
import java.sql.*; 
import java.util.*; 
import Principal.conexaoBD;


public class menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_5;
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menu frame = new menu();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public menu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 855, 723);
        
        cardLayout = new CardLayout();
        contentPane = new JPanel(cardLayout);
        contentPane.setBackground(new Color(0, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        
        
        JPanel menu = new JPanel();
        menu.setBackground(new Color(0, 128, 255));
        menu.setLayout(null);
        contentPane.add(menu, "Menu");

        JLabel lblNewLabel = new JLabel("Bem vindo ao Chronolink");
        lblNewLabel.setBounds(240, 79, 351, 24);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 23));
        menu.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Selecione a opção desejada:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial", Font.ITALIC, 20));
        lblNewLabel_1.setBounds(284, 143, 262, 24);
        menu.add(lblNewLabel_1);

        JButton btnConsultarEventosAgendados = new JButton("Consultar eventos agendados");
        btnConsultarEventosAgendados.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(contentPane, "ConsultarEventosAgendados");
            }
        });
        
        btnConsultarEventosAgendados.setFont(new Font("Verdana", Font.BOLD, 17));
        btnConsultarEventosAgendados.setBackground(new Color(230, 230, 230));
        btnConsultarEventosAgendados.setBounds(247, 287, 336, 31);
        menu.add(btnConsultarEventosAgendados);

        JButton btnConsultarDatasDisponiveis = new JButton("Consultar datas disponíveis");
        btnConsultarDatasDisponiveis.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 cardLayout.show(contentPane, "ConsultarDatasDisponiveis");
        	}
        });
        btnConsultarDatasDisponiveis.setFont(new Font("Verdana", Font.BOLD, 17));
        btnConsultarDatasDisponiveis.setBackground(new Color(230, 230, 230));
        btnConsultarDatasDisponiveis.setBounds(247, 345, 336, 31);
        menu.add(btnConsultarDatasDisponiveis);

        JButton btnEditar = new JButton("Editar evento");
        btnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 cardLayout.show(contentPane, "Editar");
        	}
        });
        btnEditar.setFont(new Font("Verdana", Font.BOLD, 17));
        btnEditar.setBackground(new Color(230, 230, 230));
        btnEditar.setBounds(247, 399, 336, 31);
        menu.add(btnEditar);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 System.exit(0);
        	}
        });
        btnSair.setFont(new Font("Verdana", Font.BOLD, 17));
        btnSair.setBackground(new Color(230, 230, 230));
        btnSair.setBounds(247, 450, 336, 31);
        menu.add(btnSair);

        JButton btnCadastrarEvento = new JButton("Cadastrar evento");
        btnCadastrarEvento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "CadastrarEvento"); 
            }
        });
        btnCadastrarEvento.setFont(new Font("Verdana", Font.BOLD, 17));
        btnCadastrarEvento.setBackground(new Color(230, 230, 230));
        btnCadastrarEvento.setBounds(247, 233, 336, 31);
        menu.add(btnCadastrarEvento);
        
        JPanel panel = new JPanel();
        panel.setBounds(197, 50, 438, 537);
        menu.add(panel);

        JPanel cadastrar = new JPanel();
        cadastrar.setBackground(new Color(0, 128, 255));
        cadastrar.setLayout(null);
        contentPane.add(cadastrar, "CadastrarEvento");

        JLabel lblCadastro = new JLabel("Cadastrar novo evento");
        lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastro.setFont(new Font("Verdana", Font.BOLD, 23));
        lblCadastro.setBounds(257, 47, 316, 74);
        cadastrar.add(lblCadastro);

       
        JButton btnVoltar = new JButton("Sair para o menu");
        btnVoltar.setBackground(new Color(230, 230, 230));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Menu"); 
            }
        });
        btnVoltar.setFont(new Font("Verdana", Font.BOLD, 17));
        btnVoltar.setBounds(426, 496, 336, 31);
        cadastrar.add(btnVoltar);
        
        JLabel lblNewLabel_2 = new JLabel("Nome do cliente");
        lblNewLabel_2.setFont(new Font("Verdana", Font.ITALIC, 18));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(107, 169, 199, 38);
        cadastrar.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Tema do evento");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Verdana", Font.ITALIC, 18));
        lblNewLabel_2_1.setBounds(107, 229, 199, 38);
        cadastrar.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Endereço do evento");
        lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.ITALIC, 18));
        lblNewLabel_2_1_1.setBounds(107, 289, 199, 38);
        cadastrar.add(lblNewLabel_2_1_1);
        
        JLabel lblNewLabel_2_1_1_1 = new JLabel("Data do evento");
        lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.ITALIC, 18));
        lblNewLabel_2_1_1_1.setBounds(107, 348, 199, 38);
        cadastrar.add(lblNewLabel_2_1_1_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Verdana", Font.PLAIN, 15));
        textField.setBounds(318, 176, 316, 33);
        cadastrar.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Verdana", Font.PLAIN, 15));
        textField_1.setColumns(10);
        textField_1.setBounds(318, 229, 316, 33);
        cadastrar.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Verdana", Font.PLAIN, 15));
        textField_2.setColumns(10);
        textField_2.setBounds(318, 289, 316, 33);
        cadastrar.add(textField_2);
        
        JFormattedTextField formattedDateField = new JFormattedTextField();
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');  
            formattedDateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(dateMask));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        formattedDateField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        formattedDateField.setColumns(10);
        formattedDateField.setBounds(318, 348, 316, 33);
        cadastrar.add(formattedDateField);

        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if (textField.getText().isEmpty() || textField_1.getText().isEmpty() || 
                    textField_2.getText().isEmpty() || formattedDateField.getText().equals("__/__/____")) {
                    JOptionPane.showMessageDialog(cadastrar, "Preencha todos os campos para cadastrar");
                } else {
                    
                    String nome = textField.getText();
                    String tema = textField_1.getText();
                    String endereco = textField_2.getText();
                    String dataStr = formattedDateField.getText();
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataEvento = null;
                    try {
                        dataEvento = sdf.parse(dataStr);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(cadastrar, "Erro, o formato da data deve ser dd/MM/yyyy");
                        return;
                    }

                    Cliente cliente = new Cliente(nome, tema, endereco, dataEvento);
                       
                    Cadastro cadastro = null;
                    try {
                        cadastro = new Cadastro();  
                        cadastro.adicionarCliente(cliente);  
                        
                        JOptionPane.showMessageDialog(cadastrar, "Cadastro realizado com sucesso!");
                        
                        textField.setText(""); 
                        textField_1.setText(""); 
                        textField_2.setText("");
                        formattedDateField.setText("");
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(cadastrar, "Erro ao cadastrar evento no banco de dados.");
                    }
                }
            }
        });

        
        btnNewButton.setBackground(new Color(230, 230, 230));
        btnNewButton.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNewButton.setBounds(64, 496, 336, 31);
        cadastrar.add(btnNewButton);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 28, 811, 585);
        cadastrar.add(panel_1);
        
     
        JPanel consultarEventosAgendados = new JPanel();
        consultarEventosAgendados.setBackground(new Color(0, 128, 255));
        consultarEventosAgendados.setLayout(null);
        contentPane.add(consultarEventosAgendados, "ConsultarEventosAgendados");

        JLabel lblConsultarEventosAgendados = new JLabel("Consultar eventos agendados");
        lblConsultarEventosAgendados.setHorizontalAlignment(SwingConstants.CENTER);
        lblConsultarEventosAgendados.setFont(new Font("Verdana", Font.BOLD, 23));
        lblConsultarEventosAgendados.setBounds(194, 10, 443, 74);
        consultarEventosAgendados.add(lblConsultarEventosAgendados);

        JButton btnVoltarConsultarEventos = new JButton("Sair para o menu");
        btnVoltarConsultarEventos.setBackground(new Color(230, 230, 230));
        btnVoltarConsultarEventos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Menu");
            }
        });
        btnVoltarConsultarEventos.setFont(new Font("Verdana", Font.BOLD, 17));
        btnVoltarConsultarEventos.setBounds(247, 621, 336, 31);
        consultarEventosAgendados.add(btnVoltarConsultarEventos);
        
        JTextArea textAreaResultados_2 = new JTextArea();
        textAreaResultados_2.setFont(new Font("Verdana", Font.BOLD, 14));
        textAreaResultados_2.setEditable(false);
        textAreaResultados_2.setBackground(new Color(219, 219, 219));
        textAreaResultados_2.setBounds(10, 315, 811, 271);
        consultarEventosAgendados.add(textAreaResultados_2);
        
        JScrollPane scrollPaneResultados = new JScrollPane(textAreaResultados_2);

     
     scrollPaneResultados.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
     scrollPaneResultados.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

     
     scrollPaneResultados.setBounds(10, 315, 811, 271);

    
     consultarEventosAgendados.add(scrollPaneResultados);

        JButton btnNome = new JButton("Por nome");
        btnNome.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome.setBounds(34, 141, 333, 31);
        btnNome.addActionListener(new ActionListener() {
           
            	public void actionPerformed(ActionEvent e) {
                    String nome = JOptionPane.showInputDialog(consultarEventosAgendados, "Digite o nome do cliente:");

                    if (nome != null && !nome.isEmpty()) {
                        Cadastro cadastro = null;
                        try {
                            cadastro = new Cadastro();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            
                            String resultado = cadastro.consultarEventos("nome", nome);

                            if (resultado.isEmpty()) {
                                JOptionPane.showMessageDialog(consultarEventosAgendados, "Nenhum evento encontrado para o nome: " + nome);
                            } else {
                                textAreaResultados_2.setText(resultado);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(consultarEventosAgendados, "A consulta pelo nome não pode ser vazia.");
                    }
                }
            });

        consultarEventosAgendados.add(btnNome);

        JButton btnTema = new JButton("Por tema");
        btnTema.setFont(new Font("Verdana", Font.BOLD, 17));
        btnTema.setBounds(423, 141, 333, 31);
        btnTema.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String tema = JOptionPane.showInputDialog(consultarEventosAgendados, "Digite o tema do evento:");

                if (tema != null && !tema.isEmpty()) {
                    Cadastro cadastro = null;
                    try {
                        cadastro = new Cadastro();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        
                        String resultado = cadastro.consultarEventos("tema", tema);
                        
                        if (resultado.isEmpty()) {
                            JOptionPane.showMessageDialog(consultarEventosAgendados, "Nenhum evento encontrado para o tema: " + tema);
                        } else {
                            textAreaResultados_2.setText(resultado);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(consultarEventosAgendados, "A consulta não pode ser vazia.");
                }
            }
        });
        consultarEventosAgendados.add(btnTema);

        JButton btnEndereco = new JButton("Pelo endereço");
        btnEndereco.setFont(new Font("Verdana", Font.BOLD, 17));
        btnEndereco.setBounds(34, 197, 333, 31);
        btnEndereco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String endereco = JOptionPane.showInputDialog(consultarEventosAgendados, "Digite o endereço do evento:");

                if (endereco != null && !endereco.isEmpty()) {
                    Cadastro cadastro = null;
                    try {
                        cadastro = new Cadastro();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        
                        String resultado = cadastro.consultarEventos("endereco", endereco);
                       
                        if (resultado.isEmpty()) {
                            JOptionPane.showMessageDialog(consultarEventosAgendados, "Nenhum evento encontrado para o endereço: " + endereco);
                        } else {
                            textAreaResultados_2.setText(resultado);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(consultarEventosAgendados, "A consulta não pode ser vazia.");
                }
            }
        });
        consultarEventosAgendados.add(btnEndereco);

        JButton btnData = new JButton("Pela data");
        btnData.setFont(new Font("Verdana", Font.BOLD, 17));
        btnData.setBounds(423, 197, 333, 31);
        btnData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	  JFormattedTextField dataField;
                  try {
                     
                      MaskFormatter dateMask = new MaskFormatter("##/##/####");
                      dateMask.setPlaceholderCharacter('_');
                      dataField = new JFormattedTextField(dateMask);
                      dataField.setFont(new Font("Verdana", Font.PLAIN, 15));
                      
                      int option = JOptionPane.showConfirmDialog(
                          consultarEventosAgendados,
                          dataField,
                          "Digite a data do evento",
                          JOptionPane.OK_CANCEL_OPTION,
                          JOptionPane.PLAIN_MESSAGE
                      );
                      
                      if (option == JOptionPane.OK_OPTION) {
                          String data = dataField.getText();
                          
                          if (data.length() == 10 && !data.equals("____/__/____")) {
                              try {
                            	  
                                  String[] partes = data.split("/");
                                  String dataFormatada = partes[2] + "-" + partes[1] + "-" + partes[0];
                                  
                                  Cadastro cadastro = new Cadastro();
                                  String resultado = cadastro.consultarEventos("data", dataFormatada);
                                  
                                  if (resultado.isEmpty()) {
                                      JOptionPane.showMessageDialog(consultarEventosAgendados, "Nenhum evento encontrado para a data: " + data);
                                  } else {
                                      textAreaResultados_2.setText(resultado);
                                  }
                              } catch (SQLException ex) {
                                  JOptionPane.showMessageDialog(consultarEventosAgendados, "Erro ao consultar o banco de dados: " + ex.getMessage());
                                  ex.printStackTrace();
                              } catch (IllegalArgumentException ex) {
                                  JOptionPane.showMessageDialog(consultarEventosAgendados, "Data inválida.");
                              }
                          } else {
                              JOptionPane.showMessageDialog(consultarEventosAgendados, "Data inválida. O formato deve ser dd/mm/yyyy.");
                          }
                      }
                  } catch (ParseException ex) {
                      JOptionPane.showMessageDialog(consultarEventosAgendados, "Erro ao processar a data. Tente novamente.");
                      ex.printStackTrace();
                  }
              }
          });
        consultarEventosAgendados.add(btnData);


        JLabel lblNewLabel_3 = new JLabel("Selecione como deseja consultar:");
        lblNewLabel_3.setFont(new Font("Verdana", Font.ITALIC, 18));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(247, 80, 336, 46);
        consultarEventosAgendados.add(lblNewLabel_3);
        
        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setFont(new Font("Verdana", Font.BOLD, 20));
        lblResultado.setBounds(34, 248, 169, 50);
        consultarEventosAgendados.add(lblResultado);
        
        
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 10, 831, 656);
        consultarEventosAgendados.add(panel_2);

        JPanel consultarDatasDisponiveis = new JPanel();
        consultarDatasDisponiveis.setBackground(new Color(0, 128, 255));
        consultarDatasDisponiveis.setLayout(null);
        contentPane.add(consultarDatasDisponiveis, "ConsultarDatasDisponiveis");

        JLabel lblConsultarDatasDisponiveis = new JLabel("Consultar datas disponíveis");
        lblConsultarDatasDisponiveis.setHorizontalAlignment(SwingConstants.CENTER);
        lblConsultarDatasDisponiveis.setFont(new Font("Verdana", Font.BOLD, 23));
        lblConsultarDatasDisponiveis.setBounds(222, 44, 387, 74);
        consultarDatasDisponiveis.add(lblConsultarDatasDisponiveis);
        
        String[] meses = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox<String> comboBoxMes = new JComboBox<>(meses);
        comboBoxMes.setBackground(new Color(255, 255, 255));
        comboBoxMes.setFont(new Font("Verdana", Font.PLAIN, 15));
        comboBoxMes.setBounds(488, 149, 138, 28);
        consultarDatasDisponiveis.add(comboBoxMes);

        JComboBox<String> comboBoxAno = new JComboBox<>();
        comboBoxAno.setBackground(new Color(255, 255, 255));
        comboBoxAno.setModel(new DefaultComboBoxModel<>(new String[] {"2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
        comboBoxAno.setFont(new Font("Verdana", Font.PLAIN, 16));
        comboBoxAno.setBounds(488, 203, 138, 28);
        consultarDatasDisponiveis.add(comboBoxAno);
        
        JTextArea textAreaResultados = new JTextArea();
        textAreaResultados.setBackground(new Color(219, 219, 219));
        textAreaResultados.setEditable(false);  
        textAreaResultados.setFont(new Font("Verdana", Font.BOLD, 14));
        textAreaResultados.setBounds(113, 394, 604, 192);
        consultarDatasDisponiveis.add(textAreaResultados);
        
        JScrollPane scrollPane = new JScrollPane(textAreaResultados);
        scrollPane.setBounds(113, 413, 604, 173); 
        consultarDatasDisponiveis.add(scrollPane);

        JButton btnVoltarConsultarDatas = new JButton("Sair para o menu");
        btnVoltarConsultarDatas.setBackground(new Color(230, 230, 230));
        btnVoltarConsultarDatas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Menu");
            }
        });
        btnVoltarConsultarDatas.setFont(new Font("Verdana", Font.BOLD, 17));
        btnVoltarConsultarDatas.setBounds(247, 616, 336, 31);
        consultarDatasDisponiveis.add(btnVoltarConsultarDatas);
        
        JLabel lblNewLabel_4 = new JLabel("Selecione o mês que deseja consultar:");
        lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 16));
        lblNewLabel_4.setBounds(97, 151, 359, 22);
        consultarDatasDisponiveis.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("Selecione o ano que deseja consultar:");
        lblNewLabel_4_1.setFont(new Font("Verdana", Font.BOLD, 16));
        lblNewLabel_4_1.setBounds(97, 206, 359, 22);
        consultarDatasDisponiveis.add(lblNewLabel_4_1);
        
        JLabel lblResultados = new JLabel("Resultados:");
        lblResultados.setFont(new Font("Verdana", Font.BOLD, 20));
        lblResultados.setBounds(113, 334, 169, 50);
        consultarDatasDisponiveis.add(lblResultados);
        
        JButton btnNewButton_2 = new JButton("Consultar");
        btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 18));
        btnNewButton_2.setBounds(236, 285, 336, 28);
        consultarDatasDisponiveis.add(btnNewButton_2);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 10, 811, 656);
        consultarDatasDisponiveis.add(panel_3);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    Connection con = conexaoBD.getConnection();
        	    int mes = Integer.parseInt((String) comboBoxMes.getSelectedItem());
        	    int ano = Integer.parseInt((String) comboBoxAno.getSelectedItem());

        	   
        	    textAreaResultados.setText("");

        	    try {
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
        	            }
        	        } catch (SQLException ex) {
        	            textAreaResultados.setText("Erro ao consultar datas ocupadas: " + ex.getMessage());
        	            return;
        	        }

        	        StringBuilder resultados = new StringBuilder();
        	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	      
        	        resultados.append("Datas Ocupadas:\n");
        	        if (datasOcupadas.isEmpty()) {
        	            resultados.append("Nenhuma data ocupada.\n");
        	        } else {
        	            for (String data : datasOcupadas) {
        	                resultados.append(data).append("\n");
        	            }
        	        }
        	       
        	        resultados.append("\nDatas Disponíveis:\n");
        	        for (int dia = 1; dia <= diasNoMes; dia++) {
        	            calendar.set(ano, mes - 1, dia);
        	            String dataAtual = sdf.format(calendar.getTime());

        	            if (!datasOcupadas.contains(dataAtual)) {
        	                resultados.append(dataAtual).append("\n");
        	            }
        	        }
        	        
        	        textAreaResultados.setText(resultados.toString());

        	       
        	        textAreaResultados.setCaretPosition(0);

        	    } catch (Exception ex) { 
        	        textAreaResultados.setText("Erro: " + ex.getMessage());
        	    }
        	}

            
        });
        

        JPanel editar = new JPanel();
        editar.setBackground(new Color(0, 128, 255));
        editar.setLayout(null);
        contentPane.add(editar, "Editar");

        JLabel lblEditar = new JLabel("Editar evento");
        lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
        lblEditar.setFont(new Font("Verdana", Font.BOLD, 23));
        lblEditar.setBounds(257, 10, 316, 74);
        editar.add(lblEditar);

        JButton btnVoltarEditar = new JButton("Sair para o menu");
        btnVoltarEditar.setBackground(new Color(230, 230, 230));
        btnVoltarEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPane, "Menu");
            }
        });
        btnVoltarEditar.setFont(new Font("Verdana", Font.BOLD, 17));
        btnVoltarEditar.setBounds(257, 609, 336, 31);
        editar.add(btnVoltarEditar);
        
        JLabel lblNewLabel_5 = new JLabel("Encontre o evento desejado:");
        lblNewLabel_5.setFont(new Font("Verdana", Font.ITALIC, 18));
        lblNewLabel_5.setBounds(36, 90, 280, 36);
        editar.add(lblNewLabel_5);
        
        JLabel lblResultadoDaBusca = new JLabel("Resultado da  busca:");
        lblResultadoDaBusca.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultadoDaBusca.setFont(new Font("Verdana", Font.BOLD, 20));
        lblResultadoDaBusca.setBounds(0, 154, 316, 74);
        editar.add(lblResultadoDaBusca);
        
        JTextArea textAreaResultados_1 = new JTextArea();
        textAreaResultados_1.setFont(new Font("Verdana", Font.PLAIN, 14));
        textAreaResultados_1.setEditable(false);
        textAreaResultados_1.setBackground(new Color(219, 219, 219));

        
        JScrollPane scrollPane9 = new JScrollPane(textAreaResultados_1);
        scrollPane9.setBounds(24, 215, 786, 124); 
        scrollPane9.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollPane9.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  

        
        editar.add(scrollPane9);
    
        JLabel lblNewLabel_6 = new JLabel("Selecione o ID correspondente do evento desejado:");
        lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_6.setBounds(40, 371, 533, 27);
        editar.add(lblNewLabel_6);

        
        textField_5 = new JTextField();
        textField_5.setBounds(513, 371, 130, 24);
        editar.add(textField_5);
        textField_5.setColumns(10);

       
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Verdana", Font.BOLD, 15));
        btnConfirmar.setBounds(653, 371, 120, 24);
        editar.add(btnConfirmar);

        
        JLabel lblOQueVoc = new JLabel("O que você deseja alterar?");
        lblOQueVoc.setHorizontalAlignment(SwingConstants.CENTER);
        lblOQueVoc.setFont(new Font("Verdana", Font.BOLD, 20));
        lblOQueVoc.setBounds(257, 419, 316, 74);
        editar.add(lblOQueVoc);

        
        btnConfirmar.addActionListener(e -> {
            String idTexto = textField_5.getText().trim();
            if (idTexto.isEmpty()) {
                JOptionPane.showMessageDialog(editar, "Por favor, insira um ID válido.");
                return;
            }

            try {
                int idSelecionado = Integer.parseInt(idTexto);

                String query = "SELECT * FROM eventos WHERE id = ?";
                try (Connection conn = conexaoBD.getConnection();
                     PreparedStatement stmt = conn.prepareStatement(query)) {

                    stmt.setInt(1, idSelecionado);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        
                        JOptionPane.showMessageDialog(
                            editar,
                            "ID ENCONTRADO, SELECIONE O QUE DESEJA ALTERAR.",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE
                        );

                        
                        String nome = rs.getString("nome");
                        String tema = rs.getString("tema");
                        String endereco = rs.getString("endereco");
                        String data = rs.getString("data_evento");

                        System.out.println("Evento Encontrado: ");
                        System.out.println("Nome: " + nome);
                        System.out.println("Tema: " + tema);
                        System.out.println("Endereço: " + endereco);
                        System.out.println("Data: " + data);
                    } else {
                        JOptionPane.showMessageDialog(editar, "ID não encontrado. Tente novamente.");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(editar, "Erro ao acessar o banco de dados: " + ex.getMessage());
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(editar, "ID deve ser um número.");
            }
        });


        JButton btnNome_2 = new JButton("Nome");
        btnNome_2.addActionListener(e -> {
            String idTexto = textField_5.getText().trim();
            if (idTexto.isEmpty()) {
                JOptionPane.showMessageDialog(editar, "Por favor, insira um ID e clique em confirmar antes de editar.");
                return; 
            }
            String novoNome = JOptionPane.showInputDialog(editar, "Digite o novo nome do evento:");
            if (novoNome != null && !novoNome.trim().isEmpty()) {
                try {
                    int idSelecionado = Integer.parseInt(idTexto);
                    Cadastro cadastro = new Cadastro();
                    cadastro.editarEvento(idSelecionado, "nome", novoNome);
                    JOptionPane.showMessageDialog(editar, "Nome atualizado com sucesso.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(editar, "Erro ao editar nome: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNome_2.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome_2.setBounds(40, 523, 166, 31);
        editar.add(btnNome_2);
        
        JButton btnNome_2_1 = new JButton("Tema");
        btnNome_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idTexto = textField_5.getText().trim();
                if (idTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(editar, "Por favor, insira um ID e clique em confirmar antes de editar.");
                    return; 
                }
                String novoTema = JOptionPane.showInputDialog(editar, "Digite o novo tema do evento:");
                if (novoTema != null && !novoTema.trim().isEmpty()) {
                    try {
                        int idSelecionado = Integer.parseInt(idTexto);
                        Cadastro cadastro = new Cadastro();
                        cadastro.editarEvento(idSelecionado, "tema", novoTema);
                        JOptionPane.showMessageDialog(editar, "Tema atualizado com sucesso.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(editar, "Erro ao editar tema: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnNome_2_1.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome_2_1.setBounds(234, 523, 166, 31);
        editar.add(btnNome_2_1);
        
        
        JButton btnNome_2_1_1 = new JButton("Endereço");
        btnNome_2_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idTexto = textField_5.getText().trim();
                if (idTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(editar, "Por favor, insira um ID e clique em confirmar antes de editar.");
                    return; 
                }
                String novoEndereco = JOptionPane.showInputDialog(editar, "Digite o novo endereço do evento:");
                if (novoEndereco != null && !novoEndereco.trim().isEmpty()) {
                    try {
                        int idSelecionado = Integer.parseInt(idTexto);
                        Cadastro cadastro = new Cadastro();
                        cadastro.editarEvento(idSelecionado, "endereco", novoEndereco);
                        JOptionPane.showMessageDialog(editar, "Endereço atualizado com sucesso.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(editar, "Erro ao editar endereço: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        btnNome_2_1_1.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome_2_1_1.setBounds(427, 523, 166, 31);
        editar.add(btnNome_2_1_1);
        
        JButton btnNome_2_1_1_1 = new JButton("Data");
        btnNome_2_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idTexto = textField_5.getText().trim();
            
                if (idTexto.isEmpty()) {
                    JOptionPane.showMessageDialog(editar, "Por favor, insira um ID e clique em confirmar antes de editar.");
                    return;
                }

                JFormattedTextField dataField;
                try {
                    MaskFormatter dateMask = new MaskFormatter("##/##/####");
                    dateMask.setPlaceholderCharacter('_');
                    dataField = new JFormattedTextField(dateMask);
                    dataField.setFont(new Font("Verdana", Font.PLAIN, 15));

                    int option = JOptionPane.showConfirmDialog(
                        editar,
                        dataField,
                        "Digite a nova data do evento",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                    );

                    if (option == JOptionPane.OK_OPTION) {
                        String novaData = dataField.getText().trim();

                        if (novaData.isEmpty()) {
                            JOptionPane.showMessageDialog(editar, "Data inválida. Tente novamente.");
                            return;
                        }

                        try {
                            SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
                            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");

                            java.util.Date date = sdfInput.parse(novaData);
                            String dataConvertida = sdfOutput.format(date);

                            int idSelecionado = Integer.parseInt(idTexto); 
                            Cadastro cadastro = new Cadastro();
                            cadastro.editarEvento(idSelecionado, "data_evento", dataConvertida);
                            JOptionPane.showMessageDialog(editar, "Data atualizada com sucesso.");
                        } catch (ParseException ex) {
                            JOptionPane.showMessageDialog(editar, "Erro ao formatar a data: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        } catch (SQLException e1) {
							
							e1.printStackTrace();
						}
                    }
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(editar, "Erro ao formatar a data: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnNome_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome_2_1_1_1.setBounds(626, 523, 166, 31);
        editar.add(btnNome_2_1_1_1);
        
        JButton btnNome_1 = new JButton("Por nome");
        btnNome_1.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        	    
        	    String nome = JOptionPane.showInputDialog(editar, "Digite o nome do cliente para encontrar o evento:");
        	    
        	    if (nome != null && !nome.trim().isEmpty()) {
        	        try {
        	            Cadastro cadastro = new Cadastro();  
        	            List<Evento> eventos = cadastro.buscarEventos("nome", nome.trim()); 

        	            if (eventos.isEmpty()) {
        	                JOptionPane.showMessageDialog(editar, "Nenhum evento encontrado para o cliente: " + nome);
        	            } else {
        	                
        	                StringBuilder resultado = new StringBuilder();

        	                for (Evento evento : eventos) {
        	                  
        	                    String dataFormatada = formatarData(evento.getData());

        	                    
        	                    resultado.append("ID: ").append(evento.getId())
        	                             .append(" | Cliente: ").append(evento.getNome())  
        	                             .append(" | Tema: ").append(evento.getTema())
        	                             .append(" | Endereço: ").append(evento.getEndereco())
        	                             .append(" | Data: ").append(dataFormatada)
        	                             .append("\n");
        	                }

        	               
        	                textAreaResultados_1.setText(resultado.toString());
        	            }

        	        } catch (SQLException ex) {
        	            
        	            JOptionPane.showMessageDialog(editar, "Erro ao consultar o banco de dados: " + ex.getMessage());
        	            ex.printStackTrace();
        	        }
        	    } else {
        	        
        	        JOptionPane.showMessageDialog(editar, "Por favor, insira um nome válido.");
        	    }
        	}

        	
        	private String formatarData(String dataOriginal) {
        	    if (dataOriginal == null || dataOriginal.isEmpty()) {
        	        return "Data não disponível";  
        	    }
        	    try {
        	        String[] partes = dataOriginal.split("-");
        	        if (partes.length == 3) {
        	            return partes[2] + "/" + partes[1] + "/" + partes[0];  
        	        } else {
        	            return dataOriginal;  
        	        }
        	    } catch (Exception e) {
        	        return "Data inválida";  
        	    }
        	}

        });
        btnNome_1.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome_1.setBounds(325, 94, 180, 31);
        editar.add(btnNome_1);
        
        JButton btnNome_1_1 = new JButton("Por tema");
        btnNome_1_1.addActionListener(new ActionListener() {
        	
        		public void actionPerformed(ActionEvent e) {
        		    String tema = JOptionPane.showInputDialog(editar, "Digite o tema do evento para buscar:");
        		    
        		    if (tema != null && !tema.trim().isEmpty()) {
        		        try {
        		            Cadastro cadastro = new Cadastro();  
        		            List<Evento> eventos = cadastro.buscarEventos("tema", tema.trim());

        		            if (eventos.isEmpty()) {
        		                JOptionPane.showMessageDialog(editar, "Nenhum evento encontrado para o tema: " + tema);
        		            } else {
        		                StringBuilder resultado = new StringBuilder();

        		                for (Evento evento : eventos) {
        		                    String dataFormatada = formatarData(evento.getData());

        		                    resultado.append("ID: ").append(evento.getId())
        		                             .append(" | Cliente: ").append(evento.getNome())
        		                             .append(" | Tema: ").append(evento.getTema())
        		                             .append(" | Endereço: ").append(evento.getEndereco())
        		                             .append(" | Data: ").append(dataFormatada)
        		                             .append("\n");
        		                }

        		                textAreaResultados_1.setText(resultado.toString());
        		            }

        		        } catch (SQLException ex) {
        		            JOptionPane.showMessageDialog(editar, "Erro ao consultar o banco de dados: " + ex.getMessage());
        		            ex.printStackTrace();
        		        }
        		    } else {
        		        JOptionPane.showMessageDialog(editar, "Por favor, insira um tema válido.");
        		    }
        		}

        		private String formatarData(String dataOriginal) {
        		    if (dataOriginal == null || dataOriginal.isEmpty()) {
        		        return "Data não disponível";
        		    }
        		    try {
        		        String[] partes = dataOriginal.split("-");
        		        if (partes.length == 3) {
        		            return partes[2] + "/" + partes[1] + "/" + partes[0];
        		        } else {
        		            return dataOriginal;
        		        }
        		    } catch (Exception e) {
        		        return "Data inválida";
        		    }
        		}

        });
        btnNome_1_1.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome_1_1.setBounds(554, 94, 180, 31);
        editar.add(btnNome_1_1);
        
        JButton btnNome_1_2 = new JButton("Pelo endereço");
        btnNome_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    String endereco = JOptionPane.showInputDialog(editar, "Digite o endereço para buscar o evento:");
        	    
        	    if (endereco != null && !endereco.trim().isEmpty()) {
        	        try {
        	            Cadastro cadastro = new Cadastro();  
        	            List<Evento> eventos = cadastro.buscarEventos("endereco", endereco.trim());

        	            if (eventos.isEmpty()) {
        	                JOptionPane.showMessageDialog(editar, "Nenhum evento encontrado para o endereço: " + endereco);
        	            } else {
        	                StringBuilder resultado = new StringBuilder();

        	                for (Evento evento : eventos) {
        	                    String dataFormatada = formatarData(evento.getData());

        	                    resultado.append("ID: ").append(evento.getId())
        	                             .append(" | Cliente: ").append(evento.getNome())
        	                             .append(" | Tema: ").append(evento.getTema())
        	                             .append(" | Endereço: ").append(evento.getEndereco())
        	                             .append(" | Data: ").append(dataFormatada)
        	                             .append("\n");
        	                }

        	                textAreaResultados_1.setText(resultado.toString());
        	            }

        	        } catch (SQLException ex) {
        	            JOptionPane.showMessageDialog(editar, "Erro ao consultar o banco de dados: " + ex.getMessage());
        	            ex.printStackTrace();
        	        }
        	    } else {
        	        JOptionPane.showMessageDialog(editar, "Por favor, insira um endereço válido.");
        	    }
        	}

        	private String formatarData(String dataOriginal) {
        	    if (dataOriginal == null || dataOriginal.isEmpty()) {
        	        return "Data não disponível";
        	    }
        	    try {
        	        String[] partes = dataOriginal.split("-");
        	        if (partes.length == 3) {
        	            return partes[2] + "/" + partes[1] + "/" + partes[0];
        	        } else {
        	            return dataOriginal;
        	        }
        	    } catch (Exception e) {
        	        return "Data inválida";
        	    }
        	}

        });
        btnNome_1_2.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome_1_2.setBounds(326, 140, 179, 31);
        editar.add(btnNome_1_2);
        
        JButton btnNome_1_3 = new JButton("Pela data");
        btnNome_1_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    MaskFormatter dateMask = new MaskFormatter("##/##/####");
                    dateMask.setPlaceholderCharacter('_');
                    JFormattedTextField dataField = new JFormattedTextField(dateMask);
                    dataField.setColumns(10);

                    int option = JOptionPane.showConfirmDialog(
                        editar,
                        dataField,
                        "Digite a data para buscar o evento:",
                        JOptionPane.OK_CANCEL_OPTION
                    );

                    
                    if (option == JOptionPane.OK_OPTION) {
                        String dataInserida = dataField.getText();

                        if (dataInserida != null && !dataInserida.contains("_")) {
                            try {
                                
                                SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
                                SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String dataFormatada = dbFormat.format(inputFormat.parse(dataInserida));

                                Cadastro cadastro = new Cadastro();  
                                List<Evento> eventos = cadastro.buscarEventos("data", dataFormatada);

                                if (eventos.isEmpty()) {
                                    JOptionPane.showMessageDialog(editar, "Nenhum evento encontrado para a data: " + dataInserida);
                                } else {
                                    StringBuilder resultado = new StringBuilder();

                                    for (Evento evento : eventos) {
                                        String dataFormatadaExibicao = formatarData(evento.getData());

                                        resultado.append("ID: ").append(evento.getId())
                                                 .append(" | Cliente: ").append(evento.getNome())
                                                 .append(" | Tema: ").append(evento.getTema())
                                                 .append(" | Endereço: ").append(evento.getEndereco())
                                                 .append(" | Data: ").append(dataFormatadaExibicao)
                                                 .append("\n");
                                    }

                                    textAreaResultados_1.setText(resultado.toString());
                                }

                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(editar, "Formato de data inválido. Use dd/MM/yyyy.");
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(editar, "Erro ao consultar o banco de dados: " + ex.getMessage());
                                ex.printStackTrace();
                            }
                        } else {
                            JOptionPane.showMessageDialog(editar, "Por favor, insira uma data válida no formato dd/MM/yyyy.");
                        }
                    }
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(editar, "Erro ao configurar o campo de data.");
                }
            }

            private String formatarData(String dataOriginal) {
                if (dataOriginal == null || dataOriginal.isEmpty()) {
                    return "Data não disponível";
                }
                try {
                    String[] partes = dataOriginal.split("-");
                    if (partes.length == 3) {
                        return partes[2] + "/" + partes[1] + "/" + partes[0];
                    } else {
                        return dataOriginal;
                    }
                } catch (Exception e) {
                    return "Data inválida";
                }
            }
        });



         
        btnNome_1_3.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNome_1_3.setBounds(554, 140, 180, 31);
        
        editar.add(btnNome_1_3);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(10, 10, 811, 656);
        editar.add(panel_4);

    }

	protected void mostrarResultados(List<Evento> eventos) {
		
	}
}
