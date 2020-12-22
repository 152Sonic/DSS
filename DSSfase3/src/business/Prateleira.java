package business;

import java.util.Objects;

/**
 * Classe que contém a implementação da Prateleira
 */
public class Prateleira {
    private int codPrateleira;
    private int disponibilidade;
    private int codPalete;
    private int x;
    private int y;


    /**
     * Construtor parametrizado
     * @param codPrateleira Código da prateleira
     * @param disponibilidade Disponibilidade
     * @param codPal Código da palete
     * @param x abcissa
     * @param y ordenada
     */
    public Prateleira(int codPrateleira, int disponibilidade, int codPal, int x, int y) {
        this.codPalete = codPal;
        this.disponibilidade = disponibilidade;
        this.codPrateleira = codPrateleira;
        this.x = x;
        this.y = y;
    }

    /**
     * Construtor vazio
     */
    public Prateleira(){
        codPalete = -1;
        disponibilidade = 1;
        codPrateleira = -1;
        x = -1;
        y = -1;
    }

    /**
     * Construtor por cópia
     * @param prat Prateleira
     */
    public Prateleira(Prateleira prat){
        codPalete = prat.getCodPal();
        disponibilidade = prat.isDisponibilidade();
        codPrateleira = prat.getCodPrateleira();
        x = prat.getX();
        y = prat.getY();
    }

    /**
     * Devolve  o código da palete
     * @return int
     */
    public int getCodPal(){
        return codPalete;
    }

    /**
     * Define o código da palete
     * @param codPalete Código da palete
     */
    public void setCodPalete(int codPalete) {
        this.codPalete = codPalete;
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
     * Método que nos diz se está disponível
     * @return boolean
     */
    public int isDisponibilidade() {
        return disponibilidade;
    }

    /**
     * Define a disponibiliadade
     * @param disponibilidade Disponibilidade
     */
    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    /**
     * Devolve o código da prateleira
     * @return int
     */
    public int getCodPrateleira() {
        return codPrateleira;
    }

    /**
     * Define  o código da prateleira
     * @param codPrateleira Código da prateleira
     */
    public void setCodPrateleira(int codPrateleira) {
        this.codPrateleira = codPrateleira;
    }


    /**
     * Verifica a igualdade com outro objeto.
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prateleira)) return false;
        Prateleira that = (Prateleira) o;
        return getCodPrateleira() == that.getCodPrateleira() &&
                isDisponibilidade() == that.isDisponibilidade() &&
                codPalete == that.codPalete &&
                getX() == that.getX() &&
                getY() == that.getY();
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(getCodPrateleira(), isDisponibilidade(), codPalete, getX(), getY());
    }

    /**
     * Devolve uma cópia da instância
     * @return prateleira
     */
    public Prateleira clone(){
        return new Prateleira(this);
    }

    /**
     * Método que compara o código de duas paletes
     * @param p Palete
     * @return boolean
     */
    public boolean compara(Palete p){
        return (p.getCodPalete() == this.codPalete);
    }

    /**
     * Método toString do objeto
     * @return Objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prateleira{");
        sb.append("codPrateleira=").append(codPrateleira);
        sb.append(", disponibilidade=").append(disponibilidade);
        sb.append(", codPalete=").append(codPalete);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
