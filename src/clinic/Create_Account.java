package clinic;

import java.sql.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Create_Account extends javax.swing.JFrame {

    public Create_Account() {
        initComponents();
    }

    public String Doc_id(){
        String id = "DOC"+0;
            try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            String str = "Select id from Customer";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
              id = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id+001;
    }
    
    public String Med_id(){
        String id = "MED"+0;
            try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            String str = "Select id from Customer";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
              id = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return id+1;
    }
    
//    public void randomnumber(){
//        Random ran = new Random();
//        int n = ran.nextInt(100)+1;
//        String val = String.valueOf(n);
//        txt_id.setText(val);
//    }
//    
    
    public void Ac_type(){
    String Acc = ac_type.getSelectedItem().toString();
    if(Acc.equals("Doctor")){
        try{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
        java.sql.Statement st =cn.createStatement();
        String str = "insert into AccountForDoctor values('"+ac_type.getSelectedItem().toString()+"','"+txt_id.getText()+"','"+txtname.getText()+"','"+cmbcode.getSelectedItem().toString()+"','"+txtmob.getText()+"','"+txtmail.getText()+"','"+txtuser.getText()+"','"+txtpass.getText()+"','"+txtcpass.getText()+"')";
        st.executeUpdate(str);
            JOptionPane.showMessageDialog(rootPane, "Doctor Account Created !!!");
            Doctor_Login dl = new Doctor_Login();
            dl.show();
            dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }else if(Acc.equals("Medical")){ 
        try{
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
        java.sql.Statement st =cn.createStatement();
        String str = "insert into AccountForMedical values('"+ac_type.getSelectedItem().toString()+"','"+txt_id.getText()+"','"+txtname.getText()+"','"+cmbcode.getSelectedItem().toString()+"','"+txtmob.getText()+"','"+txtmail.getText()+"','"+txtuser.getText()+"','"+txtpass.getText()+"','"+txtcpass.getText()+"')";
        st.executeUpdate(str);
            JOptionPane.showMessageDialog(rootPane, "Medical Account Created.!!!!!");
            Medical_Login ml = new Medical_Login();
            ml.show();
            dispose();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }else{
        JOptionPane.showMessageDialog(rootPane, "Please select Account type...");
    }    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cmbcode = new javax.swing.JComboBox<>();
        txtmob = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtmail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txtuser = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        txtcpass = new javax.swing.JPasswordField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        ac_type = new javax.swing.JComboBox<>();
        lblid = new javax.swing.JLabel();
        txt_acc = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lblmob = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        lblepass = new javax.swing.JLabel();
        lblecpass = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Create Account");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("Enter Name");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnameKeyReleased(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("Mobile number");

        cmbcode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+91", "+90", "+34", "+41", "+81" }));
        cmbcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcodeActionPerformed(evt);
            }
        });

        txtmob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmobKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setText("Email ID");

        txtmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmailActionPerformed(evt);
            }
        });
        txtmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmailKeyReleased(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setText("Password");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setText("Create Account ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtuserKeyReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("Username");

        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpassKeyReleased(evt);
            }
        });

        txtcpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcpassKeyReleased(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel28.setText("confirm password");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel29.setText("Account type");

        ac_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Select Ac type ---", "Doctor", "Medical" }));
        ac_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_typeActionPerformed(evt);
            }
        });
        ac_type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ac_typeKeyReleased(evt);
            }
        });

        lblid.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblid.setText("ID:");

        txt_acc.setForeground(new java.awt.Color(255, 0, 0));

        lblname.setForeground(new java.awt.Color(255, 0, 0));

        lblmob.setForeground(new java.awt.Color(255, 0, 0));

        lblemail.setForeground(new java.awt.Color(255, 0, 0));

        lbluser.setForeground(new java.awt.Color(255, 0, 0));

        lblepass.setForeground(new java.awt.Color(255, 0, 0));

        lblecpass.setForeground(new java.awt.Color(255, 0, 0));

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblecpass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblepass, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbluser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel29)
                                                .addComponent(ac_type, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblid, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                                            .addGap(20, 20, 20))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                    .addComponent(cmbcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtmob))
                                                .addComponent(txtname)
                                                .addComponent(txtmail, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtuser, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtpass, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtcpass, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGap(15, 15, 15))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txt_acc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblmob, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                .addGap(85, 85, 85))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lblid))
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ac_type, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22))
                    .addComponent(txt_acc))
                .addGap(5, 5, 5)
                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbcode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(lblmob)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addGap(0, 0, 0)
                .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblemail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbluser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblepass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcpass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblecpass)
                .addGap(15, 15, 15)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 71, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clinic management system");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 70));

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/close.png"))); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(557, 0, 40, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void txtnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyReleased
        String Pattern1 = "^[a-z A-Z]{0,25}$";
            Pattern pat = Pattern.compile(Pattern1);
            Matcher matc = pat.matcher(txtname.getText());
            if(!matc.matches()){
                lblname.setText("  *Enter Character Only..!");
            }
            else{
                lblname.setText("");
            }
    }//GEN-LAST:event_txtnameKeyReleased

    private void cmbcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbcodeActionPerformed

    private void txtmobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmobKeyReleased
        // TODO add your handling code here:
                String PATTERN = "^[0-9]{0,10}$";
            Pattern patt = Pattern.compile(PATTERN);
            Matcher match = patt.matcher(txtmob.getText());
            if(!match.matches()){
                lblmob.setText("* Enter valid Number..!");
            }
            else{
                lblmob.setText("");
            }
    }//GEN-LAST:event_txtmobKeyReleased

    private void txtmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailActionPerformed

    private void txtmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailKeyReleased
        // TODO add your handling code here:
        String PATTERN = "^[_A-Z a-z 0-9 +-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$";
            Pattern patt = Pattern.compile(PATTERN);
            Matcher match = patt.matcher(txtmail.getText());
            if(!match.matches()){
                lblemail.setText("* Enter valid Email ID...");
            }
            else{
                lblemail.setText("");
            }
    }//GEN-LAST:event_txtmailKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String name = txtname.getText();
    String username = txtuser.getText();
    String Confirm = txtcpass.getText();
    String password = txtpass.getText();
    if(name.equals("")){
        JOptionPane.showMessageDialog(rootPane, "Please Enter Name...!");
    }
    
    else if(username.equals("")){
        JOptionPane.showMessageDialog(rootPane, "Enter Username...!");
    }

    else if(password.equals("")){
        JOptionPane.showMessageDialog(rootPane, "Enter Password...!");
    }
    else if(Confirm.equals("")){
        JOptionPane.showMessageDialog(rootPane, "Re-Enter Password...!");
    }
    else{
        Ac_type();
    }
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyReleased
        // TODO add your handling code here:
            String PATTERN = "^[a-z A-z 0-9]{0,10}$";
            Pattern patt = Pattern.compile(PATTERN);
            Matcher match = patt.matcher(txtuser.getText());
            if(!match.matches()){
                lbluser.setText("* Enter valid Username..!");
            }
            else{
                lbluser.setText("");
            }
    }//GEN-LAST:event_txtuserKeyReleased

    private void txtpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyReleased
        // TODO add your handling code here:
            String PATTERN = "^[a-z A-z 0-9]{8,20}$";
            Pattern patt = Pattern.compile(PATTERN);
            Matcher match = patt.matcher(txtpass.getText());
            if(!match.matches()){
                lblepass.setText("* Maximum 8 Character..!");
            }
            else{
                lblepass.setText("");
            }
    }//GEN-LAST:event_txtpassKeyReleased

    private void txtcpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcpassKeyReleased
        // TODO add your handling code here:
        String pass= txtpass.getText();
        String cpass = txtcpass.getText();
        if(cpass.equals(pass)){
            String PATTERN = "^[a-z A-z 0-9]{8,20}$";
            Pattern patt = Pattern.compile(PATTERN);
            Matcher match = patt.matcher(cpass);
            if(!match.matches()){ 
            lblecpass.setText("* please check Password ..!");
            }
            else{
                lblecpass.setText("");
            }
        }
        else{
            lblecpass.setText("* Password not Match /n please check..!");
        }
    }//GEN-LAST:event_txtcpassKeyReleased

    private void ac_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ac_typeActionPerformed
        // TODO add your handling code here:
        String id = ac_type.getSelectedItem().toString();
        if(id.equalsIgnoreCase("Doctor")){
            lblid.setText("Doctor ID");
            Doc_id();
            txt_id.setText(Doc_id());
        }else if(id.equals("Medical")){
            lblid.setText("Medical ID");
            Med_id();
            txt_id.setText(Med_id());
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please select Acc type!!!!");
        }
    }//GEN-LAST:event_ac_typeActionPerformed

    private void ac_typeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ac_typeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ac_typeKeyReleased

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton21ActionPerformed

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
            java.util.logging.Logger.getLogger(Create_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_Account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ac_type;
    private javax.swing.JComboBox<String> cmbcode;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblecpass;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblepass;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblmob;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lbluser;
    private javax.swing.JLabel txt_acc;
    private javax.swing.JLabel txt_id;
    private javax.swing.JPasswordField txtcpass;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtmob;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
