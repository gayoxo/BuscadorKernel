package fdi.ucm.server.model.finder.reduce;

import com.google.gson.Gson;

import fdi.ucm.server.model.finder.kernel.Formula;
import fdi.ucm.server.model.finder.kernel.FormulaAND;
import fdi.ucm.server.model.finder.kernel.FormulaEV;
import fdi.ucm.server.model.finder.kernel.FormulaNOT;
import fdi.ucm.server.model.finder.kernel.FormulaOR;
import fdi.ucm.server.model.finder.result.ATerm;
import fdi.ucm.server.model.finder.result.Ecuation;
import fdi.ucm.server.model.finder.result.EcuationTerm;

public class Normalize {


	public static String normalizeIt(Formula entrada)
	{
//	ArrayList<Ecuation> Salida = new ArrayList<Ecuation>();
	
	
	Ecuation Salida=norma(entrada);

//	if (Salida.isEmpty())
//		return null;
	
	Gson gson = new Gson();
    String jsonString = gson.toJson(Salida);
   // System.out.println("JSON: " + jsonString);      
	return jsonString;	
	}

	

	
	




	private static Ecuation norma(Formula formulaIn) {
		if (formulaIn instanceof FormulaEV)
		{
			FormulaEV Act=(FormulaEV)formulaIn;
			ATerm newT=new ATerm(Act.getAttribute(), Act.getValor());
			EcuationTerm T=new EcuationTerm();
			T.getPTerm().add(newT);
			Ecuation E=new Ecuation();
			E.getPartesEcuacion().add(T);
			return E;
			
		}else if (formulaIn instanceof FormulaOR)
		{
			FormulaOR Act=(FormulaOR)formulaIn;
			Ecuation entrada1 = norma(Act.getFormula1());
			Ecuation entrada2= norma(Act.getFormula2());
			entrada1.getPartesEcuacion().addAll(entrada2.getPartesEcuacion());
			return entrada1;

			
		}else if (formulaIn instanceof FormulaAND)
		{
			FormulaAND Act=(FormulaAND)formulaIn;
			Ecuation E1 = norma(Act.getFormula1());
			Ecuation E2 = norma(Act.getFormula2());
			Ecuation SalidaT=comb(E1,E2);
			return SalidaT;
			
		}else if (formulaIn instanceof FormulaNOT)
		{
			FormulaNOT Act=(FormulaNOT)formulaIn;
			Formula ActN=Act.getFormula();
			if (ActN instanceof FormulaEV)
			{
				FormulaEV ActInt=(FormulaEV)ActN;
				ATerm newT=new ATerm(ActInt.getAttribute(), ActInt.getValor());
				EcuationTerm T=new EcuationTerm();
				T.getNTerm().add(newT);
				Ecuation E=new Ecuation();
				E.getPartesEcuacion().add(T);
				return E;
			}else if (ActN instanceof FormulaNOT)
			{
				FormulaNOT ActInt2=(FormulaNOT)ActN;
				Ecuation E=norma(ActInt2.getFormula());
				return E;
			}
			else  if (ActN instanceof FormulaAND)
			{
				FormulaAND ActInt=(FormulaAND)ActN;
				FormulaNOT nueva1=new FormulaNOT(ActInt.getFormula1());
				FormulaNOT nueva2=new FormulaNOT(ActInt.getFormula2());
				Ecuation entrada1 =norma(nueva1);
				Ecuation entrada2 =norma(nueva2);
				entrada1.getPartesEcuacion().addAll(entrada2.getPartesEcuacion());
				return entrada1;
				
			}else if (ActN instanceof FormulaOR)
			{
				FormulaOR ActInt=(FormulaOR)ActN;
				FormulaNOT nueva1=new FormulaNOT(ActInt.getFormula1());
				FormulaNOT nueva2=new FormulaNOT(ActInt.getFormula2());
				Ecuation E1=norma(nueva1);
				Ecuation E2=norma(nueva2);
				Ecuation SalidaT=comb(E1,E2);
				return SalidaT;
			}
				
			
			
		}
		
		return new Ecuation();
	}









	private static Ecuation comb(Ecuation e1, Ecuation e2) {
		Ecuation nueva=new Ecuation();

				for (EcuationTerm ecuation1Part : e1.getPartesEcuacion()) {
					for (EcuationTerm ecuation2Part : e2.getPartesEcuacion()) {
						EcuationTerm nuevo=new EcuationTerm();
						nueva.getPartesEcuacion().add(nuevo);
						for (ATerm term1 : ecuation1Part.getPTerm()) {
							nuevo.getPTerm().add(term1);
						}
						for (ATerm term2 : ecuation2Part.getPTerm()) {
							if (!nuevo.getPTerm().contains(term2))
								nuevo.getPTerm().add(term2);
						}
						for (ATerm term1 : ecuation1Part.getNTerm()) {
							nuevo.getNTerm().add(term1);
						}
						for (ATerm term2 : ecuation2Part.getNTerm()) {
							if (!nuevo.getNTerm().contains(term2))
								nuevo.getNTerm().add(term2);
						}

				
			}
		}
		return nueva;
	}









}
