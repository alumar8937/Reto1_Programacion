package gestorEmpresa.menu;

import gestorEmpresa.Utilidades;
import gestorEmpresa.datos.CSV.ExportadorDeDatosCSV;
import gestorEmpresa.datos.CSV.FuenteDeDatosCSV;
import gestorEmpresa.gestor.*;

import java.io.File;
import java.io.IOException;
/**
 * @author Pedro Marín Sanchis
 */
public class Menu_Exportar {
    private static boolean salir = false;

    public static void menuExportarDatos() {
        salir = false;
        while (!salir) {
            Utilidades.limpiarPantalla();
            String textoMenu = "1.-Exportar datos como CSV\n2.-Atrás";
            switch (Utilidades.leerEntero(textoMenu)) {
                case 1:
                    try {
                        ExportadorDeDatosCSV exportadorDeDatosCSV = new ExportadorDeDatosCSV(new File("Export"+ File.separator), ";");
                        exportadorDeDatosCSV.exportarEmpleados(GestorEmpleados.getEmpleados());
                        exportadorDeDatosCSV.exportarDepartamentos(GestorDepartamentos.getDepartamentos());
                        exportadorDeDatosCSV.exportarCategorias(GestorCategoria.getCategorias());
                        exportadorDeDatosCSV.exportarGrupoCotizacion(GestorGruposCotizacion.getGruposCotizacion());
                        exportadorDeDatosCSV.exportarHorasExtras(GestorHorasExtras.getHorasExtras());
                        salir = true;
                    } catch (IOException e) {
                        Utilidades.mostrarMensaje("La exportación ha fallado.");
                    } catch (Exception e) {
                        Utilidades.mostrarMensaje("La ruta de exportado no es un directorio.");
                    }
                    break;
                case 2:
                    salir = true;
                    break;
                default:
                    Utilidades.mostrarMensaje("Has introducido una opción no válida.");
            }
        }
    }
}