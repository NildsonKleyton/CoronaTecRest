package dao;

import entidade.Cliente;

public interface ClienteDao {

	public boolean inserirCliente(Cliente cliente);
	public Cliente pesquisarCliente(Cliente cliente);
	public boolean adicionarContatoCliente(Cliente cliente);
	public boolean removerContatoCliente(Cliente cliente);

}