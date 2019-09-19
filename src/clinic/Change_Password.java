/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Umashankar
 */
public class Change_Password extends javax.swing.JFrame {

    /**
     * Creates new form Forgot_Password
     */
    public Change_Password() {
        initComponents();
    }
    
    public void Acc_type(){
    String ac_type = Acc_Type.getSelectedItem().toString();
    if(ac_type.equals("Patient")){
    String uname = txtid1.getText();
    String strpass = txtoldpass.getText();
    String newpass = txtpass1.getText();
    String conpass = txtpass2.getText();
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("Select * from AccountForPatient");
            
            while(rs.next()){
                String username = rs.getString("username");
                String Password = rs.getString("password");
                if(uname.equals(username) &&  strpass.equals(Password)){
                    if(newpass.equals(conpass)){
                        String str = "update AccountForPatient set password =?, cpassword=? where username=?";
                        PreparedStatement pst = cn.prepareStatement(str);
                        pst.setString(1, newpass);
                        pst.setString(2, conpass);
                        pst.setString(3, uname);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(rootPane, "Password update successful..");
                        txtid1.setText("");
                        txtoldpass.setText("");
                        txtpass1.setText("");
                        txtpass2.setText("");
                        Acc_Type.setSelectedIndex(0); 
                        Patient_login dl = new Patient_login();
                        dl.show();
                        dl.dispose();
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "please confirm password");
                    }
                }
                else if(uname.equals("") && strpass.equals("") && newpass.equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Please Enter information..");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Username not Found");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
}
    else if(ac_type.equals("Doctor")){
        String uname = txtid1.getText();
        String strpass = txtoldpass.getText();
        String newpass = txtpass1.getText();
        String conpass = txtpass2.getText();
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("Select * from AccountForDoctor");
            
            while(rs.next()){
                String username = rs.getString("username");
                String Password = rs.getString("password");
                if(uname.equals(username) &&  strpass.equals(Password)){
                    if(newpass.equals(conpass)){
                        String str = "update AccountForDoctor set password =?, cpassword=? where username=?";
                        PreparedStatement pst = cn.prepareStatement(str);
                        pst.setString(1, newpass);
                        pst.setString(2, conpass);
                        pst.setString(3, uname);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(rootPane, "Password update successful..");
                        txtid1.setText("");
                        txtoldpass.setText("");
                        txtpass1.setText("");
                        txtpass2.setText("");
                        Acc_Type.setSelectedIndex(0);
                        Doctor_Login dl = new Doctor_Login();
                        dl.show();
                        dl.dispose();
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "please confirm password");
                    }
                }
                else if(uname.equals("") && strpass.equals("") && newpass.equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Please Enter information..");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Username not Found");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

        
    }else if(ac_type.equals("Medical")){
        String uname = txtid1.getText();
        String strpass = txtoldpass.getText();
        String newpass = txtpass1.getText();
        String conpass = txtpass2.getText();
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("Select * from AccountForMedical");
            
            while(rs.next()){
                String username = rs.getString("username");
                String Password = rs.getString("password");
                if(uname.equals(username) &&  strpass.equals(Password)){
                    if(newpass.equals(conpass)){
                        String str = "update AccountForMedical set password =?, cpassword=? where username=?";
                        PreparedStatement pst = cn.prepareStatement(str);
                        pst.setString(1, newpass);
                        pst.setString(2, conpass);
                        pst.setString(3, uname);
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(rootPane, "Password update successful..");
                        txtid1.setText("");
                        txtoldpass.setText("");
                        txtpass1.setText("");
                        txtpass2.setText("");
                        Acc_Type.setSelectedIndex(0);
                        Medical_Login dl = new Medical_Login();
                        dl.show();
                        dl.dispose();
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "please confirm password");
                    }
                }
                else if(uname.equals("") && strpass.equals("") && newpass.equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Please Enter information..");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Username not Found");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }else{
        JOptionPane.showMessageDialog(rootPane, "Please select Account Type.....");
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtid1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtpass1 = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtpass2 = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtoldpass = new javax.swing.JPasswordField();
        Acc_Type = new javax.swing.JComboBox<>();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clinic management system");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Username");

        txtid1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtid1txtidActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("New Password");

        txtpass1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnlogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnlogin.setText("Change Password");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginjButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Login again");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Forgot Password");

        txtpass2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Confirm Password");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Old Password");

        txtoldpass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        Acc_Type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Acc_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Select Account type ---", "Patient", "Doctor", "Medical" }));
        Acc_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_TypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtoldpass, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid1)
                            .addComponent(txtpass1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtpass2)
                            .addComponent(Acc_Type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Acc_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtid1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtoldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtpass2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setText("Back");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setText("Exit");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20)
                    .addComponent(jButton21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Patient_login cd = new Patient_login();
        cd.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnloginjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginjButton1ActionPerformed
        Acc_type();
    }//GEN-LAST:event_btnloginjButton1ActionPerformed

    private void txtid1txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtid1txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid1txtidActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here
        Patient_Dashboard pd = new Patient_Dashboard();
        pd.show();
        dispose();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void Acc_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_TypeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_Acc_TypeActionPerformed

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
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Acc_Type;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtid1;
    private javax.swing.JPasswordField txtoldpass;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JPasswordField txtpass2;
    // End of variables declaration//GEN-END:variables

//String sql = "Select username , password from AccountForDoctor where username=? and password = ?";
}
