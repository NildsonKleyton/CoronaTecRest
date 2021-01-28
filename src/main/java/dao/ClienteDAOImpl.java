package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Cliente;
import entidade.Contato;
import util.JpaUtil;

/**
 * @author Nildson Kleyton
 *
 */
public class ClienteDAOImpl implements ClienteDao {

	/**
	 * InseritCliente
	 * 
	 * Cria um objeto tipo cliente contendo CPF como id
	 * 
	 * @param cliente (nome , cpf, sexo, idade, interesses e listaContatos).
	 * 
	 * @return Objeto cliente.
	 */
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
	public List<Cliente> pesquisarCliente(Cliente cliente) {
		String sql = "from Cliente c";

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery(sql);

		List<Cliente> listaClientes = query.getResultList();

		ent.close();

		return listaClientes;
	}

	@Override
	public boolean adicionarContatoCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();

		tx.begin();
		for (Contato contato : cliente.getListaContatos()) {
			ent.merge(contato);
		}


		tx.commit();
		ent.close();
		return true;
	}

	@Override
	public boolean removerContatoCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		
		tx.begin();
		
		for (Contato contato : cliente.getListaContatos()) {
			Contato existe = ent.find(Contato.class, contato.getId());
			if(existe != null) {
				ent.remove(existe);
			}
		}
		
		tx.commit();
		ent.close();
		
		return true;
	}

	/**
	 * Verifica se o cliente a ser Adicionado já existe, atravez de seu CPF.
	 * 
	 */
	@Override
	public Cliente existeCliente(Cliente cliente) {
		EntityManager ent = JpaUtil.getEntityManager();

		Cliente existe = ent.find(Cliente.class, cliente.getCpf());

		ent.close();

		return existe;
	}

}
