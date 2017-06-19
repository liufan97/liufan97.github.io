package R10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextArea;

import com.mysql.jdbc.Connection;

import R12.Mysqldl;

public class Ck1 implements Runnable {
	Socket soc;
	JTextArea jta;
	public static void main(String[] args) {
		
	}
	public Ck1(){
		
	}
	public Ck1(Socket soc,JTextArea jta){
		this.soc = soc;
		this.jta = jta;
	}
	String s;
	public void run(){
		while(true){
			try {//接受服务器返回的内容    向显示框发送内容
				BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				s = br.readLine();
				jta.setText(jta.getText()+"\n"+s);
				System.out.println(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*public  String getS(){
		return jta.getText()+"\n"+s;
	}*/
}













