package br.com.senaccompadrao.entidade;

import java.io.Serializable;

public abstract class Veiculo implements Serializable {

    protected Integer id;
    protected String tipo;
    protected String modelo;
    protected String fabricante;
    protected String placa;
    protected double valor;
    protected double ipva;
    protected String renavan;

    public Veiculo() {
    }

    public Veiculo(Integer id, String tipo, String modelo,
            String fabricante, String placa, double valor, double ipva, String renavan) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.placa = placa;
        this.valor = valor;
        this.ipva = ipva;
        this.renavan = renavan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getIpva() {
        return ipva;
    }

    public void setIpva(double ipva) {
        this.ipva = ipva;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

}
