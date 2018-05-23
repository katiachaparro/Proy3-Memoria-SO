/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class Principal extends javax.swing.JFrame {
    String prioridad = "Priorida:";
    //Proceso _proceso= null;
    ListaProcesos _procesos = null;
    public Principal() {
        initComponents();
        setSize(1500,400);
        setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
  
        jLabel2 = new JLabel();
        panel2 = new JPanel();
        nombrePLabel = new JLabel();
        tiempoLlegLabel = new JLabel();
        tiempoRafLabel = new JLabel();
        prioridadLabel = new JLabel();
        tiempoLlegadaField = new JTextField();
        nombrePField = new JTextField();
        prioridadField = new JTextField();
        tiempoRafagaField = new JTextField();
        agregarButton = new JToggleButton();
        panel1 = new JPanel();
        algoritmoCombo = new JComboBox();
        selectAlgLabel = new JLabel();
        runButton = new JButton();
        panel3 = new JScrollPane();
        tabla = new JTable();

        jLabel2.setText("Rafaga");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Planificador de procesos");
        setName("ventana"); // NOI18N
        setResizable(false);

        panel2.setBackground(new Color(255, 255, 255));

        nombrePLabel.setFont(new Font("Lucida Calligraphy", 1, 9)); // NOI18N
        nombrePLabel.setText("Nombre del proceso:");
        nombrePLabel.setToolTipText("");

        tiempoLlegLabel.setFont(new Font("Lucida Calligraphy", 1, 9)); // NOI18N
        tiempoLlegLabel.setText("Tiempo de llegada:");

        tiempoRafLabel.setFont(new Font("Lucida Calligraphy", 1, 9)); // NOI18N
        tiempoRafLabel.setText("Tiempo de rafaga:");

        prioridadLabel.setFont(new Font("Lucida Calligraphy", 1, 9)); // NOI18N
        prioridadLabel.setText(prioridad);

        tiempoLlegadaField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tiempoLlegadaFieldActionPerformed(evt);
            }
        });

        nombrePField.setToolTipText("");
        nombrePField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                nombrePFieldActionPerformed(evt);
            }
        });

        prioridadField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                prioridadFieldActionPerformed(evt);
            }
        });

        tiempoRafagaField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tiempoRafagaFieldActionPerformed(evt);
            }
        });

        agregarButton.setBackground(new Color(0, 0, 204));
        agregarButton.setForeground(new Color(0, 0, 204));
        agregarButton.setIcon(new ImageIcon(getClass().getResource("/memoria/plus.png"))); // NOI18N
        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });
        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        GroupLayout panel2Layout = new GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregarButton))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(tiempoRafLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(prioridadLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tiempoLlegLabel, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(tiempoLlegadaField,GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                            .addComponent(tiempoRafagaField)))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(prioridadField))))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(nombrePLabel, GroupLayout.PREFERRED_SIZE, 140,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombrePField, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrePLabel,GroupLayout.PREFERRED_SIZE, 32,GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombrePField, GroupLayout.PREFERRED_SIZE, 28,GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempoLlegLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoLlegadaField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tiempoRafLabel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addComponent(tiempoRafagaField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(prioridadLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prioridadField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    )
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(9, 9, 9)
                .addComponent(agregarButton)
                .addGap(7, 7, 7))
        );

        nombrePLabel.getAccessibleContext().setAccessibleParent(nombrePLabel);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setBorder(BorderFactory.createCompoundBorder());

        algoritmoCombo.setModel(new DefaultComboBoxModel(new String[] { "Item 1", "SJF EXPULSIVO", "Item 3", "Item 4" }));
        algoritmoCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                algoritmoComboActionPerformed(evt);
            }
        });

        selectAlgLabel.setFont(new java.awt.Font("Lucida Calligraphy", 1, 10)); // NOI18N
        selectAlgLabel.setText("Algoritmo:");

        runButton.setBackground(new java.awt.Color(0, 153, 51));
        runButton.setForeground(new java.awt.Color(0, 153, 51));
        runButton.setIcon(new ImageIcon(getClass().getResource("/memoria/play-button .png"))); // NOI18N

        GroupLayout panel1Layout = new GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(selectAlgLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(algoritmoCombo, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                .addComponent(runButton)
                .addGap(55, 55, 55))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(runButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(algoritmoCombo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectAlgLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panel3.setBackground(new java.awt.Color(255, 255, 255));

        tabla.setModel(new DefaultTableModel(
            new String [3][4],
            new String [] {
                "Proceso", "Tiempo de LLegada", "Tiempo de Rafaga", "Estado"
            }
        ));
        panel3.setViewportView(tabla);

        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(23)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        			.addGap(19))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        			.addContainerGap(248, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    private void nombrePFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_nombrePFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrePFieldActionPerformed

    private void tiempoLlegadaFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tiempoLlegadaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempoLlegadaFieldActionPerformed

    private void prioridadFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_prioridadFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prioridadFieldActionPerformed

    private void tiempoRafagaFieldActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tiempoRafagaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tiempoRafagaFieldActionPerformed

    private void algoritmoComboActionPerformed(ActionEvent evt) {//GEN-FIRST:event_algoritmoComboActionPerformed
        
        String seleccionado  = (String)algoritmoCombo.getSelectedItem();
        if(seleccionado.equals("SJF EXPULSIVO")){
            System.out.println("selecciono sjf expulsivo");
            //ListaProcesos lista = new ListaProcesos();
            //lista.cargarList("MisProcesos.txt");
            //SJF A = new SJF(lista, this);
        }
        
       
    }//GEN-LAST:event_algoritmoComboActionPerformed
    
    private void runButtonActionPerformed(ActionEvent evt) {  
        System.out.println("click en run");
        String seleccionado  = (String)algoritmoCombo.getSelectedItem();
        if(seleccionado.equals("SJF EXPULSIVO")){
            System.out.println("ejecuto sjf expulsivo");
            ListaProcesos lista = new ListaProcesos();
            lista.cargarList("MisProcesos.txt");
            //lista.setPrincipal(this);
           System.out.println("cargo lista");
            Principal a = this;
            this.dispose();
            Planificar  b =new Planificar();
            b.main(null);
             
           // a.run();
            //Thread c = new Thread(this); 
            // c.start();
           // SJF B = new SJF(lista,a);
          //  B.run();
           
            
           
            
           
           //SJF a = new SJF(lista,null);
        }
        
        
    }                                        

    private void agregarButtonActionPerformed(ActionEvent evt) {                                              
        if(_procesos == null ){
            _procesos = new ListaProcesos();
            
        }
        System.out.println("click en agregar");
        Proceso pro = new Proceso();
        pro.setEstado("");
        pro.setNombreProceso(nombrePField.getText());
        pro.setTiempoLlegada(Integer.parseInt(tiempoLlegadaField.getText()));
        pro.setTiempoRafaga(Integer.parseInt(tiempoRafagaField.getText()));
        pro.setPrioridad(Integer.parseInt(prioridadField.getText()));
        _procesos.agregarProceso(pro);
        System.out.println(nombrePField.getText());
        System.out.println(tiempoLlegadaField.getText());
        System.out.println(tiempoRafagaField.getText());
        System.out.println(prioridadField.getText());
       
            setTabla(_procesos.tamano(), _procesos);
       
        
          
    }
    /*PODEMOS UTILIZAR PARA SABER SI SE AGREGO UN PROCESO DE FORMA MANUAL*/
    public int getTamanoProcesos(){
        return _procesos.tamano();
    }
    public ListaProcesos getProcesos(){
        return _procesos;
    }
 
    public void setTabla(int tamano, ListaProcesos lista){
       try{
       //System.out.println("tamaño" + tamano);
       String arreglo [][] = new String [3][4];
       for(int i = 0;i<tamano; i++){
            Proceso _proceso = lista.getProceso(i);
             arreglo[i][0] = _proceso.getNombreProceso();
             arreglo[i][1] = String.valueOf(_proceso.getTiempoLlegada());
             arreglo[i][2] = String.valueOf(_proceso.getTiempoRafaga());
             arreglo[i][3] = _proceso.getEstado();        
       }
       _procesos= lista;
       tabla.updateUI();
       tabla.setModel(new DefaultTableModel(
            arreglo,
             new String [] {
                "Proceso", "Tiempo de LLegada", "Tiempo de Rafaga", "Estado"
             }
         ));
        //panel3.setViewportView(tabla);
        this.validate();
       // this.validate();
       }catch(ArrayIndexOutOfBoundsException e){
       
           System.out.println("error aca");
       }
       
    }
    public void setRafaga(ListaProcesos pro){
        jLabel2.setText("Rafaga: " + pro.getRafaga());
        this.validate();
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JToggleButton agregarButton;
    private JComboBox algoritmoCombo;
    private JLabel jLabel2;
    private JLabel nombrePLabel;
    private JPanel panel1;
    private JPanel panel2;
    private JScrollPane panel3;
    private JTextField prioridadField;
    private JLabel prioridadLabel;
    private JButton runButton;
    private JLabel selectAlgLabel;
    private JTable tabla;
    private JLabel tiempoLlegLabel;
    private JTextField tiempoLlegadaField;
    private JTextField nombrePField;
    private JLabel tiempoRafLabel;
    private JTextField tiempoRafagaField;
    // End of variables declaration//GEN-END:variables
    private JLabel contadorRafaga;

}

