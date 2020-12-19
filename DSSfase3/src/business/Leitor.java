package business;

import java.util.Objects;

public class  Leitor {
    private String info;
    private QRcode qrcode;


    public Leitor(){
        qrcode = new QRcode();
        info = new String();
    }

    public Leitor(String info,QRcode qr) {
        this.qrcode = qr;
        this.info = info;
    }

    public Leitor(Leitor lei){
        qrcode = lei.getQrcode();
        info = lei.getInfo();
    }

    public QRcode getQrcode() {
        return qrcode;
    }

    public void setQrcode(QRcode qrcode) {
        this.qrcode = qrcode;
    }

    public String  getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leitor)) return false;
        Leitor leitor = (Leitor) o;
        return Objects.equals(getInfo(), leitor.getInfo()) &&
                Objects.equals(getQrcode(), leitor.getQrcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInfo(), getQrcode());
    }

    public Leitor clone(){
        return new Leitor(this);
    }
}
