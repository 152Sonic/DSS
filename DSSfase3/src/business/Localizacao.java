package business;

import java.util.Objects;

/**
 * Classe que contém a implementação da Localização
 */
public class Localizacao {
    private int x;
    private int y;

    /**
     * Construtor vazio
     */
    public Localizacao(){
        x = -1;
        y = -1;
    }

    /**
     * Construtor parametrizado
     * @param x abcissa
     * @param y ordenada
     */
    public Localizacao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Construtor por cópia
     * @param local localização
     */
    public Localizacao(Localizacao local){
        x = local.getX();
        y = local.getY();
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
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Devolve o Y
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Define o Y
     * @param y ordenada
     */
    public void setY(int y) {
        this.y = y;
    }


    /**
     * Verifica a igualdade com outro objeto
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return x == that.x &&
                y == that.y;
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Devolve uma cópia da instância
     * @return localização
     */
    public Localizacao clone(){
        return new Localizacao(this);
    }

    /**
     * Método toString do objeto
     * @return Objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Localizacao{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método que nos diz se corresponde à entrada
     * @return boolean
     */

    /**
     * Método que nos diz se corresponde à saída
     * @return boolean
     */
    public boolean isSaida(){
        return x == 1 && y == 1;
    }

}
