package gestorEmpresa.menu;
import gestorEmpresa.Utilidades;
import gestorEmpresa.gestor.GestorEmpleados;
import gestorEmpresa.gestor.GestorHorasExtras;
import gestorEmpresa.gestor.GestorGruposCotizacion;

/**
 * @author Javier Blasco
 * @since 20/02/2023
 * @version 2.0.0
 */
public class Menu_GruposCotizacion {

    private static boolean salir = false;

    /**
     * Este es el gestorEmpresa.menu que cuenta con las opciones referidas a los grupos de cotizacion, el usuario selecciona la opcion
     * mientras que esta sea una de las que aparecen no soltara el mensaje de error.
     * {@link Utilidades#limpiarPantalla()}
     * {@link Utilidades#leerEntero}
     * {@link Utilidades#mostrarMensaje(String)}
     * {@link GestorEmpleados#contarEmpleadosGrupoCotizacion(int)}
     * {@link GestorHorasExtras#horasExtraGrupoCotizacion()}
     * {@link GestorGruposCotizacion#agregarDatosGrupoCotizacion()}
     * {@link GestorGruposCotizacion#eliminarGrupoCotizacion()}
     */
    public static void menuGruposCotizacion() {
        salir = false;
        while (!salir) {
            Utilidades.limpiarPantalla();

            String textoMenu = "1.-Consultar la cantidad de trabajadores pertenecientes a un grupo de cotización" +
                    "\n2.-Consultar la cantidad de horas extras segun grupo de cotización \n3.-Agregar grupo de cotización "+
                    "\n4.-Eliminar grupo de cotización \n5.-Volver a atras \nIntroduzca una opción válida:";

            switch(Utilidades.leerEntero(textoMenu)){
                case 1:
                    Utilidades.mostrarMensaje("En este grupo de cotización hay: " + GestorEmpleados.contarEmpleadosGrupoCotizacion(Utilidades.leerEntero("Introduce la id del grupo de cotización:"))+ " empleados.");
                    break;
                case 2:
                    GestorHorasExtras.horasExtraGrupoCotizacion();
                    break;
                case 3:
                    GestorGruposCotizacion.agregarDatosGrupoCotizacion();
                    break;
                case 4:
                    GestorGruposCotizacion.eliminarGrupoCotizacion();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    Utilidades.mostrarMensaje("Has introducido una opción no válida.");
            }
        }
    }
}
