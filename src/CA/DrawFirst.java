package CA;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFirst extends JFrame{
	Data data=new Data();
	int m=data.M;
	JFrame jf;
	JPanel[][] jp;
	public DrawFirst(){
		jf=new JFrame("CA");
		jf.setSize(600, 600);
		jp=new JPanel[m][m];
		
		jf.setLayout(new GridLayout(m,m,5,5));
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				jp[i][j]=new JPanel();
				jp[i][j].setBackground(Color.WHITE);
				jf.add(jp[i][j]);
			}
		}
		jf.setTitle("CA_V0.31");
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}


	public void onColor(ArrayList<Block> a){
		for(int i=0;i<m;i++){
			for(int j=0;j<m;j++){
				jp[i][j].setBackground(Color.white);
			}
		}
		for(int i=0;i<a.size();i++){
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
			default:
				jp[a.get(i).getX()][a.get(i).getY()].setBackground(Color.BLACK);
				break;
			}
		}
	}
	
	
	
	
	
	
}
