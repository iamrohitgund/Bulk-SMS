import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
public class Sms {

	private JFrame frame;
	private JTextField txtMob;
	private JTextField txtMsg;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	
	
    public  String retval1="";

	public static String retval="";
	private TextField pass;

	   public static String SMSSender(String phone,String msg,String password)
	    {
	        String rsp="";
	       
	        String user="#";  //replace it with your username
	        
	        String msisdn="#"; //replace with your SMS id eg. SBICRD
	        String priority="#"; //SMS priority eg. dnd, ndnd
	        String type="#"; //SMS type eg. normal , mms
	        
	        

	        try {
	            // Construct The Post Data
	            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
	            data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
	            data += "&" + URLEncoder.encode("sender", "UTF-8") + "=" + URLEncoder.encode(msisdn, "UTF-8");
	            data += "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8");
	            data += "&" + URLEncoder.encode("text", "UTF-8") + "=" + URLEncoder.encode(msg, "UTF-8");
	            data += "&" + URLEncoder.encode("priority", "UTF-8") + "=" + URLEncoder.encode(priority, "UTF-8");
	            data += "&" + URLEncoder.encode("stype", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8");

	            //Push the HTTP Request
	            URL url = new URL("http://bhashsms.com/api/sendmsg.php?"); //Bulk SMS provider URL
	            URLConnection conn = url.openConnection();
	            conn.setDoOutput(true);

	            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	            wr.write(data);
	            wr.flush();

	            //Read The Response
	            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = rd.readLine()) != null) {
	                retval += line;
	            }
	            wr.close();
	            rd.close();

	           // System.out.println(retval);
	            rsp = retval;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return  rsp;
	    }
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sms window = new Sms();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the application.
	 */
	public Sms() {
		initialize();
		// Process line...
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.setContentPane(new JLabel(new ImageIcon("#")));
		frame.setBounds(100, 100, 577, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblMobileNo = new JLabel("Mobile No.");
		lblMobileNo.setBounds(32, 34, 84, 16);
		lblMobileNo.setForeground(Color.RED);
		frame.getContentPane().add(lblMobileNo);
		
		txtMob = new JTextField();
		txtMob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    //String phone1=txtMob.getText();
			  //  String msg1=txtMsg.getText();
			    
				//String response = SMSSender(phone1,msg1);

				
			}
		});
		txtMob.setBounds(118, 28, 420, 28);
		frame.getContentPane().add(txtMob);
		txtMob.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(32, 118, 61, 16);
		lblMessage.setForeground(Color.RED);
		frame.getContentPane().add(lblMessage);
		
		txtMsg = new JTextField();
		txtMsg.setBounds(122, 108, 416, 94);
		frame.getContentPane().add(txtMsg);
		txtMsg.setColumns(10);
		
		JButton btnSend = new JButton("send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String phone1=txtMob.getText();
				String msg1=txtMsg.getText();
				String pass1=pass.getText();
			    String response = SMSSender(phone1,msg1,pass1);

				
				
				 lblNewLabel.setText("SMS sent..");
			
			}
		});
		btnSend.setBounds(132, 216, 117, 29);
		frame.getContentPane().add(btnSend);
		
		lblNewLabel = new JLabel("We are processing ur request..");
		lblNewLabel.setBounds(261, 221, 226, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Check Balance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					String pass1=pass.getText();


			          // public static String retval1="";

			    
			        

			        	try {
			            

			            //Push the HTTP Request
			            URL url = new URL(" # "+pass1); //Replace with your service provider URL
			            URLConnection conn = url.openConnection();
			            conn.setDoOutput(true);



			            //Read The Response
			            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			            String line;
			            
			            while ((line = rd.readLine()) != null) {
			                 //Process line...
			                 retval1 += line;
			            }
			           
			     

			           

			    		JLabel lblNewLabel_1 = new JLabel(""+retval1);
			    		
			    		lblNewLabel_1.setBounds(261, 274, 150, 16);
			    		frame.getContentPane().add(lblNewLabel_1);
			    		lblNewLabel_1.setText(("Your Balance is: "+retval1));
						
						

			        } catch (Exception e1) {
			            e1.printStackTrace();
			        }
			        
			    
				
				
				
			}
		});
		btnNewButton.setBounds(132, 269, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(32, 71, 61, 16);
		lblPassword.setForeground(Color.RED);

		frame.getContentPane().add(lblPassword);
		
		pass = new TextField();
		pass.setEchoChar('*');
		pass.setBounds(118, 68, 420, 28);
		frame.getContentPane().add(pass);
		pass.setColumns(10);
		
		
	
		

	}
}
