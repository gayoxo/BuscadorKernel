/**
 * 
 */
package fdi.ucm.model.finder.result;

import java.io.Serializable;

/**
 * @author Joaquin Gayoso-Cabada
 * Termino Basico
 */
public class ATerm implements Serializable{


	private static final long serialVersionUID = -3509372566712033447L;
	private Long Attribute;
	private String Valor;
	
	public ATerm() {
		Attribute=0l;
		Valor="";
	}

	/**
	 * @param attribute
	 * @param valor
	 */
	public ATerm(Long attribute, String valor) {
		super();
		Attribute = attribute;
		Valor = valor;
	}

	/**
	 * @return the attribute
	 */
	public Long getAttribute() {
		return Attribute;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(Long attribute) {
		Attribute = attribute;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return Valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		Valor = valor;
	}
	
	
}
