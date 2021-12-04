package IU;

import Asignatura.Asignatura;
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
import Asignatura.Obligatoria;
import Asignatura.Optativa;
import Curso.Bachiller;
import Curso.Curso;
import Curso.FP;
import Estudiante.Estudiante;
import IU.JPanelTpAsign;
import IU.VentanaCurso;
import IU.VentanaInicioGestion;
import Lista.ListaAsignaturas;
import Lista.ListaEstudiantes;
import Lista.ListaCursos;
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
    private final Optativa.Tipo perfiles[] = {Optativa.Tipo.TEÓRICA, Optativa.Tipo.PRÁCTICA};
    private int asig_option, i, size_lista_ref;
    private static final String asignaturaBox = "Asignaturas";
    private ListaCursos listaAuxiliarCurso;
    private ListaAsignaturas listaAuxiliarAsignatura;
    private ListaEstudiantes listaAuxEstudiantes;

    // Constructores
    public VentanaCursoAsign(VentanaInicioGestion inicio, Curso seleccionado) {
        // super("Gestión Asignaturas - Curso" + nombreCurso);
        super("Gestión Asignaturas - " + seleccionado.getNombre());
        vInicio = inicio;
        vCurso = vInicio.getvCurso();
        
        //conseguimos las listas "globales"
        listaAuxiliarCurso = vInicio.getListaGlobalCursos();
        listaAuxiliarAsignatura = vInicio.getListaGlobalAsignaturas();
        listaAuxEstudiantes = vInicio.getListaGlobalEstudiantes();
        
        //A LO MEJOR NO IMPORTA
        //vemos si el objeto seleccionado es Fp o Bachiller
        if (seleccionado.getClass() == FP.class) {
            this.i = 1;
        } else {
            this.i = 2;
        }
        /* BORRAR SI VA TODO BIEN porque ya paso el curso
        //segun si es bachiller o fp llenamos el objeto correspondiente
        if (this.i == 1) {
            this.sel_fp = (FP) seleccionado;
            //tamaño de la lista con referencias a asignatura
            size_lista_ref = sel_fp.getSizeRef();
        } else if (this.i == 2) {
            this.sel_bch = (Bachiller) seleccionado;
            //tamaño de la lista con referencias a asignatura
            size_lista_ref = sel_bch.getSizeRef();
        }*/
        initComponents(seleccionado);
    }

    private void initComponents(Curso seleccionado) {

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
                    accionAltaAsignatura(seleccionado);
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
                inIt(seleccionado);
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
    private void actualizar_lista_asignaturas(ListaAsignaturas lista) {
            for (int i = 0; i <lista.getSize(); i++) {
                listaTipoAsignaturasJBox.addItem(lista.getObject(i));
            }
    }

    private void accionAltaAsignatura(Curso seleccionado) {
        //Vemos si la opcion es obligatoria (2) u optativa (1)
        asig_option = panelTipoAsignatura.getSelectEspAsignatura();

        switch (asig_option) {
            // Obligatoria
            case 2:
                if (!panelTipoAsignatura.getSelectComboAsig().equals("Créditos")) {
                    //crear asignatura del curso específico
                    int codigo=Integer.parseInt(atCodigo.getText());
                    double creditos=Double.parseDouble(panelTipoAsignatura.getSelectComboAsig().toString());
                    Obligatoria obl=new Obligatoria(atNombre.getText(),codigo,seleccionado,creditos);
                     // Añadir a listaAuxiliarAsignatura la asignatura nueva
                    listaAuxiliarAsignatura.setObject(obl);
                    listaAuxiliarAsignatura.ordenarLista();
                    vInicio.setListaAsignaturas(listaAuxiliarAsignatura);
                    //añadir a la lista de asignaturas del curso en concreto
                    seleccionado.getListaAsignaturas().setObject(obl);
                    seleccionado.getListaAsignaturas().ordenarLista();
                    //añadimos la asignatura en el JComboBox
                    listaTipoAsignaturasJBox.addItem(obl);
                    this.pantalla.setText(obl.toString());
                } else {
                    this.pantalla.setText("No has seleccionado el número de créditos.\n"
                            + "Por favor, revise su selección");
                }
                break;
            //Optativa
            case 1:
                if (!panelTipoAsignatura.getSelectComboAsig().equals("Perfiles")) {
                    int codigo=Integer.parseInt(atCodigo.getText());
                    Optativa.Tipo tipo=(Optativa.Tipo)panelTipoAsignatura.getSelectComboAsig();
                    Optativa opt=new Optativa(atNombre.getText(),codigo,seleccionado,tipo);
                        //añadir lista global asignaturas
                        listaAuxiliarAsignatura.setObject(opt);
                        //añadir a lista concreta de un curso
                        seleccionado.getListaAsignaturas().setObject(opt);
                        seleccionado.getListaAsignaturas().ordenarLista();
                        //añadirlo a JComboBox de opción
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
        //Actualizamos la slistas
        vInicio.setListaAsignaturas(listaAuxiliarAsignatura);
        //vInicio.setListaGlobalCursos(listaAuxiliarCurso);
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
                if(aux_obli.getRefEstudiante(p) != null){
                estudiantes += aux_obli.getRefEstudiante(p).toString() + "\n";}
            }

        } else if (listaTipoAsignaturasJBox.getSelectedItem().getClass() == Optativa.class) {

            Optativa aux_opt = null;
            aux_opt = (Optativa) listaTipoAsignaturasJBox.getSelectedItem();
            int size = aux_opt.getSizeRef();
            for (int p = 0; p < size; p++) {
              if(aux_opt.getRefEstudiante(p) != null){
                  //vamos añadiendo todos sus alumnos al string
                estudiantes += aux_opt.getRefEstudiante(p).toString() + "\n";}
            }
        }
        //Visualizamos el contenido en la "pantalla"
        this.pantalla.setText(estudiantes);
    }
    private void removeEstudiantes(Asignatura ass){
        int size = ass.getSizeRef();
        Estudiante es;
        
        for(int k = 0; k<size; k++){
            if(ass.getRefEstudiante(k) != null){
            es = ass.getRefEstudiante(k);
            listaAuxEstudiantes.removeObject(es);
            es.remove(ass);
            listaAuxEstudiantes.setObject(es);
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
                listaAuxiliarCurso.setObject(sel_fp);

            } else if (i == 2) {

                listaAuxiliarCurso.removeObject(sel_bch);
                sel_bch.removeObject(aEliminar);
                listaAuxiliarCurso.setObject(sel_bch);
            }
            //eliminamos objeto del combobox
            removeEstudiantes((Asignatura)aEliminar);
            listaAuxiliarAsignatura.removeObject(aEliminar);
            //eliminamos asignatura de la lista de asignaturas
            listaTipoAsignaturasJBox.removeItem(aEliminar);
            //set de las listas
            vInicio.setListaAsignaturas(listaAuxiliarAsignatura);
            vInicio.setListaGlobalCursos(listaAuxiliarCurso);
            vInicio.setetListaGlobalAlumnos(listaAuxEstudiantes);
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

    private void inIt(Curso seleccionado) {
        this.atNombre.setText("");
        this.atCodigo.setText("");
        //this.pantalla.setText("");
        this.pantalla.setText("Selecciona una asignatura para ver sus estudiantes");
        listaTipoAsignaturasJBox.removeAllItems();
        listaTipoAsignaturasJBox.addItem("Asignaturas");
        actualizar_lista_asignaturas(seleccionado.getListaAsignaturas());
    }

    private void cerrarVentana() {
        this.dispose();
    }
}
