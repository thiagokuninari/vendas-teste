package br.com.xbrain.vendasteste.vendas.dto;

public class RelatorioDto {

    private String nomeVendedor;
    private Integer totalVendas;
    private double mediaDeVendasDiaria;

    public RelatorioDto() {
    }

    public RelatorioDto(String nomeVendedor, Integer totalVendas, double mediaDeVendasDiaria) {
        this.nomeVendedor = nomeVendedor;
        this.totalVendas = totalVendas;
        this.mediaDeVendasDiaria = mediaDeVendasDiaria;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Integer getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(Integer totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getMediaDeVendasDiaria() {
        return mediaDeVendasDiaria;
    }

    public void setMediaDeVendasDiaria(double mediaDeVendasDiaria) {
        this.mediaDeVendasDiaria = mediaDeVendasDiaria;
    }
}
