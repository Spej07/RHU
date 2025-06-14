/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import config.dbConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import login.loginf;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author clair
 */
public class Admin_Billing extends javax.swing.JFrame {

    /**
     * Creates new form_Billing
     */
    public Admin_Billing() {
        initComponents();
       
        displayData1() ;
    }

    
    

     
       public void displayData1() {
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        DELETE = new javax.swing.JButton();
        EDIT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patienttbl = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        print = new javax.swing.JLabel();
        acc_name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        acc_lname = new javax.swing.JLabel();
        log = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(235, 230, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DELETE.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DELETE.setForeground(new java.awt.Color(102, 102, 102));
        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        jPanel1.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 100, 30));

        EDIT.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        EDIT.setForeground(new java.awt.Color(102, 102, 102));
        EDIT.setText("EDIT");
        EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITActionPerformed(evt);
            }
        });
        jPanel1.add(EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 100, 30));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 450, 230));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PATIENT LIST TABLE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 490, 30));

        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/database/icons8-print-50.png"))); // NOI18N
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, 60));

        acc_name.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acc_name.setForeground(new java.awt.Color(102, 102, 102));
        acc_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name.setText("ADMIN");
        jPanel1.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-100_1.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 130));

        acc_lname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acc_lname.setForeground(new java.awt.Color(102, 102, 102));
        acc_lname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_lname.setText("ADMIN");
        jPanel1.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, -1));

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
        jPanel1.add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 90, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("TRANSACTION PRINTING");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 470, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseClicked

    }//GEN-LAST:event_logMouseClicked

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        ManagerDashboard md  = new ManagerDashboard();
        md.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        int selectedRow = patienttbl.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a Bill  to delete.");
            return;
        }

        String appointmentId = patienttbl.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to delete Billing ID: " + appointmentId + "?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                dbConnect dbc = new dbConnect();
                String sql = "DELETE FROM tbl_billing WHERE b_id = ?";
                java.sql.PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
                pstmt.setString(1, appointmentId);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Billing  deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete appointment.");
                }

                pstmt.close();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Deletion canceled.");
    }//GEN-LAST:event_DELETEActionPerformed
    }
    private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed
     
    }//GEN-LAST:event_EDITActionPerformed

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

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
        int selectedRow = patienttbl.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a Bill first.");
            return;
        }
        String billingId = patienttbl.getModel().getValueAt(selectedRow, 0).toString();
        String patientName = patienttbl.getModel().getValueAt(selectedRow, 1).toString();
        String description = patienttbl.getModel().getValueAt(selectedRow, 5).toString();
        String totalAmount = patienttbl.getModel().getValueAt(selectedRow, 3).toString();
        String transactionDate = patienttbl.getModel().getValueAt(selectedRow, 4).toString();
        String firstName = patienttbl.getModel().getValueAt(selectedRow, 1).toString();
        String lastName = patienttbl.getModel().getValueAt(selectedRow, 2).toString();
        String patientFullName = firstName + " " + lastName;

     Admin_printing ad = new Admin_printing(billingId,  patientFullName, description, transactionDate,totalAmount);
        //printing p = new printing();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_printMouseClicked

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
            java.util.logging.Logger.getLogger(Admin_Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE;
    private javax.swing.JButton EDIT;
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton log;
    private javax.swing.JTable patienttbl;
    private javax.swing.JLabel print;
    // End of variables declaration//GEN-END:variables
}
