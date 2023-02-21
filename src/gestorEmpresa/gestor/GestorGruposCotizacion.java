package gestorEmpresa.gestor;

import gestorEmpresa.primitivo.GrupoCotizacion;
import gestorEmpresa.Utilidades;
import java.util.ArrayList;
/**
 * @author David Serna
 * @since 20/02/2023
 * @version 2.0.0
 */
public class GestorGruposCotizacion {
    private static ArrayList<GrupoCotizacion> gruposCotizacion = new ArrayList<>(1); // Datos_GrupoCotizacion.csv
    public static ArrayList<GrupoCotizacion> getGruposCotizacion() {
        return gruposCotizacion;
    }

    public static void setGruposCotizacion(ArrayList<GrupoCotizacion> gruposCotizacion) {
        GestorGruposCotizacion.gruposCotizacion = gruposCotizacion;
    }

    /**
     * Método que comprueba si el grupo de cotización existe
     * @param grupo_cotizacion
     * @return devuelve true o false dependiendo de si existe el grupo de cotización
     * {@link Utilidades#mostrarError(String)}
     */
    private static boolean comprobarGrupoCotizacion(int grupo_cotizacion) {
        try {

            for(GrupoCotizacion grupoCotizacion : gruposCotizacion){

                if (grupoCotizacion.getId() == grupo_cotizacion) {
                    return true;
                }

            }
            return false;

        }catch (Exception e){
            Utilidades.mostrarError("Esta id no existe.");
            return false;
        }
    }
    /**
     * Método que elimina un grupo de cotización si es posible
     * {@link Utilidades#mostrarMensaje(String)}
     * {@link Utilidades#leerEntero(String)}
     * {@link GestorGruposCotizacion#comprobarGrupoCotizacion(int)}
     * {@link GestorEmpleados#contarEmpleadosGrupoCotizacion(int)}
     */
    public static void eliminarGrupoCotizacion() {
        int indice_grupocot = 0;
        int grupo_cotizacion = Utilidades.leerEntero("Introduzca la id del grupo de cotización que desea eliminar:");

        if (!comprobarGrupoCotizacion(grupo_cotizacion)) {
            Utilidades.mostrarMensaje("La id introducida no existe.");
            return;
        }

        int contar_empleados = GestorEmpleados.contarEmpleadosGrupoCotizacion(grupo_cotizacion);

        if (contar_empleados != 0){
            Utilidades.mostrarMensaje("Tienes " + contar_empleados + " empleados en el grupo de cotización "
                    + grupo_cotizacion + ", mientras tengas empleados no puedes eliminar el grupo de coti" +
                    "zación.");
            return;

        }

        for (GrupoCotizacion grupocot : gruposCotizacion){
            if(grupocot.getId() == grupo_cotizacion){
                indice_grupocot = gruposCotizacion.indexOf(grupocot);
            }
        }
        gruposCotizacion.remove(indice_grupocot);
        Utilidades.mostrarMensaje("Se ha eliminado el grupo de cotización correctamente.");
    }
    /**
     * Método que agrega un grupo de cotización nuevo
     * {@link Utilidades#mostrarPeticionDeConfirmacion(String)}
     * {@link Utilidades#leerEntero(String)}
     * {@link Utilidades#mostrarError(String)}
     */
    public static void agregarDatosGrupoCotizacion() {
        try {
            int sueldo_grupcotizacion = Utilidades.leerEntero("Introduzca el sueldo del base del grupo cotización: ");


            if(!Utilidades.mostrarPeticionDeConfirmacion("Sueldo base del grupo_cot: " + sueldo_grupcotizacion)) {
                return;
            }

            int indicemax = 0;
            for(GrupoCotizacion grupoCotizacion: gruposCotizacion){
                if(grupoCotizacion.getId() > indicemax){
                    indicemax = grupoCotizacion.getId();
                }
            }

            gruposCotizacion.add(new GrupoCotizacion(indicemax + 1, sueldo_grupcotizacion));


        } catch (Exception e) {

            Utilidades.mostrarError("Entrada no válida.");

        }
    }
}
