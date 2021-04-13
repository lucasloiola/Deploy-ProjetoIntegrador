package org.gen.raizesdela.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@NotNull
	@Size(min=2, max=100)
	private String nome;
	@NotNull
	@Size(min=2, max=200)
	private String email;
	@NotNull
	@Size(min=6, max=100)
	private String senha;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List <Produto> produto;
	
	private boolean tipoVendedor;
	
	private boolean tipoAdministrador;
	
	public boolean getTipoVendedor() {
		return tipoVendedor;
	}
	public void setTipoVendedor(boolean tipoVendedor) {
		this.tipoVendedor = tipoVendedor;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;  
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public boolean isTipoAdministrador() {
		return tipoAdministrador;
	}
	public void setTipoAdministrador(boolean tipoAdministrador) {
		this.tipoAdministrador = tipoAdministrador;
	}
	
}
