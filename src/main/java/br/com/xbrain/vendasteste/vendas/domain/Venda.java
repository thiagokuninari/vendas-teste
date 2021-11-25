package br.com.xbrain.vendasteste.vendas.domain;

import br.com.xbrain.vendasteste.vendas.dto.VendaDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Venda {

    private BigDecimal valorVenda;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idVenda;

    private LocalDate dataVenda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVendedor")
    private Vendedor vendedor;

    public Venda() {
    }

    public static Venda from(VendaDto dto){
        Venda venda = new Venda();
        venda.setDataVenda(dto.getDataDaVenda());
        venda.setValorVenda(dto.getValorDaVenda());
        return venda;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
