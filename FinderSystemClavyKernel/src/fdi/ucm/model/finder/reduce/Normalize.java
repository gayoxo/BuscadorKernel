package fdi.ucm.model.finder.reduce;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import fdi.ucm.model.finder.kernel.Formula;
import fdi.ucm.model.finder.kernel.FormulaAND;
import fdi.ucm.model.finder.kernel.FormulaEV;
import fdi.ucm.model.finder.kernel.FormulaNOT;
import fdi.ucm.model.finder.kernel.FormulaOR;
import fdi.ucm.model.finder.result.ATerm;
import fdi.ucm.model.finder.result.Ecuation;
import fdi.ucm.model.finder.result.EcuationTerm;

public class Normalize {


	public static String normalizeIt(Formula entrada)
	{
	ArrayList<Ecuation> Salida = new ArrayList<Ecuation>();
	
	
	norma(entrada,Salida);

	if (Salida.isEmpty())
		return null;
	
	Gson gson = new Gson();
    String jsonString = gson.toJson(Salida);
   // System.out.println("JSON: " + jsonString);      
	return jsonString;	
	}

	

	
	




	private static ArrayList<Ecuation> norma(Formula formulaIn, ArrayList<Ecuation> entrada) {
		if (formulaIn instanceof FormulaEV)
		{
			FormulaEV Act=(FormulaEV)formulaIn;
			ATerm newT=new ATerm(Act.getAttribute(), Act.getValor());
			EcuationTerm T=new EcuationTerm();
			T.getPTerm().add(newT);
			Ecuation E=new Ecuation();
			E.getPartesEcuacion().add(T);
			entrada.add(E);
			
		}else if (formulaIn instanceof FormulaOR)
		{
			FormulaOR Act=(FormulaOR)formulaIn;
			norma(Act.getFormula1(),entrada);
			norma(Act.getFormula2(),entrada);
		}else if (formulaIn instanceof FormulaAND)
		{
			FormulaAND Act=(FormulaAND)formulaIn;
			ArrayList<Ecuation> E1=new ArrayList<Ecuation>();
			ArrayList<Ecuation> E2=new ArrayList<Ecuation>();
			norma(Act.getFormula1(), E1);
			norma(Act.getFormula2(), E2);
			List<Ecuation> SalidaT=comb(E1,E2);
			entrada.addAll(SalidaT);
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
				entrada.add(E);
				return entrada;
			}else if (ActN instanceof FormulaNOT)
			{
				FormulaNOT ActInt2=(FormulaNOT)ActN;
				norma(ActInt2.getFormula(), entrada);
			}
			else  if (ActN instanceof FormulaAND)
			{
				FormulaAND ActInt=(FormulaAND)ActN;
				FormulaNOT nueva1=new FormulaNOT(ActInt.getFormula1());
				FormulaNOT nueva2=new FormulaNOT(ActInt.getFormula2());
				norma(nueva1,entrada);
				norma(nueva2,entrada);
				
			}else if (ActN instanceof FormulaOR)
			{
				FormulaOR ActInt=(FormulaOR)ActN;
				ArrayList<Ecuation> E1=new ArrayList<Ecuation>();
				ArrayList<Ecuation> E2=new ArrayList<Ecuation>();
				FormulaNOT nueva1=new FormulaNOT(ActInt.getFormula1());
				FormulaNOT nueva2=new FormulaNOT(ActInt.getFormula2());
				norma(nueva1, E1);
				norma(nueva2, E2);
				List<Ecuation> SalidaT=comb(E1,E2);
				entrada.addAll(SalidaT);
			}
				
			
			
		}
		
		return entrada;
	}









	private static List<Ecuation> comb(ArrayList<Ecuation> e1, ArrayList<Ecuation> e2) {
		List<Ecuation> Salida=new ArrayList<Ecuation>();
		Ecuation nueva=new Ecuation();
		Salida.add(nueva);
		for (Ecuation ecuation1 : e1) {
			for (Ecuation ecuation2 : e2) {
				for (EcuationTerm ecuation1Part : ecuation1.getPartesEcuacion()) {
					for (EcuationTerm ecuation2Part : ecuation2.getPartesEcuacion()) {
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
				
			}
		}
		return Salida;
	}









}
