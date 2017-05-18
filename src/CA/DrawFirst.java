package CA;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFirst extends JFrame{
	//绘图类
	Data data=new Data();
	int m=data.M;
	JFrame jf;//初始化JFrame组件
	JPanel[][] jp;//初始化JPanel组件
	//构造方法
	public DrawFirst(){
		jf=new JFrame("CA");
		jp=new JPanel[m][m];
		jf.setLayout(new GridLayout(m,m,5,5));//将JPanel网格化
		for(int i=0;i<m;i++){//初始化网格 并上颜色
			for(int j=0;j<m;j++){
				jp[i][j]=new JPanel();
				jp[i][j].setBackground(Color.WHITE);
				jf.add(jp[i][j]);
			}
		}
		jf.setTitle("CA_V0.31");//设置标题
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH);//全屏
		jf.setVisible(true);//jframe设置为显示
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮
	}
	//上颜色方法
	public void onColor(ArrayList<Block> a){
		for(int i=0;i<m;i++){//每次循环前先初始化
			for(int j=0;j<m;j++){
				jp[i][j].setBackground(Color.white);
			}
		}
		for(int i=0;i<a.size();i++){//根据不同的logo值绘出不同的颜色
			int logo=a.get(i).getLogo();
			switch (logo) {
			case 1://peopel
				jp[a.get(i).getX()][a.get(i).getY()].setBackground(Color.blue);
				break;
			case 0:// null
				jp[a.get(i).getX()][a.get(i).getY()].setBackground(Color.white);
				break;
			case 10://wall
				jp[a.get(i).getX()][a.get(i).getY()].setBackground(Color.PINK);
				break;
			case 100://exit
				jp[a.get(i).getX()][a.get(i).getY()].setBackground(Color.DARK_GRAY);
				break;
			case 50://view point
				jp[a.get(i).getX()][a.get(i).getY()].setBackground(Color.GREEN);
				break;
			default:
				jp[a.get(i).getX()][a.get(i).getY()].setBackground(Color.BLACK);
				break;
			}
		}
	}
}
