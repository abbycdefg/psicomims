
import java.awt.Color;
import java.awt.Font;
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
public class DCEditPurchaseOrderScreen extends javax.swing.JFrame {

    /**
     * Creates new form DCEditPurchaseOrderScreen
     */
    public DCEditPurchaseOrderScreen() {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        editBooksButton.setOpaque(false);
        editBooksButton.setContentAreaFilled(false);
        editBooksButton.setBorderPainted(false);
        editBooksButton.addMouseListener(new java.awt.event.MouseAdapter() {
            Font originalFont = null;
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                originalFont = editBooksButton.getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                editBooksButton.setFont(originalFont.deriveFont(attributes));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBooksButton.setFont(originalFont);
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

        editPurchaseOrderLabel = new javax.swing.JLabel();
        purchaseOrderNumberLabel = new javax.swing.JLabel();
        dateTodayLabel = new javax.swing.JLabel();
        purchaseOrderNumberField = new javax.swing.JTextField();
        dateTodayChooser = new com.toedter.calendar.JDateChooser();
        outletField = new javax.swing.JTextField();
        contactPersonField = new javax.swing.JTextField();
        contactPersonLabel = new javax.swing.JLabel();
        outletLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        editBooksButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Purchase Order");
        setResizable(false);

        editPurchaseOrderLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        editPurchaseOrderLabel.setForeground(new java.awt.Color(255, 255, 255));
        editPurchaseOrderLabel.setText("EDIT PURCHASE ORDER");

        purchaseOrderNumberLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        purchaseOrderNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        purchaseOrderNumberLabel.setText("Purchase Order Number");

        dateTodayLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        dateTodayLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateTodayLabel.setText("Date Today");

        purchaseOrderNumberField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        purchaseOrderNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseOrderNumberFieldActionPerformed(evt);
            }
        });

        outletField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        outletField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outletFieldActionPerformed(evt);
            }
        });

        contactPersonField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        contactPersonField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactPersonFieldActionPerformed(evt);
            }
        });

        contactPersonLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        contactPersonLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactPersonLabel.setText("Contact Person");

        outletLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        outletLabel.setForeground(new java.awt.Color(255, 255, 255));
        outletLabel.setText("Outlet");

        editButton.setBackground(new java.awt.Color(205, 0, 69));
        editButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Purchase Order");
        editButton.setBorder(null);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(102, 102, 102));
        cancelButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setBorder(null);
        cancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        editBooksButton.setBackground(new java.awt.Color(255, 255, 255));
        editBooksButton.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        editBooksButton.setForeground(new java.awt.Color(255, 255, 255));
        editBooksButton.setText("Click here to edit books");
        editBooksButton.setBorder(null);
        editBooksButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBooksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBooksButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(purchaseOrderNumberLabel)
                                    .addComponent(purchaseOrderNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateTodayChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateTodayLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(contactPersonField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contactPersonLabel))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(outletLabel)
                                    .addComponent(outletField, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(editPurchaseOrderLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(editBooksButton)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(editPurchaseOrderLabel)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseOrderNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTodayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(purchaseOrderNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(dateTodayChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contactPersonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outletLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactPersonField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outletField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(editBooksButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void purchaseOrderNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseOrderNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseOrderNumberFieldActionPerformed

    private void outletFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outletFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outletFieldActionPerformed

    private void contactPersonFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactPersonFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactPersonFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editBooksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBooksButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editBooksButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DCEditPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCEditPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCEditPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCEditPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCEditPurchaseOrderScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField contactPersonField;
    private javax.swing.JLabel contactPersonLabel;
    private com.toedter.calendar.JDateChooser dateTodayChooser;
    private javax.swing.JLabel dateTodayLabel;
    private javax.swing.JButton editBooksButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editPurchaseOrderLabel;
    private javax.swing.JTextField outletField;
    private javax.swing.JLabel outletLabel;
    private javax.swing.JTextField purchaseOrderNumberField;
    private javax.swing.JLabel purchaseOrderNumberLabel;
    // End of variables declaration//GEN-END:variables
}
