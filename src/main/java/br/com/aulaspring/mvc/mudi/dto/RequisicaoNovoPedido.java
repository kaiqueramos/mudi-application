package br.com.aulaspring.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.aulaspring.mvc.mudi.model.Pedido;
import br.com.aulaspring.mvc.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {
	
	@NotBlank
	public String nomeProduto;
	
	@NotBlank
	public String urlProduto;
	
	@NotBlank
	public String urlImagem;
	
	public String descricaoPedido;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricaoPedido() {
		return descricaoPedido;
	}
	public void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
	}
	public Pedido toPedido() {
		Pedido ped = new Pedido();
		ped.setNomeProduto(nomeProduto);
		ped.setUrlProduto(urlProduto);
		ped.setUrlImagem(urlImagem);
		ped.setDescricaoPedido(descricaoPedido);
		ped.setStatus(StatusPedido.AGUARDANDO);
		return ped;
	}
	
}
