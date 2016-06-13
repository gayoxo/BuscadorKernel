/**
 * 
 */
package fdi.ucm.server.model.finder.kernel;

/**
 * @author Joaquin Gayoso-Cabada
 * Formula AND
 */
public class FormulaOR extends Formula {


	private static final long serialVersionUID = -953542119960452097L;
	private Formula formula1;
	private Formula formula2;
	
	public FormulaOR() {
	}

	
	
	/**
	 * @param formula1
	 * @param formula2
	 */
	public FormulaOR(Formula formula1, Formula formula2) {
		super();
		this.formula1 = formula1;
		this.formula2 = formula2;
	}



	/**
	 * @return the formula1
	 */
	public Formula getFormula1() {
		return formula1;
	}

	/**
	 * @param formula1 the formula1 to set
	 */
	public void setFormula1(Formula formula1) {
		this.formula1 = formula1;
	}

	/**
	 * @return the formula2
	 */
	public Formula getFormula2() {
		return formula2;
	}

	/**
	 * @param formula2 the formula2 to set
	 */
	public void setFormula2(Formula formula2) {
		this.formula2 = formula2;
	}
	
	
}
