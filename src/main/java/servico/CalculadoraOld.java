package servico;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("calculadoraold")//dereciona
public class CalculadoraOld {

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
	
	@GET
	@Path("/subtrair")//direciona 
	@Produces(MediaType.TEXT_PLAIN)
	public String subtrair(@QueryParam("valor1")double valor1,
						@QueryParam("valor2") double valor2 ) {
		return "Resultato: " +(valor1 - valor2) ;
	}
	
	@GET
	@Path("/multiplicar")//direciona 
	@Produces(MediaType.TEXT_PLAIN)
	public String multiplicar(@QueryParam("valor1")double valor1,
						@QueryParam("valor2") double valor2 ) {
		return "Resultato: " +(valor1 * valor2) ;
	}
	
	@GET
	@Path("/dividir")//direciona 
	@Produces(MediaType.TEXT_PLAIN)
	public String dividir(@QueryParam("valor1")double valor1,
						@QueryParam("valor2") double valor2 ) {
		return "Resultato: " +(valor1 / valor2) ;
	}
}
