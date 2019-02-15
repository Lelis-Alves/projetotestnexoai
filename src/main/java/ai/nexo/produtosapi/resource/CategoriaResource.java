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
import ai.nexo.produtosapi.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository categoriaRepository; 

	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);;
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public Categoria cadastrarCategoria(@RequestBody @Valid Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	@DeleteMapping()
	public Categoria deletarCategoria(@RequestBody Categoria categoria) {
		categoriaRepository.delete(categoria);
		return categoria;
	}
	
	

	
}