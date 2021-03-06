package app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class DCViewPurchaseOrderScreen extends javax.swing.JFrame {

	String prevPage;
	String poNumber1;
    /**
     * Creates new form DCViewPurchaseOrderScreen
     */
    public DCViewPurchaseOrderScreen(String page) {
        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);

   }
    
    public DCViewPurchaseOrderScreen(String poNumber, String contactPerson, String outlet, String page) {
        initComponents();
        
        prevPage = page;
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        outletValueLabel.setText(outlet);
        poNumberValueLabel.setText(poNumber);
        poNumber1 = poNumber;
        contactPersonValueLabel.setText(contactPerson);
        
        this.displayAll(poNumber);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewPoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseOrdersTable = new javax.swing.JTable();
        poNumberLabel = new javax.swing.JLabel();
        contactPersonLabel = new javax.swing.JLabel();
        outletLabel = new javax.swing.JLabel();
        poNumberValueLabel = new javax.swing.JLabel();
        contactPersonValueLabel = new javax.swing.JLabel();
        outletValueLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Purchase Order");
        setResizable(false);

        viewPoLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        viewPoLabel.setForeground(new java.awt.Color(255, 255, 255));
        viewPoLabel.setText("VIEW PURCHASE ORDER");

        purchaseOrdersTable.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        purchaseOrdersTable.setForeground(new java.awt.Color(255, 255, 255));
        
        

        poNumberLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        poNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        poNumberLabel.setText("PO Number:");

        contactPersonLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        contactPersonLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactPersonLabel.setText("Contact Person:");

        outletLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        outletLabel.setForeground(new java.awt.Color(255, 255, 255));
        outletLabel.setText("Outlet:");

        poNumberValueLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        poNumberValueLabel.setForeground(new java.awt.Color(255, 255, 255));

        contactPersonValueLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        contactPersonValueLabel.setForeground(new java.awt.Color(255, 255, 255));

        outletValueLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        outletValueLabel.setForeground(new java.awt.Color(255, 255, 255));

        backButton.setBackground(new java.awt.Color(205, 0, 69));
        backButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back");
        backButton.setBorder(null);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(300)
        					.addComponent(viewPoLabel))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(25)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 710, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(43)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(outletLabel)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(outletValueLabel))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(contactPersonLabel)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(contactPersonValueLabel))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(poNumberLabel)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(poNumberValueLabel)))))
        			.addContainerGap(25, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(0, 613, Short.MAX_VALUE)
        			.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        			.addGap(47))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(viewPoLabel)
        			.addGap(21)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(poNumberLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        				.addComponent(poNumberValueLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(contactPersonLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        				.addComponent(contactPersonValueLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(outletLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        				.addComponent(outletValueLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        			.addGap(25)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    	this.dispose();
        DCIncompletePurchaseOrdersTab a = new DCIncompletePurchaseOrdersTab("");
        
        if (prevPage.equals("")){
        	a = new DCIncompletePurchaseOrdersTab("");
       	}
    	else if (prevPage.equals("ad")){
    		a = new DCIncompletePurchaseOrdersTab("ad");
     	}
        
        a.setVisible(true);  
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DCViewPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCViewPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCViewPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCViewPurchaseOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCViewPurchaseOrderScreen("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel contactPersonLabel;
    private javax.swing.JLabel contactPersonValueLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchaseOrdersTable;
    private javax.swing.JLabel outletLabel;
    private javax.swing.JLabel outletValueLabel;
    private javax.swing.JLabel poNumberLabel;
    private javax.swing.JLabel poNumberValueLabel;
    private javax.swing.JLabel viewPoLabel;
    // End of variables declaration//GEN-END:variables
    
    public void displayAll(String poNumber){
    	String[] columnNames = {"ITEM CODE", "TITLE", "QUANTITY", "STATUS"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        
        PreparedStatement pst;
        Connection con;
        
        String itemCode = "";
        String title = "";
        String quantity = "";
        String status = "";
        System.out.println(poNumber1);
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
           	pst = con.prepareStatement("SELECT book_id, specific_po.quantity, status, title FROM psicomims.book, psicomims.specific_po  WHERE item_code=book_id AND po_id='" +poNumber1+"'" );
           	
        	ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {
                title = rs.getString("title");
                itemCode = rs.getString("book_id");
                quantity = rs.getString("quantity");
                status = rs.getString("status");
                model.addRow(new Object[]{itemCode, title, quantity, status});
                i++;
            }
            
            if (i < 1){
            
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            if (i == 1) {
                System.out.println(i + " Record Found");
            } 
            
            else {
                System.out.println(i + " Records Found");
            }

                  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        purchaseOrdersTable = new JTable(model);
        purchaseOrdersTable.setModel(model);
        purchaseOrdersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        purchaseOrdersTable.setToolTipText("");
        purchaseOrdersTable.setCellSelectionEnabled(true);
        purchaseOrdersTable.setGridColor(new java.awt.Color(204, 204, 255));
        purchaseOrdersTable.setRequestFocusEnabled(false);
        purchaseOrdersTable.setRowHeight(18);
        purchaseOrdersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(purchaseOrdersTable);
        purchaseOrdersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }
}
