package servico;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entidade.RetornoCalculadora;

@Path("calculadora")//dereciona
public class Calculadora {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String Ola() {
		return "Testando";
	}
	
	@GET
	@Path("/somar")
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadora somar(@QueryParam("valor1") double valor1, @QueryParam("valor2") double valor2) {
		RetornoCalculadora retorno = new RetornoCalculadora();
		retorno.setCodigoRetorno(0);
		retorno.setValorRetorno(valor1 + valor2);
		retorno.setMensagemRetorno("Sucesso!!");
		return retorno;
	}
	
	@GET
	@Path("/subtrair")
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadora subtrair(@QueryParam("valor1") double valor1, @QueryParam("valor2") double valor2) {
		RetornoCalculadora retorno = new RetornoCalculadora();
		retorno.setCodigoRetorno(0);
		retorno.setValorRetorno(valor1 - valor2);
		retorno.setMensagemRetorno("Sucesso!!");
		return retorno;
	}
	
	@GET
	@Path("/multiplicar")
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadora multiplicar(@QueryParam("valor1") double valor1, @QueryParam("valor2") double valor2) {
		RetornoCalculadora retorno = new RetornoCalculadora();
		retorno.setCodigoRetorno(0);
		retorno.setValorRetorno(valor1 * valor2);
		retorno.setMensagemRetorno("Sucesso!!");
		return retorno;
	}
	
	@GET
	@Path("/dividir")
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoCalculadora dividir(@QueryParam("valor1") double valor1, @QueryParam("valor2") double valor2) {
		RetornoCalculadora retorno = new RetornoCalculadora();
		if (valor2 != 0) {
			retorno.setCodigoRetorno(0);
			retorno.setMensagemRetorno("Sucesso!!");
			retorno.setValorRetorno(valor1 / valor2);
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemRetorno("Erro Dividendo nÃ£o pode ser igual a ZERO!!");
		}
		return retorno;
	}
}
