package data;

import business.Localizacao;
import business.Pair;
import business.Prateleira;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class EsperaDAO implements List<Pair> {

    private static EsperaDAO singleton = null;

    private EsperaDAO() {
        try (Connection conn =
                     DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS localizacao (" +
                    "x int NOT NULL PRIMARY KEY," +
                    "y int NOT NULL PRIMARY KEY DEFAULT 0)";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE  IF NOT EXISTS par (" +
                    "x int NOT NULL PRIMARY KEY," +
                    "y NOT NULL PRIMARY KEY," +
                    "foreign key(Localizacao) references localizacao(x,y))";
            stm.executeUpdate(sql);
            sql = "CREATE TABLE IF NOT EXISTS espera (" +
                    "par NOT NULL PRIMARY KEY,"+
                    "foreign key(Pair) references par(x,y))";
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

    public boolean add(Pair pair) {
        Localizacao l = pair.getY();
        try (Connection conn = DriverManager.getConnection(DAOconfig.URL, DAOconfig.USERNAME, DAOconfig.PASSWORD);
             Statement stm = conn.createStatement()) {
            // Actualizar o localização
            stm.executeUpdate(
                    "INSERT INTO localizacao " +
                            "VALUES ('"+ l.getX()+ "', "+
                            l.getY()+") ");

            // Actualizar o espera
            stm.executeUpdate(
                    "INSERT INTO espera" +
                            "VALUES ('" + pair.getX() + "'," +
                            pair.getY()+") ");
        } catch (SQLException e) {
            // Database error!
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        }
        return true;
    }

    public Pair remove(int index) {
        return null;
    }

    public Pair get(int index) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public void add(int index, Pair element) {

    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<Pair> iterator() {
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

    public boolean addAll(Collection<? extends Pair> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends Pair> c) {
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

    public Pair set(int index, Pair element) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<Pair> listIterator() {
        return null;
    }

    public ListIterator<Pair> listIterator(int index) {
        return null;
    }

    public List<Pair> subList(int fromIndex, int toIndex) {
        return null;
    }
}
