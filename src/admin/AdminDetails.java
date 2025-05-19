
package admin;

import config.session;
import config.dbConnector;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import dhp.Signup;

public class AdminDetails extends javax.swing.JFrame {

    public AdminDetails() {
        initComponents();
    }
  public boolean updateCheck(){
        
     dbConnector dbc = new dbConnector();
    session sess = session.getInstance();

    try {
        String query = "SELECT * FROM tbl_user WHERE (u_username = '" + acc_email.getText() 
                     + "' OR u_email = '" + acc_uname.getText() 
                     + "') AND u_id != '" + sess.getUid() + "'";

        ResultSet resultSet = dbc.getData(query);

        if (resultSet.next()) {
            String email = resultSet.getString("u_email"); 
            if (email.equals(acc_uname.getText())) { 
                JOptionPane.showMessageDialog(null, "Email is Already Used!");
                acc_uname.setText(""); 
            }

            String username = resultSet.getString("u_username");
            if (username.equals(acc_email.getText())) { 
                JOptionPane.showMessageDialog(null, "Username is Already Used!");
                acc_email.setText(""); 
            }

            return true;
        } else {
            return false;
        }
    } catch (SQLException ex) {
        System.out.println("" + ex);
        return false;
    }
        
    }
       
     private void uploadImage() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        
        // Define destination path inside src/images/
        File destinationFolder = new File("src/images/");
        if (!destinationFolder.exists()) {
            destinationFolder.mkdirs(); // Create folder if it does not exist
        }

        File destinationFile = new File(destinationFolder, selectedFile.getName());

        try {
            // Copy file to the destination folder
            Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            
            // Store the image path
            selectedImagePath = "src/images/" + selectedFile.getName();

            // Update the image label
            image.setIcon(new javax.swing.ImageIcon(destinationFile.getAbsolutePath()));

            JOptionPane.showMessageDialog(this, "Image uploaded successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error uploading image: " + e.getMessage());
        }
    }
}
   
     private String selectedImagePath = "";
      



    
        public void logEvent(int userId, String username, String userType, String logDescription) {
    dbConnector dbc = new dbConnector();
    Connection con = dbc.getConnection();
    PreparedStatement pstmt = null;

    try {
        String sql = "INSERT INTO tbl_log (u_id, u_username, login_time, u_type, log_status, log_description) VALUES (?, ?, ?, ?, ?, ?)";
        pstmt = con.prepareStatement(sql);

        pstmt.setInt(1, userId);
        pstmt.setString(2, username);
        pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
        pstmt.setString(4, userType); 
        pstmt.setString(5, "Active");
        pstmt.setString(6, logDescription); 

        pstmt.executeUpdate();
        System.out.println("Log recorded successfully.");
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        acc_email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        acc_fname = new javax.swing.JTextField();
        acc_lname = new javax.swing.JTextField();
        acc_uname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        acc_id = new javax.swing.JLabel();
        acc_type = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("First Name :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 130, 30));

        acc_email.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        acc_email.setEnabled(false);
        acc_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_emailActionPerformed(evt);
            }
        });
        jPanel2.add(acc_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 250, 30));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Email :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 130, 30));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 130, 30));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Username :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 130, 30));

        acc_fname.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        acc_fname.setEnabled(false);
        acc_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_fnameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 250, 30));

        acc_lname.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        acc_lname.setEnabled(false);
        acc_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_lnameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 250, 30));

        acc_uname.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        acc_uname.setEnabled(false);
        acc_uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_unameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 250, 30));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ADMIN ACCOUNT");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, 34));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageMouseClicked(evt);
            }
        });
        jPanel9.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 180));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 220, 200));

        acc_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_id.setText("ID");
        jPanel3.add(acc_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 110, 20));

        acc_type.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        acc_type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_type.setText("Type");
        jPanel3.add(acc_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 110, 20));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        update.setText("Save ");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 130, 40));

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(27, 57, 77));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel3.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 130, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 300, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acc_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_emailActionPerformed

    private void acc_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_fnameActionPerformed

    private void acc_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_lnameActionPerformed

    private void acc_unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_unameActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       session sess = session.getInstance();
        if (sess.getUid() == 0) {

           Signup fm = new Signup();
                   fm.setVisible(true);
                   this.dispose();
            JOptionPane.showMessageDialog(null, "No Account, Login FIrst");
        } else {
            
            
            acc_fname.setText("" + sess.getFname());
            acc_lname.setText("" + sess.getLname());
            acc_email.setText("" + sess.getEmail());
            acc_uname.setText("" + sess.getUsername());
            acc_type.setText("" + sess.getType());
            acc_id.setText("" + sess.getUid());  
        }// TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        AdminDashboard ads = new AdminDashboard();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_imageMouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Define destination path inside src/images/
            File destinationFolder = new File("src/images/");
            if (!destinationFolder.exists()) {
                destinationFolder.mkdirs(); // Create folder if it does not exist
            }

            File destinationFile = new File(destinationFolder, selectedFile.getName());

            try {
                // Copy file to the destination folder
                Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Store the image path
                selectedImagePath = "src/images/" + selectedFile.getName();

                // Update the image label
                image.setIcon(new javax.swing.ImageIcon(destinationFile.getAbsolutePath()));

                JOptionPane.showMessageDialog(this, "Image uploaded successfully!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error uploading image: " + e.getMessage());
            }
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked

    }//GEN-LAST:event_updateMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        dbConnector dbc = new dbConnector();
        session sess = session.getInstance();
        dbConnector connector = new dbConnector();
        int userId = 0;
        String uname2 = null;

        // Check if username or email already exists
        if (updateCheck()) {
            return;
        }

        // Validate inputs
        if (acc_fname.getText().isEmpty() || acc_lname.getText().isEmpty() ||
            acc_email.getText().isEmpty() || acc_uname.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // SQL Query to update the user profile
        String query = "UPDATE tbl_user SET u_fname=?, u_lname=?, u_email=?, u_username=?, u_image=? WHERE u_id=?";

        try (Connection conn = dbc.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, acc_fname.getText());
            pstmt.setString(2, acc_lname.getText());
            pstmt.setString(3, acc_email.getText());
            pstmt.setString(4, acc_uname.getText());
            pstmt.setString(5, selectedImagePath);  // Store uploaded image path
            pstmt.setInt(6, sess.getUid());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Profile updated successfully!");

                try {
                    String query2 = "SELECT * FROM tbl_user WHERE u_id = ?"; //use prepared statement.
                    PreparedStatement pstmt2 = connector.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, sess.getUid());

                    ResultSet resultSet = pstmt2.executeQuery();

                    if (resultSet.next()) {
                        userId = resultSet.getInt("u_id");  // Update the outer `userId` correctly
                        uname2 = resultSet.getString("u_username");
                    }
                } catch (SQLException ex) {
                    System.out.println("SQL Exception: " + ex);
                }

                logEvent(userId, uname2, sess.getType(), "User Changed Their Details"); //fixed
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update profile!", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField acc_email;
    public javax.swing.JTextField acc_fname;
    private javax.swing.JLabel acc_id;
    public javax.swing.JTextField acc_lname;
    private javax.swing.JLabel acc_type;
    public javax.swing.JTextField acc_uname;
    public javax.swing.JButton cancel;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
