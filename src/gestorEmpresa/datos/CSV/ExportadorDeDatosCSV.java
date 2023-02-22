package gestorEmpresa.datos.CSV;

import gestorEmpresa.Utilidades;
import gestorEmpresa.datos.ExportadorDeDatos;
import gestorEmpresa.primitivo.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ExportadorDeDatosCSV extends ExportadorDeDatos {

    // CABECERAS CSV

    final private static String cabecera_Categoria = "cat_GrupoProfesional";
    final private static String cabecera_Datos_Empresa = "id_usuario;id_departamento;antiguedad;cat_GrupoProfesional;grupo_Cotizacion;email";
    final private static String cabecera_Datos_Personales = "id_usuario;NIF;Nombre;Apellido1;Apellido2;num_SegSocial";
    final private static String cabecera_Departamento = "id;Nombre";
    final private static String cabecera_Grupo_Cotizacion = "Id;sueldo_base";
    final private static String cabecera_Hores_extres = "id_usuario;hora";

    private String delimitador_CSV = ",";

    public ExportadorDeDatosCSV(File destino, String delimitador_CSV) throws Exception {
        if (destino.isDirectory()) {
            this.destino = destino;
        } else {
            throw new Exception();
        }
        this.delimitador_CSV = delimitador_CSV;
    }

    public void exportarCategorias(ArrayList<Categoria> categorias) throws IOException {
        crearCategoriaCSV(categorias).exportarComoArchivo(destino, "Categoria.csv");
    }

    public void exportarDepartamentos(ArrayList<Departamento> departamentos) throws IOException {
        crearDepartamentoCSV(departamentos).exportarComoArchivo(destino, "Departamento.csv");
    }

    public void exportarEmpleados(ArrayList<Empleado> empleados) throws IOException {
        crearDatos_EmpresaCSV(empleados).exportarComoArchivo(destino, "Datos_Empresa.csv");
        crearDatos_PersonalesCSV(empleados).exportarComoArchivo(destino, "Datos_Personales.csv");
    }

    public void exportarGrupoCotizacion(ArrayList<GrupoCotizacion> gruposCotizacion) throws IOException {
        crearGrupo_CotizacionCSV(gruposCotizacion).exportarComoArchivo(destino, "Grupo_Cotizacion.csv");
    }

    public void exportarHorasExtras(ArrayList<HoraExtra> horasextras) throws IOException {
        crearHores_extresCSV(horasextras).exportarComoArchivo(destino, "Hores_extres.csv");
    }

    private DocumentoCSV crearCategoriaCSV(ArrayList<Categoria> categorias) { // Author: Pedro Marín Sanchis

        DocumentoCSV documento = new DocumentoCSV("", delimitador_CSV);
        documento.anyadirTuple(cabecera_Categoria, delimitador_CSV);

        if (categorias.size() > 0) {
            for (Categoria i: categorias) {
                documento.anyadirTuple(new String[]{i.getCat_GrupoProfesional()});
            }
        } else {
            Utilidades.mostrarError("Los archivos no son válidos.");
        }
        return documento;

    }

    /**
     * Método que crea un documento CSV con los datos empresariales del empleado
     * @return devuelve el documento CSV
     * {@link Utilidades#mostrarError(String)}
     */
    private DocumentoCSV crearDatos_EmpresaCSV(ArrayList<Empleado> empleados) { // Author: Pedro Marin Sanchis

        DocumentoCSV documento = new DocumentoCSV("", delimitador_CSV);
        documento.anyadirTuple(cabecera_Datos_Empresa, delimitador_CSV);

        if (empleados.size() > 0) {
            for (Empleado i: empleados) {
                documento.anyadirTuple(new String[]{Integer.toString(i.getId_usuario()), Integer.toString(i.getId_departamento()), i.getAntiguedad(), i.getCat_GrupoProfesional(), Integer.toString(i.getGrupo_Cotizacion()), i.getEmail()});
            }
        } else {
            Utilidades.mostrarError("Los archivos no son válidos.");
        }
        return documento;

    }

    /**
     * Método que crea un documento CSV con los datos personales del empleado
     * @return devuelve el documento CSV
     * {@link Utilidades#mostrarError(String)}
     */
    private DocumentoCSV crearDatos_PersonalesCSV(ArrayList<Empleado> empleados) { // Author: Pedro Marín Sanchis

        DocumentoCSV documento = new DocumentoCSV("", delimitador_CSV);
        documento.anyadirTuple(cabecera_Datos_Personales, delimitador_CSV);

        if (empleados.size() > 0) {
            for (Empleado i: empleados) {
                documento.anyadirTuple(new String[]{Integer.toString(i.getId_usuario()), i.getNIF(), i.getNombre(), i.getApellido1(), i.getApellido2(), Integer.toString(i.getNum_SegSocial())});
            }
        } else {
            Utilidades.mostrarError("Los archivos no son válidos.");
        }
        return documento;

    }

    /**
     * Método que crea el documento CSV con los departamentos
     * @return devuelve el documento CSV
     * {@link Utilidades#mostrarError(String)}
     */
    private DocumentoCSV crearDepartamentoCSV(ArrayList<Departamento> departamentos) { // Author: Pedro Marín Sanchis

        DocumentoCSV documento = new DocumentoCSV("", delimitador_CSV);
        documento.anyadirTuple(cabecera_Departamento, delimitador_CSV);

        if (departamentos.size() > 0) {
            for (Departamento i: departamentos) {
                documento.anyadirTuple(new String[]{Integer.toString(i.getId()), i.getNombre()});
            }
        } else {
            Utilidades.mostrarError("Los archivos no son válidos.");
        }
        return documento;

    }

    /**
     * Método que crea el documento CSV con los grupos de cotización
     * @return devuelve el documento CSV
     * {@link Utilidades#mostrarError(String)}
     */
    private DocumentoCSV crearGrupo_CotizacionCSV(ArrayList<GrupoCotizacion> gruposCotizacion) { // Author: Pedro Marín Sanchis

        DocumentoCSV documento = new DocumentoCSV("", delimitador_CSV);
        documento.anyadirTuple(cabecera_Grupo_Cotizacion, delimitador_CSV);

        if (gruposCotizacion.size() > 0) {
            for (GrupoCotizacion grupoCotizacion: gruposCotizacion) {
                documento.anyadirTuple(new String[]{Integer.toString(grupoCotizacion.getId()), Integer.toString(grupoCotizacion.getSueldo_base())});
            }
        } else {
            Utilidades.mostrarError("Los archivos no son válidos.");
        }
        return documento;

    }

    /**
     * Método que crea el documento CSV de las horas extras
     * @return devuelve el documento CSV
     * {@link Utilidades#mostrarError(String)}
     */
    private DocumentoCSV crearHores_extresCSV(ArrayList<HoraExtra> horasExtras) { // Author: Pedro Marín Sanchis

        DocumentoCSV documento = new DocumentoCSV("", delimitador_CSV);
        documento.anyadirTuple(cabecera_Hores_extres, delimitador_CSV);

        if (horasExtras.size() > 0) {
            for (HoraExtra i : horasExtras) {
                documento.anyadirTuple(new String[]{Integer.toString(i.getId_usuario()), Integer.toString(i.getHoras())});
            }
        } else {
            Utilidades.mostrarError("Los archivos no son válidos.");
        }
        return documento;

    }

}
