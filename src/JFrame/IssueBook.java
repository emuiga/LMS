/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author muiga
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    //fetch book details from book details table and display
    public void getBookDetails(){
        int book_id = Integer.parseInt(var_bookId.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            
            PreparedStatement prepst = con.prepareStatement("select * from book_details where book_id = ?");
            prepst.setInt(1, book_id);
            ResultSet rs = prepst.executeQuery();
            
            if(rs.next()){
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("book_author"));
                lbl_quantity.setText(rs.getString("quantity"));
            }else{
                lbl_bookError.setText("Invalid Book ID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void getPatronDetails(){
        int patronId = Integer.parseInt(var_patronId.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            
            PreparedStatement prepst = con.prepareStatement("select * from patron_details where patronId = ?");
            prepst.setInt(1, patronId);
            ResultSet rs = prepst.executeQuery();
            
            if(rs.next()){
                lbl_patronId.setText(rs.getString("patronId"));
                lbl_patronName.setText(rs.getString("patron_name"));
                lbl_contact.setText(rs.getString("contact"));
                lbl_position.setText(rs.getString("position"));
            }else{
                lbl_patronError.setText("Invalid Patron ID");
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    public boolean issueBook(){
        boolean isIssued = false;
        int bookId =Integer.parseInt(var_bookId.getText());
        int patronId =Integer.parseInt(var_patronId.getText());
        String book_name =lbl_bookName.getText();
        String patron_name =lbl_patronName.getText();
        
        Date uIssueDate = date_returnDate.getDate();
        Date uDueDate = date_returnDate.getDate();
        
        Long l1 = uIssueDate.getTime();
        long l2 = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);

        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,patronId,patron_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
            PreparedStatement prepst = con.prepareStatement(sql);
            prepst.setInt(1, bookId);
            prepst.setString(2,book_name);
            prepst.setInt(3, patronId);
            prepst.setString(4,patron_name);
            prepst.setDate(5,sIssueDate);
            prepst.setDate(6,sDueDate);
            prepst.setString(7,"pending");
            
            int rowCount = prepst.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            }else{
                isIssued = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isIssued;
    }
    
    //update book count
    public void updateBookCount(){
        int bookId = Integer.parseInt(var_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity - 1 where book_id = ?";
            PreparedStatement prepst = con.prepareStatement(sql);
            prepst.setInt(1, bookId);
            
            
            int rowCount = prepst.executeUpdate();
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this,"Book Count Updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
            }else{
                JOptionPane.showMessageDialog(this,"Can't Update Book Count");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
    //check whether book already allocated
    public boolean alreadyIssued(){
        boolean isAlreadyIssued = false;
        int bookId =Integer.parseInt(var_bookId.getText());
        int patronId =Integer.parseInt(var_patronId.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and patronId = ? and status = ?";
            PreparedStatement prepst = con.prepareStatement(sql);
            prepst.setInt(1,bookId);
            prepst.setInt(2,patronId);
            prepst.setString(3,"pending");
            
            ResultSet rs = prepst.executeQuery();
            
            if (rs.next()){
                isAlreadyIssued = true;
            }else{
                isAlreadyIssued = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        lbl_branch = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        lbl_position = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_patronId = new javax.swing.JLabel();
        lbl_patronName = new javax.swing.JLabel();
        lbl_contact = new javax.swing.JLabel();
        lbl_patronError = new javax.swing.JLabel();
        lbl_branch1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        lbl_bookError = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        var_bookId = new app.bolivia.swing.JCTextField();
        var_patronId = new app.bolivia.swing.JCTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jLabel18 = new javax.swing.JLabel();
        date_returnDate = new com.toedter.calendar.JDateChooser();
        date_issueDate1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1180, 700));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setMinimumSize(new java.awt.Dimension(1180, 700));
        panel_main.setPreferredSize(new java.awt.Dimension(1180, 700));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_branch.setBackground(new java.awt.Color(0, 102, 0));
        lbl_branch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel1.setText(" Patron Details");
        lbl_branch.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 40));
        lbl_branch.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 310, -1));

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setText(" Position :");
        lbl_branch.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, 30));

        lbl_position.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        lbl_branch.add(lbl_position, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 200, 30));

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 51));
        jLabel5.setText("    Patron Name :");
        lbl_branch.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, 30));

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText(" Contact  :");
        lbl_branch.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 30));

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 51));
        jLabel7.setText("    Patron Id :");
        lbl_branch.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 30));

        lbl_patronId.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        lbl_branch.add(lbl_patronId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 200, 30));

        lbl_patronName.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        lbl_branch.add(lbl_patronName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 200, 30));

        lbl_contact.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        lbl_branch.add(lbl_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 200, 30));

        lbl_patronError.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lbl_patronError.setForeground(new java.awt.Color(255, 153, 51));
        lbl_patronError.setText(" ");
        lbl_branch.add(lbl_patronError, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 200, 30));

        panel_main.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 370, 800));

        lbl_branch1.setBackground(new java.awt.Color(0, 102, 0));
        lbl_branch1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 51));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel11.setText("   Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        lbl_branch1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jLabel12.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText(" Book Details");
        lbl_branch1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 30));
        lbl_branch1.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 310, -1));

        lbl_bookError.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 153, 51));
        lbl_branch1.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 120, 30));

        lbl_quantity.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        lbl_branch1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 200, 30));

        jLabel15.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 51));
        jLabel15.setText("    Book Name :");
        lbl_branch1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 30));

        jLabel16.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 153, 51));
        jLabel16.setText(" Author  :");
        lbl_branch1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, 30));

        jLabel17.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 51));
        jLabel17.setText("   Book Id :");
        lbl_branch1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        lbl_bookId.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        lbl_branch1.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 200, 30));

        lbl_bookName.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        lbl_branch1.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 200, 30));

        lbl_author.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        lbl_branch1.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 200, 30));

        jLabel22.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 153, 51));
        jLabel22.setText(" Quantity :");
        lbl_branch1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));
        jPanel1.setMinimumSize(new java.awt.Dimension(5, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(40, 700));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        lbl_branch1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 10, -1));

        panel_main.add(lbl_branch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 800));

        jProgressBar4.setBackground(new java.awt.Color(0, 102, 0));
        jProgressBar4.setForeground(new java.awt.Color(0, 102, 0));
        panel_main.add(jProgressBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 310, -1));

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel8.setText("  Issue Book");
        panel_main.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        panel_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 0));
        jLabel9.setText("    Patron ID  :");
        panel_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 350, 130, -1));

        jLabel19.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 0));
        jLabel19.setText("  Due Date :");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 110, 20));

        var_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 0)));
        var_bookId.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        var_bookId.setPhColor(new java.awt.Color(0, 102, 0));
        var_bookId.setPlaceholder("Book Id...");
        var_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                var_bookIdFocusLost(evt);
            }
        });
        panel_main.add(var_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 270, 220, -1));

        var_patronId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 0)));
        var_patronId.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        var_patronId.setPhColor(new java.awt.Color(0, 102, 0));
        var_patronId.setPlaceholder("Patron Id...");
        var_patronId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                var_patronIdFocusLost(evt);
            }
        });
        var_patronId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                var_patronIdActionPerformed(evt);
            }
        });
        panel_main.add(var_patronId, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, 220, -1));

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setText("    Book ID  :");
        panel_main.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 120, -1));

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 0));
        jLabel21.setText("  Issue Date :");
        panel_main.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 420, 130, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 153, 51));
        rSMaterialButtonCircle1.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle1.setText("ISSUE BOOK");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 560, 290, 70));

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 153, 51));
        jLabel18.setText("   X");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 40, -1));

        date_returnDate.setForeground(new java.awt.Color(0, 102, 0));
        panel_main.add(date_returnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 210, 30));

        date_issueDate1.setForeground(new java.awt.Color(0, 102, 0));
        panel_main.add(date_issueDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 420, 210, 30));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 800));

        setSize(new java.awt.Dimension(1180, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed

        if (lbl_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Book Unavailable");
        } else {
            if (alreadyIssued() == false) {

                if (issueBook() == true) {
                    JOptionPane.showMessageDialog(this, "Book Issued");
                    updateBookCount();
                } else {
                    JOptionPane.showMessageDialog(this, "Book Issue Failed");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Patron Already Has The Book");
            }

        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void var_patronIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_var_patronIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_var_patronIdActionPerformed

    private void var_patronIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_var_patronIdFocusLost
        if (!var_patronId.getText().equals("")){
        getPatronDetails();
        }
    }//GEN-LAST:event_var_patronIdFocusLost

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void var_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_var_bookIdFocusLost
        if (!var_bookId.getText().equals("")){
        getBookDetails();
        }
    }//GEN-LAST:event_var_bookIdFocusLost

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date_issueDate1;
    private com.toedter.calendar.JDateChooser date_returnDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JPanel lbl_branch;
    private javax.swing.JPanel lbl_branch1;
    private javax.swing.JLabel lbl_contact;
    private javax.swing.JLabel lbl_patronError;
    private javax.swing.JLabel lbl_patronId;
    private javax.swing.JLabel lbl_patronName;
    private javax.swing.JLabel lbl_position;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField var_bookId;
    private app.bolivia.swing.JCTextField var_patronId;
    // End of variables declaration//GEN-END:variables
}
