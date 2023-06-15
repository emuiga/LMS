/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import static JFrame.DBConnection.con;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author muiga
 */
public class ReturnBook extends javax.swing.JFrame {


    /**
     * Creates new form ReturnBook
     */
    
    DefaultTableModel model;
    public ReturnBook() {
        initComponents();
    }
    
    //fetch issue book details
    public void getIssueBookDetails(){

        int bookId = Integer.parseInt(var_bookId.getText());
        int patronId = Integer.parseInt(var_patronId.getText());
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nca_lmsdb","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");
            
            while(rs.next()){
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String patronName = rs.getString("patron_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                Object[] obj = {id,bookName,patronName,issueDate,dueDate,status};
                model =(DefaultTableModel) tbl_returnbooktable.getModel();//typecast
                model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
//    public void issuePatronDetails(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nca_lmsdb","root","");
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from issue_book_details");
//            
//            while(rs.next()){
//                String id = rs.getString("id");
//                String bookName = rs.getString("book_name");
//                String patronName = rs.getString("patron_name");
//                String issueDate = rs.getString("issue_date");
//                String dueDate = rs.getString("due_date");
//                String status = rs.getString("status");
//                
//                Object[] obj = {id,bookName,patronName,issueDate,dueDate,status};
//                DefaultTableModel model = (DefaultTableModel) tbl_returnbooktable.getModel(); //typecast
//                model.addRow(obj);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    
    //book return
    public boolean returnBook(){
        boolean isReturned = false;
        int bookId = Integer.parseInt(var_bookId.getText());
        int patronId = Integer.parseInt(var_patronId.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set status = ? where patronId = ? and book_id = ? and status = ?";
            PreparedStatement prepst = con.prepareStatement(sql);
            prepst.setString(1, "returned");
            prepst.setInt(2,patronId);
            prepst.setInt(3, bookId);
            prepst.setString(4, "pending");
            
            int rowCount = prepst.executeUpdate();
            if (rowCount > 0){
                isReturned = true;
            }else{
                isReturned = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return isReturned;
    }
    
    //update book count
//    public void updateBookCount(){
//        int bookId = Integer.parseInt(var_bookId.getText());
//        try {
//            Connection con = DBConnection.getConnection();
//            String sql = "update book_details set quantity = quantity +1 where book_id = ?";
//            PreparedStatement prepst = con.prepareStatement(sql);
//            prepst.setInt(1, bookId);
//            
//            
//            int rowCount = prepst.executeUpdate();
//            if (rowCount > 0) {
//                JOptionPane.showMessageDialog(this,"Book Count Updated");
//                updateBookCount();
//            }else{
//                JOptionPane.showMessageDialog(this,"Can't Update Book Count");
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
        
//    public void reset()
//    {
//        bookId.setEnabled(true);
//        jTextField10.setEnabled(true);
//        bookId.setText("");
//        jTextField2.setText("");
//        jTextField3.setText("");
//        
//        jTextField5.setText("");
//        jTextField6.setText("");
//        jTextField7.setText("");
//        jTextField8.setText("");
////        jTextField15.setText("");
//        jTextField10.setText("");
//        jTextField11.setText("");
//        jTextField12.setText("");
//        jTextField13.setText("");
//        jTextField14.setText("");
//        jDateChooser1.setCalendar(null);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_bookError = new javax.swing.JLabel();
        panel_main = new javax.swing.JPanel();
        lbl_branch1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        var_patronId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        var_bookId = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar4 = new javax.swing.JProgressBar();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_returnbooktable = new rojeru_san.complementos.RSTableMetro();

        lbl_bookError.setFont(new java.awt.Font("Georgia", 0, 17)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 153, 51));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1180, 700));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setMinimumSize(new java.awt.Dimension(1180, 700));
        panel_main.setPreferredSize(new java.awt.Dimension(1180, 700));
        panel_main.setRequestFocusEnabled(false);
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)
        );

