package util;

import java.io.IOException;
import java.util.Scanner;
public class Main {
      public static void main(String[] args)
            throws IOException
        {
 
        Scanner sc = new Scanner(System.in);
        GestorSistema gestor = new GestorSistema(sc);
        int opcion = 0;
 
        do {
            System.out.println("\nPLANIFICACIÓN ACADÉMICA");
            System.out.println("SISTEMA UNIVERSITARIO");
            System.out.println("=== GESTION DE ESTUDIANTES ===");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante por ID");
            System.out.println("3. Listar todos los estudiantes");
            System.out.println("4. Eliminar estudiante");
            System.out.println("=== GESTION DE MATERIAS ===");
            System.out.println("5. Crear materia");
            System.out.println("6. Agregar pre-requisito");
            System.out.println("7. Mostrar pre-requisitos");
            System.out.println("8. Inscribir estudiante");
            System.out.println("9. Cancelar inscripcion");
            System.out.println("10. Mostrar cola de espera");
            System.out.println("=== GESTION DE HORARIOS ===");
            System.out.println("11. Reservar horario en aula");
            System.out.println("12. Liberar horario");
            System.out.println("13. Consultar disponibilidad");
            System.out.println("=== RUTAS ENTRE EDIFICIOS ===");
            System.out.println("14. Agregar conexion entre edificios");
            System.out.println("15. Calcular ruta mas corta");
            System.out.println("=== REPORTES ACADEMICOS ===");
            System.out.println("16. Registrar nota");
            System.out.println("17. Ver reporte academico");
            System.out.println("18. Navegador de reportes (atras/adelante)");
            System.out.println("=== SISTEMA DESHACER/REHACER ===");
            System.out.println("19. Deshacer última operacion");
            System.out.println("20. Rehacer ultima operacion");
            System.out.println("=== PROCESAMIENTO POR LOTES ===");
            System.out.println("21. Procesar archivo CSV");
            System.out.println("=== SALIR ===");
            System.out.println("22. Salir");
            System.out.print("Seleccione una opcion: ");
 
            opcion = Integer.parseInt(sc.nextLine().trim());
 
            switch (opcion) {
               
                case 5:
                    gestor.crearMateria();
                    break;
            }
        } while (opcion != 22);
    }
}
