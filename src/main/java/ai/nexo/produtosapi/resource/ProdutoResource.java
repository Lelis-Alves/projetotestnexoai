package ai.nexo.produtosapi.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ai.nexo.produtosapi.model.Categoria;
import ai.nexo.produtosapi.model.Produto;
import ai.nexo.produtosapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtosRepository; 

	@GetMapping
	public List<Produto> listar() {
		return produtosRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Optional<Produto> obj = produtosRepository.findById(id);;
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public Produto cadastrarProduto(@RequestBody @Valid Produto produto) {
		return produtosRepository.save(produto);
	}
	
	@DeleteMapping()
	public Produto deletarProduto(@RequestBody Produto produto) {
		produtosRepository.delete(produto);
		return produto;
	}
	
	
	
	

	
}