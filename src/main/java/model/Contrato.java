package model;

public class Contrato {

    private int id;
    private int id_cliente;
    private int id_imovel;
    private double valor;
    private String data_inicio;
    private String data_fim;
    private Boolean ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_inicio(){
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim(){
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) { this.id_cliente = id_cliente; }

    public int getId_imovel() {
        return id_imovel;
    }

    public void setId_imovel(int id_imovel) { this.id_imovel = id_imovel; }


}
