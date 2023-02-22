package gestorEmpresa.menu;

import gestorEmpresa.Utilidades;
import gestorEmpresa.gestor.GestorEmpleados;

/**
 * @author Javier Blasco y David Serna
 * @since 20/02/2023
 * @version 2.0.0
 */
public class Menu_Principal {
    private static boolean salir = false;
    private static boolean comprobar = false;

    public static void menuPrincipal() {
        while (!salir) {
            Utilidades.limpiarPantalla();
            String textoMenu = "1.-Menú importar datos \n2.-Menú exportar datos \n3.-Menú departamentos" +
                    "\n4.-Menú empleados \n5.-Menú grupo cotización"+
                    " \n6.-Coste salarial de la empresa \n7.-Salir del programa \nIntroduzca una opción válida:";
            switch(Utilidades.leerEntero(textoMenu)){
                case 1:
                    Menu_Importar.menuCargarDatos();
                    comprobar = true;
                    break;
                case 2:
                    if(comprobar) {
                    Menu_Exportar.menuExportarDatos();
                    }else{
                        Utilidades.mostrarMensaje("No has importado los datos.");
                    }
                    break;
                case 3:
                    if(comprobar) {
                        Menu_Departamentos.menuDepartamentos();
                    }else{
                        Utilidades.mostrarMensaje("No has importado los datos.");
                    }
                    break;
                case 4:
                    if(comprobar) {
                        Menu_Empleados.menuEmpleados();
                    }else{
                        Utilidades.mostrarMensaje("No has importado los datos.");
                    }
                    break;
                case 5:
                    if(comprobar) {
                        Menu_GruposCotizacion.menuGruposCotizacion();
                    }else{
                        Utilidades.mostrarMensaje("No has importado los datos.");
                    } 
                    break;
                case 6:
                    if(comprobar) {
                        GestorEmpleados.costeSalarial();
                    }else{
                        Utilidades.mostrarMensaje("No has importado los datos.");
                    }
                    break;
                case 7:
                    salir = Utilidades.mostrarPeticionDeConfirmacion("Los cambios sin guardar se perderán.");
                    break;
                default:
                    Utilidades.mostrarMensaje("Has introducido una opción no válida.");
            }
        }
    }
}
