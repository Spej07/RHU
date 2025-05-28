
package admin;

import config.Session;
import config.dbConnect;
import java.awt.Color;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author clair
 */
public class adminUserf extends javax.swing.JFrame {

     
    public adminUserf() {
        initComponents();
        displayData();
    }

 public void displayData() {
    dbConnect dbc = new dbConnect();
    try {
        String query = "SELECT u_id, u_fname, u_lname, u_username, "
                     + "u_email, u_phoneNumber, u_type, u_status FROM tbl_user";
        
        ResultSet rs = dbc.getData(query);
        accounttble.setModel(DbUtils.resultSetToTableModel(rs));
        
       
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accounttble = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        border = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(235, 230, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 80, 30));

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setBackground(new java.awt.Color(230, 189, 230));
        back.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(102, 102, 102));
        back.setText("BACK");
        back.setToolTipText("");
        back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 90, 30));

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Current User");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 200, -1));

        acc_id.setForeground(new java.awt.Color(102, 102, 102));
        acc_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_id.setText("  id  ");
        jPanel2.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 370));

        accounttble.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        accounttble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(accounttble);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 410, 230));

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 80, 30));

        jButton4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 102, 102));
        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, 30));

        border.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        border.setForeground(new java.awt.Color(102, 102, 102));
        border.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        border.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "ADMIN DASHBOARD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(border, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 400, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
      ManagerDashboard md = new ManagerDashboard();
            md.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
    Session sess = Session.getInstance();
        acc_id.setText(""+sess.getID());    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int rowIndex = accounttble.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select a User!");
        } else {
            try {
                dbConnect dbc = new dbConnect();
                TableModel tbl = accounttble.getModel();


                String query = "SELECT * FROM tbl_user WHERE u_id = '" +tbl.getValueAt(rowIndex, 0)+ "'";
                ResultSet rs = dbc.getData(query);
                System.out.println(""+tbl.getValueAt(rowIndex, 0));
                if (rs.next()) {
                    createUserf crf = new createUserf();

                    crf.ID.setText(""+rs.getInt("u_id"));
                    crf.fn.setText(""+rs.getString("u_fname")); 
                    crf.ln.setText(""+rs.getString("u_lname")); 
                    crf.em.setText(""+rs.getString("u_email")); 
                    crf.pnr.setText(""+rs.getString("u_phoneNumber")); 
                    crf.ty.setSelectedItem(""+rs.getString("u_type")); 
                    crf.usn.setText(""+rs.getString("u_username")); 
                    crf.pwd.setText(""+rs.getString("u_password")); 
                    crf.us.setSelectedItem(""+rs.getString("u_status")); 
                    crf.add.setEnabled(false);
                     crf.update.setEnabled(true);
                    crf.setVisible(true);
                    this.dispose();
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex.getMessage()); 
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           createUserf crf = new createUserf();
        crf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int selectedRow = accounttble.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a User to delete.");
            return;
        }

        String UserId = accounttble.getValueAt(selectedRow, 0).toString(); // assuming column 0 is p_id

        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to delete User ID: " + UserId + "?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                dbConnect dbc = new dbConnect();
                String sql = "DELETE FROM tbl_user WHERE u_id = ?";
                java.sql.PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
                pstmt.setString(1, UserId);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "User deleted successfully.");
                    ((javax.swing.table.DefaultTableModel) accounttble.getModel()).removeRow(selectedRow); // Remove from table
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
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(adminUserf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminUserf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminUserf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminUserf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminUserf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_id;
    private javax.swing.JTable accounttble;
    private javax.swing.JButton back;
    private javax.swing.JLabel border;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

  
}
