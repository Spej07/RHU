/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import config.dbConnect;
import config.passwordHasher;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author clair
 */
public class ForgetPass extends javax.swing.JFrame {
    private String correctAnswer;

    /**
     * Creates new form ForgetPass
     */
    public ForgetPass() {
        initComponents();
    }

       public static String Phone, usname;
       
    
    
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
        } finally //This is a database closer
        {
            try 
            {
                if (pstmt != null) 
                {
                    pstmt.close();
                }
                if (con != null) 
                {
                    con.close();
                }
            } catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }
    
    
    
    
    
    
    private void fetchSecurityQuestion() {
        String username = un.getText().trim();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your username.");
            return;
        }

        dbConnect db = new dbConnect();
        try (Connection con = db.getConnection()) {
            String sql = "SELECT security_question, security_answer FROM tbl_user WHERE u_username = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    sq.removeAllItems();
                    sq.addItem(rs.getString("security_question"));
                    correctAnswer = rs.getString("security_answer");
                    sq.setEnabled(true);
                    confirm.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Username not found.");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching security question.");
        }
    }

    private void resetPassword() {
        String enteredAnswer = ans.getText();
        String newPassword = new String(Newpass.getPassword());
      

        if (correctAnswer == null) {
            JOptionPane.showMessageDialog(this, "Please search for your username first.");
            return;
        }

        if (!enteredAnswer.equalsIgnoreCase(correctAnswer)) {
            JOptionPane.showMessageDialog(this, "Incorrect security answer.");
            return;
        }

        if (newPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty.");
            return;
        }

        try {
            // Hash the new password before storing it
            String hashedPassword = passwordHasher.hashPassword(newPassword);

            // Instantiate the database connection
            dbConnect db = new dbConnect();
            Connection con = db.getConnection();

            if (con == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
                return;
            }

            try {
                // Update password in the database
                PreparedStatement stmt = con.prepareStatement(
                        "UPDATE tbl_user SET u_password = ? WHERE u_username = ?"
                );
                stmt.setString(1, hashedPassword);  // Store the hashed password
                stmt.setString(2, un.getText());

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Password successfully reset!");
                    dispose(); // Close the window after successful password reset
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Username not found or password update failed.");
                }
            } finally {
                con.close(); // Close the database connection after use
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        sq = new javax.swing.JComboBox<>();
        ans = new javax.swing.JTextField();
        Newpass = new javax.swing.JPasswordField();
        Cpass = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        confirm = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-search-24.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 86, -1, -1));

        un.setBackground(new java.awt.Color(153, 255, 255));
        un.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        jPanel2.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 260, 50));

        sq.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        sq.setForeground(new java.awt.Color(51, 51, 51));
        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What's your favorite Color?", "What was the name of your first pet?" }));
        jPanel2.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 260, 40));

        ans.setBackground(new java.awt.Color(153, 255, 255));
        ans.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ans.setForeground(new java.awt.Color(102, 102, 102));
        ans.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 260, 40));

        Newpass.setBackground(new java.awt.Color(153, 255, 255));
        Newpass.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Newpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Newpass.setToolTipText("");
        Newpass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ENTER NEW PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(Newpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 260, 50));

        Cpass.setBackground(new java.awt.Color(153, 255, 255));
        Cpass.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Cpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Cpass.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(Cpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 260, 50));

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 80, -1));

        confirm.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        confirm.setForeground(new java.awt.Color(102, 102, 102));
        confirm.setText("CONFIRM");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        jPanel2.add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("FORGOT PASSWORD");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 410));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -30, 450, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      loginf lf = new loginf();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
          String u = un.getText().trim();
        String a = ans.getText().trim();
        String np = new String(Newpass.getPassword()).trim();
        String cp = new String(Cpass.getPassword()).trim();
        dbConnect connector = new dbConnect();
        int userId = 0;


        
        if (u.isEmpty() || a.isEmpty() || np.isEmpty() || cp.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please fill in all fields before submitting.");
            return;
        }else if(!np.equals(cp))
        {
            JOptionPane.showMessageDialog(this, "Password does not match");
        }else
        {
            // Call resetPassword method to validate and update password
            resetPassword();
            
            
            try 
            {
                String query = "SELECT u_id FROM tbl_user WHERE u_username = '" + u + "'";
                PreparedStatement pstmt = connector.getConnection().prepareStatement(query);

                ResultSet resultSet = pstmt.executeQuery();

                if (resultSet.next()) 
                {
                    System.out.println("user was recieved");
                    userId = resultSet.getInt("u_id");   // Update the outer `userId` correctly
                }
            } catch (SQLException ex) 
            {
                System.out.println("SQL Exception: " + ex);
            }
            System.out.println("username: "+u);
            System.out.println("user ID: "+userId);

            logEvent(userId, u, "Forgot, and changed their password");
            
            
         loginf lf = new loginf();
        lf.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_confirmActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
  dbConnect connector = new dbConnect();
        String username = un.getText();  
        String answer = null;
        
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter your username.");
        return;
    }

    dbConnect db = new dbConnect(); 
    Connection con = db.getConnection(); 
        try {
            String query = "SELECT * FROM tbl_user WHERE u_username = '" + username + "'"; //was not searching * or all when finding security_asnwer column
            PreparedStatement pstmt = connector.getConnection().prepareStatement(query);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                answer = resultSet.getString("security_answer");
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
        }

    if (con == null) {
        JOptionPane.showMessageDialog(this, "Database connection failed. Please try again later.");
        return;
    }else if(answer.equals(""))
    {
        JOptionPane.showMessageDialog(this, "You did not set a password recovery for your account.");
      loginf lf = new loginf();
        lf.setVisible(true);
        this.dispose();
    }else
    {

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
                confirm.setEnabled(true);
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
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgetPass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgetPass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Cpass;
    private javax.swing.JPasswordField Newpass;
    private javax.swing.JTextField ans;
    private javax.swing.JButton confirm;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> sq;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
