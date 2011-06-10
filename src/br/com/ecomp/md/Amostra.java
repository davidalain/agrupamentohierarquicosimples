package br.com.ecomp.md;

import util.Util;

public class Amostra {
	
	public int id;
	public double[] dados;
	
	public Amostra(int id, double[] dados){
		this.id = id;
		this.dados = dados;
	}
	
	public Amostra(int id, String dados){
		this.id = id;
		this.dados = Util.converterDados(dados);
	}
	

}
