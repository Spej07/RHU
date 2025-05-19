/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;



import config.session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



/**
 *
 * @author User
 */
public class CreateUser extends javax.swing.JFrame {

    /**
     * Creates new form registF
     */
    public CreateUser() {
        initComponents();
    }
    
 
       private String userId; // Declare userId at the class level

    public void setUserId(String id) {
        this.userId = id; // Store the user ID for later use
    }
    
   
     
        public static String email,username;
              
    public String destination = ""; 
    File selectedFile;
    public String oldpath;
    public String path;
        

   public boolean duplicateCheck(String username, String email) { 
    dbConnector dbc = new dbConnector();
    
    try {
        String query = "SELECT * FROM tbl_user WHERE u_username = '" + username + "' OR u_email = '" + email + "'";
        ResultSet resultSet = dbc.getData(query);
        
        if (resultSet.next()) {
            String existingEmail = resultSet.getString("u_email");
            if (existingEmail.equals(email)) {
                JOptionPane.showMessageDialog(null, "Email is already used!");
                return true;
            }

            String existingUsername = resultSet.getString("u_username");
            if (existingUsername.equals(username)) {
                JOptionPane.showMessageDialog(null, "Username is already used!");
                return true;
            }
        }
    } catch (SQLException ex) {
        System.out.println("" + ex);
    }
    
    return false; // No duplicate found
}

    public boolean UpdateCheck(){
        
    dbConnector dbc = new dbConnector();
        
     try{
            String query = "SELECT * FROM tbl_user  WHERE (u_username = '" +us.getText()+ "' OR u_email = '" +mail.getText()+ "') AND u_id != '"+uid.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
           
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                if(email.equals(mail.getText())){
                JOptionPane.showMessageDialog(null, "Email is already used!");
                mail.setText("");
                }
                username = resultSet.getString("u_username");
                if(username.equals(us.getText())){
                JOptionPane.showMessageDialog(null, "Username is already used!");
                us.setText("");
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
     public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }    
    
       public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
            if(ImagePath !=null){
                MyImage = new ImageIcon(ImagePath);
            }else{
                MyImage = new ImageIcon(pic);
            }

        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
     public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/usersimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
        public void imageUpdater(String existingFilePath, String newFilePath){
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
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
     public void logEvent(int userId, String username, String action) 
    {
        dbConnector dbc = new dbConnector();
        Connection con = dbc.getConnection();
        PreparedStatement pstmt = null;
        Timestamp time = new Timestamp(new Date().getTime());

        try {
            String sql = "INSERT INTO tbl_log (u_id, u_username, login_time, log_status, log_description) "
                    + "VALUES ('" + userId + "', '" + username + "', '" + time + "', '" + action + "')";
            pstmt = con.prepareStatement(sql);

            /*            pstmt.setInt(1, userId);
            pstmt.setString(2, username);
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setString(4, userType);*/
            pstmt.executeUpdate();
            System.out.println("Login log recorded successfully.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error recording log: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
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

        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        check = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        u_image = new javax.swing.JLabel();
        sq = new javax.swing.JComboBox<>();
        ans = new javax.swing.JTextField();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ln = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        us = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pw = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        ut = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        stat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cl = new javax.swing.JButton();
        cc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        check.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        check.setText("show");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        jPanel10.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 270, -1, 30));

        u_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(u_image, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(u_image, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 250, 210));

        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What's the name of your first pet?", "What's the lastname of your Mother?", "What's your favorite food?", "What's your favorite Color?", "What's your birth month?" }));
        jPanel10.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        ans.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jPanel10.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 240, 30));

        select.setBackground(new java.awt.Color(255, 255, 255));
        select.setText("SELECT");
        select.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel10.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 80, 30));

