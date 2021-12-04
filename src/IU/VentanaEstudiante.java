package IU;

import Asignatura.Asignatura;
import Asignatura.Obligatoria;
import Asignatura.Optativa;
import Curso.Bachiller;
import Curso.FP;
import Estudiante.Estudiante;
import Lista.ListaEstudiantesAntigua;
import Lista.ListaAsignaturas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class VentanaEstudiante extends JFrame {

    // Constantes
    // Tamaño ventana
    private final int alto_MAX = 600;
    private final int ancho_MAX = 700;

    private final int altoBotonesV = 40 + 27;

    private final int anchoPanelesIzq = ancho_MAX * 35 / 100;
    private final int anchoPanelesDrc = (ancho_MAX * 65 / 100) - 30;

    private final int alturaPEstudiante = 75;
    private final int alturaTituloAsign = 50;
    private final int alturaTipoAsig = 180;
    private final int alturaBotnsAsig = 50;

    // Variables
    private VentanaInicioGestion vInicio;
    private VentanaAsignatura vAsignatura;
    private VentanaCurso vCurso;

    // RELLENAR CON EL TIPO DE ASIGNATURAS
    private ListaEstudiantesAntigua listaEstudiantes;

    // Componentes:
    // Barra de Menu
    private JMenuBar barraMenu;

    private JMenu menu;

    private JMenuItem ventanaPrin;
    private JMenuItem ventanaCurso;
    private JMenuItem ventanaAsign;

    // Paneles
    private JPanel panelLabelsEstudiante; // Panel Labels de Estudiante
    private JPanel panelEstudiante; // Panel para recoger datos Estudiante
    private JPanel panelTituloAsig; // Panel para recoger datos Asignatura
    private JPanelTpAsign panelTipoAsig; // Panel del tipo asignatura
    private JPanel panelBotonListaAsig;
    private JPanel panelAux; // Panel Auxiliar
    private JPanel panelBotonActuaiza;
    private JPanel panelBotonAlta;
    private JPanel panelLEstudiantes;
    private JPanel panelBotonListar;

    // Panel Pantalla//
    // Para enseñar contenido
    private JTextArea pantalla;
    private JScrollPane scrollPane;

    // Panel Estudiante
    private JLabel estudiante;
    private JLabel nombre;
    private JLabel DNI;

    private JTextField areaNombre;
    private JTextField areaDNI;

    // Panel Tipo asignatura//
    private JComboBox listaTipoAsignaturasJBox;
    private JComboBox estudiantesJBox;
    private JButton botonActualiza;
    private JButton botonAlta;
    private JButton botonListarEstudiante;

    // Asignatura
    private JLabel lCurso;

    // Constante
    private final String lAsignatura = "Lista Asignaturas";
    private final String lEstudiantes = "Lista Estudiantes";

    // CONSTRUCTOR//
    public VentanaEstudiante() {
        super("Gestión Estudiantes");
        listaEstudiantes = new ListaEstudiantesAntigua();
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
        // BARRA//
        barraMenu = new JMenuBar();
        menu = new JMenu("Menú");
        ventanaPrin = new JMenuItem("Menú Principal");
        ventanaCurso = new JMenuItem("Gestión Cursos");
        ventanaAsign = new JMenuItem("Gestión Asignaturas");

        menu.add(ventanaPrin);
        menu.add(ventanaCurso);
        menu.add(ventanaAsign);
        barraMenu.add(menu);

        // BOTONES//
        botonAlta = new JButton("ALTA");
        botonAlta.setBackground(Color.BLACK);

        botonActualiza = new JButton("Actualizar Lista");
        botonActualiza.setBackground(Color.BLACK);

        botonListarEstudiante = new JButton("Listar");
        botonListarEstudiante.setBackground(Color.BLACK);

        listaTipoAsignaturasJBox = new JComboBox();
        listaTipoAsignaturasJBox.addItem(lAsignatura);

        estudiantesJBox = new JComboBox();
        estudiantesJBox.addItem(lEstudiantes);

        // PANELES//
        // Panel "Tipo Estudiante"
        panelLabelsEstudiante = new JPanel();
        // new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        panelLabelsEstudiante.setLayout(new GridLayout(3, 1, 5, 1));
        panelLabelsEstudiante.setVisible(true);

        panelEstudiante = new JPanel();
        // new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        panelEstudiante.setLayout(new GridLayout(2, 1, 5, 1));
        panelEstudiante.setVisible(true);

        // Panel "Tipo asignatura"
        panelTituloAsig = new JPanel();
        // new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        panelTituloAsig.setLayout(new GridLayout(1, 2, 5, 1));
        panelTituloAsig.setVisible(true);

        // 2 = NO JComboBox
        panelTipoAsig = new JPanelTpAsign(2);

        panelBotonListaAsig = new JPanel();
        panelBotonListaAsig.setLayout(new GridLayout(1, 1, 5, 1));
        panelBotonListaAsig.setVisible(true);

        panelBotonActuaiza = new JPanel();
        panelBotonActuaiza.setLayout(new GridLayout(1, 1, 5, 1));
        panelBotonActuaiza.setVisible(true);

        panelBotonAlta = new JPanel();
        panelBotonAlta.setLayout(new GridLayout(1, 1, 5, 1));
        panelBotonAlta.setVisible(true);

        panelLEstudiantes = new JPanel();
        panelLEstudiantes.setLayout(new GridLayout(1, 1, 5, 1));
        panelLEstudiantes.setVisible(true);

        panelBotonListar = new JPanel();
        panelBotonListar.setLayout(new GridLayout(1, 1, 5, 1));
        panelBotonListar.setVisible(true);

        // Paneles Auxiliares
        panelAux = new JPanel();
        panelAux.setVisible(true);

        // Areas de texto//
        // Pantalla
        pantalla = new JTextArea("");
        // sólo va a cambiar el tamaño a 16 puntos
        pantalla.setFont(pantalla.getFont().deriveFont(16f));
        pantalla.setEditable(false);
        pantalla.setVisible(true);
        // Scroll Pane
        scrollPane = new JScrollPane(pantalla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVisible(true);

        // Estudiante
        areaNombre = new JTextField("");
        areaNombre.setEditable(true);

        areaDNI = new JTextField("");
        areaDNI.setEditable(true);

        // Labels
        estudiante = new JLabel("ESTUDIANTE");
        estudiante.setFont(new Font("Arial", Font.PLAIN, 16));
        estudiante.setVerticalAlignment(SwingConstants.CENTER);
        nombre = new JLabel("Nombre:");
        // this.tipo.setFont(new Font("Arial", Font.PLAIN, 24));
        nombre.setVerticalAlignment(SwingConstants.CENTER);

        DNI = new JLabel("DNI:");
        // this.tipo.setFont(new Font("Arial", Font.PLAIN, 24));
        DNI.setVerticalAlignment(SwingConstants.CENTER);

        lCurso = new JLabel("CURSO");
        lCurso.setFont(new Font("Arial", Font.PLAIN, 16));
        lCurso.setVerticalAlignment(SwingConstants.CENTER);

        // Acciones al presionar el botón "Actualizar"
        botonActualiza.addActionListener((ActionEvent ae) -> {
            actualizarLista();
        });

        // Acciones al presionar el botón "Alta Estudiante"
        botonAlta.addActionListener((ActionEvent ae) -> {
            accionAlta();
        });

        // Acciones al presionar el botón de la barra de menú "Menú Principal"
        ventanaPrin.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            vInicio.setVisible(true);
        });

        // Acciones al presionar el botón de la barra de menú "Gestión Cursos"
        ventanaCurso.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            vCurso.setVisible(true);
        });

        // Acciones al presionar el botón de la barra de menú "Gestión Estudiantes"
        ventanaAsign.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            vAsignatura.setVisible(true);
        });

        botonListarEstudiante.addActionListener((ActionEvent ae) -> {
            accionListarEstudiante();
        });

        // .setBounds(x,y,ancho,alto)
        panelLabelsEstudiante.setBounds(10, 0, 100, alturaPEstudiante);
        panelEstudiante.setBounds(anchoPanelesIzq + 20, 20, anchoPanelesDrc - 100, alturaPEstudiante - 20);
        panelBotonAlta.setBounds(anchoPanelesIzq + 25 + (anchoPanelesDrc - 100), 20, 95, alturaPEstudiante - 20);

        panelLEstudiantes.setBounds(10, alturaPEstudiante + 10, anchoPanelesIzq, alturaTituloAsign);
        panelBotonListar.setBounds(10, alturaTituloAsign + 10 + alturaPEstudiante + 10, anchoPanelesIzq, 30);

        panelTituloAsig.setBounds(10, alturaTituloAsign + 10 + alturaPEstudiante, anchoPanelesIzq, alturaTituloAsign);
        panelTipoAsig.setBounds(10, alturaTituloAsign + 15 + alturaPEstudiante + alturaTituloAsign, anchoPanelesIzq, 40 + alturaTipoAsig);

        panelBotonActuaiza.setBounds(10, alto_MAX - altoBotonesV - 2 * alturaBotnsAsig - 20, anchoPanelesIzq,
                alturaBotnsAsig);
        panelBotonListaAsig.setBounds(10, alto_MAX - altoBotonesV - alturaBotnsAsig - 5, anchoPanelesIzq,
                alturaBotnsAsig);

        scrollPane.setBounds(anchoPanelesIzq + 20, alturaPEstudiante + 10, anchoPanelesDrc,
                alto_MAX - altoBotonesV - 90);

        // Añadimos componentes a los paneles
        // Panel Estudiate
        panelLabelsEstudiante.add(estudiante);
        panelLabelsEstudiante.add(nombre);
        panelLabelsEstudiante.add(DNI);

        panelEstudiante.add(areaNombre);
        panelEstudiante.add(areaDNI);

        panelBotonAlta.add(botonAlta);

        // Panel Tipo Asignatura
        panelLEstudiantes.add(estudiantesJBox);
        panelBotonListar.add(botonListarEstudiante);

        panelTituloAsig.add(lCurso);
        panelTituloAsig.add(panelAux);

        panelBotonListaAsig.add(listaTipoAsignaturasJBox);
        panelBotonActuaiza.add(botonActualiza);

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

        listaTipoAsignaturasJBox.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                if (!jComboBoxAsigIsEmpety()) {
                    actualizarListaEstudiantesAuto();
                }
            }
        });

        estudiantesJBox.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                if (!jComboBoxEstIsEmpety()) {
                    accionListarEstudiante();
                } else {
                    pantalla.setText("");
                }
            }
        });

        // Añadir componentes
        this.setJMenuBar(barraMenu);

        this.getContentPane().add(panelEstudiante);
        this.getContentPane().add(panelLabelsEstudiante);
        this.getContentPane().add(panelLEstudiantes);
        //this.getContentPane().add(panelBotonListar);
        this.getContentPane().add(panelBotonAlta);
        this.getContentPane().add(panelTituloAsig);
        this.getContentPane().add(panelTipoAsig);
        this.getContentPane().add(panelBotonActuaiza);
        this.getContentPane().add(panelBotonListaAsig);

        this.getContentPane().add(scrollPane);

    }

    /**
     * Actión al pulsar el boton actualizar
     */
    private void actualizarLista() {
        //Si se ha seleccionado un elemento de la lista de asignaturas
        if (!isEmptySelectA()) {

            //Se limpia la lista
            listaTipoAsignaturasJBox.removeAllItems();
            //Se añade la cabecera
            listaTipoAsignaturasJBox.addItem(lAsignatura);
            //Lista auxiliar de asignaturas, servira para ordenar alfabeticamente
            ListaAsignaturas lista_auxiliar = new ListaAsignaturas();
            switch (panelTipoAsig.getSelect()) {
                // FP - Obligatoria
                case 1:
                    for (int i = 0; i < vInicio.getListaGlobalCursos().getSize(); i++) {
                        if (vInicio.getListaGlobalCursos().getCurso(i).getClass() == FP.class) {
                            //Algoritmo para todos los casos:
                            //Recorremos el array Lista global de cursos, cuando encontremos el que cumple el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro, se añaden al JBox.
                            for (int j = 0; j < vInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {

                                if (vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Obligatoria.class) {
                                    lista_auxiliar.addObject(vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));

                                }
                            }
                        }
                    }
                    lista_auxiliar.ordenarLista();
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listaTipoAsignaturasJBox.addItem(lista_auxiliar.getAsignatura(i));
                    }
                    break;
                // FP - Optativa
                case 2:
                    for (int i = 0; i < vInicio.getListaGlobalCursos().getSize(); i++) {
                        if (vInicio.getListaGlobalCursos().getCurso(i).getClass() == FP.class) {
                            //Algoritmo para todos los casos:
                            //Recorremos el array Lista global de cursos, cuando encontremos el que cumple el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro, se añaden al JBox.
                            for (int j = 0; j < vInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Optativa.class) {
                                    lista_auxiliar.addObject(vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
                                }
                            }
                        }
                    }
                    lista_auxiliar.ordenarLista();
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listaTipoAsignaturasJBox.addItem(lista_auxiliar.getAsignatura(i));
                    }
                    break;
                // Bach - Obligatoria
                case 3:
                    for (int i = 0; i < vInicio.getListaGlobalCursos().getSize(); i++) {
                        if (vInicio.getListaGlobalCursos().getCurso(i).getClass() == Bachiller.class) {
                            //Algoritmo para todos los casos:
                            //Recorremos el array Lista global de cursos, cuando encontremos el que cumple el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro, se añaden al JBox.
                            for (int j = 0; j < vInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Obligatoria.class) {
                                    lista_auxiliar.addObject(vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
                                }
                            }
                        }
                    }
                    lista_auxiliar.ordenarLista();
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listaTipoAsignaturasJBox.addItem(lista_auxiliar.getAsignatura(i));
                    }
                    break;
                // Bach - Optativa
                case 4:
                    for (int i = 0; i < vInicio.getListaGlobalCursos().getSize(); i++) {
                        if (vInicio.getListaGlobalCursos().getCurso(i).getClass() == Bachiller.class) {
                            //Algoritmo para todos los casos:
                            //Recorremos el array Lista global de cursos, cuando encontremos el que cumple el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro, se añaden al JBox.
                            for (int j = 0; j < vInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Optativa.class) {
                                    lista_auxiliar.addObject(vInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
                                }
                            }
                        }
                    }
                    lista_auxiliar.ordenarLista();
                    for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                        listaTipoAsignaturasJBox.addItem(lista_auxiliar.getAsignatura(i));
                    }
                    break;
                default:
                    break;
            }

        }
    }

    /**
     * Verifica si estan vacios los campos
     *
     * @return
     */
    private boolean isEmptySelectA() {
        boolean empty = true;
        if (panelTipoAsig.getSelect() != 0) {
            if (panelTipoAsig.getTipo().equals("Tipos de Cursos")) {
                this.pantalla.setText("Selecciona un tipo de Curso");
            } else if (panelTipoAsig.getTipo().equals("Especialidades")) {
                this.pantalla.setText("Selecciona una Especialidad");
            } else if (panelTipoAsig.getAsignatura().equals("Créditos")) {
                this.pantalla.setText("Selecciona un número de Créditos");
            } else if (panelTipoAsig.getAsignatura().equals("Perfiles")) {
                this.pantalla.setText("Selecciona un Perfil");
            } else {
                empty = false;
            }
        } else {
            this.pantalla.setText("No están todos los botones seleccionados");
        }
        return empty;
    }

    /**
     * Acción que da de alta un estudiante
     */
    private void accionAlta() {
        //Si alguno de los campos que definen un alumno, esta vacío
        if (areaNombre.getText().equals("") || areaDNI.getText().equals("")) {
            this.pantalla.setText("RELLENE TODOS LOS CAMPOS");
        } else {
            //Si el elemento seleccionado es igual a la cabecera
            if (listaTipoAsignaturasJBox.getSelectedItem().equals(lAsignatura)) {

                this.pantalla.setText("Selecciona una Asignatura de la lista");

            } else {
                //Asignatura auxiliar, se crea a partir del objeto seleccionado en la lista, haciendo cast porque devuelve Object
                Asignatura auxiliar = (Asignatura) listaTipoAsignaturasJBox.getSelectedItem();
                //Indice de la asignatura seleccionada en la lista, en la lista global
                int indice = vInicio.getListaGlobalAsignaturas().getIndice(auxiliar);

                //Alumno nuevo, se crea a partir de los campos 
                Estudiante es = new Estudiante(areaNombre.getText(), Integer.parseInt(areaDNI.getText()));
                boolean matriculado = false;
                for (int i = 0; i < vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getSizeRef(); i++) {

                    if (vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getRefEstudiante(i).getNombre().equals(es.getNombre()) && 
                            vInicio.getListaGlobalEstudiantes().getAsignatura(indice).getRefEstudiante(i).getDni().equals(es.getDni())) {
                        matriculado = true;
                    }
                }

                if (matriculado == false) {
                    boolean original = true;
                    int indiceAlumno = 0;
                    for (int i = 0; i < vInicio.getListaGlobalEstudiantes().getSize(); i++) {
                        if (vInicio.getListaGlobalEstudiantes().getEstudiante(i).getNombre().equals(es.getNombre()) && 
                                vInicio.getListaGlobalEstudiantes().getEstudiante(i).getDni().equals(es.getDni())) {
                            original = false;
                            indiceAlumno = i;
                        }
                    }
                    if (original) {
                        vInicio.getListaGlobalEstudiantes().addObject(es);
                        vInicio.getListaGlobalAsignaturas().getAsignatura(indice).add(vInicio.getListaGlobalEstudiantes().getEstudiante(vInicio.getListaGlobalEstudiantes().getSize() - 1));
                        vInicio.getListaGlobalEstudiantes().getEstudiante(vInicio.getListaGlobalEstudiantes().getSize() - 1).addAsignatura(vInicio.getListaGlobalAsignaturas().getAsignatura(indice));
                        this.estudiantesJBox.addItem(vInicio.getListaGlobalEstudiantes().getEstudiante(vInicio.getListaGlobalEstudiantes().getSize() - 1));

                    } else {
                        vInicio.getListaGlobalEstudiantes().getEstudiante(indiceAlumno).addAsignatura(vInicio.getListaGlobalAsignaturas().getAsignatura(indice));
                        vInicio.getListaGlobalAsignaturas().getAsignatura(indice).add(vInicio.getListaGlobalEstudiantes().getEstudiante(indiceAlumno));
                        //Se añade al Jbox el nuevo alumno
                        this.estudiantesJBox.addItem(vInicio.getListaGlobalEstudiantes().getEstudiante(indiceAlumno));
                    }
                    this.pantalla.setText("Se ha matriculado:\nAlumno " + es);
                } else {
                    this.pantalla.setText("ESTE ESTUDIANTE YA ESTABA MATRICULADO EN ESTA ASIGNATURA");
                }
                inItEstudiantes();
            }
        }

    }

    /**
     * Acción al presionar el botón de listar. Indicar de que asignaturas (con
     * el tipo, perfil y credits de cada una de ellos) está matriculado y a que
     * curso (indicando el tipo y especialidad del curso) pertenece cada
     * asignatura.
     */
    private void accionListarEstudiante() {
        //Lista auxiliar de asignaturas
        ListaAsignaturas lista_auxiliar = new ListaAsignaturas();
        //Si no se ha seleccionada la cabecera
        if (!estudiantesJBox.getSelectedItem().equals(lEstudiantes)) {
            //Se crea un alumno auxiliar, que es igual al seleccionado en el Jbox
            Estudiante auxiliar = (Estudiante) estudiantesJBox.getSelectedItem();
            //Se busca el indice de este alumno en la lista global de alumnos
            int indice = vInicio.getListaGlobalEstudiantes().getIndice(auxiliar);
            //Se calcula el tamaño de la lista de referncia de dicho alumno
            int size = vInicio.getListaGlobalEstudiantes().getEstudiante(indice).getSizeRef();
            //Si hay asignaturas enlazadas a este alumno
            if (size != 0) {
                //Se añaden a la lista auxiliar de asignaturas
                for (int i = 0; i < size; i++) {
                    lista_auxiliar.addObject(vInicio.getListaGlobalEstudiantes().getEstudiante(indice).getRefAsignaturaEstudiante(i));
                }
                //Se ordenada la lista
                lista_auxiliar.ordenarLista();

                String listado = "";
                for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                    listado = listado + lista_auxiliar.getAsignatura(i).toString() + "\n" + "Curso: "
                            + lista_auxiliar.getAsignatura(i).getStringCurso() + "\n";

                }

                this.pantalla.setText(listado);
            } else {
                this.pantalla.setText("NO SE HAN ENCONTRADO ASIGNATURAS");
            }

        }
    }

    /**
     * Metodo que muestra automaticamente la lista global de los estudiantes
     */
    private void actualizarListaEstudiantesAuto() {
        //Se resetea el estudianteJBox
        estudiantesJBox.removeAllItems();
        estudiantesJBox.addItem(lEstudiantes);
        //Lista auxiliar de alumnos
        ListaEstudiantesAntigua lista_auxiliar = new ListaEstudiantesAntigua();

        //Si el objeto seleccionado del JBox es perteneciente a Optativa o a Obligatoria
        if (listaTipoAsignaturasJBox.getSelectedItem().getClass() == Optativa.class || listaTipoAsignaturasJBox.getSelectedItem().getClass() == Obligatoria.class) {
            //Se crea una asignatura auxiliar, igual a la seleccioanda en el Jbox
            Asignatura auxiliar = (Asignatura) listaTipoAsignaturasJBox.getSelectedItem();

            //Se busca el indice de esta asignatura en la lista global de asignaturas
            int indice = vInicio.getListaGlobalAsignaturas().getIndice(auxiliar);
            //Se calcula el numero de estudiantes matriculados de esta asignatura
            int size = vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getSizeRef();

            //Si hay algun estudiante matriculado
            if (size != 0) {

                for (int i = 0; i < size; i++) {
                    lista_auxiliar.addObject(vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getRefEstudiante(i));
                }
                //Se ordena la lista
                lista_auxiliar.ordenarLista();

                String listado = "CURSO: " + vInicio.getListaGlobalAsignaturas().getAsignatura(indice).getStringCurso() + "\n\n" + "ESTUDIANTES" + "\n\n";
                for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                    listado = listado + lista_auxiliar.getEstudiante(i).toString() + "\n\n";
                    estudiantesJBox.addItem(lista_auxiliar.getEstudiante(i));
                }

                this.pantalla.setText(listado);
            } else {
                this.pantalla.setText("NO SE HAN ENCONTRADO ALUMNOS MATRICULADOS");
            }

        }
    }

    /**
     * Ponemos todos los campos en blanco
     */
    private void inIt() {
        this.areaNombre.setText("");
        this.areaDNI.setText("");

        this.pantalla.setText("");
        this.listaTipoAsignaturasJBox.removeAllItems();
        this.listaTipoAsignaturasJBox.addItem(lAsignatura);

        inItEstudiantes();
    }

    /**
     * Método que recorre todos los estudiantes y los añado al JComboBox
     */
    private void inItEstudiantes() {
        this.estudiantesJBox.removeAllItems();
        this.estudiantesJBox.addItem(lEstudiantes);
        ListaEstudiantesAntigua lista_auxiliar = vInicio.getListaGlobalEstudiantes();
        for (int i = 0; i < lista_auxiliar.getSize(); i++) {
            if (lista_auxiliar.getEstudiante(i).getSizeRef() != 0) {
                this.estudiantesJBox.addItem(lista_auxiliar.getEstudiante(i));
            }
        }

    }

    private boolean jComboBoxAsigIsEmpety() {
        return listaTipoAsignaturasJBox.getSelectedItem().equals(lAsignatura);
    }

    private boolean jComboBoxEstIsEmpety() {
        return estudiantesJBox.getSelectedItem().equals(lEstudiantes);
    }

    private void cerrarVentana() {
        this.dispose();
    }

    public void setInicio(VentanaInicioGestion vI) {
        vInicio = vI;
        vAsignatura = vInicio.getvAsignatura();
        vCurso = vInicio.getvCurso();
    }

    public ListaEstudiantesAntigua getListaEstudiantes() {
        return listaEstudiantes;
    }

}
