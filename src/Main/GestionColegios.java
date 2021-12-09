package Main;

import IU.VentanaAsignatura;
import IU.VentanaCurso;
import IU.VentanaEstudiante;
import IU.VentanaInicio;
import Lista.ListaAsignaturas;
import Lista.ListaCursos;
import Lista.ListaEstudiantes;

/**
 *
 * @author luisb
 */
public class GestionColegios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaAsignaturas listaAsignaturas = new ListaAsignaturas();
        ListaCursos listaCursos = new ListaCursos();
        ListaEstudiantes listaEstudiantes = new ListaEstudiantes();

        VentanaCurso vCurso = new VentanaCurso();
        VentanaAsignatura vAsign = new VentanaAsignatura();
        VentanaEstudiante vEstud = new VentanaEstudiante();

        VentanaInicio vInicio = new VentanaInicio(vCurso, vAsign, vEstud, listaCursos, listaAsignaturas, listaEstudiantes);

        vCurso.setInicio(vInicio);
        vAsign.setInicio(vInicio);
        vEstud.setInicio(vInicio);

        vInicio.setVisible(true);
    }
}
