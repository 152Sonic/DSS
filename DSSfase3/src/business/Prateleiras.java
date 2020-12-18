package business;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prateleiras {
    private Map<String, Prateleira> prateleiras;

    public Prateleiras(Map<String, Prateleira> prateleiras) {
       setPrateleiras(prateleiras);
    }

    public Prateleiras(Prateleiras pr){
        setPrateleiras(pr.getPrateleiras());
    }

    public Prateleiras(){
        prateleiras = new HashMap<>();
    }

    public Map<String, Prateleira> getPrateleiras() {
        Map<String, Prateleira> auxprateletiras = new HashMap<>();
        for(Prateleira n: prateleiras.values()){
            auxprateletiras.put(n.getCodPrateleira(), n);
        }
        return auxprateletiras;
    }

    public void setPrateleiras(Map<String, Prateleira> robots) {
        this.prateleiras = new HashMap<>();
        for(Prateleira n: prateleiras.values()){
            this.prateleiras.put(n.getCodPrateleira(), n);
        }
    }

    public void adicionaPrateileira(Prateleira a){
        this.prateleiras.put(a.getCodPrateleira(), a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prateleiras that = (Prateleiras) o;
        return Objects.equals(prateleiras, that.prateleiras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prateleiras);
    }

    public Prateleiras clone(){
        return new Prateleiras(this);
    }



}
