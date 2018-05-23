package memoria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTable colaProceso;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 691);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnEjecutar = new JButton("Run");
		btnEjecutar.setBounds(559, 11, 87, 41);
		btnEjecutar.setIcon(new ImageIcon(Ventana.class.getResource("/memoria/play-button .png")));
		btnEjecutar.setSelectedIcon(new ImageIcon(Ventana.class.getResource("/memoria/play-button .png")));
		btnEjecutar.setBackground(new Color(0, 204, 51));
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnEjecutar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cola de Proceso", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 63, 664, 128);
		contentPane.add(panel);
		panel.setLayout(null);
		
		colaProceso = new JTable();
		colaProceso.setBounds(10, 54, 390, 48);
		panel.add(colaProceso);
		colaProceso.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		colaProceso.setRowSelectionAllowed(false);
		colaProceso.setEnabled(false);
		colaProceso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		colaProceso.setSurrendersFocusOnKeystroke(true);
		colaProceso.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null, "", null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Proceso", "Tiempo de Rafaga", "Tiempo de Llegada", "Estado"
			}
		));
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(429, 54, 225, 32);
		panel.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		
		JLabel lblProceso = new JLabel("Proceso");
		lblProceso.setBounds(10, 29, 46, 14);
		panel.add(lblProceso);
		
		JLabel lblTLlegada = new JLabel("T. Llegada");
		lblTLlegada.setBounds(112, 29, 85, 14);
		panel.add(lblTLlegada);
		
		JLabel lblTRafaga = new JLabel("T. Rafaga");
		lblTRafaga.setBounds(220, 29, 79, 14);
		panel.add(lblTRafaga);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(332, 29, 46, 14);
		panel.add(lblEstado);
		
		JLabel label = new JLabel("Proceso");
		label.setBounds(441, 29, 46, 14);
		panel.add(label);
		
		JLabel lblPagina = new JLabel("Pagina");
		lblPagina.setBounds(513, 29, 46, 14);
		panel.add(lblPagina);
		
		JLabel lblInstruccion = new JLabel("Instruccion");
		lblInstruccion.setBounds(592, 29, 62, 14);
		panel.add(lblInstruccion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Memoria RAM", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 202, 664, 128);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table_3 = new JTable();
		table_3.setBounds(332, 21, 0, 0);
		panel_1.add(table_3);
		
		table_2 = new JTable();
		table_2.setBounds(337, 21, 0, 0);
		panel_1.add(table_2);
		
		table_1 = new JTable();
		table_1.setBounds(342, 21, 0, 0);
		panel_1.add(table_1);
		
		table_4 = new JTable();
		table_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"Pagina"
			}
		));
		table_4.setBounds(32, 57, 601, 60);
		panel_1.add(table_4);
		
		JLabel lblPagina_1 = new JLabel("Pagina");
		lblPagina_1.setBounds(45, 32, 46, 14);
		panel_1.add(lblPagina_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Memoria Virtual", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 352, 664, 128);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"Pagina"
			}
		));
		table_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_5.setBounds(34, 46, 601, 60);
		panel_2.add(table_5);
		
		JLabel label_1 = new JLabel("Pagina");
		label_1.setBounds(47, 21, 46, 14);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 500, 664, 128);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Proceso", "Pagina"
			}
		));
		table_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_6.setBounds(30, 46, 611, 60);
		panel_3.add(table_6);
		
		JLabel lblProceso_1 = new JLabel("Proceso");
		lblProceso_1.setBounds(53, 21, 46, 14);
		panel_3.add(lblProceso_1);
		
		JLabel label_3 = new JLabel("Pagina");
		label_3.setBounds(366, 21, 46, 14);
		panel_3.add(label_3);
		colaProceso.getColumnModel().getColumn(0).setPreferredWidth(106);
		colaProceso.getColumnModel().getColumn(1).setPreferredWidth(123);
		colaProceso.getColumnModel().getColumn(2).setPreferredWidth(118);
	}
}
