import java.util.ArrayList;

public class GestorDepartamentos {
    private static ArrayList<Departamento> departamentos = new ArrayList<>(1); // Datos_Departamento.csv

    public static int consultarIdporNombreDepartamento(String departamento) {
        for (Departamento dep : departamentos){
            if(departamento.equalsIgnoreCase(dep.getNombre())){
                return dep.getId();
            }
        }
        return 0;
    }
}
