package R2;

import java.io.*;
import java.net.*;

public class Fb3 implements Runnable{
	Socket soc = null;
	public Fb3(Socket soc){
		this.soc = soc;
	}
	public void run(){
		while(true){
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				String fh = null;
				//����
				fh = br.readLine();
				System.out.println("�������˷�����ϢΪ��"+fh);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
