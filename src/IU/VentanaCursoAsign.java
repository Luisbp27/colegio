package IU;

import Asignatura.Asignatura;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import Asignatura.Obligatoria;
import Asignatura.Optativa;
import Curso.Bachiller;
import Curso.Curso;
import Curso.FP;
import Estudiante.Estudiante;
import Lista.ListaAsignaturas;
import Lista.ListaEstudiantes;
import Lista.ListaCursos;
import Lista_Ref.Lista_Ref_Estudiantes;
import java.awt.event.ItemEvent;

/**
 * 
 * @author luisb
 */
public class VentanaCursoAsign extends JFrame {

    // Constantes
    // Tamaño ventanas
    private static final int ANCHURA = 600;

    private final int altoDtsAsignatura = 100;
    private final int altoTipAsig = 100;
    private final int altoListaAsignatura = 40;
    private final int altoListaScroll = 180;
    private final int altoBotonesV = 50;

    private final int alto_MAX = 70 + altoDtsAsignatura + altoTipAsig + altoListaAsignatura + altoListaScroll
            + altoBotonesV + (6 * 5);

    // Variables
    private VentanaInicio ventanaInicio;
    private VentanaCurso ventanaCurso;

    // Componentes:
    // Barra de Menu
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem ventanaPrin;
    private JMenuItem ventanaCur;

    // Paneles
    private JPanelTpAsign panelTipoAsignatura;
    private JPanel panelBotonesAsignatura;
    private JPanel panelDatosAsignatura;
    private JPanel panelListaAsignaturas;

    // LABELS//
    private JLabel aNombre;
    private JLabel aCodigo;

    // Botones
    private JButton altaAsignatura;
    private JButton bajaAsignatura;
    private JComboBox listaTipoAsignaturasJBox;

    // Area de texto
    private JTextField atNombre;
    private JTextField atCodigo;
    // Panel derecho
    // Para enseñar contenido
    private JTextArea pantalla;
    private JScrollPane scrollPane;

    // Variables
    private FP sel_fp;
    private Bachiller sel_bachiller;
    private Obligatoria obligatoria;
    private Optativa optativa;
    private final Optativa.Tipo[] tipos = { Optativa.Tipo.TEÓRICA, Optativa.Tipo.PRÁCTICA };
    private int asig_option, i, size_lista_ref;
    private static final String ASIGNATURABOX = "Asignaturas";
    private ListaCursos listaAuxiliarCurso;
    private ListaAsignaturas listaAuxiliarAsignatura;
    private ListaEstudiantes listaAuxEstudiantes;

    /**
     * Método constructor de la clase
     *
     * @param inicio
     * @param seleccionado
     */
    public VentanaCursoAsign(VentanaInicio inicio, Curso seleccionado) {
        // super("Gestión Asignaturas - Curso" + nombreCurso);
        super("Gestión Asignaturas - " + seleccionado.getNombre());
        ventanaInicio = inicio;
        ventanaCurso = ventanaInicio.getVentanaCurso();

        // conseguimos las listas "globales"
        listaAuxiliarCurso = ventanaInicio.getListaGlobalCursos();
        listaAuxiliarAsignatura = ventanaInicio.getListaGlobalAsignaturas();
        listaAuxEstudiantes = ventanaInicio.getListaGlobalEstudiantes();

        // Vemos si el objeto seleccionado es Fp o Bachiller
        if (seleccionado.getClass() == FP.class) {
            this.i = 1;
        } else {
            this.i = 2;
        }

        // Segun si es bachiller o fp llenamos el objeto correspondiente
        if (this.i == 1) {
            this.sel_fp = (FP) seleccionado;
            // tamaño de la lista con referencias a asignatura
            size_lista_ref = sel_fp.getSizeRef();
        } else if (this.i == 2) {
            this.sel_bachiller = (Bachiller) seleccionado;
            // tamaño de la lista con referencias a asignatura
            size_lista_ref = sel_bachiller.getSizeRef();
        }

        initComponents(seleccionado);
    }

