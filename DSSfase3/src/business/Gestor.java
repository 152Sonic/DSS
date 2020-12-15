package business;

import java.util.Objects;

public class Gestor {
    private String nome;
    private String pass;

    public Gestor(){
        nome = new String();
        pass = new String();
    }

    public Gestor(String nome, String pass) {
        nome = nome;
        this.pass = pass;
    }

    public Gestor(Gestor ges){
        nome = ges.getNome();
        pass = ges.getPass();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gestor gestor = (Gestor) o;
        return Objects.equals(nome, gestor.nome) &&
                Objects.equals(pass, gestor.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pass);
    }

    public Gestor clone(){
        return new Gestor(this);
    }

}
