package br.com.ecomp.md;

/**
 * Clusters de s�ries temporais
 * 
 * @author David Alain
 */

public class Cluster {
	
	public int id;
	public Amostra[] amostras;
	
	public Cluster cluster1;
	public Cluster cluster2;
	public double distancia;
	
	/**
	 * Verifica se � um cluster simples, ou seja, possui apenas uma s�rie temporal, ou � um cluster que agrupa mais de uma s�rie (um grupo).
	 * @return true se for um cluster simples
	 */
	public boolean isClusterSimples(){
		return (this.cluster1 == null);
	}
	
	/**
	 * Cria um cluster simples atrav�s de uma amostra de s�rie temporal
	 * @param id Identifica��o do cluster
	 * @param amostra Amostra de s�rie temporal
	 */
	public Cluster(int id, Amostra amostra){
		this.id = id;
		this.amostras = new Amostra[1];
		this.amostras[0] = amostra;
	}
	
//	public Cluster(int id, Cluster cluster, Amostra amostra, double distanciaEntreClusters){
//		this.id = id;
//		this.distancia = distanciaEntreClusters;
//		this.amostras = new Amostra[cluster.amostras.length + 1];
//		this.amostras[0] = amostra;
//		for(int i = 1 ; i < this.amostras.length ; ++i){
//			this.amostras[i] = cluster.amostras[i - 1];
//		}
//	}
	
	/**
	 * Cria um cluster que agrupa dois outros clusters
	 * @param id Identifica��o do cluster
	 * @param cluster1 Cluster a ser agrupado
	 * @param cluster2 Cluster a ser agrupado
	 * @param distanciaEntreClusters Distancia euclidiana entre os dois clusters
	 */
	public Cluster(int id, Cluster cluster1, Cluster cluster2, double distanciaEntreClusters){
		
		this.id = id;
		this.distancia = distanciaEntreClusters;
		
		this.amostras = new Amostra[cluster1.amostras.length + cluster2.amostras.length];
		
		int i = 0;
		for(; i < cluster1.amostras.length ; ++i){
			this.amostras[i] = cluster1.amostras[i];
		}
		for(int j = 0 ; j < cluster2.amostras.length ; ++j, ++i){
			this.amostras[i] = cluster2.amostras[j];
		}
		
		this.cluster1 = cluster1;
		this.cluster2 = cluster2;
	}
	

}
