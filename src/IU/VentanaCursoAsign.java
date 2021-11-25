package IU;

import Alumno.Alumno;
import Asignatura.Asignatura;
import Clases.Bachiller;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import Clases.FP;
import Asignatura.Obligatoria;
import Asignatura.Optativa;
import Lista.Lista_Asignaturas;
import Asignatura.Perfil;
import Lista.Lista_Alumnos;
import Lista.Lista_Cursos;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class VentanaCursoAsign extends JFrame {

    // Constantes
    // Tamaño ventanas
    private final int ancho_MAX = 600;

    private final int altoDtsAsignatura = 100;
    private final int altoTipAsig = 100;
    private final int altoListaAsignatura = 40;
    private final int altoListaScroll = 180;
    private final int altoBotonesV = 50;

    private final int alto_MAX = 70 + altoDtsAsignatura + altoTipAsig + altoListaAsignatura + altoListaScroll
            + altoBotonesV + (6 * 5);

    // Variables
    private VentanaInicioGestion vInicio;
    private VentanaCurso vCurso;

    // Componentes:
    // Barra de Menu
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem ventanaPrin;
    private JMenuItem ventanaCurso;

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
    private Bachiller sel_bch;
    private Obligatoria obli;
    private Optativa opt;
    private final Perfil perfiles[] = {Perfil.TEORICO, Perfil.PRACTICO};
    private int asig_option, i, size_lista_ref;
    private static final String asignaturaBox = "Asignaturas";
    private Lista_Cursos listaAuxiliarCurso;
    private Lista_Asignaturas listaAuxiliarAsignatura;
    private Lista_Alumnos listaAuxAlumnos;

    // Constructores
    public VentanaCursoAsign(VentanaInicioGestion inicio, Object seleccionado) {
        // super("Gestión Asignaturas - Curso" + nombreCurso);
        super("Gestión Asignaturas - " + seleccionado);
        vInicio = inicio;
        vCurso = vInicio.getvCurso();

        //conseguimos las listas "globales"
        listaAuxiliarCurso = vInicio.getListaGlobalCursos();
        listaAuxiliarAsignatura = vInicio.getListaGlobalAsignaturas();
        listaAuxAlumnos = vInicio.getListaGlobalAlumnos();

        //vemos si el objeto seleccionado es Fp o Bachiller
        if (seleccionado.getClass() == FP.class) {
            this.i = 1;
        } else {
            this.i = 2;
        }
        //segun si es bachiller o fp llenamos el objeto correspondiente
        if (this.i == 1) {
            this.sel_fp = (FP) seleccionado;
            //tamaño de la lista con referencias a asignatura
            size_lista_ref = sel_fp.getSizeRef();
        } else if (this.i == 2) {
            this.sel_bch = (Bachiller) seleccionado;
            //tamaño de la lista con referencias a asignatura
            size_lista_ref = sel_bch.getSizeRef();
        }
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
        ventanaCurso = new JMenuItem("Volver");

        menu.add(ventanaPrin);
        menu.add(ventanaCurso);
        barraMenu.add(menu);

        // Paneles
        //0 = NO Tipo
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
        bajaAsignatura.setBackground(Color.BLACK);

        altaAsignatura = new JButton("Alta");
        altaAsignatura.setBackground(Color.BLACK);

        listaTipoAsignaturasJBox = new JComboBox();
        listaTipoAsignaturasJBox.addItem(asignaturaBox);

        // Acciones al presionar el botón "Indicar Curso"
        bajaAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accionBajaAsignatura();
            }
        });

        // Acciones al presionar el botón "Listar curso"
        altaAsignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (atNombre.getText().equals("") || atCodigo.getText().equals("")) {
                    if (atNombre.getText().equals("")) {
                        pantalla.setText("Escriba el nombre de la asignatura");
                    } else {
                        if (atCodigo.getText().equals("")) {
                            pantalla.setText("Escriba el código de la asignatura ");
                        }
                    }
                } else {
                    accionAltaAsignatura();
                }
            }

        }
        );

        // Acciones al presionar el botón de la barra de menú "Menú Principal"
        ventanaPrin.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                cerrarVentana();
                vInicio.setVisible(true);
            }
        }
        );

        // Acciones al presionar el botón de la barra de menú "Volver"
        ventanaCurso.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                cerrarVentana();
                vCurso.setVisible(true);
            }
        }
        );

        // Escuchador panel
        panelBotonesAsignatura.addAncestorListener(
                new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event
            ) {
                inIt();
            }

            @Override
            public void ancestorRemoved(AncestorEvent ae
            ) {
            }

            @Override
            public void ancestorMoved(AncestorEvent ae
            ) {
            }
        });

        listaTipoAsignaturasJBox.addItemListener(
                new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie
            ) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    if (!jComboBoxAsigIsEmpety()) {
                        accionListarEstudiantes();
                    }
                }
            }
        }
        );

        // .setBounds(x,y,ancho,alto)
        panelDatosAsignatura.setBounds(
                10, 5, ancho_MAX - 30, altoDtsAsignatura);
        panelTipoAsignatura.setBounds(
                10, altoDtsAsignatura + 5, ancho_MAX - 30, altoTipAsig);
        panelListaAsignaturas.setBounds(
                10, altoTipAsig + 5 + altoDtsAsignatura + 5, ancho_MAX - 30,
                altoListaAsignatura);
        scrollPane.setBounds(
                10, altoTipAsig + 5 + altoDtsAsignatura + 5 + altoListaAsignatura + 5, ancho_MAX - 30,
                altoListaScroll);
        panelBotonesAsignatura.setBounds(
                10,
                altoTipAsig + 5 + altoDtsAsignatura + 5 + altoListaAsignatura + 5 + altoListaScroll + 5, ancho_MAX - 30,
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

        this.getContentPane()
                .add(panelTipoAsignatura);

        this.getContentPane()
                .add(panelBotonesAsignatura);

        this.getContentPane()
                .add(panelDatosAsignatura);

        this.getContentPane()
                .add(panelListaAsignaturas);

        this.getContentPane()
                .add(scrollPane);
    }

    /**
     * Actualiza el Jcombobox con la asignaturas que ya exisitian
     */
    private void actualizar_lista_asignaturas() {
        if (i == 1) {
            for (int m = 0; m <= size_lista_ref - 1; m++) {
                listaTipoAsignaturasJBox.addItem(sel_fp.getAsignaturaRef(m));
            }
        } else if (i == 2) {
            for (int m = 0; m <= size_lista_ref - 1; m++) {
                listaTipoAsignaturasJBox.addItem(sel_bch.getAsignaturaRef(m));
            }
        }
    }

    private void accionAltaAsignatura() {
        //Vemos si la opcion es obligatoria (2) u optativa (1)
        asig_option = panelTipoAsignatura.getSelectEspAsignatura();

        switch (asig_option) {
            // if obligatoria
            case 0:
                this.pantalla.setText("No hay ningún tipo de asignatura seleccionado.\n"
                        + "Por favor, revise su selección");
                break;
            // if optativa
            case 2:
                if (!panelTipoAsignatura.getSelectComboCurso().equals("Especialidad")) {
                    // add a  listaAuxiliarAsignatura la asig nueva
                    listaAuxiliarAsignatura.addObject(obli = new Obligatoria(Integer.parseInt(atCodigo.getText()), atNombre.getText(),
                            Double.parseDouble(panelTipoAsignatura.getSelectComboAsig().toString())));
                    //vemos segun si el objeto era bachiller o fp
                    if (this.i == 1) {
                        listaAuxiliarCurso.removeObject(sel_fp);
                        //le pasamos el curso.toString() a la asignatura creada
                        obli.setCursoPerteneciente(sel_fp.toString());
                        //añadimos la asignatura a la lista de referencias del curso
                        sel_fp.add(obli);
                        //Actualizamos el curso seleccionado
                        listaAuxiliarCurso.addObject(sel_fp);

                        //añadimos la asignatura en el JComboBox
                        listaTipoAsignaturasJBox.addItem(obli);
                    } else if (this.i == 2) {
                        listaAuxiliarCurso.removeObject(sel_bch);
                        //le pasamos el curso.toString() a la asignatura creada
                        obli.setCursoPerteneciente(sel_bch.toString());
                        //añadimos la asignatura a la lista de referencias del curso
                        sel_bch.add(obli);
                        //Actualizamos el curso seleccionado
                        listaAuxiliarCurso.addObject(sel_bch);
                        //añadimos la asignatura en el JComboBox
                        listaTipoAsignaturasJBox.addItem(obli);
                    }
                    this.pantalla.setText(obli.toString());
                } else {
                    this.pantalla.setText("No hay ningún tipo de asignatura seleccionado.\n"
                            + "Por favor, revise su selección");
                }
                break;
            //If obligatoria
            case 1:
                if (!panelTipoAsignatura.getSelectComboAsig().equals("Perfiles")) {
                    if (perfiles[1].ordinal() == ((Perfil) panelTipoAsignatura.getSelectComboAsig()).ordinal()) {
                        // add a  listaAuxiliarAsignatura la asig nueva
                        listaAuxiliarAsignatura.addObject(
                                opt = new Optativa(Integer.parseInt(atCodigo.getText()), atNombre.getText(), perfiles[1]));
                        //vemos segun si el objeto era bachiller o fp

                        if (this.i == 1) {
                            listaAuxiliarCurso.removeObject(sel_fp);
                            //le pasamos el curso.toString() a la asignatura creada
                            opt.setCursoPerteneciente(sel_fp.toString());
                            //añadimos la asignatura a la lista de referencias del curso
                            sel_fp.add(opt);
                            //Actualizamos el curso seleccionado
                            listaAuxiliarCurso.addObject(sel_fp);
                            //añadimos la asignatura en el JComboBox
                            listaTipoAsignaturasJBox.addItem(opt);

                        } else if (this.i == 2) {
                            listaAuxiliarCurso.removeObject(sel_bch);
                            //le pasamos el curso.toString() a la asignatura creada
                            opt.setCursoPerteneciente(sel_bch.toString());
                            //añadimos la asignatura a la lista de referencias del curso
                            sel_bch.add(opt);
                            //Actualizamos el curso seleccionado
                            listaAuxiliarCurso.addObject(sel_bch);
                            //añadimos la asignatura en el JComboBox
                            listaTipoAsignaturasJBox.addItem(opt);

                        }
                        this.pantalla.setText(opt.toString());

                    } else {
                        // add a  listaAuxiliarAsignatura la asig nueva
                        listaAuxiliarAsignatura.addObject(
                                opt = new Optativa(Integer.parseInt(atCodigo.getText()), atNombre.getText(), perfiles[0]));
                        //vemos segun si el objeto era bachiller o fp
                        if (this.i == 1) {
                            listaAuxiliarCurso.removeObject(sel_fp);
                            //le pasamos el curso.toString() a la asignatura creada
                            opt.setCursoPerteneciente(sel_fp.toString());
                            //añadimos la asignatura a la lista de referencias del curso
                            sel_fp.add(opt);
                            //Actualizamos el curso seleccionado

                            listaAuxiliarCurso.addObject(sel_fp);
                            //añadimos la asignatura en el JComboBox
                            listaTipoAsignaturasJBox.addItem(opt);

                        } else if (this.i == 2) {
                            listaAuxiliarCurso.removeObject(sel_bch);
                            //le pasamos el curso.toString() a la asignatura creada
                            opt.setCursoPerteneciente(sel_bch.toString());
                            //añadimos la asignatura a la lista de referencias del curso
                            sel_bch.add(opt);
                            //Actualizamos el curso seleccionado
                            listaAuxiliarCurso.addObject(sel_bch);
                            //añadimos la asignatura en el JComboBox
                            listaTipoAsignaturasJBox.addItem(opt);

                        }
                        this.pantalla.setText(opt.toString());
                    }
                } else {
                    this.pantalla.setText("No hay ningún tipo de asignatura seleccionado.\n"
                            + "Por favor, revise su selección");
                }
                break;
            default:
                this.pantalla.setText("No hay ningún tipo de asignatura seleccionado.\n"
                        + "Por favor, revise su selección");
                break;
        }
        //Actualizamos la slistas
        vInicio.setListaAsignaturas(listaAuxiliarAsignatura);
        vInicio.setListaGlobalCursos(listaAuxiliarCurso);
    }

    /**
     * Método que muestra por la "pantalla" los alumnos de un asignatura
     * selecionada previamente en el JComboBox AUTOMATICAMENTE
     */
    private void accionListarEstudiantes() {
        String estudiantes = "";
       //vemos que tipo de asignatura es
        if (listaTipoAsignaturasJBox.getSelectedItem().getClass() == Obligatoria.class) {

            Obligatoria aux_obli;
            aux_obli = (Obligatoria) listaTipoAsignaturasJBox.getSelectedItem();
            //vamos añadiendo todos sus alumnos al string
            int size = aux_obli.getSizeRef();
            for (int p = 0; p < size; p++) {
                if(aux_obli.getAlumnoRef(p) != null){
                estudiantes += aux_obli.getAlumnoRef(p).toString() + "\n";}
            }

        } else if (listaTipoAsignaturasJBox.getSelectedItem().getClass() == Optativa.class) {

            Optativa aux_opt = null;
            aux_opt = (Optativa) listaTipoAsignaturasJBox.getSelectedItem();
            int size = aux_opt.getSizeRef();
            for (int p = 0; p < size; p++) {
              if(aux_opt.getAlumnoRef(p) != null){
                  //vamos añadiendo todos sus alumnos al string
                estudiantes += aux_opt.getAlumnoRef(p).toString() + "\n";}
            }
        }
        //Visualizamos el contenido en la "pantalla"
        this.pantalla.setText(estudiantes);
    }
    private void removeEstudiantes(Asignatura ass){
        int size = ass.getSizeRef();
       Alumno al ;
        
        for(int k = 0; k<size; k++){
            if(ass.getAlumnoRef(k) != null){
            al = ass.getAlumnoRef(k);
            listaAuxAlumnos.removeObject(al);
            al.remove(ass);
            listaAuxAlumnos.addObject(al);
            }
            
        }
    }

    private void accionBajaAsignatura() {
        if (!listaTipoAsignaturasJBox.getSelectedItem().equals(asignaturaBox)) {
            Object aEliminar = listaTipoAsignaturasJBox.getSelectedItem();

            //actualizamos la lista de referencias del curso en cuestion
            if (i == 1) {
                listaAuxiliarCurso.removeObject(sel_fp);
                sel_fp.remove(aEliminar);
                listaAuxiliarCurso.addObject(sel_fp);

            } else if (i == 2) {

                listaAuxiliarCurso.removeObject(sel_bch);
                sel_bch.remove(aEliminar);
                listaAuxiliarCurso.addObject(sel_bch);
            }
            //eliminamos objeto del combobox
            removeEstudiantes((Asignatura)aEliminar);
            listaAuxiliarAsignatura.removeObject(aEliminar);
            //eliminamos asignatura de la lista de asignaturas
            listaTipoAsignaturasJBox.removeItem(aEliminar);
            //set de las listas
            vInicio.setListaAsignaturas(listaAuxiliarAsignatura);
            vInicio.setListaGlobalCursos(listaAuxiliarCurso);
            vInicio.setetListaGlobalAlumnos(listaAuxAlumnos);
            this.pantalla.setText("");
        } else {
            this.pantalla.setText("Selecciona una asignatura");
        }
    }

    private boolean jComboBoxAsigIsEmpety() {
        return listaTipoAsignaturasJBox.getSelectedItem().equals(asignaturaBox);
    }

    public void setInicio(VentanaInicioGestion vig) {
        this.vInicio = vig;
        this.vCurso = vInicio.getvCurso();
    }

    private void inIt() {
        this.atNombre.setText("");
        this.atCodigo.setText("");
        //this.pantalla.setText("");
        this.pantalla.setText("Selecciona una asignatura para ver sus estudiantes");
        listaTipoAsignaturasJBox.removeAllItems();
        listaTipoAsignaturasJBox.addItem("Asignaturas");
        actualizar_lista_asignaturas();
    }

    private void cerrarVentana() {
        this.dispose();
    }
}
