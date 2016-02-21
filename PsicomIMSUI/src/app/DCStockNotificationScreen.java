package app;
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class DCStockNotificationScreen extends javax.swing.JFrame {

    /**
     * Creates new form DCStockNotification
     */
    public DCStockNotificationScreen(String title) {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);

        Color z = new Color(102, 102, 102);
        okayButton.setBackground(z);
        
        titleLabel.setText(title);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        confirmationLabel = new javax.swing.JLabel();
        confirmationLabel1 = new javax.swing.JLabel();
        okayButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Notice");
        setResizable(false);

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));

        confirmationLabel.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        confirmationLabel.setForeground(new java.awt.Color(255, 255, 255));
        confirmationLabel.setText("has reached its low stock level limit");

        confirmationLabel1.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        confirmationLabel1.setForeground(new java.awt.Color(255, 255, 255));
        confirmationLabel1.setText("Create a job order now");

        okayButton.setBackground(new java.awt.Color(102, 102, 102));
        okayButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        okayButton.setForeground(new java.awt.Color(255, 255, 255));
        okayButton.setText("Okay");
        okayButton.setBorder(null);
        okayButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        okayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmationLabel1)
                            .addComponent(confirmationLabel))))
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(okayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(18, 18, 18)
                        .addComponent(confirmationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmationLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addComponent(okayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okayButtonActionPerformed
        this.dispose();
        DCJobOrdersTab j = new DCJobOrdersTab();
        j.setVisible(true);
    }//GEN-LAST:event_okayButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DCStockNotificationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCStockNotificationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCStockNotificationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCStockNotificationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCStockNotificationScreen("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmationLabel;
    private javax.swing.JLabel confirmationLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okayButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
