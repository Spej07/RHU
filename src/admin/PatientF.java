/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import login.loginf;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author clair
 */
public class PatientF extends javax.swing.JFrame {

    /**
     * Creates new form Patient
     */
    public PatientF() {
        initComponents();
            displayData();
    }

    
     private void loadUsersData() 
    {
      DefaultTableModel model = (DefaultTableModel) patienttbl.getModel();
    model.setRowCount(0); 

    String sql = "SELECT * FROM tbl_patient WHERE p_status != 'Deleted'";

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/birthingcenter", "root", "");
         PreparedStatement pst = con.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("p_id"),
                rs.getString("p_firstname"),
                rs.getString("p_lastname"),
                rs.getInt("p_age"),
                rs.getString("p_dob"),
                rs.getString("p_address"),
                rs.getString("p_contactNumber"),
                rs.getString("p_status")
            });
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading patient data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }

    }
    
    
    
       public void logEvent(int userId, String username, String action) 
    {
        dbConnect dbc = new dbConnect();
        Connection con = dbc.getConnection();
        PreparedStatement pstmt = null;
        Timestamp time = new Timestamp(new Date().getTime());

        try {
            String sql = "INSERT INTO tbl_logs (u_id, u_username, action_time, log_action) "
                    + "VALUES ('" + userId + "', '" + username + "', '" + time + "', '" + action + "')";
            pstmt = con.prepareStatement(sql);

            /*            pstmt.setInt(1, userId);
            pstmt.setString(2, username);
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setString(4, userType);*/
            pstmt.executeUpdate();
            System.out.println("Login log recorded successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error recording log: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }
    
    public void displayData() {
    dbConnect dbc = new dbConnect();
    try {
        String query = "SELECT p_id, p_firstname, p_lastname, p_age, "
                     + "p_dob, p_address, p_contactNumber FROM tbl_patient";

        ResultSet rs = dbc.getData(query);
        patienttbl.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
       private void deleteUser() {
        dbConnect dbc = new dbConnect();
        Session sess = Session.getInstance();
        dbConnect connector = new dbConnect();
//        int userId = 0;
        String uname3 = null;
        String uname2 = null;
        String uname = null;
        int userId = 0;

        int selectedRow = patienttbl.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to delete.");
            return;
        }

        int productId = Integer.parseInt(patienttbl.getValueAt(selectedRow, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {

            try {
                String query2 = "SELECT * FROM tbl_patient WHERE p_id = '" + productId + "'";
                PreparedStatement pstmt = connector.getConnection().prepareStatement(query2);

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    String ID = rs.getString("p_id");
                    String fn = rs.getString("p_firstname");
                    String ln = rs.getString("p_lastprice");
                     String age= rs.getString("p_age");
                     String dob= rs.getString("p_dob");
                      String ADR = rs.getString("p_address");
                     String cn = rs.getString("p_contactNumber");
                       String s = "Deleted";

                    dbc.updateData("UPDATE tbl_patient SET p_firstname = '" + fn + "', p_lastname = '" + ln + "', p_age = '" + age+ "', p_dob = '" + dob+ "' , p_address = '" + ADR+ "'  , p_contactNumber = '" +cn+ "' WHERE p_id = '" + ID + "'");

                    try {
                        System.out.println("1");
                        String query = "SELECT * FROM tbl_patient WHERE u_id = '" + sess.getID() + "'";
                        PreparedStatement pstmt2 = connector.getConnection().prepareStatement(query);

                        ResultSet rs2 = pstmt2.executeQuery();

                        if (rs2.next()) {
                            System.out.println("2");
                            userId = rs2.getInt("u_id");
                            uname2 = rs2.getString("u_username");
                            loadUsersData();
                        }
                        logEvent(userId, uname2, "Admin Deleted Account: " + uname2);

                    } catch (SQLException ex) 
                    {
                        System.out.println("" + ex);
                    }
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        log = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        acc_name = new javax.swing.JLabel();
        acc_lname = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patienttbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        admin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(235, 230, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        log.setBackground(new java.awt.Color(230, 189, 230));
        log.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        log.setForeground(new java.awt.Color(102, 102, 102));
        log.setText("BACK");
        log.setToolTipText("");
        log.setBorder(null);
        log.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logMouseClicked(evt);
            }
        });
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });
        jPanel2.add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 90, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-100_1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 130));

        acc_name.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acc_name.setForeground(new java.awt.Color(102, 102, 102));
        acc_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name.setText("USER");
        jPanel2.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 180, -1));

        acc_lname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acc_lname.setForeground(new java.awt.Color(102, 102, 102));
        acc_lname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_lname.setText("USER");
        jPanel2.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 410));

        patienttbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(patienttbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 450, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-20.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, 30));

        add.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(102, 102, 102));
        add.setText("   ADD PATIENT");
        add.setToolTipText("");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 140, 30));

        update.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(102, 102, 102));
        update.setText("EDIT");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 110, 30));

        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 110, 30));

        admin.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        admin.setForeground(new java.awt.Color(102, 102, 102));
        admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "PATIENT DASHBOARD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 470, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseClicked

    }//GEN-LAST:event_logMouseClicked

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
       ManagerDashboard md = new ManagerDashboard();
            md.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_logActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
   EditF ef = new EditF();
    ef.update.setEnabled(false);
  ef.ID.setVisible(false);  // 
   ef.setVisible(true);
  this.dispose();
           
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
      int rowIndex = patienttbl.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select an Item!");
        } else {
            try {
                dbConnect dbc = new dbConnect();
                TableModel tbl = patienttbl.getModel();


                String query = "SELECT * FROM tbl_patient  WHERE p_id = '" +tbl.getValueAt(rowIndex, 0)+ "'";
                ResultSet rs = dbc.getData(query);
                System.out.println(""+tbl.getValueAt(rowIndex, 0));
                if (rs.next()) {
                    EditF ef  = new EditF();

                    ef.ID.setText(""+rs.getInt("p_id"));
                    ef.fn.setText(""+rs.getString("p_firstname")); 
                    ef.ln.setText(""+rs.getString("p_lastname")); 
                    ef.age.setText(""+rs.getString("p_age")); 
                    ef.dob.setText(""+rs.getString("p_dob")); 
                    ef.ADR.setText(""+rs.getString("p_address")); 
                    ef.cn.setText(""+rs.getString("p_contactNumber")); 
                    ef.ID.setEnabled(false);
                    ef.add.setEnabled(false);
                    ef.update.setEnabled(true);
                    ef.setVisible(true);
                    this.dispose();
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex.getMessage()); 
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int selectedRow = patienttbl.getSelectedRow(); 

if (selectedRow == -1) {
    JOptionPane.showMessageDialog(null, "Please select a patient to delete.");
    return;
}

String patientId = patienttbl.getValueAt(selectedRow, 0).toString(); // assuming column 0 is p_id

int confirm = JOptionPane.showConfirmDialog(
        null,
        "Are you sure you want to delete Patient ID: " + patientId + "?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
);

if (confirm == JOptionPane.YES_OPTION) {
    try {
        dbConnect dbc = new dbConnect();
        String sql = "DELETE FROM tbl_patient WHERE p_id = ?";
        java.sql.PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
        pstmt.setString(1, patientId);

        int affectedRows = pstmt.executeUpdate();

        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(null, "Patient deleted successfully.");
            ((javax.swing.table.DefaultTableModel) patienttbl.getModel()).removeRow(selectedRow); // Remove from table
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete patient.");
        }

        pstmt.close();
    } catch (java.sql.SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    }
} else {
    JOptionPane.showMessageDialog(null, "Deletion canceled.");
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
 Session sess = Session.getInstance();
     
        if(sess.getID() == 0 ){
            JOptionPane.showMessageDialog(null,"No account, Login First!");
            loginf lf = new loginf();
             lf.setVisible(true);
            this.dispose();  
        }else{
            acc_name.setText(""+sess.getFname());
           acc_lname.setText(""+sess.getLname());
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(PatientF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_name;
    public javax.swing.JButton add;
    private javax.swing.JLabel admin;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton log;
    private javax.swing.JTable patienttbl;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
