package br.com.ecomp.md;

import util.Util;

/**
 * Amostra de série temporal
 * 
 * @author David Alain
 */

public class Amostra {
	
	public int id;
	public double[] dados;
	
	/**
	 * Cria uma amostra de uma série temporal através de um conjunto ordenado de dados contínuos
	 * @param id Identificação da Amostra
	 * @param dados Conjunto ordenado de valores contínuos da série temporal 
	 */
	public Amostra(int id, double[] dados){
		this.id = id;
		this.dados = dados;
	}
	
	/**
	 * Cria uma amostra de uma série temporal através de uma String que contém um conjunto ordenado de dados contínuos
	 * @param id Identificação da Amostra
	 * @param dados String contendo um conjunto ordenado de valores contínuos da série temporal 
	 */
	public Amostra(int id, String dados){
		this.id = id;
		this.dados = Util.converterDados(dados);
	}
	

}
