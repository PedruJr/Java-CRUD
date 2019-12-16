package br.com.senaccompadrao.entidade;

public class Moto extends Veiculo {

    private String potencia;

    public Moto() {
        tipo = "Moto";
    }

    public Moto(Integer id, String potencia, String modelo, String fabricante,
            String placa, double valor, double ipva, String renavan) {
        super(id, "Moto", modelo, fabricante, placa, valor, ipva, renavan);
        this.potencia = potencia;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }
}
