package gestorEmpresa.gestor;

import gestorEmpresa.primitivo.Categoria;

import java.util.ArrayList;

/**
 * @author David Serna
 */
public class GestorCategoria {
    private static ArrayList<Categoria> categorias = new ArrayList<>(1); //clases_primitivas.Categoria.csv

    public static ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public static void setCategorias(ArrayList<Categoria> categorias) {
        GestorCategoria.categorias = categorias;
    }
}
