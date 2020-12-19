import business.SistemaFacade;
import ui.TextUI;

public class Main {

    public static void  main (String[] agrs){
        try {
            new TextUI().run();
        }
        catch (Exception e) {
            System.out.println("Não foi possível arrancar: "+e.getMessage());
        }


    }
}

