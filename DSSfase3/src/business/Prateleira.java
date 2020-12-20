package business;

import java.util.Objects;

/**
 * Classe que contém a implementação da Prateleira
 */
public class Prateleira {
    private int codPrateleira;
    private boolean disponibilidade;
    private int codPalete;
    private Localizacao local;


    /**
     * Construtor parametrizado
     * @param codPrateleira
     * @param disponibilidade
     * @param codPal
     * @param local
     */
    public Prateleira(int codPrateleira, boolean disponibilidade, int codPal, Localizacao local) {
        this.codPalete = codPal;
        this.disponibilidade = disponibilidade;
        this.codPrateleira = codPrateleira;
        this.local = local;
    }

    /**
     * Construtor vazio
     */
    public Prateleira(){
        codPalete = -1;
        disponibilidade = false;
        codPrateleira = -1;
        local = new Localizacao();
    }

    /**
     * Construtor por cópia
     * @param prat
     */
    public Prateleira(Prateleira prat){
        codPalete = prat.getCodPal();
        disponibilidade = prat.isDisponibilidade();
        codPrateleira = prat.getCodPrateleira();
        local = prat.getLocal();
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

    /**
     * Devolve a localização
     * @return localização
     */
    public Localizacao getLocal() {
        return local;
    }

    /**
     * Define a localização
     * @param local
     */
    public void setLocal(Localizacao local) {
        this.local = local;
    }


    /**
     * Método que nos diz se está disponível
     * @return boolean
     */
    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    /**
     * Define a disponibiliadade
     * @param disponibilidade
     */
    public void setDisponibilidade(boolean disponibilidade) {
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


    /**
     * Verifica a igualdade com outro objeto
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prateleira that = (Prateleira) o;
        return disponibilidade == that.disponibilidade &&
                Objects.equals(codPalete, that.codPalete) &&
                Objects.equals(codPrateleira, that.codPrateleira) &&
                Objects.equals(local, that.local);
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(codPalete, disponibilidade, codPrateleira, local);
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

    /**
     * Método toString do objeto
     * @return Objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prateleira{");
        sb.append("codPrateleira=").append(codPrateleira);
        sb.append(", disponibilidade=").append(disponibilidade);
        sb.append(", codPalete=").append(codPalete);
        sb.append(", local=").append(local);
        sb.append('}');
        return sb.toString();
    }
}
