package R2;
import java.net.*;
import java.util.*;
import java.io.*;

public class Zy {
	public static void main(String[] args) throws IOException {
		ServerSocket ser = new ServerSocket(9999);
		System.out.println("�������������");
		//��¼�û�
		List<Socket> li = new ArrayList<Socket>();
		//
		Map<String,Socket> map = new HashMap<String,Socket>();
		while(true){
			//���û�
			Socket soc = ser.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String name = br.readLine();
			map.put(name,soc);//ӳ�����ֺͿͻ���
			li.add(soc);
			System.out.println(li);
			new Thread(new Fb1(soc,li,map)).start();
		}
	}
}
