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
public class WCHomeScreen extends javax.swing.JFrame {

    /**
     * Creates new form WCHomeScreen
     */
    public WCHomeScreen() {
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
        mainPanel = new javax.swing.JPanel();
        copyrightLabel1 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        defButton = new javax.swing.JButton();
        dispButton = new javax.swing.JButton();
        greetingLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        signOutButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setResizable(false);

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/VS2.1.png"))); // NOI18N

        mainPanel.setBackground(new java.awt.Color(227, 234, 245));
        mainPanel.setAlignmentX(0.0F);
        mainPanel.setAlignmentY(0.0F);

        copyrightLabel1.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        copyrightLabel1.setForeground(new java.awt.Color(32, 55, 73));
        copyrightLabel1.setText("� 2016 PSICOM Inventory Mgt. System Powered by VIPE Solutions. All Rights Reserved. ");

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_up.png"))); // NOI18N
        updateButton.setToolTipText("Update Stocks");
        updateButton.setAlignmentY(0.0F);
        updateButton.setBorder(null);
        updateButton.setBorderPainted(false);
        updateButton.setContentAreaFilled(false);
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_up2.png"))); // NOI18N
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        defButton.setBackground(new java.awt.Color(255, 255, 255));
        defButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        defButton.setForeground(new java.awt.Color(255, 255, 255));
        defButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_def.png"))); // NOI18N
        defButton.setToolTipText("Defective Books");
        defButton.setAlignmentY(0.0F);
        defButton.setBorder(null);
        defButton.setBorderPainted(false);
        defButton.setContentAreaFilled(false);
        defButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        defButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_def2.png"))); // NOI18N
        defButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defButtonActionPerformed(evt);
            }
        });

        dispButton.setBackground(new java.awt.Color(255, 255, 255));
        dispButton.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        dispButton.setForeground(new java.awt.Color(255, 255, 255));
        dispButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_disp.png"))); // NOI18N
        dispButton.setToolTipText("Display Orders");
        dispButton.setAlignmentY(0.0F);
        dispButton.setBorder(null);
        dispButton.setBorderPainted(false);
        dispButton.setContentAreaFilled(false);
        dispButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dispButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_disp2.png"))); // NOI18N
        dispButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispButtonActionPerformed(evt);
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
                        .addGap(271, 271, 271)
                        .addComponent(updateButton)
                        .addGap(18, 18, 18)
                        .addComponent(defButton)
                        .addGap(18, 18, 18)
                        .addComponent(dispButton)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton)
                    .addComponent(defButton)
                    .addComponent(dispButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                .addComponent(copyrightLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        greetingLabel.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        greetingLabel.setForeground(new java.awt.Color(255, 255, 255));
        greetingLabel.setText("Hello, Warehouse Clerk  | ");

        searchField.setFont(new java.awt.Font("Calibri", 0, 10)); // NOI18N
        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setText("   Search");
        searchField.setToolTipText("Search");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 483, Short.MAX_VALUE)
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

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
    	this.dispose();
        WCUpdateStocksTab a = new WCUpdateStocksTab();
        a.setVisible(true);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void defButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defButtonActionPerformed
    	this.dispose();
        WCDefectiveBookRecordTab a = new WCDefectiveBookRecordTab();
        a.setVisible(true);
    }//GEN-LAST:event_defButtonActionPerformed

    private void dispButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispButtonActionPerformed
    	this.dispose();
        WCDisplayIncompleteOrdersTab a = new WCDisplayIncompleteOrdersTab();
        a.setVisible(true);
    }//GEN-LAST:event_dispButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
    	this.dispose();
        WCLogInScreen a = new WCLogInScreen();
        a.setVisible(true);
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WCHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WCHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WCHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WCHomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WCHomeScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel copyrightLabel1;
    private javax.swing.JButton defButton;
    private javax.swing.JButton dispButton;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton signOutButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
