package br.com.xbrain.vendasteste.vendas.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class Vendedor {

    @Column(nullable = false)
    private String nomeVendedor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idVendedor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor", orphanRemoval = true)
    private List<Venda> vendas;

    public Vendedor() {
    }

    public Vendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Vendedor(String nomeVendedor, Long idVendedor) {
        this.nomeVendedor = nomeVendedor;
        this.idVendedor = idVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
