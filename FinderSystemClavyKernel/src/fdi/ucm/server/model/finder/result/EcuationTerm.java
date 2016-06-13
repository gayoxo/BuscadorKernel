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
	private List<ATerm> PTerm;
	private List<ATerm> NTerm;
	
	public EcuationTerm() {
		PTerm=new ArrayList<ATerm>();
		NTerm=new ArrayList<ATerm>();
	}

	/**
	 * @param pTerm
	 * @param nTerm
	 */
	public EcuationTerm(List<ATerm> pTerm, List<ATerm> nTerm) {
		super();
		PTerm = pTerm;
		NTerm = nTerm;
	}

	/**
	 * @return the pTerm
	 */
	public List<ATerm> getPTerm() {
		return PTerm;
	}

	/**
	 * @param pTerm the pTerm to set
	 */
	public void setPTerm(List<ATerm> pTerm) {
		PTerm = pTerm;
	}

	/**
	 * @return the nTerm
	 */
	public List<ATerm> getNTerm() {
		return NTerm;
	}

	/**
	 * @param nTerm the nTerm to set
	 */
	public void setNTerm(List<ATerm> nTerm) {
		NTerm = nTerm;
	}
	
	
}
