package Main;

import IU.VentanaAsignatura;
import IU.VentanaCurso;
import IU.VentanaEstudiante;
import IU.VentanaInicioGestion;
import Lista.ListaAsignaturas;
import Lista.ListaCursos;
import Lista.ListaEstudiantes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author luisb
 */
public class GestionColegios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GestionColegios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ListaAsignaturas listaAsignaturas = new ListaAsignaturas();
        ListaCursos listaCursos = new ListaCursos();
        ListaEstudiantes listaEstudiantes = new ListaEstudiantes();
        
        VentanaCurso vCurso = new VentanaCurso();
        VentanaAsignatura vAsign = new VentanaAsignatura();
        VentanaEstudiante vEstud = new VentanaEstudiante();

        VentanaInicioGestion vInicio = new VentanaInicioGestion(vCurso, vAsign, vEstud, listaCursos, listaAsignaturas, listaEstudiantes);
    }
    
}
