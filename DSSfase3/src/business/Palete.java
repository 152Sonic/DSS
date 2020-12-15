package business;

import java.util.Objects;

public class Palete {
    private String codPalete;
    private Localizacao localizacao;
    private boolean transporte;
    private String materiaP;

    public Palete(String codPalete, Localizacao localizacao, boolean espera, String materiaP) {
        this.codPalete = codPalete;
        this.localizacao = localizacao;
        this.transporte = espera;
        this.materiaP = materiaP;
    }

    public Palete(){
        codPalete = new String();
        localizacao = new Localizacao();
        transporte = false;
        materiaP = new String();
    }

    public Palete(Palete pal){
        codPalete = pal.getCodPalete();
        localizacao = pal.getLocalizacao();
        transporte = pal.isEspera();
        materiaP = pal.getMateriaP();
    }

    public String getCodPalete() {
        return codPalete;
    }

    public void setCodPalete(String codPalete) {
        this.codPalete = codPalete;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isEspera() {
        return transporte;
    }

    public void setEspera(boolean espera) {
        this.transporte = espera;
    }

    public String getMateriaP() {
        return materiaP;
    }

    public void setMateriaP(String materiaP) {
        this.materiaP = materiaP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palete palete = (Palete) o;
        return transporte == palete.transporte &&
                Objects.equals(codPalete, palete.codPalete) &&
                Objects.equals(localizacao, palete.localizacao) &&
                Objects.equals(materiaP, palete.materiaP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPalete, localizacao, transporte, materiaP);
    }

    public Palete clone(){
        return new Palete(this);
    }
}
