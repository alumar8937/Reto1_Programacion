import java.util.ArrayList;

public class GestorCategoria {
    private static ArrayList<Categoria> categorias = new ArrayList<>(1); //Categoria.csv

    public static ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public static void setCategorias(ArrayList<Categoria> categorias) {
        GestorCategoria.categorias = categorias;
    }
}
