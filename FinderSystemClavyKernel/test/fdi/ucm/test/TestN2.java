/**
 * 
 */
package fdi.ucm.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fdi.ucm.server.model.finder.kernel.FormulaAND;
import fdi.ucm.server.model.finder.kernel.FormulaEV;
import fdi.ucm.server.model.finder.kernel.FormulaNOT;
import fdi.ucm.server.model.finder.kernel.FormulaOR;
import fdi.ucm.server.model.finder.reduce.Normalize;

/**
 * @author Joaquin Gayoso-Cabada
 *
 */
public class TestN2 {

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
	public void test2NivelesANDNOT() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaNOT Not=new FormulaNOT(Entrada1);
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaAND And=new FormulaAND(Not,Entrada2);
		String Salida=Normalize.normalizeIt(And);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("ANDNOTTest->"+Salida);
	}
	
	@Test
	public void test2NivelesANDAND() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaAND And1=new FormulaAND(Entrada1,Entrada2);
		FormulaAND And2=new FormulaAND(And1,Entrada3);
		String Salida=Normalize.normalizeIt(And2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("ANDANDTest->"+Salida);
	}
	
	@Test
	public void test2NivelesORNOT() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaNOT Not=new FormulaNOT(Entrada1);
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaOR Or=new FormulaOR(Not,Entrada2);
		String Salida=Normalize.normalizeIt(Or);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("ORNOTTest->"+Salida);
	}
	
	@Test
	public void test2NivelesOROR() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaOR Or1=new FormulaOR(Entrada1,Entrada2);
		FormulaOR Or2=new FormulaOR(Or1,Entrada3);
		String Salida=Normalize.normalizeIt(Or2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("ORORTest->"+Salida);
	}
	
	@Test
	public void test2NivelesNOTNOT() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaNOT Not1=new FormulaNOT(Entrada1);
		FormulaNOT Not2=new FormulaNOT(Not1);
		String Salida=Normalize.normalizeIt(Not2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("NOTNOTTest->"+Salida);
	}
	
	@Test
	public void test2NivelesNOTAND() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaAND And1=new FormulaAND(Entrada1,Entrada2);
		FormulaNOT Not2=new FormulaNOT(And1);
		String Salida=Normalize.normalizeIt(Not2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("NOTANDTest->"+Salida);
	}
	
	@Test
	public void test2NivelesNOTOR() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaOR Or1=new FormulaOR(Entrada1,Entrada2);
		FormulaNOT Not2=new FormulaNOT(Or1);
		String Salida=Normalize.normalizeIt(Not2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("NOTORTest->"+Salida);
	}
	
}
