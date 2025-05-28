/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnect;
import config.passwordHasher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author clair
 */
public class createUserf extends javax.swing.JFrame {

    /**
     * Creates new form createUserf
     */
    public createUserf() {
        initComponents();
    }

     public boolean duplicateCheck(){
     dbConnect dbc = new dbConnect();
       try{
           String query = "SELECT * FROM tbl_user  WHERE u_username = '" + usn.getText()+ "'OR u_email ='" + em.getText()+ "'";
            ResultSet resultSet = dbc.getData(query);
            if(resultSet.next()){
              String email =resultSet.getString("u_email");
                if(email.equals(em.getText())){
                    JOptionPane.showMessageDialog(null, "Email is already used!");
                    em.setText("");
                }
               String username =resultSet.getString("u_username");
                if(username.equals(usn.getText())){
                    JOptionPane.showMessageDialog(null, "Username is already used!!");
                    usn.setText("");
                }
                 return true;
            }else{  
                return false;
            }
       }catch(SQLException ex){
           System.out.println(""+ex);
           return false;
           
   }
}
     
     public boolean updateCheck() {
   dbConnect dbc = new dbConnect();
       try{
           String query = "SELECT * FROM tbl_user  WHERE (u_username = '" + usn.getText()+ "'OR u_email ='" + em.getText()+ "')AND u_id !='"+ID.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            if(resultSet.next()){
                String email =resultSet.getString("u_email");
                if(email.equals(em.getText())){
                    JOptionPane.showMessageDialog(null, "Email is already used!");
                    em.setText("");
                }
                String username =resultSet.getString("u_username");
                if(username.equals(usn.getText())){
                    JOptionPane.showMessageDialog(null, "Username is already used!!");
                    usn.setText("");
                }
                 return true;
            }else{  
                return false;
            }
       }catch(SQLException ex){
           System.out.println(""+ex);
           return false;
           
   }
    }
 
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        usn = new javax.swing.JTextField();
        em = new javax.swing.JTextField();
        pnr = new javax.swing.JTextField();
        us = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ty = new javax.swing.JComboBox<>();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        add = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        ID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fn.setBackground(new java.awt.Color(153, 255, 255));
        fn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        fn.setForeground(new java.awt.Color(102, 102, 102));
        fn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FIRSTNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 290, 60));

        ln.setBackground(new java.awt.Color(153, 255, 255));
        ln.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ln.setForeground(new java.awt.Color(102, 102, 102));
        ln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ln.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "LASTNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 290, 60));

        pwd.setBackground(new java.awt.Color(153, 255, 255));
        pwd.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        pwd.setForeground(new java.awt.Color(102, 102, 102));
        pwd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pwd.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PASSWORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 290, 50));

        usn.setBackground(new java.awt.Color(153, 255, 255));
        usn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        usn.setForeground(new java.awt.Color(102, 102, 102));
        usn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        usn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usnActionPerformed(evt);
            }
        });
        jPanel2.add(usn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 290, 50));

        em.setBackground(new java.awt.Color(153, 255, 255));
        em.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        em.setForeground(new java.awt.Color(102, 102, 102));
        em.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        em.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "EMAIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 290, 50));

        pnr.setBackground(new java.awt.Color(153, 255, 255));
        pnr.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        pnr.setForeground(new java.awt.Color(102, 102, 102));
        pnr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnr.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "PHONENUMBER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.add(pnr, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 290, 50));

        us.setBackground(new java.awt.Color(230, 189, 230));
        us.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        us.setForeground(new java.awt.Color(102, 102, 102));
        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending", " " }));
        us.setBorder(null);
        jPanel2.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 120, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("USER STATUS:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("TYPE:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        ty.setBackground(new java.awt.Color(230, 189, 230));
        ty.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ty.setForeground(new java.awt.Color(102, 102, 102));
        ty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STAFF", "DOCTOR" }));
        ty.setBorder(null);
        jPanel2.add(ty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 120, 30));

        delete.setBackground(new java.awt.Color(230, 189, 230));
        delete.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(102, 102, 102));
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel2.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 100, 30));

        update.setBackground(new java.awt.Color(230, 189, 230));
        update.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(102, 102, 102));
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 100, 30));

        add.setBackground(new java.awt.Color(230, 189, 230));
        add.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(102, 102, 102));
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 100, 30));

        cancel.setBackground(new java.awt.Color(230, 189, 230));
        cancel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cancel.setForeground(new java.awt.Color(102, 102, 102));
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 100, 30));

        ID.setBackground(new java.awt.Color(153, 255, 255));
        ID.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ID.setForeground(new java.awt.Color(102, 102, 102));
        ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USER ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        ID.setEnabled(false);
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });
        jPanel2.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 300, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 410));

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

    private void usnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usnActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        adminUserf au = new  adminUserf();
        au.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
     if (fn.getText().isEmpty()   || ln.getText().isEmpty()   || em.getText().isEmpty() 
                || pnr.getText().isEmpty()|| usn.getText().isEmpty() || pwd.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "All field are required");
            }else if(pwd.getText().length()< 8){
            JOptionPane.showMessageDialog(null, "Password should have at least 8 characters");
        pwd.setText("");
        }else if(duplicateCheck()){
           System.out.println("Duplicate Exist");
     
         }else{
            
        
        dbConnect dbc = new dbConnect();
         if (dbc.insertData("INSERT INTO tbl_user(u_fname, u_lname, u_email, u_phoneNumber, u_type, u_username, u_password, u_status) "
                + "VALUES ('" + fn.getText() + "','" + ln.getText() + "','" + em.getText() + "',"
                + "'" + pnr.getText() + "','" + ty.getSelectedItem() + "','" + usn.getText() + "','" + pwd.getText()+"','"+us.getSelectedItem()+"')"))
                    {
            JOptionPane.showMessageDialog(null, "Registration Successful!");
          adminUserf au = new  adminUserf();
           au.setVisible(true);
           this.dispose();
       } else {
          JOptionPane.showMessageDialog(null, "Connection Error");

         }
        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
     if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty()|| pnr.getText().isEmpty()
                || usn.getText().isEmpty()|| pwd.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "All field are required");
            return;
       }
       String contactPattern = "^[0-9]{11}$"; 
    if (!pnr.getText().matches(contactPattern)) {
        JOptionPane.showMessageDialog(null, "Invalid contact number. It must be exactly 11 digits and contain numbers only.");
        pnr.setText(""); 
        return;
    }
       
       String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    if (!em.getText().matches(emailPattern)) {
        JOptionPane.showMessageDialog(null, "Invalid email format. Please enter a valid email.");
        em.setText(""); 
        return;
            }else if(pwd.getText().length()< 8){
        JOptionPane.showMessageDialog(null, "Password should have at least 8 characters");
        pwd.setText("");
        }else if(updateCheck()){
           System.out.println("Duplicate Exist");
     
         }else{
          dbConnect dbc = new dbConnect();
   dbc.updateData("UPDATE tbl_user SET,u_lname='"+ln.getText()+"',u_username ='"+"'"+usn.getText()
          + "u_fname ='"+fn.getText()+"'WHERE u_id ='"+ID.getText()+"'");
          JOptionPane.showMessageDialog(null,"Updated Successfully!");
           adminUserf au = new  adminUserf();
           au.setVisible(true);
           this.dispose();     }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

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
            java.util.logging.Logger.getLogger(createUserf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ID;
    public javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton delete;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField pnr;
    public javax.swing.JTextField pwd;
    public javax.swing.JComboBox<String> ty;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JTextField usn;
    // End of variables declaration//GEN-END:variables
}
