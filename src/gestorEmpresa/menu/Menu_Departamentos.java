package gestorEmpresa.menu;

import gestorEmpresa.Utilidades;
import gestorEmpresa.gestor.*;

/**
 * @author Javier Blasco
 * @since 20/02/2023
 * @version 2.0.0
 */
public class Menu_Departamentos {

    private static boolean salir = false;

    /**
     * Este es el gestorEmpresa.menu que cuenta con las opciones referidas a los departamentos, el usuario selecciona la opcion
     * mientras que esta sea una de las que aparecen no soltara el mensaje de error.
     * {@link Utilidades#limpiarPantalla()}
     * {@link Utilidades#leerEntero}
     * {@link GestorEmpleados#consultarEmpleadosDepartamento()}
     * {@link GestorHorasExtras#horasExtraDepartamento()}
     * {@link GestorDepartamentos#agregarDepartamento()}
     * {@link GestorDepartamentos#modificarDepartamento()}
     * {@link GestorDepartamentos#eliminarDepartamento()}
     */
    public static void menuDepartamentos() {
        salir = false;
        while (!salir) {
            Utilidades.limpiarPantalla();

            String textoMenu = "1.-Consultar los datos de los empleados de un departamento " +
                    "\n2.-Consultar la cantidad de horas extras segun departamento \n3.-Agregar departamento"+
                    "\n4.-Modificar departamento \n5.-Eliminar departamento" +
                    "\n6.-Volver a atras \nIntroduzca una opción válida:";

            switch(Utilidades.leerEntero(textoMenu)){
                case 1:
                    GestorEmpleados.consultarEmpleadosDepartamento();
                    break;
                case 2:
                    GestorHorasExtras.horasExtraDepartamento();
                    break;
                case 3:
                    GestorDepartamentos.agregarDepartamento();
                    break;
                case 4:
                    GestorDepartamentos.modificarDepartamento();
                    break;
                case 5:
                    GestorDepartamentos.eliminarDepartamento();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    Utilidades.mostrarMensaje("Has introducido una opción no válida.");
            }
        }
    }
}
