package br.com.xbrain.vendasteste.vendas.repository;

import br.com.xbrain.vendasteste.vendas.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository extends JpaRepository<Venda, Long>{
}
