package business;

import java.util.Objects;

public class Palete {
    private String codPalete;
    private Localizacao localizacao;
    private String robot;
    private String materiaP;

    public Palete(String codPalete, Localizacao localizacao, String robot, String materiaP) {
        this.codPalete = codPalete;
        this.localizacao = localizacao;
        this.robot = robot;
        this.materiaP = materiaP;
    }

    public Palete(){
        codPalete = new String();
        localizacao = new Localizacao();
        robot = new String();
        materiaP = new String();
    }

    public Palete(Palete pal){
        codPalete = pal.getCodPalete();
        localizacao = pal.getLocalizacao();
        robot = pal.isTransporte();
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

    public String isTransporte() {
        return robot;
    }

    public void setTransporte(String robot) {
        this.robot = robot;
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
        return robot == palete.robot &&
                Objects.equals(codPalete, palete.codPalete) &&
                Objects.equals(localizacao, palete.localizacao) &&
                Objects.equals(materiaP, palete.materiaP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codPalete, localizacao, robot, materiaP);
    }

    public Palete clone(){
        return new Palete(this);
    }
}
