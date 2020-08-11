import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
	//========= TESTE 1 =========//	
	int[] a = {1, 2, 3};
	int[] b = {3, 4};
	int[][] query = {{1,5}, {0,0,1}, {1,5}};
	
	int[] resultados = processaQuery(a, b, query);
	imprimirResultados(resultados);
	
	//========= TESTE 2 =========//	
	a = new int[]{1, 2, 2};
	b = new int[]{2, 3};
	query = new int[][]{{1,4}, {0,0,3}, {1,5}};
	
	resultados = processaQuery(a, b, query);
	imprimirResultados(resultados);
	
	//========= TESTE 3 =========//	
	a = new int[]{1};
	b = new int[]{2};
	query = new int[][]{{1,2}};
	
	resultados = processaQuery(a, b, query);
	imprimirResultados(resultados);
	
	//========= TESTE 4 =========//
	a = new int[]{1, 1};
	b = new int[]{3, 3, 3};
	query = new int[][]{{0, 1, 1}, {1, 0}, {1, 2}, {1, 1}};
	
	resultados = processaQuery(a, b, query);
	imprimirResultados(resultados);	
	
	//========= TESTE 5 =========//
	a = new int[]{5, 6, 4, 4, 10, 6};
	b = new int[]{8, 3, 0};
	query = new int[][]{{1, 12}, {1, 2}, {1, 4}, {1, 1}, {1, 12}};
	
	resultados = processaQuery(a, b, query);
	imprimirResultados(resultados);	
	
	}

	private static void imprimirResultados(int[] resultados) {
		System.out.print("[");
		System.out.print(resultados[0]);
		for (int i = 1; i < resultados.length; i++) {
			System.out.print(", "+resultados[i]);
		}
		System.out.print("]\n");
	}

	private static int[] processaQuery(int[] a, int[] b, int[][] query) {
		
		List<Integer> resultados = new ArrayList<>();
		
		for (int[] q : query) {
			
			if(q[0] == 0) {
				b[q[1]] = q[2];
				
			} else if(q[0] == 1) {
				
				int soma = q[1];
				int contador = 0;
				
				for (int aElement : a) {
					for (int bElement : b) {
						if(aElement + bElement == soma) {
							contador++;
						}
					}
				}
				
				resultados.add(contador);
				
			} else {
				System.out.println("Query inválida");
			}
			
		}
		
		int[] retorno = new int[resultados.size()];
	    Arrays.setAll(retorno, resultados::get);
		
		return retorno;
		
		
		
	}
	
	
	

}
