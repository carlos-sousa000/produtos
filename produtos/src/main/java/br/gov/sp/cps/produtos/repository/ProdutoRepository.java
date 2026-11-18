package br.gov.sp.cps.produtos.repository;

import br.gov.sp.cps.produtos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
