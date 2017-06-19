package R10;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.sql.*;
import R10.Ck1;
import R12.Mysqldl;
import javax.swing.*;
import com.mysql.jdbc.Connection;

public class Ckqq extends JFrame {
	
	static JTextArea jta=null;
	public Ckqq(Socket soc) throws Exception{
		super();
		this.setLayout(null);
		//输入框
		JTextArea jta1 = new JTextArea();
		jta1.setBounds(0,270,800,30);
		this.add(jta1);
		//发送
		JButton jb = new JButton();
		this.add(jb);
		jb.setText("发送");
		jb.setBounds(90,340,60,30);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				//获取输入的内容
				String s = jta1.getText();
				if(!"".equals(s)){
					try {
						PrintWriter pw = new PrintWriter(soc.getOutputStream());
						pw.write(s+"\n");
						pw.flush();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				jta1.setText("");
			}
		});
		//显示框
		jta = new JTextArea();
		jta.setBounds(0,60,800,200);
		this.add(jta);
		jta.setEnabled(false);
		this.setVisible(true);
		this.setBounds(20,100,800,600);
		new Thread(new Ck1(soc,jta)).start();
		//滚动条
		JScrollPane jsll = new JScrollPane(jta);
		jsll.setBounds(0,60,800,200);
		this.add(jsll);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//清空
		JButton jb1 = new JButton();
		this.add(jb1);
		jb1.setText("清空");
		jb1.setBounds(166,340,60,30);
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jta.setText("");
			}
		});
		
		//
		
	}
	public static JTextArea getJta(){
		return jta;
	}
	
	public static void main(String[] args) throws Exception {
		Socket soc = new Socket("192.168.199.159",9999);
		PrintWriter pw = new PrintWriter(soc.getOutputStream());
		pw.write("m\n");
		pw.flush();
		new Ckqq(soc);
		//数据库
		try{
			Connection con = (Connection) Mysqldl.getCon();
			Statement statement = Mysqldl.getCon().createStatement();
			String sql = "select * from Xiaoxi";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				jta.setText(jta.getText()+"\n"+rs.getString("xx"));
			}
			//con.close();
			//rs.close();
			//
		}catch(Exception e){
			e.printStackTrace();
		}
		//
	}
}










