package br.com.xbrain.vendasteste.vendas.service;

import br.com.xbrain.vendasteste.vendas.domain.Vendedor;
import br.com.xbrain.vendasteste.vendas.dto.RelatorioDto;
import br.com.xbrain.vendasteste.vendas.dto.VendedorDto;
import br.com.xbrain.vendasteste.vendas.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;


    public List<RelatorioDto> getRelatorio(LocalDate dataInicio, LocalDate dataFim){
        List<Vendedor> vendedores = repository.findByData(dataInicio, dataFim);

        long totalDias = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;

        return vendedores.stream().map(vendedor ->
                new RelatorioDto(vendedor.getNomeVendedor(), vendedor.getVendas().size(), (double) vendedor.getVendas().size() / totalDias))
                .collect(Collectors.toList());

    }

    public List<VendedorDto> findAll() {
        return repository.findAll().stream()
                .map(vendedor -> new VendedorDto(vendedor.getNomeVendedor(), vendedor.getIdVendedor()))
                .collect(Collectors.toList());
    }

    public VendedorDto findById(Long id) {
        Vendedor vendedor = repository.findById(id).get();
        return new VendedorDto(vendedor.getNomeVendedor(), vendedor.getIdVendedor());
    }

    public void salvar(VendedorDto dto) {
        Vendedor vendedor = new Vendedor(dto.getNome());
        repository.save(vendedor);
    }

    public void alterar(VendedorDto vendedor) {
        Vendedor vendedor1 = repository.findById(vendedor.getId()).get();
        vendedor1.setNomeVendedor(vendedor.getNome());

        repository.save(vendedor1);
    }

    public void deletar(Long id) {
        Vendedor vendedor = repository.findById(id).get();

        repository.delete(vendedor);
    }
}