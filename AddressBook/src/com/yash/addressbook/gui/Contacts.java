package com.yash.addressbook.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.yash.addressbook.dbutil.DBUtil;
import com.yash.addressbook.model.Contact;
import com.yash.addressbook.service.ContactService;
import com.yash.addressbook.serviceimpl.ContactServiceImpl;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;

public class Contacts extends JFrame {
	private JTable table;
//	private MyTableModel myTableModel;
	private ContactService contactService;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	
	


	public Contacts() {
		try {
			DBUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 910, 460);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		
		table.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Contacts", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.setTableHeader();
		int uid=LoginPage.loggedInUser.getUserId();
		contactService = new ContactServiceImpl();
		ResultSet rs = contactService.getallContacts(uid);
		try {
			while(rs.next()) {
				String name;
				try {
					name = rs.getString("contactName");
					String phoneNo = rs.getString("phoneNo");
					String address = rs.getString("address");
					String email = rs.getString("email");
					String contactGroup = rs.getString("contactGroup");
					String tbldata[] = {name,phoneNo,address,email,contactGroup};
					DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
					System.out.println(tblModel.toString());
					tblModel.addRow(tbldata);
                                     
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		myTableModel= new MyTableModel();
//		table.setModel(myTableModel);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(30, 407, 856, -384);
		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, -86, 162, 100);
		panel.add(lblNewLabel);


	}
	
	 private void deleteAllRowsFromTable() {
	        int rowCount=table.getRowCount();
	        if(rowCount>=1){
//	            myTableModel.removeRow(rowCount-1);
	            deleteAllRowsFromTable(); //recursive call
	        }else{
	        return;
	        }

	    }

	    private void fetchAllContacts() throws Exception{
	    	contactService = new ContactServiceImpl();
	        Vector<Vector> data=contactService.getAll(LoginPage.loggedInUser.getUserId());
	        for (Vector row : data) {
//	            myTableModel.addRow(row);

	        }

	    }
	
	    class MyTableModel extends DefaultTableModel{
	        Vector header;
	        Vector<Vector> data;

	        public MyTableModel() {
	            header=new Vector();
	            header.add("Select");
	            header.add("Id");
	            header.add("Name");
	            header.add("Phone");
	            header.add("Email");
	            header.add("Address");
	            header.add("Group Type");
	            int uid=LoginPage.loggedInUser.getUserId();
	            try{
	            contactService= new ContactServiceImpl();
	            data=contactService.getAll(uid);
	            }catch(Exception e){
	                e.printStackTrace();
	            }
	            setDataVector(data, header);

	    }
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            if (column == 0) {
	                return true;
	            } else {
	                return false;
	            }
	        }

	        @Override
	        public Class<?> getColumnClass(int columnIndex){
	            if(columnIndex==0)
	            {
	                return Boolean.class;
	            }
	            return super.getColumnClass(columnIndex);

	        }
	    }
}
