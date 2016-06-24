/**
 * 
 */
package fdi.ucm.server.model.finder.kernel;

/**
 * @author Joaquin Gayoso-Cabada
 * Formula OR
 */
public class FormulaAND extends Formula {


	private static final long serialVersionUID = -953542119960452097L;
	private Formula f1;
	private Formula f2;
	
	public FormulaAND() {
	}

	
	
	/**
	 * @param formula1
	 * @param formula2
	 */
	public FormulaAND(Formula formula1, Formula formula2) {
		super();
		this.f1 = formula1;
		this.f2 = formula2;
	}



	/**
	 * @return the formula1
	 */
	public Formula getFormula1() {
		return f1;
	}

	/**
	 * @param formula1 the formula1 to set
	 */
	public void setFormula1(Formula formula1) {
		this.f1 = formula1;
	}

	/**
	 * @return the formula2
	 */
	public Formula getFormula2() {
		return f2;
	}

	/**
	 * @param formula2 the formula2 to set
	 */
	public void setFormula2(Formula formula2) {
		this.f2 = formula2;
	}
	
	
}
