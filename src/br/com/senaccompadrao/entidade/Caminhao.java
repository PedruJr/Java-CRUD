package br.com.senaccompadrao.entidade;

public class Caminhao extends Veiculo {

    private String qtdEixo;

    public Caminhao() {
        tipo = "Caminhão";
    }

    public Caminhao(Integer id, String qtdEixo, String modelo, String fabricante,
            String placa, double valor, double ipva, String renavan) {

        super(id, "Caminhão", modelo, fabricante, placa, valor, ipva, renavan);
        this.qtdEixo = qtdEixo;
    }

    public String getQtdEixo() {
        return qtdEixo;

    }

    public void setQtdEixo(String qtdEixo) {
        this.qtdEixo = qtdEixo;
    }
}
