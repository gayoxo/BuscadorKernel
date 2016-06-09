package fdi.ucm.model.finder.kernel;
/**
 * 
 */

/**
 * @author Joaquin Gayoso-Cabada
 * Formula Base
 */
public class FormulaEV extends Formula {

	private static final long serialVersionUID = 1631979871344616552L;
	private Long Attribute;
	private String Valor;
	
	public FormulaEV() {
		Attribute=0l;
		Valor="";
	}
	
	/**
	 * @param attribute
	 * @param valor
	 */
	public FormulaEV(Long attribute, String valor) {
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
