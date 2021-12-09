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
import java.awt.Image;
import javax.swing.ImageIcon;

public class VentanaInicio extends JFrame {

    //VARIABLES GLOBALES
    private ListaAsignaturas lista_global_asignaturas;
    private ListaCursos lista_global_cursos;
    private ListaEstudiantes lista_global_estudiantes;

    //INICIALIZACIÓN VARIABLES GLOBALES
    //lista_global_asignaturas
    //Tamaño Pantalla
    private static final int ALTURA = 500;
    private static final int ANCHURA = 400;

    //Componentes:
    private JPanel panelBotones;
    private JPanel panelTitulo;

    private JButton bCurso;
    private JButton bAsignatura;
    private JButton bEstudiante;

    private JLabel titulo;
    private JLabel imagen;

    //Ventanas para abrir
    VentanaAsignatura ventanaAsignatura;
    VentanaEstudiante ventanaEstudiante;
    VentanaCurso ventanaCurso;

    /**
     * Método constructor de la clase
     *
     * @param ventanaCurso
     * @param ventanaAsignatura
     * @param ventanaEstudiante
     * @param listaCurso
     * @param listaAsignatura
     * @param listaEstudiantes
     */
    public VentanaInicio(VentanaCurso ventanaCurso, VentanaAsignatura ventanaAsignatura, VentanaEstudiante ventanaEstudiante, ListaCursos listaCurso, ListaAsignaturas listaAsignatura, ListaEstudiantes listaEstudiantes) {
        super("Gestión Colegio");
        this.ventanaCurso = ventanaCurso;
        this.ventanaAsignatura = ventanaAsignatura;
        this.ventanaEstudiante = ventanaEstudiante;

        lista_global_cursos = listaCurso;
        lista_global_asignaturas = listaAsignatura;
        lista_global_estudiantes = listaEstudiantes;

        initComponents();
    }

    /**
     * Método que gestiona los componentes de la clase
     *
     */
    private void initComponents() {
        //+35 por los botones de la ventana y +5 para las separaciones Horitzontales
        this.setSize(ANCHURA, ALTURA);
        this.setLocationRelativeTo(null);

        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        ////Componentes////
        //Paneles
        this.panelBotones = new JPanel();
        //new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        panelBotones.setLayout(new GridLayout(3, 1, 0, 20));
        panelBotones.setVisible(true);

        this.panelTitulo = new JPanel();
        panelTitulo.setVisible(true);

        //Labels
        this.titulo = new JLabel("PROGRAMA PRINCIPAL");
        this.titulo.setFont(new Font("Arial", Font.PLAIN, 24));
        this.titulo.setVerticalAlignment(SwingConstants.CENTER);

        this.imagen = new JLabel();
        ImageIcon img = new ImageIcon(this.getClass().getResource("/Imagenes/colegio.png"));
        imagen.setIcon(new ImageIcon(img.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        imagen.setVisible(true);

        //Botones
        this.bCurso = new JButton("Curso");
        this.bCurso.setForeground(Color.WHITE);
        this.bCurso.setBackground(Color.GRAY);

        this.bAsignatura = new JButton("Asignatura");
        this.bAsignatura.setForeground(Color.WHITE);
        this.bAsignatura.setBackground(Color.GRAY);

        this.bEstudiante = new JButton("Estudiante");
        this.bEstudiante.setForeground(Color.WHITE);
        this.bEstudiante.setBackground(Color.GRAY);

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
        panelBotones.setBounds(5 + 80, ALTURA - 200, ANCHURA - 175, 100);
        panelTitulo.setBounds(7, 20, ANCHURA - 20, ALTURA - 20);
        imagen.setBounds(ANCHURA / 2, 25, 200, 200);
        //titulo.setBounds(this.ancho_MAX/2 - 50, 0,200,200);

        //Añadir componentes
        panelBotones.add(bCurso);
        panelBotones.add(bAsignatura);
        panelBotones.add(bEstudiante);
        panelTitulo.add(titulo);

        //Añadimos paneles a la ventana
        this.getContentPane().add(panelBotones);
        this.getContentPane().add(panelTitulo);
        this.getContentPane().add(imagen);

    }

    /**
     * Método que permite cerrar la ventana
     *
     */
    private void cerrarVentana() {
        this.dispose();
    }

    /**
     * Método que devuelve el contenido de la VentanaCurso
     *
     * @return
     */
    public VentanaCurso getVentanaCurso() {
        return ventanaCurso;
    }

    /**
     * Método que modifica el contenido de la lista global de cursos con la
     * lista pasada por parámetro
     *
     * @param lc
     */
    public void setListaGlobalCursos(ListaCursos lc) {
        this.lista_global_cursos = lc;
    }

    /**
     * Método que devuelve el contenido de la lista global de cursos
     *
     * @return
     */
    public ListaCursos getListaGlobalCursos() {
        return this.lista_global_cursos;
    }

    /**
     * Método que devuelve el contenido de la lista global de asignaturas
     *
     * @return
     */
    public ListaAsignaturas getListaGlobalAsignaturas() {
        return this.lista_global_asignaturas;
    }

    /**
     * Método que devuelve el contenido de la lista global de estudiantes
     *
     * @return
     */
    public ListaEstudiantes getListaGlobalEstudiantes() {
        return this.lista_global_estudiantes;
    }

    /**
     * Método que modifica el contenido de la lista global de estudiantes por la
     * lista pasada por parámetro
     *
     * @param le
     */
    public void setListaGlobalEstudiantes(ListaEstudiantes le) {
        this.lista_global_estudiantes = le;
    }

    /**
     * Método que modifica el valor la lista global de asignaturas por la lista
     * pasada por parámetro
     *
     * @param la
     */
    public void setListaAsignaturas(ListaAsignaturas la) {
        this.lista_global_asignaturas = la;
    }

    /**
     * Método que devuelve el contenido de la VentanaAsignatura
     *
     * @return
     */
    public VentanaAsignatura getvAsignatura() {
        return ventanaAsignatura;
    }

    /**
     * Método que devuelve el contenido de la VentanaEstudiante
     *
     * @return
     */
    public VentanaEstudiante getvEstudiante() {
        return ventanaEstudiante;
    }
}
