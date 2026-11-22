
package modelo;

import java.util.LinkedList;
import java.util.List;

public class Estudiante extends Persona
{
    private int semestre;
    private Double[][] notas = new Double[10][20];
    private List<Materia> historialMaterias = new LinkedList<>();

    public Estudiante(String nombre, String id, String email, int semestre)
    {
        super(nombre, id, email);
        this.semestre = semestre;
    }

    public int getSemestre()
    {
        return semestre;
    }

    public void setSemestre(int semestre)
    {
        this.semestre = semestre;
    }

    public Double[][] getNotas()
    {
        return notas;
    }

    public List<Materia> getHistorialMaterias()
    {
        return historialMaterias;
    }

    public void agregarMateriaHistorial(Materia materia)
    {
        int i = 0;
        boolean existe = false;

        while (i < historialMaterias.size() && !existe)
        {
            existe = historialMaterias.get(i).getCodigo()
                    .equalsIgnoreCase(materia.getCodigo());
            i++;
        }

           if (!existe)
        {
            historialMaterias.add(materia);
        }
    }

    public void removerMateriaHistorial(String codigoMateria)
    {
        int i = historialMaterias.size() - 1;

        while (i >= 0)
        {
            if (historialMaterias.get(i).getCodigo()
                    .equalsIgnoreCase(codigoMateria))
            {
                historialMaterias.remove(i);
            }
            i--;
        }
    }

    public boolean tieneMateriaAprobada(String codigoMateria)
    {
        int i = 0;

        while (i < historialMaterias.size())
        {
            if (historialMaterias.get(i).getCodigo()
                    .equalsIgnoreCase(codigoMateria))
            {
                return true;
            }
            i++;
        }

        return false;
    }

    public void registrarNota(int numSemestre, int indiceMateria, Double nota)
    {
        int fila = numSemestre - 1;

        boolean posicionValida = fila >= 0 && fila < notas.length
                && indiceMateria >= 0 && indiceMateria < notas[fila].length;

        if (posicionValida)
        {
            notas[fila][indiceMateria] = nota;
        }
    }

    public double calcularPromedioSemestre(int numSemestre)
    {
        int fila = numSemestre - 1;

        if (fila < 0 || fila >= notas.length)
        {
            return 0.0;
        }

        double suma = 0.0;
        int contador = 0;
        int j = 0;

        while (j < notas[fila].length)
        {
            suma += (notas[fila][j] != null) ? notas[fila][j] : 0.0;
            contador += (notas[fila][j] != null) ? 1 : 0;
            j++;
        }

        return contador == 0 ? 0.0 : suma / contador;
    }

    public double calcularPromedioAcumulado()
    {
        double suma = 0.0;
        int contador = 0;
        int i = 0;

        while (i < notas.length)
        {
            int j = 0;

            while (j < notas[i].length)
            {
                suma += notas[i][j] == null ? 0.0 : notas[i][j];
                contador += notas[i][j] == null ? 0 : 1;
                j++;
            }
            i++;
        }

        return contador == 0 ? 0.0 : suma / contador;
    }

    public int contarAprobadas()
    {
        int aprobadas = 0;
        int i = 0;

        while (i < notas.length)
        {
            int j = 0;
            while (j < notas[i].length)
            {
                aprobadas += (notas[i][j] != null && notas[i][j] >= 3.0) ? 1 : 0;
                j++;
            }
            i++;
        }

        return aprobadas;
    }

    public int contarReprobadas()
    {
        int reprobadas = 0;
        int i = 0;

        while (i < notas.length)
        {
            int j = 0;
            while (j < notas[i].length)
            {
                reprobadas += (notas[i][j] != null && notas[i][j] < 3.0) ? 1 : 0;
                j++;
            }
            i++;
        }

        return reprobadas;
    }

    @Override
    public void mostrarInformacion()
    {
        double prom = calcularPromedioAcumulado();

        String textoProm = prom > 0.0
                ? String.format("%.2f", prom)
                : "0.0 (sin notas aun)";

        System.out.println("ID: " + getId()
                + "\nNombre: " + getNombre()
                + "\nEmail: " + getEmail()
                + "\nSemestre: " + semestre
                + "\nPromedio acumulado: " + textoProm);
    }
}
