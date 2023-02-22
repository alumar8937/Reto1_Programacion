package gestorEmpresa.menu;

import java.io.File;
import java.io.IOException;

import gestorEmpresa.datos.CSV.DocumentoCSV;
import gestorEmpresa.datos.CSV.FuenteDeDatosCSV;
import gestorEmpresa.Utilidades;
import gestorEmpresa.datos.*;
import gestorEmpresa.primitivo.*;

/**
 * @author Pedro Marín Sanchis
 */
public class Menu_Importar {
    private static boolean salir = false;
    public static void menuCargarDatos() {
        while (!salir) {
            Utilidades.limpiarPantalla();
            String textoMenu = "1.-A partir de CSV\n2.-Salir del Programa";
            switch(Utilidades.leerEntero(textoMenu)){
                case 1:
                    try {
                        FuenteDeDatosCSV fuenteDeDatosCSV = crearFuenteDeDatosCSV();
                        cargarDatos(fuenteDeDatosCSV);
                        salir = true;
                    }catch (IOException e) {
                        Utilidades.mostrarMensaje("La carga de gestorEmpresa.datos ha fallado.");
                    }
                    break;
                case 2:
                    System.exit(0);
                default:
                    Utilidades.mostrarMensaje("Has introducido una opción no válida.");
            }
        }
    }

    private static void cargarDatos(FuenteDeDatos fuenteDeDatos) {
        fuenteDeDatos.cargar(new Empleado());
        fuenteDeDatos.cargar(new Departamento());
        fuenteDeDatos.cargar(new Categoria());
        fuenteDeDatos.cargar(new GrupoCotizacion());
        fuenteDeDatos.cargar(new HoraExtra());
    }

    private static FuenteDeDatosCSV crearFuenteDeDatosCSV() throws IOException {
        DocumentoCSV CategoriaCSV = new DocumentoCSV(new File("CSV/Categoria.csv"), ";");
        DocumentoCSV Datos_EmpresaCSV = new DocumentoCSV(new File("CSV/Datos_Empresa.csv"), ";");
        DocumentoCSV Datos_PersonalesCSV = new DocumentoCSV(new File("CSV/Datos_Personales.csv"), ";");
        DocumentoCSV DepartamentoCSV = new DocumentoCSV(new File("CSV/Departamento.csv"), ";");
        DocumentoCSV Grupo_CotizacionCSV = new DocumentoCSV(new File("CSV/Grupo_Cotizacion.csv"), ";");
        DocumentoCSV Hores_extresCSV = new DocumentoCSV(new File("CSV/Hores_extres.csv"), ";");
        return new FuenteDeDatosCSV(CategoriaCSV, Datos_EmpresaCSV, Datos_PersonalesCSV,
                DepartamentoCSV, Grupo_CotizacionCSV, Hores_extresCSV);
    }
}
