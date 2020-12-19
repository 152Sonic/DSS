package business;

import java.util.Objects;

public class Pair {
    private int x;
    private Localizacao y;

    public Pair(){
        x = -1;
        y = new Localizacao();
    }

    public Pair(int i, Localizacao l){
        x = i;
        y = l;
    }

    public Pair(Pair p){
        x = p.getX();
        y = p.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Localizacao getY() {
        return y;
    }

    public void setY(Localizacao y) {
        this.y = y;
    }

    public Pair clone(){ return new Pair(this); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return Objects.equals(getX(), pair.getX()) &&
                Objects.equals(getY(), pair.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pair{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
