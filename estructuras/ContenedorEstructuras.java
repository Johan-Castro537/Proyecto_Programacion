package estructuras;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import modelo.Aula;
import modelo.Estudiante;
import modelo.Facultad;
import modelo.Materia;

public class ContenedorEstructuras {
    private Map<String, Estudiante> estudiantesMap = new HashMap<>();
    private Map<String, Aula> aulasMap = new TreeMap<>();
    private Map<String, Materia> materiasMap = new HashMap<>();
    private Stack<Operacion> pilaDeshacer = new Stack<>();
    private Stack<Operacion> pilaRehacer = new Stack<>();
    private Stack<String> pilaReportes = new Stack<>();
    private Stack<String> pilaAdelanteReportes = new Stack<>();
    private Queue<String[]> colaBatch = new ArrayDeque<>();
    private Facultad[] facultades = new Facultad[5];

    public ContenedorEstructuras() {
        facultades[0] = new Facultad("ING", "Ingenieria");
        facultades[1] = new Facultad("CIE", "Ciencias Exactas");
        facultades[2] = new Facultad("ADMIN", "Administracion");
        facultades[3] = new Facultad("HUM", "Humanidades");
        facultades[4] = new Facultad("SA", "Salud");

        aulasMap.put("11", new Aula("11", 30));
        aulasMap.put("22", new Aula("22", 40));
    }

    public Map<String, Estudiante> getEstudiantesMap() {
        return estudiantesMap;
    }

    public Map<String, Aula> getAulasMap() {
        return aulasMap;
    }

    public Map<String, Materia> getMateriasMap() {
        return materiasMap;
    }

    public Stack<Operacion> getPilaDeshacer() {
        return pilaDeshacer;
    }

    public Stack<Operacion> getPilaRehacer() {
        return pilaRehacer;
    }

    public Stack<String> getPilaReportes() {
        return pilaReportes;
    }

    public Stack<String> getPilaAdelanteReportes() {
        return pilaAdelanteReportes;
    }

    public Queue<String[]> getColaBatch() {
        return colaBatch;
    }

    public Facultad[] getFacultades() {
        return facultades;
    }
}