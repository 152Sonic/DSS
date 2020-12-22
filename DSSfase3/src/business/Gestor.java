package business;

import java.util.Objects;

/**
 * Classe que contém a implementação do Gestor
 */
public class Gestor {
    private String nome;
    private String pass;


    /**
     * Construtor vazio
     */
    public Gestor(){
        nome = new String();
        pass = new String();
    }

    /**
     * Construtor parametrizado
     * @param nome Nome do Gestor
     * @param pass Passe
     */
    public Gestor(String nome, String pass) {
        nome = nome;
        this.pass = pass;
    }

    /**
     * Construtor por cópia
     * @param ges Gestor
     */
    public Gestor(Gestor ges){
        nome = ges.getNome();
        pass = ges.getPass();
    }

    /**
     * Devolve o nome
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome
     * @param nome Nome
     */
    public void setNome(String nome) {
        nome = nome;
    }

    /**
     * Devolve a passe
     * @return String
     */
    public String getPass() {
        return pass;
    }

    /**
     * Define a passe
     * @param pass Passe
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Verifica a igualdade com outro objeto
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gestor gestor = (Gestor) o;
        return Objects.equals(nome, gestor.nome) &&
                Objects.equals(pass, gestor.pass);
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(nome, pass);
    }

    /**
     * Devolve uma cópia da instância
     * @return gestor
     */
    public Gestor clone(){
        return new Gestor(this);
    }

}
