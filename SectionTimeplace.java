

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class SectionTimeplace extends javax.swing.JFrame {
private int needed_id_sect;
public static final String DB_URL = "jdbc:mysql://localhost/mydb";
public static final String DB_Driver = "com.mysql.jdbc.Driver";
public static final String DB_Password = "Alushta2022";
    /**
     * Creates new form SectionTimeplace
     */
Calendar calendar = new Calendar() {
    @Override
    protected void computeTime() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void computeFields() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(int field, int amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void roll(int field, boolean up) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMinimum(int field) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getMaximum(int field) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getGreatestMinimum(int field) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getLeastMaximum(int field) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
};
    public SectionTimeplace() {
        initComponents();
        Connect();
        
        Table();
        setDefaultCloseOperation(SectionTimeplace.DISPOSE_ON_CLOSE);
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
        String GetSecName = txtGetSecName.getSelectedItem().toString();
        PreparedStatement pst2 = con.prepareStatement("SELECT id_section FROM mydb.section WHERE section_name =?");
        pst2.setString(1,GetSecName);
        ResultSet rs2 = pst2.executeQuery();
       int got_id_sec = 0;
        while(rs2.next())
        { 
         got_id_sec = rs2.getInt(1);
        }
            
            pst = con.prepareStatement("SELECT * FROM section_timeplace WHERE id_section_got = ?");
            pst.setInt(1, got_id_sec);
            
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
                    v2.add(Rs.getString("date"));
                    v2.add(Rs.getString("place"));
                    v2.add(Rs.getString("time"));
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

        txtGetSecName = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        Delete = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        txtgetDate = new javax.swing.JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
        txtgetPlace = new javax.swing.JTextField();
        txtgetTime = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtGetSecName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGetSecName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A. Неравновесные и равновесные процессы в соплах и струях", "B. Гиперзвуковая аэротермодинамика, химические реакции, горение, детонация", "C. Многофазные течения и процессы тепломассообмена", "D. Плазменная аэродинамика. Течения разреженного газа. Взаимодействие потоков с поверхностью","E. Общая механика, механика деформируемого твердого тела, трибология","F. Классическая и небесная механика, мехатроника, биомеханика","G. Аэрокосмическая механика, создание и эксплуатация аэрокосмической техники, экологические проблемы", "H. Компьютерное моделирование. Численные методы. Высокопроизводительные вычисления", "I. Методы искусственного интеллекта. Машинное обучение и обработка больших данных", "J. Управление, оптимизация и обработка информации","K. Образовательные технологии в аэрокосмической отрасли" }));
        txtGetSecName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtGetSecNameItemStateChanged(evt);
            }
        });
        txtGetSecName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGetSecNameMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtGetSecNameMousePressed(evt);
            }
        });
        txtGetSecName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGetSecNameActionPerformed(evt);
            }
        });

        jToggleButton1.setText("jToggleButton1");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Дата", "Место проведения", "Время начала"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Add.setText("Добавить");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Delete.setText("Удалить");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Изменить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtgetDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgetDateActionPerformed(evt);
            }
        });

        txtgetTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgetTimeActionPerformed(evt);
            }
        });

        jToggleButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jToggleButton2.setText("Обновить");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Дата");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Место проведения");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Время");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtGetSecName, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jToggleButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtgetDate, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))
                        .addComponent(txtgetPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtgetTime, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGetSecName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgetDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgetPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgetTime, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void mouseClicked(MouseEvent event){
        if (event.getClickCount() == 2 && event.getButton() == MouseEvent.BUTTON1) {
            Test();
        }

    }
    public void Test(){
          try {
    int row = jTable1.getSelectedRow();
    String date_get = jTable1.getModel().getValueAt(row, 0).toString();
    String place_get = jTable1.getModel().getValueAt(row, 1).toString();
        
    String GetSecName = txtGetSecName.getSelectedItem().toString();
    PreparedStatement pst2 = con.prepareStatement("SELECT id_section FROM mydb.section WHERE section_name =?");
    pst2.setString(1,GetSecName);
    ResultSet rs2 = pst2.executeQuery();
    int got_id_sec = 0;
    while(rs2.next())
    { 
        got_id_sec = rs2.getInt(1);
    }
        pst = con.prepareStatement("SELECT idsection_timeplace FROM  mydb.section_timeplace WHERE id_section_got = ? AND date = ? AND place = ?");
        pst.setInt(1,got_id_sec);
        pst.setString(2, date_get);
        pst.setString(3, place_get);

        ResultSet Rs = pst.executeQuery();
        
        while(Rs.next())
           {  
                this.needed_id_sect = Rs.getInt(1);
           }
    
        System.out.println("KEKW");
        this.setVisible(false);
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public int getId(){
        return needed_id_sect;
    }
    
    
    public void LoadNames(){
            try
                {
              
                pst = con.prepareStatement("SELECT section_name FROM mydb.section");
                ResultSet rs = pst.executeQuery();
                txtGetSecName.removeAllItems();
 
                while (rs.next())
                  {
                     
                     txtGetSecName.addItem(rs.getString(1));
                  }
                }
                catch ( Exception e)
                {
                   e.printStackTrace();
                }
    }
    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
      try {
       
       java.util.Calendar selectedDate = java.util.Calendar.getInstance();
        String Sec_date = txtgetDate.getText();
        String Sec_place =txtgetPlace.getText();
        String Sec_Time =txtgetTime.getText();
        String GetSecName = txtGetSecName.getSelectedItem().toString();
        
        PreparedStatement pst2 = con.prepareStatement("SELECT id_section FROM mydb.section WHERE section_name =?");
        pst2.setString(1,GetSecName);
        ResultSet rs2 = pst2.executeQuery();
       int got_id_sec = 0;
        while(rs2.next())
        { 
         got_id_sec = rs2.getInt(1);
        }
        
        pst = con.prepareStatement("insert into mydb.section_timeplace(id_section_got,date,place,time)values(?,?,?,?)");
        pst.setInt(1, got_id_sec);
        pst.setString(2,Sec_date);
        pst.setString(3,Sec_place);
        pst.setString(4,Sec_Time);
        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "Секция назначена");
            txtgetDate.setText("");
            txtgetPlace.setText("");
            txtgetTime.setText("");
            txtgetTime.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ошибка");
        }
        Table();
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_AddActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

        try {
        
            
        int row = jTable1.getSelectedRow();
        String date_get = jTable1.getModel().getValueAt(row, 0).toString();
        String place_get = jTable1.getModel().getValueAt(row, 1).toString();
        
        String GetSecName = txtGetSecName.getSelectedItem().toString();
        
        PreparedStatement pst2 = con.prepareStatement("SELECT id_section FROM mydb.section WHERE section_name =?");
        pst2.setString(1,GetSecName);
        ResultSet rs2 = pst2.executeQuery();
       int got_id_sec = 0;
        while(rs2.next())
        { 
         got_id_sec = rs2.getInt(1);
        }
        
        
        pst = con.prepareStatement("DELETE FROM  mydb.section_timeplace WHERE id_section_got = ? AND date = ? AND place = ?");
        pst.setInt(1,got_id_sec);
        pst.setString(2, date_get);
        pst.setString(3, place_get);

        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "Секция откреплена");
            //txtSection.setText("");
            //txtSection.requestFocus();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Ошибка");
        }
        Table();
        
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(SectionForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_DeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
        String Sec_date = txtgetDate.getText();
        String Sec_place =txtgetPlace.getText();
        String Sec_Time =txtgetTime.getText(); 
        
        int row = jTable1.getSelectedRow();
        String date_get = jTable1.getModel().getValueAt(row, 0).toString();
        String place_get = jTable1.getModel().getValueAt(row, 1).toString();
        
        String GetSecName = txtGetSecName.getSelectedItem().toString();
        
        PreparedStatement pst2 = con.prepareStatement("SELECT id_section FROM mydb.section WHERE section_name =?");
        pst2.setString(1,GetSecName);
        ResultSet rs2 = pst2.executeQuery();
       int got_id_sec = 0;
        while(rs2.next())
        { 
         got_id_sec = rs2.getInt(1);
        }
        
        pst = con.prepareStatement("update mydb.section_timeplace set date = ?, place = ?, time = ? WHERE id_section_got = ? AND date = ? AND place = ?");
        pst.setString(1,Sec_date);
        pst.setString(2, Sec_place);
        pst.setString(3, Sec_Time);
        pst.setInt(4, got_id_sec);
        pst.setString(5, date_get);
        pst.setString(6, place_get);
        int k = pst.executeUpdate();
        
        if(k==1)
        {
            JOptionPane.showMessageDialog(this, "Запись обновлена");
            txtgetDate.setText("");
            txtgetPlace.setText("");
            txtgetPlace.setText("");
            txtgetTime.requestFocus();
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

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        new SectionForm().setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txtgetDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgetDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgetDateActionPerformed

    private void txtGetSecNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGetSecNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGetSecNameActionPerformed

    private void txtGetSecNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGetSecNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGetSecNameMouseClicked

    private void txtGetSecNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGetSecNameMousePressed
        
    }//GEN-LAST:event_txtGetSecNameMousePressed

    private void txtGetSecNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtGetSecNameItemStateChanged
        Table();
    }//GEN-LAST:event_txtGetSecNameItemStateChanged

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        LoadNames();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void txtgetTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgetTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgetTimeActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        mouseClicked(evt);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseExited

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseReleased

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
            java.util.logging.Logger.getLogger(SectionTimeplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SectionTimeplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SectionTimeplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SectionTimeplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SectionTimeplace().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JToggleButton Delete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JComboBox<String> txtGetSecName;
    private javax.swing.JTextField txtgetDate;
    private javax.swing.JTextField txtgetPlace;
    private javax.swing.JTextField txtgetTime;
    // End of variables declaration//GEN-END:variables
}
