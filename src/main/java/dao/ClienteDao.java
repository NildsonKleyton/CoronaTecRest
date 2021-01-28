package dao;

import java.util.List;

import entidade.Cliente;

public interface ClienteDao {

	public boolean inserirCliente(Cliente cliente);
	
	public List<Cliente> pesquisarCliente(Cliente cliente);
	
	public boolean adicionarContatoCliente(Cliente cliente);
	
	public boolean removerContatoCliente(Cliente cliente);
	
	public Cliente existeCliente(Cliente cliente);

}