package fdi.ucm.server.model.finder.kernel;

/**
 * 
 * @author Joaquin Gayoso-Cabada
 * Formula Negativa
 */
public class FormulaNOT extends Formula {

	private static final long serialVersionUID = -3944187927128675254L;
	private Formula formula;
	
	public FormulaNOT() {
	}

	/**
	 * @param formula
	 */
	public FormulaNOT(Formula formula) {
		super();
		this.formula = formula;
	}

	/**
	 * @return the formula
	 */
	public Formula getFormula() {
		return formula;
	}

	/**
	 * @param formula the formula to set
	 */
	public void setFormula(Formula formula) {
		this.formula = formula;
	}
	
}
