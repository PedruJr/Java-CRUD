package br.com.senaccompadrao.entidade;

public class Onibus extends Veiculo {

    private String qtdAcento;

    public Onibus() {
        tipo = "Ônibus";
    }

    public Onibus(Integer id, String qtdAcento, String modelo, String fabricante, String placa, double valor, double ipva, String renavan) {
        super(id, "Ônibus", modelo, fabricante, placa, valor, ipva, renavan);
        this.qtdAcento = qtdAcento;
    }

    public String getQtdAcento() {
        return qtdAcento;
    }

    public void setQtdAcento(String qtdAcento) {
        this.qtdAcento = qtdAcento;
    }
}
