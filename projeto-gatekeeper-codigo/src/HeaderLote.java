import java.util.ArrayList;

public class HeaderLote {
    private String tipReg;
    private String modeloPlastico;
    private String numeroKit;
    private String seqLote;
    private String nomePlastico;
    private String tipoProcessamento;
    private String tipoMovimento;
    private String tipoCartao;
    private String tipoGravacao;
    private String corEntintamento;
    private String tipoEnvelopamento;
    private String tipoEnderecamento;
    private String etiquetaBloqueio;
    private String overlay;
    private String postagem;
    private String brancos;
    private ArrayList quantErrosHL = new ArrayList<String>();
    private ArrayList quantOkHL = new ArrayList<String>();

    public HeaderLote(String linhaArquivo) {

        this.tipReg =  linhaArquivo.substring(0, 1);
        this.modeloPlastico = linhaArquivo.substring(1, 4);
        this.numeroKit = linhaArquivo.substring(4, 10);
        this.seqLote = linhaArquivo.substring(10, 14);
        this.nomePlastico = linhaArquivo.substring(14, 34);
        this.tipoProcessamento = linhaArquivo.substring(34,36);
        this.tipoMovimento = linhaArquivo.substring(36, 38);
        this.tipoCartao = linhaArquivo.substring(38, 40);
        this.tipoGravacao = linhaArquivo.substring(40, 42);
        this.corEntintamento = linhaArquivo.substring(42, 44);
        this.tipoEnvelopamento = linhaArquivo.substring(44, 46);
        this.tipoEnderecamento = linhaArquivo.substring(46, 48);
        this.etiquetaBloqueio = linhaArquivo.substring(48,50);
        this.overlay = linhaArquivo.substring(50, 52);
        this.postagem = linhaArquivo.substring(52, 54);
        this.brancos = linhaArquivo.substring(54,1200);
    }

    public String getTipReg() {
        return tipReg;
    }

    public void setTipReg(String tipReg) {
        this.tipReg = tipReg;
    }

    public String getModeloPlastico() {
        return modeloPlastico;
    }

    public void setModeloPlastico(String modeloPlastico) {
        this.modeloPlastico = modeloPlastico;
    }

    public String getNumeroKit() {
        return numeroKit;
    }

    public void setNumeroKit(String numeroKit) {
        this.numeroKit = numeroKit;
    }

    public String getSeqLote() {
        return seqLote;
    }

    public void setSeqLote(String seqLote) {
        this.seqLote = seqLote;
    }

    public String getNomePlastico() {
        return nomePlastico;
    }

    public void setNomePlastico(String nomePlastico) {
        this.nomePlastico = nomePlastico;
    }

    public String getTipoProcessamento() {
        return tipoProcessamento;
    }

    public void setTipoProcessamento(String tipoProcessamento) {
        this.tipoProcessamento = tipoProcessamento;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(String tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    public String getTipoGravacao() {
        return tipoGravacao;
    }

    public void setTipoGravacao(String tipoGravacao) {
        this.tipoGravacao = tipoGravacao;
    }

    public String getCorEntintamento() {
        return corEntintamento;
    }

    public void setCorEntintamento(String corEntintamento) {
        this.corEntintamento = corEntintamento;
    }

    public String getTipoEnvelopamento() {
        return tipoEnvelopamento;
    }

    public void setTipoEnvelopamento(String tipoEnvelopamento) {
        this.tipoEnvelopamento = tipoEnvelopamento;
    }

    public String getTipoEnderecamento() {
        return tipoEnderecamento;
    }

    public void setTipoEnderecamento(String tipoEnderecamento) {
        this.tipoEnderecamento = tipoEnderecamento;
    }

    public String getEtiquetaBloqueio() {
        return etiquetaBloqueio;
    }

    public void setEtiquetaBloqueio(String etiquetaBloqueio) {
        this.etiquetaBloqueio = etiquetaBloqueio;
    }

    public String getOverlay() {
        return overlay;
    }

    public void setOverlay(String overlay) {
        this.overlay = overlay;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public String getBrancos() {
        return brancos;
    }

    public void setBrancos(String brancos) {
        this.brancos = brancos;
    }

    public ArrayList getQuantErrosHL() {
        return quantErrosHL;
    }

    public void setQuantErrosHL(ArrayList quantErrosHL) {
        this.quantErrosHL = quantErrosHL;
    }

    public ArrayList getQuantOkHL() {
        return quantOkHL;
    }

    public void setQuantOkHL(ArrayList quantOkHL) {
        this.quantOkHL = quantOkHL;
    }

    public void validarSessao() {
        boolean a = Validador.validaInteiro(getTipReg());
        if (a == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: TipReg.");

        } else {
            quantOkHL.add("Header Lote: TipReg validado com sucesso!");

        }

        boolean b = Validador.validaInteiro(getModeloPlastico());
        if (b == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: ModeloPlastico.");

        } else {
            quantOkHL.add("Header Lote: ModeloPlastico validado com sucesso!");

        }

        boolean c = Validador.validaInteiro(getSeqLote());
        if (c == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: SeqLote.");

        } else {
            quantOkHL.add("Header Lote: SeqLote validado com sucesso!");

        }

        boolean d = Validador.validaInteiro(getTipoProcessamento());
        if (d == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: TipoProcessamento.");

        } else {
            quantOkHL.add("Header Lote: TipoProcessamento validado com sucesso!");

        }

        boolean e = Validador.validaInteiro(getTipoMovimento());
        if (e == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: TipoMovimento.");

        } else {
            quantOkHL.add("Header Lote: TipoMovimento validado com sucesso!");

        }

        boolean f = Validador.validaInteiro(getTipoCartao());
        if (f == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: TipoCartao.");

        } else {
            quantOkHL.add("Header Lote: TipoCartao validado com sucesso!");

        }

        boolean g = Validador.validaInteiro(getTipoEnvelopamento());
        if (g == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: TipoEnvelopamento.");

        } else {
            quantOkHL.add("Header Lote: TipoEnvelopamento validado com sucesso!");

        }

        boolean h = Validador.validaInteiro(getTipoEnderecamento());
        if (h == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: TipoEnderecamento.");

        } else {
            quantOkHL.add("Header Lote: TipoEnderecamento validado com sucesso!");

        }

        boolean i = Validador.validaInteiro(getEtiquetaBloqueio());
        if (i == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: EtiquetaBloqueio.");

        } else {
            quantOkHL.add("Header Lote: EtiquetaBloqueio validado com sucesso!");

        }

        boolean j = Validador.validaInteiro(getOverlay());
        if (j == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: Overlay.");

        } else {
            quantOkHL.add("Header Lote: Overlay validado com sucesso!");

        }

        boolean k = Validador.validaInteiro(getPostagem());
        if (k == false) {
            quantErrosHL.add("Erro no Header Lote, Campo: Postagem.");

        } else {
            quantOkHL.add("Header Lote: Postagem validado com sucesso!");

        }
    }
}

