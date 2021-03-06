

import javax.swing.ButtonGroup;
import java.sql.*;
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
public class AuthorForm extends javax.swing.JFrame {
public static final String DB_URL = "jdbc:mysql://localhost/mydb";
public static final String DB_Driver = "com.mysql.jdbc.Driver";
public static final String DB_Password = "Alushta2022";
    /**
     * Creates new form AuthorForm
     */
    public AuthorForm() {
        initComponents();
        Connect();
        Table();
        setDefaultCloseOperation(AuthorForm.DISPOSE_ON_CLOSE);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtFamilyName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOtchestvo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        ???????????????? = new javax.swing.JButton();

        jRadioButton2.setText("jRadioButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("??????????????");

        txtFamilyName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "??????????????", "??????", "????????????????"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("??????");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("????????????????*");

        txtOtchestvo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("????????????????");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton4.setText("??????????????");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("??????????");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setText("????????????????");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        ????????????????.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ????????????????.setText("????????????????");
        ????????????????.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ????????????????ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(31, 31, 31)
                                .addComponent(jButton5)
                                .addGap(31, 31, 31)
                                .addComponent(jButton4)
                                .addGap(58, 58, 58)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOtchestvo, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(263, 263, 263))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFamilyName, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(????????????????))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFamilyName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(????????????????)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOtchestvo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    try {
        String family_name_get = txtFamilyName.getText();
        String name_get = txtName.getText();
        String otchestvo_get = txtOtchestvo.getText();

        pst = con.prepareStatement("insert into mydb.Author(name,family_name,otchestvo)values(?,?,?)");
        pst.setString(1,name_get);
        pst.setString(2, family_name_get);
        pst.setString(3, otchestvo_get);
        
        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "?????????? ????????????????");
            txtFamilyName.setText("");
            txtName.setText("");
            txtOtchestvo.setText("");
            txtFamilyName.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "????????????");
        }
        PreparedStatement pst2 = con.prepareStatement("SELECT id_author FROM  mydb.Author where name = ? AND family_name = ? AND otchestvo =? ");
        pst2.setString(1,name_get);
        pst2.setString(2, family_name_get);
        pst2.setString(3, otchestvo_get);
        ResultSet rs2 = pst2.executeQuery();
        int got_id_author = 0;
        while(rs2.next())
        { 
         got_id_author = rs2.getInt(1);
        }
        PreparedStatement pst3 = con.prepareStatement("INSERT into mydb.table_of_arrival(id_author_arrival)values(?) ");
        pst3.setInt(1,got_id_author);
        int k2=pst3.executeUpdate();
        
        
        Table();
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
        int row = jTable1.getSelectedRow();
        String family_name_get = jTable1.getModel().getValueAt(row, 0).toString();
        String name_get = jTable1.getModel().getValueAt(row, 1).toString();
        String otchestvo_get = jTable1.getModel().getValueAt(row, 2).toString();
        PreparedStatement pst2 = con.prepareStatement("SELECT id_author FROM  mydb.Author where name = ? AND family_name = ? AND otchestvo =? ");
        pst2.setString(1,name_get);
        pst2.setString(2, family_name_get);
        pst2.setString(3, otchestvo_get);
        ResultSet rs2 = pst2.executeQuery();
        int got_id_author = 0;
        while(rs2.next())
        { 
         got_id_author = rs2.getInt(1);
        }
        PreparedStatement pst3 = con.prepareStatement("DELETE FROM mydb.table_of_arrival WHERE id_author_arrival= ? ");
        pst3.setInt(1,got_id_author);
        int k2=pst3.executeUpdate();
        if(k2==1){
            
        }
        else {
            JOptionPane.showMessageDialog(this, "???????????? ???????????????? ???? ?????????????? ????????????????");
        }
        pst = con.prepareStatement("DELETE FROM  mydb.Author WHERE name = ? AND family_name = ? AND otchestvo =?");
        pst.setString(1,name_get);
        pst.setString(2, family_name_get);
        pst.setString(3, otchestvo_get);
        
        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "?????????? ????????????");
            txtFamilyName.setText("");
            txtName.setText("");
            txtOtchestvo.setText("");
            txtFamilyName.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "????????????");
        }
        
        Table();
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
        String author_search = txtSearch.getText();
        //int row = jTable1.getSelectedRow();
        //String org_name_get = jTable1.getModel().getValueAt(row, 0).toString();
        pst = con.prepareStatement("SELECT family_name, name, otchestvo FROM  mydb.Author WHERE CONCAT(family_name, name, otchestvo) LIKE ? ");
        pst.setString(1,"%" + author_search + "%");
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
                    v2.add(Rs.getString("family_name"));
                    v2.add(Rs.getString("name"));
                    v2.add(Rs.getString("otchestvo"));
                }
                DFT.addRow(v2);
        }
        jTable1.setModel(model);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ResultSet k = pst.executeQuery();

    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
        String family_name_get = txtFamilyName.getText();
        String name_get = txtName.getText();
        String otchestvo_get = txtOtchestvo.getText();
        int row = jTable1.getSelectedRow();
        String family_name_get_from_table = jTable1.getModel().getValueAt(row, 0).toString();
        pst = con.prepareStatement("update mydb.author set name = ?, family_name = ?, otchestvo = ? WHERE family_name = ?");
        pst.setString(1,name_get);
        pst.setString(2, family_name_get);
        pst.setString(3, otchestvo_get);
        pst.setString(4, family_name_get_from_table);
        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "???????????? ??????????????????");
            txtFamilyName.setText("");
            txtName.setText("");
            txtOtchestvo.setText("");
            txtFamilyName.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "????????????");
        }
        Table();
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void ????????????????ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_????????????????ActionPerformed
        new ArrivalTable().setVisible(true);
    }//GEN-LAST:event_????????????????ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        txtFamilyName.setText(jTable1.getModel().getValueAt(row, 0).toString());
        txtName.setText(jTable1.getModel().getValueAt(row, 1).toString());
        txtOtchestvo.setText(jTable1.getModel().getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    public void Table()
    {
        try {
            pst = con.prepareStatement("SELECT * FROM mydb.author order by id_author ");
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
                    v2.add(Rs.getString("family_name"));
                    v2.add(Rs.getString("name"));
                    v2.add(Rs.getString("otchestvo"));
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
            java.util.logging.Logger.getLogger(AuthorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthorForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFamilyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOtchestvo;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JButton ????????????????;
    // End of variables declaration//GEN-END:variables
}
