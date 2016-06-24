package fdi.ucm.server.model.finder.kernel;
/**
 * 
 */

/**
 * @author Joaquin Gayoso-Cabada
 * Formula Base
 */
public class FormulaEV extends Formula {

	private static final long serialVersionUID = 1631979871344616552L;
	private Long id;
	private String v;
	
	public FormulaEV() {
		id=0l;
		v="";
	}
	
	/**
	 * @param attribute
	 * @param valor
	 */
	public FormulaEV(Long attribute, String valor) {
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
