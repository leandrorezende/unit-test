package br.ce.wcaquino.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraTest {
	private Calculadora calc;
	public static StringBuffer ordem = new StringBuffer();
	@Before
	public void setUp() {
		calc = new Calculadora();
		System.out.println("iniciando 1 ...");
		ordem.append("1");
	}
	
	@After
	public void tearDown() {
		System.out.println("finalizando 1 ...");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println(ordem.toString());
	}
	
	@Test
	public void deveSomarDoisValore() {
		//cenario
		int a = 5;
		int b = 3;
		
		//acao
		int resultado = calc.somar(a,b);
		
		//verficacao
		Assert.assertEquals(8, resultado);
	}
	
	@Test
	public void deveSubtrairDoisValores() {
		//cenario
		int a = 4;
		int b = 2;
		
		//acao
		int resultado = calc.subtrair(a, b);
		
		//verificacao
		Assert.assertEquals(2, resultado);
	}
	
	@Test 
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		//cenario
		int a = 6;
		int b = 3;
		
		//acao
		int resultado = calc.divide(a, b);
		
		//verificacao
		Assert.assertEquals(2, resultado);
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		int a = 10;
		int b = 0;
		
		calc.divide(a, b);
	}
	
	@Test
	public void deveDividirDoisNumeros() {
		String a = "4";
		String b = "2";
		
		int result = new Calculadora().divide(a, b);
		
		Assert.assertEquals(2, result);
	}
}
