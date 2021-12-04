package IU;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Lista.ListaAsignaturas;
import Lista.ListaCursos;
import Lista.ListaEstudiantes;

public class VentanaInicio extends JFrame {

    //VARIABLES GLOBALES
    private ListaAsignaturas lista_global_asignaturas;
    private ListaCursos lista_global_cursos;
    private ListaEstudiantes lista_global_estudiantes;

    //INICIALIZACIÓN VARIABLES GLOBALES
    //lista_global_asignaturas
    //Tamaño Pantalla
    private static final int ALTURA = 300;
    private static final int ANCHURA = 600;

    //Componentes:
    private JPanel panelBotones;
    private JPanel panelTitulo;

    private JButton bCurso;
    private JButton bAsignatura;
    private JButton bEstudiante;

    private JLabel titulo;

    //Ventanas para abrir
    VentanaAsignatura ventanaAsignatura;
    VentanaEstudiante ventanaEstudiante;
    VentanaCurso ventanaCurso;

    //Constructor
    public VentanaInicio(VentanaCurso ventanaCurso, VentanaAsignatura ventanaAsignatura, VentanaEstudiante ventanaEstudiante, ListaCursos listaCurso, ListaAsignaturas listaAsignatura, ListaEstudiantes listaEstudiantes) {
        super("Programa de Gestión de Datos Colegio");
        this.ventanaCurso = ventanaCurso;
        this.ventanaAsignatura = ventanaAsignatura;
        this.ventanaEstudiante = ventanaEstudiante;

        lista_global_cursos = listaCurso;
        lista_global_asignaturas = listaAsignatura;
        lista_global_estudiantes = listaEstudiantes;
        initComponents();
    }

    private void initComponents() {
        //+35 por los botones de la ventana y +5 para las separaciones Horitzontales
        this.setSize(ANCHURA, ALTURA);
        this.setLocationRelativeTo(null);

        //Quitamos el Layout para ordenar los paneles
        this.getContentPane().setLayout(null);

        //Cierre con la X de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //No ensanchable
        this.setResizable(false);

        ////Componentes////
        //Paneles
        this.panelBotones = new JPanel();
        //new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        panelBotones.setLayout(new GridLayout(1, 3, 20, 0));
        panelBotones.setVisible(true);

        this.panelTitulo = new JPanel();
        panelTitulo.setVisible(true);

        //Labels
        this.titulo = new JLabel("GESTIÓN DE DATOS");
        this.titulo.setFont(new Font("Arial", Font.PLAIN, 24));
        this.titulo.setVerticalAlignment(SwingConstants.CENTER);
       
        //Botones
        this.bCurso = new JButton("Curso");
        this.bCurso.setBackground(Color.BLACK);

        this.bAsignatura = new JButton("Asignatura");
        this.bAsignatura.setBackground(Color.BLACK);

        this.bEstudiante = new JButton("Estudiante");
        this.bEstudiante.setBackground(Color.BLACK);

        ///Actiones Botones///
        //Acciones al presionar el botón "Curso"
        bCurso.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            ventanaCurso.setVisible(true);
        });

        //Acciones al presionar el botón "Asignatura"
        bAsignatura.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            ventanaAsignatura.setVisible(true);
        });

        //Acciones al presionar el botón "Estudiante"
        bEstudiante.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            ventanaEstudiante.setVisible(true);
        });

        //.setBounds(x,y,ancho,alto)
        panelBotones.setBounds(27, VentanaInicio.ALTURA - 100, VentanaInicio.ANCHURA - 60, 30);
        panelTitulo.setBounds(0 + 7, 20, VentanaInicio.ANCHURA - 20, VentanaInicio.ALTURA - 20);
        //titulo.setBounds(this.ancho_MAX/2 - 50, 0,200,200);

        //Añadir componentes
        panelBotones.add(bCurso);
        panelBotones.add(bAsignatura);
        panelBotones.add(bEstudiante);

        panelTitulo.add(titulo);

        //Añadimos paneles a la ventana
        this.getContentPane().add(panelBotones);
        this.getContentPane().add(panelTitulo);

    }

    private void cerrarVentana() {
        this.dispose();
    }

    public VentanaCurso getVentanaCurso() {
        return ventanaCurso;
    }

    public void setListaGlobalCursos(ListaCursos lc) {
        this.lista_global_cursos = lc;
    }

    public ListaCursos getListaGlobalCursos() {
        return this.lista_global_cursos;
    }

    public ListaAsignaturas getListaGlobalAsignaturas() {
        return this.lista_global_asignaturas;
    }

    public ListaEstudiantes getListaGlobalEstudiantes() {
        return this.lista_global_estudiantes;
    }

    public void setListaGlobalEstudiantes(ListaEstudiantes le) {
        this.lista_global_estudiantes = le;
    }

    public void setListaAsignaturas(ListaAsignaturas la) {
        this.lista_global_asignaturas = la;
    }

    public VentanaAsignatura getvAsignatura() {
        return ventanaAsignatura;
    }

    public VentanaEstudiante getvEstudiante() {
        return ventanaEstudiante;
    }

    private VentanaInicio getInicio() {
        return this;
    }
}
