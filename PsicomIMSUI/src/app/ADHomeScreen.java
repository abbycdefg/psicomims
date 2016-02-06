package app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class ADHomeScreen extends javax.swing.JFrame {

    /**
     * Creates new form ADHomeScreen
     */
    public ADHomeScreen() {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        signOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            Font originalFont = null;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                originalFont = signOutButton.getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                signOutButton.setFont(originalFont.deriveFont(attributes));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signOutButton.setFont(originalFont);
            }
        });
        
             searchField.addFocusListener(new FocusListener(){            
            @Override
            public void focusLost(FocusEvent arg0) {
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                searchField.setText("");
            }
        }); 
             
        
        
        searchField.addFocusListener(new FocusListener(){            
            @Override
            public void focusLost(FocusEvent arg0) {
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                searchField.setText("");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoLabel = new javax.swing.JLabel();
        greetingLabel = new javax.swing.JLabel();
        signOutButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        copyrightLabel1 = new javax.swing.JLabel();
        booksButton = new javax.swing.JButton();
        poButton = new javax.swing.JButton();
        joButton = new javax.swing.JButton();
        drButton = new javax.swing.JButton();
        dsButton = new javax.swing.JButton();
        histButton = new javax.swing.JButton();
        usersButton = new javax.swing.JButton();
        outletButton = new javax.swing.JButton();
        contactButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setResizable(false);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VS2.1.png"))); // NOI18N

        greetingLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        greetingLabel.setForeground(new java.awt.Color(255, 255, 255));
        greetingLabel.setText("Hello, Administrator  | ");

        signOutButton.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        signOutButton.setForeground(new java.awt.Color(255, 255, 255));
        signOutButton.setText("Sign Out");
        signOutButton.setBorder(null);
        signOutButton.setBorderPainted(false);
        signOutButton.setContentAreaFilled(false);
        signOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setText("   Search");
        searchField.setToolTipText("Search");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(205, 0, 69));
        searchButton.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_search.png"))); // NOI18N
        searchButton.setToolTipText("");
        searchButton.setAlignmentY(0.0F);
        searchButton.setBorder(null);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        searchButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/button_search2.png"))); // NOI18N
        searchButton.setRequestFocusEnabled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(227, 234, 245));
        mainPanel.setAlignmentX(0.0F);
        mainPanel.setAlignmentY(0.0F);

        copyrightLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel1.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel1.setText("© 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        booksButton.setBackground(new java.awt.Color(255, 255, 255));
        booksButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        booksButton.setForeground(new java.awt.Color(255, 255, 255));
        booksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_books.png"))); // NOI18N
        booksButton.setToolTipText("Books");
        booksButton.setAlignmentY(0.0F);
        booksButton.setBorder(null);
        booksButton.setBorderPainted(false);
        booksButton.setContentAreaFilled(false);
        booksButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        booksButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_books2.png"))); // NOI18N
        booksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksButtonActionPerformed(evt);
            }
        });

        poButton.setBackground(new java.awt.Color(255, 255, 255));
        poButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        poButton.setForeground(new java.awt.Color(255, 255, 255));
        poButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_po.png"))); // NOI18N
        poButton.setToolTipText("Books");
        poButton.setAlignmentY(0.0F);
        poButton.setBorder(null);
        poButton.setBorderPainted(false);
        poButton.setContentAreaFilled(false);
        poButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        poButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_po2.png"))); // NOI18N
        poButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poButtonActionPerformed(evt);
            }
        });

        joButton.setBackground(new java.awt.Color(255, 255, 255));
        joButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        joButton.setForeground(new java.awt.Color(255, 255, 255));
        joButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_jo.png"))); // NOI18N
        joButton.setToolTipText("Books");
        joButton.setAlignmentY(0.0F);
        joButton.setBorder(null);
        joButton.setBorderPainted(false);
        joButton.setContentAreaFilled(false);
        joButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        joButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_jo2.png"))); // NOI18N
        joButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButtonActionPerformed(evt);
            }
        });

        drButton.setBackground(new java.awt.Color(255, 255, 255));
        drButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        drButton.setForeground(new java.awt.Color(255, 255, 255));
        drButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_dr.png"))); // NOI18N
        drButton.setToolTipText("Books");
        drButton.setAlignmentY(0.0F);
        drButton.setBorder(null);
        drButton.setBorderPainted(false);
        drButton.setContentAreaFilled(false);
        drButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        drButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_dr2.png"))); // NOI18N
        drButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drButtonActionPerformed(evt);
            }
        });

        dsButton.setBackground(new java.awt.Color(255, 255, 255));
        dsButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        dsButton.setForeground(new java.awt.Color(255, 255, 255));
        dsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_ds.png"))); // NOI18N
        dsButton.setToolTipText("Books");
        dsButton.setAlignmentY(0.0F);
        dsButton.setBorder(null);
        dsButton.setBorderPainted(false);
        dsButton.setContentAreaFilled(false);
        dsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dsButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_ds2.png"))); // NOI18N
        dsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsButtonActionPerformed(evt);
            }
        });

        histButton.setBackground(new java.awt.Color(255, 255, 255));
        histButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        histButton.setForeground(new java.awt.Color(255, 255, 255));
        histButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_hist.png"))); // NOI18N
        histButton.setToolTipText("Books");
        histButton.setAlignmentY(0.0F);
        histButton.setBorder(null);
        histButton.setBorderPainted(false);
        histButton.setContentAreaFilled(false);
        histButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        histButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_hist2.png"))); // NOI18N
        histButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                histButtonActionPerformed(evt);
            }
        });

        usersButton.setBackground(new java.awt.Color(255, 255, 255));
        usersButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        usersButton.setForeground(new java.awt.Color(255, 255, 255));
        usersButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_users.png"))); // NOI18N
        usersButton.setToolTipText("Books");
        usersButton.setAlignmentY(0.0F);
        usersButton.setBorder(null);
        usersButton.setBorderPainted(false);
        usersButton.setContentAreaFilled(false);
        usersButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_users2.png"))); // NOI18N
        usersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersButtonActionPerformed(evt);
            }
        });

        outletButton.setBackground(new java.awt.Color(255, 255, 255));
        outletButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        outletButton.setForeground(new java.awt.Color(255, 255, 255));
        outletButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_outlets.png"))); // NOI18N
        outletButton.setToolTipText("Books");
        outletButton.setAlignmentY(0.0F);
        outletButton.setBorder(null);
        outletButton.setBorderPainted(false);
        outletButton.setContentAreaFilled(false);
        outletButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        outletButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_outlets2.png"))); // NOI18N
        outletButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outletButtonActionPerformed(evt);
            }
        });

        contactButton.setBackground(new java.awt.Color(255, 255, 255));
        contactButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        contactButton.setForeground(new java.awt.Color(255, 255, 255));
        contactButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_contacts.png"))); // NOI18N
        contactButton.setToolTipText("Books");
        contactButton.setAlignmentY(0.0F);
        contactButton.setBorder(null);
        contactButton.setBorderPainted(false);
        contactButton.setContentAreaFilled(false);
        contactButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contactButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_contacts2.png"))); // NOI18N
        contactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(copyrightLabel1))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(booksButton)
                        .addGap(18, 18, 18)
                        .addComponent(poButton)
                        .addGap(18, 18, 18)
                        .addComponent(joButton)
                        .addGap(18, 18, 18)
                        .addComponent(drButton)
                        .addGap(18, 18, 18)
                        .addComponent(dsButton))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(histButton)
                        .addGap(30, 30, 30)
                        .addComponent(usersButton)
                        .addGap(30, 30, 30)
                        .addComponent(outletButton)
                        .addGap(30, 30, 30)
                        .addComponent(contactButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(booksButton)
                    .addComponent(poButton)
                    .addComponent(joButton)
                    .addComponent(drButton)
                    .addComponent(dsButton))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(histButton)
                    .addComponent(usersButton)
                    .addComponent(outletButton)
                    .addComponent(contactButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(copyrightLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 497, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(greetingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signOutButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(signOutButton)
                            .addComponent(greetingLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))))
                .addGap(18, 18, 18)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void booksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_booksButtonActionPerformed

    private void poButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_poButtonActionPerformed

    private void joButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joButtonActionPerformed

    private void drButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drButtonActionPerformed

    private void dsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dsButtonActionPerformed

    private void histButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_histButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_histButtonActionPerformed

    private void usersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersButtonActionPerformed
    	this.dispose();
    	ADUsersTab a = new ADUsersTab();
    	a.setVisible(true);
    }//GEN-LAST:event_usersButtonActionPerformed

    private void outletButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outletButtonActionPerformed
    	this.dispose();
    	ADOutletsTab a = new ADOutletsTab();
    	a.setVisible(true);
    }//GEN-LAST:event_outletButtonActionPerformed

    private void contactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactButtonActionPerformed
    	this.dispose();
    	ADContactPersonsTab a = new ADContactPersonsTab();
    	a.setVisible(true);
    }//GEN-LAST:event_contactButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ADHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ADHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ADHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ADHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ADHomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton booksButton;
    private javax.swing.JButton contactButton;
    private javax.swing.JLabel copyrightLabel1;
    private javax.swing.JButton drButton;
    private javax.swing.JButton dsButton;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JButton histButton;
    private javax.swing.JButton joButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton outletButton;
    private javax.swing.JButton poButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton signOutButton;
    private javax.swing.JButton usersButton;
    // End of variables declaration//GEN-END:variables
}
