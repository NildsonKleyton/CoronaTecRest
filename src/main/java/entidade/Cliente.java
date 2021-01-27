package entidade;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
//atributos
	@Id
	@Column(name = "CPF", nullable = false)
	private String cpf ;
	@Column(name = "NOME", nullable = false)
	private String nome;
	@Column(name = "SEXO", nullable = false)
	private String sexo;
	@Column(name = "INTERESSES")
	private String interesses;
	@Column(name = "IDADE", nullable = false)
	private int idade;
	private List<Contato> contato;
	
//get set 	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getInteresses() {
		return interesses;
	}

	public void setInteresses(String interesses) {
		this.interesses = interesses;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Contato> getContato() {
		return contato;
	}

	public void setContato(List<Contato> contato) {
		this.contato = contato;
	}


	
}
