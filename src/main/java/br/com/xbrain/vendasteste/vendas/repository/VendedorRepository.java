package br.com.xbrain.vendasteste.vendas.repository;

import br.com.xbrain.vendasteste.vendas.domain.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT DISTINCT v FROM Vendedor v LEFT JOIN FETCH v.vendas ve WHERE ve.dataVenda BETWEEN ?1 AND ?2")
    List<Vendedor> findByData(LocalDate dataInicio, LocalDate dataFim);

}
