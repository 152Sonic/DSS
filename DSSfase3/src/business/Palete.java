package business;

import java.util.Objects;


/**
 * Classe que contém a implementação da Palete
 */
public class Palete {
    private int codPalete;
    private Localizacao localizacao;
    private int robot;
    private String materiaP;

    /**
     * Construtor parametrizado
     * @param codPalete
     * @param localizacao
     * @param robot
     * @param materiaP
     */
    public Palete(int codPalete, Localizacao localizacao, int robot, String materiaP) {
        this.codPalete = codPalete;
        this.localizacao = localizacao;
        this.robot = robot;
        this.materiaP = materiaP;
    }

    /**
     * Construtor vazio
     */
    public Palete(){
        codPalete = -1;
        localizacao = new Localizacao();
        robot = -1;
        materiaP = new String();
    }

    /**
     * Construtor por cópia
     * @param pal
     */
    public Palete(Palete pal){
        codPalete = pal.getCodPalete();
        localizacao = pal.getLocalizacao();
        robot = pal.isTransporte();
        materiaP = pal.getMateriaP();
    }

    /**
     * Devolve o código da palete
     * @return int
     */
    public int getCodPalete() {
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
    public Localizacao getLocalizacao() {
        return localizacao;
    }

    /**
     * Define a localização
     * @param localizacao
     */
    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Método que nos diz qual robot transporta a palete
     * @return
     */
    public int isTransporte() {
        return robot;
    }

    /**
     * Método que altera o robot responsável pelo transporte da palete
     * @param robot
     */
    public void setTransporte(int robot) {
        this.robot = robot;
    }


    /**
     * Devolve o material da palete
     * @return String
     */
    public String getMateriaP() {
        return materiaP;
    }

    /**
     * Define o material da palete
     * @param materiaP
     */
    public void setMateriaP(String materiaP) {
        this.materiaP = materiaP;
    }

    /**
     * Verifica a igualdade com outro objeto
     * @param o Objeto a comparar
     * @return boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palete palete = (Palete) o;
        return robot == palete.robot &&
                Objects.equals(codPalete, palete.codPalete) &&
                Objects.equals(localizacao, palete.localizacao) &&
                Objects.equals(materiaP, palete.materiaP);
    }

    /**
     * Método hashCode do objeto
     * @return hash do objeto
     */
    public int hashCode() {
        return Objects.hash(codPalete, localizacao, robot, materiaP);
    }


    /**
     * Devolve uma cópia da instância
     * @return Palete
     */
    public Palete clone(){
        return new Palete(this);
    }

    /**
     * Método toString do objeto
     * @return Objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Palete{");
        sb.append("codPalete=").append(codPalete);
        sb.append(", localizacao=").append(localizacao);
        sb.append(", robot=").append(robot);
        sb.append(", materiaP='").append(materiaP).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método que nos diz se está vazio
     * @return boolean
     */
    public boolean isEmpty(){
        return codPalete == -1 && localizacao.getX() == -1 && localizacao.getY() == -1 && robot == -1 && materiaP.equals("");
    }

}
