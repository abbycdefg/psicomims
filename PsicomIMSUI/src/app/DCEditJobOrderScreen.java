package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class DCEditJobOrderScreen extends javax.swing.JFrame {

    /**
     * Creates new form DCEditJobOrderScreen
     */
	private JComboBox itemCodecomboBox = new JComboBox();
	private List<String> itemCodeList  = new ArrayList<String>();
	private String []ic;
	private String bookTitle = "";
    public DCEditJobOrderScreen() {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
    }
    
    public DCEditJobOrderScreen(String joNumber1, String date1, String itemCode1, String title1, String quantity1) {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        editButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        jobOrderNumberField.setText(joNumber1);
        jobOrderNumberField.setEditable(false);
        titleField.setEditable(false);
        getItemCodeList();
        
        ic = new String[itemCodeList.size()];
        itemCodeList.toArray(ic);
        AutoCompleteSupport.install(itemCodecomboBox, GlazedLists.eventListOf(ic));
        
        itemCodecomboBox.setSelectedItem(itemCode1);
        titleField.setText(title1);
        quantityField.setText(quantity1);
        try {
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			java.util.Date dateToday = df.parse(date1);
			dateChooser.setDate(dateToday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addJobOrderLabel = new javax.swing.JLabel();
        jobOrderNumberLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jobOrderNumberField = new javax.swing.JTextField();
        titleField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        itemCodeLabel1 = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        
        itemCodecomboBox.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = (String) itemCodecomboBox.getSelectedItem();
				if(s != null)
				{
					getBook(s);
					titleField.setText(bookTitle);
				}
				else
				{
					titleField.setText("");
				}

				
			}
		});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Job Order");
        setResizable(false);

        addJobOrderLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addJobOrderLabel.setForeground(new java.awt.Color(255, 255, 255));
        addJobOrderLabel.setText("EDIT JOB ORDER");

        jobOrderNumberLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jobOrderNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        jobOrderNumberLabel.setText("Job Order Number");

        dateLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Date Today");

        jobOrderNumberField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jobOrderNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobOrderNumberFieldActionPerformed(evt);
            }
        });

        titleField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Title");

        itemCodeLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        itemCodeLabel1.setForeground(new java.awt.Color(255, 255, 255));
        itemCodeLabel1.setText("Item Code");

        quantityLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        quantityLabel.setText("Quantity");

        quantityField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(205, 0, 69));
        editButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Job Order");
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
        
        itemCodecomboBox.setUI(new BasicComboBoxUI() { // make the down arrow invisible
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
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(255)
        			.addComponent(addJobOrderLabel)
        			.addContainerGap(261, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(60)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
        						.addComponent(quantityLabel))
        					.addContainerGap(448, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(itemCodeLabel1)
        								.addComponent(itemCodecomboBox, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
        							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(titleLabel)
        									.addGap(222))
        								.addComponent(titleField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(jobOrderNumberField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jobOrderNumberLabel))
        							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(dateLabel)
        								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))))
        					.addGap(68))))
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(141, Short.MAX_VALUE)
        			.addComponent(editButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        			.addGap(133))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(addJobOrderLabel)
        			.addGap(29)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(dateLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jobOrderNumberLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jobOrderNumberField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(itemCodeLabel1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(itemCodecomboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(titleField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18)
        			.addComponent(quantityLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(44)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(editButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(40, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobOrderNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_jobOrderNumberFieldActionPerformed

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
HashMap map;
        
        try{
        	String joNumber = "";
            String itemCode = "";
            String title = "";
            String quantity = "";
            boolean go = true;
            
            if( jobOrderNumberField.getText().equals("") || itemCodecomboBox.getSelectedItem() == null|| titleField.getText().equals("")|| quantityField.getText().equals("")) {
           	   go = false;
                JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
              }
             else {
             	if(checkNumber(jobOrderNumberField.getText()) == true && checkCharacters(jobOrderNumberField.getText()) == false ) {
             		joNumber = jobOrderNumberField.getText();
             	}
             	else {
 	            	 go = false;
 	            	 JOptionPane.showMessageDialog(null, "Please enter a numeric job order code value.", "Error", JOptionPane.ERROR_MESSAGE);
             	}
             	
             	if(itemCodecomboBox.getSelectedIndex() != -1)
             	{
             		itemCode = itemCodecomboBox.getSelectedItem().toString(); 
             	}
             	
             	else {
 	            	 go = false;
 	            	 JOptionPane.showMessageDialog(null, "Item code does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
             	}
             	
 	            title = titleField.getText();
 	            
 	            if(checkNumber(quantityField.getText()) == true && Integer.parseInt(quantityField.getText())  > 0) {
 	            	quantity = quantityField.getText();
 	            }
 	            else{
 	            	go = false;
 		           	 JOptionPane.showMessageDialog(null, "Please enter a positive numeric quantity value.", "Error", JOptionPane.ERROR_MESSAGE);
 	            }
             }
            
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            java.util.Date dateToday = dateChooser.getDate();
            String dateTodayStr = df.format(dateToday);
            

            try{
            	if (go == true) {
	                map = doCommand("editJobOrder", joNumber, dateTodayStr, itemCode, title, quantity);
	            	this.dispose();
	            	DCJobOrdersTab a = new DCJobOrdersTab("");
	            	a.setVisible(true);
            	}
                
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        DCJobOrdersTab a = new DCJobOrdersTab("");
        a.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(DCEditJobOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DCEditJobOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DCEditJobOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DCEditJobOrderScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DCEditJobOrderScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addJobOrderLabel;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel itemCodeLabel1;
    private javax.swing.JTextField jobOrderNumberField;
    private javax.swing.JLabel jobOrderNumberLabel;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String joNumber, String dateToday, String itemCode, String title, String quantity ) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("joNumber", joNumber);
        map.put("dateToday", dateToday);
        map.put("itemCode", itemCode);
        map.put("title", title);
        map.put("quantity", quantity);

        
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
    
    public void getItemCodeList()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM book");
    			ResultSet rs = pst.executeQuery();
    		    Set<String> itemCodeSet = new HashSet<String>();
    			while (rs.next()) {
    				if(!rs.getString("item_code").equals(null))
    				{
    					itemCodeSet.add(rs.getString("item_code"));
    				}
    			}
    			itemCodeList.addAll(itemCodeSet);
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		
    }
    public void getBook(String itemCode1)
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT * FROM book");
    			ResultSet rs = pst.executeQuery();
    			while (rs.next()) {
    				if(rs.getString("item_code").equals(itemCode1))
    				{ 
    					bookTitle = rs.getString("title");
    					System.out.println(bookTitle);
    					break;
    				}
    			}
    			
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		
    }
    private boolean checkNumber(String text) {
    	try{
    		 Integer.parseInt( text );
    	      return true;
    	}
    	catch (Exception e){
    		return false;
    	}
    }
    private boolean checkCharacters(String text) {
    	try{
    		String thePattern = "[^A-Za-z0-9]+"; 
    		Pattern.compile(thePattern).matcher(text).find();
    	      return false;
    	}
    	catch (Exception e){
    		return true;
    	}
    }
}
