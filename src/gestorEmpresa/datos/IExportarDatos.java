package gestorEmpresa.datos;

import gestorEmpresa.primitivo.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author Pedro Marín Sanchis
 */
public interface IExportarDatos {
    void exportarCategorias(ArrayList<Categoria> categorias) throws IOException;

    void exportarDepartamentos(ArrayList<Departamento> departamentos) throws IOException;

    void exportarEmpleados(ArrayList<Empleado> empleados) throws IOException;

    void exportarGrupoCotizacion(ArrayList<GrupoCotizacion> gruposCotizacion) throws IOException;

    void exportarHorasExtras(ArrayList<HoraExtra> horasextras) throws IOException;
}
