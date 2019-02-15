package ai.nexo.produtosapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ai.nexo.produtosapi.model.Categoria;
import ai.nexo.produtosapi.model.Produto;
import ai.nexo.produtosapi.repository.CategoriaRepository;
import ai.nexo.produtosapi.repository.ProdutoRepository;

@SpringBootApplication
public class ProdutosApiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProdutosApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 =  new Produto(null, "Computador", 2000.00);
		Produto p2 =  new Produto(null, "Impressora", 800.00);
		Produto p3 =  new Produto(null, "Mouse", 80.00);
		
		//categorias cat1 é do produto p1, p2 p3
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		
		//produto p3 é da categoria cat1
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	
	}

}

