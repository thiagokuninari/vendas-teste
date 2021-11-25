package br.com.xbrain.vendasteste.vendas.controller;

import br.com.xbrain.vendasteste.vendas.dto.VendaDto;
import br.com.xbrain.vendasteste.vendas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public void salvarVenda(@RequestBody @Valid VendaDto dto) {
        vendaService.criarVenda(dto);

    }
}
