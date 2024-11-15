package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Grafo {

    private int numVertices; // Número total de vértices no grafo
    private List<List<Integer>> adjacencyList; // Lista de adjacência para armazenar as conexões

    // Construtor do grafo
    public Grafo(int numVertices) {
        this.numVertices = numVertices; // Define o número de vértices
        this.adjacencyList = new ArrayList<>(numVertices); // Inicializa a lista de adjacência

        for (int i = 0; i < numVertices; i++) {
            this.adjacencyList.add(new LinkedList<>()); // Adiciona uma lista vazia para cada vértice
        }
    }

    // Método para adicionar uma aresta entre dois vértices
    public void addEdge(int v, int w) {
        adjacencyList.get(v).add(w); // Adiciona o vértice w à lista de adjacência do vértice v
        adjacencyList.get(w).add(v); // Adiciona o vértice v à lista de adjacência do vértice w (grafo não direcionado)
    }

    // Método para representar o grafo como string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // StringBuilder para compor a saída

        for (int i = 0; i < numVertices; i++) {
            sb.append("Vértice: ").append(i).append(":\n"); // Mostra o vértice atual
            for (Integer neighbor : adjacencyList.get(i)) {
                sb.append(" -> ").append(neighbor).append("\n"); // Mostra cada vizinho do vértice
            }
            sb.append("\n"); // Nova linha para separar os vértices
        }

        return sb.toString(); // Retorna a representação do grafo
    }

    // IMPLEMENTAÇÃO DA BUSCA EM LARGURA (BFS-Breadth-First Search)
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices]; // Array para marcar vértices visitados
        Queue<Integer> queue = new LinkedList<>(); // Fila para controlar a ordem de visita dos vértices

        visited[startVertex] = true; // Marca o vértice inicial como visitado
        queue.add(startVertex); // Adiciona o vértice inicial à fila

        System.out.println("Busca em Largura a partir do vértice " + startVertex + ":");

        // Enquanto a fila não estiver vazia
        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Remove o próximo vértice da fila
            System.out.print(vertex + " "); // Imprime o vértice visitado

            // Para cada vizinho do vértice atual
            for (int neighbor : adjacencyList.get(vertex)) {
                if (!visited[neighbor]) { // Se o vizinho ainda não foi visitado
                    visited[neighbor] = true; // Marca como visitado
                    queue.add(neighbor); // Adiciona o vizinho à fila
                }
            }
        }

        System.out.println(); // Pula linha após a impressão dos vértices
    }

    // Método principal para testar o grafo e a BFS
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5); // Cria um grafo com 5 vértices

        // Adiciona as arestas ao grafo
        grafo.addEdge(0, 1);
        grafo.addEdge(0, 4);
        grafo.addEdge(1, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(1, 4);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 4);

        System.out.println(grafo.toString()); // Exibe a representação do grafo

        grafo.bfs(0); // Executa a busca em largura a partir do vértice 0
    }
}
