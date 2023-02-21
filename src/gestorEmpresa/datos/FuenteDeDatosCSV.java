package gestorEmpresa.datos;

import gestorEmpresa.gestor.*;
import gestorEmpresa.primitivo.*;
import gestorEmpresa.Utilidades;
import java.util.ArrayList;

public class FuenteDeDatosCSV extends FuenteDeDatos {


    // CABECERAS CSV

    final private static String cabecera_Categoria = "cat_GrupoProfesional";
    final private static String cabecera_Datos_Empresa = "id_usuario;id_departamento;antiguedad;cat_GrupoProfesional;grupo_Cotizacion;email";
    final private static String cabecera_Datos_Personales = "id_usuario;NIF;Nombre;Apellido1;Apellido2;num_SegSocial";
    final private static String cabecera_Departamento = "id;Nombre";
    final private static String cabecera_Grupo_Cotizacion = "Id;sueldo_base";
    final private static String cabecera_Hores_extres = "id_usuario;hora";

    private DocumentoCSV CategoriaCSV = null;
    private DocumentoCSV Datos_EmpresaCSV = null;
    private DocumentoCSV Datos_PersonalesCSV = null;
    private DocumentoCSV DepartamentoCSV = null;
    private DocumentoCSV Grupo_CotizacionCSV = null;
    private DocumentoCSV Hores_extresCSV = null;

    public FuenteDeDatosCSV(DocumentoCSV categoriaCSV, DocumentoCSV Datos_EmpresaCSV, DocumentoCSV Datos_PersonalesCSV,
                            DocumentoCSV DepartamentoCSV, DocumentoCSV Grupo_CotizacionCSV, DocumentoCSV Hores_extresCSV){
        this.CategoriaCSV = categoriaCSV;
        this.Datos_EmpresaCSV = Datos_EmpresaCSV;
        this.Datos_PersonalesCSV = Datos_PersonalesCSV;
        this.DepartamentoCSV = DepartamentoCSV;
        this.Grupo_CotizacionCSV = Grupo_CotizacionCSV;
        this.Hores_extresCSV = Hores_extresCSV;
    }

    /**
     * Carga la categoria de los ficheros csv importados dentro de un arraylist, en el caso de que
     * no tanga campos soltara un error.
     * {@link Utilidades#mostrarError(String)}
     */
    protected void cargarCategorias() {

        ArrayList<Categoria> lista = new ArrayList<>(1);

        if (CategoriaCSV.obtenerCantidadDeCampos() > 0) {

            for (int i = 1; i < CategoriaCSV.obtenerCantidadDeCampos(); i++) {

                lista.add(new Categoria(CategoriaCSV.obtenerValor(i, 0)));

            }

            GestorCategoria.setCategorias(lista);

        } else {

            Utilidades.mostrarError("Los archivos no son válidos.");

        }

    }

    /**
     * A partir de los gestorEmpresa.datos que se enquentran en los csv importados la informacion de estos la carga en un arraylist
     * para su posterior uso.
     * {@link Utilidades#mostrarError(String)}
     */
    protected void cargarEmpleados() {

        ArrayList<Empleado> lista = new ArrayList<>(1);

        if (Datos_PersonalesCSV.obtenerCantidadDeCampos() > 0 && Datos_EmpresaCSV.obtenerCantidadDeCampos() > 0) {

            for (int i = 1; i < Datos_PersonalesCSV.obtenerCantidadDeCampos(); i++) {

                int id_usuario = Integer.parseInt(Datos_PersonalesCSV.obtenerValor(i,0));
                int id_departamento = Integer.parseInt(Datos_EmpresaCSV.obtenerValor(i,1));
                String NIF = Datos_PersonalesCSV.obtenerValor(i, 1);
                String nombre = Datos_PersonalesCSV.obtenerValor(i, 2);
                String apellido1 = Datos_PersonalesCSV.obtenerValor(i, 3);
                String apellido2 = Datos_PersonalesCSV.obtenerValor(i, 4);
                int num_SegSocial = 0;
                String antiguedad = Datos_EmpresaCSV.obtenerValor(i, 2);
                String cat_GrupoProfesional = Datos_EmpresaCSV.obtenerValor(i, 3);
                int grupo_Cotizacion = Integer.parseInt(Datos_EmpresaCSV.obtenerValor(i, 4));
                String email = Datos_EmpresaCSV.obtenerValor(i, 5);

                lista.add(new Empleado(id_usuario, id_departamento, NIF, nombre, apellido1, apellido2, num_SegSocial, antiguedad, cat_GrupoProfesional, grupo_Cotizacion, email));

            }

            GestorEmpleados.setEmpleados(lista);

        } else {

            Utilidades.mostrarError("Los archivos no son válidos.");

        }

    }

    /**
     * A partir de los gestorEmpresa.datos que se enquentran en los csv importados la informacion de estos la carga en un arraylist
     * para su posterior uso.
     * {@link Utilidades#mostrarError(String)}
     */
    protected void cargarDepartamentos() {

        ArrayList<Departamento> lista = new ArrayList<>(1);

        if (DepartamentoCSV.obtenerCantidadDeCampos() > 0) {

            for (int i = 1; i < DepartamentoCSV.obtenerCantidadDeCampos(); i++) {

                lista.add(new Departamento(Integer.parseInt(DepartamentoCSV.obtenerValor(i, 0)), DepartamentoCSV.obtenerValor(i, 1)));

            }

            GestorDepartamentos.setDepartamentos(lista);

        } else {

            Utilidades.mostrarError("Los archivos no son válidos.");

        }

    }

    /**
     * A partir de los gestorEmpresa.datos que se enquentran en los csv importados la informacion de estos la carga en un arraylist
     * para su posterior uso.
     * {@link Utilidades#mostrarError(String)}
     */
    protected void cargarGrupo_Cotizacion() {

        ArrayList<GrupoCotizacion> lista = new ArrayList<>(1);

        if (Grupo_CotizacionCSV.obtenerCantidadDeCampos() > 0) {

            for (int i = 1; i < Grupo_CotizacionCSV.obtenerCantidadDeCampos(); i++) {

                lista.add(new GrupoCotizacion(Integer.parseInt(Grupo_CotizacionCSV.obtenerValor(i, 0)), Integer.parseInt(Grupo_CotizacionCSV.obtenerValor(i, 1))));

            }

            GestorGruposCotizacion.setGruposCotizacion(lista);

        } else {

            Utilidades.mostrarError("Los archivos no son válidos.");

        }

    }

    /**
     * A partir de los gestorEmpresa.datos que se enquentran en los csv importados la informacion de estos la carga en un arraylist
     * para su posterior uso.
     * {@link Utilidades#mostrarError(String)}
     */
    protected void cargarHores_extres() {

        ArrayList<HoraExtra> lista = new ArrayList<>(1);

        if (Hores_extresCSV.obtenerCantidadDeCampos() > 0) {

            for (int i = 1; i < Hores_extresCSV.obtenerCantidadDeCampos(); i++) {

                lista.add(new HoraExtra(Integer.parseInt(Hores_extresCSV.obtenerValor(i, 0)), Integer.parseInt(Hores_extresCSV.obtenerValor(i, 1))));

            }

            GestorHorasExtras.setHorasExtras(lista);

        } else {

            Utilidades.mostrarError("Los archivos no son válidos.");

        }

    }


}
