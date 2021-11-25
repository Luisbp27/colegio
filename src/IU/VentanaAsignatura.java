package IU;

import Asignatura.Asignatura;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import Clases.Bachiller;
import Clases.FP;
import Asignatura.Obligatoria;
import Asignatura.Optativa;
import Lista.Lista_Alumnos;
import Lista.Lista_Asignaturas;


public class VentanaAsignatura extends JFrame {

    // Constantes
    public static final String listaAsig = "Lista Asignatura";
    // Tamaño ventana
    private final int alto_MAX = 500;
    private final int ancho_MAX = 700;

    private final int altoBotonesV = 40 + 27;
    private final int anchoPanelesIz = ancho_MAX * 35 / 100;
    private final int anchoPanelesDr = ancho_MAX * 65 / 100;
    private final int altoTipAsig = 300;
    private final int altoBtnAsig = 50;

    // Variables
    private VentanaInicioGestion vInicio;
    private VentanaEstudiante vEstudiante;
    private VentanaCurso vCurso;

    // Componentes:
    // Barra de Menu
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem ventanaPrin;
    private JMenuItem ventanaCurso;
    private JMenuItem ventanaEstud;

    // Paneles
    private JPanelTpAsign panelTipoAsignatura;
    private JPanel panelBotonesAsignatura; // Botones y labels
    private JPanel panelListaAsignatura;

    // Panel Izquierdo
    // private JButton indicarC;
    private JComboBox listaAsignaturas;
    private JButton actualizarA;
    private JButton listarC;

    // Panel derecho
    // Para enseñar contenido
    private JTextArea pantalla;
    private JScrollPane scrollPane;

    // Constructores
    public VentanaAsignatura() {
        super("Gestión Asignaturas");
        initComponents();
    }

    public VentanaAsignatura(VentanaInicioGestion inicio) {
        super("Gestión Asignaturas");
        vInicio = inicio;
        initComponents();
    }

