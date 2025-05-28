/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import config.dbConnect;
import config.passwordHasher;
import static config.passwordHasher.hashPassword;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class registerf1 extends javax.swing.JFrame {

    /**
     * Creates new form registerf1
     */
    public registerf1() {
        initComponents();
    }

     public boolean duplicateCheck()
    {
       dbConnect dbc = new dbConnect();
       try{
           String query = "SELECT * FROM tbl_user  WHERE u_username = '" + un.getText()+ "'OR u_email ='" + gen.getText()+ "'";
            ResultSet resultSet = dbc.getData(query);
            if(resultSet.next()){
               String  email =resultSet.getString("u_email");
                if(gen.equals(gen.getText())){
                    JOptionPane.showMessageDialog(null, "Email is already used!");
                    gen.setText("");
                }
                 String username =resultSet.getString("u_usname");
                if(un.equals(un.getText())){
                    JOptionPane.showMessageDialog(null, "Username is already used!!");
                    un.setText("");
                }
                 return true;
            }else{  
                return false;
            }
       }catch(SQLException ex){
           System.out.println(""+ex);
           return false;
        } }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fname = new javax.swing.JTextField();
        ans = new javax.swing.JTextField();
        sq = new javax.swing.JComboBox<>();
        lname = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        phoneN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pd = new javax.swing.JPasswordField();
        ty = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        em1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        gen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fname.setBackground(new java.awt.Color(153, 255, 255));
        fname.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        fname.setForeground(new java.awt.Color(102, 102, 102));
        fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FIRSTNAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 290, 50));

        ans.setBackground(new java.awt.Color(153, 255, 255));
        ans.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ans.setForeground(new java.awt.Color(102, 102, 102));
        ans.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 180, 30));

        sq.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        sq.setForeground(new java.awt.Color(102, 102, 102));
        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What's your favorite Color?", "What was the name of your first pet?" }));
        jPanel2.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 180, 30));

        lname.setBackground(new java.awt.Color(153, 255, 255));
        lname.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lname.setForeground(new java.awt.Color(102, 102, 102));
        lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lname.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "LASTNAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 290, -1));

        un.setBackground(new java.awt.Color(153, 255, 255));
        un.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        un.setForeground(new java.awt.Color(102, 102, 102));
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        jPanel2.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 290, 50));

        phoneN.setBackground(new java.awt.Color(153, 255, 255));
        phoneN.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        phoneN.setForeground(new java.awt.Color(102, 102, 102));
        phoneN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneN.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PHONENUMBER", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(phoneN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 290, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-hide-password-24.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, 30));

        pd.setBackground(new java.awt.Color(153, 255, 255));
        pd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        pd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pd.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PASSWORD", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(pd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 290, -1));

        ty.setBackground(new java.awt.Color(230, 189, 230));
        ty.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ty.setForeground(new java.awt.Color(102, 102, 102));
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Staff", "Doctor" }));
        ty.setBorder(null);
        jPanel2.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 90, 30));

        jButton1.setBackground(new java.awt.Color(230, 189, 230));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("CANCEL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 100, -1));

        jButton2.setBackground(new java.awt.Color(230, 189, 230));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("REGISTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("TYPE:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        em1.setBackground(new java.awt.Color(153, 255, 255));
        em1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        em1.setForeground(new java.awt.Color(102, 102, 102));
        em1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        em1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "EMAIL", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(em1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 290, 50));

        jLabel1.setText("GENDER:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        gen.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.add(gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 290, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("REGISTRATION APPLICATION");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed

    }//GEN-LAST:event_lnameActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loginf lf = new loginf();
        lf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

  if (fname.getText().isEmpty() 
    || lname.getText().isEmpty() 
    || un.getText().isEmpty()
    || gen.getText().isEmpty() 
    || phoneN.getText().isEmpty()
    || pd.getText().isEmpty()
    || sq.getSelectedItem() == null       
    || ans.getText().isEmpty()) {    

    JOptionPane.showMessageDialog(null, "All fields are required");
    return;

} else if (duplicateCheck()) {
    System.out.println("Duplicate Exist");
    return;

} else {
    dbConnect dbc = new dbConnect();
    try {
        String pass = passwordHasher.hashPassword(pd.getText());

        String sql = "INSERT INTO tbl_user (u_fname, u_lname, u_username, u_email, u_phoneNumber,gender, u_password, u_type, u_image, security_question, security_answer, u_status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, '', ?, ?,?, 'Pending')";

        PreparedStatement pst = dbc.getConnection().prepareStatement(sql);
        pst.setString(1, fname.getText());
        pst.setString(2, lname.getText());
        pst.setString(3, un.getText());
        pst.setString(4, em1.getText());
         pst.setString(5, gen.getText());
        pst.setString(6, phoneN.getText());
        pst.setString(7, pass);
        pst.setString(8, ty.getSelectedItem().toString());
        pst.setString(9, sq.getSelectedItem().toString());
        pst.setString(10, ans.getText());

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Registered Successfully!");
            loginf lf = new loginf();
            lf.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Registration failed!");
        }

    } catch (NoSuchAlgorithmException | SQLException ex) {
        Logger.getLogger(registerf1.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if (pd.getEchoChar() == '\u2022') { 
        pd.setEchoChar((char) 0); 
    } else {
        pd.setEchoChar('\u2022'); 
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
            java.util.logging.Logger.getLogger(registerf1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registerf1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registerf1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registerf1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registerf1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ans;
    private javax.swing.JTextField em1;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField gen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lname;
    private javax.swing.JPasswordField pd;
    private javax.swing.JTextField phoneN;
    private javax.swing.JComboBox<String> sq;
    private javax.swing.JComboBox<String> ty;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
