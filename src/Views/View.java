package Views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;

import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class View extends JFrame {
	JPanel joing ;JScrollPane scroll2;JScrollPane scroll3;JScrollPane scroll1;
	private JTextArea textName;JButton btnExit ;
	
	public JPanel getJoing() {
		return joing;
	}
	public void setJoing(JPanel joing) {
		this.joing = joing;
	}
	public JTextArea getTextName() {
		return textName;
	}
	public void setTextName(JTextArea textName) {
		this.textName = textName;
	}
	public JLabel getLblMyName() {
		return lblMyName;
	}
	public void setLblMyName(JLabel lblMyName) {
		this.lblMyName = lblMyName;
	}
	public JTextArea getTextOnlineMemebers() {
		return textOnlineMemebers;
	}
	public void setTextOnlineMemebers(JTextArea textOnlineMemebers) {
		this.textOnlineMemebers = textOnlineMemebers;
	}
	public JTextArea getTextSend() {
		return textSend;
	}
	public void setTextSend(JTextArea textSend) {
		this.textSend = textSend;
	}
	public JTextArea getTxtGroup() {
		return txtGroup;
	}
	public void setTxtGroup(JTextArea txtGroup) {
		this.txtGroup = txtGroup;
	}
	public JTextArea getTextChat() {
		return TextChat;
	}
	public void setTextChat(JTextArea textChat) {
		TextChat = textChat;
	}
	public JButton getBtnEnterName() {
		return btnEnterName;
	}
	public void setBtnEnterName(JButton btnEnterName) {
		this.btnEnterName = btnEnterName;
	}
	public JLabel getLblOnlineMemebers() {
		return lblOnlineMemebers;
	}
	public void setLblOnlineMemebers(JLabel lblOnlineMemebers) {
		this.lblOnlineMemebers = lblOnlineMemebers;
	}
	public JButton getBtnSend() {
		return btnSend;
	}
	public void setBtnSend(JButton btnSend) {
		this.btnSend = btnSend;
	}
	public JLabel getLblMessege() {
		return lblMessege;
	}
	public void setLblMessege(JLabel lblMessege) {
		this.lblMessege = lblMessege;
	}
	public JLabel getLblTo() {
		return lblTo;
	}
	public void setLblTo(JLabel lblTo) {
		this.lblTo = lblTo;
	}
	public ViewListener getListener() {
		return listener;
	}
	public void setListener(ViewListener listener) {
		this.listener = listener;
	}
	public JTextArea getTextIP() {
		return textIP;
	}
	public void setTextIP(JTextArea textIP) {
		this.textIP = textIP;
	}
	public JLabel getLblIp() {
		return lblIp;
	}
	public void setLblIp(JLabel lblIp) {
		this.lblIp = lblIp;
	}
	public JLabel getLblName() {
		return lblName;
	}
	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}
	public JButton getBtnIPEnter() {
		return btnIPEnter;
	}
	public void setBtnIPEnter(JButton btnIPEnter) {
		this.btnIPEnter = btnIPEnter;
	}
	public JTextArea getTextPort() {
		return textPort;
	}
	public void setTextPort(JTextArea textPort) {
		this.textPort = textPort;
	}
	public JLabel getLblPort() {
		return lblPort;
	}
	public void setLblPort(JLabel lblPort) {
		this.lblPort = lblPort;
	}
	private JLabel lblMyName;
	private JTextArea textOnlineMemebers;
	private JTextArea textSend;
	private JTextArea txtGroup;
	private JTextArea TextChat;
	private JButton btnEnterName;
	private	JLabel lblOnlineMemebers ;
	JButton btnSend;
	JLabel lblMessege;
	JLabel lblTo;
	private ViewListener listener;
	private JTextArea textIP;
	private JLabel lblIp;
	JLabel lblName;
	JButton btnIPEnter;
	private JTextArea textPort;
	JLabel lblPort;
	//////////////////////////////////////////////////////////////////////////////
	public View()
	{
		setTitle("Simple Chating Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,800, 600);
		joing =new JPanel();
		joing.setBackground(new Color(169, 169, 169));
		joing.setBounds(0, 0,750, 550);
		getContentPane().add(joing);
		joing.setLayout(null);
		
		textName = new JTextArea();
		textName.setBounds(106, 527, 233, 23);
		joing.add(textName);
		textName.setColumns(10);
		
		btnEnterName = new JButton("EnterName");
		btnEnterName.setBounds(550, 526, 134, 25);
		btnEnterName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				boolean f =true;
				if(countLines(textName.getText())>1)
				{
					JOptionPane.showMessageDialog(new JFrame(), "There can not be a name with two lines"+countLines(textName.getText()), "Two Line Name",
			    	        JOptionPane.ERROR_MESSAGE);
					f=false;
				}
				if(listener!=null&&!textName.getText().isEmpty()&&f){
				listener.join(textName.getText());
				}
				else{if(f)
					JOptionPane.showMessageDialog(new JFrame(), "There can not be a empty name", "NullText",
			    	        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		joing.add(btnEnterName);
		
		lblName = new JLabel("Choose a Name");
		lblName.setBounds(10, 527, 131, 23);
		joing.add(lblName);
		
		lblMyName = new JLabel("");
		lblMyName.setBounds(500, 452, 162, 23);
		joing.add(lblMyName);
		
		
		textOnlineMemebers = new JTextArea();
		  scroll1 = new JScrollPane ( textOnlineMemebers  );
		 scroll1.setLocation(543, 47);
		 scroll1.setSize(220, 394);
		    scroll1.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		textOnlineMemebers.setEditable(false);
		textOnlineMemebers.setBounds(503, 47, 271, 405);
		joing.add(scroll1);
		textOnlineMemebers.setColumns(10);
		
		lblOnlineMemebers = new JLabel("Online Memebers");
		lblOnlineMemebers.setBackground(Color.GRAY);
		lblOnlineMemebers.setBounds(606, 11, 131, 39);
		joing.add(lblOnlineMemebers);
		
		textSend = new JTextArea();
		textSend.setBounds(106, 489, 434, 33);
		 scroll3 = new JScrollPane ( textSend );
		scroll3.setLocation(178, 477);
		scroll3.setSize(497, 39);
	    scroll3.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		joing.add(scroll3);
		textSend.setColumns(10);
		
		txtGroup = new JTextArea();
		txtGroup.setText("All");
		txtGroup.setBounds(10, 481, 158, 35);
		joing.add(txtGroup);
		txtGroup.setColumns(10);
		
		 btnSend = new JButton("Send");
		btnSend.setBounds(685, 481, 89, 27);
		btnSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listener!=null&&!textSend.getText().isEmpty()&&!txtGroup.getText().isEmpty()&&!txtGroup.getText().equalsIgnoreCase(lblMyName.getName()))
				{
					listener.send(lblMyName.getName(),textSend.getText(),txtGroup.getText());
					if(txtGroup.getText().equalsIgnoreCase("All"))
					{
						TextChat.setText(TextChat.getText()+"\n"+"::>> said Your messege:"+textSend.getText());
					}
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(), "There can not be a empty messege or empty sender", "NullText",
			    	        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		joing.add(btnSend);
		
		TextChat = new JTextArea();
		
		scroll2 = new JScrollPane ( TextChat);
		scroll2.setLocation(0, 0);
		scroll2.setSize(470, 441);
	    scroll2.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		TextChat.setEditable(false);
		TextChat.setBounds(10, 47, 483, 405);
		joing.add(scroll2);
		TextChat.setColumns(10);
		
		lblTo = new JLabel("To");
		lblTo.setBounds(20, 463, 46, 15);
		joing.add(lblTo);
		
		 lblMessege = new JLabel("Messege");
		lblMessege.setBounds(191, 463, 111, 14);
		joing.add(lblMessege);
		
		textIP = new JTextArea();
		textIP.setBounds(396, 528, 144, 20);
		joing.add(textIP);
		textIP.setColumns(10);
		
		lblIp = new JLabel("IP");
		lblIp.setBounds(365, 531, 21, 14);
		joing.add(lblIp);
		
		btnIPEnter = new JButton("Enter");
		btnIPEnter.setBounds(573, 527, 89, 25);
		btnIPEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(listener!=null&&!textIP.getText().isEmpty()&&!textPort.getText().isEmpty())
				{
					listener.EnterIP(textIP.getText(),textPort.getText());
				}
				else{
					JOptionPane.showMessageDialog(new JFrame(), "There can not be a empty port or empty IP", "NullText",
			    	        JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		joing.add(btnIPEnter);
		
		textPort = new JTextArea();
		textPort.setBounds(151, 528, 188, 20);
		joing.add(textPort);
		textPort.setColumns(10);
		
		 lblPort = new JLabel("Port");
		lblPort.setBounds(50, 527, 46, 14);
		joing.add(lblPort);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(685, 528, 89, 23);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(listener!=null)
				{
					listener.closeClient();
				}
			}
		});
		joing.add(btnExit);
		
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public	void enterIPPanel()
	{   lblPort.setVisible(true);
		textPort.setVisible(true);
		textName.setVisible(false);
		lblMyName.setVisible(false);
		btnEnterName.setVisible(false);
		btnIPEnter.setVisible(true);
		scroll1.setVisible(false);
		scroll2.setVisible(false);
		scroll3.setVisible(false);
	textIP.setVisible(true);
	lblIp.setVisible(true);
	lblName.setVisible(false);
	btnSend.setVisible(false);
	 textOnlineMemebers.setVisible(false);;
	 textSend.setVisible(false);
	 txtGroup.setVisible(false);
	 TextChat.setVisible(false);
	 lblOnlineMemebers.setVisible(false) ;
	 lblMessege.setVisible(false);
	 lblTo.setVisible(false);
	 btnEnterName.setVisible(false);
		btnIPEnter.setVisible(true);
	}
	public void enterNamePanel()
	{	 lblPort.setVisible(false);
	textPort.setVisible(false);
			textName.setVisible(true);
			lblMyName.setVisible(true);
			btnEnterName.setVisible(true);
			btnIPEnter.setVisible(false);;
		textIP.setVisible(false);
		lblIp.setVisible(false);
		lblName.setVisible(true);
		btnSend.setVisible(false);
		 textOnlineMemebers.setVisible(false);;
		 textSend.setVisible(false);
		 txtGroup.setVisible(false);
		 TextChat.setVisible(false);
		 lblOnlineMemebers.setVisible(false) ;
		 lblMessege.setVisible(false);
		 lblTo.setVisible(false);
		 scroll1.setVisible(false);
			scroll2.setVisible(false);
			scroll3.setVisible(false);
			btnEnterName.setVisible(true);
			btnIPEnter.setVisible(false);
	}
	public	void ChatPanel()
	{ lblPort.setVisible(false);
	textPort.setVisible(false);
		textName.setVisible(false);
		lblMyName.setVisible(false);
		btnEnterName.setVisible(false);
		textIP.setVisible(false);
		lblIp.setVisible(false);
		lblMyName.setVisible(true);
		lblName.setVisible(false);
	 textOnlineMemebers.setVisible(true);;
	 textSend.setVisible(true);
	 txtGroup.setVisible(true);
	 TextChat.setVisible(true);
	 lblOnlineMemebers.setVisible(true) ;
	 lblMessege.setVisible(true);
	 lblTo.setVisible(true);
	 btnSend.setVisible(true);
	 scroll1.setVisible(true);
		scroll2.setVisible(true);
		scroll3.setVisible(true);
		btnEnterName.setVisible(false);
		btnIPEnter.setVisible(false);
	}
	 static int countLines(String str){
		   String[] lines = str.split("\r\n|\r|\n");
		   return  lines.length;
		}
}
