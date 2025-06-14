/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import Staff.AppointmentF;
import config.Session;
import config.dbConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import login.loginf;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author clair
 */
public class Appointment extends javax.swing.JFrame {

    /**
     * Creates new form Appointment
     */
    public Appointment() {
        initComponents();
        displayData1();
          displayData();
    }
    
    
      
   
    
     public void displayData() {
    dbConnect dbc = new dbConnect();
    try {
        String query = "SELECT a_id, p_id,appointment_date, appointment_time, "
                     + "appointment_type, status FROM tbl_appointment";

        ResultSet rs = dbc.getData(query);
        Appointmenttable.setModel(DbUtils.resultSetToTableModel(rs));
        
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
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
        apptbl = new javax.swing.JScrollPane();
        Appointmenttable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        DELETE = new javax.swing.JButton();
        EDIT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patienttbl = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        admin = new javax.swing.JLabel();
        log = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        acc_name = new javax.swing.JLabel();
        acc_lname = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(235, 230, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Appointmenttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        apptbl.setViewportView(Appointmenttable);

        jPanel1.add(apptbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 450, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-20.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, 30));

        add.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(102, 102, 102));
        add.setText("      ADD APPOINTMENT");
        add.setToolTipText("");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 200, 30));

        DELETE.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        DELETE.setForeground(new java.awt.Color(102, 102, 102));
        DELETE.setText("DELETE");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });
        jPanel1.add(DELETE, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 100, 30));

        EDIT.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        EDIT.setForeground(new java.awt.Color(102, 102, 102));
        EDIT.setText("EDIT");
        EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITActionPerformed(evt);
            }
        });
        jPanel1.add(EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 100, 30));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 450, 110));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("APPOINTMENT LIST TABLE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 490, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PATIENT LIST TABLE");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 490, 30));

        admin.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        admin.setForeground(new java.awt.Color(102, 102, 102));
        admin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admin.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "APPOINTMENT DASHBOARD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 490, 30));

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
        jPanel1.add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 90, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-100_1.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 180, 130));

        acc_name.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acc_name.setForeground(new java.awt.Color(102, 102, 102));
        acc_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name.setText("ADMIN");
        jPanel1.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 180, -1));

        acc_lname.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        acc_lname.setForeground(new java.awt.Color(102, 102, 102));
        acc_lname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_lname.setText("ADMIN");
        jPanel1.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 180, -1));

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

    private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed
        int rowIndex = Appointmenttable.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select an appointment to edit!");
        } else {
            try {
                dbConnect dbc = new dbConnect();
                TableModel tbl = Appointmenttable.getModel();

                String query = "SELECT * FROM tbl_appointment WHERE a_id = '" + tbl.getValueAt(rowIndex, 0) + "'";
                ResultSet rs = dbc.getData(query);
                if (rs.next()) {
                    AddF af = new AddF();

                    af.AID.setText(""+rs.getInt("a_id"));
                    af.PID.setText(""+rs.getInt("p_id"));
                    af.d.setText(""+rs.getString("appointment_date"));
                    af.t.setText(""+rs.getString("appointment_time"));
                    af.tp.setText(""+rs.getString("appointment_type"));
                    af.st.setSelectedItem(""+rs.getString("status"));
                    af.add.setEnabled(false);
                    af.update.setEnabled(true);
                    af.AID.setEnabled(false);
                    af.PID.setEnabled(false);
                    af.setVisible(true);
                    this.dispose();
                }
            } catch (SQLException ex) {
                System.out.println("SQL Exception: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_EDITActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
      int selectedRow = patienttbl.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a patient first.");
        return;
    }

    int patientId = Integer.parseInt(patienttbl.getValueAt(selectedRow, 0).toString());

    AddF af = new AddF();
    af.update.setEnabled(false);     
    af.AID.setEnabled(false);         
    af.PID.setEnabled(false);          
    af.PID.setText(String.valueOf(patientId)); 

    af.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        ManagerDashboard md  = new ManagerDashboard();
        md.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logActionPerformed

    private void logMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logMouseClicked

    }//GEN-LAST:event_logMouseClicked

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
int selectedRow = Appointmenttable.getSelectedRow(); 

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select an appointment to delete.");
        return;
    }

  
    String appointmentId = Appointmenttable.getValueAt(selectedRow, 0).toString();

    int confirm = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to delete appointment ID: " + appointmentId + "?", 
                    "Confirm Delete", 
                    JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            dbConnect dbc = new dbConnect();
            String sql = "DELETE FROM tbl_appointment WHERE a_id = ?";
            java.sql.PreparedStatement pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1, appointmentId);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Appointment deleted successfully.");
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
    }    }//GEN-LAST:event_DELETEActionPerformed

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
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Appointmenttable;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton EDIT;
    private javax.swing.JLabel acc_lname;
    private javax.swing.JLabel acc_name;
    public javax.swing.JButton add;
    private javax.swing.JLabel admin;
    private javax.swing.JScrollPane apptbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton log;
    private javax.swing.JTable patienttbl;
    // End of variables declaration//GEN-END:variables

    }

