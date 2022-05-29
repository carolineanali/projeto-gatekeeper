import java.util.Scanner;

public class Menu {

    public void exibirPrimeiroMenu(){
        System.out.println("\nOlá, seja bem vindo!\n" +
                "Digite o caminho da pasta com os arquivos " +
                "que deseja validar: \nEx: C:\\Users\\rayssa\\IdeaProjects ");

    }

    public void exibirSegundoMenu() {
        System.out.println("\nGostaria de ver os erros apresentados?\n" +
                "\nDigite:\n" +
                "1 - SIM\n" +
                "2 - NÃO\n" +
                "3 - Validar outros arquivos\n");


    }

    public void exibirTerceiroMenu() {
        System.out.println("\nEscolha a opção desejada:\n" +
                "1 - Erros no Header Geral\n" +
                "2 - Erros no Header Lote\n" +
                "3 - Erros no Detalhe\n" +
                "4 - Erros no Trailler Lote\n" +
                "5 - Erros no Trailler Geral\n" +
                "6 - Ver todos os erros\n" +
                "0 - Sair\n");

    }


}
