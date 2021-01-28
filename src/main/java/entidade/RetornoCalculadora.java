package entidade;

//import javax.xml.bind.annotation.XmlRootElement;
/*
 *  @XmlRootElement 
 *  retotrnao um objeto
 */
//@XmlRootElement 
public class RetornoCalculadora {
	
	private int codigoRetrono;//0-Sucesso 1-Falha
	private String mensagemRetorno;
	private double valorRetorno;
	
	
	public int getCodigoRetrono() {
		return codigoRetrono;
	}
	public void setCodigoRetrono(int codigoRetrono) {
		this.codigoRetrono = codigoRetrono;
	}
	public String getMensagemRetorno() {
		return mensagemRetorno;
	}
	public void setMensagemRetorno(String mensagemRetorno) {
		this.mensagemRetorno = mensagemRetorno;
	}
	public double getValorRetorno() {
		return valorRetorno;
	}
	public void setValorRetorno(double valorRetorno) {
		this.valorRetorno = valorRetorno;
	}

	
}