        remove.setBackground(new java.awt.Color(255, 255, 255));
        remove.setText("REMOVE");
        remove.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel10.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 80, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("User ID");
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 100, 30));

        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setEnabled(false);
        jPanel10.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 190, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("First Name");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 100, 30));

        fn.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        fn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel10.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 190, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Name");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 100, 30));

        ln.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 190, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Email");
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 100, 30));

        mail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 190, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Username");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 90, 30));

        us.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        us.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel10.add(us, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 190, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Password");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 100, 30));

        pw.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwActionPerformed(evt);
            }
        });
        jPanel10.add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 190, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("User Status");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 100, 30));

        ut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Patient", "Medical Staff" }));
        jPanel10.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 190, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("User Type");
        jPanel10.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 100, 30));

        stat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        stat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel10.add(stat, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 190, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("CREATE USER");
        jPanel10.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        add.setBackground(new java.awt.Color(204, 204, 204));
        add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel10.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 130, 40));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 130, 40));

        cl.setBackground(new java.awt.Color(204, 204, 204));
        cl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cl.setForeground(new java.awt.Color(255, 51, 51));
        cl.setText("CLEAR");
        cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clActionPerformed(evt);
            }
        });
        jPanel10.add(cl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 130, 40));

        cc.setBackground(new java.awt.Color(204, 204, 204));
        cc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cc.setText("CANCEL");
        cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccActionPerformed(evt);
            }
        });
        jPanel10.add(cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 130, 40));

        getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       dbConnector dbc = new dbConnector();
    session sess = session.getInstance();  // Logged-in admin

    String fname = fn.getText().trim();
    String lname = ln.getText().trim();
    String uname = us.getText().trim();
    String pass = pw.getText().trim();
    String email = mail.getText().trim();
    String status = stat.getSelectedItem().toString().trim();
    String type = ut.getSelectedItem().toString();
    String question = sq.getSelectedItem().toString();
    String answer = ans.getText().trim();

    // Use the class-level selectedFile
    if (selectedFile == null) {
        JOptionPane.showMessageDialog(null, "Please select an image.");
        return;
    }

    String imageName = uname + "_" + selectedFile.getName();
    String destinationDir = "src/usersimages";
    new File(destinationDir).mkdirs();  // Ensure folder exists
    String destinationPath = destinationDir + "/" + imageName;

    // Validation
    if (fname.isEmpty() || lname.isEmpty() || uname.isEmpty() || pass.isEmpty() ||
        email.isEmpty() || question.isEmpty() || answer.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill all fields.");
        return;
    } else if (pass.length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters.");
        return;
    } else if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
        JOptionPane.showMessageDialog(null, "Enter a valid email address.");
        return;
    } else if (duplicateCheck(uname, email)) {
        return; // Already shown warning inside duplicateCheck
    }

    try {
        String hashedPassword = passwordHasher.hashPassword(pass);
        String hashedAnswer = passwordHasher.hashPassword(answer);

        // Save image to folder
        Files.copy(selectedFile.toPath(), new File(destinationPath).toPath(), StandardCopyOption.REPLACE_EXISTING);

        // Insert user into DB
        String insertQuery = "INSERT INTO tbl_user (u_fname, u_lname, u_username, u_status, u_password, u_email, u_type, u_image, security_question, security_answer) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbc.getConnection();
             PreparedStatement pst = conn.prepareStatement(insertQuery)) {

            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, uname);
            pst.setString(4, status);
            pst.setString(5, hashedPassword);
            pst.setString(6, email);
            pst.setString(7, type);
            pst.setString(8, imageName);
            pst.setString(9, question);
            pst.setString(10, hashedAnswer);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                // Insert log entry
               String logQuery = "INSERT INTO tbl_log (u_id, u_username, u_type, log_status, log_description) VALUES (?, ?, ?, ?, ?)";

