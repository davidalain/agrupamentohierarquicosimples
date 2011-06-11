package util;

import java.util.LinkedList;
import java.util.List;

public class Util {

	
	public static double[] converterDados(String dados){
		
		String[] valores = dados.split(" ");
		List<Double> listaValoresDouble = new LinkedList<Double>();
		for(int i = 0 ; i < valores.length ; ++i){
			if(!valores[i].equals("")){
				listaValoresDouble.add(Double.parseDouble(valores[i]));
			}
		}
		
		double[] retorno = new double[listaValoresDouble.size()];
		for(int i = 0 ; i < retorno.length ; ++i){
			retorno[i] = listaValoresDouble.get(i);
		}
		
		return retorno;
	}
}
