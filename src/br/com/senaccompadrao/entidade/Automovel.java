package br.com.senaccompadrao.entidade;

public class Automovel extends Veiculo {

    private String numeroPorta;

    public Automovel() {
        tipo = "Automóvel";
    }

    public Automovel(Integer id, String numeroPorta, String modelo, String fabricante, String placa,
            double valor, double ipva, String renavan) {
        super(id, "Automóvel", modelo, fabricante, placa,
                valor, ipva, renavan);
        this.numeroPorta = numeroPorta;
    }

    public String getNumeroPorta() {
        return numeroPorta;
    }

    public void setNumeroPorta(String numeroPorta) {
        this.numeroPorta = numeroPorta;
    }

}
