
package modelo;

public class Campus {
    private String[] edificios;
    private int[][] matrizAdyacencia;
    private static final int INF = 1_000_000_000;

    public Campus(String[] nombresEdificios) {
        edificios = nombresEdificios;
        int cantidad = edificios.length;
        matrizAdyacencia = new int[cantidad][cantidad];

        int i = 0;

        while (i < cantidad) {
            int j = 0;

            while (j < cantidad) {
                matrizAdyacencia[i][j] = (i != j) ? INF : 0;
                j++;
            }

            i++;
        }
    }

    public String[] getEdificios() {
        return edificios;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void agregarConexion(int origen, int destino, int distancia) {
        int cantidad = edificios.length;

        boolean valido = origen >= 0 && destino >= 0
                && origen < cantidad && destino < cantidad;

        if (valido && distancia > 0) {
            matrizAdyacencia[origen][destino] = distancia;
            matrizAdyacencia[destino][origen] = distancia;
        }
    }

    public String calcularRutaDijkstra(int origen, int destino) {
        int cantidad = edificios.length;

        int[] distancias = new int[cantidad];
        boolean[] visitados = new boolean[cantidad];
        int[] anterior = new int[cantidad];

        int i = 0;

        while (i < cantidad) {
            distancias[i] = INF;
            visitados[i] = false;
            anterior[i] = -1;
            i++;
        }

        distancias[origen] = 0;

        int contador = cantidad - 1;

        while (contador > 0) {
            int nodo = -1;
            int menor = INF;

            int j = 0;

            while (j < cantidad) {
                if (distancias[j] < menor && !visitados[j]) {
                    menor = distancias[j];
                    nodo = j;
                }
                j++;
            }

            if (nodo < 0) {
                contador = 0;
            } else {
                visitados[nodo] = true;

                int k = 0;

                while (k < cantidad) {
                    boolean conectado = matrizAdyacencia[nodo][k] != INF;
                    boolean disponible = !visitados[k];

                    if (conectado && disponible && distancias[nodo] != INF) {
                        int nuevaDistancia = distancias[nodo] + matrizAdyacencia[nodo][k];

                        if (nuevaDistancia < distancias[k]) {
                            distancias[k] = nuevaDistancia;
                            anterior[k] = nodo;
                        }
                    }

                    k++;
                }

                contador--;
            }
        }

        if (distancias[destino] == INF) {
            return "No existe ruta entre " + edificios[origen]
                    + " y " + edificios[destino] + ".";
        }

        int[] camino = new int[cantidad];
        int totalPasos = 0;
        int posicion = destino;

        while (posicion != -1) {
            camino[totalPasos] = posicion;
            totalPasos++;
            posicion = anterior[posicion];
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("Ruta mas corta:\n");

        int recorrido = totalPasos - 1;

        while (recorrido > 0) {
            int edificioActual = camino[recorrido];
            int siguiente = camino[recorrido - 1];

            resultado.append(edificios[edificioActual])
                    .append(" -> ")
                    .append(edificios[siguiente])
                    .append(" (")
                    .append(matrizAdyacencia[edificioActual][siguiente])
                    .append("m)");

            recorrido--;

            if (recorrido > 0) {
                resultado.append(" -> ");
            }
        }

        resultado.append("\nDistancia TOTAL: ")
                .append(distancias[destino])
                .append(" metros");

        return resultado.toString();
    }
}
