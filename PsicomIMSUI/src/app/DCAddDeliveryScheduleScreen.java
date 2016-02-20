package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class DCAddDeliveryScheduleScreen extends javax.swing.JFrame {

    /**
     * Creates new form DCAddDeliverySchedule
     */
	private List<String> outletsList  = new ArrayList<String>();
	private JComboBox outletComboBox = new JComboBox();

	private String []ou;
	private JTextField scheduleCodeField;
	private JTextField deliveryReceiptCodeField;
	
    public DCAddDeliveryScheduleScreen() {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        getOutletList();
        
        ou = new String[outletsList.size()];
        outletsList.toArray(ou);
        AutoCompleteSupport.install(outletComboBox, GlazedLists.eventListOf(ou));
        
        Date now = new Date();
        dateChooser.setDate(now);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addDeliveryScheduleLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        scheduleCodeLabel = new javax.swing.JLabel();
        scheduleCodeField = new javax.swing.JTextField();
        outletsLabel = new javax.swing.JLabel();
        deliveryReceiptCodeLabel = new javax.swing.JLabel();
        deliveryReceiptCodeField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Delivery Schedule");
        setResizable(false);

        addDeliveryScheduleLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addDeliveryScheduleLabel.setForeground(new java.awt.Color(255, 255, 255));
        addDeliveryScheduleLabel.setText("ADD DELIVERY SCHEDULE");

        dateLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date");

        scheduleCodeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        scheduleCodeLabel.setForeground(new java.awt.Color(255, 255, 255));
        scheduleCodeLabel.setText("Schedule Code");

        scheduleCodeField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        scheduleCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleCodeFieldActionPerformed(evt);
            }
        });

        outletsLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        outletsLabel.setForeground(new java.awt.Color(255, 255, 255));
        outletsLabel.setText("Outlets");

        deliveryReceiptCodeLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        deliveryReceiptCodeLabel.setForeground(new java.awt.Color(255, 255, 255));
        deliveryReceiptCodeLabel.setText("Delivery Receipt Code");

        deliveryReceiptCodeField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        deliveryReceiptCodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryReceiptCodeFieldActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(205, 0, 69));
        addButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Delivery Schedule");
        addButton.setToolTipText("");
        addButton.setBorder(null);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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
        
        outletComboBox.setUI(new BasicComboBoxUI() { // make the down arrow invisible
            protected JButton createArrowButton() {
                return new JButton() {
                    public int getWidth() {
                        return 0;
                    }

                    @Override
                    public synchronized void addMouseListener(MouseListener l) {
                    }
                };
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(81)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
        								.addComponent(dateLabel))
        							.addGap(18)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(scheduleCodeLabel)
        								.addComponent(scheduleCodeField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(outletsLabel)
        								.addComponent(outletComboBox, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
        							.addGap(31)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(deliveryReceiptCodeLabel)
        								.addComponent(deliveryReceiptCodeField, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(145)
        					.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(238)
        					.addComponent(addDeliveryScheduleLabel)))
        			.addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(38)
        			.addComponent(addDeliveryScheduleLabel)
        			.addGap(34)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(scheduleCodeLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(scheduleCodeField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(outletsLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(outletComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(deliveryReceiptCodeLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(deliveryReceiptCodeField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        			.addGap(54)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(40, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scheduleCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scheduleCodeFieldActionPerformed

    private void deliveryReceiptCodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryReceiptCodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deliveryReceiptCodeFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	 HashMap map;
         
         try{
         	
        	 String scheduleCode = scheduleCodeField.getText();
             String outlet = outletComboBox.getSelectedItem().toString();
             String deliveryReceiptCode = deliveryReceiptCodeField.getText();
             
             DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
             java.util.Date deliveryDate = dateChooser.getDate();
             String dateTodayStr = df.format(deliveryDate);
             

             try{

                 map = doCommand("addDeliverySchedule", dateTodayStr, scheduleCode, outlet, deliveryReceiptCode);
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

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DCAddDeliveryScheduleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCAddDeliveryScheduleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCAddDeliveryScheduleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCAddDeliveryScheduleScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCAddDeliveryScheduleScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addDeliveryScheduleLabel;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel deliveryReceiptCodeLabel;
    private javax.swing.JLabel outletsLabel;
    private javax.swing.JLabel scheduleCodeLabel;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String date, String scheduleCode, String outlets, String deliveryReceiptCode ) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("date", date);
        map.put("scheduleCode", scheduleCode);
        map.put("outlets", outlets);
        map.put("deliveryReceiptCode", deliveryReceiptCode);

        
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
 
    public void getOutletList()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM outlet");
    			ResultSet rs = pst.executeQuery();
    		    Set<String> outletSet = new HashSet();
    			while (rs.next()) {
    				if(!rs.getString("outlet_name").equals(null))
    				{
    					outletSet.add(rs.getString("outlet_name"));
    				}
    			}
    			outletsList.addAll(outletSet);
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		
    } 
}
