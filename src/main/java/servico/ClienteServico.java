package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAOImpl;
import dao.ClienteDao;
import entidade.Cliente;
import entidade.Contato;
import entidade.RetornoCliente;

@Path("/cliente")
public class ClienteServico {

	private ClienteDao clienteDAO = new ClienteDAOImpl();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String texto() {
		return "Serviço Cliente";
	}

	/*
	 * 
	 */
	@POST
	@Path("/inserirCliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente inserirCliente(Cliente cliente) {
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso!!");
		if (clienteDAO.existeCliente(cliente) == null) {
			if (cliente.getListaContatos() != null && cliente.getListaContatos().size() > 0) {
				for (Contato contato : cliente.getListaContatos()) {
					contato.setCliente(cliente);
				}
			}
			clienteDAO.inserirCliente(cliente);
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("FALHA: Cliente já exixte!!");
		}

		return retorno;
	}

	@GET
	@Path("/pesquisarCliente")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente pesquisarCliente(Cliente cliente) {
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso!!");
		retorno.setListaCliente(clienteDAO.pesquisarCliente(cliente));
		return retorno;
	}

	@PUT
	@Path("/adicionarContato")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente adicionarContatoCliente(Cliente cliente) {
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso!!");
		// 1 - verificar se existe o cliente na base
		Cliente clienteBase = clienteDAO.existeCliente(cliente);
		if (clienteBase != null) {
			// 2 - Verificar se existe contatos para serem inseridos
			if (cliente.getListaContatos() != null && cliente.getListaContatos().size() > 0) {
				// 3 - Verifica se existe contato
				boolean existeContato = false;
				for (Contato contato : cliente.getListaContatos()) {
					//cria variável "index" para receber o contato 
					int index = clienteBase.getListaContatos().indexOf(contato);
					if (index != -1) {
						existeContato = true;
					}
				}
				// 4 - Senão existe contato adiciona, se existir contato manda o erro,
				if (!existeContato) {
					//adiciona o contato
					clienteBase.getListaContatos().addAll(cliente.getListaContatos());
				} else {
					retorno.setCodigoRetorno(1);
					retorno.setMensagemRetorno("FALHA: Contato já existente!!!");
				}
			}
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("FALHA: Cliente não exixte!!");
		}

		return retorno;
	}

	@DELETE
	@Path("/removerContato")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente removerContatoCliente(Cliente cliente) {
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemRetorno("Sucesso!!");
		// 1 - verificar se existe o cliente na base
		Cliente clienteBase = clienteDAO.existeCliente(cliente);
		if (clienteBase != null) {
			// 2 - Verificar se existe contatos para serem inseridos
			if (cliente.getListaContatos() != null && cliente.getListaContatos().size() > 0) {
				// 3 - Verifica se existe contato
				for (Contato contato : cliente.getListaContatos()) {
						//remove o contato
						clienteBase.getListaContatos().remove(contato);
				}

			} else {
				retorno.setCodigoRetorno(1);
				retorno.setMensagemRetorno("FALHA: Contato não existente!!!");
			}

		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("FALHA: Cliente não exixte!!");
		}
		return retorno;
	}

}
