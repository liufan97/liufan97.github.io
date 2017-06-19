package R2;
import java.io.*;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.util.*;

import com.mysql.jdbc.Connection;

import R12.Mysqldl;

public class Fb1 implements Runnable {
	List<Socket> li;
	Socket soc = null;
	Map<String,Socket> map = new HashMap<String,Socket>();
	public Fb1(Socket soc,List<Socket> li,Map<String,Socket> map){
		this.soc = soc;
		this.li = li;
		this.map = map;
	}
	public void run(){
		while(true){
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));//getInputStream���ش��׽��ֵ�������
				String s = null;
				s = br.readLine();
				//����
				Set <String> set = map.keySet();
				String name = "";
				for(String s1: set){
					Socket so = map.get(s1);
					if(soc==so){
						name = s1;
					}
				}
				String s2 = name+"˵��"+s;
				System.out.println(s2);
				//��ʷ��¼
				Connection con = (Connection) Mysqldl.getCon();
				try {
					PreparedStatement psql = con.prepareStatement("insert into Xiaoxi (xx)"
							+"values(?)");
					psql.setString(1,s2);
					psql.executeUpdate();
				} catch (Exception e1) {
					e1.printStackTrace();
				} 				
				//
				//�������û�������Ϣ
				//String s1 = "���������ص���Ϣ"+s;
				PrintWriter pw;
				for(Socket soc1: li){
					pw = new PrintWriter(soc1.getOutputStream());
					pw.write(s2+"\n");
					pw.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
