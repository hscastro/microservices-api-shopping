package com.ms.hscastro.entities;

import java.util.Date;
import com.ms.hscastro.dto.UserDTO;


public class User {

	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String endereco;
	
	private String email;
	
	private String telefone;
	
	private Date dataCadastro;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
		
	public User(Long id, String nome, String cpf, String endereco, String email, String telefone, Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
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
	
	public static User convertToDTO(UserDTO userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setNome(userDto.getNome());
		user.setCpf(userDto.getCpf());
		user.setEndereco(userDto.getEndereco());
		user.setEmail(userDto.getEmail());		
		user.setTelefone(userDto.getTelefone());
		user.setDataCadastro(userDto.getDataCadastro());
		return user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
