package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Cliente;
import util.JpaUtil;

public class ClienteDAOImplementacao implements ClienteDao {

	@Override
	public boolean inserirCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();

		ent.merge(cliente);

		tx.commit();
		ent.close();
		return true;
	}

	@Override
	public Cliente pesquisarCliente(Cliente cliente) {
		
		return null;
	}

	@Override
	public boolean adicionarContatoCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removerContatoCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}



}
