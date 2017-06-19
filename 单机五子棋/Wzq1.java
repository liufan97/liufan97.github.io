//五子棋1
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
		//画线
		for(int i=0;i<11;i++){
			g.drawLine((i*60+60),60,(i*60+60),660);
			g.drawLine(60,(i*60+60),660,(i*60+60));
		}
		//画棋子
			for(Point p:pt){
				g.setColor(p.getColor());
				g.fillOval(p.getX(),p.getY(),60,60);
			}
		//判断
		panduan();
		//
		if(ss == true){
			g.setFont(new Font("微软雅黑",Font.ITALIC,60));
			g.drawString("赢",300,300);
		}
	}
	public void mouseClicked(MouseEvent e) {
		//获取鼠标点击点的坐标
		int x = e.getX()-30;
		int y = e.getY()-30;
		//将棋子对齐
		x = Math.round(x/60)*60+30;
		y = Math.round(y/60)*60+30;
		cx = x;
		cy = y;
		//是否重复
		boolean is = false;
		for(Point p:pt){
			if(p.getX() == x && p.getY() == y){
				is = true;
			}
		}
		//
		//
		if(!is){//是否重复
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
			//用户触发
			this.repaint();
		}
		System.out.println("棋子个数"+pt.size());
	}
	//判断该坐标是否有棋子
	public Point fp(int x,int y){
		for(Point p:pt){
			if(p.getX() == x && p.getY() == y){
				return p;
			}
		}
		return null;
	}
	//判断输赢
	public void panduan(){
		int sl = 0;
		//东
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
		//西
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
			System.out.println("黑子东西方向个数"+sl);
		}else{
			System.out.println("白子东西方向个数"+sl);
		}
		if(sl>=5){
			System.out.print("赢");
			ss = true;
		}
		//北
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
		//南
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
			System.out.println("黑子南北方向个数"+sl1);
		}else{
			System.out.println("白子南北方向个数"+sl1);
		}
		if(sl1>=5){
			System.out.print("赢");
			ss = true;
		}
		//西南
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
		
		//东北
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
			System.out.println("黑子西南东北方向个数"+sl2);
		}else{
			System.out.println("白子西南东北方向个数"+sl2);
		}
		if(sl2>=5){
			System.out.print("赢");
			ss = true;
		}
		//西北
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
		//东南
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
			System.out.println("黑子东南西北方向个数"+sl3);
		}else{
			System.out.println("白子东南西北方向个数"+sl3);
		}
		if(sl3>=5){
			System.out.print("赢");
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