package br.com.ecomp.md;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Agrupamento {

	/**
	 * Calcula a distancia euclidiana entre duas amostras de séries temporais
	 * @param a1
	 * @param a2
	 * @return
	 */
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

	private double distanciaCluster(Cluster c1, Cluster c2){

		double dist = Double.MAX_VALUE;

		for(int i = 0 ; i < c1.amostras.length ; ++i){
			for(int j = 0 ; j < c2.amostras.length ; ++j){
				
				if(!c1.amostras[i].equals(c2.amostras[j])){

					double distAmostras = this.distanciaEuclidiana(c1.amostras[i],c2.amostras[j]);
					if(distAmostras < dist ){
						dist = distAmostras;
					}
				}
			}
		}

		return dist;
	}

	public Cluster[] agruparClusterMaisProximo(int id, Cluster[] clusters){

		Cluster[] resultado = new Cluster[clusters.length - 1];

		int iProximo = -1,jProximo = -1;
		double menorDistancia = Double.MAX_VALUE;

		for(int i = 0 ; i < clusters.length ; ++i){
			for(int j = 0 ; j < clusters.length ; ++j){

				if(i != j){

					double distClusters = this.distanciaCluster(clusters[i],clusters[j]);
					if(distClusters < menorDistancia){
						menorDistancia = distClusters;
						iProximo = i;
						jProximo = j;
					}
				}

			}
		}

		resultado[0] = new Cluster(id, clusters[iProximo],clusters[jProximo],menorDistancia);
		System.out.println("Agrupou em "+id+" os cluster: "+clusters[iProximo].id + " e " +clusters[jProximo].id);

		for(int i = 1 , j = 0; i < resultado.length ; ++j){
			if(j != iProximo && j != jProximo){
				resultado[i] = clusters[j];
				i++;
			}
		}

		return resultado;
	}

	public Cluster agrupar(Amostra[] amostras){

		Cluster[] clustersIniciais = new Cluster[amostras.length];
		int id = 0;
		for( ; id < clustersIniciais.length ; ++id){
			clustersIniciais[id] = new Cluster(id, amostras[id]);
		}

		Cluster[] clustersMaisProximos = this.agruparClusterMaisProximo(id, clustersIniciais);
		while(clustersMaisProximos.length > 1){
			//System.out.println("Faltam " + clustersMaisProximos.length + " clusters");
			clustersMaisProximos = this.agruparClusterMaisProximo(++id, clustersMaisProximos);
		}

		return clustersMaisProximos[0];
	}
	
	public Cluster[] agrupar(Amostra[] amostras, int quantidadeClusters){

		Cluster[] clustersIniciais = new Cluster[amostras.length];
		int id = 0;
		for( ; id < clustersIniciais.length ; ++id){
			clustersIniciais[id] = new Cluster(id, amostras[id]);
		}

		Cluster[] clustersMaisProximos = this.agruparClusterMaisProximo(id, clustersIniciais);
		while(clustersMaisProximos.length > quantidadeClusters){
			//System.out.println("Faltam " + clustersMaisProximos.length + " clusters");
			clustersMaisProximos = this.agruparClusterMaisProximo(++id, clustersMaisProximos);
		}

		return clustersMaisProximos;
	}

	public static void main(String[] args) throws IOException {

		File f = new File("base_dados/synthetic_control.data");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);

		List<Amostra> amostrasList = new LinkedList<Amostra>();
		int id = 0;

		String linha = null;
		while( (linha = br.readLine()) != null){
			amostrasList.add(new Amostra(id++, linha));
		}

		System.out.println("Leu amostras");

		fr.close();
		br.close();

		Amostra[] amostras = new Amostra[amostrasList.size()];
		for(id = 0 ; id < amostras.length ; ++id){
			amostras[id] = amostrasList.get(id);
		}

		Agrupamento ag = new Agrupamento();
		Cluster mestre = ag.agrupar(amostras);

		System.out.println("fim");

	}




}
