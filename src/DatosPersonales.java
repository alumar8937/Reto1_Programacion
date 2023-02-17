/**
 * Define la información personal de una personal.
 *
 * @author Pedro Marín Sanchis
 * @version V.0
 * @since 17/02/2023
 */
public abstract class DatosPersonales {

    protected int id_usuario = 0;
    protected String NIF;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected int num_SegSocial;

    /**
     * @return id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * Establece la variable num_SegSocial
     * @param num_SegSocial
     */
    public void setNum_SegSocial(int num_SegSocial) {
        this.num_SegSocial = num_SegSocial;
    }

    /**
     * Establece la variable NIF
     * @param NIF
     */
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    /**
     * Establece la variable nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la variable apellido1
     * @param apellido1
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Establece la variable apellido2
     * @param apellido2
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @return apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @return num_SegSocial
     */
    public int getNum_SegSocial() {
        return num_SegSocial;
    }

}
