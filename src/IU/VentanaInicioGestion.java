package IU;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Lista.ListaAsignaturas;
import Lista.ListaCursos;
import Lista.ListaEstudiantes;

public class VentanaInicioGestion extends JFrame {

    //VARIABLES GLOBALES
    private ListaAsignaturas lista_global_asignaturas;
    private ListaCursos lista_global_cursos;
    private ListaEstudiantes lista_global_alumnos;

    //INICIALIZACIÓN VARIABLES GLOBALES
    //lista_global_asignaturas
    //Tamaño Pantalla
    private final int alto_MAX = 300;
    private final int ancho_MAX = 600;

    //Componentes:
    private JPanel panelBotones;
    private JPanel panelTitulo;

    private JButton bCurso;
    private JButton bAsign;
    private JButton bEstud;

    private JLabel titulo;

    //Ventanas para abrir
    VentanaAsignatura vAsignatura;
    VentanaEstudiante vEstudiante;
    VentanaCurso vCurso;

    //Constructor
    public VentanaInicioGestion(VentanaCurso vC, VentanaAsignatura vA, VentanaEstudiante vE, ListaCursos listaCurso, ListaAsignaturas listaAsignatura, ListaEstudiantes listaAlumnos) {
        super("Programa de Gestión de Datos Colegio");
        vCurso = vC;
        vAsignatura = vA;
        vEstudiante  = vE;

        lista_global_cursos = listaCurso;
        lista_global_asignaturas = listaAsignatura;
        lista_global_alumnos=listaAlumnos;
        initComponents();
    }

    private void initComponents() {
        //+35 por los botones de la ventana y +5 para las separaciones Horitzontales
        this.setSize(ancho_MAX, alto_MAX);
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

        this.bAsign = new JButton("Asignatura");
        this.bAsign.setBackground(Color.BLACK);

        this.bEstud = new JButton("Estudiante");
        this.bEstud.setBackground(Color.BLACK);

        ///Actiones Botones///
        //Acciones al presionar el botón "Curso"
        bCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cerrarVentana();
                vCurso.setVisible(true);
            }
        });

        //Acciones al presionar el botón "Asignatura"
        bAsign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cerrarVentana();
                vAsignatura.setVisible(true);
            }
        });

        //Acciones al presionar el botón "Estudiante"
        bEstud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cerrarVentana();
                vEstudiante.setVisible(true);
            }
        });

        //.setBounds(x,y,ancho,alto)
        panelBotones.setBounds(27, this.alto_MAX - 100, this.ancho_MAX - 60, 30);
        panelTitulo.setBounds(0+7, 20, this.ancho_MAX - 20, this.alto_MAX - 20);
        //titulo.setBounds(this.ancho_MAX/2 - 50, 0,200,200);

        //Añadir componentes
        panelBotones.add(bCurso);
        panelBotones.add(bAsign);
        panelBotones.add(bEstud);

        panelTitulo.add(titulo);

        //Añadimos paneles a la ventana
        this.getContentPane().add(panelBotones);
        this.getContentPane().add(panelTitulo);

    }

    private void cerrarVentana() {
        this.dispose();
    }

    public VentanaCurso getvCurso(){
        return vCurso;
    }

    public void setListaGlobalCursos(ListaCursos x){
        this.lista_global_cursos = x;
    }

    public ListaCursos getListaGlobalCursos(){
        return this.lista_global_cursos;
    }
    public ListaAsignaturas getListaGlobalAsignaturas(){
        return this.lista_global_asignaturas;
    }
     public ListaEstudiantes getListaGlobalAlumnos(){
        return this.lista_global_alumnos;
        
    }
      public void setetListaGlobalAlumnos(ListaEstudiantes x){
        this.lista_global_alumnos=x;
        
    }
    public void setListaAsignaturas(ListaAsignaturas la){
        this.lista_global_asignaturas = la;
    }
    

    
    public VentanaAsignatura getvAsignatura() {
        return vAsignatura;
    }

    public VentanaEstudiante getvEstudiante() {
        return vEstudiante;
    }
    
    private VentanaInicioGestion getInicio(){
        return this;
    }

}
