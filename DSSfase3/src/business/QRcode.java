package business;

public class QRcode {
    private int cod;
    private String materiaP;


    public QRcode(){
        materiaP = new String();
        cod = -1;
    }

    public QRcode(String materiaP, int cod) {
        this.materiaP = materiaP;
        this.cod = cod;
    }

    public QRcode(QRcode lei){
        materiaP = lei.getMateriaP();
        cod = lei.getCod();
    }

    public String getMateriaP() {
        return materiaP;
    }

    public void setMateriaP(String materiaP) {
        this.materiaP = materiaP;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