try (PreparedStatement logPst = conn.prepareStatement(logQuery)) {
    logPst.setInt(1, sess.getUid());  // User ID of the admin performing the action
    logPst.setString(2, sess.getUsername()); // Admin username
    logPst.setString(3, sess.getType()); // Assuming you have this in session
    logPst.setString(4, "Active"); // You can adjust this as needed
    logPst.setString(5, "Admin Added a New Account: " + uname); // Description of the action
    logPst.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Registered Successfully!");
                new Records().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Registration Failed!");
            }
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_addActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clActionPerformed
        fn.setText("");
            ln.setText("");
            mail.setText("");
            us.setText("");
            pw.setText("");
           sq.setSelectedIndex(0);
            ans.setText("");           // TODO add your handling code here:
    }//GEN-LAST:event_clActionPerformed

    private void ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccActionPerformed
       Records usf = new Records();
       usf.setVisible(true);
       this.dispose();
       
    }//GEN-LAST:event_ccActionPerformed

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
       boolean isSelected = check.isSelected();

    if (isSelected) {      
        pw.setEchoChar((char)0);
    } else {      
        pw.setEchoChar('*'); 
    }
    }//GEN-LAST:event_checkActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String id = uid.getText().trim();
String email = mail.getText().trim();
String username = us.getText().trim();
String password = pw.getText().trim();
String firstName = fn.getText().trim();  // First name
String lastName = ln.getText().trim();   // Last name
String type = stat.getSelectedItem().toString();  // User type
String statusValue = ut.getSelectedItem().toString(); // User status
session sess = session.getInstance();

// Validation
if (id.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Error: User ID is missing.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

if (firstName.isEmpty() || lastName.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Error: First Name and Last Name are required.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Email validation
String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
if (!email.matches(emailRegex)) {
    JOptionPane.showMessageDialog(this, "Invalid Email! Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

// Username validation
if (!username.matches("[a-zA-Z0-9_]{5,}")) {
    JOptionPane.showMessageDialog(this, "Invalid Username! Must be at least 5 characters and contain only letters, numbers, and underscores.", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    
    // Hash the password using SHA-256 before storing
    String hashedPassword = passwordHasher.hashPassword(password);

    dbConnector dbc = new dbConnector();
    String checkQuery = "SELECT COUNT(*) FROM tbl_user WHERE (u_username = ? OR u_email = ?) AND u_id != ?";

    try (Connection conn = dbc.getConnection();
         PreparedStatement pst = conn.prepareStatement(checkQuery)) {

        pst.setString(1, username);
        pst.setString(2, email);
        pst.setInt(3, Integer.parseInt(id));

        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(this, "Username or Email already exists! Please use different credentials.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // ✅ Corrected the column order in the UPDATE query
        String updateQuery = "UPDATE tbl_user SET u_fname = ?, u_lname = ?, u_username = ?, u_email = ?, u_password = ?, u_type = ?, u_status = ? WHERE u_id = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhpapp", "root", "");
             PreparedStatement updatePst = con.prepareStatement(updateQuery)) {
            
            
            String query = "SELECT * FROM tbl_user WHERE u_id = '"+sess.getUid()+"'";
            ResultSet rs = dbc.getData(query);
            if(rs.next())
            {
                String npass = rs.getString("u_password");

                updatePst.setString(1, firstName);   
                updatePst.setString(2, lastName);    
                updatePst.setString(3, username);   
                updatePst.setString(4, email);       
                updatePst.setString(5, npass);  
                updatePst.setString(6, statusValue); 
                updatePst.setString(7, type);        
                updatePst.setInt(8, Integer.parseInt(id)); 
                



                int updated = updatePst.executeUpdate();
                if (updated > 0) {
                    JOptionPane.showMessageDialog(this, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new Records().setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Update failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
} catch (Exception ex) {
    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
            JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/usersimages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path= "";
                }else{
                    u_image.setIcon(ResizeImage(path, null, u_image));
                    select.setEnabled(false);
                    remove.setEnabled(true);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }

    }//GEN-LAST:event_selectActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        select.setEnabled(true);
        u_image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_removeActionPerformed

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
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JTextField ans;
    private javax.swing.JButton cc;
    private javax.swing.JCheckBox check;
    private javax.swing.JButton cl;
    public javax.swing.JTextField fn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    public javax.swing.JTextField ln;
    public javax.swing.JTextField mail;
    public javax.swing.JPasswordField pw;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    private javax.swing.JComboBox<String> sq;
    public javax.swing.JComboBox<String> stat;
    private javax.swing.JLabel u_image;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField us;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
