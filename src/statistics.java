import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import singleton.singletonConnection;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author guest_acc
 */
public class statistics extends javax.swing.JFrame {

    /**
     * Creates new form statistics
     */
    public statistics() {
        initComponents();
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(325, 125));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Issue Details");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 6, -1, -1));

        jTable1.setBackground(new java.awt.Color(255, 255, 153));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Book ID", "Book Name", "Isuue Date", "Due Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 680, 146));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Return Details");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        jTable2.setBackground(new java.awt.Color(255, 255, 153));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Book ID", "Book Name", "Issue Date", "Due Date"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 680, 159));

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/red-x-mark-transparent-background-3.png"))); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/123456.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            Connection conn = singletonConnection.getCon();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select issue.studentID, student.name, issue.bookID, book.name, issue.issueDate, issue.dueDate from student inner join book inner join issue where book.bookID=issue.bookID and student.studentID=issue.studentID and issue.returnBook='NO'");
            //jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            int rc = df.getRowCount();
            for (int i = 0; i < rc; i++) {
                df.removeRow(0);
            }
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("issue.studentID"));
                v.add(rs.getString("student.name"));
                v.add(rs.getString("issue.bookID"));
                v.add(rs.getString("book.name"));
                v.add(rs.getString("issue.issueDate"));
                v.add(rs.getString("issue.dueDate"));

                df.addRow(v);
            }
            
               ResultSet rs1 = st.executeQuery("select issue.studentID, student.name, issue.bookID, book.name, issue.issueDate, issue.dueDate from student inner join book inner join issue where book.bookID=issue.bookID and student.studentID=issue.studentID and issue.returnBook='Yes'");
            //jTable2.setModel(DbUtils.resultSetToTableModel(rs1));                       //DbUtils.resultSetToTableModel(rs) is used to convert the data retrieved in a ResultSet (which is the result of a SQL query) into a format that can be displayed in a JTable in a Java Swing application.

            DefaultTableModel df2 = (DefaultTableModel) jTable2.getModel();
            int rc2 = df2.getRowCount();
            for (int i = 0; i < rc2; i++) {
                df2.removeRow(0);
            }
            while (rs1.next()) {
                Vector v = new Vector();
                v.add(rs1.getString("issue.studentID"));
                v.add(rs1.getString("student.name"));
                v.add(rs1.getString("issue.bookID"));
                v.add(rs1.getString("book.name"));
                v.add(rs1.getString("issue.issueDate"));
                v.add(rs1.getString("issue.dueDate"));

                df2.addRow(v);
            }
        } catch (Exception e) {                                                           //DbUtils.resultSetToTableModel(rs) is a method that converts a ResultSet from a database query into a TableModel that can be used to display data in a JTable.
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(statistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new statistics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
