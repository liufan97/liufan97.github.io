//五子棋3\\\
package R10;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Wzq extends JFrame {
	static List<Socket> li = new ArrayList<Socket>();
	public static void main(String[] args) throws Exception {
		
		//ServerSocket ser = new ServerSocket(9999);
		//System.out.println("服务器创建成功");
		
		//while(true){
		//	Socket soc = ser.accept();
		//	li.add(soc);
			new Wzq();
		//	System.out.println(li);
		//}
	}
	static JButton jb1;
	static boolean ks = false;
	public Wzq(){
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时关闭程序
		this.setBounds(200,200,690,690);
		this.setVisible(true);
		//this.setLayout(null);
		JButton jb = new JButton();
		this.add(jb);
		//this.setBounds(20,30,100,30);
		//this.setVisible(true);
		jb.setBounds(0,0,100,30);
		jb.setText("开始游戏");
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ks = true;
				Wzq1.getK(ks);
			}
		});
		//
		jb1 = new JButton();
		this.add(jb1);
		jb1.setText("悔棋");
		jb1.setBounds(160,0,80,30);
		//
		Wzq1 w1 = new Wzq1();
		w1.setBounds(0,0,690,690);
		this.add(w1);
	}
}










