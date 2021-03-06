package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONTATO")
public class Contato {
//atributos
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "S_CONTATO")
	@SequenceGenerator(name = "S_CONTATO", sequenceName = "S_CONTATO", allocationSize = 1)
	private int id;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	@Column(name = "TELEFONE", nullable = false)
	private String telefone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPF_CLIENTE", referencedColumnName = "CPF" ,nullable = false )
	private Cliente cliente;
	
//get set				
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
