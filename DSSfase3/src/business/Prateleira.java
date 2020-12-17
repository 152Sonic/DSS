package business;

import java.util.Objects;

public class Prateleira {
    private boolean disponibilidade;
    private String codPrateleira;
    private Localizacao local;


    public Prateleira(boolean disponibilidade, String codPrateleira, Localizacao local) {
        this.disponibilidade = disponibilidade;
        this.codPrateleira = codPrateleira;
        this.local = local;
    }

    public Prateleira(){
        disponibilidade = false;
        codPrateleira = new String();
        local = new Localizacao();
    }

    public Prateleira(Prateleira prat){
        disponibilidade = prat.isDisponibilidade();
        codPrateleira = prat.getCodPrateleira();
        local = prat.getLocal();
    }

    public Localizacao getLocal() {
        return local;
    }

    public void setLocal(Localizacao local) {
        this.local = local;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getCodPrateleira() {
        return codPrateleira;
    }

    public void setCodPrateleira(String codPrateleira) {
        this.codPrateleira = codPrateleira;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prateleira that = (Prateleira) o;
        return disponibilidade == that.disponibilidade &&
                Objects.equals(codPrateleira, that.codPrateleira) &&
                Objects.equals(local, that.local);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disponibilidade, codPrateleira, local);
    }

    public Prateleira clone(){
        return new Prateleira(this);
    }
}