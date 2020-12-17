package ui;

import java.util.Scanner;

public class TextUI {

    public TextUI() {
        // Criar o menu
        String[] opcoes = {
                "Adicionar Aluno",
                "Consultar Aluno",
                "Listar Alunos",
                "Adicionar Turma",
                "Mudar Sala à Turma",
                "Listar Turmas",
                "Adicionar Aluno a Turma",
                "Remover Aluno da Turma",
                "Listar Alunos de Turma"};
        this.menu = new Menu(opcoes);
        this.model = new TurmasFacade();
        scin = new Scanner(System.in);
    }

    public void run() {
        System.out.println("d");
    }
}
