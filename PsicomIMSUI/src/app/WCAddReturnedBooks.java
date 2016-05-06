package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
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
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abby
 */
public class WCAddReturnedBooks extends javax.swing.JFrame {

    /**
     * Creates new form WCAddDefectiveBookScreen
     */
	private List<String> itemCodeList  = new ArrayList<String>();
	private List<String> outletsList  = new ArrayList<String>(); 
    private String []co;
    private String []ou;
    private String title;
	JComboBox outComboBox = new JComboBox();
	JComboBox itemCodeComboBox = new JComboBox();
	
    public WCAddReturnedBooks() {
        initComponents();
        
        Color x = new Color(32, 55, 73);
        this.getContentPane().setBackground(x);
        
        Color y = new Color(205, 0, 69);
        addButton.setBackground(y);
        
        Color z = new Color(102, 102, 102);
        cancelButton.setBackground(z);
        
        getItemCode();
        
        co = new String[itemCodeList.size()];
        itemCodeList.toArray(co);
        AutoCompleteSupport.install(itemCodeComboBox, GlazedLists.eventListOf(co));
        titleField.setEditable(false);
        quantityField.setText("1");
        getOutletList();
        ou = new String[outletsList.size()];
        outletsList.toArray(ou);
        AutoCompleteSupport.install(outComboBox, GlazedLists.eventListOf(ou));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
        addDefectiveBookLabel = new javax.swing.JLabel();
        itemCodeLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Defective Book");
        setResizable(false);

        addDefectiveBookLabel.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        addDefectiveBookLabel.setForeground(new java.awt.Color(255, 255, 255));
        addDefectiveBookLabel.setText("ADD RETURNED BOOK");

        itemCodeLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        itemCodeLabel.setForeground(new java.awt.Color(255, 255, 255));
        itemCodeLabel.setText("Item Code");

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Title");

        titleField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        titleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleFieldActionPerformed(evt);
            }
        });

        quantityLabel.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(255, 255, 255));
        quantityLabel.setText("Quantity");

        quantityField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(205, 0, 69));
        addButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Defective Book");
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
        

        itemCodeComboBox.setUI(new BasicComboBoxUI() { // make the down arrow invisible
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
        outComboBox.setUI(new BasicComboBoxUI() { // make the down arrow invisible
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
        itemCodeComboBox.addActionListener(new ActionListener() {
           
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String s = (String) itemCodeComboBox.getSelectedItem();
						if(s != null)
						{
							getTitle(s);
							titleField.setText(title);
						}
						else
						{
							titleField.setText("");
						}
					}
				});
        
        JLabel lblOutlet = new JLabel();
        lblOutlet.setText("Outlet");
        lblOutlet.setForeground(Color.WHITE);
        lblOutlet.setFont(new Font("Calibri", Font.PLAIN, 15));
        
       
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(60, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(addDefectiveBookLabel)
        					.addGap(141))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        					.addGap(44))))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(76)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(outComboBox, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(lblOutlet, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
        						.addContainerGap())
        					.addGroup(layout.createSequentialGroup()
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(itemCodeComboBox, 0, 289, Short.MAX_VALUE)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(itemCodeLabel)
        								.addComponent(titleLabel)
        								.addComponent(titleField, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(2)
        									.addComponent(quantityLabel))
        								.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
        						.addGap(79)))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(addDefectiveBookLabel)
        			.addGap(18)
        			.addComponent(itemCodeLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(itemCodeComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(titleField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(quantityLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(quantityField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(lblOutlet)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(outComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        			.addGap(40))
        );
        getContentPane().setLayout(layout);
        pack();

    }// </editor-fold>//GEN-END:initComponents

    private void titleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleFieldActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    	HashMap map;
        if(!(itemCodeComboBox.getSelectedIndex() == -1) && !quantityField.getText().equals(""))
        {
        	if(this.isNumeric(quantityField.getText())){
        		try{
                    String itemCode = itemCodeComboBox.getSelectedItem().toString();
                    String title = titleField.getText();
                    String quantity = quantityField.getText();
                    String outlet = outComboBox.getSelectedItem().toString();

                    try{
                        map = doCommand("addDefectiveBook", itemCode, title, quantity, outlet);
                        
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    
                    cancelButton.setEnabled(false);
                    
                	this.dispose();
                	WCDefectiveBookRecordTab a = new WCDefectiveBookRecordTab();
                	a.setVisible(true);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
	    	  }
        	else
        	{
        		JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
	    	}
    	}
        else{
    		JOptionPane.showMessageDialog(null, "Missing input", "Error", JOptionPane.ERROR_MESSAGE);
    	}
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    	this.dispose();
    	WCDefectiveBookRecordTab a = new WCDefectiveBookRecordTab();
    	a.setVisible(true);
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
            java.util.logging.Logger.getLogger(WCAddReturnedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WCAddReturnedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WCAddReturnedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WCAddReturnedBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WCAddReturnedBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addDefectiveBookLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel itemCodeLabel;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    
    private HashMap doCommand(String command, String itemCode, String title, String quantity, String outlet) throws Exception
    {
        String url1 = "http://localhost:8080/"+command;
        
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("itemCode", itemCode);
        map.put("title", title);
        map.put("quantity", quantity);
        map.put("outlet", quantity);
        map.put("outlet", "GOOD");
        
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

    public void getItemCode()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT item_code FROM book");
    			ResultSet rs = pst.executeQuery();
    			Set<String> bookSet = new HashSet();
     			while (rs.next()) {
     				if(!rs.getString("item_code").equals(null))
     				{
     					bookSet.add(rs.getString("item_code"));
     				}
     			}
     			itemCodeList.addAll(bookSet);
    			
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		
    }
    public void getTitle(String itemCode1)
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
    					title = rs.getString("title");
    					System.out.println(title);
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
    private static void printMessage(HashMap map)
    {
        System.out.println(map.get("message"));
    }
    
    public boolean isAlpha(String s) {
    	String s1 = s.replaceAll("\\s+","");
        return s1.matches("[a-zA-Z]+");
    }
    
    public static boolean isNumeric(String s)
    {
      return s.matches("-?\\d+(\\.\\d+)?");
    }
    public void getOutletList()
    {
    		PreparedStatement pst;
    		Connection con;
    		
    		try {

    			Class.forName("com.mysql.jdbc.Driver");
    			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psicomims", "root", "root");
    			pst = (PreparedStatement) con.prepareStatement("SELECT outlet_name FROM outlet LIMIT 5");
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
