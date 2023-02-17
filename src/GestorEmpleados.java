import java.util.ArrayList;

public class GestorEmpleados {
    private static ArrayList<Empleado> empleados = new ArrayList<>(1); // Datos_Empresa.csv + Datos_Personales.csv

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Métoodo que saca los datos personales de un empleado según su ID
     * {@link Utilidades#leerEntero(String)}
     * {@link Utilidades#mostrarMensaje(String)}
     * {@link Utilidades#mostrarError(String)}
     */
    private static void obtenerDatosPersonalesID() { // Author: David Serna

        int id_pedido;

        try {
            id_pedido = Utilidades.leerEntero("Introduzca la id del empleado:");


            for(Empleado empleado : empleados){
                if(id_pedido == empleado.getId_usuario()){
                    Utilidades.mostrarMensaje("NIF del empleado: " + empleado.getNIF() +
                            "\nNombre del empleado: " + empleado.getNombre() +
                            "\nPrimer apellido del empleado: " + empleado.getApellido1() +
                            "\nSegundo apellido del empleado: " + empleado.getApellido2() +
                            "\nNúmero de la Seguridad Social del empleado: " + empleado.getNum_SegSocial());
                }
            }
        } catch (Exception e) {
            Utilidades.mostrarError("Entrada no válida.");
        }

    }

    /**
     * Métoodo que saca los datos empresariales de un empleado según su ID
     * {@link Utilidades#leerEntero(String)}
     * {@link Utilidades#mostrarMensaje(String)}
     * {@link Utilidades#mostrarError(String)}
     */
    private static void obtenerDatosEmpresaID() { //Author: Javier Blasco
        int id_solicitada;

        try {
            id_solicitada = Utilidades.leerEntero("Introduce la id del empleado");

            for(Empleado empleado : empleados){
                if(id_solicitada == empleado.getId_usuario()){
                    Utilidades.mostrarMensaje("ID del departamento: " + empleado.getId_departamento() +
                            "\nAntiguedad del empleado: " + empleado.getAntiguedad() +
                            "\nCategoría profesional al que pertence: " + empleado.getCat_GrupoProfesional() +
                            "\nGrupo de cotización al que pertenece: " + empleado.getGrupo_Cotizacion() +
                            "\nEmail del empleado: " + empleado.getEmail());
                }
            }
        } catch (Exception e) {
            Utilidades.mostrarError("Entrada no válida.");
        }
    }

    /**
     * Método que consulta la información de los empleados de un departamento en específico
     * {@link Utilidades#mostrarError(String)}
     * {@link Utilidades#leerCadena(String)}
     * {@link Utilidades#mostrarMensaje(String)}
     */
    private static void consultarEmpleadosDepartamento() { //Author: David Serna
        String departamento;
        int id_dep = 0;
        try {
            departamento = Utilidades.leerCadena("Introduzca el nombre del departamento:");

            id_dep = GestorDepartamentos.consultarIdporNombreDepartamento(departamento);

            for(Empleado empleado : empleados){
                if(id_dep == empleado.getId_departamento()){
                    Utilidades.mostrarMensaje("NIF del empleado: " + empleado.getNIF() +
                            "\nNombre del empleado: " + empleado.getNombre() +
                            "\nPrimer apellido del empleado: " + empleado.getApellido1() +
                            "\nSegundo apellido del empleado: " + empleado.getApellido2() +
                            "\nNúmero de la Seguridad Social del empleado: " + empleado.getNum_SegSocial());
                }
            }
        } catch (Exception e) {
            Utilidades.mostrarError("Entrada no válida.");
        }

    }

    /**
     * Método que calcula el coste salarial de la empresa
     * {@link Utilidades#mostrarMensaje(String)}
     * {@link Utilidades#mostrarError(String)}
     */
    private static void costeSalarial() { //Author: Javier Blasco
        int costeTotal = 0;
        try {
            for(GrupoCotizacion grupoCotizacion : GestorGruposCotizacion.getGruposCotizacion()) {
                for (Empleado empleado : empleados) {
                    if (grupoCotizacion.getId() == empleado.getGrupo_Cotizacion()) {
                        costeTotal = costeTotal + grupoCotizacion.getSueldo_base();
                    }
                }
            }
            Utilidades.mostrarMensaje("Coste salarial de la empresa: " + costeTotal + " €");
        } catch (Exception e) {
            Utilidades.mostrarError("Error");
        }
    }
    /**
     * Método que agrega un usuario mediante la solicitud de los datos personales y de empresa de este
     * {@link Utilidades#leerEntero(String)}
     * {@link Utilidades#leerCadena(String)}
     * {@link Utilidades#mostrarPeticionDeConfirmacion(String)}
     * {@link Utilidades#mostrarError(String)}
     */
    private static void agregarDatosUsuario(){ //Author: David Serna
        try {
            int id_departamento = Utilidades.leerEntero("Introduzca la id del departamento del empleado: ");
            String NIF = Utilidades.leerCadena("Introduzca el NIF del empleado: ").toUpperCase();
            String nombre = Utilidades.leerCadena("Introduzca el nombre del empleado: ").toUpperCase();
            String apellido1 = Utilidades.leerCadena("Introduzca el primer apellido del empleado: ").toUpperCase();
            String apellido2 = Utilidades.leerCadena("Introduzca el segundo apellido del empleado: ").toUpperCase();
            int num_SegSocial = Utilidades.leerEntero("Introduzca el numero de la SS del empleado: ");
            String antiguedad = Utilidades.leerCadena("Introduzca la fecha en la que empezo a trabajar el empleado (Ejemplo: dd/mm/year): ");
            String cat_GrupoProfesional = Utilidades.leerCadena("Introduzca la categoria del grupo profesional del empleado: ");
            int grupo_Cotizacion = Utilidades.leerEntero("Introduzca el grupo de cotización del empleado: ");
            String email = Utilidades.leerCadena("Introduzca el email del usuario: ");


            if(!Utilidades.mostrarPeticionDeConfirmacion("NIF del empleado: " + NIF +
                    "\nNombre del empleado: " + nombre +
                    "\nPrimer apellido del empleado: " + apellido1 +
                    "\nSegundo apellido del empleado: " + apellido2 +
                    "\nNúmero de la Seguridad Social del empleado: " + num_SegSocial +
                    "\nID del departamento: " + id_departamento +
                    "\nAntiguedad del empleado: " + antiguedad +
                    "\nCategoría profesional al que pertence: " + cat_GrupoProfesional +
                    "\nGrupo de cotización al que pertenece: " + grupo_Cotizacion +
                    "\nEmail del empleado: " + email)) {
                return;
            }

            int indicemax = 0;
            for(Empleado empleado : empleados){
                if(empleado.getId_usuario() > indicemax){
                    indicemax = empleado.getId_usuario();
                }
            }

            empleados.add(new Empleado(indicemax + 1,id_departamento,NIF,nombre,apellido1,apellido2,num_SegSocial,antiguedad,
                    cat_GrupoProfesional,grupo_Cotizacion,email));

            GestorHorasExtras.getHorasExtras.add(new HoraExtra(indicemax + 1, 0));
        } catch (Exception e) {

            Utilidades.mostrarError("Entrada no válida.");

        }

    }
}