    /**
     * Método que permite la gestión de los componentes de la clase
     *
     * @param seleccionado
     */
    private void initComponents(Curso seleccionado) {
        this.setSize(ANCHURA, alto_MAX);
        this.setLocationRelativeTo(null);

        // Quitamos el Layout para ordenar los paneles
        this.setLayout(null);

        // Cierre con la X de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // No ensanchable
        this.setResizable(false);

        // Componentes:
        // Barra
        barraMenu = new JMenuBar();
        menu = new JMenu("Menú");
        ventanaPrin = new JMenuItem("Menú Principal");
        ventanaCur = new JMenuItem("Volver");

        menu.add(ventanaPrin);
        menu.add(ventanaCur);
        barraMenu.add(menu);

        // Paneles
        // 0 = NO Tipo
        panelTipoAsignatura = new JPanelTpAsign(0);

        // Panel "Tipo asignatura"
        panelBotonesAsignatura = new JPanel();
        // new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        panelBotonesAsignatura.setLayout(new GridLayout(1, 2, 5, 1));
        panelBotonesAsignatura.setVisible(true);

        // Paneles parte derecha
        panelDatosAsignatura = new JPanel();
        panelDatosAsignatura.setLayout(new GridLayout(2, 2, 5, 1));
        panelDatosAsignatura.setVisible(true);

        panelListaAsignaturas = new JPanel();
        panelListaAsignaturas.setLayout(new GridLayout(1, 1, 5, 1));
        panelListaAsignaturas.setVisible(true);

        // Areas de texto (JTextArea)
        atNombre = new JTextField();
        atNombre.setFont(atNombre.getFont().deriveFont(14f));
        atNombre.setEditable(true);

        atCodigo = new JTextField();
        atCodigo.setFont(atCodigo.getFont().deriveFont(14f));
        atCodigo.setEditable(true);

        pantalla = new JTextArea("");
        pantalla.setFont(pantalla.getFont().deriveFont(16f));
        pantalla.setEditable(false);
        pantalla.setVisible(true);

        // Scroll Pane
        scrollPane = new JScrollPane(pantalla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVisible(true);

        // Labels
        aNombre = new JLabel("Nombre:");
        aCodigo = new JLabel("Código:");

        // Botones
        bajaAsignatura = new JButton("Baja");
        bajaAsignatura.setForeground(Color.WHITE);
        bajaAsignatura.setBackground(Color.GRAY);

        altaAsignatura = new JButton("Alta");
        altaAsignatura.setForeground(Color.WHITE);
        altaAsignatura.setBackground(Color.GRAY);

        listaTipoAsignaturasJBox = new JComboBox();
        listaTipoAsignaturasJBox.addItem(ASIGNATURABOX);

        // Acciones al presionar el botón "Baja Curso"
        bajaAsignatura.addActionListener((ActionEvent ae) -> {
            accionBajaAsignatura(seleccionado);
        });

        // Acciones al presionar el botón "Listar curso"
        altaAsignatura.addActionListener((ActionEvent ae) -> {
            if (atNombre.getText().equals("") || atCodigo.getText().equals("")) {
                if (atNombre.getText().equals("")) {
                    pantalla.setText("Escriba el nombre de la asignatura");
                } else {
                    if (atCodigo.getText().equals("")) {
                        pantalla.setText("Escriba el código de la asignatura ");
                    }
                }
            } else {
                accionAltaAsignatura(seleccionado);
            }
        });

        // Acciones al presionar el botón de la barra de menú "Menú Principal"
        ventanaPrin.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            ventanaInicio.setVisible(true);
        });

