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
				//�������������Ϣ
				PrintWriter pw;
				pw = new PrintWriter(soc.getOutputStream());//���ش��׽��ֵ������
				System.out.println("������Ҫ���͵�����");
				String s = z.nextLine();
				pw.write(s+"\n");
				pw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
