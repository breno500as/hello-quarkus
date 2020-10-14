package com.quarkus.product;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoAPI {

	@GET
	public List<Produto> list(){
		return Produto.listAll();
	}
	
	@POST
	@Transactional
	public void cria(ProdutoDTO produtoDTO) {
		Produto p = new Produto();
		p.setNome(produtoDTO.getNome());
		p.setValor(produtoDTO.getValor());
		Produto.persist(p);
	}
	
	@PUT
	@Path("{id}")
	@Transactional
	public void atualiza(@PathParam("id") Long id, ProdutoDTO produtoDTO) {
		Optional<Produto> optional = Produto.findByIdOptional(id);
		
		if (optional.isPresent()) {
			Produto p = optional.get();
			p.setNome(produtoDTO.getNome());
			p.setValor(produtoDTO.getValor());
			Produto.persist(p);
		} else {
			 throw new NotFoundException();
		} 
	}
	
	@DELETE
	@Path("{id}")
	@Transactional
	public void delete(@PathParam("id") Long id) {
		Optional<Produto> optional = Produto.findByIdOptional(id);
		
		optional.ifPresentOrElse(Produto::delete, () -> {
			throw new NotFoundException();
		});
		 
	
		
	}
}
