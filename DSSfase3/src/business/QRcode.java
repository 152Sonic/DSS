package business;

public class QRcode {
    private String materiaP;
    private int qtdPaletes;

    public QRcode(){
        materiaP = new String();
        qtdPaletes = 0;
    }

    public QRcode(String materiaP, int qtdPaletes) {
        this.materiaP = materiaP;
        this.qtdPaletes = qtdPaletes;
    }

    public QRcode(QRcode lei){
        materiaP = lei.getMateriaP();
        qtdPaletes = lei.getQtdPaletes();
    }

    public String getMateriaP() {
        return materiaP;
    }

    public void setMateriaP(String materiaP) {
        this.materiaP = materiaP;
    }

    public int getQtdPaletes() {
        return qtdPaletes;
    }

    public void setQtdPaletes(int qtdPaletes) {
        this.qtdPaletes = qtdPaletes;
    }
}
