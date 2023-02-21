package gestorEmpresa.gestor;

import gestorEmpresa.primitivo.Departamento;
import gestorEmpresa.primitivo.Empleado;
import gestorEmpresa.primitivo.GrupoCotizacion;
import gestorEmpresa.primitivo.HoraExtra;
import gestorEmpresa.Utilidades;
import java.util.ArrayList;
/**
 * @author David Serna
 * @since 20/02/2023
 * @version 2.0.0
 */
public class GestorHorasExtras {
    private static ArrayList<HoraExtra> horasExtras = new ArrayList<>(1); // Horas_Extras.csv
    public static ArrayList<HoraExtra> getHorasExtras() {
        return horasExtras;
    }

    public static void setHorasExtras(ArrayList<HoraExtra> horasExtras) {
        GestorHorasExtras.horasExtras = horasExtras;
    }

    /**
     * Método que elimina las horas extras de un empleado
     * @param id
     */
    public static void eliminarHorasExtraEmpleado(int id) {
        for (int j = 0; j < horasExtras.size(); j++) {
            if (horasExtras.get(j).getId_usuario() == id) {
                horasExtras.remove(j);
            }
        }
    }
    /**
     * Método que devuelve las horas extras de un grupo de cotización
     * {@link Utilidades#mostrarMensaje(String)}
     */
    public static void horasExtraGrupoCotizacion() {

        int horasTotales = 0;
        int id = Utilidades.leerEntero("Introduzca la ID del grupo de cotización:");
        for (GrupoCotizacion grupoCotizacion : GestorGruposCotizacion.getGruposCotizacion()) {

            if(grupoCotizacion.getId() == id) {

                for(Empleado empleado : GestorEmpleados.getEmpleados()) {
                    if(id == empleado.getGrupo_Cotizacion()){
                        for(HoraExtra hora : horasExtras) {
                            if (empleado.getId_usuario() == hora.getId_usuario()) {
                                horasTotales = horasTotales + hora.getHoras();
                            }
                        }
                    }
                }

            }
        }
        Utilidades.mostrarMensaje("Horas extras del grupo de cotizacion " + id + ": " + horasTotales);
    }
    /**
     * Método que devuelve las horas extras de un departamento
     * {@link Utilidades#mostrarError(String)}
     * {@link Utilidades#mostrarMensaje(String)}
     */
    public static void horasExtraDepartamento() {
        String departamento;
        int id_departamento = 0;
        int horasTotales = 0;
        try {
            departamento = Utilidades.leerCadena("Introduzca el nombre del departamento:").toUpperCase();

            for (Departamento dep : GestorDepartamentos.getDepartamentos()){
                if(departamento.equals(dep.getNombre())){
                    id_departamento = dep.getId();
                }
            }

            for(Empleado empleado : GestorEmpleados.getEmpleados()){
                if(id_departamento == empleado.getId_departamento()){
                    for(HoraExtra hora : horasExtras) {
                        if (empleado.getId_usuario() == hora.getId_usuario()) {
                            horasTotales = horasTotales + hora.getHoras();
                        }
                    }
                }
            }
            Utilidades.mostrarMensaje("Horas extras del departamento " + departamento + " " + horasTotales);
        } catch (Exception e) {
            Utilidades.mostrarError("Entrada no válida.");
        }
    }

}
