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
	float ventaMes,ventaMesNegativo;
	float horasExtras,horasExtrasNegativo;
	float nominaBruta;
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
		ventaMesNegativo=-1;
		horasExtras=0;
		horasExtrasNegativo=-1;
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
		float actual=Empleado.calculoNominaBruta(encargado, ventaMesNegativo, horasExtras);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaBrutaVentaMesMenorMil() {
		ventaMes=999;
		float expected=2000;
		float actual=Empleado.calculoNominaBruta(vendedor, ventaMes, horasExtras);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaBrutaVentaMesEntre1000y1500(){
		ventaMes=1000;
		float expected=2600;
		float actual=Empleado.calculoNominaBruta(encargado, ventaMes,horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaVentaMesMayor2500() {
		ventaMes=2600;
		float expected=2200;
		float actual=Empleado.calculoNominaBruta(vendedor, ventaMes, horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaHorasExtrasPositivas() {
		horasExtras=1;
		float expected=2530;
		float actual=Empleado.calculoNominaBruta(encargado, ventaMes, horasExtras);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaBrutaHorasExtrasNegativas() {
		float expected=-1;
		float actual=Empleado.calculoNominaBruta(encargado, ventaMes, horasExtrasNegativo);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaNetaNegativa() {
		nominaBruta=-1;
		float expected=-1;
		float actual=Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaNetaMenos2100() {
		nominaBruta=2000;
		float expected=2000;
		float actual=Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected, actual);
	}
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		nominaBruta=2200;
		float expected=1870;
		float actual=Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected,actual);
	}
	@Test
	void testCalculoNominaNetaMayor2500() {
		nominaBruta=2600;
		float expected=2132;
		float actual=Empleado.calculoNominaNeta(nominaBruta);
		assertEquals(expected,actual);
	}

}