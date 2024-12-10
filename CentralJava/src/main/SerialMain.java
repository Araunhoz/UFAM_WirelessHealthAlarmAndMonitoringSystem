package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Random;
import java.util.Scanner;

public class SerialMain extends javax.swing.JFrame implements ActionListener {
    SerialTest main;
    NewSick newsick;
    Sick sick;
    ConexaoTela1 bd;
    AllSick allsick;
    Timer timer1;
    
    public SerialMain() {
        initComponents();
        init_all();
    }
    
    private void init_all()
    {
        /*//Abre conexão
        main = new SerialTest();
        main.initialize();
        if(main.ok){
            jTextArea1.setText("");
            timer1 = new Timer(1000,this);
            timer1.start();
        }
        else{
            jTextArea1.setText("Sem conexão");
        }
        //*/
        newsick = new NewSick();
        newsick.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        sick = new Sick();
        sick.newsick = newsick;
        sick.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //Cria objeto do banco:
        bd = new ConexaoTela1();
        //para teste sem porta:
        allsick = new AllSick();
        allsick.bd = bd;
        timer1 = new Timer(1000,this);
        timer1.start();
        //Fim do teste sem porta.
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Executado a cada 1 seg
        
        String buffer;
        Integer aux_add, aux_sensor, aux_al;
        /*//Logica com porta
        buffer = main.data;
        main.data = new String();
        //Fim da logica com porta.*/
        //Logica aleatoria.
        buffer = new String();
        Random x = new Random();
        for(int i=1; i <= 1+x.nextInt(4); i++){
            aux_add = i;
            aux_sensor = x.nextInt(200)+300;
            buffer = buffer + aux_add.toString() + " " + aux_sensor.toString() + " 0\n";
        }
        //Fim da logica aleatoria.
        jTextArea1.setText(buffer);
        Scanner input = new Scanner(buffer);
        
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        
        while(input.hasNextLine()){
            String aux = input.nextLine();
            if(aux.length() == 7){
                aux_add = Integer.parseInt(aux.substring(0, 1));
                aux_sensor = Integer.parseInt(aux.substring(2, 5));
                aux_al = Integer.parseInt(aux.substring(6,7));
                NewSick.Paciente aux_p = newsick.pacientes.get(aux_add-1);
                aux_p.sensor1 = aux_sensor;
                aux_p.alarme = aux_al;
                
                if(aux_p.xbee.isEmpty() == false){
                    bd.adicionarDado(aux_p);
                }
                
                switch(aux_add){
                    case 1:
                        jXbee1.setText(aux_p.nome + ": " + aux_sensor.toString());
                        jCheckBox1.setSelected(true);
                        break;
                    case 2:
                        jXbee2.setText(aux_p.nome + ": " + aux_sensor.toString());
                        jCheckBox2.setSelected(true);
                        break;
                    case 3:
                        jXbee3.setText(aux_p.nome + ": " + aux_sensor.toString());
                        jCheckBox3.setSelected(true);
                        break;
                    case 4:
                        jXbee4.setText(aux_p.nome + ": " + aux_sensor.toString());
                        jCheckBox4.setSelected(true);
                        break;                        
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jXbee1 = new javax.swing.JLabel();
        jXbee2 = new javax.swing.JLabel();
        jXbee3 = new javax.swing.JLabel();
        jXbee4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Central");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jXbee1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jXbee1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXbee1.setText("Xbee 1");
        jXbee1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jXbee1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXbee1MouseClicked(evt);
            }
        });
        jXbee1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jXbee1KeyPressed(evt);
            }
        });

        jXbee2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jXbee2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXbee2.setText("Xbee 2");
        jXbee2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jXbee2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXbee2MouseClicked(evt);
            }
        });

        jXbee3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jXbee3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXbee3.setText("Xbee 3");
        jXbee3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jXbee3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXbee3MouseClicked(evt);
            }
        });

        jXbee4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jXbee4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXbee4.setText("Xbee 4");
        jXbee4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jXbee4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jXbee4MouseClicked(evt);
            }
        });

        jCheckBox1.setEnabled(false);

        jCheckBox2.setEnabled(false);

        jCheckBox3.setEnabled(false);

        jCheckBox4.setEnabled(false);

        jMenu1.setText("Relatorios");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox4)
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jXbee2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXbee3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXbee4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jXbee1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jXbee1))
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXbee2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXbee3))
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jXbee4)
                    .addComponent(jCheckBox4))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXbee1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXbee1KeyPressed
        
    }//GEN-LAST:event_jXbee1KeyPressed

    private void jXbee1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXbee1MouseClicked
        newsick.index = 0;
        if(newsick.pacientes.get(0).nome.equals("Xbee 1"))
            newsick.setVisible(true);
        else
            sick.setVisible(true);
    }//GEN-LAST:event_jXbee1MouseClicked

    private void jXbee2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXbee2MouseClicked
        newsick.index = 1;
        if(newsick.pacientes.get(1).nome.equals("Xbee 2"))
            newsick.setVisible(true);
        else
            sick.setVisible(true);
    }//GEN-LAST:event_jXbee2MouseClicked

    private void jXbee3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXbee3MouseClicked
        newsick.index = 2;
        if(newsick.pacientes.get(2).nome.equals("Xbee 3"))
            newsick.setVisible(true);
        else
            sick.setVisible(true);
    }//GEN-LAST:event_jXbee3MouseClicked

    private void jXbee4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jXbee4MouseClicked
        newsick.index = 3;
        if(newsick.pacientes.get(3).nome.equals("Xbee 4"))
            newsick.setVisible(true);
        else
            sick.setVisible(true);
    }//GEN-LAST:event_jXbee4MouseClicked

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
        init_all();
    }//GEN-LAST:event_jTextArea1MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        main.close();
    }//GEN-LAST:event_formWindowClosed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        allsick.setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        allsick.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SerialMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SerialMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SerialMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SerialMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SerialMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jXbee1;
    private javax.swing.JLabel jXbee2;
    private javax.swing.JLabel jXbee3;
    private javax.swing.JLabel jXbee4;
    // End of variables declaration//GEN-END:variables
}