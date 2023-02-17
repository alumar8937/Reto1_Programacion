import java.util.ArrayList;

public abstract class FuenteDeDatos {

    File archivoFuente = null;

    public FuenteDeDatos(File archivoFuente) {
        this.archivoFuente = archivoFuente;
    }

    public abstract ArrayList<Object> obtener(Object obj);

}
