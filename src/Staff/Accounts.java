/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

import config.Session;
import config.dbConnect;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import login.loginf;

/**
 *
 * @author clair
 */
public class Accounts extends javax.swing.JFrame {

    /**
     * Creates new form Accounts
     */
    public Accounts() {
        initComponents();
    }
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
     public int FileExistenceChecker(String path) {
        File file = new File(path);
        String fileName = file.getName();

        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);

        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    }
     
     
     public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
         
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);

       
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();

           
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);

            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }

        return -1;
    }

    public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void imageUpdater(String existingFilePath, String newFilePath) {
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: " + e);
            }
        } else {
            try {
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Error on update!");
            }
        }
    }
    
    
     public void logEvent(int userId, String username, String action) {
    
      dbConnect dbc = new dbConnect();
    Timestamp time = new Timestamp(new Date().getTime());

    String sql = "INSERT INTO tbl_logs (u_id, u_username, log_action, action_time) VALUES (?, ?, ?, ?)";

    try (
        Connection con = dbc.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)
    ) {
        pstmt.setInt(1, userId);
        pstmt.setString(2, username);
        pstmt.setString(4, action);
         pstmt.setTimestamp(3, time);

        pstmt.executeUpdate();
        System.out.println("Log recorded successfully.");

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error recording log: " + e.getMessage());
    }
}
      
         public static String usname;

    public boolean updateCheck() {
        dbConnect dbc = new dbConnect();
        Session sess = Session.getInstance();
        String  e = em .getText().trim();
        String u = un.getText().trim();

        try {
            System.out.println("1");
            String query = "SELECT * FROM tbl_user WHERE (u_username='" + u+ "'OR u_email ='" + e + "') AND u_id != '" + sess.getID() + "'";
            ResultSet resultSet = dbc.getData(query);
            if (resultSet.next()) {
                e = resultSet.getString("u_email");
                if (em.equals(e)) {
                    JOptionPane.showMessageDialog(null, "Email is Already Used");
                    em.setText("");
                }

                usname = resultSet.getString("u_username");
                if (usname.equals(un)) {
                    JOptionPane.showMessageDialog(null, "Username is Already Used");
                    un.setText("");
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        Select = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lastn = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        firstn = new javax.swing.JLabel();
        button3 = new java.awt.Button();
        em = new javax.swing.JTextField();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(235, 230, 240));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button1.setBackground(new java.awt.Color(235, 230, 240));
        button1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        button1.setForeground(new java.awt.Color(102, 102, 102));
        button1.setLabel("CHANGE PASSWORD");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 160, 30));

        button2.setBackground(new java.awt.Color(235, 230, 240));
        button2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        button2.setForeground(new java.awt.Color(102, 102, 102));
        button2.setLabel("CANCEL");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 80, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 140, 130));

        Select.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Select.setForeground(new java.awt.Color(102, 102, 102));
        Select.setText("SELECT");
        Select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectActionPerformed(evt);
            }
        });
        jPanel1.add(Select, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        Remove.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        Remove.setForeground(new java.awt.Color(102, 102, 102));
        Remove.setText("REMOVE");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        jPanel1.add(Remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lastn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lastn.setForeground(new java.awt.Color(102, 102, 102));
        lastn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lastn.setText("USER");
        jPanel2.add(lastn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, -1));

        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-user-100_1.png"))); // NOI18N
        jPanel2.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 140));

        jButton1.setBackground(new java.awt.Color(230, 189, 230));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("LOGOUT");
        jButton1.setToolTipText("");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 90, 30));

        firstn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        firstn.setForeground(new java.awt.Color(102, 102, 102));
        firstn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstn.setText("USER");
        jPanel2.add(firstn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 410));

        button3.setBackground(new java.awt.Color(235, 230, 240));
        button3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        button3.setForeground(new java.awt.Color(102, 102, 102));
        button3.setLabel("CONFRIM");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel1.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 80, 30));

        em.setBackground(new java.awt.Color(153, 255, 255));
        em.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        em.setForeground(new java.awt.Color(102, 102, 102));
        em.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        em.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "EMAIL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        em.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emKeyReleased(evt);
            }
        });
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 230, 50));

        fn.setBackground(new java.awt.Color(153, 255, 255));
        fn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        fn.setForeground(new java.awt.Color(102, 102, 102));
        fn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fn.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "FIRSTNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 230, 50));

        ln.setBackground(new java.awt.Color(153, 255, 255));
        ln.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        ln.setForeground(new java.awt.Color(102, 102, 102));
        ln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ln.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "LASTNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 230, 50));

        un.setBackground(new java.awt.Color(153, 255, 255));
        un.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        un.setForeground(new java.awt.Color(102, 102, 102));
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "USERNAME", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel1.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 230, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ACCOUNT INFORMATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 330, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
      changePass cp = new changePass();
       cp.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
         NurseDashboard nd = new NurseDashboard();
            nd.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

    private void SelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userimages/" + selectedFile.getName();
                path = selectedFile.getAbsolutePath();

                if (FileExistenceChecker(path) == 1) {
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path = "";
                } else {
                    image.setIcon(ResizeImage(path, null, image));
                    Select.setEnabled(false);
                    Remove.setEnabled(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_SelectActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
    Remove.setEnabled(false);
        Select.setEnabled(true);
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_RemoveActionPerformed

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
            fn.setText(""+sess.getFname());
            ln.setText(""+sess.getLname());
            un.setText(""+sess.getUsername());
           em.setText(""+sess.getEmail());
       ;
        
       }    }//GEN-LAST:event_formWindowActivated

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
    dbConnect dbc = new dbConnect();
    Session sess = Session.getInstance();

    String f = fn.getText().trim();
    String l = ln.getText().trim();
    String u = un.getText().trim();
    String e = em.getText().trim();

   
    String sq = "";
    String sa = "";

    if (u.isEmpty() || l.isEmpty() || f.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please Fill All Boxes");
        return;
    }

    if (updateCheck()) {
        System.out.println("Duplicate Exists");
        return;
    }

    try {
        String query = "SELECT * FROM tbl_user WHERE u_id = ?";
        PreparedStatement ps = dbc.getConnection().prepareStatement(query);
        ps.setInt(1, sess.getID());
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String pass = rs.getString("u_password");
            String ty = rs.getString("u_type");
            String pn = rs.getString("u_phoneNumber");
            String s = rs.getString("u_status");

            String insertQuery = "INSERT INTO tbl_user (u_fname, u_lname, u_username, u_email, u_phoneNumber, u_password, u_type, u_image, u_status, security_question, security_answer) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertPs = dbc.getConnection().prepareStatement(insertQuery);

            insertPs.setString(1, f);
            insertPs.setString(2, l);
            insertPs.setString(3, u);
            insertPs.setString(4, e);
            insertPs.setString(5, pn);
            insertPs.setString(6, pass);
            insertPs.setString(7, ty);
            insertPs.setString(8, destination);
            insertPs.setString(9, s);
            insertPs.setString(10, sq);
            insertPs.setString(11, sa);

            if (insertPs.executeUpdate() > 0) {
                logEvent(sess.getID(), u, "User Changed Their Details");
                new NurseDashboard().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Unknown Error Occurred");
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    
        }    }//GEN-LAST:event_button3ActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void emKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emKeyReleased
         String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pt = Pattern.compile(EMAIL_PATTERN);
        Matcher match = pt.matcher(em.getText());
    }//GEN-LAST:event_emKeyReleased

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
            java.util.logging.Logger.getLogger(Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Remove;
    private javax.swing.JButton Select;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private javax.swing.JTextField em;
    private javax.swing.JLabel firstn;
    private javax.swing.JTextField fn;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lastn;
    private javax.swing.JTextField ln;
    private javax.swing.JTextField un;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
