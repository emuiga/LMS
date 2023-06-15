/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import static JFrame.DBConnection.con;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.util.Date;

/**
 *
 * @author muiga
 */
public class ViewRecords extends javax.swing.JFrame {

    /**
     * Creates new form ViewRecords
     */
    DefaultTableModel model;
    public ViewRecords() {
        initComponents();
        issuePatronDetails();
    }

    public void issuePatronDetails(){
        try {
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
                model =(DefaultTableModel) tbl_recorddetails.getModel();//typecast
                model.addRow(obj);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void clearTable(){
        DefaultTableModel model= (DefaultTableModel) tbl_recorddetails.getModel();
        model.setRowCount(0);
    }
    
    //fetch record
    public void search(){
        Date uFromDate = date_fromDate.getDate();
        Date uToDate = date_fromDate.getDate();
        
        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();
        
        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
            PreparedStatement prepst = con.prepareStatement(sql);
            
            prepst.setDate(1, fromDate);
            prepst.setDate(2, toDate);
            
            ResultSet rs = prepst.executeQuery();
            if (rs.next() == false){
                JOptionPane.showMessageDialog(this,"No record found");
            }else{
                while(rs.next()){
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String patronName = rs.getString("patron_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                
                Object[] obj = {id,bookName,patronName,issueDate,dueDate,status};
                model =(DefaultTableModel) tbl_recorddetails.getModel();//typecast
                model.addRow(obj);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
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
        jLabel12 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        date_fromDate = new com.toedter.calendar.JDateChooser();
        date_toDate1 = new com.toedter.calendar.JDateChooser();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_recorddetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1180, 700));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText(" View Records");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, 50));
        jPanel1.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 350, 5));

        jLabel21.setBackground(new java.awt.Color(255, 153, 51));
        jLabel21.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 153, 51));
        jLabel21.setText("  Issue Date :");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 120, -1));

        jLabel19.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 51));
        jLabel19.setText("  Due Date :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 130, -1));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle1.setText("SEARCH");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 230, 170, 50));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("   Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 153, 51));
        jLabel17.setText("  X");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 40, -1));

        date_fromDate.setBackground(new java.awt.Color(255, 153, 51));
        date_fromDate.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 220, 40));

        date_toDate1.setBackground(new java.awt.Color(255, 153, 51));
        date_toDate1.setDateFormatString("dd/MM/yy");
        jPanel1.add(date_toDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 220, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 280));

        tbl_recorddetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Patron Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_recorddetails.setColorBackgoundHead(new java.awt.Color(0, 0, 0));
        tbl_recorddetails.setColorBordeHead(new java.awt.Color(255, 153, 51));
        tbl_recorddetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_recorddetails.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_recorddetails.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_recorddetails.setColorForegroundHead(new java.awt.Color(255, 153, 51));
        tbl_recorddetails.setColorSelBackgound(new java.awt.Color(102, 0, 102));
        tbl_recorddetails.setColorSelForeground(new java.awt.Color(255, 153, 51));
        tbl_recorddetails.setRowHeight(40);
        tbl_recorddetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_recorddetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_recorddetails);

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_tableLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tableLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 201, Short.MAX_VALUE))
        );

        getContentPane().add(panel_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 280, 1160, 620));

        setSize(new java.awt.Dimension(1180, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_recorddetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_recorddetailsMouseClicked
//        int rowNumber = tbl_recorddetails.getSelectedRow();
//        TableModel model = tbl_recorddetails.getModel();

//        var_bookid.setText(model.getValueAt(rowNumber, 0).toString());
//        var_bookname.setText(model.getValueAt(rowNumber, 1).toString());
//        var_author.setText(model.getValueAt(rowNumber, 2).toString());
//        var_copies.setText(model.getValueAt(rowNumber, 3).toString());
    }//GEN-LAST:event_tbl_recorddetailsMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
        clearTable();
        search();
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRecords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRecords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser date_fromDate;
    private com.toedter.calendar.JDateChooser date_toDate1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_table;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojeru_san.complementos.RSTableMetro tbl_recorddetails;
    // End of variables declaration//GEN-END:variables
}
