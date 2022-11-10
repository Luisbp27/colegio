package IU;

import Asignatura.Optativa;
import Asignatura.Optativa.Tipo;
import Curso.Bachiller;
import Curso.Bachiller.Año;
import Curso.FP;
import Curso.FP.Especialidad;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *
 * @author luisb
 */
public class JPanelTpAsign extends JPanel {

    private final String sBoxIn = "Seleciona";
    private final Optativa.Tipo perfiles[] = { Tipo.TEÓRICA, Tipo.PRÁCTICA };
    // Especialidades de un curso FP
    private final FP.Especialidad especialidades[] = { Especialidad.INFORMÁTICA, Especialidad.MECÁNICA,
            Especialidad.ELECTRÓNICA };
    // Tipos de cursos de Bachiller
    private final Bachiller.Año tBach[] = { Año.PRIMERO, Año.SEGUNDO };
    // Tipos de creditos Asignaturas Obligatorias
    private final String creditos[] = { "Créditos", "6", "8", "9" };

    private JLabel tTipo;
    private JLabel tAsignatura;

    private ButtonGroup gTipo;
    private JRadioButton optativa;
    private JRadioButton obligatoria;

    private ButtonGroup gEspecialidad;
    private JRadioButton fp;
    private JRadioButton batch;

    private JComboBox tipoCurso;
    private JComboBox tipoAsig;

    private JPanel panelAux; // Area de texto
    private JPanel panelAux2; // Area de texto

    private boolean tipoB;
    private boolean especialidadB;
    private boolean jComboBoxB;

    /**
     * Método constructor de la clase
     *
     */
    public JPanelTpAsign() {
        this.tipoB = true;
        this.especialidadB = true;
        this.jComboBoxB = true;

        initComponents();

        this.setVisible(true);
    }

    /**
     * Método que según el numero elegido no se va a visualizar lo siguiente: O
     * Tipo 1 Especialidad 2 JComboBox
     *
     * @param ver
     */
    public JPanelTpAsign(int ver) {
        switch (ver) {
            case 0:
                tipoB = false;
                especialidadB = true;
                jComboBoxB = true;
                break;
            case 1:
                tipoB = true;
                especialidadB = false;
                jComboBoxB = true;
                break;
            case 2:
                tipoB = true;
                especialidadB = true;
                jComboBoxB = false;
                break;
            default:
                break;
        }

        initComponents();
        this.setVisible(true);
    }

    /**
     * Método que permite la gestión de los componentes de la ventana
     *
     */
    private void initComponents() {
        // Paneles
        panelAux = new JPanel();
        panelAux.setVisible(true);
        panelAux2 = new JPanel();
        panelAux2.setVisible(true);

        // new GridLayout(filas,columnas,espacio entre columnas, espacio entre filas)
        if (tipoB && especialidadB) {
            this.setLayout(new GridLayout(4, 2, 5, 1));
        } else {
            this.setLayout(new GridLayout(2, 2, 5, 1));
        }
        // this.setVisible(true);

        // Labels
        tTipo = new JLabel("Tipo:");
        // this.tipo.setFont(new Font("Arial", Font.PLAIN, 24));
        tTipo.setVerticalAlignment(SwingConstants.CENTER);

        tAsignatura = new JLabel("Asignatura:");
        // this.tipo.setFont(new Font("Arial", Font.PLAIN, 24));
        tAsignatura.setVerticalAlignment(SwingConstants.CENTER);

        tipoCurso = new JComboBox();
        tipoCurso.addItem(sBoxIn);
        tipoAsig = new JComboBox();
        tipoAsig.addItem(sBoxIn);

        // Radio botones
        gTipo = new ButtonGroup();
        optativa = new JRadioButton("Optativa", false);
        obligatoria = new JRadioButton("Obligatoria", false);

        gTipo.add(optativa);
        gTipo.add(obligatoria);

        gEspecialidad = new ButtonGroup();
        fp = new JRadioButton("FP", false);
        batch = new JRadioButton("Bachillerato", false);

        gEspecialidad.add(fp);
        gEspecialidad.add(batch);

        // Escuchadores//
        // Grupo Tipo
        optativa.setActionCommand(TOOL_TIP_TEXT_KEY);
        optativa.addActionListener(radioButtonActionListenerOpt);
        obligatoria.setActionCommand(TOOL_TIP_TEXT_KEY);
        obligatoria.addActionListener(radioButtonActionListenerObl);
        // Grupo Especialidad
        fp.setActionCommand(TOOL_TIP_TEXT_KEY);
        fp.addActionListener(radioButtonActionListenerFP);
        batch.setActionCommand(TOOL_TIP_TEXT_KEY);
        batch.addActionListener(radioButtonActionListenerBt);

        this.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent event) {
                // Component added somewhere
                tipoCurso.removeAllItems();
                tipoAsig.removeAllItems();
                tipoCurso.addItem(sBoxIn);
                tipoAsig.addItem(sBoxIn);
                gTipo.clearSelection();
                gEspecialidad.clearSelection();
            }

            @Override
            public void ancestorRemoved(AncestorEvent event) {
                // Component removed from container
            }

