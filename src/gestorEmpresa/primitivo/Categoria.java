package gestorEmpresa.primitivo;

/**
 * Clase que define un Grupo Profesional.
 * 
 * @author Pedro Marín Sanchis
 * @version V.1
 * @since 18/12/2022
 */
public class Categoria {

    final private String cat_GrupoProfesional;

    /**
     * Constructor de clases_primitivas.Categoria
     * @param cat_GrupoProfesional
     */
    public Categoria(String cat_GrupoProfesional) {

        this.cat_GrupoProfesional = cat_GrupoProfesional;

    }

    public Categoria(){
        this.cat_GrupoProfesional = null;
    }

    /**
     * @return cat_GrupoProfesional
     */
    public String getCat_GrupoProfesional() {

        return this.cat_GrupoProfesional;

    }

}
