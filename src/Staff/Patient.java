/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;


import config.Session;
import config.dbConnect;
import java.sql.PreparedStatement;
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
public class Patient extends javax.swing.JFrame {

    /**
     * Creates new form Patient
     */
    public Patient() {
        initComponents();
           displayData();
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        log = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        firstn = new javax.swing.JLabel();
        lastn = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patienttbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        cn = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addAppointment = new javax.swing.JButton();
        ADR = new javax.swing.JTextField();
        admin = new javax.swing.JLabel();
        gen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(235, 230, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
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

        firstn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        firstn.setForeground(new java.awt.Color(102, 102, 102));
        firstn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstn.setText("USER");
        jPanel2.add(firstn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, -1));

        lastn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lastn.setForeground(new java.awt.Color(102, 102, 102));
        lastn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastn.setText("USER");
        jPanel2.add(lastn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 410));

        patienttbl.setBackground(new java.awt.Color(204, 204, 204));
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 600, 140));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-20.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, 30));

        add.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(102, 102, 102));
        add.setText("   ADD PATIENT");
        add.setToolTipText("");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 140, 30));

        cn.setBackground(new java.awt.Color(204, 255, 204));
        cn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cn.setForeground(new java.awt.Color(102, 102, 102));
        cn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "CONTACT NUMBER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 220, 40));

        fn.setBackground(new java.awt.Color(204, 255, 204));
        fn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        fn.setForeground(new java.awt.Color(102, 102, 102));
        fn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FIRSTNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 220, 40));

        ln.setBackground(new java.awt.Color(204, 255, 204));
        ln.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ln.setForeground(new java.awt.Color(102, 102, 102));
        ln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ln.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "LASTNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 220, 40));

        age.setBackground(new java.awt.Color(204, 255, 204));
        age.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        age.setForeground(new java.awt.Color(102, 102, 102));
        age.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        age.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "AGE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 220, 40));

        dob.setBackground(new java.awt.Color(204, 255, 204));
        dob.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dob.setForeground(new java.awt.Color(102, 102, 102));
        dob.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dob.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DATE OF BIRTH", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 220, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-20.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, 30));

        addAppointment.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        addAppointment.setForeground(new java.awt.Color(102, 102, 102));
        addAppointment.setText("     ADD APPOINTMENT");
        addAppointment.setToolTipText("");
        addAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAppointmentActionPerformed(evt);
            }
        });
        jPanel1.add(addAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 190, 30));

        ADR.setBackground(new java.awt.Color(204, 255, 204));
        ADR.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ADR.setForeground(new java.awt.Color(102, 102, 102));
        ADR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ADR.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ADDRESS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(ADR, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 220, 40));

        admin.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        admin.setForeground(new java.awt.Color(102, 102, 102));
        admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "PATIENT DASHBOARD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 470, 30));

        gen.setBackground(new java.awt.Color(204, 255, 204));
        gen.setText("GENDER:");
        jPanel1.add(gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 280, 30));

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

    private void logMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseClicked
     
    }//GEN-LAST:event_logMouseClicked

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
   NurseDashboard nd = new NurseDashboard();
            nd.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_logActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
 if (fn.getText().isEmpty() || ln.getText().isEmpty() || age.getText().isEmpty() || gen.getText().isEmpty() ||
    dob.getText().isEmpty() || ADR.getText().isEmpty() || cn.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null, "All fields are required");

} else {

    dbConnect dbc = new dbConnect();

    // No need to include ID in insert since it's auto-increment
    String sql = "INSERT INTO tbl_patient(p_firstname, p_lastname, p_age,p_gender ,p_dob, p_address, p_contactNumber) " +
                 "VALUES ('" + fn.getText() + "','" + ln.getText() +"','" + gen.getText() +  "','" + age.getText() + "','" +
                 dob.getText() + "','" + ADR.getText() + "','" + cn.getText() + "')";

    if (dbc.insertData(sql)) {
        JOptionPane.showMessageDialog(null, "Patient added successfully!");
        Patient p = new Patient();
        p.setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Connection Error");
    }
}


    }//GEN-LAST:event_addActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void addAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAppointmentActionPerformed
   int selectedRow = patienttbl.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a patient first.");
        return;
    }

    int patientId = Integer.parseInt(patienttbl.getValueAt(selectedRow, 0).toString());

   
    AppointmentF af = new AppointmentF(patientId); 
    af.setVisible(true);
    af.PID.setEnabled(false);
    this.dispose();

    }//GEN-LAST:event_addAppointmentActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
   Session sess = Session.getInstance();
       if(sess. getID() == 0)
      {
           JOptionPane.showMessageDialog(null,"No Account, Login FIrst");
           loginf lf = new loginf();
        lf.setVisible(true);
        this.dispose();
       }else
       {
           firstn.setText("" + sess.getFname());
           lastn.setText("" + sess.getLname());
        
       }    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ADR;
    public javax.swing.JButton add;
    public javax.swing.JButton addAppointment;
    private javax.swing.JLabel admin;
    private javax.swing.JTextField age;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField dob;
    private javax.swing.JLabel firstn;
    private javax.swing.JTextField fn;
    private javax.swing.JTextField gen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lastn;
    private javax.swing.JTextField ln;
    private javax.swing.JButton log;
    private javax.swing.JTable patienttbl;
    // End of variables declaration//GEN-END:variables
}
