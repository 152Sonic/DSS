package business;

import java.util.Objects;

/**
 * Classe que contém a implementação da Prateleira
 */
public class Prateleira {
    private int codPrateleira;
    private int disponibilidade; // 0 -false ; 1 - true
    private int codPalete;
    private int x;
    private int y;


    /**
     * Construtor parametrizado
     * @param codPrateleira
     * @param disponibilidade
     * @param codPal
     * @param local
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
     * @param prat
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
     * @return
     */
    public int getCodPal(){
        return codPalete;
    }

    /**
     * Define o código da palete
     * @param codPalete
     */
    public void setCodPalete(int codPalete) {
        this.codPalete = codPalete;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

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
     * @param disponibilidade
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
     * @param codPrateleira
     */
    public void setCodPrateleira(int codPrateleira) {
        this.codPrateleira = codPrateleira;
    }


    @Override
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

    @Override
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
     * @param p
     * @return boolean
     */
    public boolean compara(Palete p){
        return (p.getCodPalete() == this.codPalete);
    }

    @Override
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
