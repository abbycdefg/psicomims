package app;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        this.setAlwaysOnTop(true);
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);

        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
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
        cancelButton = new javax.swing.JButton();
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
        confirmationLabel1.setText("Create a job order now?");

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
        
        JButton okayButton = new JButton();
        okayButton.addActionListener(new ActionListener() {
        	public void actionPerformed(java.awt.event.ActionEvent evt1) {
        		okayButtonActionPerformed(evt1);
        	}
        });
        okayButton.setBorder(null);
        okayButton.setText("Create Job Order");
        okayButton.setForeground(Color.WHITE);
        okayButton.setFont(new Font("Calibri", Font.PLAIN, 14));
        okayButton.setBackground(new Color(205, 0, 69));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(65, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(titleLabel))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(okayButton, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
        							.addGap(15)
        							.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        						.addComponent(confirmationLabel1)
        						.addComponent(confirmationLabel))))
        			.addGap(166))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(44)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(titleLabel)
        					.addGap(18)
        					.addComponent(confirmationLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(confirmationLabel1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabel1))
        			.addGap(27)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        				.addComponent(okayButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addGap(39))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okayButtonActionPerformed(java.awt.event.ActionEvent evt1) {//GEN-FIRST:event_okayButtonActionPerformed
        this.dispose();
        DCJobOrdersTab j = new DCJobOrdersTab("");
        j.setVisible(true);
    }//GEN-LAST:event_okayButtonActionPerformed
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okayButtonActionPerformed
        this.dispose();
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
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel titleLabel;
}
