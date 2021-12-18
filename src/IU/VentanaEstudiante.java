package IU;

import Asignatura.Asignatura;
import Asignatura.Obligatoria;
import Asignatura.Optativa;
import Curso.Bachiller;
import Curso.FP;
import Estudiante.Estudiante;
import Lista.ListaEstudiantes;
import Lista.ListaAsignaturas;
import Lista_Ref.Lista_Ref_Estudiantes;
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
    private static final int ALTURA = 600;
    private static final int ANCHURA = 700;

    private final int altoBotonesV = 40 + 27;

    private final int anchoPanelesIzq = ANCHURA * 35 / 100;
    private final int anchoPanelesDrc = (ANCHURA * 65 / 100) - 30;

    private final int alturaPEstudiante = 75;
    private final int alturaTituloAsign = 50;
    private final int alturaTipoAsig = 180;
    private final int alturaBotnsAsig = 50;

    // Variables
    private VentanaInicio ventanaInicio;
    private VentanaAsignatura ventanaAsignatura;
    private VentanaCurso ventanaCurso;

    // RELLENAR CON EL TIPO DE ASIGNATURAS
    private ListaEstudiantes listaEstudiantes;

    // Componentes:
    // Barra de Menu
    private JMenuBar barraMenu;

    private JMenu menu;

    private JMenuItem ventanaPrin;
    private JMenuItem ventanaCur;
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

    /**
     * Método constructor de la clase
     *
     */
    public VentanaEstudiante() {
        super("Gestión Estudiantes");
        listaEstudiantes = new ListaEstudiantes();

        initComponents();
    }

    /**
     * Método que permite la gestión de los componentes de la clase
     *
     */
    private void initComponents() {
        this.setSize(ANCHURA, ALTURA);
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
        ventanaCur = new JMenuItem("Gestión Cursos");
        ventanaAsign = new JMenuItem("Gestión Asignaturas");

        menu.add(ventanaPrin);
        menu.add(ventanaCur);
        menu.add(ventanaAsign);
        barraMenu.add(menu);

        // BOTONES//
        botonAlta = new JButton("ALTA");
        botonAlta.setForeground(Color.WHITE);
        botonAlta.setBackground(Color.GRAY);

        botonActualiza = new JButton("Actualizar Lista");
        botonActualiza.setForeground(Color.WHITE);
        botonActualiza.setBackground(Color.GRAY);

        botonListarEstudiante = new JButton("Listar");
        botonListarEstudiante.setForeground(Color.WHITE);
        botonListarEstudiante.setBackground(Color.GRAY);

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
            ventanaInicio.setVisible(true);
        });

        // Acciones al presionar el botón de la barra de menú "Gestión Cursos"
        ventanaCur.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            ventanaCurso.setVisible(true);
        });

        // Acciones al presionar el botón de la barra de menú "Gestión Estudiantes"
        ventanaAsign.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            ventanaAsignatura.setVisible(true);
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

        panelBotonActuaiza.setBounds(10, ALTURA - altoBotonesV - 2 * alturaBotnsAsig - 20, anchoPanelesIzq,
                alturaBotnsAsig);
        panelBotonListaAsig.setBounds(10, ALTURA - altoBotonesV - alturaBotnsAsig - 5, anchoPanelesIzq,
                alturaBotnsAsig);

        scrollPane.setBounds(anchoPanelesIzq + 20, alturaPEstudiante + 10, anchoPanelesDrc,
                ALTURA - altoBotonesV - 90);

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
                init();
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
     * Método que realiza la acción al pulsar el boton ACTUALIZAR
     *
     */
    private void actualizarLista() {
        // Si se ha seleccionado un elemento de la lista de asignaturas
        if (!isEmptySelectA()) {
            // Se limpia la lista
            listaTipoAsignaturasJBox.removeAllItems();
            // Se añade la cabecera
            listaTipoAsignaturasJBox.addItem(lAsignatura);
            // Lista auxiliar de asignaturas, servira para ordenar alfabeticamente
            ListaAsignaturas lista_auxiliar = new ListaAsignaturas();

            switch (panelTipoAsig.getSelect()) {
                // FP - Obligatoria
                case 1:
                    for (int i = 0; i < ventanaInicio.getListaGlobalCursos().getSize(); i++) {
                        if (ventanaInicio.getListaGlobalCursos().getCurso(i).getClass() == FP.class) {
                            //Algoritmo para todos los casos:
                            //Recorremos el array Lista global de cursos, cuando encontremos el que cumple el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro, se añaden al JBox.
                            for (int j = 0; j < ventanaInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {

                                if (ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Obligatoria.class) {
                                    lista_auxiliar.addObject(ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
                                    System.out.println("Asignatura " + j);
                                    System.out.println(ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
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
                    for (int i = 0; i < ventanaInicio.getListaGlobalCursos().getSize(); i++) {
                        if (ventanaInicio.getListaGlobalCursos().getCurso(i).getClass() == FP.class) {
                            //Algoritmo para todos los casos:
                            //Recorremos el array Lista global de cursos, cuando encontremos el que cumple el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro, se añaden al JBox.
                            for (int j = 0; j < ventanaInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Optativa.class) {
                                    lista_auxiliar.addObject(ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
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
                    for (int i = 0; i < ventanaInicio.getListaGlobalCursos().getSize(); i++) {
                        if (ventanaInicio.getListaGlobalCursos().getCurso(i).getClass() == Bachiller.class) {
                            //Algoritmo para todos los casos:
                            //Recorremos el array Lista global de cursos, cuando encontremos el que cumple el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro, se añaden al JBox.
                            for (int j = 0; j < ventanaInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Obligatoria.class) {
                                    lista_auxiliar.addObject(ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
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
                    for (int i = 0; i < ventanaInicio.getListaGlobalCursos().getSize(); i++) {
                        if (ventanaInicio.getListaGlobalCursos().getCurso(i).getClass() == Bachiller.class) {
                            //Algoritmo para todos los casos:
                            //Recorremos el array Lista global de cursos, cuando encontremos el que cumple el filtro hacemos:
                            // Recorremos su lista de referencia de asignaturas, las que cumplan el filtro, se añaden al JBox.
                            for (int j = 0; j < ventanaInicio.getListaGlobalCursos().getCurso(i).getSizeRef(); j++) {
                                if (ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j).getClass() == Optativa.class) {
                                    lista_auxiliar.addObject(ventanaInicio.getListaGlobalCursos().getCurso(i).getAsignaturaRef(j));
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
     * Método que verifica si estan vacíos los campos
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
     * Método que realiza la acción de dar de ALTA a un estudiante
     *
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
                int indice=ventanaInicio.getListaGlobalAsignaturas().getIndice(auxiliar);
                Asignatura asignatura_seleccionada=ventanaInicio.getListaGlobalAsignaturas().getAsignatura(indice);
                Lista_Ref_Estudiantes lre = asignatura_seleccionada.getListaEstudiantes();

                //Alumno nuevo, se crea a partir de los campos 
                Estudiante es = new Estudiante(areaNombre.getText(), areaDNI.getText());
                boolean matriculado = false;

                // Recorrer la lista de referencias a estudiantes de la asignatura 
                // selecionada JComboBox para ver si el estudiante está matriculado
                for (int i = 0; i < lre.getSize(); i++) {
                    Estudiante aux = (Estudiante) lre.getObject(i);

                    if (es.getDni().equals(aux.getDni())) {
                        matriculado = true;
                    }
                }

                if (matriculado == false) {
                    boolean original = true;

                    for (int i = 0; i < ventanaInicio.getListaGlobalEstudiantes().getSize(); i++) {
                        Estudiante estudianteAuxiliar = ventanaInicio.getListaGlobalEstudiantes().getEstudiante(i);
                        if (estudianteAuxiliar.getNombre().equals(es.getNombre())
                                && estudianteAuxiliar.getDni().equals(es.getDni())) {
                            original = false;
                            //USAR MISMA INSTANCIA NO OTRA QUE TENÍAMOS EN LA LISTA GLOBAL DE ESTUDIANTES
                            es=ventanaInicio.getListaGlobalEstudiantes().getEstudiante(i);
                        }
                    }

                    // No matriculado en la asignatura y nuevo alumno del curso
                    if (original) {
                        lre.addNodo(es);

                        // Añadimos la asignatura a las respectivas listas
                        ListaEstudiantes borrar= ventanaInicio.getListaGlobalEstudiantes();
                        ventanaInicio.getListaGlobalEstudiantes().setObject(es);
                        es.getListaRefEstudianteAsignatura().addNodo(asignatura_seleccionada);

                        this.pantalla.setText("Se ha matriculado:\nAlumno " + es.toString());
                        System.out.println("No matriculado en la asignatura y nuevo alumno del curso");

                        // No matriculado de la asignatura y no es nuevo alumno del curso
                    } else {
                        asignatura_seleccionada.getListaEstudiantes().addNodo(es);

                        // Añadimos la asignatura a las respectivas listas
                        es.getListaRefEstudianteAsignatura().addNodo(asignatura_seleccionada);

                        this.pantalla.setText("Se ha matriculado:\nAlumno " + es);
                        System.out.println("No matriculado de la asignatura y no es nuevo alumno del curso");
                    }

                } else {
                    this.pantalla.setText("Este estudiante ya está matriculado en esta asignatura.");
                }

                initEstudiantes();
            }
        }
    }

    /**
     * Método que realiza la acción al presionar el botón de LISTAR. Indica de
     * que asignaturas (con el tipo, perfil y credits de cada una de ellos) está
     * matriculado el estudiante seleccionado en el JComboBox y a que curso
     * (indicando el tipo y especialidad del curso) pertenece cada asignatura.
     *
     */
    private void accionListarEstudiante() {
        System.out.println("hola");
        //Lista auxiliar de asignaturas
        ListaAsignaturas lista_auxiliar = new ListaAsignaturas();

        //Si no se ha seleccionada la cabecera
        if (!estudiantesJBox.getSelectedItem().equals(lEstudiantes)) {
            //Se crea un alumno auxiliar, que es igual al seleccionado en el Jbox
            Estudiante estudianteAuxiliar = (Estudiante) estudiantesJBox.getSelectedItem();
            //Se busca el indice de este alumno en la lista global de alumnos
            System.out.println("Contenido lista estuidantes" + ventanaInicio.getListaGlobalEstudiantes().getInfoTotal());
            ListaEstudiantes le=ventanaInicio.getListaGlobalEstudiantes();
            int indice = ventanaInicio.getListaGlobalEstudiantes().getIndicePorNombre(estudianteAuxiliar.getNombre());
            estudianteAuxiliar=ventanaInicio.getListaGlobalEstudiantes().getEstudiante(indice);
            System.out.println("Post" + indice);
            //Se calcula el tamaño de la lista de referncia de dicho alumno
            int size = estudianteAuxiliar.getSizeRef();

            System.out.println("hola2");

            System.out.println(estudianteAuxiliar.getListaRefEstudianteAsignatura().getSize());

            //Si hay asignaturas enlazadas a este alumno
            if (size != 0) {
                System.out.println(size);
                //Se añaden a la lista auxiliar de asignaturas
                for (int i = 0; i < size; i++) {
                    lista_auxiliar.addObject(estudianteAuxiliar.getListaRefEstudianteAsignatura().getInfoNodo(i));
                }

                //Se ordenada la lista
                lista_auxiliar.ordenarLista();
                System.out.println(String.valueOf(lista_auxiliar.getSize()));
                String listado = "";
                for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                    listado += lista_auxiliar.getAsignatura(i).toString() + "\n" + "Curso: "
                            + lista_auxiliar.getAsignatura(i).getStringCurso() + "\n";
                }

                this.pantalla.setText(listado);
            } else {
                this.pantalla.setText(" NO SE HAN ENCONTRADO ASIGNATURAS");
            }
        }
    }

    /**
     * Metodo que muestra automáticamente la lista global de los estudiantes
     *
     */
    private void actualizarListaEstudiantesAuto() {
        //Se resetea el estudianteJBox
        estudiantesJBox.removeAllItems();
        estudiantesJBox.addItem(lEstudiantes);
        
        //Lista auxiliar de alumnos
        ListaEstudiantes lista_auxiliar = new ListaEstudiantes();
        
        //Si el objeto seleccionado del JBox es perteneciente a Optativa o a Obligatoria
        if (listaTipoAsignaturasJBox.getSelectedItem().getClass() == Optativa.class || listaTipoAsignaturasJBox.getSelectedItem().getClass() == Obligatoria.class) {
            //Se crea una asignatura auxiliar, igual a la seleccioanda en el Jbox
            Asignatura auxiliar = (Asignatura) listaTipoAsignaturasJBox.getSelectedItem();

            //buscar asignatura en lista global y mostrar su lista de referencia a estudiantes
            
            //Se busca el indice de esta asignatura en la lista global de asignaturas
            int indice = ventanaInicio.getListaGlobalAsignaturas().getIndice(auxiliar);
             //buscar asignatura en lista global y mostrar su lista de referencia a estudiantes
            Asignatura asignatura_seleccionada= ventanaInicio.getListaGlobalAsignaturas().getAsignatura(indice);
            //Se calcula el numero de estudiantes matriculados de esta asignatura
            Lista_Ref_Estudiantes lre=asignatura_seleccionada.getListaEstudiantes();
            

            //Si hay algun estudiante matriculado
            if (lre.getSize() > 0) {
                for (int i = 0; i < lre.getSize(); i++) {
                    lista_auxiliar.setObject(lre.getObject(i));
                }

                //Se ordena la lista
                lista_auxiliar.ordenarLista();

                String listado = "CURSO: " + ventanaInicio.getListaGlobalAsignaturas().getAsignatura(indice).getStringCurso() + "\n\n" + "ESTUDIANTES" + "\n\n";
                for (int i = 0; i < lista_auxiliar.getSize(); i++) {
                    listado = listado + lista_auxiliar.getEstudiante(i).toString() + "\n\n";
                    estudiantesJBox.addItem(lista_auxiliar.getEstudiante(i));
                }

                this.pantalla.setText(listado);
            } else {
                this.pantalla.setText(" NO SE HAN ENCONTRADO ALUMNOS MATRICULADOS");
            }
        }
    }

    /**
     * Método que pone todos los campos en blanco
     *
     */
    private void init() {
        this.areaNombre.setText("");
        this.areaDNI.setText("");

        this.pantalla.setText("");
        this.listaTipoAsignaturasJBox.removeAllItems();
        this.listaTipoAsignaturasJBox.addItem(lAsignatura);

        // Si no es la primera vez que se entra, se visualizan los estudiantes anteriores
        initEstudiantes();
    }

    /**
     * Método que recorre todos los estudiantes y los añado al JComboBox
     *
     */
    private void initEstudiantes() {
        try {
            this.estudiantesJBox.removeAllItems();

            this.estudiantesJBox.addItem(lEstudiantes);
            Asignatura auxiliar = (Asignatura) listaTipoAsignaturasJBox.getSelectedItem();
            int indice= ventanaInicio.getListaGlobalAsignaturas().getIndice(auxiliar);
            Asignatura asignatura_seleccionada=ventanaInicio.getListaGlobalAsignaturas().getAsignatura(indice);
            System.out.println(auxiliar);
            Lista_Ref_Estudiantes lre = asignatura_seleccionada.getListaEstudiantes();

            for (int i = 0; i < lre.getSize(); i++) {
                if (lre.getSize() != 0) {
                    this.estudiantesJBox.addItem(lre.getObject(i));
                }
            }

        } catch (Exception e) {
        }

    }

    /**
     * Método que verifica si el JComboBox de asignaturas está vacío o no
     *
     * @return
     */
    private boolean jComboBoxAsigIsEmpety() {
        return listaTipoAsignaturasJBox.getSelectedItem().equals(lAsignatura);
    }

    /**
     * Método que verifica si el JComboBox de estudiantes está vacío o no
     *
     * @return
     */
    private boolean jComboBoxEstIsEmpety() {
        return estudiantesJBox.getSelectedItem().equals(lEstudiantes);
    }

    /**
     * Método que nos permite cerrar la ventana
     *
     */
    private void cerrarVentana() {
        this.dispose();
    }

    /**
     * Método que modifica el valor de la ventanaInicio de esta clase
     *
     * @param vI
     */
    public void setInicio(VentanaInicio vI) {
        ventanaInicio = vI;
        ventanaAsignatura = ventanaInicio.getvAsignatura();
        ventanaCurso = ventanaInicio.getVentanaCurso();
    }

    /**
     * Método que devuelve el contenido de la lista de Estudiantes
     *
     * @return
     */
    public ListaEstudiantes getListaEstudiantes() {
        return listaEstudiantes;
    }
}
