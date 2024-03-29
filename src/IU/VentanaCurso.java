package IU;

import Asignatura.Asignatura;
import Curso.Bachiller;
import Curso.Bachiller.Año;
import Curso.Curso;
import Curso.FP;
import Curso.FP.Especialidad;
import Estudiante.Estudiante;
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
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import Lista.ListaEstudiantes;
import Lista.ListaAsignaturas;
import Lista.ListaCursos;
import Lista_Ref.Lista_Ref_Estudiantes;

/**
 *
 * @author luisb
 */
public class VentanaCurso extends JFrame {

    // Tamaño Pantalla
    private final int alto_MAX = 400;
    private final int ancho_MAX = 600;

    private VentanaInicio vInicio;
    private VentanaAsignatura vAsignatura;
    private VentanaEstudiante vEstudiante;

    // Especialidades de un curso FP:
    private final FP.Especialidad especialidades[] = {Especialidad.INFORMÁTICA, Especialidad.MECÁNICA, Especialidad.ELECTRÓNICA};
    // Tipos de cursos de Bachiller: tBach
    private final Bachiller.Año tBach[] = {Año.PRIMERO, Año.SEGUNDO};

    private VentanaCursoAsign vCrsAsg;

    // Componentes:
    // Barra de Menu
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem ventanaPrin;
    private JMenuItem ventanaEstudiante;
    private JMenuItem ventanaAsign;

    // Paneles
    private JPanel panelCurso;
    private JPanel panelBotonBox;
    private JPanel panelBotones;
    private JPanelTpAsign panelTipo;

    // Panel Pantalla//
    // Para enseñar contenido
    private JTextArea pantalla;
    private JScrollPane scrollPane;

    // Labels
    private JLabel curso;
    private JLabel codigo;

    // Areas de texto
    private JTextField areaNombre;
    private JTextField areaCodigo;

    // Botones
    private JComboBox listaCursosJBox;
    private JComboBox seleccionado;
    private JButton botonAlta;
    private JButton botonBaja;
    private JButton botonEntrar;

    // VARIABLES
    private final String listaCursos = "Lista Cursos";
    private FP fp;
    private Bachiller bch, cb;
    private Object c, aEliminar;
    private int i;

    // listas auxiliaries
    private ListaCursos listaCursoAux = new ListaCursos();
    private ListaAsignaturas listaAuxiliarAsignatura;
    private ListaEstudiantes listaAuxAlumnos;

    /**
     * Método constructor de la clase
     *
     */
    public VentanaCurso() {
        super("Gestión Curso");

        initComponents();
    }

    /**
     * Método que permite la gestión de los componentes de la clase
     *
     */
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
        ventanaAsign = new JMenuItem("Gestión Asignaturas");
        ventanaEstudiante = new JMenuItem("Gestión Estudiantes");

        menu.add(ventanaPrin);
        menu.add(ventanaEstudiante);
        menu.add(ventanaAsign);
        barraMenu.add(menu);

        // BOTONES//
        botonAlta = new JButton("ALTA");
        botonAlta.setForeground(Color.WHITE);
        botonAlta.setBackground(Color.GRAY);

        botonBaja = new JButton("BAJA");
        botonBaja.setForeground(Color.WHITE);
        botonBaja.setBackground(Color.GRAY);

        botonEntrar = new JButton("ENTRAR");
        botonEntrar.setForeground(Color.WHITE);
        botonEntrar.setBackground(Color.GRAY);

        listaCursosJBox = new JComboBox();
        listaCursosJBox.addItem("Lista Cursos");

        // LABELS//
        curso = new JLabel("Curso");
        curso.setVerticalAlignment(SwingConstants.CENTER);

        codigo = new JLabel("Código");
        codigo.setVerticalAlignment(SwingConstants.CENTER);

        // AREA DE TEXTO//
        // Areas de texto//
        areaNombre = new JTextField();
        areaNombre.setEditable(true);

        areaCodigo = new JTextField();
        areaCodigo.setEditable(true);

        // PANELES//
        panelCurso = new JPanel();
        // new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        panelCurso.setLayout(new GridLayout(2, 2, 5, 1));
        panelCurso.setVisible(true);

        // 1 = NO Asignatura
        panelTipo = new JPanelTpAsign(1);

