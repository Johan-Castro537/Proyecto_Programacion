
package estructuras;

import modelo.Estudiante;

public class Operacion
{
    private String tipo;
    private String idEstudiante;
    private String codigoMateria;
    private String numeroAula;
    private int dia;
    private int hora;
    private int duracion;
    private int semestre;
    private int indiceNota;
    private Double notaAnterior;
    private Estudiante estudianteRespaldo;

    public Operacion(String tipo, String idEstudiante, String codigoMateria)
    {
        this.tipo = tipo;
        this.idEstudiante = idEstudiante;
        this.codigoMateria = codigoMateria;
    }

    public static Operacion crearOperacionHorario(String numeroAula, int dia, int hora, int duracion)
    {
        Operacion nueva = new Operacion("HORARIO", null, null);

        nueva.numeroAula = numeroAula;
        nueva.dia = dia;
        nueva.hora = hora;
        nueva.duracion = duracion;

        return nueva;
    }

    public static Operacion crearOperacionNota(String idEstudiante, int semestre, int indiceNota, Double notaAnterior)
    {
        Operacion nueva = new Operacion("NOTA", idEstudiante, null);

        nueva.semestre = semestre;
        nueva.indiceNota = indiceNota;
        nueva.notaAnterior = notaAnterior;

        return nueva;
    }

    public static Operacion crearOperacionEliminarEstudiante(Estudiante estudiante)
    {
        Operacion nueva = new Operacion("ELIMINAR_ESTUDIANTE", estudiante.getId(), null);

        nueva.estudianteRespaldo = estudiante;

        return nueva;
    }

    public Estudiante getEstudianteRespaldo()
    {
        return estudianteRespaldo;
    }

    public String getTipo()
    {
        return tipo;
    }

    public String getCodigoMateria()
    {
        return codigoMateria;
    }

    public String getIdEstudiante()
    {
        return idEstudiante;
    }

    public String getNumeroAula()
    {
        return numeroAula;
    }

    public int getDuracion()
    {
        return duracion;
    }

    public int getHora()
    {
        return hora;
    }

    public int getDia()
    {
        return dia;
    }

    public int getIndiceNota()
    {
        return indiceNota;
    }

    public int getSemestre()
    {
        return semestre;
    }

    public Double getNotaAnterior()
    {
        return notaAnterior;
    }
}
