/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Staff.NurseDashboard;
import admin.ManagerDashboard;
import config.Session;
import config.dbConnect;
import config.passwordHasher;
import static config.passwordHasher.hashPassword;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JOptionPane;

/**
 *
 * @author clair
 */
public class loginf extends javax.swing.JFrame {

    /**
     * Creates new form loginf
     */
    public loginf() {
        initComponents();
    }

     static String status;
    static String type;
    
    
      public static boolean logAcc(String username, String password)
    {
       dbConnect connector = new dbConnect();
    try {
        
      String query = "SELECT * FROM tbl_user WHERE u_username = ?";
      PreparedStatement pst = connector.getConnection().prepareStatement(query);
      pst.setString(1, username);
      ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            String hashedPass = resultSet.getString("u_password");
            String rehashedPass = hashPassword(password); 

            System.out.println("Stored Password: " + hashedPass);
            System.out.println("Entered Password (Hashed): " + rehashedPass);

            if (hashedPass.equals(rehashedPass)) {
                status = resultSet.getString("u_status");
                type = resultSet.getString("u_type");
             
               Session  sess = Session.getInstance();
                  sess.setID(resultSet.getInt("u_id"));
                  sess.setLname(resultSet.getNString("u_lname"));
                  sess.setUsername(resultSet.getNString("u_username"));
                  sess.setFname(resultSet.getNString("u_fname"));
                  sess.setEmail(resultSet.getNString("u_email"));
                  sess.setPhoneNumber(resultSet.getNString("u_phoneNumber"));
                  sess.setType(resultSet.getNString("u_type"));
                  sess.setStatus(resultSet.getNString("u_status"));

                  return true;
            }      }
    } catch (SQLException | NoSuchAlgorithmException ex) {
        ex.printStackTrace();
    }  return false;
}
      
      
      public void logEvent(int userId, String username, String action) 
    {
        dbConnect dbc = new dbConnect();
        Connection con = dbc.getConnection();
        PreparedStatement pstmt = null;
        Timestamp time = new Timestamp(new Date().getTime());

        try 
        {    
            String sql = "INSERT INTO tbl_logs (u_id, u_username, action_time, log_action) "
                                     + "VALUES ('" + userId + "', '" + username + "', '" + time + "', '" + action + "')";
            System.out.println("userId: "+userId);
            pstmt = con.prepareStatement(sql);

            /*            pstmt.setInt(1, userId);
            pstmt.setString(2, username);
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setString(4, userType);*/

            pstmt.executeUpdate();
            System.out.println("Login log recorded successfully.");
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Error recording log: " + e.getMessage());
        } finally 
        {
            try 
            {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        us = new javax.swing.JTextField();
        login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        us.setBackground(new java.awt.Color(204, 204, 204));
        us.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        us.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        us.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel2.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 280, 50));

        login.setBackground(new java.awt.Color(230, 189, 230));
        login.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        login.setForeground(new java.awt.Color(102, 102, 102));
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        jPanel2.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 90, 30));

        jLabel5.setBackground(new java.awt.Color(230, 189, 230));
        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-hide-password-24.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, -1, 40));

        pass.setBackground(new java.awt.Color(204, 204, 204));
        pass.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        pass.setForeground(new java.awt.Color(153, 153, 153));
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel2.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 280, 50));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Forgot Password? click here");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Don't have an account? REGISTER");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 320, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gwapo ko\\Downloads\\2b4.png")); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 220, 230));

        jLabel12.setBackground(new java.awt.Color(51, 102, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("RURAL HEALTH UNIT APP");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 20, 380, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
     registerf1 rf = new registerf1();
      rf.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
         String uname = us.getText().trim();
        String password = new String(pass.getPassword()).trim();

     if (password.isEmpty() || uname.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Please Fill all Boxes");
     } else if (logAcc(uname, password)) {

    if (!status.equalsIgnoreCase("Active")) {
        JOptionPane.showMessageDialog(null, "Inactive Account, Contact the Admin");
    } else {
        JOptionPane.showMessageDialog(null, "Login Successfully");

        if (type.equalsIgnoreCase("Doctor")) {  
            ManagerDashboard md = new ManagerDashboard();
            md.setVisible(true);
            this.dispose();
        } else if (type.equalsIgnoreCase("Staff")) {  
            NurseDashboard nd = new NurseDashboard();
            nd.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Unknown Account Type, Contact the Admin");
        }
    }
} else {
    JOptionPane.showMessageDialog(null, "Invalid Account");
}
    }//GEN-LAST:event_loginActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
     if (pass.getEchoChar() == '\u2022') { 
        pass.setEchoChar((char) 0); 
    } else {
        pass.setEchoChar('\u2022'); 
    }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    ForgetPass efp = new ForgetPass();
    efp.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(loginf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField us;
    // End of variables declaration//GEN-END:variables
}
