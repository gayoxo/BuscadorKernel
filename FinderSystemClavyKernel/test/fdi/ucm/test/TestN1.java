/**
 * 
 */
package fdi.ucm.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import fdi.ucm.model.finder.kernel.FormulaAND;
import fdi.ucm.model.finder.kernel.FormulaEV;
import fdi.ucm.model.finder.kernel.FormulaNOT;
import fdi.ucm.model.finder.kernel.FormulaOR;
import fdi.ucm.model.finder.reduce.Normalize;

/**
 * @author Joaquin Gayoso-Cabada
 *
 */
public class TestN1 {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEV() {
		FormulaEV Entrada=new FormulaEV(0l, "test");
		String Salida=Normalize.normalizeIt(Entrada);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("EVTest->"+Salida);
	}
	
	@Test
	public void testNOT() {
		FormulaEV Entrada=new FormulaEV(0l, "test");
		FormulaNOT Not=new FormulaNOT(Entrada);
		String Salida=Normalize.normalizeIt(Not);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("NOTTest->"+Salida);
	}
	
	@Test
	public void testAND() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaAND And=new FormulaAND(Entrada1,Entrada2);
		String Salida=Normalize.normalizeIt(And);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("ANDTest->"+Salida);
	}
	
	@Test
	public void testOR() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaOR Or=new FormulaOR(Entrada1,Entrada2);
		String Salida=Normalize.normalizeIt(Or);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("ORTest->"+Salida);
	}
	
	
}
