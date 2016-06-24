package fdi.ucm.server.model.finder.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Joaquin Gayoso-Cabada
 * Ecuacion Basica
 */
public class EcuationTerm implements Serializable{

	private static final long serialVersionUID = 8870884329896048545L;
	private List<ATerm> lp;
	private List<ATerm> ln;
	
	public EcuationTerm() {
		lp=new ArrayList<ATerm>();
		ln=new ArrayList<ATerm>();
	}

	/**
	 * @param pTerm
	 * @param nTerm
	 */
	public EcuationTerm(List<ATerm> pTerm, List<ATerm> nTerm) {
		super();
		lp = pTerm;
		ln = nTerm;
	}

	/**
	 * @return the pTerm
	 */
	public List<ATerm> getPTerm() {
		return lp;
	}

	/**
	 * @param pTerm the pTerm to set
	 */
	public void setPTerm(List<ATerm> pTerm) {
		lp = pTerm;
	}

	/**
	 * @return the nTerm
	 */
	public List<ATerm> getNTerm() {
		return ln;
	}

	/**
	 * @param nTerm the nTerm to set
	 */
	public void setNTerm(List<ATerm> nTerm) {
		ln = nTerm;
	}
	
	
}
