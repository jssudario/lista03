import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static int funcaoHash(String palavra, int tam){
        int hash = 0;
        // ex: Abobora -> pega letra A -> int da tabela ascii
        // A -> valor 65
        // 65 -> 0
        // 90 -> 25
        hash = 13 + palavra.toUpperCase().charAt(0); // pega a inicial

        return hash % tam;
    }

    // Método a ser implementado no App.java
    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam) {
        int categoria = funcaoHash(palavra, tam);
        if (tabelaHash[categoria].contains(palavra)) {
            System.out.println("Palavra '" + palavra + "' encontrada na categoria n° " + categoria + ".");
            return true;
        } else {
            System.out.println("Palavra '" + palavra + "' não encontrada.");
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        int totalCategorias = 26;
        ArrayList<String> tabelaHash[] = new ArrayList[totalCategorias];

        // inicializar a tabela
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.println(i + "-> " + tabelaHash[i]);
            tabelaHash[i] = new ArrayList<String>();
        }

        System.out.println("---INSTANCIADAS---");
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.println(i + "-> " + tabelaHash[i]);
        }

        System.out.println("Adicionando palavras...");
        for (int i = 0; i < 100; i++) {
            String palavra = GeradorPalavras.gerarPalavraAleatoria(3, 10);
            int categoria = funcaoHash(palavra, totalCategorias);
            tabelaHash[categoria].add(palavra);
        }

        System.out.println("---PREENCHIDA---");
        for (int i = 0; i < tabelaHash.length; i++) {
            System.out.println(i + "-> total = " + tabelaHash[i]);
        }

        // scanner para localizar palavra
        Scanner sc = new Scanner(System.in);
        System.out.print("\n* Informe uma palavra para buscar: ");
        String palavraBuscar = sc.nextLine();
        buscarPalavra(palavraBuscar, tabelaHash, totalCategorias);

        sc.close();
    }
}