package com.quarkus.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoAPI {

	@GET
	public List<Produto> list(){
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Cerveja Brahma", BigDecimal.TEN));
		return produtos;
	}
	
	@POST
	//@Transactional
	public Response cria(ProdutoDTO produtoDTO) {
		Produto p = new Produto(produtoDTO.getNome(), produtoDTO.getValor());
	    //p.persist();
		return Response.status(Status.CREATED).build();
	
	}
	
	@PUT
	@Path("{id}")
	//@Transactional
	public void atualiza(@PathParam("id") Long id, ProdutoDTO produtoDTO) {
		//Optional<Produto> optional = Produto.findByIdOptional(id);
		
		//if (optional.isPresent()) {
		//	Produto p = optional.get();
		//	p.setNome(produtoDTO.getNome());
		//	p.setValor(produtoDTO.getValor());
		//	p.persist();
		// } else {
		//	 throw new NotFoundException();
		// } 
	}
	
	@DELETE
	@Path("{id}")
	//@Transactional
	public void delete(@PathParam("id") Long id) {
		// Optional<Produto> optional = Produto.findByIdOptional(id);
		
		// optional.ifPresentOrElse(Produto::delete, () -> {
		//	throw new NotFoundException();
	//	});
		
	}
}
