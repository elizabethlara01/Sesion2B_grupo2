package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {
	float ventaMes;
	float horasExtras;
	TipoEmpleado encargado, vendedor; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ventaMes=0;
		horasExtras=0;
		encargado=TipoEmpleado.Encargado;
		vendedor=TipoEmpleado.Vendedor;
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculoNominaBruta() {
		
		float expected=2500;
		float actual=Empleado.calculoNominaBruta(encargado,ventaMes,horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaNeta() {
		
		float expected=2000;
		float actual=Empleado.calculoNominaBruta(vendedor, ventaMes, horasExtras);
		assertEquals(expected,actual);
	}
	
	@Test
	void testCalculoNominaBrutaEncargado() {
		float expected=2500;
		float actual=Empleado.calculoNominaBruta(encargado,ventaMes,horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaVendedor() {
		float expected=2000;
		float actual=Empleado.calculoNominaBruta(vendedor,ventaMes,horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaOtro() {
		float expected=-1;
		float actual=Empleado.calculoNominaBruta(null,ventaMes,horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaVentaMesNegativa() {
		float expected=-1;
		float actual=Empleado.calculoNominaBruta(encargado, -1, horasExtras);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaBrutaVentaMesMenorMil() {
		float expected=2000;
		float actual=Empleado.calculoNominaBruta(vendedor, 999, horasExtras);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaBrutaVentaMesEntre1000y1500(){
		float expected=2600;
		float actual=Empleado.calculoNominaBruta(encargado, 1000,horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaVentaMesMayor2500() {
		float expected=2200;
		float actual=Empleado.calculoNominaBruta(vendedor, 1600, horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaHorasExtrasPositivas() {
		float expected=2530;
		float actual=Empleado.calculoNominaBruta(encargado, 0, 1);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaHorasExtrasNegativas() {
		float expected=-1;
		float actual=Empleado.calculoNominaBruta(encargado, 0, -1);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaNetaNegativa() {
		float expected=-1;
		float actual=Empleado.calculoNominaNeta(-1);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaNetaMenos2100() {
		float expected=2000;
		float actual=Empleado.calculoNominaNeta(2000);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		float expected=1870;
		float actual=Empleado.calculoNominaNeta(2200);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaNetaMayor2500() {
		float expected=2132;
		float actual=Empleado.calculoNominaNeta(2600);
		assertEquals(expected,actual);
	}

}