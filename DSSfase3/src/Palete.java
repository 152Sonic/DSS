import java.util.Objects;

public class Palete {
    private String codPalete;
    private Localização localização;
    private boolean espera;
    private String materiaP;

    public Palete(String codPalete, Localização localização, boolean espera, String materiaP) {
        this.codPalete = codPalete;
        this.localização = localização;
        this.espera = espera;
        this.materiaP = materiaP;
    }

    public Palete(){
        codPalete = new String();
        localização = new Localização();
        espera = false;
        materiaP = new String();
    }

    public Palete(Palete pal){
        codPalete = pal.getCodPalete();
        localização = pal.getLocalização();
        espera = pal.isEspera();
        materiaP = pal.getMateriaP();
    }

    public String getCodPalete() {
        return codPalete;
    }

    public void setCodPalete(String codPalete) {
        this.codPalete = codPalete;
    }

    public Localização getLocalização() {
        return localização;
    }

    public void setLocalização(Localização localização) {
        this.localização = localização;
    }

    public boolean isEspera() {
        return espera;
    }

    public void setEspera(boolean espera) {
        this.espera = espera;
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
        return espera == palete.espera &&
                Objects.equals(codPalete, palete.codPalete) &&
                Objects.equals(localização, palete.localização) &&
                Objects.equals(materiaP, palete.materiaP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPalete, localização, espera, materiaP);
    }

    public Palete clone(){
        return new Palete(this);
    }
}