        lbl_branch1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 153, 51));
        rSMaterialButtonCircle1.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle1.setText("RETURN BOOK");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        lbl_branch1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 290, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 153, 51));
        rSMaterialButtonCircle2.setForeground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle2.setText("FIND");
        rSMaterialButtonCircle2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        lbl_branch1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 290, 70));

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
        lbl_branch1.add(var_patronId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 220, -1));

        jLabel9.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel9.setText("    Patron ID  :");
        lbl_branch1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 130, -1));

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel20.setText("    Book ID  :");
        lbl_branch1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 130, -1));

        var_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 102, 0)));
        var_bookId.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        var_bookId.setPhColor(new java.awt.Color(0, 102, 0));
        var_bookId.setPlaceholder("Book Id...");
        var_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                var_bookIdFocusLost(evt);
            }
        });
        var_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                var_bookIdActionPerformed(evt);
            }
        });
        var_bookId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                var_bookIdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                var_bookIdKeyTyped(evt);
            }
        });
        lbl_branch1.add(var_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 220, -1));

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel8.setText("  Return Book");
        lbl_branch1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jProgressBar4.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar4.setForeground(new java.awt.Color(0, 0, 0));
        lbl_branch1.add(jProgressBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 310, -1));

        panel_main.add(lbl_branch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 700));

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 153, 51));
        jLabel18.setText("   X");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 10, 40, -1));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 51));
        jLabel13.setText(" X");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        panel_main.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 30, 40));

        jLabel12.setFont(new java.awt.Font("Georgia", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 51));
        jLabel12.setText("Book Details");
        panel_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, -1, 50));

        jProgressBar2.setBackground(new java.awt.Color(255, 153, 51));
        panel_main.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 310, -1));

        tbl_returnbooktable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Issue ID", "Book ID", "Patron ID", "Issued Date", "Due Date"
            }
        ));
        tbl_returnbooktable.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        tbl_returnbooktable.setColorBordeFilas(new java.awt.Color(255, 153, 51));
        tbl_returnbooktable.setColorBordeHead(new java.awt.Color(255, 153, 51));
        tbl_returnbooktable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_returnbooktable.setColorFilasForeground1(new java.awt.Color(255, 153, 51));
        tbl_returnbooktable.setColorFilasForeground2(new java.awt.Color(255, 153, 51));
        tbl_returnbooktable.setColorSelBackgound(new java.awt.Color(0, 153, 51));
        tbl_returnbooktable.setPreferredSize(new java.awt.Dimension(300, 0));
        tbl_returnbooktable.setRowHeight(40);
        jScrollPane1.setViewportView(tbl_returnbooktable);
        if (tbl_returnbooktable.getColumnModel().getColumnCount() > 0) {
            tbl_returnbooktable.getColumnModel().getColumn(0).setHeaderValue("Issue ID");
            tbl_returnbooktable.getColumnModel().getColumn(1).setHeaderValue("Book ID");
            tbl_returnbooktable.getColumnModel().getColumn(2).setHeaderValue("Patron ID");
            tbl_returnbooktable.getColumnModel().getColumn(3).setHeaderValue("Issued Date");
            tbl_returnbooktable.getColumnModel().getColumn(4).setHeaderValue("Due Date");
        }

        panel_main.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 770, 470));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 700));

        setSize(new java.awt.Dimension(1164, 767));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void var_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_var_bookIdFocusLost

    }//GEN-LAST:event_var_bookIdFocusLost

    private void var_patronIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_var_patronIdFocusLost
        
    }//GEN-LAST:event_var_patronIdFocusLost

    private void var_patronIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_var_patronIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_var_patronIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
if(returnBook() == true){
    JOptionPane.showMessageDialog(this,"Book returned");
    
}else{
    JOptionPane.showMessageDialog(this,"Return Record Failed");

}
        
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void var_bookIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_var_bookIdKeyTyped
         
    }//GEN-LAST:event_var_bookIdKeyTyped

    private void var_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_var_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_var_bookIdActionPerformed

    private void var_bookIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_var_bookIdKeyReleased
        // TODO add your handling code here:
        String books=var_bookId.getText();
        String sql = "Select * from issue_book_details where book_id ='"+books+"'";
                try{
                    PreparedStatement prepst = con.prepareStatement(sql);
                     ResultSet rs=prepst.executeQuery();
                     tbl_returnbooktable.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e){
                    e.printStackTrace();
                }
    }//GEN-LAST:event_var_bookIdKeyReleased

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JPanel lbl_branch1;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojeru_san.complementos.RSTableMetro tbl_returnbooktable;
    private app.bolivia.swing.JCTextField var_bookId;
    private app.bolivia.swing.JCTextField var_patronId;
    // End of variables declaration//GEN-END:variables
}
