import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.exibirPrimeiroMenu();
        Scanner ler = new Scanner(System.in);
        String caminho = ler.nextLine();
        Arquivo arquivo = new Arquivo();
        arquivo.abrirArquivos(caminho);
        arquivo.executarArquivos();
        arquivo.opcoesMenu();


    }
}
