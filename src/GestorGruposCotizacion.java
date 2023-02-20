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
}
