import java.util.ArrayList;

public class TraillerLote {

    private String tipRegT;
    private String modPlastT;
    private String kitT;
    private String qtdCartLote;
    private String brancos4;
    private ArrayList quantErrosTL = new ArrayList<>();
    private ArrayList quantOkTL = new ArrayList<>();

    public TraillerLote(String linhaArquivo) {
        this.tipRegT = linhaArquivo.substring(0, 1);
        this.modPlastT = linhaArquivo.substring(1, 4);
        this.kitT = linhaArquivo.substring(4, 10);
        this.qtdCartLote = linhaArquivo.substring(10, 17);
        this.brancos4 = linhaArquivo.substring(17, 1200);
    }

    public String getTipRegT() {
        return tipRegT;
    }

    public void setTipRegT(String tipRegT) {
        this.tipRegT = tipRegT;
    }

    public String getModPlastT() {
        return modPlastT;
    }

    public void setModPlastT(String modPlastT) {
        this.modPlastT = modPlastT;
    }

    public String getKitT() {
        return kitT;
    }

    public void setKitT(String kitT) {
        this.kitT = kitT;
    }

    public String getQtdCartLote() {
        return qtdCartLote;
    }

    public void setQtdCartLote(String qtdCartLote) {
        this.qtdCartLote = qtdCartLote;
    }

    public String getBrancos4() {
        return brancos4;
    }

    public void setBrancos4(String brancos4) {
        this.brancos4 = brancos4;
    }

    public ArrayList getQuantErrosTL() {
        return quantErrosTL;
    }

    public void setQuantErrosTL(ArrayList quantErrosTL) {
        this.quantErrosTL = quantErrosTL;
    }

    public ArrayList getQuantOkTL() {
        return quantOkTL;
    }

    public void setQuantOkTL(ArrayList quantOkTL) {
        this.quantOkTL = quantOkTL;
    }

    public void validarSessao() {
        boolean x = Validador.validaInteiro(getTipRegT());
        if (x == false) {
            quantErrosTL.add("Erro no Trailler Lote, Campo: TipRegT.");

        } else {
            quantOkTL.add("Trailler Lote: TipRegT validado com sucesso!");

        }

        boolean y = Validador.validaInteiro(getQtdCartLote());
        if (y == false) {
            quantErrosTL.add("Erro no Trailler Lote, Campo: QtdCartLote.");

        } else {
            quantOkTL.add("Trailler Lote: QtdCartLote validado com sucesso!");

        }
    }
}