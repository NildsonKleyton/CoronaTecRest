package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Cliente;
import entidade.Contato;

public class TesteConexao {

	public static void main(String[] args) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction t = ent.getTransaction();
		t.begin();

		Contato cont = new Contato();
		cont.setEmail("teste1@teste.com");
		cont.setTelefone("(81) 98877-6655");
		
		ent.persist(cont);
		
		Cliente c = new Cliente(); 
		c.setNome("Testador 1");
		c.setCpf("789.789.789-01");
		c.setIdade(99);
		c.setSexo("Testelino");
		c.setInteresses("Testando");

		
		ent.persist(c);
		
		t.commit();
		ent.close();

	}

}
