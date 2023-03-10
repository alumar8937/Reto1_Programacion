package gestorEmpresa.primitivo;

/**
 * Define tanto la información personal de un empleado como la informacion.
 *
 * @author Pedro Marín Sanchis
 * @version V.2
 * @since 18/12/2022
 */
public class Empleado extends DatosPersonales {

    private int id_departamento;
    private String antiguedad;
    private String cat_GrupoProfesional;
    private int grupo_Cotizacion;
    private String email;

    /**
     * Constructor de clases_primitivas.Empleado
     * @param id_usuario
     * @param id_departamento
     * @param NIF
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param num_SegSocial
     * @param antiguedad
     * @param cat_GrupoProfesional
     * @param grupo_Cotizacion
     * @param email
     */
    public Empleado(int id_usuario, int id_departamento, String NIF, String nombre, String apellido1,
                    String apellido2, int num_SegSocial, String antiguedad, String cat_GrupoProfesional,
                    int grupo_Cotizacion, String email) {

        this.id_usuario = id_usuario;
        this.id_departamento = id_departamento;
        this.NIF = NIF;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.num_SegSocial = num_SegSocial;
        this.antiguedad = antiguedad;
        this.cat_GrupoProfesional = cat_GrupoProfesional;
        this.grupo_Cotizacion = grupo_Cotizacion;
        this.email = email;

    }

    public Empleado(){
        this.id_usuario = 0;
        this.id_departamento = 0;
        this.NIF = null;
        this.nombre = null;
        this.apellido1 = null;
        this.apellido2 = null;
        this.num_SegSocial = 0;
        this.antiguedad =  null;
        this.cat_GrupoProfesional = null;
        this.grupo_Cotizacion = 0;
        this.email = null;

    }

    /**
     * <pre>
     * Este método devuelve un array de Strings donde cada valor representa diferente información del empleado.
     * [0] : ID
     * [1] : ID clases_primitivas.Departamento
     * [2] : NIF
     * [3] : Nombre
     * [4] : Primer apellido
     * [5] : Segundo apellido
     * [6] : Número de la Seguridad Social
     * [7] : Antigüedad
     * [8] : Categoría / Grupo Profesional
     * [9] : Grupo de Cotización
     * [10]: Email
     * </pre>
     * @return String[]
     */
    public String[] toStringArray() {
        return new String[]{String.valueOf(this.id_usuario), String.valueOf(this.id_departamento),
                this.NIF, this.nombre, this.apellido1, this.apellido2, String.valueOf(this.num_SegSocial),
                this.antiguedad, this.cat_GrupoProfesional, String.valueOf(this.grupo_Cotizacion), this.email};
    }

    /**
     * @return id_departamento
     */
    public int getId_departamento() {
        return id_departamento;
    }

    /**
     * @return antiguedad
     */
    public String getAntiguedad() {
        return antiguedad;
    }

    /**
     * @return cat_GrupoProfesional
     */
    public String getCat_GrupoProfesional() {
        return cat_GrupoProfesional;
    }

    /**
     * @return grupo_Cotizacion
     */
    public int getGrupo_Cotizacion() {
        return grupo_Cotizacion;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece la variable id_departamento
     * @param id_departamento
     */
    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    /**
     * Establece la variable antiguedad
     * @param antiguedad
     */
    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    /**
     * Establece la variable cat_GrupoProfesional
     * @param cat_GrupoProfesional
     */
    public void setCat_GrupoProfesional(String cat_GrupoProfesional) {
        this.cat_GrupoProfesional = cat_GrupoProfesional;
    }

    /**
     * Establece la variable grupo_Cotizacion
     * @param grupo_Cotizacion
     */
    public void setGrupo_Cotizacion(int grupo_Cotizacion) {
        this.grupo_Cotizacion = grupo_Cotizacion;
    }

    /**
     * Establece la variable email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
