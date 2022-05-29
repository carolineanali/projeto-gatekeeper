
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Arquivo {


    private File[] arquivos = new File[0];
    private File[] arquivosOk = new File[0];
    private int quantArquivosFalha;
    private ArrayList errosHG;
    private ArrayList errosHL = new ArrayList<String>();
    private ArrayList errosDT = new ArrayList<String>();
    private ArrayList errosTL = new ArrayList<String>();
    private ArrayList errosTG = new ArrayList<String>();
    private ArrayList errosLinha = new ArrayList<String>();

    public int getQuantArquivosFalha() {
        return quantArquivosFalha;
    }

    public void setQuantArquivosFalha(int quantArquivosFalha) {
        this.quantArquivosFalha = quantArquivosFalha;
    }

    public ArrayList getErrosHG() {
        return errosHG;
    }

    public void setErrosHG(ArrayList errosHG) {
        this.errosHG = errosHG;
    }

    public ArrayList getErrosHL() {
        return errosHL;
    }

    public void setErrosHL(ArrayList errosHL) {
        this.errosHL = errosHL;
    }

    public ArrayList getErrosDT() {
        return errosDT;
    }

    public void setErrosDT(ArrayList errosDT) {
        this.errosDT = errosDT;
    }

    public ArrayList getErrosTL() {
        return errosTL;
    }

    public void setErrosTL(ArrayList errosTL) {
        this.errosTL = errosTL;
    }

    public ArrayList getErrosTG() {
        return errosTG;
    }

    public void setErrosTG(ArrayList errosTG) {
        this.errosTG = errosTG;
    }

    public ArrayList getErrosLinha() {
        return errosLinha;
    }

    public void setErrosLinha(ArrayList errosLinha) {
        this.errosLinha = errosLinha;
    }

    public void abrirArquivos(String caminho) {

        File diretorio = new File(caminho);
        //TODO realizar tratamento de erro, caso o arquivo seja null
        try {
            arquivos = diretorio.listFiles();
            System.out.println("\nForam lidos " + arquivos.length + " arquivos.");
        } catch (NullPointerException e) {

            System.err.println("Você digitou um caminho inválido!" +
                    "Tente adicionar apenas o caminho da pasta " +
                    "com os arquivos que deseja validar");

        }


        try {
            FileFilter filtro = new FileFilter() {

                @Override
                public boolean accept(File arquivos) {
                    return arquivos.getName().endsWith(".txt");
                }
            };

            arquivosOk = diretorio.listFiles(filtro);
            System.out.println("\nSerá(ão) validado(s) " + arquivosOk.length + " arquivo(s).");
            quantArquivosFalha = (arquivos.length) - (arquivosOk.length);
            if (quantArquivosFalha >= 1) {
                System.out.println(quantArquivosFalha + " arquivo(s) não é(são) do tipo .txt, " +
                        "portanto não será(ão) validado(s). \n");
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao abrir arquivo(s).");
        }


    }

    public void executarArquivos() {


        for (int i = 0; i < arquivosOk.length; i++) {
            String arquivo = arquivosOk[i].toString();
            System.out.println("\nLendo arquivo: " + arquivo);
            String linha;

            int numeroArquivo = i + 1;
            errosHG.add("\nArquivo: " + numeroArquivo);
            errosDT.add("\nArquivo: " + numeroArquivo);
            errosHL.add("\nArquivo: " + numeroArquivo);
            errosTL.add("\nArquivo: " + numeroArquivo);
            errosTG.add("\nArquivo: " + numeroArquivo);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"))) {

                while ((linha = br.readLine()) != null) {
                    int linhaTotal = linha.length();
                    if (1200 == linhaTotal) {
                        String valorLinha = linha.substring(0, 1);
                        switch (valorLinha) {
                            case "0":
                                HeaderGeralArquivo hga = new HeaderGeralArquivo(linha);
                                hga.validarSessao();
                                errosHG = new ArrayList<String>();
                                errosHG.add(hga.getQuantErrosHG());
                                break;

                            case "1":
                                HeaderLote hl = new HeaderLote(linha);
                                hl.validarSessao();
                                //TODO instanciar arraylist aqui
                                errosHL.add(hl.getQuantErrosHL());
                                break;

                            case "2":
                                Detalhe dt = new Detalhe(linha);
                                dt.validarSessao();
                                errosDT.add(dt.getQuantErrosDt());
                                break;

                            case "3":
                                TraillerLote tl = new TraillerLote(linha);
                                tl.validarSessao();
                                errosTL.add(tl.getQuantErrosTL());
                                break;

                            case "9":
                                TraillerGeral tg = new TraillerGeral(linha);
                                tg.validarSessao();
                                errosTG.add(tg.getQuantErrosTG());
                                break;

                            default:
                                errosLinha.add("\nErro no arquivo " + numeroArquivo +
                                        ": Tipo Registro não apresenta " +
                                        "um valor válido. Valor apresentado: " + valorLinha);

                        }
                    } else {
                        errosLinha.add("\nERRO no arquivo " + numeroArquivo + ": na linha "
                                + br.readLine() + "\n com " + linhaTotal
                                + " caracteres, esperava-se 1200.\n");


                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.err.println("Erro ao abrir o arquivo");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                System.err.println("Erro ao abrir o arquivo");
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Erro ao abrir o arquivo");
            }

        }
        if (!errosLinha.isEmpty()) {
            System.out.println("\nLinha(s) não será(ão) validada(s). " + errosLinha);
        }


    }

    public void opcoesMenu() {

        Menu menu = new Menu();
        menu.exibirSegundoMenu();

        Scanner ler = new Scanner(System.in);
        int escolha = ler.nextInt();

        do {
            if (escolha == 1) {

                menu.exibirTerceiroMenu();
                int escolha1 = ler.nextInt();
                switch (escolha1) {
                    case 1:
                        for (Object s : errosHG) {
                            System.out.println(s);
                        }


                        continue;

                    case 2:
                        for (Object s : errosHL) {
                            System.out.println(s);
                        }

                        continue;

                    case 3:
                        for (Object s : errosDT) {
                            System.out.println(s);
                        }

                        continue;

                    case 4:
                        for (Object s : errosTL) {
                            System.out.println(s);
                        }

                        continue;

                    case 5:
                        for (Object s : errosTG) {
                            System.out.println(s);
                        }

                        continue;

                    case 6:

                        System.out.println("\nErros nas Linhas: " + errosLinha);
                        System.out.println("\nErros do Header Geral: " + errosHG);
                        System.out.println("\nErros do Header Lote: " + errosHL);
                        System.out.println("\nErros do Detalhe: " + errosDT);
                        System.out.println("\nErros do Trailler Lote: " + errosTL);
                        System.out.println("\nErros do Trailler Geral: " + errosTG);

                        continue;

                    case 0:
                        System.exit(0);

                    default:
                        System.out.println("Opção inválida, tente novamente: ");

                }

            } else if (escolha == 2) {
                System.exit(2);

            } else if (escolha == 3) {
                menu.exibirPrimeiroMenu();
                String caminho2 = ler.next();
                abrirArquivos(caminho2);
                executarArquivos();
            } else {
                System.out.println("Você informou uma opção inválida!");
                break;
            }

        } while (escolha == 2 || escolha == 1);

    }
}


