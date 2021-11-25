package br.com.xbrain.vendasteste.vendas.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaDto {

    private Long id;
    @NotNull
    private BigDecimal valorDaVenda;
    @NotNull
    private LocalDate dataDaVenda;
    @NotNull
    private Long vendedorId;

    public VendaDto() {
    }

    public VendaDto(Long id, BigDecimal valorDaVenda, LocalDate dataDaVenda, Long vendedorId) {
        this.id = id;
        this.valorDaVenda = valorDaVenda;
        this.dataDaVenda = dataDaVenda;
        this.vendedorId = vendedorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorDaVenda() {
        return valorDaVenda;
    }

    public void setValorDaVenda(BigDecimal valorDaVenda) {
        this.valorDaVenda = valorDaVenda;
    }

    public LocalDate getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(LocalDate dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public Long getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Long vendedorId) {
        this.vendedorId = vendedorId;
    }
}
