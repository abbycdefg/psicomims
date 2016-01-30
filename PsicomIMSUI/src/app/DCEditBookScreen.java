package app;
import java.awt.Color;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */

public class DCEditBookScreen extends javax.swing.JFrame {
	private static int rowId;
    /**
     * Creates new form DCEditBookScreen
     */
	public DCEditBookScreen() {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);       
    }
	
    public DCEditBookScreen( String title, String itemCode, String price, String author, String releaseDate, int rowId) {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        titleField.setText(title);
        itemCodeField.setText(itemCode);
        priceField.setText(price);
        authorField.setText(author);
        releaseDateChooser.setDateFormatString(releaseDate);
        rowId = this.rowId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleField = new javax.swing.JTextField();
        itemCodeLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        editBookLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        authorField = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        itemCodeField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        releaseDateLabel = new javax.swing.JLabel();
        releaseDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Book");
        setResizable(false);

        titleField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        itemCodeLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        itemCodeLabel.setForeground(new java.awt.Color(255, 255, 255));
        itemCodeLabel.setText("Item Code");

        priceLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel.setText("Price");

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Title");

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

        editBookLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        editBookLabel.setForeground(new java.awt.Color(255, 255, 255));
        editBookLabel.setText("EDIT BOOK");

        editButton.setBackground(new java.awt.Color(205, 0, 69));
        editButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Book");
        editButton.setBorder(null);
        editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        authorField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        authorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorFieldActionPerformed(evt);
            }
        });

        authorLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        authorLabel.setForeground(new java.awt.Color(255, 255, 255));
        authorLabel.setText("Author");

        itemCodeField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        itemCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCodeFieldActionPerformed(evt);
            }
        });

        priceField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        releaseDateLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        releaseDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        releaseDateLabel.setText("Release Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(titleField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemCodeLabel)
                                        .addComponent(itemCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(priceLabel)
                                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(authorLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(authorField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(releaseDateLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(releaseDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(editBookLabel)
                        .addGap(199, 199, 199))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(editBookLabel)
                .addGap(31, 31, 31)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(releaseDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(releaseDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	HashMap map;
    	
        try{
            String title = titleField.getText();
            String itemCode = itemCodeField.getText();
            String price = priceField.getText();
            String author = authorField.getText();
            String releaseDate = releaseDateChooser.getDateFormatString();           

            try{
            	String idString = String.valueOf(rowId);
                map = doCommand("editBook", title, itemCode, price, author, releaseDate, idString);
            	this.dispose();
            	DCBooksTab a = new DCBooksTab();
            	a.setVisible(true);
                
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void authorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorFieldActionPerformed

    private void itemCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemCodeFieldActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceFieldActionPerformed

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
            java.util.logging.Logger.getLogger(DCEditBookScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCEditBookScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCEditBookScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCEditBookScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCEditBookScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorField;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel editBookLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField itemCodeField;
    private javax.swing.JLabel itemCodeLabel;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private com.toedter.calendar.JDateChooser releaseDateChooser;
    private javax.swing.JLabel releaseDateLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    private HashMap doCommand(String command, String title, String itemCode, String price, String author, String releaseDate, String id ) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        
       
        map.put("title", title);
        map.put("itemCode", itemCode);
        map.put("price", price);
        map.put("author", author);
        map.put("releaseDate", releaseDate);
        map.put("id", id);

        
        // CONVERT JAVA DATA TO JSON
        ObjectMapper mapper = new ObjectMapper();
        String json1 = mapper.writeValueAsString(map);
        
        
        // SEND TO SERVICE
        String reply = NetUtil.postJsonDataToUrl(url1, json1);
        System.out.println("REPLY = "+reply);
        
        
        try
        {
            // CONVERT REPLY JSON STRING TO A JAVA OBJECT 
            HashMap replyMap = (HashMap) mapper.readValue(reply, HashMap.class);
            return replyMap;
        }
        catch(Exception e)
        {
            //System.out.println(reply);
            HashMap replyMap = new HashMap();
            replyMap.put("message", reply);
            return replyMap;
            
        }
    }
}
