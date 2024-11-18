package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexaoBD {

    public static Connection faz_conexao() { 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/cadastro", "root", "root");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado: " + e.getMessage());
            return null; 
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
            return null; 
        }
    }

    public static Connection getConnection() {
        return faz_conexao(); 
    }
}