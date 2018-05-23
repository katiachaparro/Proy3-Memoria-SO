package memoria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTable table_4;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 216, 664, 117);
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Memoria RAM", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(panel_1);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_4.setBounds(21, 46, 601, 60);
		panel_1.add(table_4);
		
		JLabel label_2 = new JLabel("Pagina");
		label_2.setBounds(45, 21, 46, 14);
		panel_1.add(label_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(10, 62, 674, 117);
		contentPane.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cola de Proceso", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_1.setViewportView(panel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));

		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setEnabled(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBounds(10, 54, 390, 50);
		panel.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},

			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_1.setBounds(420, 54, 225, 48);
		panel.add(table_1);
		
		JLabel label = new JLabel("Proceso");
		label.setBounds(10, 29, 46, 14);
		panel.add(label);
		
		JLabel label_4 = new JLabel("T. Llegada");
		label_4.setBounds(112, 29, 85, 14);
		panel.add(label_4);
		

		JLabel label_5 = new JLabel("T. Rafaga");
		label_5.setBounds(220, 29, 79, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Estado");
		label_6.setBounds(332, 29, 46, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Proceso");
		label_7.setBounds(441, 29, 46, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Pagina");
		label_8.setBounds(513, 29, 46, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("Instruccion");
		label_9.setBounds(592, 29, 62, 14);
		panel.add(label_9);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(10, 357, 664, 128);
		contentPane.add(scrollPane_2);
		

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Memoria Virtual", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_2.setViewportView(panel_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_2.setBounds(22, 46, 601, 60);
		panel_2.add(table_2);
		
		JLabel label_1 = new JLabel("Pagina");
		label_1.setBounds(47, 21, 46, 14);
		panel_2.add(label_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(10, 514, 664, 127);
		contentPane.add(scrollPane_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Historial", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane_3.setViewportView(panel_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_3.setBounds(24, 46, 611, 48);
		panel_3.add(table_3);
		
		JLabel label_3 = new JLabel("Proceso");
		label_3.setBounds(53, 21, 46, 14);
		panel_3.add(label_3);
		
		JLabel label_10 = new JLabel("Pagina");
		label_10.setBounds(366, 21, 46, 14);
		panel_3.add(label_10);
	}
      public void setTabla(int tamano, ListaProcesos lista){
        try{
        String arreglo [][] = new String [3][4];
        for(int i = 0;i<tamano; i++){
             Proceso _proceso = lista.getProceso(i);
              arreglo[i][0] = _proceso.getNombreProceso();
              arreglo[i][1] = String.valueOf(_proceso.getTiempoLlegada());
              arreglo[i][2] = String.valueOf(_proceso.getTiempoRafaga());
              arreglo[i][3] = _proceso.getEstado();        
        }
        //_procesos= lista;
        table.removeAll();
        table.setBorder(new LineBorder(Color.red, 1, true));
        table.setModel(new DefaultTableModel(
             arreglo,
              new String [] {
                 "Proceso", "Tiempo de Rafaga", "Tiempo de Llegada", "Estado"
              }
          ));

         this.validate();
        // this.validate();
        }catch(ArrayIndexOutOfBoundsException e){

            System.out.println("error aca");
        }
       
    }
    public void setRam(Pagina _memoriaRam[] ){
        String arreglo [][] = new String [_memoriaRam.length][1];
        for(int i = 0;i<_memoriaRam.length; i++){
             Pagina _pagina = _memoriaRam[i];
             if(_pagina != null){
                // System.out.println(_pagina.getProceso().getTiempoRafaga());
                 System.out.println(_pagina.getIdentificador());
                 if(_pagina.getIdentificador()>0){
                     arreglo[i][0] ="cod_pag: " +String.valueOf(_pagina.getIdentificador())+ " Proceso: "+ _pagina.getProceso().getNombreProceso();
     
                 }
               }        
        }
        table_4.removeAll();
        table_4.setBorder(new LineBorder(Color.red, 1, true));
        table_4.setAutoscrolls(true);
        table_4.setModel(new DefaultTableModel(
             arreglo,
              new String [] {
                 "Pagina"
              }
          ));
        
       
        this.validate();
    }
     public void setVirtual(ArrayList<Pagina> _memoriaV ){
        String arreglo [][] = new String [_memoriaV.size()][1];
        for(int i = 0;i<_memoriaV.size(); i++){
             Pagina _pagina = _memoriaV.get(i);
             
                // System.out.println(_pagina.getProceso().getTiempoRafaga());
                 System.out.println(_pagina.getIdentificador());
                 arreglo[i][0] = "cod_pag: " +String.valueOf(_pagina.getIdentificador())+ " Proceso: "+ _pagina.getProceso().getNombreProceso();
                    
        }
        table_2.removeAll();
        table_2.setBorder(new LineBorder(Color.red, 1, true));
        table_2.setAutoscrolls(true);
        table_2.setModel(new DefaultTableModel(
             arreglo,
              new String [] {
                 "Pagina"
              }
          ));
        
       
        this.validate();
    }
    public void setPagina(Pagina pagina){
        String arreglo [][] = new String [pagina.getInstruccion().size()][3];
         for(int i = 0;i<pagina.getInstruccion().size(); i++){
          arreglo[i][0] = pagina.getProceso().getNombreProceso();
          arreglo[i][1] = String.valueOf(pagina.getIdentificador());
          arreglo[i][2] = pagina.getListadeInstrucciones().get(i);
          table_1.removeAll();
          table_1.setBorder(new LineBorder(Color.red, 1, true));
          table_1.setAutoscrolls(true);
          table_1.setModel(new DefaultTableModel(
             arreglo,
              new String [] {
                "New column", "New column", "New column"
              }
          ));
        try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                //Logger.getLogger(SJF.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        
    }
}
