package servico;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("calculadora")//dereciona
public class Calculadora {

	@GET
	@Path("/")//direciona 
	@Produces(MediaType.TEXT_PLAIN)
	public String Ola() {
		return "Testando";
	}
	
	@GET
	@Path("/somar")//direciona 
	@Produces(MediaType.TEXT_PLAIN)
	public String somar(@QueryParam("valor1")double valor1,
						@QueryParam("valor2") double valor2 ) {
		return "Resultato: " +(valor1 + valor2) ;
	}
	
}
