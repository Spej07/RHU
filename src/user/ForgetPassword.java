
package user;

import config.session;
import config.dbConnector;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;
import dhp.Rhu;


public class ForgetPassword extends javax.swing.JFrame {
  private String correctAnswer;
    
    public ForgetPassword() {
        initComponents();
        
        
    }
    


   private void fetchSecurityQuestion() {
    String username = un.getText();  
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your username.");
        return;
    }

    // Create a database connection
    dbConnector db = new dbConnector();  // Instantiate dbConnector
    Connection con = db.getConnection(); // Get connection

    if (con == null) {
        JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
        return;
    }

    try {
        PreparedStatement stmt = con.prepareStatement(
            "SELECT security_question, security_answer FROM tbl_user WHERE u_username = ?"
        );
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            sq.removeAllItems();
            sq.addItem(rs.getString("security_question"));
            sq.setEnabled(true);
            correctAnswer = rs.getString("security_answer");
            Submit.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Username not found.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while fetching the security question.");
    } finally {
        try {
            if (con != null) {
                con.close(); // Close the connection after use
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
   
public void logEvent(int userId, String username, String description) {
    dbConnector dbc = new dbConnector();
    Connection con = dbc.getConnection();
    PreparedStatement pstmt = null;

    try {
        // Fixed: include `log_description` in your INSERT
        String sql = "INSERT INTO tbl_log (u_id, u_username, login_time, u_type, log_status, log_description) VALUES (?, ?, ?, ?, ?, ?)";
        pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, userId);
        pstmt.setString(2, username);
        pstmt.setTimestamp(3, new Timestamp(new Date().getTime())); // login_time
        pstmt.setString(4, "Success - User Action"); // u_type (general category)
        pstmt.setString(5, "Active"); // log_status
        pstmt.setString(6, description); // log_description (e.g., "User Reset Their Password")

        pstmt.executeUpdate();
        System.out.println("Log event recorded successfully.");
    } catch (SQLException e) {
        System.out.println("Error recording log: " + e.getMessage());
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
        }
    }
}

   


   private void resetPassword() {
    String enteredAnswer = ans.getText();
    String newPassword = new String(Newpass.getPassword());

    // Declare variables here to fix your error
    int userId = -1;
    String uname2 = "";

    if (correctAnswer == null) {
        JOptionPane.showMessageDialog(this, "Please search for your username first.");
        return;
    }

    try {
        if (!passwordHasher.hashPassword(enteredAnswer).equals(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "Incorrect security answer.");
            return;
        }
    } catch (NoSuchAlgorithmException ex) {
        JOptionPane.showMessageDialog(this, "Error verifying answer: " + ex.getMessage());
        return;
    }

    try {
        // Hash the new password before storing it
        String hashedPassword = passwordHasher.hashPassword(newPassword);

        // Instantiate the database connection
        dbConnector db = new dbConnector();
        Connection con = db.getConnection();
        dbConnector connector = new dbConnector(); // For logging query
        session sess = session.getInstance();

        if (con == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
            return;
        }

        try {
            // Update password in the database
            PreparedStatement stmt = con.prepareStatement(
                "UPDATE tbl_user SET u_password = ? WHERE u_username = ?"
            );
            stmt.setString(1, hashedPassword);
            stmt.setString(2, un.getText());

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Password successfully reset!");

                // Try to log the password reset
                try {
                    String query2 = "SELECT * FROM tbl_user WHERE u_username = ?";
                    PreparedStatement pstmt = connector.getConnection().prepareStatement(query2);
                    pstmt.setString(1, un.getText());

                    ResultSet resultSet = pstmt.executeQuery();
                    if (resultSet.next()) {
                        userId = resultSet.getInt("u_id");
                        uname2 = resultSet.getString("u_username");

                        // Log the event
                   logEvent(userId, uname2, "User Reset Their Password");

                    }
                } catch (SQLException ex) {
                    System.out.println("Log Error (SQL): " + ex.getMessage());
                }

                dispose(); // Close the window
            } else {
                JOptionPane.showMessageDialog(this, "Error: Username not found or password update failed.");
            }

        } finally {
            con.close();
        }

    } catch (NoSuchAlgorithmException ex) {
        JOptionPane.showMessageDialog(this, "Error hashing password: " + ex.getMessage());
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "An error occurred while updating the password.");
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        sq = new javax.swing.JComboBox<>();
        ans = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Newpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        Submit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 80, 30));

        un.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 360, 40));

        Search.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search-30.png"))); // NOI18N
        Search.setText("Search");
        Search.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Search.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });
        jPanel1.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 120, 40));

        sq.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What's the name of your first pet?", "What's the lastname of your Mother?", "What's your favorite food?", "What's your favorite Color? What's your birth month?" }));
        sq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqActionPerformed(evt);
            }
        });
        jPanel1.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 360, -1));
        jPanel1.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 360, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("New Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 130, 30));

        Newpass.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jPanel1.add(Newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 360, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Cancel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 110, 50));

        Submit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Submit.setText("Submit");
        Submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitMouseClicked(evt);
            }
        });
        jPanel1.add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 110, 50));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FORGOT PASSWORD");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 840, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 153, 255));
        jLabel4.setText("Login here");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 90, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Remember your passsword? ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitMouseClicked
    
      resetPassword();  
    }//GEN-LAST:event_SubmitMouseClicked

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
  String username = un.getText();  
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your username.");
        return;
    }

    // Create a database connection
    dbConnector db = new dbConnector();  // Instantiate dbConnector
    Connection con = db.getConnection(); // Get connection

    if (con == null) {
        JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
        return;
    }

    try {
        PreparedStatement stmt = con.prepareStatement(
            "SELECT security_question, security_answer FROM tbl_user WHERE u_username = ?"
        );
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            sq.removeAllItems();
            sq.addItem(rs.getString("security_question"));
            sq.setEnabled(true);
          correctAnswer = rs.getString("security_answer"); // still okay if hashed

            Submit.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Username not found.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while fetching the security question.");
    } finally {
        try {
            if (con != null) {
                con.close(); // Close the connection after use
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    // TODO add your handling code here:
    }//GEN-LAST:event_SearchMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
     Rhu m = new Rhu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void sqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      Rhu m = new Rhu();
        m.setVisible(true);
        this.dispose();  // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> new ForgetPassword().setVisible(true));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Newpass;
    private javax.swing.JButton Search;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField ans;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> sq;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