            @Override
            public void ancestorMoved(AncestorEvent event) {
                // Component container moved
            }
        });

        // Añadimos componentes a los paneles
        if (tipoB && especialidadB && jComboBoxB) {
            this.add(tTipo);
            this.add(fp);
            panelAux.add(tipoCurso);
            this.add(panelAux);
            this.add(batch);
            this.add(tAsignatura);
            this.add(optativa);
            panelAux2.add(tipoAsig);
            this.add(panelAux2);
            this.add(obligatoria);
        } else {
            if (!tipoB) {
                panelAux2.add(tipoAsig);

                this.add(tAsignatura);
                this.add(optativa);
                this.add(panelAux2);
                this.add(obligatoria);
            }
            if (!especialidadB) {
                panelAux.add(tipoCurso);

                this.add(tTipo);
                this.add(fp);
                this.add(panelAux);
                this.add(batch);
            }
            if (!jComboBoxB) {
                this.add(tTipo);
                this.add(fp);
                this.add(panelAux);
                this.add(batch);

                this.add(tAsignatura);
                this.add(optativa);
                this.add(panelAux2);
                this.add(obligatoria);
            }
        }
    }

    ActionListener radioButtonActionListenerOpt = new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tipoAsig.removeAllItems();
            tipoAsig.addItem("Perfiles");

            for (int i = 0; i < perfiles.length; i++) {
                tipoAsig.addItem(perfiles[i]);
            }
        }
    };

    ActionListener radioButtonActionListenerObl = new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tipoAsig.removeAllItems();

            for (int i = 0; i < creditos.length; i++) {
                tipoAsig.addItem(creditos[i]);
            }
        }
    };

    ActionListener radioButtonActionListenerFP = new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tipoCurso.removeAllItems();
            tipoCurso.addItem("Especialidades");

            for (int i = 0; i < especialidades.length; i++) {
                tipoCurso.addItem(especialidades[i]);
            }
        }
    };

    ActionListener radioButtonActionListenerBt = new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            tipoCurso.removeAllItems();
            tipoCurso.addItem("Año");

            for (int i = 0; i < tBach.length; i++) {
                tipoCurso.addItem(tBach[i]);
            }
        }
    };

    /**
     * Método que devuelve con un valor númerico que botones están pulados: FP o
     * Bachiller
     *
     * NADA = 0 || FP = 1 || BACHILLERATO = 2
     *
     * @return select
     */
    public int getSelectTCurso() {
        int select = 0;
        if (fp.isSelected()) {
            select = 1;

        } else if (batch.isSelected()) {
            select = 2;
        }
        return select;
    }

    /**
     * Método que devuelve el objeto selecionado en los cursos
     *
     * @return
     */
    public Object getSelectComboCurso() {
        return tipoCurso.getSelectedItem();
    }

    /**
     * Método que devuelve con un valor númerico que botones están pulados:
     * Optativa o Obligatoria
     *
     * NADA = 0 || Optativa = 1 || Obligatoria = 2
     *
     * @return select
     */
    public int getSelectEspAsignatura() {
        int select = 0;
        if (optativa.isSelected()) {
            select = 1;

        } else if (obligatoria.isSelected()) {
            select = 2;
        }
        return select;
    }

    /**
     * Método que devuelve el objeto selecionado en las asignatuas
     *
     * @return
     */
    public Object getSelectComboAsig() {
        return tipoAsig.getSelectedItem();
    }

    /**
     * Método que devuelve con un valor númerico que botones están pulados:
     *
     * NADA = 0
     *
     * FP - OBLIGATORIA = 1 || FP - OPTATIVA = 2
     *
     * BACHILLERATO - OBLICATORIA = 3 || BACHILLERATO - OPTATIVA = 4
     *
     * @return select
     */
    public int getSelect() {
        int select = 0;

        if (fp.isSelected()) {
            if (obligatoria.isSelected()) {
                select = 1;
            } else if (optativa.isSelected()) {
                select = 2;
            }
        } else if (batch.isSelected()) {
            if (obligatoria.isSelected()) {
                select = 3;
            } else if (optativa.isSelected()) {
                select = 4;
            }
        }

        return select;
    }

    /**
     * Método que devuelve el entero correspondiente a la especialidad
     *
     * @return
     */
    public int getEspecialidad() {
        if (!isEmpty()) {
            return (int) getAsignatura();
        }
        return -1;
    }

    /**
     * Método que devuelve el tipo de atributo de un curso, es decir, el
     * JComboBox selecionado de "Tipo:"
     *
     * @return
     */
    public Object getTipo() {
        return tipoCurso;
    }

    /**
     * Método que devuelve el tipo de atributo de una Asignatura, es decir, el
     * JComboBox selecionado de "Asignatura:"
     *
     * @return
     */
    public Object getAsignatura() {
        return tipoAsig;
    }

    /**
     * Método que verifica si el panel está vacío
     *
     * @return
     */
    public boolean isEmpty() {
        boolean empty = true;
        
        if (getSelect() != 0 && !getTipo().equals("Tipos de Cursos") && !getTipo().equals("Especialidades")
                && !getAsignatura().equals("Créditos") && !getAsignatura().equals("Perfiles")) {
            empty = false;
        }

        return empty;
    }
}
