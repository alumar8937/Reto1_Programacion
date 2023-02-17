import java.util.ArrayList;

public class GestorGruposCotizacion {
    private static ArrayList<GrupoCotizacion> gruposCotizacion = new ArrayList<>(1); // Datos_GrupoCotizacion.csv
    public static ArrayList<GrupoCotizacion> getGruposCotizacion() {
        return gruposCotizacion;
    }
}
