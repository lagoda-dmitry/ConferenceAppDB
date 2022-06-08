
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author senhe
 */
public class SectionForm extends javax.swing.JFrame {
public static final String DB_URL = "jdbc:mysql://localhost/mydb";
public static final String DB_Driver = "com.mysql.jdbc.Driver";
public static final String DB_Password = "Alushta2022";
    /**
     * Creates new form SectionForm
     */
    public SectionForm() {
        initComponents();
        setDefaultCloseOperation(SectionForm.DISPOSE_ON_CLOSE);
        Connect();
        Table();
    }
    Connection con;
    PreparedStatement pst;
    public void Connect(){
        try {
            Class.forName(DB_Driver);
            con = DriverManager.getConnection(DB_URL,"root",DB_Password);
            System.out.println("connect");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Archive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Archive.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void Table()
    {
        try {
            pst = con.prepareStatement("SELECT * FROM section");
            ResultSet Rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
          
            ResultSetMetaData RSMD = Rs.getMetaData();
            int CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) jTable1.getModel();
            DFT.setRowCount(0);
            
            while(Rs.next())
           {  
               Vector v2 = new Vector();
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("section_name"));
                }
                DFT.addRow(v2);
            }
            jTable1.setModel(model);
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        txtSection = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Название секции");

        txtSection.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Добавить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("Удалить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Название секции"
            }
        ));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("Изменить");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jButton1)
                .addGap(42, 42, 42)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSection, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        String Sec_name = txtSection.getText();

        pst = con.prepareStatement("insert into mydb.Section(section_name)values(?)");
        pst.setString(1, Sec_name);
        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "Секция добавлена");
            txtSection.setText("");
            txtSection.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ошибка");
        }
        Table();
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
        int row = jTable1.getSelectedRow();
        String Sec_name = jTable1.getModel().getValueAt(row, 0).toString();
        pst = con.prepareStatement("DELETE FROM mydb.Section WHERE section_name=?");
        pst.setString(1, Sec_name);
        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "Секция удалена");
            txtSection.setText("");
            txtSection.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ошибка");
        }
        Table(); 
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
        String Sec_name = txtSection.getText();   
        int row = jTable1.getSelectedRow();
        String org_name_get_from_table = jTable1.getModel().getValueAt(row, 0).toString();
        pst = con.prepareStatement("update mydb.Section set section_name = ? WHERE section_name = ?");
        pst.setString(1,Sec_name);
        pst.setString(2, org_name_get_from_table);
        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "Запись обновлена");
            txtSection.setText("");
            txtSection.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ошибка");
        }
        Table();
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(SectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SectionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SectionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSection;
    // End of variables declaration//GEN-END:variables
}