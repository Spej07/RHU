/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

import config.dbConnect;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author clair
 */
public class AppointmentF extends javax.swing.JFrame {
  
       private int patientId;


    public AppointmentF(int patientId) {
        initComponents();
        this.patientId = patientId;

        PID.setText(String.valueOf(patientId));
         loadAppointments(); 

       
    }

   
    public AppointmentF() {
        initComponents();
    }
    
    
    
    private void loadAppointments() {
    try {
        dbConnect dbc = new dbConnect();
        String sql = "SELECT a_id, p_id, appointment_date, appointment_time, appointment_type, status FROM tbl_appointment"; // tanan appointments

        ResultSet rs = dbc.selectData(sql);
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new String[] { "Appointment ID", "Patient ID", "Date", "Time", "Type", "Status" }, 0);

        while (rs.next()) {
            Object[] row = new Object[6];
            row[0] = rs.getInt("a_id");
            row[1] = rs.getInt("p_id");
            row[2] = rs.getString("appointment_date");
            row[3] = rs.getString("appointment_time");
            row[4] = rs.getString("appointment_type");
            row[5] = rs.getString("status");
            model.addRow(row);
        }

        appointmenttbl.setModel(model);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to load appointments");
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
        appointmenttbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        PID = new javax.swing.JTextField();
        t = new javax.swing.JTextField();
        tp = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        acc_name.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acc_name.setForeground(new java.awt.Color(102, 102, 102));
        acc_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name.setText("USER");
        jPanel2.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 180, -1));

        acc_lname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acc_lname.setForeground(new java.awt.Color(102, 102, 102));
        acc_lname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_lname.setText("USER");
        jPanel2.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 410));

        appointmenttbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(appointmenttbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 450, 150));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-20.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, 30));

        add.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(102, 102, 102));
        add.setText("   ADD");
        add.setToolTipText("");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 80, 30));

        PID.setBackground(new java.awt.Color(235, 230, 240));
        PID.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        PID.setForeground(new java.awt.Color(102, 102, 102));
        PID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PID.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(PID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 220, 40));

        t.setBackground(new java.awt.Color(235, 230, 240));
        t.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        t.setForeground(new java.awt.Color(102, 102, 102));
        t.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "TIME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tActionPerformed(evt);
            }
        });
        jPanel1.add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 220, 40));

        tp.setBackground(new java.awt.Color(235, 230, 240));
        tp.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        tp.setForeground(new java.awt.Color(102, 102, 102));
        tp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tp.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "TYPE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(tp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 220, 40));

        d.setBackground(new java.awt.Color(235, 230, 240));
        d.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        d.setForeground(new java.awt.Color(102, 102, 102));
        d.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        d.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DATE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 220, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("APPOINTMENT DASHBOARD");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 420, 20));

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
   DisplayA da = new  DisplayA();
        da.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
    String patientId = PID.getText();
    String date = d.getText();
    String time = t.getText();
    String type = tp.getText();
    String status = "Pending";

    if (patientId.isEmpty() || date.isEmpty() || time.isEmpty() || type.isEmpty()) {
        JOptionPane.showMessageDialog(null, "All fields are required.");
        return;
    }

    try {
        // Convert time to valid MySQL TIME format
        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mma");
        SimpleDateFormat mysqlFormat = new SimpleDateFormat("HH:mm:ss");
        Date parsedTime = inputFormat.parse(time);
        String formattedTime = mysqlFormat.format(parsedTime);

        dbConnect dbc = new dbConnect();
        String sql = "INSERT INTO tbl_appointment (p_id, appointment_date, appointment_time, appointment_type, status) " +
                     "VALUES ('" + patientId + "', '" + date + "', '" + formattedTime + "', '" + type + "', '" + status + "')";
        
        if (dbc.insertData(sql)) {
            JOptionPane.showMessageDialog(null, "Appointment added!");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add appointment.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Invalid time format. Use something like 08:00AM.");
    }
    }//GEN-LAST:event_addActionPerformed
    private void tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_tActionPerformed

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
            java.util.logging.Logger.getLogger(AppointmentF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField PID;
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_name;
    public javax.swing.JButton add;
    private javax.swing.JTable appointmenttbl;
    private javax.swing.JTextField d;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton log;
    private javax.swing.JTextField t;
    private javax.swing.JTextField tp;
    // End of variables declaration//GEN-END:variables
}
