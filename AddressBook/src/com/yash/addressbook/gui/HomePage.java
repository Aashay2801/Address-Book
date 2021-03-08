package com.yash.addressbook.gui;


import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.yash.addressbook.dbutil.DBUtil;
import com.yash.addressbook.model.Contact;
import com.yash.addressbook.model.User;
import com.yash.addressbook.serviceimpl.ContactServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class HomePage extends JFrame {
	private JTable table;
	private JPanel contentPane;
	ContactServiceImpl contactService;
    private JTextField cPhone;
    private JTextField cName;
    private JTextField cEmail;
    
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */

    
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                contentPane.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setOpaque(false);
//		contentPane.setBackground(null);
		try {
			DBUtil.getConnection();
//			myTableModel=new MyTableModel();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel();
		try {
			DBUtil.getConnection();
			String userName= LoginPage.loggedInUser.getUserName();
			lblNewLabel.setText("Welcome : "+userName.toUpperCase());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(21, 11, 291, 65);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(281, 0, 429, 485);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setOpaque(false);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(21, 42, 106, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setBounds(21, 104, 106, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(21, 168, 106, 30);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(21, 304, 106, 30);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Group");
		lblNewLabel_5.setBounds(21, 364, 106, 30);
		panel.add(lblNewLabel_5);
		
		cPhone = new JTextField();
		cPhone.setBounds(137, 104, 243, 30);
		panel.add(cPhone);
		cPhone.setColumns(10);
		
		cName = new JTextField();
		cName.setBounds(137, 42, 243, 30);
		cName.setColumns(10);
		panel.add(cName);
		
		JTextArea cAddress = new JTextArea();
		cAddress.setBounds(137, 171, 243, 106);
		panel.add(cAddress);
		
		cEmail = new JTextField();
		cEmail.setBounds(137, 304, 243, 30);
		cEmail.setColumns(10);
		panel.add(cEmail);
		
		JComboBox cGroup = new JComboBox();
		cGroup.setBounds(137, 368, 243, 26);
		cGroup.setModel(new DefaultComboBoxModel(new String[] {"friends", "Family", "Company", "Other"}));
		panel.add(cGroup);
		
		JButton btnNewButton_3 = new JButton("SAVE");
		btnNewButton_3.setBounds(126, 427, 146, 36);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				contactService = new ContactServiceImpl();
				Contact contact = new Contact();
				contact.setUserId(LoginPage.loggedInUser.getUserId());
				contact.setContactName(cName.getText());
				contact.setPhoneNo(cPhone.getText());
				contact.setEmail(cEmail.getText());
				contact.setAddress(cAddress.getText());
				contact.setContactGroup(cGroup.getSelectedItem().toString());
				contactService.save(contact);
				JOptionPane.showMessageDialog(btnNewButton_3,"Contact saved ");
				cName.setText("");
				cPhone.setText("");cEmail.setText("");cAddress.setText("");
	
			
			}
		});
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_7 = new JLabel("Contact Form");
		lblNewLabel_7.setBounds(169, -12, 159, 55);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		
		JLabel lblNewLabel_6 = new JLabel("Update Personal Detail");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_6.setBounds(21, 382, 222, 54);
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                     
                    int id= LoginPage.loggedInUser.getUserId();
                    UserUpdateForm userUpdtae = new UserUpdateForm(id);
                    userUpdtae.setVisible(true);
                            
                    }
                    @Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("entered");
				lblNewLabel_6.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6.setForeground(Color.black);
			}
                    
                
                });
                contentPane.add(lblNewLabel_6);
		
                
                
		JLabel lblNewLabel_6_1 = new JLabel("View Contact");
		lblNewLabel_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	//			desktop = new JDesktopPane();
		ShowContact showContact = new ShowContact();
                showContact.setVisible(true);
                                                               
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("entered");
				lblNewLabel_6_1.setForeground(Color.blue);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6_1.setForeground(Color.black);
			}
		});
		lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_6_1.setBounds(56, 129, 137, 54);
		contentPane.add(lblNewLabel_6_1);
		
		
		
				
		JLabel lblNewLabel_8 = new JLabel("");
               System.out.println(lblNewLabel_8.getHeight()); 
                System.out.println(lblNewLabel_8.getWidth());
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\aashay.sharma\\Pictures\\home.jpg"));
		lblNewLabel_8.setBounds(0, 0, 747, 496);
		contentPane.add(lblNewLabel_8);
		
		
		
	}
}


//Inner Class -  MyTableModel - Start

