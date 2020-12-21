package data;

import business.Localizacao;
import business.Pair;
import business.Palete;
import business.Prateleira;

import java.sql.*;
import java.util.*;

public class EsperaDAO implements List<Palete> {

    private static EsperaDAO singleton = null;

    private EsperaDAO() {
        try (Connection conn =
                     DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS espera (" +
                    "codPaletes int NOT NULL PRIMARY KEY," +
                    "x INT DEFAULT NULL," +
                    "y INT DEFAULT NULL," +
                    "transporte int DEFAULT NULL," +
                    "materialP varchar(100))";
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
    }

    public static EsperaDAO getInstance() {
        if (EsperaDAO.singleton == null) {
            EsperaDAO.singleton = new EsperaDAO();
        }
        return EsperaDAO.singleton;
    }
    //Necessitamos do add, get, remove

    public boolean add(Palete a) {
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            // Actualizar o espera
            stm.executeUpdate(
                    "INSERT INTO espera VALUES ('"+a.getCodPalete()+"', '"+a.getX()+"', '"+a.getY()+ "', '" +a.isTransporte()+"', '"+a.getMateriaP()+"') ");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return true;
    }

    public Palete remove(int index) {
        Palete p = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            stm.executeUpdate("DELETE FROM espera LIMIT 1");
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return p;
    }

    public static List<Palete> getToList(){
        List<Palete> r = new ArrayList<>();
        Palete p = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM espera")) {
            while(rs.next()){
                p = new Palete(rs.getInt("codPaletes"),rs.getInt("x"),rs.getInt("y"), rs.getInt("transporte"),rs.getString("materialP"));
                r.add(p);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return r;
    }

    public Palete get(int index) {
        Palete p = null;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM espera LIMIT 1")) {
            if (rs.next()) {  // A chave existe na tabela
                // Reconstruir o aluno com os dados obtidos da BD - a chave estranjeira da turma, não é utilizada aqui.
                p = new Palete(rs.getInt("codPaletes"), rs.getInt("x"), rs.getInt("y"),rs.getInt("transporte"),rs.getString("materialP"));
            }
        } catch (Exception e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return p;
    }

    public boolean remove(Object o) {
        return false;
    }

    public void add(int index, Palete element) {

    }

    public int size() {
        int i = 0;
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement();
             ResultSet rs = stm.executeQuery("SELECT count(*) FROM espera")) {
            if(rs.next()) {
                i = rs.getInt(1);
            }
        }
        catch (Exception e) {
            // Erro a criar tabela...
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return i;
    }
    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<Palete> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }


    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends Palete> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends Palete> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public Palete set(int index, Palete element) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<Palete> listIterator() {
        return null;
    }

    public ListIterator<Palete> listIterator(int index) {
        return null;
    }

    public List<Palete> subList(int fromIndex, int toIndex) {
        return null;
    }
}
