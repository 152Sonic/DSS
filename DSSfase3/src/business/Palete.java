package business;

import java.util.Objects;

public class Palete {
    private int codPalete;
    private Localizacao localizacao;
    private int robot;
    private String materiaP;

    public Palete(int codPalete, Localizacao localizacao, int robot, String materiaP) {
        this.codPalete = codPalete;
        this.localizacao = localizacao;
        this.robot = robot;
        this.materiaP = materiaP;
    }

    public Palete(){
        codPalete = -1;
        localizacao = new Localizacao();
        robot = -1;
        materiaP = new String();
    }

    public Palete(Palete pal){
        codPalete = pal.getCodPalete();
        localizacao = pal.getLocalizacao();
        robot = pal.isTransporte();
        materiaP = pal.getMateriaP();
    }

    public int getCodPalete() {
        return codPalete;
    }

    public void setCodPalete(int codPalete) {
        this.codPalete = codPalete;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public int isTransporte() {
        return robot;
    }

    public void setTransporte(int robot) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Palete{");
        sb.append("codPalete=").append(codPalete);
        sb.append(", localizacao=").append(localizacao);
        sb.append(", robot=").append(robot);
        sb.append(", materiaP='").append(materiaP).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public boolean isEmpty(){
        return codPalete == -1 && localizacao.getX() == -1 && localizacao.getY() == -1 && robot == -1 && materiaP.equals("");
    }
}
