/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;
import java.sql.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author APURAV SHARMA
 */
public class transfer extends javax.swing.JFrame {

    /**
     * Creates new form transfer
     */
    Connection con=null;
    Statement stmt = null,stmtcr = null,stmtdr = null; //USED FOR RUNNING COMMAND
    ResultSet rs = null,rt = null,rg = null;
    int otp,bal;//USED FOR STORING THE RECORDS WHICH COMES FROM TABLE
    PreparedStatement stat,stat2,statdr,statcr;
    String phone,phone1,secperson;//IF YOU WANT TO USE RUNTIME ERROR
    public transfer() {
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblbalance = new java.awt.Label();
        jPanel3 = new javax.swing.JPanel();
        lblbene = new javax.swing.JLabel();
        txtbene = new javax.swing.JTextField();
        lblamt = new javax.swing.JLabel();
        txtamt = new javax.swing.JTextField();
        lblpass = new javax.swing.JLabel();
        btntransfer = new java.awt.Button();
        txtpass = new javax.swing.JPasswordField();
        btnotp = new java.awt.Button();
        txtotp = new javax.swing.JTextField();
        lblotp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRANSFER PORTAL");
        setPreferredSize(new java.awt.Dimension(814, 606));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(31, 97, 141));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MONEY TRANSFER GATEWAY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(175, 214, 241));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblbalance.setAlignment(java.awt.Label.CENTER);
        lblbalance.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblbalance.setForeground(new java.awt.Color(0, 0, 0));
        lblbalance.setText("AVAILABLE BALANCE : "+userlogin.balance+" Rs");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblbalance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(175, 214, 241));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblbene.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblbene.setText("BENEFICIARY ACCOUNT NUMBER ");

        txtbene.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtbene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbeneActionPerformed(evt);
            }
        });
        txtbene.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbeneKeyPressed(evt);
            }
        });

        lblamt.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblamt.setText("AMOUNT TO BE TRANSFERRED");

        txtamt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtamtActionPerformed(evt);
            }
        });
        txtamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtamtKeyPressed(evt);
            }
        });

        lblpass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblpass.setText("PASSWORD");

        btntransfer.setBackground(new java.awt.Color(31, 97, 141));
        btntransfer.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btntransfer.setForeground(new java.awt.Color(255, 255, 255));
        btntransfer.setLabel("CONFIRM TRANSFER");
        btntransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntransferActionPerformed(evt);
            }
        });

        txtpass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });

        btnotp.setBackground(new java.awt.Color(31, 97, 141));
        btnotp.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnotp.setForeground(new java.awt.Color(255, 255, 255));
        btnotp.setLabel("GENERATE OTP");
        btnotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotpActionPerformed(evt);
            }
        });

        txtotp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtotp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtotpActionPerformed(evt);
            }
        });
        txtotp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtotpKeyPressed(evt);
            }
        });

        lblotp.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblotp.setText("ENTER OTP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnotp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btntransfer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblotp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtotp, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblbene)
                                    .addComponent(lblamt)
                                    .addComponent(lblpass))
                                .addGap(117, 117, 117)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtbene, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                    .addComponent(txtamt)
                                    .addComponent(txtpass, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbene)
                    .addComponent(txtbene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblamt)
                    .addComponent(txtamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpass)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnotp, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtotp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblotp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btntransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtamtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtamtActionPerformed

    private void btntransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntransferActionPerformed
        // TODO add your handling code here:
        if(txtbene.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(transfer.this, "Enter valid account number.");
            txtbene.grabFocus();
            return;
        }
        else if(txtamt.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(transfer.this, "Enter valid amount.");
            txtamt.grabFocus();
            return;
        }
        else if(txtpass.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(transfer.this, "Enter valid pass.");
            txtpass.grabFocus();
            return;
        }
        else if(txtotp.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(transfer.this, "Enter valid OTP.");
            txtotp.grabFocus();
            return;
        }
        else
        {
            if(Integer.parseInt(txtotp.getText())==otp)
            {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BANK;integratedSecurity=true";
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
                con = DriverManager.getConnection(url);
                int count = 0;
                Random rand = new Random();
                otp = rand.nextInt(999999);
                int bene = Integer.parseInt(txtbene.getText());
                int amt = Integer.parseInt(txtamt.getText());
                String pass = txtpass.getText();
                stmt = con.createStatement(); 
                rg = stmt.executeQuery("SELECT * FROM ACCNO");
                while(rg.next())
                {
                if(bene==rg.getInt("ACCOUNTNO"))
                {      
                count++;
                if(amt<userlogin.balance)
                {
                if(userlogin.password.equals(pass))
                {
                    userlogin.balance = userlogin.balance - amt;
                    options1.lblbalance.setText("AVAILABLE BALANCE : "+userlogin.balance+" Rs");
                    stat = con.prepareStatement("UPDATE ACCOUNTS SET BALANCE=? WHERE USERNAME = ?");
                    stat.setInt(1, userlogin.balance);
                    stat.setString(2, userlogin.user);
                    stat.executeUpdate();
                    rs = stmt.executeQuery("SELECT * FROM ACCNO");
                    while(rs.next())
                    {
                        if(bene==rs.getInt("ACCOUNTNO"))
                        {
                            phone1 = rs.getString("PHONE");
                        } 
                    }
                    rt = stmt.executeQuery("SELECT * FROM ACCOUNTS");
                    while(rt.next())
                    {
                        if(phone1.equals(rt.getString("PHONE")))
                        {
                            bal = rt.getInt("BALANCE");
                            secperson = rt.getString("USERNAME");
                        }
                    }
                    bal = bal+amt;
                    stat2 = con.prepareStatement("UPDATE ACCOUNTS SET BALANCE=? WHERE PHONE = ?");
                    stat2.setInt(1, bal);
                    stat2.setString(2, phone1);
                    stat2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Money successfully transferred !");
                    this.dispose();
                    statcr = con.prepareStatement("INSERT INTO "+userlogin.user+" VALUES(GETDATE(),?,?,?)");
                    statcr.setString(1,"DR");
                    statcr.setInt(3,amt);
                    statcr.setInt(2,bene);
                    statcr.executeUpdate();
                    statdr = con.prepareStatement("INSERT INTO "+secperson+" VALUES(GETDATE(),?,?,?)");
                    statdr.setString(1,"CR");
                    statdr.setInt(3,amt);
                    statdr.setInt(2,userlogin.account);
                    statdr.executeUpdate();
                    this.dispose();
                    try 
                    {
			// Construct data
			String apiKey = "apikey=" + "7OG1UqMorVE-ruQEkjc0RVRGqywGy4jtO3v1OTI8ai";
			String message = "&message=" + "Your account has been debited with Rs "+amt+".";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + userlogin.phone;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) 
                        {
				stringBuffer.append(line);
			}
			rd.close();
//			JOptionPane.showMessageDialog(null, "OTP is "+otp);
//                        JOptionPane.showMessageDialog(null, "OTP sent successfully !");
			//return stringBuffer.toString();
		    } 
                    catch (Exception e) 
                    {
			System.out.println("Error SMS "+e);
			//return "Error "+e;
		    }
                    try 
                    {
			// Construct data
			String apiKey = "apikey=" + "7OG1UqMorVE-ruQEkjc0RVRGqywGy4jtO3v1OTI8ai";
			String message = "&message=" + "Your account has been credited with Rs "+amt+".";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + phone1;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) 
                        {
				stringBuffer.append(line);
			}
			rd.close();
//			JOptionPane.showMessageDialog(null, "OTP is "+otp);
//                        JOptionPane.showMessageDialog(null, "OTP sent successfully !");
			//return stringBuffer.toString();
		    } 
                    catch (Exception e) 
                    {
			System.out.println("Error SMS "+e);
			//return "Error "+e;
		    }
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Password Incorrect !");
                    txtpass.setText("");
                }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Insufficient Funds !");
                    txtamt.setText("");
                }
                }
                }
                if(count==0)
                {
                    JOptionPane.showMessageDialog(null,"Invalid Account number !");
                    txtbene.setText("");
                }
                con.close();
            }
            catch(Exception m)
            {
                
            }
        }
            else
            {
               JOptionPane.showMessageDialog(null, "INVALID OTP ENTERED !"); 
               txtotp.setText("");
            } 
        }
    }//GEN-LAST:event_btntransferActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void txtbeneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbeneKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c))
        {
            txtbene.setEditable(false);
            JOptionPane.showMessageDialog(null, "Enter numeric value !");
            txtbene.setEditable(true);
        }
        else
        {
            txtbene.setEditable(true);
        }
        txtbene.setTransferHandler(null);
    }//GEN-LAST:event_txtbeneKeyPressed

    private void txtamtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtamtKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c))
        {
            txtamt.setEditable(false);
            JOptionPane.showMessageDialog(null, "Enter numeric value !");
            txtamt.setEditable(true);
        }
        else
        {
            txtamt.setEditable(true);
        }
        txtamt.setTransferHandler(null);
    }//GEN-LAST:event_txtamtKeyPressed

    private void txtbeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbeneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbeneActionPerformed

    private void txtotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtotpActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtotpActionPerformed

    private void btnotpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotpActionPerformed
        // TODO add your handling code here:
        Random rand = new Random();
        otp = rand.nextInt(999999);
        String phone = userlogin.phone;
        try 
                {
			// Construct data
			String apiKey = "apikey=" + "7OG1UqMorVE-ruQEkjc0RVRGqywGy4jtO3v1OTI8ai";
			String message = "&message=" + "Your OTP is "+otp;
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "91"+phone;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) 
                        {
				stringBuffer.append(line);
			}
			rd.close();
//			JOptionPane.showMessageDialog(null, "OTP is "+otp);
                        JOptionPane.showMessageDialog(null, "OTP sent successfully !");
			//return stringBuffer.toString();
		} 
                catch (Exception e) 
                {
			System.out.println("Error SMS "+e);
			//return "Error "+e;
		}
    }//GEN-LAST:event_btnotpActionPerformed

    private void txtotpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtotpKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c))
        {
            txtotp.setEditable(false);
            JOptionPane.showMessageDialog(null, "Enter numeric value !");
            txtotp.setEditable(true);
        }
        else
        {
            txtotp.setEditable(true);
        }
        txtotp.setTransferHandler(null);
    }//GEN-LAST:event_txtotpKeyPressed

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
            java.util.logging.Logger.getLogger(transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnotp;
    private java.awt.Button btntransfer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblamt;
    private java.awt.Label lblbalance;
    private javax.swing.JLabel lblbene;
    private javax.swing.JLabel lblotp;
    private javax.swing.JLabel lblpass;
    private javax.swing.JTextField txtamt;
    private javax.swing.JTextField txtbene;
    private javax.swing.JTextField txtotp;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}