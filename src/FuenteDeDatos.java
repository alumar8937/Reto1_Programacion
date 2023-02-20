import java.util.ArrayList;

public abstract class FuenteDeDatos {

    /**
     * En este metodo se importaran los datos de los documentos csv asignados a las tablas de
     * la base de datos en la que se basa el programa.
     * {@link FuenteDeDatosCSV#cargarCategorias()}
     * {@link FuenteDeDatosCSV#cargarEmpleados()}
     * {@link FuenteDeDatosCSV#cargarDepartamentos()}
     * {@link FuenteDeDatosCSV#cargarGrupo_Cotizacion()}
     * {@link FuenteDeDatosCSV#cargarHores_extres()}
     */
    public void obtener(Object obj) {
        if (obj instanceof Categoria) {
            cargarCategorias();
            return;
        }
        if (obj instanceof Empleado) {
            cargarEmpleados();
            return;
        }
        if (obj instanceof Departamento) {
            cargarDepartamentos();
            return;
        }
        if (obj instanceof GrupoCotizacion) {
            cargarGrupo_Cotizacion();
            return;
        }
        if (obj instanceof HoraExtra) {
            cargarHores_extres();
            return;
        }
    }

    protected abstract void cargarCategorias();

    protected abstract void cargarDepartamentos();

    protected abstract void cargarEmpleados();

    protected abstract void cargarGrupo_Cotizacion();

    protected abstract void cargarHores_extres();

}
