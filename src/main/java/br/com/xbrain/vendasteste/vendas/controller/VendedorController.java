package br.com.xbrain.vendasteste.vendas.controller;

import br.com.xbrain.vendasteste.vendas.dto.RelatorioDto;
import br.com.xbrain.vendasteste.vendas.dto.VendedorDto;
import br.com.xbrain.vendasteste.vendas.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping("/relatorio")
    public List<RelatorioDto> getRelatorio(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
       return service.getRelatorio(dataInicio, dataFim);
    }

    @GetMapping
    public List<VendedorDto> findAll() {
        return service.findAll();

    }
    @GetMapping("{id}")
    public VendedorDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public void salvar(@RequestBody @Valid VendedorDto dto) {
       service.salvar(dto);
    }

    @PutMapping
    public void alterar(@RequestBody @Valid VendedorDto dto){
        service.alterar(dto);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
