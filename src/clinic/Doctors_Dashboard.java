/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import javafx.scene.control.RadioButton;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Date.*;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Umashankar
 */
public class Doctors_Dashboard extends javax.swing.JFrame {


    
    
    public Doctors_Dashboard() {
        initComponents();
        showDate();
        showTime();
        randomnumber();
        Doc_Id();
//        P_Id();
//        Appointment();
    }
        
    public void randomnumber()
    {
        Random ran = new Random();
        int n = ran.nextInt(100)+1;
        String val = String.valueOf(n);
//        txt_id.setText(val);
        a_id.setText(val);
    }
  
        public void Doc_Id(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            String str = "select Doc_id from Add_Doctor";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
//                d_id.addItem(rs.getString("Doc_id"));
                cmb_doc_id.addItem(rs.getString("Doc_id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

//        public void P_Id(){
//        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
//            Statement st = cn.createStatement();
//            String str = "select Patient_Id from Add_patient";
//            ResultSet rs = st.executeQuery(str);
//            while(rs.next()){
//                cmb_id.addItem(rs.getString("Patient_Id"));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, e.getMessage());
//        }
//    }

    public void showDate(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        lbldate.setText(sdf.format(d));
    }
    
    public void  showTime(){
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            java.util.Date d = new java.util.Date();
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
            lbltime.setText(sdf.format(d));
            }
        }).start();
    }
    public void Patienttype(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            String str = "select Patienttype from Appointment";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
                cmb_flter_list.addItem(rs.getString("Patienttype"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    
    public void name(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            String str = "select Patient_name from Appointment";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
                cmb_flter_list.addItem(rs.getString("Patient_name"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    
    public void Appointment_Id(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            String str = "select Appointment_Id from Appointment";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
                cmb_flter_list.addItem(rs.getString("Appointment_Id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    
    public void Doc_name(){
            try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            String str = "select * from Appointment";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
                cmb_flter_list.addItem(rs.getString("Doc_name"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

        
    public void cmb_flter(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            Statement st = cn.createStatement();
            String str = "select * from Add_patient";
            ResultSet rs = st.executeQuery(str);
            while(rs.next()){
                cmb_flter_list1.addItem(rs.getString("Patient_id"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }
    
String imgPath = null;
     public ImageIcon ResizeImage(String ImagePath, byte[] pic)
    {
        ImageIcon MyImage = null;
        if(ImagePath != null)
        {
           MyImage = new ImageIcon(ImagePath);
        }else
        {
            MyImage = new ImageIcon(pic);
        }
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblphoto.getWidth(), lblphoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
     
//    public void Appointment(){
//        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
//            Statement st = cn.createStatement();
//            String str = "select Appointment_id from Appointment";
//            ResultSet rs = st.executeQuery(str);
//            while(rs.next()){
//                cmb_appointment.addItem(rs.getString("Appointment_id"));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(rootPane, e.getMessage());
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        P_Gender = new javax.swing.ButtonGroup();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        R_gender = new javax.swing.ButtonGroup();
        A_gender = new javax.swing.ButtonGroup();
        h_gender = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        p_id = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        p_contact = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        p_address = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        p_name = new javax.swing.JTextField();
        p_age = new javax.swing.JTextField();
        p_male = new javax.swing.JRadioButton();
        p_female = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        lblphoto = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        r_contact = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        r_name = new javax.swing.JTextField();
        r_age = new javax.swing.JTextField();
        r_male = new javax.swing.JRadioButton();
        r_female = new javax.swing.JRadioButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        p_relation = new javax.swing.JComboBox<>();
        jButton23 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        p_mob = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        p_address1 = new javax.swing.JTextArea();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        p_age1 = new javax.swing.JTextField();
        p_male1 = new javax.swing.JRadioButton();
        p_female1 = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        p_type = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        Doc_name = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        C_fees = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        doc_mob = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        a_id = new javax.swing.JTextField();
        cmb_specialist = new javax.swing.JComboBox<>();
        a_date = new com.toedter.calendar.JDateChooser();
        a_time = new com.github.lgooddatepicker.components.TimePicker();
        jLabel63 = new javax.swing.JLabel();
        cmb_doc_id = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        p_id1 = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cmb_filter = new javax.swing.JComboBox<>();
        cmb_flter_list = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        cmb_flter_list1 = new javax.swing.JComboBox<>();
        cmb_filter1 = new javax.swing.JComboBox<>();
        jButton21 = new javax.swing.JButton();
        lbldate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lbl_error = new javax.swing.JLabel();

        jButton18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton18.setText("Back");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton19.setText("Exit");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Welcome to Clinic management system");
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setText("Prescription");
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete Patients info");
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton10.setText("Patients History");
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setText("Update Patients info");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton13.setText("Book Appointment");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout-sign.png"))); // NOI18N
        jButton22.setText("Logout");
        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Doctor Dashboard");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        jLabel17.setText("Patient ID: ");
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setText("Contact: ");
        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        p_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_contactKeyReleased(evt);
            }
        });

        p_address.setColumns(20);
        p_address.setRows(5);
        p_address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_addressKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(p_address);

        jLabel19.setText("Address:");
        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel20.setText("Gender:");
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel21.setText("Patient Age: ");
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel22.setText("Patient Name: ");
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        p_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_nameKeyReleased(evt);
            }
        });

        p_age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_ageKeyReleased(evt);
            }
        });

        P_Gender.add(p_male);
        p_male.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        p_male.setText("Male");
        p_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_maleActionPerformed(evt);
            }
        });

        P_Gender.add(p_female);
        p_female.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        p_female.setText("Female");
        p_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_femaleActionPerformed(evt);
            }
        });

        jLabel23.setText("Patient Information");
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(p_age, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(p_male, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(p_female, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(p_name))
                                .addGap(23, 23, 23))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(p_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_name)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_age, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_male)
                    .addComponent(p_female))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_contact)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        jButton4.setText("Save");
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        lblphoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton11.setText("Select Image");
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(0, 204, 204));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel54.setText("Contact: ");
        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        r_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                r_contactKeyReleased(evt);
            }
        });

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jTextArea8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea8KeyReleased(evt);
            }
        });
        jScrollPane10.setViewportView(jTextArea8);

        jLabel55.setText("Relative Address:");
        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel56.setText("Gender:");
        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel64.setText("Relative Age: ");
        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel65.setText("Relative Name: ");
        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        r_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                r_nameKeyReleased(evt);
            }
        });

        r_age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                r_ageKeyReleased(evt);
            }
        });

        R_gender.add(r_male);
        r_male.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        r_male.setText("Male");
        r_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_maleActionPerformed(evt);
            }
        });

        R_gender.add(r_female);
        r_female.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        r_female.setText("Female");
        r_female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_femaleActionPerformed(evt);
            }
        });

        jLabel66.setText("For Emergency Contact");
        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel67.setText("Relation:");
        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        p_relation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Select Relation ---", "Father", "Mother", "Sister", "Brother", "Husband", "Wife", "Cousin", "Son", "Daughter", "Uncle", "Aunt" }));
        p_relation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(r_name, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(r_age, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(r_male, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(r_female, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(p_relation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(r_contact, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_relation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(r_name)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(r_age, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(r_male)
                    .addComponent(r_female))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(r_contact)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        jButton23.setText("Search");
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(p_id, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton11)))))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lblphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jTabbedPane1.addTab("New Patients", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 204, 204));

        jPanel12.setBackground(new java.awt.Color(0, 204, 204));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel31.setText("Contact: ");
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        p_address1.setColumns(20);
        p_address1.setRows(5);
        jScrollPane5.setViewportView(p_address1);

        jLabel32.setText("Address:");
        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel33.setText("Gender:");
        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel34.setText("Patient Age: ");
        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel35.setText("Patient Name: ");
        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        A_gender.add(p_male1);
        p_male1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        p_male1.setText("Male");
        p_male1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_male1ActionPerformed(evt);
            }
        });

        A_gender.add(p_female1);
        p_female1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        p_female1.setText("Female");
        p_female1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_female1ActionPerformed(evt);
            }
        });

        jLabel36.setText("Patient Information");
        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel37.setText("Patient Type");
        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        p_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Select Patient type ---", "New", "Old" }));
        p_type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(p_male1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(p_female1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 46, Short.MAX_VALUE))
                                    .addComponent(pname)
                                    .addComponent(p_age1)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)))
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(p_mob)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(p_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(40, 40, 40))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pname)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_age1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_male1)
                    .addComponent(p_female1))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(p_mob)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(p_type, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jButton7.setText("Save");
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Delete");
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Cancel");
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(0, 204, 204));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel40.setText("Time :");
        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel50.setText("Appointment Information");
        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel57.setText("Specialist for:");
        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel58.setText("Doctor name:");
        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        Doc_name.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel59.setText("Consultancy fees:");
        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        C_fees.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel60.setText("Contact :");
        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        doc_mob.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        doc_mob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doc_mobActionPerformed(evt);
            }
        });

        jLabel61.setText("Date:");
        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel62.setText("Appointment ID:");
        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        a_id.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        cmb_specialist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Specialist for ---", "Allergists", "Anesthesiologists ", "Cardiologists( heart, blood vessels)", "Dentist", "Dermatologists( Skin, Hair etc.)", "ENT Specialist (Ear, Nose, and Throat)", "Endocrinologists( Diabetes, Thyroid problems, infertility, and calcium)", "Microbiologist", "Neurosurgeon", "Pediatrician", "Surgeon" }));
        cmb_specialist.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel63.setText("Doctor ID:");
        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cmb_doc_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Select Doctor Id ---" }));
        cmb_doc_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_doc_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_doc_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel50))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(a_time, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(a_date, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doc_mob, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_specialist, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(C_fees, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(a_id, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmb_doc_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Doc_name, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(a_id)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_specialist, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_doc_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Doc_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_fees, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doc_mob, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a_date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(a_time, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Book Appointment");
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel30.setText("Patient ID: ");
        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jButton24.setText("Search");
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(326, 326, 326)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(p_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Book Appointments", jPanel5);

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Name", "Age", "Gender", "Contact", "Type", "Appointment ID", "Doctor for", "Doc id", "Doctor name", "Doctor no", "Date", "Time"
            }
        ));
        jScrollPane6.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(12).setPreferredWidth(40);
        }

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Appointment List");
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        cmb_filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Filtered by ---", "All Appointment", "Patient Type", "Name", "Appointment Id", "Doctor Name" }));
        cmb_filter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_filterActionPerformed(evt);
            }
        });

        cmb_flter_list.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_flter_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_flter_listActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cmb_filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_flter_list, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_flter_list, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Doctor appointment List", jPanel6);

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Patient  Name", "Age", "Gender", "Contact", "Relation", "Relative Name", "Relative Contact", "Image"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable2);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Patient List");
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        cmb_flter_list1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_flter_list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_flter_list1ActionPerformed(evt);
            }
        });

        cmb_filter1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- Filtered by ---", "All Appointment", "Patient ID" }));
        cmb_filter1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_filter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_filter1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmb_filter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_flter_list1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_flter_list1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_filter1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("List Patients", jPanel3);

        jButton21.setText("Exit");
        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        lbldate.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Date  :");
        jLabel10.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N

        jLabel11.setText("Time :");
        jLabel11.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N

        lbltime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbltime.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        lbltime.setToolTipText("");

        lbl_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_error.setFont(new java.awt.Font("Sitka Small", 1, 14)); // NOI18N
        lbl_error.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(0, 0, 0)
                                .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(lbl_error, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
            Doctor_Prescription up = new Doctor_Prescription();
            up.show();
            dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
            Patient_Delete pd = new Patient_Delete();
            pd.show();
            dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here
        _Clinic_Dashboard pd = new _Clinic_Dashboard();
        pd.show();
        dispose();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Patients_History ph = new Patients_History();
        ph.show();
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        String title = "Quit";
        int reply = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to Logout now?", title, JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION)
        {
            Doctor_Login ml = new Doctor_Login();
            ml.show();
            dispose();
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void cmb_filter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_filter1ActionPerformed
        // TODO add your handling code here:

        String Filter = cmb_filter1.getSelectedItem().toString();
        if(Filter.equalsIgnoreCase("All Appointment")){
            cmb_flter_list1.addItem("All");
        }
        else if(Filter.equalsIgnoreCase("Patient ID")){
            cmb_flter();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Please select type..");
        }
    }//GEN-LAST:event_cmb_filter1ActionPerformed

    private void cmb_flter_list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_flter_list1ActionPerformed
        // TODO add your handling code here:
        String filter = cmb_flter_list1.getSelectedItem().toString();
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            if(filter.equals("All")){
                Statement st = cn.createStatement();
                String sql ="SELECT * FROM ADD_PATIENT";
                ResultSet rs = st.executeQuery(sql);
                DefaultTableModel dtm = (DefaultTableModel)jTable2.getModel();
                dtm.setRowCount(0);
                while (rs.next()){
                    Object o[] = {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(12),
                        rs.getBlob(13)
                    };
                    dtm.addRow(o);
                }
            }
            if(filter.equals("All")){
                Statement st = cn.createStatement();
                String sql ="SELECT * FROM ADD_PATIENT";
                ResultSet rs = st.executeQuery(sql);
                DefaultTableModel dtm = (DefaultTableModel)jTable2.getModel();
                dtm.setRowCount(0);
                while (rs.next()){
                    Object o[] = {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(12),
                        rs.getBlob(13)
                    };
                    dtm.addRow(o);
                }
            }
        }catch(Exception e){
            e.getMessage();
        }

    }//GEN-LAST:event_cmb_flter_list1ActionPerformed

    private void cmb_flter_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_flter_listActionPerformed
        // TODO add your handling code here:
        String filter = cmb_flter_list.getSelectedItem().toString();
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            if(filter.equals("All")){
                Statement st = cn.createStatement();
                String sql ="select * from Appointment";
                ResultSet rs = st.executeQuery(sql);
                DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                dtm.setRowCount(0);
                while (rs.next()){
                    Object o[] = {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(13),
                        rs.getDate(14),
                        rs.getString(15)
                    };
                    dtm.addRow(o);
                }
            }
            else if(filter.equals("New")){
                Statement st = cn.createStatement();
                String sql ="SELECT * FROM APPOINTMENT WHERE PATIENTTYPE = '"+filter+"'";
                ResultSet rs = st.executeQuery(sql);
                DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                dtm.setRowCount(0);
                while (rs.next()){
                    Object o[] = {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(13),
                        rs.getDate(14),
                        rs.getString(15)
                    };
                    dtm.addRow(o);
                }
            }
            else if(filter.equals("Old")){
                Statement st = cn.createStatement();
                String sql ="SELECT * FROM APPOINTMENT WHERE PATIENTTYPE = '"+filter+"'";
                ResultSet rs = st.executeQuery(sql);
                DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                dtm.setRowCount(0);
                while (rs.next()){
                    Object o[] = {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(13),
                        rs.getDate(14),
                        rs.getString(15)
                    };
                    dtm.addRow(o);
                }
            }

            else if(filter.equals("Old")){
                Statement st = cn.createStatement();
                String sql ="SELECT * FROM APPOINTMENT WHERE PATIENTTYPE = '"+filter+"'";
                ResultSet rs = st.executeQuery(sql);
                DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
                dtm.setRowCount(0);
                while (rs.next()){
                    Object o[] = {
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(13),
                        rs.getDate(14),
                        rs.getString(15)
                    };
                    dtm.addRow(o);
                }
            }
        }catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_cmb_flter_listActionPerformed

    private void cmb_filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_filterActionPerformed
        // TODO add your handling code here:

        String Filter = cmb_filter.getSelectedItem().toString();
        if(Filter.equalsIgnoreCase("All Appointment")){
            cmb_flter_list.addItem("All");
        }
        else if(Filter.equalsIgnoreCase("Patient Type")){
            cmb_flter_list.addItem("New");
            cmb_flter_list.addItem("Old");
        }
        else if(Filter.equalsIgnoreCase("Name")){
            name();
        }
        else if(Filter.equalsIgnoreCase("Appointment Id")){
            Appointment_Id();
        }
        else if(Filter.equalsIgnoreCase("Doctor Name")){
            Doc_name();
        }
        else if(Filter.equalsIgnoreCase("Patienttype")) {
            Patienttype();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please select type..");
        }
    }//GEN-LAST:event_cmb_filterActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            String sql = "Select * from Add_patient where patient_id=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p_id.getText());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                pname.setText(rs.getString("patient_name"));
                p_age1.setText(rs.getString("patient_age"));
                if("Male".equals(rs.getString("patient_Gender"))){
                    p_male1.setSelected(true);
                }
                else if("Female".equals(rs.getString("patient_Gender"))){
                    p_female1.setSelected(true);
                }else{
                    p_male1.setSelected(false);
                    p_female1.setSelected(false);
                }
                p_address1.setText(rs.getString("patient_address"));
                p_mob.setText(rs.getString("patient_contact"));
            }
            pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void cmb_doc_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_doc_idActionPerformed
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
            String sql = "Select * from Add_Doctor where Doc_id=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cmb_doc_id.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Doc_name.setText(rs.getString("Doc_name"));
            }
            pst.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_cmb_doc_idActionPerformed

    private void doc_mobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doc_mobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doc_mobActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(pname.getText().equals("") || p_age1.getText().equals("") || p_address1.getText().equals("") || p_mob.getText().equals("") || a_id.getText().equals("") || Doc_name.getText().equals("") || C_fees.getText().equals("") || doc_mob.getText().equals("") || a_time.getText().equals("") || a_date.getDate().equals("")){
            lbl_error.setText("*Please Insert required data..");
        }else{
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
                String sql = "insert into Appointment values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, p_id1.getText());
                pst.setString(2, pname.getText());
                pst.setString(3, p_age1.getText());
                pst.setString(4, A_Gender);
                pst.setString(5, p_address1.getText());
                pst.setString(6, p_mob.getText());
                pst.setString(7, p_type.getSelectedItem().toString());
                pst.setString(8, a_id.getText());
                pst.setString(9, cmb_specialist.getSelectedItem().toString());
                pst.setString(10, cmb_doc_id.getSelectedItem().toString());
                pst.setString(11, Doc_name.getText());
                pst.setString(12, C_fees.getText());
                pst.setString(13, doc_mob.getText());
                pst.setDate(14, new java.sql.Date(a_date.getDate().getTime()));
                pst.setString(15, a_time.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Appointment Done..");
                p_id1.setText("");
                p_type.setSelectedIndex(0);
                pname.setText("");
                p_age1.setText("");
                if("Male".equals("A_Gender")){
                    p_male1.setSelected(false);
                }
                else if("Female".equals("A_Gender")){
                    p_female1.setSelected(false);
                }else{
                    p_male1.setSelected(false);
                    p_female1.setSelected(false);
                }
                p_address1.setText("");
                p_mob.setText("");
                a_id.setText("");
                cmb_specialist.setSelectedIndex(0);
                cmb_doc_id.setSelectedIndex(0);
                Doc_name.setText("");
                C_fees.setText("");
                doc_mob.setText("");
                a_date.setDate(null);
                a_time.setText("");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            lbl_error.setText("");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void p_female1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_female1ActionPerformed
        // TODO add your handling code here:
        A_Gender = "Female";
    }//GEN-LAST:event_p_female1ActionPerformed

    private void p_male1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_male1ActionPerformed
        // TODO add your handling code here:
        A_Gender = "Male";
    }//GEN-LAST:event_p_male1ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        if(p_id.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please enter Patient id..");
        }else{
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
                String sql = "Select * from Add_patient where patient_id=?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, p_id.getText());
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    p_name.setText(rs.getString("patient_name"));
                    p_age.setText(rs.getString("patient_age"));
                    if("Male".equals(rs.getString("patient_Gender"))){
                        p_male.setSelected(true);
                    }
                    else if("Female".equals(rs.getString("patient_Gender"))){
                        p_female.setSelected(true);
                    }else{
                        p_male.setSelected(false);
                        p_female.setSelected(false);
                    }
                    p_address.setText(rs.getString("patient_address"));
                    p_contact.setText(rs.getString("patient_contact"));
                    p_relation.setSelectedItem(rs.getString("relation"));
                    r_name.setText(rs.getString("relative_name"));
                    r_age.setText(rs.getString("relative_age"));
                    if("Male".equals(rs.getString("relative_Gender"))){
                        r_male.setSelected(true);
                    }
                    else if("Female".equals(rs.getString("relative_Gender"))){
                        r_female.setSelected(true);
                    }else{
                        r_male.setSelected(false);
                        r_female.setSelected(false);
                    }
                    jTextArea8.setText(rs.getString("relative_address"));
                    r_contact.setText(rs.getString("relative_contact"));
                    lblphoto.setIcon(ResizeImage(null, rs.getBytes("img")));
                }
                pst.execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //http://raphaeljs.com/icons/#lock
    }//GEN-LAST:event_jButton23ActionPerformed

    private void r_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_femaleActionPerformed
        // TODO add your handling code here:
        Relative_Gender = "Female";
    }//GEN-LAST:event_r_femaleActionPerformed

    private void r_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_maleActionPerformed
        // TODO add your handling code here:
        Relative_Gender = "Male";
    }//GEN-LAST:event_r_maleActionPerformed

    private void r_ageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_ageKeyReleased

        String PATTERN = "^[0-9]{0,10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(r_age.getText());
        if(!match.matches()){
            lbl_error.setText("*Enter Number Only..!");
        }
        else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_r_ageKeyReleased

    private void r_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_nameKeyReleased
        String Pattern1 = "^[a-z A-Z]{0,25}$";
        Pattern pat = Pattern.compile(Pattern1);
        Matcher matc = pat.matcher(r_name.getText());
        if(!matc.matches()){
            lbl_error.setText("*Enter Character Only..!");
        }
        else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_r_nameKeyReleased

    private void jTextArea8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea8KeyReleased

    }//GEN-LAST:event_jTextArea8KeyReleased

    private void r_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_r_contactKeyReleased
        String PATTERN = "^[0-9]{0,10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(r_contact.getText());
        if(!match.matches()){
            lbl_error.setText("*Enter valid Number..!");
        }
        else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_r_contactKeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // Image code
        JFileChooser file=new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png",".pdf");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        //if the user click on save in Jfilechooser
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lblphoto.setIcon(ResizeImage(path,null));
            imgPath = path;
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No File Select");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(p_id.getText().equals("") || p_name.getText().equals("") || p_age.getText().equals("") || p_address.getText().equals("") || p_contact.getText().equals("") || r_name.getText().equals("") || r_age.getText().equals("") || jTextArea8.getText().equals("") || r_contact.getText().equals("")){
            lbl_error.setText("*Please Enter Data..");
        }
        else{
            if(imgPath != null){
                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    Connection cn = DriverManager.getConnection("jdbc:derby://localhost:1527/Clinic_Data");
                    InputStream img = new FileInputStream(new File(imgPath));
                    String sql = "Insert into Add_Patient values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = cn.prepareStatement(sql);
                    pst.setString(1, p_id.getText());
                    pst.setString(2, p_name.getText());
                    pst.setInt(3,Integer.parseInt(p_age.getText()));
                    pst.setString(4, Gender);
                    pst.setString(5, p_address.getText());
                    pst.setString(6, p_contact.getText());
                    pst.setString(7, p_relation.getSelectedItem().toString());
                    pst.setString(8, r_name.getText());

                    pst.setInt(9,Integer.parseInt(r_age.getText()));
                    pst.setString(10, Relative_Gender);
                    pst.setString(11, jTextArea8.getText());
                    pst.setString(12, r_contact.getText());
                    pst.setBlob(13, img);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(rootPane, "Successfully Added..");

                    p_id.setText("");
                    p_name.setText("");
                    p_age.setText("");
                    if("Male".equals("patient_Gender")){
                        p_male1.setSelected(true);
                    }
                    else if("Female".equals("patient_Gender")){
                        p_female1.setSelected(true);
                    }else{
                        p_male1.setSelected(false);
                        p_female1.setSelected(false);
                    }
                    p_address.setText("");
                    p_contact.setText("");
                    p_relation.setSelectedIndex(0);
                    r_name.setText("");
                    r_age.setText("");
                    if("Male".equals("relative_Gender")){
                        r_male.setSelected(true);
                    }
                    else if("Female".equals("relative_Gender")){
                        r_female.setSelected(true);
                    }else{
                        r_male.setSelected(false);
                        r_female.setSelected(false);
                    }
                    jTextArea8.setText("");
                    r_contact.setText("");
                    lblphoto.setIcon(null);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Error!! \nPlease Select Image...");
            }
            lbl_error.setText("");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void p_femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_femaleActionPerformed
        // TODO add your handling code here:
        Gender = "Female";
    }//GEN-LAST:event_p_femaleActionPerformed

    private void p_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_maleActionPerformed
        // TODO add your handling code here:
        Gender = "Male";
    }//GEN-LAST:event_p_maleActionPerformed

    private void p_ageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_ageKeyReleased

        String PATTERN = "^[0-9]{0,10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(p_age.getText());
        if(!match.matches()){
            lbl_error.setText("*Enter Number Only..!");
        }
        else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_p_ageKeyReleased

    private void p_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_nameKeyReleased
        String Pattern1 = "^[a-z A-Z]{0,25}$";
        Pattern pat = Pattern.compile(Pattern1);
        Matcher matc = pat.matcher(p_name.getText());
        if(!matc.matches()){
            lbl_error.setText("*Enter Character Only..!");
        }
        else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_p_nameKeyReleased

    private void p_addressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_addressKeyReleased

    }//GEN-LAST:event_p_addressKeyReleased

    private void p_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_contactKeyReleased
        String PATTERN = "^[0-9]{0,10}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(p_contact.getText());
        if(!match.matches()){
            lbl_error.setText("*Enter valid Number..!");
        }
        else{
            lbl_error.setText("");
        }
    }//GEN-LAST:event_p_contactKeyReleased

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        Patient_Update p = new Patient_Update();
        p.show();
        dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        Book_Appointment b = new Book_Appointment();
        b.show();
        dispose();
    }//GEN-LAST:event_jButton13ActionPerformed

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
            java.util.logging.Logger.getLogger(Doctors_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctors_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctors_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctors_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctors_Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup A_gender;
    private javax.swing.JTextField C_fees;
    private javax.swing.JTextField Doc_name;
    private javax.swing.ButtonGroup P_Gender;
    private javax.swing.ButtonGroup R_gender;
    private com.toedter.calendar.JDateChooser a_date;
    private javax.swing.JTextField a_id;
    private com.github.lgooddatepicker.components.TimePicker a_time;
    private javax.swing.JComboBox<String> cmb_doc_id;
    private javax.swing.JComboBox<String> cmb_filter;
    private javax.swing.JComboBox<String> cmb_filter1;
    private javax.swing.JComboBox<String> cmb_flter_list;
    private javax.swing.JComboBox<String> cmb_flter_list1;
    private javax.swing.JComboBox<String> cmb_specialist;
    private javax.swing.JTextField doc_mob;
    private javax.swing.ButtonGroup h_gender;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JLabel lbl_error;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lblphoto;
    private javax.swing.JLabel lbltime;
    private javax.swing.JTextArea p_address;
    private javax.swing.JTextArea p_address1;
    private javax.swing.JTextField p_age;
    private javax.swing.JTextField p_age1;
    private javax.swing.JTextField p_contact;
    private javax.swing.JRadioButton p_female;
    private javax.swing.JRadioButton p_female1;
    private javax.swing.JTextField p_id;
    private javax.swing.JTextField p_id1;
    private javax.swing.JRadioButton p_male;
    private javax.swing.JRadioButton p_male1;
    private javax.swing.JTextField p_mob;
    private javax.swing.JTextField p_name;
    private javax.swing.JComboBox<String> p_relation;
    private javax.swing.JComboBox<String> p_type;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField r_age;
    private javax.swing.JTextField r_contact;
    private javax.swing.JRadioButton r_female;
    private javax.swing.JRadioButton r_male;
    private javax.swing.JTextField r_name;
    // End of variables declaration//GEN-END:variables
    private String Gender,Relative_Gender,A_Gender,H_gender;
}
