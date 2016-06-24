package fdi.ucm.server.model.finder.kernel;

/**
 * 
 * @author Joaquin Gayoso-Cabada
 * Formula Negativa
 */
public class FormulaNOT extends Formula {

	private static final long serialVersionUID = -3944187927128675254L;
	private Formula f;
	
	public FormulaNOT() {
	}

	/**
	 * @param formula
	 */
	public FormulaNOT(Formula formula) {
		super();
		this.f = formula;
	}

	/**
	 * @return the formula
	 */
	public Formula getFormula() {
		return f;
	}

	/**
	 * @param formula the formula to set
	 */
	public void setFormula(Formula formula) {
		this.f = formula;
	}
	
}
