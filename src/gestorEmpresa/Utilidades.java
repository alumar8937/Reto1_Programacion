package gestorEmpresa;

import java.util.Scanner;

/**
 * @author Raul Simarro
 * @since 20/02/2023
 * @version 2.0.0
 */

public class Utilidades {
    final private static Scanner inputValue = new Scanner(System.in);

    public static boolean mostrarPeticionDeConfirmacion(String mensaje) {
        while (true) {
            limpiarPantalla();
            System.out.println("[Aviso]: " + mensaje + "\n¿Deseas continuar? [Y/N]: ");
            switch (inputValue.nextLine().toUpperCase()) {
                case "Y":
                    limpiarPantalla();
                    return true;
                case "N":
                    limpiarPantalla();
                    return false;
            }
        }
    }

    public static void mostrarMensaje(String mensaje) {
        limpiarPantalla();
        System.out.println(mensaje + "\nPulsa ENTER para continuar...");
        inputValue.nextLine();
        limpiarPantalla();
    }

    public static void mostrarError(String mensaje) {
        mostrarMensaje("[Error]: " + mensaje);
    }

    public static void limpiarPantalla() {
        System.out.println("\n".repeat(50));
    }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        try {
            int entero = inputValue.nextInt();
            inputValue.nextLine();
            return entero;
        } catch (Exception e) {
            return 0;
        }
    }
    public static String leerCadena(String mensaje) {
        System.out.println(mensaje);
        return inputValue.nextLine();
    }
}
