package es.recha.dbcine.rechautils;

import java.util.Scanner;

public class Menu {
    private String titulo;
    private String[] opciones;
    
	public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BLACK  = "\u001B[30m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN   = "\u001B[36m";
    public static final String ANSI_WHITE  = "\u001B[37m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";
    // Constructor
    
    public Menu(String titulo, String[] opciones) {
        this.titulo = titulo;
        this.opciones = opciones;
    }

    // Método para mostrar y manejar el menú
    public int mostrar() {
        Scanner scanner = new Scanner(System.in);
        int opcionSeleccionada = -1;

        while (true) {
            // Mostrar el título
            System.out.println("\n" + titulo);
            System.out.println("=".repeat(titulo.length()));

            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }
            printNLines(1);
            System.out.print(ANSI_BOLD + ANSI_GREEN + "Selecciona una opción (1-" + opciones.length+ ")"+ ANSI_RESET );

             if (scanner.hasNextInt()) {
                opcionSeleccionada = scanner.nextInt();

                // Validar el rango de la opción
                if (opcionSeleccionada >= 0 && opcionSeleccionada <= opciones.length) {
                    return opcionSeleccionada;
                } else {
                    System.out.println("✖ Opción no válida. Intenta de nuevo.");
                }
            } else {
                System.out.println("✖ Por favor, ingresa un número.");
                scanner.next(); 
            }
        }
    }
    //imprime el numero de lineas vacias seleccionadas.
    public static void printNLines(int lines) {
    	for (int i = 0; i < lines; i++) {
			System.out.println("");    		
			
		}
    }
}
