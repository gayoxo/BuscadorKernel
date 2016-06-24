/**
 * 
 */
package fdi.ucm.server.model.finder.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joaquin Gayoso-Cabada
 * Ecuacion General
 */
public class Ecuation implements Serializable{

	private static final long serialVersionUID = 3111145466048154044L;
	private List<EcuationTerm> le;
	
	public Ecuation() {
		le=new ArrayList<EcuationTerm>();
	}

	/**
	 * @param partesEcuacion
	 */
	public Ecuation(List<EcuationTerm> partesEcuacion) {
		super();
		this.le = partesEcuacion;
	}

	/**
	 * @return the partesEcuacion
	 */
	public List<EcuationTerm> getPartesEcuacion() {
		return le;
	}

	/**
	 * @param partesEcuacion the partesEcuacion to set
	 */
	public void setPartesEcuacion(List<EcuationTerm> partesEcuacion) {
		this.le = partesEcuacion;
	}
	
	
}
