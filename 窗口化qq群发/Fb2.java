package R2;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Fb2  implements Runnable{
	Socket soc = null;
	Scanner z = new Scanner(System.in);
	public Fb2(Socket soc){
		this.soc = soc;
	}
	public void run(){
		while(true){
			try {
				//向服务器发送消息
				PrintWriter pw;
				pw = new PrintWriter(soc.getOutputStream());//返回此套接字的输出流
				System.out.println("请输入要发送的内容");
				String s = z.nextLine();
				pw.write(s+"\n");
				pw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
