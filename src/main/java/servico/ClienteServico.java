package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
		if(clienteDAO.existeCliente(cliente) == null) {
			if(cliente.getListaContatos() !=null && cliente.getListaContatos().size() > 0) {
				for(Contato contato: cliente.getListaContatos()) {
					contato.setCliente(cliente);
				}
			}
			clienteDAO.inserirCliente(cliente);
		}else {
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
	
	
//	@Override
//	public RetornoCleiente adicionarContatoCliente(Cliente cliente) {
//		RetornoCleiente retorno = new RetornoCleiente();
//		retorno.setCodigoRetorno(0);
//		retorno.setMensagemRetorno("Conta");
//
//		if (existe(cliente) != null) {
//			if (jaTem(contato) == null) {
//				this.listaContato.add(contato);
//			} else {
//				retorno.setCodigoRetorno(1);
//				retorno.setMensagemRetorno("FALHA: Contato já existe!!!");
//			}
//		} else {
//			retorno.setCodigoRetorno(1);
//			retorno.setMensagemRetorno("FALHA: Não existe cliente!!!");
//		}
//		return retorno;
//
//	}
//
//	@Override
//	public RetornoCleiente removerContatoCliente(Cliente cliente) {
//		RetornoCleiente retorno = new RetornoCleiente();
//		retorno.setCodigoRetorno(0);
//		retorno.setMensagemRetorno("Contatos adcionado");
//
//		if (existe(cliente) != null) {
//			if (jaTem(contato) != null) {
//				this.listaContato.remove(contato);
//			} else {
//				retorno.setCodigoRetorno(1);
//				retorno.setMensagemRetorno("FALHA: Contato já existe!!!");
//			}
//		} else {
//			retorno.setCodigoRetorno(1);
//			retorno.setMensagemRetorno("FALHA: Não existe cliente!!!");
//		}
//		return retorno;
//	}

}
