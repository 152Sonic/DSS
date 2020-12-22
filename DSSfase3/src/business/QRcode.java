package business;

/**
 * Classe que contém a implementação do QrCode
 */
public class QRcode {
    private int cod;
    private String materiaP;


    /**
     * Construtor vazio
     */
    public QRcode(){
        materiaP = new String();
        cod = -1;
    }

    /**
     * Construtor parametrizado
     * @param materiaP Material da palete
     * @param cod Código da palete
     */
    public QRcode(String materiaP, int cod) {
        this.materiaP = materiaP;
        this.cod = cod;
    }

    /**
     * Construtor por cópia
     * @param lei QrCode
     */
    public QRcode(QRcode lei){
        materiaP = lei.getMateriaP();
        cod = lei.getCod();
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
     * @param materiaP Material da palete
     */
    public void setMateriaP(String materiaP) {
        this.materiaP = materiaP;
    }

    /**
     * Devolve o código da palete
     * @return int
     */
    public int getCod() {
        return cod;
    }

    /**
     * Define o código da palete
     * @param cod Código da palete
     */
    public void setCod(int cod) {
        this.cod = cod;
    }
}
