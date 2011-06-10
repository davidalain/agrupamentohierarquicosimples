package br.com.ecomp.md;

public class Agrupamento {
	

	private double distanciaEuclidiana(Amostra a1, Amostra a2){
		
		double dist = 0.0;
		
		if(a1.dados.length != a2.dados.length){
			throw new Error("Vetores com tamanhos distintos");
		}
		
		for(int i = 0 ; i < a1.dados.length ; ++i){
			dist += Math.pow(a1.dados[i] - a2.dados[i],2);
		}
		
		return Math.sqrt(dist);
	}
	
	
}
