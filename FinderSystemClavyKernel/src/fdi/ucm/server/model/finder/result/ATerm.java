/**
 * 
 */
package fdi.ucm.server.model.finder.result;

import java.io.Serializable;

/**
 * @author Joaquin Gayoso-Cabada
 * Termino Basico
 */
public class ATerm implements Serializable{


	private static final long serialVersionUID = -3509372566712033447L;
	private Long id;
	private String v;
	
	public ATerm() {
		id=0l;
		v="";
	}

	/**
	 * @param attribute
	 * @param valor
	 */
	public ATerm(Long attribute, String valor) {
		super();
		id = attribute;
		v = valor;
	}

	/**
	 * @return the attribute
	 */
	public Long getAttribute() {
		return id;
	}

	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(Long attribute) {
		id = attribute;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return v;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		v = valor;
	}
	
	
}
