/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author APURAV SHARMA
 */
public class changepass extends javax.swing.JFrame {

    /**
     * Creates new form changepass
     */
     Connection con=null;
    Statement stmt = null; //USED FOR RUNNING COMMAND
    ResultSet rs = null;  //USED FOR STORING THE RECORDS WHICH COMES FROM TABLE
    PreparedStatement stat;
    public changepass() {
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

        jPanel1 = new javax.swing.JPanel();
        lblheading = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbloldpass = new javax.swing.JLabel();
        lblpass = new javax.swing.JLabel();
        lblpass1 = new javax.swing.JLabel();
        btnconfirm = new java.awt.Button();
        txtpass = new javax.swing.JPasswordField();
        txtpass1 = new javax.swing.JPasswordField();
        txtoldpass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CHANGE PASSWORD");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(31, 97, 141));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblheading.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        lblheading.setForeground(new java.awt.Color(255, 255, 255));
        lblheading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblheading.setText("CHANGE PASSWORD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblheading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(lblheading)
                .addGap(39, 39, 39))
        );

        jPanel2.setBackground(new java.awt.Color(175, 214, 241));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbloldpass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lbloldpass.setText("OLD PASSWORD");

        lblpass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblpass.setText("NEW PASSWORD");

        lblpass1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblpass1.setText("CONFIRM PASSWORD");

        btnconfirm.setBackground(new java.awt.Color(31, 97, 141));
        btnconfirm.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        btnconfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnconfirm.setLabel("CONFIRM");
        btnconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconfirmActionPerformed(evt);
            }
        });

        txtpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        txtpass1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtpass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpass1KeyPressed(evt);
            }
        });

        txtoldpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtoldpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtoldpassActionPerformed(evt);
            }
        });
        txtoldpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtoldpassKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbloldpass)
                    .addComponent(lblpass1)
                    .addComponent(lblpass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtpass)
                    .addComponent(txtpass1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(txtoldpass))
                .addGap(115, 115, 115))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(336, Short.MAX_VALUE)
                .addComponent(btnconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbloldpass)
                    .addComponent(txtoldpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpass)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpass1)
                    .addComponent(txtpass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnconfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconfirmActionPerformed
        // TODO add your handling code here:
        if(txtoldpass.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(changepass.this, "Enter valid OTP.");
            txtoldpass.grabFocus();
            return;
        }
        else if(txtpass.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(changepass.this, "Enter valid password.");
            txtpass.grabFocus();
            return;
        }
        else if(txtpass1.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(changepass.this, "Enter valid password.");
            txtpass1.grabFocus();
            return;
        }
        else
        {
            String oldpass = txtoldpass.getText();
            String pass = txtpass.getText();
            String pass1 = txtpass1.getText();
            if((userlogin.password).equals(oldpass))
                {
                    if((pass.equals(pass1)) && (oldpass == null ? (pass) != null : !oldpass.equals(pass)) && (oldpass == null ? (pass1) != null : !oldpass.equals(pass1)))
                       {
                           String url = "jdbc:sqlserver://localhost:1433;databaseName=BANK;integratedSecurity=true";
                           try
                           {
                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                con = DriverManager.getConnection(url);
                                stat = con.prepareStatement("UPDATE ACCOUNTS SET PASSWORD=? WHERE USERNAME = ?");
                                stat.setString(1, pass);
                                stat.setString(2, userlogin.user);
                                txtpass.setText("");
                                txtpass1.setText("");
                                txtoldpass.setText("");
                                stat.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Password changed successfully !");
                                this.dispose();
                                new options1().dispose();
                                new userlogin().setVisible(true);
                                con.close();
                           }
                           catch(Exception m)
                           {
                               System.out.println(m.getMessage());
                           }
                       }
                    else if(pass.equals(oldpass) || pass1.equals(oldpass))
                    {
                        JOptionPane.showMessageDialog(null, "OLD AND NEW PASSWORD CAN'T BE SAME !");
                        txtoldpass.setText("");
                        txtpass.setText("");
                        txtpass1.setText("");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Entered password isn't same !");
                        txtpass.setText("");
                        txtpass1.setText("");
                    }
                }
            else
            {
                JOptionPane.showMessageDialog(null, "Old Password doesn't matches !");
                txtoldpass.setText("");
                txtpass.setText("");
                txtpass1.setText("");
            }   
        }
    }//GEN-LAST:event_btnconfirmActionPerformed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isWhitespace(c))
        {
            txtpass.setEditable(false);
            JOptionPane.showMessageDialog(null, "No spaces !");
            txtpass.setEditable(true);
        }
        else
        {
            txtpass.setEditable(true);
        }
        txtpass.setTransferHandler(null);
    }//GEN-LAST:event_txtpassKeyPressed

    private void txtpass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpass1KeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isWhitespace(c))
        {
            txtpass1.setEditable(false);
            JOptionPane.showMessageDialog(null, "No spaces !");
            txtpass1.setEditable(true);
        }
        else
        {
            txtpass1.setEditable(true);
        }
        txtpass1.setTransferHandler(null);
    }//GEN-LAST:event_txtpass1KeyPressed

    private void txtoldpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtoldpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtoldpassActionPerformed

    private void txtoldpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtoldpassKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isWhitespace(c))
        {
            txtoldpass.setEditable(false);
            JOptionPane.showMessageDialog(null, "No spaces !");
            txtoldpass.setEditable(true);
        }
        else
        {
            txtoldpass.setEditable(true);
        }
        txtoldpass.setTransferHandler(null);
    }//GEN-LAST:event_txtoldpassKeyPressed

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
            java.util.logging.Logger.getLogger(changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changepass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnconfirm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblheading;
    private javax.swing.JLabel lbloldpass;
    private javax.swing.JLabel lblpass;
    private javax.swing.JLabel lblpass1;
    private javax.swing.JPasswordField txtoldpass;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpass1;
    // End of variables declaration//GEN-END:variables
}