    private void initComponents() {

        this.setSize(ancho_MAX, alto_MAX);
        this.setLocationRelativeTo(null);

        // Quitamos el Layout para ordenar los paneles
        this.getContentPane().setLayout(null);

        // Cierre con la X de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // No ensanchable
        this.setResizable(false);

        // Componentes:
        // Barra
        barraMenu = new JMenuBar();
        menu = new JMenu("Menú");
        ventanaPrin = new JMenuItem("Menú Principal");
        ventanaCurso = new JMenuItem("Gestión Cursos");
        ventanaEstud = new JMenuItem("Gestión Estudiantes");

        menu.add(ventanaPrin);
        menu.add(ventanaCurso);
        menu.add(ventanaEstud);
        barraMenu.add(menu);

        // Paneles "Tipo Asignatura"
        // 3 = NO JComboBox
        panelTipoAsignatura = new JPanelTpAsign(2);

        panelListaAsignatura = new JPanel();
        panelListaAsignatura.setLayout(new GridLayout(1, 1, 5, 1));
        panelListaAsignatura.setVisible(true);

        panelBotonesAsignatura = new JPanel();
        // new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        panelBotonesAsignatura.setLayout(new GridLayout(1, 2, 5, 1));
        panelBotonesAsignatura.setVisible(true);

        // Areas de texto (JTextArea)
        pantalla = new JTextArea("");
        // sólo va a cambiar el tamaño a 16 puntos
        pantalla.setFont(pantalla.getFont().deriveFont(16f));
        pantalla.setEditable(false);
        pantalla.setVisible(true);
        // Scroll Pane
        scrollPane = new JScrollPane(pantalla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVisible(true);

        // Botones
        listaAsignaturas = new JComboBox();
        listaAsignaturas.addItem(listaAsig);

        actualizarA = new JButton("Actualizar");
        actualizarA.setBackground(Color.BLACK);

        listarC = new JButton("Listar Curso");
        listarC.setBackground(Color.BLACK);

        // Acciones al presionar el botón "Indicar Curso"
        actualizarA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionActualizarCurso();
            }
        });

        // Acciones al presionar el botón "Listar curso"
        listarC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionListarCurso();
            }
        });

        // Acciones al presionar el botón de la barra de menú "Menú Principal"
        ventanaPrin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cerrarVentana();
                vInicio.setVisible(true);
            }
        });

        // Acciones al presionar el botón de la barra de menú "Gestión Cursos"
        ventanaCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cerrarVentana();
                vCurso.setVisible(true);
            }
        });

        // Acciones al presionar el botón de la barra de menú "Gestión Estudiantes"
        ventanaEstud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cerrarVentana();
                vEstudiante.setVisible(true);
            }
        });

        // Escuchadores Panel
        scrollPane.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                inIt();
            }

            @Override
            public void ancestorRemoved(AncestorEvent ae) {
            }

            @Override
            public void ancestorMoved(AncestorEvent ae) {
            }
        });

        // .setBounds(x,y,ancho,alto)
        panelTipoAsignatura.setBounds(10, 0, anchoPanelesIz, altoTipAsig);
        panelListaAsignatura.setBounds(10, altoTipAsig + 5, anchoPanelesIz, altoBtnAsig);
        panelBotonesAsignatura.setBounds(10, altoTipAsig + altoBotonesV, anchoPanelesIz, altoBtnAsig);
        scrollPane.setBounds(anchoPanelesIz + 20, 0, anchoPanelesDr - 30, this.alto_MAX - this.altoBotonesV);

        // Añadimos componentes a los paneles
        panelBotonesAsignatura.add(actualizarA);
        panelBotonesAsignatura.add(listarC);

        panelListaAsignatura.add(listaAsignaturas);

        // Añadir componentes
        this.setJMenuBar(barraMenu);
        this.getContentPane().add(panelTipoAsignatura);
        this.getContentPane().add(panelListaAsignatura);
        this.getContentPane().add(panelBotonesAsignatura);
        this.getContentPane().add(scrollPane);

    }

    /// ACCIONES DE LOS BOTONES///
    private void accionActualizarCurso() {
        // Si combo NO box vacio
        if (!panelTipoAsignatura.isEmpty()) {
            listaAsignaturas.removeAllItems();
            listaAsignaturas.addItem(listaAsig);
            Lista_Asignaturas lista_auxiliar = new Lista_Asignaturas();
            switch (panelTipoAsignatura.getSelect()) {
                // FP - Obligatoria
                case 1:
                    for (int i = 0; i < vInicio.getListaGlobalCursos().getSize(); i++) {
                        if (vInicio.getListaGlobalCursos().getCurso(i).getClass() == FP.class) {
                            // Algoritmo para todos los casos:
                            // Recorremos el array Lista global de cursos, cuando encontremos el que cumple
                            // el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro,
                            // se añaden al JBox.
                            for (int j = 0; j < vInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Obligatoria.class) {
                                    lista_auxiliar.addObject(vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));

                                }
                            }
                        }

                    }
                    lista_auxiliar.ordenarLista();
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listaAsignaturas.addItem(lista_auxiliar.getAsignatura(i));
                    }
                    break;
                // FP - Optativa
                case 2:
                    for (int i = 0; i < vInicio.getListaGlobalCursos().getSize(); i++) {
                        if (vInicio.getListaGlobalCursos().getCurso(i).getClass() == FP.class) {
                            // Algoritmo para todos los casos:
                            // Recorremos el array Lista global de cursos, cuando encontremos el que cumple
                            // el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro,
                            // se añaden al JBox.
                            for (int j = 0; j < vInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Optativa.class) {
                                    lista_auxiliar.addObject(vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
                                }
                            }
                        }

                    }
                    lista_auxiliar.ordenarLista();
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listaAsignaturas.addItem(lista_auxiliar.getAsignatura(i));
                    }
                    break;
                // Bach - Obligatoria
                case 3:
                    for (int i = 0; i < vInicio.getListaGlobalCursos().getSize(); i++) {
                        if (vInicio.getListaGlobalCursos().getCurso(i).getClass() == Bachiller.class) {
                            // Algoritmo para todos los casos:
                            // Recorremos el array Lista global de cursos, cuando encontremos el que cumple
                            // el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro,
                            // se añaden al JBox.
                            for (int j = 0; j < vInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Obligatoria.class) {
                                    lista_auxiliar.addObject(vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
                                }
                            }
                        }
                    }
                    lista_auxiliar.ordenarLista();
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listaAsignaturas.addItem(lista_auxiliar.getAsignatura(i));
                    }
                    break;
                // Bach - Optativa
                case 4:
                    for (int i = 0; i < vInicio.getListaGlobalCursos().getSize(); i++) {
                        if (vInicio.getListaGlobalCursos().getCurso(i).getClass() == Bachiller.class) {
                            // Algoritmo para todos los casos:
                            // Recorremos el array Lista global de cursos, cuando encontremos el que cumple
                            // el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro,
                            // se añaden al JBox.
                            for (int j = 0; j < vInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Optativa.class) {
                                    lista_auxiliar.addObject(vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
                                }
                            }
                        }
                    }
                    lista_auxiliar.ordenarLista();
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listaAsignaturas.addItem(lista_auxiliar.getAsignatura(i));
                    }
                    break;
            }
            this.pantalla.setText("¡Lista actualizada!");

        } else {
            this.pantalla.setText("No hay ningún filtro seleccionado");
        }
    }

    /**
     * Acción al presional el botón de Listar
     */
    private void accionListarCurso() {
        //Lista auxiliar de alumnos
        Lista_Alumnos lista_auxiliar = new Lista_Alumnos();
        //Si el tipo de asignatura seleccionado no esta vacio
        if (!panelTipoAsignatura.isEmpty()) {
            //Y si el elemento seleccionado del Jbox no es la cabecera
            if (!listaAsignaturas.getSelectedItem().equals(listaAsig)) {
                //Se crea una asignatura auxiliar que es igual a la seleccionada en el Jbox
                Asignatura auxiliar = (Asignatura) listaAsignaturas.getSelectedItem();
                //Indice de la asignatura seleccionada en la lista global de asignaturas
                int indice = vInicio.getListaGlobalAsignaturas().getIndice(auxiliar);
                //Numero de alumnos matriculados en esta asignatura
                int size = vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getSizeRef();
                //Si hay alguno matriculado
                if (size != 0) {
                    for (int i = 0; i < size; i++) {
                        lista_auxiliar.addObject(vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getAlumnoRef(i));
                    }
                    lista_auxiliar.ordenarLista();
                    String listado = "CURSO: " + vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getCursoPerteneciente() + "\n\n" + "ESTUDIANTES" + "\n\n";
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listado = listado + lista_auxiliar.getAlumno(i).toString() + "\n\n";

                    }
                    this.pantalla.setText(listado);
                } else {
                    this.pantalla.setText("CURSO: "+vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getCursoPerteneciente()+"\nEn esta asigantura \nno hay ningún alumno matriculado");
                }
            } else {
                this.pantalla.setText("Selecciona una asignatura");
            }
        } else {
            this.pantalla.setText("No hay ningún filtro seleccionado");
        }

    }

    /**
     * Ponemos todos los campos en blanco
     */
    private void inIt() {
        this.pantalla.setText("");
        this.listaAsignaturas.removeAllItems();
        this.listaAsignaturas.addItem(listaAsig);
    }

    public void setInicio(VentanaInicioGestion vig) {
        this.vInicio = vig;
        this.vEstudiante = vInicio.getvEstudiante();
        this.vCurso = vInicio.getvCurso();
    }

    private void cerrarVentana() {
        this.dispose();
    }
}
