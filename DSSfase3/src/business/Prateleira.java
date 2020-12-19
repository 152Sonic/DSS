package business;

import java.util.Objects;

public class Prateleira {
    private int codPrateleira;
    private boolean disponibilidade;
    private int codPalete;
    private Localizacao local;


    public Prateleira(int codPrateleira, boolean disponibilidade, int codPal, Localizacao local) {
        this.codPalete = codPal;
        this.disponibilidade = disponibilidade;
        this.codPrateleira = codPrateleira;
        this.local = local;
    }

    public Prateleira(){
        codPalete = -1;
        disponibilidade = false;
        codPrateleira = -1;
        local = new Localizacao();
    }

    public Prateleira(Prateleira prat){
        codPalete = prat.getCodPal();
        disponibilidade = prat.isDisponibilidade();
        codPrateleira = prat.getCodPrateleira();
        local = prat.getLocal();
    }

    public int getCodPal(){
        return codPalete;
    }

    public void setCodPalete(int codPalete) {
        this.codPalete = codPalete;
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

    public int getCodPrateleira() {
        return codPrateleira;
    }

    public void setCodPrateleira(int codPrateleira) {
        this.codPrateleira = codPrateleira;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prateleira that = (Prateleira) o;
        return disponibilidade == that.disponibilidade &&
                Objects.equals(codPalete, that.codPalete) &&
                Objects.equals(codPrateleira, that.codPrateleira) &&
                Objects.equals(local, that.local);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPalete, disponibilidade, codPrateleira, local);
    }

    public Prateleira clone(){
        return new Prateleira(this);
    }

    public boolean compara(Palete p){
        return (p.getCodPalete() == this.codPalete);
    }
}
