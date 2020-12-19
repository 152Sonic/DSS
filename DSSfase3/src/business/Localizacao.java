package business;

import java.util.Objects;

public class Localizacao {
    private int x;
    private int y;

    public Localizacao(){
        x = -1;
        y = -1;
    }

    public Localizacao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Localizacao(Localizacao local){
        x = local.getX();
        y = local.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Localizacao clone(){
        return new Localizacao(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Localizacao{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }

    public boolean isEntrada(){
        return x == 0 && y == 0;
    }

    public boolean isSaida(){
        return x == 1 && y == 1;
    }

}