        panelBotonBox = new JPanel();
        panelBotonBox.setLayout(new GridLayout(1, 1, 0, 0));
        panelBotonBox.setVisible(true);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3, 5, 1));
        panelBotones.setVisible(true);

        // Pantalla
        pantalla = new JTextArea("");
        // sólo va a cambiar el tamaño a 16 puntos
        pantalla.setFont(pantalla.getFont().deriveFont(16f));
        pantalla.setEditable(false);
        pantalla.setVisible(true);
        scrollPane = new JScrollPane(pantalla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVisible(true);

        // Acciones al presionar el botón "ALTA"
        botonAlta.addActionListener((ActionEvent ae) -> {
            if (areaNombre.getText().equals("")) {
                pantalla.setText("Escribe un nombre para el curso");
            } else if (areaCodigo.getText().equals("")) {
                pantalla.setText("Escribe un código para el curso");
            } else {
                accionAlta();
            }
        });
        // Acciones al presionar el botón "BAJA"
        botonBaja.addActionListener((ActionEvent ae) -> {
            if (!listaCursosJBox.getSelectedItem().equals(listaCursos)) {

                aEliminar = listaCursosJBox.getSelectedItem();
                accionBaja();

            } else {
                pantalla.setText("Selecciona un curso");
            }
        });
        // Acciones al presionar el botón "ENTRAR"
        botonEntrar.addActionListener((ActionEvent ae) -> {
            if (!listaCursosJBox.getSelectedItem().equals(listaCursos)) {
                // c sera nuestro objeto seleccionado
                c = listaCursosJBox.getSelectedItem();
                vCrsAsg = new VentanaCursoAsign(vInicio, (Curso) c);
                cerrarVentana();
                vCrsAsg.setVisible(true);

            } else {
                pantalla.setText("Selecciona un curso");
            }
        });

        // Acciones al presionar el botón de la barra de menú "Menú Principal"
        ventanaPrin.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            vInicio.setVisible(true);
        });

        // Acciones al presionar el botón de la barra de menú "Gestión AAsignaturas"
        ventanaAsign.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            vAsignatura.setVisible(true);
        });

        // Acciones al presionar el botón de la barra de menú "Gestión Estudiantes"
        ventanaEstudiante.addActionListener((ActionEvent ae) -> {
            cerrarVentana();
            vEstudiante.setVisible(true);
        });

        // Acciones al cambiar un panel
        panelCurso.addAncestorListener(new AncestorListener() {
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
        panelCurso.setBounds(10, 5, 220, 60);
        panelTipo.setBounds(10, 80, 300, 80);
        panelBotonBox.setBounds(ancho_MAX - 350, 25, 300, 40);
        panelBotones.setBounds(5, (alto_MAX / 2) + 80, this.ancho_MAX - 20, 40);
        scrollPane.setBounds(10, (alto_MAX / 2) - 20, this.ancho_MAX - 25, 60);

        // Añadimos componentes a los paneles
        panelCurso.add(curso);
        panelCurso.add(codigo);
        panelCurso.add(areaNombre);
        panelCurso.add(areaCodigo);

        panelBotonBox.add(listaCursosJBox);

        panelBotones.add(botonAlta);
        panelBotones.add(botonEntrar);
        panelBotones.add(botonBaja);

        // Añadimos componentes
        this.setJMenuBar(barraMenu);

        this.getContentPane().add(panelCurso);
        this.getContentPane().add(panelTipo);
        this.getContentPane().add(panelBotonBox);
        this.getContentPane().add(panelBotones);

        this.getContentPane().add(scrollPane);

    }

    /// ACCIONES DE LOS BOTONES///
    /**
     * Método que realiza la acción de dar de alta un Curso
     */
    private void accionAlta() {
        i = panelTipo.getSelectTCurso();

        // 1 = fp 2 = bach
        switch (i) {
            case 1:
                // JComboBox con las especialidades
                seleccionado = (JComboBox) panelTipo.getTipo();
                // vemos que especialidad es y la añadimos acordemente
                for (int j = 0; j < especialidades.length; j++) {
                    if (seleccionado.getSelectedItem().equals(especialidades[j])) {
                        listaCursoAux.addObject(fp = new FP(areaNombre.getText(), Integer.parseInt(areaCodigo.getText()), especialidades[j]));
                        listaCursosJBox.addItem(fp);
                        this.pantalla.setText(fp.toString());
                    }
                }

                break;
            case 2:
                // JComboBox con los años
                seleccionado = (JComboBox) panelTipo.getTipo();
                // vemos que año es y la añadimos acordemente
                for (int j = 0; j < tBach.length; j++) {
                    if (seleccionado.getSelectedItem().equals(tBach[j])) {
                        listaCursoAux.addObject(bch = new Bachiller(areaNombre.getText(), Integer.parseInt(areaCodigo.getText()), tBach[j]));
                        listaCursosJBox.addItem(bch);
                        this.pantalla.setText(bch.toString());
                    }

                }

                break;
            default:
                this.pantalla.setText("Elije una opción");
                break;
        }
        vInicio.setListaGlobalCursos(listaCursoAux);
    }

    /**
     * Método que realiza la acción de dar de baja un Curso
     */
    private void removeEstudiantes(Asignatura ass) {
        int size = ass.getListaEstudiantes().getSize();
        Lista_Ref_Estudiantes lre = ass.getListaEstudiantes();
        Estudiante es;

        for (int k = 0; k < size; k++) {
            if (lre.getObject(k) != null) {
                es = lre.getObject(k);
                //listaAuxAlumnos.removeObject(es);
                lre.removeNodoEstudiante(es);
                es.removeRefAsingatura(ass);
               // listaAuxAlumnos.setObject(es);
            }
        }
    }

    private void accionBaja() {
        if (aEliminar.getClass() == FP.class) {
            FP aux_fp = (FP) aEliminar;
            int size_lista_ref = aux_fp.getSizeRef();
            ListaAsignaturas lac= aux_fp.getListaAsignaturas();

            for (; size_lista_ref>0;size_lista_ref = aux_fp.getSizeRef()) {
                if (aux_fp.getAsignaturaRef(0) != null) {
                    removeEstudiantes(aux_fp.getAsignaturaRef(0));
                    lac.removeObject(0);
                }
            }
        } else if (aEliminar.getClass() == Bachiller.class) {
            Bachiller aux_bch = (Bachiller) aEliminar;
            int size_lista_ref = aux_bch.getSizeRef();
            ListaAsignaturas lac= aux_bch.getListaAsignaturas();

            for (; size_lista_ref>0;size_lista_ref = aux_bch.getSizeRef()) {
                if (aux_bch.getAsignaturaRef(0) != null) {
                    removeEstudiantes(aux_bch.getAsignaturaRef(0));
                    lac.removeObject(0);
                }
        }
         }
        // Eliminamos el objeto seleccionado
        listaCursoAux.removeObject(aEliminar);
        // Lo quitamos del JCombobox
        listaCursosJBox.removeItem(aEliminar);
        // la volvemos a poner en la "global"
        vInicio.setListaGlobalEstudiantes(listaAuxAlumnos);
        vInicio.setListaGlobalCursos(listaCursoAux);
        vInicio.setListaAsignaturas(listaAuxiliarAsignatura);

    }

    /**
     * Método que pone todos los campos input en blanco
     */
    private void inIt() {
        this.areaNombre.setText("");
        this.areaCodigo.setText("");
        this.pantalla.setText("");
        listaCursosJBox.removeAllItems();
        listaCursosJBox.addItem(listaCursos);

        for (int n = 0; n < listaCursoAux.getSize(); n++) {
            listaCursosJBox.addItem(listaCursoAux.getArray()[n]);
        }

        // addItem -> todos los cursos
    }

    /**
     * Método que nos permite cerrar la ventana
     *
     */
    private void cerrarVentana() {
        this.dispose();
    }

    /**
     * Método que modifica el valor de VentanaIncio por la ventana apsada por
     * parámetro
     *
     * @param vI
     */
    public void setInicio(VentanaInicio vI) {
        vInicio = vI;
        vAsignatura = vInicio.getvAsignatura();
        vEstudiante = vInicio.getvEstudiante();

        listaCursoAux = vInicio.getListaGlobalCursos();
        listaAuxiliarAsignatura = vInicio.getListaGlobalAsignaturas();
        listaAuxAlumnos = vInicio.getListaGlobalEstudiantes();
    }

    /**
     * Método que devuelve el valor de la ventana
     *
     * @return
     */
    public VentanaCurso getVentanaCurso() {
        return this;
    }
}
