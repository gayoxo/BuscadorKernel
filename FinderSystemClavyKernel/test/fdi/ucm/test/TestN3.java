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
public class TestN3 {

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
	public void test3NivelesAND_AND_AND() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaEV Entrada4=new FormulaEV(4l, "test4");
		FormulaAND And1=new FormulaAND(Entrada1,Entrada2);
		FormulaAND And2=new FormulaAND(Entrada3,Entrada4);
		FormulaAND And3=new FormulaAND(And1,And2);
		String Salida=Normalize.normalizeIt(And3);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("AND_AND_ANDTest->"+Salida);
	}
	
	@Test
	public void test3NivelesAND_OR_AND() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaEV Entrada4=new FormulaEV(4l, "test4");
		FormulaAND And1=new FormulaAND(Entrada1,Entrada2);
		FormulaOR Or1=new FormulaOR(Entrada3,Entrada4);
		FormulaAND And2=new FormulaAND(And1,Or1);
		String Salida=Normalize.normalizeIt(And2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("AND_OR_ANDTest->"+Salida);
	}
	
	@Test
	public void test3NivelesAND_OR_OR() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaEV Entrada4=new FormulaEV(4l, "test4");
		FormulaOR Or2=new FormulaOR(Entrada1,Entrada2);
		FormulaOR Or1=new FormulaOR(Entrada3,Entrada4);
		FormulaAND And2=new FormulaAND(Or2,Or1);
		String Salida=Normalize.normalizeIt(And2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("AND_OR_ORTest->"+Salida);
	}
	
	@Test
	public void test3NivelesAND_NOT_NOT() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaNOT not1=new FormulaNOT(Entrada1);
		FormulaNOT not2=new FormulaNOT(Entrada2);
		FormulaAND And2=new FormulaAND(not1,not2);
		String Salida=Normalize.normalizeIt(And2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("AND_NOT_NOTTest->"+Salida);
	}
	
	@Test
	public void test3NivelesOR_AND_AND() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaEV Entrada4=new FormulaEV(4l, "test4");
		FormulaAND And1=new FormulaAND(Entrada1,Entrada2);
		FormulaAND And2=new FormulaAND(Entrada3,Entrada4);
		FormulaOR Or1=new FormulaOR(And1,And2);
		String Salida=Normalize.normalizeIt(Or1);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("OR_AND_ANDTest->"+Salida);
	}
	
	@Test
	public void test3NivelesOR_AND_OR() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaEV Entrada4=new FormulaEV(4l, "test4");
		FormulaAND And1=new FormulaAND(Entrada1,Entrada2);
		FormulaAND Or1=new FormulaAND(Entrada3,Entrada4);
		FormulaOR Or2=new FormulaOR(And1,Or1);
		String Salida=Normalize.normalizeIt(Or2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("OR_AND_ORTest->"+Salida);
	}
	
	@Test
	public void test3NivelesOR_OR_OR() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaEV Entrada4=new FormulaEV(4l, "test4");
		FormulaAND Or3=new FormulaAND(Entrada1,Entrada2);
		FormulaAND Or1=new FormulaAND(Entrada3,Entrada4);
		FormulaOR Or2=new FormulaOR(Or3,Or1);
		String Salida=Normalize.normalizeIt(Or2);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("OR_OR_ORTest->"+Salida);
	}
	
	@Test
	public void test3NivelesOR_NOT_NOT() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaNOT not1=new FormulaNOT(Entrada1);
		FormulaNOT not2=new FormulaNOT(Entrada2);
		FormulaOR or1=new FormulaOR(not1,not2);
		String Salida=Normalize.normalizeIt(or1);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("AND_NOT_NOTTest->"+Salida);
	}
	
	@Test
	public void test3NivelesNOT_AND_AND() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaAND And1=new FormulaAND(Entrada1,Entrada2);
		FormulaAND And2=new FormulaAND(Entrada3,And1);
		FormulaNOT not1=new FormulaNOT(And2);
		String Salida=Normalize.normalizeIt(not1);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("NOT_AND_ANDTest->"+Salida);
	}
	
	@Test
	public void test3NivelesNOT_AND_OR() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaOR or1=new FormulaOR(Entrada1,Entrada2);
		FormulaAND and1=new FormulaAND(Entrada3,or1);
		FormulaNOT not1=new FormulaNOT(and1);
		String Salida=Normalize.normalizeIt(not1);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("NOT_AND_ORTest->"+Salida);
	}
	
	@Test
	public void test3NivelesNOT_OR_OR() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaEV Entrada2=new FormulaEV(2l, "test2");
		FormulaEV Entrada3=new FormulaEV(3l, "test3");
		FormulaOR or1=new FormulaOR(Entrada1,Entrada2);
		FormulaOR or2=new FormulaOR(Entrada3,or1);
		FormulaNOT not1=new FormulaNOT(or2);
		String Salida=Normalize.normalizeIt(not1);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("NOT_OR_ORTest->"+Salida);
	}
	
	@Test
	public void test3NivelesNOT_NOT_NOT() {
		FormulaEV Entrada1=new FormulaEV(1l, "test1");
		FormulaNOT not2=new FormulaNOT(Entrada1);
		FormulaNOT not3=new FormulaNOT(not2);
		FormulaNOT not1=new FormulaNOT(not3);
		String Salida=Normalize.normalizeIt(not1);
		assertNotNull(Salida);
		assertTrue(Salida,!Salida.isEmpty());
		System.out.println("NOT_NOT_NOTTest->"+Salida);
	}
}
