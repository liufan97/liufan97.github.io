//������1
package R10;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;

public class Wzq1 extends JComponent implements MouseListener{
	java.util.List<Point> pt = new ArrayList<Point>();
	//List<Socket> li = null;
	private  boolean hb;
	private int cx = 0;
	private int cy = 0;
	boolean ss = false;
	static boolean ks = false;
	public static void getK(boolean ks){
		Wzq1.ks = ks;
	}
	public void JB(){
		JButton jb1 = Wzq.jb1;
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	public Wzq1(){
		//
		this.addMouseListener(this);
	}
	public void paint(Graphics g){
		//����
		for(int i=0;i<11;i++){
			g.drawLine((i*60+60),60,(i*60+60),660);
			g.drawLine(60,(i*60+60),660,(i*60+60));
		}
		//������
			for(Point p:pt){
				g.setColor(p.getColor());
				g.fillOval(p.getX(),p.getY(),60,60);
			}
		//�ж�
		panduan();
		//
		if(ss == true){
			g.setFont(new Font("΢���ź�",Font.ITALIC,60));
			g.drawString("Ӯ",300,300);
		}
	}
	public void mouseClicked(MouseEvent e) {
		//��ȡ������������
		int x = e.getX()-30;
		int y = e.getY()-30;
		//�����Ӷ���
		x = Math.round(x/60)*60+30;
		y = Math.round(y/60)*60+30;
		cx = x;
		cy = y;
		//�Ƿ��ظ�
		boolean is = false;
		for(Point p:pt){
			if(p.getX() == x && p.getY() == y){
				is = true;
			}
		}
		//
		//
		if(!is){//�Ƿ��ظ�
			Point point = new Point(x,y);
			if(hb == true){
				point.setColor(Color.BLACK);
				hb = false;
			}else{
				point.setColor(Color.white);
				hb = true;
			}
			if(ss == false){
				if(ks){
					pt.add(point);//
				}
			}
			//�û�����
			this.repaint();
		}
		System.out.println("���Ӹ���"+pt.size());
	}
	//�жϸ������Ƿ�������
	public Point fp(int x,int y){
		for(Point p:pt){
			if(p.getX() == x && p.getY() == y){
				return p;
			}
		}
		return null;
	}
	//�ж���Ӯ
	public void panduan(){
		int sl = 0;
		//��
		for(int i=cx;i<=600;i+=60){
			Point p = fp(i,cy);
			if(p!=null){
				if(hb != true){
					if(p.getColor() == Color.BLACK){
						sl++;
					}else{
						break;
					}
				}
				if(hb != false){
					if(p.getColor() == Color.white){
						sl++;
					}else{
						break;
					}
				}
			}
		}
		//��
		for(int i=cx-60;i>=0 && cy>=0;i-=60){
			Point p = fp(i,cy);
			if(fp(i,cy)!=null){
				if(hb != true){
					if(p.getColor() == Color.BLACK){
						sl++;
					}else{
						break;
					}
				}
				if(hb != false){
					if(p.getColor() == Color.white){
						sl++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(hb != true){
			System.out.println("���Ӷ����������"+sl);
		}else{
			System.out.println("���Ӷ����������"+sl);
		}
		if(sl>=5){
			System.out.print("Ӯ");
			ss = true;
		}
		//��
		int sl1 = 0;
		for(int i=cy-60;i>=0 && cx>=0;i-=60){
			Point p = fp(cx,i);
			if(fp(cx,i)!=null){
				if(hb != true){
					if(p.getColor() == Color.BLACK){
						sl1++;
					}else{
						break;
					}
				}
				if(hb != false){
					if(p.getColor() == Color.white){
						sl1++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//��
		for(int i=cy;i<=600 && cx>=0;i+=60){
			Point p = fp(cx,i);
			if(fp(cx,i)!=null){
				if(hb != true){
					if(p.getColor() == Color.BLACK){
						sl1++;
					}else{
						break;
					}
				}
				if(hb != false){
					if(p.getColor() == Color.white){
						sl1++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(hb != true){
			System.out.println("�����ϱ��������"+sl1);
		}else{
			System.out.println("�����ϱ��������"+sl1);
		}
		if(sl1>=5){
			System.out.print("Ӯ");
			ss = true;
		}
		//����
		int sl2 = 0;
		for(int n=cx-60,i=cy+60;i<=600 && n>=0;i+=60,n-=60){
			Point p = fp(n,i);
			if(fp(n,i)!=null){
				if(hb != true){
					if(p.getColor() == Color.BLACK){
						sl2++;
					}else{
						break;
					}
				}
				if(hb != false){
					if(p.getColor() == Color.white){
						sl2++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		
		//����
		for(int n=cx,i=cy;i>=0 && n<=600;i-=60,n+=60){
			Point p = fp(n,i);
			if(fp(n,i)!=null){
				if(hb != true){
					if(p.getColor() == Color.BLACK){
						sl2++;
					}else{
						break;
					}
				}
				if(hb != false){
					if(p.getColor() == Color.white){
						sl2++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(hb != true){
			System.out.println("�������϶����������"+sl2);
		}else{
			System.out.println("�������϶����������"+sl2);
		}
		if(sl2>=5){
			System.out.print("Ӯ");
			ss = true;
		}
		//����
		int sl3 = 0;
		for(int n=cx-60,i=cy-60;i>=0 && n>=0 ;i-=60,n-=60){
			Point p = fp(n,i);
			if(fp(n,i)!=null){
				if(hb != true){
					if(p.getColor() == Color.BLACK){
						sl3++;
					}else{
						break;
					}
				}
				if(hb != false){
					if(p.getColor() == Color.white){
						sl3++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		//����
		for(int n=cx,i=cy;i<=600 && n<=600;i+=60,n+=60){
			Point p = fp(n,i);
			if(fp(n,i)!=null){
				if(hb != true){
					if(p.getColor() == Color.BLACK){
						sl3++;
					}else{
						break;
					}
				}
				if(hb != false){
					if(p.getColor() == Color.white){
						sl3++;
					}else{
						break;
					}
				}
			}else{
				break;
			}
		}
		if(hb != true){
			System.out.println("���Ӷ��������������"+sl3);
		}else{
			System.out.println("���Ӷ��������������"+sl3);
		}
		if(sl3>=5){
			System.out.print("Ӯ");
			ss = true;
		}
		//
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}