package com.ms.hscastro.dto;

import java.util.Date;

import com.ms.hscastro.entities.User;



public class UserDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Date dataCadastro;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public static UserDTO convertToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setNome(user.getNome());
		userDTO.setCpf(user.getCpf());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setEmail(user.getEmail());		
		userDTO.setTelefone(user.getTelefone());
		userDTO.setDataCadastro(user.getDataCadastro());
		return userDTO;
	}

	
}
