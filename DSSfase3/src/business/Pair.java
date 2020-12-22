package business;

import java.util.Objects;

/**
 * Classe que contém a implementação de um par
 */
public class Pair {
    private int x;
    private Localizacao y;

    /**
     * Construtor vazio
     */
    public Pair(){
        x = -1;
        y = new Localizacao();
    }

    /**
     * Construtor parametrizado
     * @param i abcissa
     * @param l Localização
     */
    public Pair(int i, Localizacao l){
        x = i;
        y = l;
    }

    /**
     * Construtor por cópia
     * @param p Par
     */
    public Pair(Pair p){
        x = p.getX();
        y = p.getY();
    }

    /**
     * Devolve o X
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Define o X
     * @param x abcissa
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Devolve o Y
     * @return Localizacao
     */
    public Localizacao getY() {
        return y;
    }

    /**
     * Define o Y
     * @param y Localização
     */
    public void setY(Localizacao y) {
        this.y = y;
    }

    /**
     * Devolve uma cópia da instância
     * @return Pair
     */
    public Pair clone(){ return new Pair(this); }


    /**
     * Verifica a igualdade com outro objeto
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return Objects.equals(getX(), pair.getX()) &&
                Objects.equals(getY(), pair.getY());
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    /**
     * Método toString do objeto
     * @return Objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pair{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
