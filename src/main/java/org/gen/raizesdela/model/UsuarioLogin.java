package org.gen.raizesdela.model;

public class UsuarioLogin {
private long id;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String token;
	
	private boolean tipoVendedor;
	
	private boolean tipoAdministrador;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean getTipoVendedor() {
		return tipoVendedor;
	}
	public void setTipoVendedor(boolean tipoVendedor) {
		this.tipoVendedor = tipoVendedor;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean isTipoAdministrador() {
		return tipoAdministrador;
	}

	public void setTipoAdministrador(boolean tipoAdministrador) {
		this.tipoAdministrador = tipoAdministrador;
	}
}