        // Acciones al presionar el botón de la barra de menú "Volver"
        ventanaCur.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            ventanaCurso.setVisible(true);
        });

        // Escuchador panel
        panelBotonesAsignatura.addAncestorListener(
                new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent event) {
                        init(seleccionado);
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
                    accionListarEstudiantes();
                }
            }
        });

        // .setBounds(x,y,ancho,alto)
        panelDatosAsignatura.setBounds(10, 5, ANCHURA - 30, altoDtsAsignatura);
        panelTipoAsignatura.setBounds(10, altoDtsAsignatura + 5, ANCHURA - 30, altoTipAsig);
        panelListaAsignaturas.setBounds(10, altoTipAsig + 5 + altoDtsAsignatura + 5, ANCHURA - 30, altoListaAsignatura);
        scrollPane.setBounds(10, altoTipAsig + 5 + altoDtsAsignatura + 5 + altoListaAsignatura + 5, ANCHURA - 30,
                altoListaScroll);
        panelBotonesAsignatura.setBounds(10,
                altoTipAsig + 5 + altoDtsAsignatura + 5 + altoListaAsignatura + 5 + altoListaScroll + 5, ANCHURA - 30,
                altoBotonesV);

        // Añadimos componentes a los paneles
        panelBotonesAsignatura.add(altaAsignatura);
        panelBotonesAsignatura.add(bajaAsignatura);
        panelDatosAsignatura.add(aNombre);
        panelDatosAsignatura.add(atNombre);
        panelDatosAsignatura.add(aCodigo);
        panelDatosAsignatura.add(atCodigo);
        panelListaAsignaturas.add(listaTipoAsignaturasJBox);

        // Añadir componentes
        this.setJMenuBar(barraMenu);
        this.add(panelTipoAsignatura);
        this.add(panelBotonesAsignatura);
        this.add(panelDatosAsignatura);
        this.add(panelListaAsignaturas);
        this.add(scrollPane);
    }

    /**
     * Método que actualiza el JComboBox con la asignaturas que ya exisitian
     *
     */
    private void actualizar_lista_asignaturas(ListaAsignaturas lista) {
        for (int j = 0; j < lista.getSize(); j++) {
            listaTipoAsignaturasJBox.addItem(lista.getObject(j));
        }
    }

    /**
     * Método que realiza la acción de dar de alta a una Asignatura
     *
     * @param seleccionado
     */
    private void accionAltaAsignatura(Curso seleccionado) {
        // Vemos si la opcion es obligatoria (2) u optativa (1)
        asig_option = panelTipoAsignatura.getSelectEspAsignatura();

        switch (asig_option) {
            // Obligatoria
            case 2:
                if (!panelTipoAsignatura.getSelectComboAsig().equals("Créditos")) {
                    // crear asignatura del curso específico
                    int codigo = Integer.parseInt(atCodigo.getText());
                    int creditos = Integer.parseInt(panelTipoAsignatura.getSelectComboAsig().toString());
                    Obligatoria obl = new Obligatoria(atNombre.getText(), codigo, creditos, seleccionado);
                    // Añadir a listaAuxiliarAsignatura la asignatura nueva
                    listaAuxiliarAsignatura.addObject(obl);
                    listaAuxiliarAsignatura.ordenarLista();
                    ventanaInicio.setListaAsignaturas(listaAuxiliarAsignatura);
                    // añadir a la lista de asignaturas del curso en concreto
                    seleccionado.getListaAsignaturas().addObject(obl);
                    seleccionado.getListaAsignaturas().ordenarLista();
                    // añadimos la asignatura en el JComboBox
                    listaTipoAsignaturasJBox.addItem(obl);
                    this.pantalla.setText(obl.toString());
                } else {
                    this.pantalla.setText("No has seleccionado el número de créditos.\n"
                            + "Por favor, revise su selección");
                }
                break;
            // Optativa
            case 1:
                if (!panelTipoAsignatura.getSelectComboAsig().equals("Perfiles")) {
                    int codigo = Integer.parseInt(atCodigo.getText());
                    Optativa.Tipo tipo = (Optativa.Tipo) panelTipoAsignatura.getSelectComboAsig();
                    Optativa opt = new Optativa(atNombre.getText(), codigo, tipo, seleccionado);
                    // añadir lista global asignaturas
                    listaAuxiliarAsignatura.addObject(opt);
                    listaAuxiliarAsignatura.ordenarLista();
                    ventanaInicio.setListaAsignaturas(listaAuxiliarAsignatura);
                    // añadir a lista concreta de un curso
                    seleccionado.getListaAsignaturas().addObject(opt);
                    seleccionado.getListaAsignaturas().ordenarLista();
                    // añadirlo por orden a JComboBox de opción
                    listaTipoAsignaturasJBox.addItem(opt);
                    this.pantalla.setText(opt.toString());
                } else {
                    this.pantalla.setText("Perfil sin seleccionar.\n"
                            + "Por favor, revise su selección");
                }
                break;
            default:
                this.pantalla.setText("No hay ningún tipo de asignatura seleccionado.\n"
                        + "Por favor, revise su selección");
                break;
        }
        // Actualizamos la slistas
        ventanaInicio.setListaAsignaturas(listaAuxiliarAsignatura);
    }

    /**
     * Método que muestra por la "pantalla" los alumnos de un asignatura
     * selecionada previamente en el JComboBox AUTOMATICAMENTE
     */
    private void accionListarEstudiantes() {
        String estudiantes = "";

        // Comprobamos que tipo de asignatura es
        if (listaTipoAsignaturasJBox.getSelectedItem().getClass() == Obligatoria.class) {
            Obligatoria aux_obli;
            aux_obli = (Obligatoria) listaTipoAsignaturasJBox.getSelectedItem();
            // Añadimos todos sus alumnos al string
            int size = aux_obli.getListaEstudiantes().getSize();
            Lista_Ref_Estudiantes are = aux_obli.getListaEstudiantes();

            for (int p = 0; (p < size); p++) {
                if (are.getObject(p) != null) {
                    estudiantes += aux_obli.getRefEstudiante(p).toString() + "\n";
                }
            }

        } else if (listaTipoAsignaturasJBox.getSelectedItem().getClass() == Optativa.class) {
            Optativa aux_opt = (Optativa) listaTipoAsignaturasJBox.getSelectedItem();
            int size = aux_opt.getListaEstudiantes().getSize();
            Lista_Ref_Estudiantes are = aux_opt.getListaEstudiantes();

            for (int p = 0; p < size; p++) {
                if (are.getObject(p) != null) {
                    // Añadimos todos sus alumnos al string
                    estudiantes += are.getObject(p).toString() + "\n";
                }
            }
        }

        // Visualizamos el contenido en la "pantalla"
        this.pantalla.setText(estudiantes);
    }

    /**
     * Método que elimina los Estudiantes de una Asignatura pasada por parámetro
     *
     * @param asignatura
     */
    private void removeEstudiantes(Asignatura asignatura) {
        int size = asignatura.getListaEstudiantes().getSize();
        Estudiante es;
        Lista_Ref_Estudiantes lre = asignatura.getListaEstudiantes();

        for (int k = 0; k < size; k++) {
            if (lre.getObject(k) != null) {
                es = lre.getObject(k);
                // aquí se elimina el estudiante lista global
                lre.removeNodoEstudiante(es);
                // aquí en teoría elimina la lista de referéncia estudiante asignatura
                // y así quita la relación del estudiante con esa asignatura
                es.removeRefAsingatura(asignatura);
            }
        }
    }

    /**
     * Método que realiza la acción de dar de baja una Asignatura
     *
     * @param seleccionado
     */
    private void accionBajaAsignatura(Curso seleccionado) {
        if (!listaTipoAsignaturasJBox.getSelectedItem().equals(ASIGNATURABOX)) {
            Asignatura aEliminar = (Asignatura) listaTipoAsignaturasJBox.getSelectedItem();

            // Actualizamos la lista de referencias del curso en cuestion
            if (i == 1) {
                // listaAuxiliarCurso.removeObject(sel_fp);
                seleccionado.getListaAsignaturas().removeObject(aEliminar);
                // listaAuxiliarCurso.addObject(sel_fp);

            } else if (i == 2) {
                // listaAuxiliarCurso.removeObject(sel_bachiller);
                seleccionado.getListaAsignaturas().removeObject(aEliminar);
                // listaAuxiliarCurso.addObject(sel_bachiller);
            }

            // Eliminamos objeto del combobox
            removeEstudiantes(aEliminar);
            listaAuxiliarAsignatura.removeObject(aEliminar);
            // seleccionado.setListaAsignaturas(listaAuxiliarAsignatura);
            // eliminamos asignatura de la lista de asignaturas
            listaTipoAsignaturasJBox.removeItem(aEliminar);

            // Set de las listas
            ventanaInicio.setListaAsignaturas(listaAuxiliarAsignatura);
            ventanaInicio.setListaGlobalCursos(listaAuxiliarCurso);
            ventanaInicio.setListaGlobalEstudiantes(listaAuxEstudiantes);

            this.pantalla.setText("");
        } else {
            this.pantalla.setText("Selecciona una asignatura");
        }
    }

    /**
     * Método que comprubea si el JComboBox de Asingaturas está vacío o no
     *
     * @return
     */
    private boolean jComboBoxAsigIsEmpety() {
        return listaTipoAsignaturasJBox.getSelectedItem().equals(ASIGNATURABOX);
    }

    /**
     * Método que modifica el contenido de la VentanaIncicio de esta clase, con
     * la ventana pasada por parámetro
     *
     * @param vI
     */
    public void setInicio(VentanaInicio vI) {
        this.ventanaInicio = vI;
        this.ventanaCurso = ventanaInicio.getVentanaCurso();
    }

    /**
     * Método que incializa los inputs de la ventana
     *
     * @param seleccionado
     */
    private void init(Curso seleccionado) {
        this.atNombre.setText("");
        this.atCodigo.setText("");
        // this.pantalla.setText("");
        this.pantalla.setText("Selecciona una asignatura para ver sus estudiantes");
        listaTipoAsignaturasJBox.removeAllItems();
        listaTipoAsignaturasJBox.addItem("Asignaturas");
        actualizar_lista_asignaturas(seleccionado.getListaAsignaturas());
    }

    /**
     * Método que nos permite cerrar la ventana
     *
     */
    private void cerrarVentana() {
        this.dispose();
    }
}
