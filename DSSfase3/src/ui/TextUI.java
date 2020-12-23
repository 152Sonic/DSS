/*
 *  DISCLAIMER: Este código foi criado para discussão e edição durante as aulas práticas de DSS, representando
 *  uma solução em construção. Como tal, não deverá ser visto como uma solução canónica, ou mesmo acabada.
 *  É disponibilizado para auxiliar o processo de estudo. Os alunos são encorajados a testar adequadamente o
 *  código fornecido e a procurar soluções alternativas, à medida que forem adquirindo mais conhecimentos.
 */
package ui;

import business.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Exemplo de interface em modo texto.
 *
 * @author JFC
 * @version 20201208
 */
public class TextUI {
    // O model tem a 'lógica de negócio'.
    private ISistemaFacade model;

    // Menus da aplicação
    private Menu menu;

    // Scanner para leitura
    private Scanner scin;

    /**
     * Construtor.
     * <p>
     * Cria os menus e a camada de negócio.
     */
    public TextUI() {
        // Criar o menu
        String[] opcoes = {
                "Gestor",
                "Leitor",
                "Robot",
                "Sistema"};
        this.menu = new Menu(opcoes);
        this.model = new SistemaFacade();
        scin = new Scanner(System.in);
    }

    public void TextUI(){
        String[] opcoes = {
                "Gestor",
                "Leitor",
                "Robot",
                "Sistema"};
        this.menu = new Menu(opcoes);
        scin = new Scanner(System.in);
    }

    /**
     * Funcionamento das várias opções
     */
    public void run(){
        int escolha;
        do{
            menu.executaP();
            escolha = menu.getOpcao();
            switch (escolha){
                case 1:
                    runGestor();
                    break;
                case 2:
                    runLeitor();
                    break;
                case 3:
                    runRobot();
                    break;
                case 4:
                    runSistema();
                    break;
                default:
                    break;
            }
        }while(escolha!=5);
        System.out.println("Até breve!...");
    }

    // -------------------------------- GESTOR -------------------------------------------

    /**
     * Mostra o menu do Gestor
     */
    public void menuGestor() {
        String[] opcoes = {
                "Consultar lista de localizações"};
        this.menu = new Menu(opcoes);
    }


    /**
     * Funcionamento do menu Gestor
     */
    public void runGestor() {
        do {
            menuGestor();
            menu.executa();
            switch (menu.getOpcao()) {
                case 1:
                    trataListaLocalizacoes();
                    break;
            }
        } while (menu.getOpcao() != 0);
        System.out.println("Até breve!...");
        TextUI();
    }

    // -------------------------------- Leitor -------------------------------------------

    /**
     * Mostra o menu do Leitor
     */
    public void menuLeitor() {
        String[] opcoes = {
                "Comunicar código QR"};
        this.menu = new Menu(opcoes);
    }

    /**
     * Funcionamento do menu Leitor
     */
    public void runLeitor() {
        do {
            menuLeitor();
            menu.executa();
            switch (menu.getOpcao()) {
                case 1:
                    trataDoQR();
                    break;
            }
        } while (menu.getOpcao() != 0);
        System.out.println("Até breve!...");
        TextUI();
    }

    /**
     * Mostra a lista de localizações das paletes
     */
    public void trataListaLocalizacoes(){
        System.out.println("** Lista de localizacoes de paletes **\n");
        Map<Integer, Map.Entry<Integer,Integer>> p = this.model.consultalistagemdeLocalizacao();
        for(Map.Entry<Integer,Map.Entry<Integer,Integer>> aux : p.entrySet())
            System.out.println("A palete numero " + aux.getKey() + " esta em x = " + aux.getValue().getKey() + ", y = " + aux.getValue().getKey());
    }

    /**
     * Mostra a palete a partir da sua materia prima
     */
    public void trataDoQR(){
        Leitor l = this.model.getLeitor();
        System.out.println("Insira matéria prima: ");
        scin = new Scanner(System.in);
        String mp = scin.next();
        l.getQrcode().setMateriaP(mp);

        this.model.comunicaQR(l.getQrcode());
        System.out.println("Nova palete em stock:");
        System.out.println("\t Materia prima: " + l.getQrcode().getMateriaP());
    }

    // -------------------------------- Robot -------------------------------------------

    /**
     * Mostra o menu Robot
     */
    public void menuRobot() {
        String[] opcoes = {
                "Notificar recolha",
                "Notificar entrega"};
        this.menu = new Menu(opcoes);
    }

    /**
     * Funcionamento do menu Robot
     */
    public void runRobot() {
        do {
            menuRobot();
            menu.executa();
            switch (menu.getOpcao()) {
                case 1:
                    trataDaRecolha();
                    break;
                case 2:
                    trataDaEntrega();
                    break;
            }
        } while (menu.getOpcao() != 0);
        System.out.println("Até breve!...");
        TextUI();
    }

    /**
     * Informa da recolha efetuada pelo robot
     */
    public void trataDaRecolha(){
        Robot r = this.model.getRobot(1);
        if (r.getaTranpos()!=-1) {
            this.model.notificaRecolha(r.getaTranpos());
            System.out.println("\nRecolha da palete numero " + r.getaTranpos() + " efetuada!");
        }
        else
            System.out.println("\nNada a recolher!");
    }

    /**
     * Informa da entrega efetuada pelo robot
     */
    public void trataDaEntrega() {
        Robot r = this.model.getRobot(1);
        Palete palete = this.model.getPaletes(r.getaTranpos());
        if ((!(r.getxRobot() == r.getLocalizacaoXFinal() &&  r.getyRobot() == r.getLocalizacaoYFinal()))) {
            Palete pal = this.model.notificaEntrega(palete, r.getLocalizacaoXFinal(),r.getLocalizacaoYFinal());
            System.out.println("\nEntrega da palete numero " + pal.toString() + " efetuada!");
        }
        else
            System.out.println("\n Palete encontra-se já no destino!");
    }

    // -------------------------------- SISTEMA -------------------------------------------

    /**
     * Mostra o menu Sistema
     */
    public void menuSistema() {
        String[] opcoes = {
                "Ordem de trasnporte"};
        this.menu = new Menu(opcoes);
    }

    /**
     * Funcionamento do menu Sistema
     */
    public void runSistema() {
        do {
            menuSistema();
            menu.executa();
            switch (menu.getOpcao()) {
                case 1:
                    trataOrdemTransporte();
                    break;
            }
        } while (menu.getOpcao() != 0);
        System.out.println("Até breve!...");
        TextUI();
    }

    /**
     * Informa da Ordem de Transporte, ou seja, se o robot está ocupado ou não
     */
    public void trataOrdemTransporte(){
        if(this.model.getEspera().size() > 0) {
            boolean flag;
            flag = this.model.comunicaOT();
            if(flag){
                System.out.println("Ordem de transporte concluida");
            }
            else{
                System.out.println("Robot ainda está ocupado");
            }
        }
        else{
            System.out.println("\nNão há paletes a recolher");
        }
    }


}