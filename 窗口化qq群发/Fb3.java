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
				//阻塞
				fh = br.readLine();
				System.out.println("服务器端返回消息为："+fh);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
