import java.util.Objects;

public class Prateleira {
    private boolean disponibilidade;
    private String codPrateleira;


    public Prateleira(boolean disponibilidade, String codPrateleira) {
        this.disponibilidade = disponibilidade;
        this.codPrateleira = codPrateleira;
    }

    public Prateleira(){
        disponibilidade = false;
        codPrateleira = new String();
    }

    public Prateleira(Prateleira prat){
        disponibilidade = prat.isDisponibilidade();
        codPrateleira = prat.getCodPrateleira();
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
                Objects.equals(codPrateleira, that.codPrateleira);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disponibilidade, codPrateleira);
    }

    public Prateleira clone(){
        return new Prateleira(this);
    }
}
