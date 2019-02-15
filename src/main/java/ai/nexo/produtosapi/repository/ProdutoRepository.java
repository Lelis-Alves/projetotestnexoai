package ai.nexo.produtosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ai.nexo.produtosapi.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
