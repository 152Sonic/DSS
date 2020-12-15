package data;
import business.Palete;
import java.sql.*;
import java.util.*;

public class PaletesDAO implements Map<String,Palete> {
    private static PaletesDAO singleton = null;

    private PaletesDAO(){
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
        Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS localizacao (" +
                    "x int NOT NULL PRIMARY KEY," +
                    "y int NOT NULL PRIMARY KEY DEFAULT 0)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS paletes (" +
                    "codPaletes varchar(10) NOT NL PRIMARY KEY," +
                    "localizacao DEFAULT NULL," +
                    "transporte char(1) DEFAULT NULL," +
                    "materialP varchar(100), foreign key(Localizacao) references localizacao(x,y))";  // Assume-se uma relação 1-n entre Turma e Aluno
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static PaletesDAO getInstance() {
        if (PaletesDAO.singleton == null) {
            PaletesDAO.singleton = new AlunoDAO();
        }
        return AlunoDAO.singleton;
    }



}
