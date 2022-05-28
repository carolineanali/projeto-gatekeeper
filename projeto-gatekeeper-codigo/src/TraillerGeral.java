import java.util.ArrayList;

public class TraillerGeral {

//Trailler Geral

    private String tipRegTG;
    private String qtdCartArq;
    private String brancos5;
    private ArrayList quantErrosTG = new ArrayList<>();
    private ArrayList quantOkTG = new ArrayList<>();

    public TraillerGeral(String linhaArquivo) {
        this.tipRegTG = linhaArquivo.substring(0, 1);
        this.qtdCartArq = linhaArquivo.substring(1, 8);
        this.brancos5 = linhaArquivo.substring(8, 1200);
    }

    public String getTipRegTG() {
        return tipRegTG;
    }

    public void setTipRegTG(String tipRegT) {
        this.tipRegTG = tipRegTG;
    }

    public String getQtdCartArq() {
        return qtdCartArq;
    }

    public void setQtdCartArq(String qtdCartArq) {
        this.qtdCartArq = qtdCartArq;
    }

    public String getBrancos5() {
        return brancos5;
    }

    public void setBrancos5(String brancos5) {
        this.brancos5 = brancos5;
    }

    public ArrayList getQuantErrosTG() {
        return quantErrosTG;
    }

    public void setQuantErrosTG(ArrayList quantErrosTG) {
        this.quantErrosTG = quantErrosTG;
    }

    public ArrayList getQuantOkTG() {
        return quantOkTG;
    }

    public void setQuantOkTG(ArrayList quantOkTG) {
        this.quantOkTG = quantOkTG;
    }

    public void validarSessao() {
        boolean x = Validador.validaInteiro(getTipRegTG());
        if (x == false) {
            quantErrosTG.add("Erro no Trailler Geral, Campo: TipRegTG.");

        } else {
            quantOkTG.add("Trailler Geral: TipRegTG validado com sucesso!");

        }

        boolean y = Validador.validaInteiro(getQtdCartArq());
        if (y == false) {
            quantErrosTG.add("Erro no Trailler Geral, Campo: QtdCartArq.");

        } else {
            quantOkTG.add("Trailler Geral: QtdCartArq validado com sucesso!");

        }
    }
}