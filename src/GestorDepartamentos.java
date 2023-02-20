import java.util.ArrayList;
/**
 * @author David Serna
 * @since 20/02/2023
 * @version 2.0.0
 */
public class GestorDepartamentos {

    private static ArrayList<Departamento> departamentos = new ArrayList<>(1); // Datos_Departamento.csv
    public static ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public static void setDepartamentos(ArrayList<Departamento> departamentos) {
        GestorDepartamentos.departamentos = departamentos;
    }

    public static int consultarIdporNombreDepartamento(String departamento) {
        for (Departamento dep : departamentos){
            if(departamento.equalsIgnoreCase(dep.getNombre())){
                return dep.getId();
            }
        }
        return 0;
    }
    /**
     * Método que comprueba si una id de departamento existe
     * {@link Utilidades#mostrarError(String)}
     * @param id_departamento
     * @return devuelve verdadero o falso dependiendo de si existe
     */
    public static boolean comprobarDepartamento(int id_departamento) {
        try {

            for(Departamento departamento : departamentos){

                if (departamento.getId() == id_departamento) {
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
     * Método que convierte un nombre de departamento a una id
     * @param departamento
     * @return la id del departamento que coincide con el nombre de este si existe
     */
    public static int convertirNombreDepartamentoIdDepartamento(String departamento) {
        for (Departamento dep : departamentos){
            if(dep.getNombre().equalsIgnoreCase(departamento)){
                return dep.getId();
            }
        }
        System.out.println("No existe el departamento");
        return 0;
    }
    /**
     * Método que elimina un departamento
     * {@link GestorDepartamentos#convertirNombreDepartamentoIdDepartamento(String)}
     * {@link GestorDepartamentos#comprobarDepartamento(int)}
     * {@link Utilidades#mostrarMensaje(String)}
     * {@link Utilidades#leerCadena(String)}
     * {@link GestorEmpleados#contarEmpleadosDepartamento(int)}
     */
    public static void eliminarDepartamento() {
        int indice_dep = 0;
        String departamento = Utilidades.leerCadena("Introduzca el nombre del departamento que desea eliminar:");
        int id_departamento = convertirNombreDepartamentoIdDepartamento(departamento);
        if (id_departamento == 0){
            return;
        }


        if (!comprobarDepartamento(id_departamento)) {
            Utilidades.mostrarMensaje("El departamento introducido no existe.");
            return;
        }


        int contar_empleados = GestorEmpleados.contarEmpleadosDepartamento(id_departamento);

        if (contar_empleados != 0){
            Utilidades.mostrarMensaje("Tienes " + contar_empleados + " empleados en el departamento "
                    + departamento + ", mientras tengas empleados no puedes eliminar el departamento " +
                    "reasigna los empleados a otro departamento antes de eliminarlo.");
            return;

        }

        for (Departamento dep : departamentos){
            if(dep.getId() == id_departamento){
                indice_dep = departamentos.indexOf(dep);
            }
        }
        departamentos.remove(indice_dep);
        Utilidades.mostrarMensaje("Se ha eliminado el departamento correctamente.");

    }
    /**
     * Método que modifica un departamento
     * {@link GestorDepartamentos#comprobarDepartamento(int)}
     * {@link Utilidades#leerCadena(String)}
     * {@link Utilidades#leerEntero(String)}
     * {@link Utilidades#mostrarError(String)}
     */
    public static void modificarDepartamento() {

        int id = Utilidades.leerEntero("Introduzca la ID del departamento:");

        if (comprobarDepartamento(id)) {

            for (Departamento i: departamentos) {

                if (id == i.getId()) {

                    i.setNombre(Utilidades.leerCadena("Introduzca el nuevo nombre de departamento:"));

                }

            }

        } else {

            Utilidades.mostrarError("No se ha encontrado el departamento.");

        }

    }
    /**
     * Método que agrega un departamento
     * {@link GestorDepartamentos#comprobarDepartamento(int)}
     * {@link Utilidades#leerEntero(String)}
     * {@link Utilidades#mostrarError(String)}
     */
    public static void agregarDepartamento() {

        int id = Utilidades.leerEntero("Introduzca la ID del departamento:");

        if (!comprobarDepartamento(id)) {

            departamentos.add(new Departamento(id, Utilidades.leerCadena("Introduzca el nombre del nuevo departamento:")));

        } else {

            Utilidades.mostrarError("No se ha encontrado el departamento.");

        }

    }

}
