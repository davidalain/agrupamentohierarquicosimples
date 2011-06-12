package br.com.ecomp.md;

import util.Util;

/**
 * Amostra de s�rie temporal
 * 
 * @author David Alain
 */

public class Amostra {
	
	public int id;
	public double[] dados;
	
	/**
	 * Cria uma amostra de uma s�rie temporal atrav�s de um conjunto ordenado de dados cont�nuos
	 * @param id Identifica��o da Amostra
	 * @param dados Conjunto ordenado de valores cont�nuos da s�rie temporal 
	 */
	public Amostra(int id, double[] dados){
		this.id = id;
		this.dados = dados;
	}
	
	/**
	 * Cria uma amostra de uma s�rie temporal atrav�s de uma String que cont�m um conjunto ordenado de dados cont�nuos
	 * @param id Identifica��o da Amostra
	 * @param dados String contendo um conjunto ordenado de valores cont�nuos da s�rie temporal 
	 */
	public Amostra(int id, String dados){
		this.id = id;
		this.dados = Util.converterDados(dados);
	}
	

}
