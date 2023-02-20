/**
 * @author Javier Blasco
 * @since 20/02/2023
 * @version 2.0.0
 */
public class Menu_Epleados {

    private static boolean salir = false;

    /**
     * Este es el menu que cuenta con las opciones referidas a los empleados, el usuario selecciona la opcion
     * mientras que esta sea una de las que aparecen no soltara el mensaje de error.
     * {@link Utilidades#limpiarPantalla()}
     * {@link Utilidades#leerEntero}
     * {@link GestorEmpleados#obtenerDatosPersonalesID()}
     * {@link GestorEmpleados#obtenerDatosEmpresaID()}
     * {@link GestorEmpleados#agregarDatosUsuario()}
     * {@link GestorEmpleados#modificarDatosPersonales()}
     * {@link GestorEmpleados#modificarDatosEmpresa()}
     * {@link GestorEmpleados#eliminarEmpleado()}
     */
    public static void menuEmpleados() {

        while (!salir) {
            Utilidades.limpiarPantalla();

            String textoMenu = "1.-Consultar datos personales del trabajador por ID \n2.-Consultar datos de empresa del " +
                    "trabajador por ID \n3.-Añadir datos personales y de empresa de un nuevo trabajador " +
                    "\n4.-Modificar datos personales de un empleado por ID. \n5.-Modificar datos de empresa de un empleado por ID" +
                    "\n6.-Eliminar un empleado \n7.-Volver a atras \nIntroduzca una opción válida:";

            switch (Utilidades.leerEntero(textoMenu)) {
                case 1:
                    GestorEmpleados.obtenerDatosPersonalesID();
                    break;
                case 2:
                    GestorEmpleados.obtenerDatosEmpresaID();
                    break;
                case 3:
                    GestorEmpleados.agregarDatosUsuario();
                    break;
                case 4:
                    GestorEmpleados.modificarDatosPersonales();
                    break;
                case 5:
                    GestorEmpleados.modificarDatosEmpresa();
                    break;
                case 6:
                    GestorEmpleados.eliminarEmpleado();
                    Utilidades.limpiarPantalla();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    Utilidades.mostrarMensaje("Has introducido una opción no válida.");
            }
        }
    }
}
