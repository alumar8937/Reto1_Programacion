package gestorEmpresa;

import gestorEmpresa.gestor.GestorEmpleados;
import gestorEmpresa.menu.Menu_Datos;
import gestorEmpresa.menu.Menu_Departamentos;
import gestorEmpresa.menu.Menu_Empleados;
import gestorEmpresa.menu.Menu_GruposCotizacion;

/**
 * @author Pedro Marín Sanchis, David Serna Mateu, Javier Blasco Gómez
 * @version V.2
 * @since 18/02/2022
 */
public class Main {
    private static boolean salir = false;

    public static void main(String[] args) {
        Menu_Datos.menuCargarDatos();
        menuPrincipal();
    }

    private static void menuPrincipal() {
        while (!salir) {
            Utilidades.limpiarPantalla();
            String textoMenu = "1.-Menú Departamentos" +
                    "\n2.-Menú Empleados \n3.-Menú Grupo Cotización"+
                    " \n4.-Coste Salarial de la Empresa \n5.-Salir del programa \nIntroduzca una opción válida:";
            switch(Utilidades.leerEntero(textoMenu)){
                case 1:
                    Menu_Departamentos.menuDepartamentos();
                    break;
                case 2:
                    Menu_Empleados.menuEmpleados();
                    break;
                case 3:
                    Menu_GruposCotizacion.menuGruposCotizacion();
                    break;
                case 4:
                    GestorEmpleados.costeSalarial();
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
