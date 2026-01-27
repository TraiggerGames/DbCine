package es.recha.dbcine.rechautils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validators {

    // =========================
    // MÉTODOS GENÉRICOS NUEVOS
    // =========================

    // Lee un int con mensaje, reintentando hasta que sea válido
    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Introduce un número entero válido.");
            }
        }
    }

    // Lee un int en un rango [min, max]
    public static int readInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int value = readInt(scanner, prompt);
            if (value < min || value > max) {
                System.out.println("❌ El valor debe estar entre " + min + " y " + max + ".");
            } else {
                return value;
            }
        }
    }

    // Lee un double con mensaje
    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Introduce un número decimal válido.");
            }
        }
    }

    // Lee un double en un rango [min, max]
    public static double readDouble(Scanner scanner, String prompt, double min, double max) {
        while (true) {
            double value = readDouble(scanner, prompt);
            if (value < min || value > max) {
                System.out.println("❌ El valor debe estar entre " + min + " y " + max + ".");
            } else {
                return value;
            }
        }
    }

    // Lee un entero no negativo
    public static int readNonNegativeInt(Scanner scanner, String prompt) {
        return readInt(scanner, prompt, 0, Integer.MAX_VALUE);
    }

    // Lee un double no negativo
    public static double readNonNegativeDouble(Scanner scanner, String prompt) {
        return readDouble(scanner, prompt, 0.0, Double.MAX_VALUE);
    }

    // Lee un String no vacío
    public static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("❌ El texto no puede estar vacío.");
            } else {
                return input;
            }
        }
    }

    // Lee un solo char
    public static char readChar(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String temp = scanner.nextLine();
            if (temp.length() != 1) {
                System.out.println("❌ Debes introducir solo un carácter.");
            } else {
                return temp.charAt(0);
            }
        }
    }
    public static String readEmail(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String email = scanner.nextLine().trim();

            if (email.isEmpty()) {
                System.out.println("❌ El email no puede estar vacío.");
                continue;
            }

            if (email.contains(" ")) {
                System.out.println("❌ El email no puede contener espacios.");
                continue;
            }

            int atIndex = email.indexOf("@");
            int dotIndex = email.lastIndexOf(".");

            if (atIndex < 1 || dotIndex < atIndex + 2 || dotIndex == email.length() - 1) {
                System.out.println("❌ Formato de email no válido. Ejemplo correcto: usuario@dominio.com");
                continue;
            }

            return email;
        }
    }
    public static LocalDate readDate(Scanner scanner, String prompt, DateTimeFormatter formatter) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Fecha no válida. Usa el formato " + formatter.toString());
            }
        }
    }

    // ======================================
    // TUS MÉTODOS ANTIGUOS (USANDO LOS NUEVOS)
    // ======================================

    // valida que solo puedas introducir un double
    public static double doubleValidados(Scanner scanner) {
        return readDouble(scanner, "Introduce un número decimal: ");
    }

    // Sobrecarga que limita si esta en un rango determinado
    public static double doubleValidados(Scanner scanner, double min, double max) {
        return readDouble(scanner,
                "Introduce un número decimal entre " + min + " y " + max + ": ",
                min, max);
    }

    // valida que solo se pueda introducir int
    public static int intValidado(Scanner scanner) {
        return readInt(scanner, "Introduce un número entero: ");
    }

    // version que el numero este en un rango determinado.
    public static int intValidado(Scanner scanner, int min, int max) {
        return readInt(scanner,
                "Introduce un entero entre " + min + " y " + max + ": ",
                min, max);
    }

    // valida que no se pueda a introducir numero negativo
    public static int noAceptarNegativosEnteros(Scanner scanner) {
        return readNonNegativeInt(scanner, "Introduce un entero (no negativo): ");
    }

    // Valida que no se puedan aceptar negativos metodo double
    public static double noAceptarNegativosDecimales(Scanner scanner) {
        return readNonNegativeDouble(scanner, "Introduce un decimal (no negativo): ");
    }

    // Valida que puedas introducir solo un char
    public static char validarChar(Scanner scanner) {
        return readChar(scanner, "Introduce un carácter: ");
    }

    // Esta en rango (por si lo quieres seguir usando)
    public static boolean isInRange(double number, double min, double max) {
        return !(number < min || number > max);
    }

    public static boolean isInRangeInt(int number, int min, int max) {
        return !(number < min || number > max);
    }

}