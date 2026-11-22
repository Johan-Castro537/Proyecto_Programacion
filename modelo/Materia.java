
package modelo;

import excepciones.ExcepcionesDelSistema.ColaDeEsperaVaciaException;
import excepciones.ExcepcionesDelSistema.CupoLlenoException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Materia {
    private String codigo;
    private String nombre;
    private int cuposMaximos;
    private int creditos;
    private List<Materia> preRequisitos = new LinkedList<>();
    private List<Estudiante> inscritos = new LinkedList<>();
    private Queue<Estudiante> colaEspera = new ArrayDeque<>();

    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuposMaximos() {
        return cuposMaximos;
    }

    public int getCreditos() {
        return creditos;
    }

    public List<Materia> getPreRequisitos() {
        return preRequisitos;
    }

    public List<Estudiante> getInscritos() {
        return inscritos;
    }

    public Queue<Estudiante> getColaEspera() {
        return colaEspera;
    }

    public void agregarPreRequisito(Materia materia) {
        int i = 0;
        boolean yaEsta = false;

        while (i < preRequisitos.size() && !yaEsta) {
            yaEsta = preRequisitos.get(i).getCodigo()
                    .equalsIgnoreCase(materia.getCodigo());
            i++;
        }

        if (!yaEsta) {
            preRequisitos.add(materia);
        }
    }

    public int getCuposRestantes() {
        return Math.max(0, cuposMaximos - inscritos.size());
    }

    public boolean estaLlena() {
        return !(inscritos.size() < cuposMaximos);
    }

    public void inscribirDirecto(Estudiante estudiante) throws CupoLlenoException {
        if (estaLlena()) {
            throw new CupoLlenoException("La materia " + codigo + " no tiene cupos disponibles.");
        }

        int i = 0;
        boolean yaInscrito = false;

        while (i < inscritos.size() && !yaInscrito) {
            yaInscrito = inscritos.get(i).getId().equals(estudiante.getId());
            i++;
        }

        if (!yaInscrito) {
            inscritos.add(estudiante);
            estudiante.agregarMateriaHistorial(this);
        }
    }

    public void encolarEstudiante(Estudiante estudiante) {
        boolean enCola = false;
        int i = 0;

        Estudiante[] estudiantes = colaEspera.toArray(new Estudiante[0]);

        while (i < estudiantes.length && !enCola) {
            enCola = estudiantes[i].getId().equals(estudiante.getId());
            i++;
        }

        if (!enCola) {
            colaEspera.offer(estudiante);
        }
    }

    public Estudiante desencolarSiguiente() throws ColaDeEsperaVaciaException {
        if (colaEspera.isEmpty()) {
            throw new ColaDeEsperaVaciaException("La cola de espera para " + codigo + " esta vacia.");
        }

        return colaEspera.poll();
    }

    public void cancelarInscripcion(Estudiante estudiante) {
        int i = inscritos.size() - 1;

        while (i >= 0) {
            boolean coincide = inscritos.get(i).getId().equals(estudiante.getId());

            if (coincide) {
                inscritos.remove(i);
            }

            i--;
        }

        estudiante.removerMateriaHistorial(codigo);
    }
}
