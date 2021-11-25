package br.com.xbrain.vendasteste.vendas.service;

import br.com.xbrain.vendasteste.vendas.domain.Venda;
import br.com.xbrain.vendasteste.vendas.domain.Vendedor;
import br.com.xbrain.vendasteste.vendas.dto.VendaDto;
import br.com.xbrain.vendasteste.vendas.dto.VendedorDto;
import br.com.xbrain.vendasteste.vendas.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private VendedorService vendedorService;

    public void criarVenda(VendaDto dto) {
        Venda venda = Venda.from(dto);
        VendedorDto vendedorDto = vendedorService.findById(dto.getVendedorId());
        Vendedor vendedor = new Vendedor(vendedorDto.getNome(), vendedorDto.getId());
        venda.setVendedor(vendedor);
        vendasRepository.save(venda);

    }
}
