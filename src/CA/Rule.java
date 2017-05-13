package CA;

import java.util.ArrayList;

public class Rule {
	Data data=new Data();
	public boolean checkCrashWall(People peo){
		boolean flag=false;
		if(peo.getX()<2 | peo.getX()>data.M-1 | peo.getY()<2 | peo.getY()>data.M-1){
			flag=true;
		}
		return flag;
	}
	public boolean checkCrashOhters(ArrayList<Block> BMap,People peo,int d){
		boolean flag=false;
		int x=peo.getX();
		int y=peo.getY();
		int px=x;
		int py=y;
		switch (d) {
		case 2:
			px=x-1;
			break;
		case 4:
			py=y-1;
			break;
		case 6:
			py=y+1;
			break;
		case 8:
			px=x+1;
			break;
		default:
			break;
		}
		for(int i=0;i<BMap.size();i++){
			if(BMap.get(i).logo==1){
				if(BMap.get(i).getX()==px & BMap.get(i).getY()==py){
					flag=true;
				}
			}
			
		}
		return flag;
	}
}
