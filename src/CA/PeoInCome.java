package CA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PeoInCome {
//	ViewInCome view=new ViewInCome();
	Data data=new Data();
	public ArrayList<Direction> countPeoInCome(People people,ArrayList<Block> BMap){
		int x=people.getX();
		int y=people.getY();
		ArrayList<Direction> peoInCome=new ArrayList<Direction>();
		Map<Integer,Double> pni=new HashMap<Integer,Double>();
		Map<Integer,Double> pdi=new HashMap<Integer,Double>();
		for(int i=0;i<10;i++){
			pni.put(i,0.0);
			pdi.put(i,0.0);
		}
		int peopleNumber=0;
		for(int i=0;i<BMap.size();i++){
			if(BMap.get(i).getLogo()==1){
				peopleNumber++;//计算墙的数量
			}
		}
		for(int i=0;i<BMap.size();i++){
			if(BMap.get(i).getLogo()==1){
				if(BMap.get(i).getX()==x & BMap.get(i).getY()==y){
					//System.out.println("this is itserf");
				}
				else{
					double parallel=BMap.get(i).getX()-x;
					double vertical=BMap.get(i).getY()-y;
					if(Math.sqrt(parallel*parallel+vertical*vertical)<data.VIEW_RANGE){
						int quadrat=judeQuadrat(parallel, vertical);
						double theta=countAngelPeopleAndExit(quadrat, parallel, vertical);
						int othersA=judgeAngleAndTheta(theta);
						switch (othersA) {
						case 1:
							pni.put(1, pni.get(1)+1);
							break;
						case 2:
							pni.put(2, pni.get(2)+1);
							break;
						case 3:
							pni.put(3, pni.get(3)+1);
							break;
						case 4:
							pni.put(4, pni.get(4)+1);
							break;
						case 5:
							pni.put(5, pni.get(5)+1);
							break;
						case 6:
							pni.put(6, pni.get(6)+1);
							break;
						case 7:
							pni.put(7, pni.get(7)+1);
							break;
						case 8:
							pni.put(8, pni.get(8)+1);
							break;
						case 9:
							pni.put(9, pni.get(9)+1);
							break;
						default:
							break;
						}
						int otherD=((People) BMap.get(i)).getDirection();
						switch (otherD) {
						case 1:
							pdi.put(1, pdi.get(1)+1);
							break;
						case 2:
							pdi.put(2, pdi.get(2)+1);
							break;
						case 3:
							pdi.put(3, pdi.get(3)+1);
							break;
						case 4:
							pdi.put(4, pdi.get(4)+1);
							break;
						case 5:
							pdi.put(5, pdi.get(5)+1);
							break;
						case 6:
							pdi.put(6, pdi.get(6)+1);
							break;
						case 7:
							pdi.put(7, pdi.get(7)+1);
							break;
						case 8:
							pdi.put(8, pdi.get(8)+1);
							break;
						case 9:
							pdi.put(9, pdi.get(9)+1);
							break;
						default:
							break;
						}
					}
				}
			}
		}
		for(int j=0;j<pdi.size();j++){
			Direction dir=new Direction();
			dir.setDirection(j);
			dir.setInCome((pni.get(j)+pdi.get(j))/peopleNumber);
			peoInCome.add(dir);
		}
		
		return peoInCome;
	}
	public ArrayList<Direction> sortPeoInCome(People people,ArrayList<Block> BMap){
		ArrayList<Direction> peoInCome=new ArrayList<Direction>();
		peoInCome=countPeoInCome(people, BMap);
		for(int i=0;i<peoInCome.size();i++){
			if(peoInCome.get(i)==null){
				peoInCome.remove(i);
				--i;
			}
		}
		for(int i=0;i<peoInCome.size();i++){
			if(peoInCome.get(i).getDirection()==0){
				peoInCome.remove(i);
				--i;
			}
		}
		for(int i=0;i<peoInCome.size()-1;i++){
			for(int j=0;j<peoInCome.size()-1;j++){
				if(peoInCome.get(j).getInCome()<peoInCome.get(j+1).getInCome()){
					Direction d1=peoInCome.get(j);
					Direction d2=peoInCome.get(j+1);
					peoInCome.set(j,d2);
					peoInCome.set(j+1,d1);
					
				}
			}
		}
		return peoInCome;
	}
	public int judgeAngleAndTheta(double theta){
		int d=0;
		if(theta<157.5 & theta >=112.5){
			d=1;
		}
		if(theta<112.5 & theta >=67.5){
			d=2;
		}
		if(theta<67.5 & theta >=22.5){
			d=3;
		}
		if(theta<202.5 & theta >=157.5){
			d=4;
		}
		if(theta<22.5 & theta >=0){
			d=6;
		}
		if(theta<360 & theta >=337.5){
			d=6;
		}
		if(theta<247.5 & theta >=202.5){
			d=7;
		}
		if(theta<292.5 & theta >=247.5){
			d=8;
		}
		if(theta<337.5 & theta >=292.5){
			d=9;
		}
		return d;
	}
	public int  judeQuadrat(double parallel,double vertical){
		int quadrat=0;
		if(vertical<0 & parallel>0){
			quadrat=1;
		}
		else if(vertical<0 & parallel<0){
			quadrat=2;
		}
		else if(vertical>0 & parallel<0){
			quadrat=3;
		}
		else if(vertical>0 & parallel>0){
			quadrat=4;
		}
		else if(vertical==0 & parallel>0){
			quadrat=5;//0
		}
		else if(vertical==0 & parallel<0){
			quadrat=6;//180;
		}
		else if(parallel==0 & vertical<0){
			quadrat=7;//90
		}
		else if(parallel==0 & vertical>0){
			quadrat=8;//270
		}
		else if(parallel==0 & vertical==0){
			quadrat=9;
		}
		else{
			System.out.println("the people on the axis");
		}
		return quadrat;
	}
	public double countAngelPeopleAndExit(int quadrat,double parallel,double vertical){
		double parallelAbs=Math.abs(parallel);
		double verticalAbs=Math.abs(vertical);
		double k=verticalAbs/parallelAbs;
		double theta=0;
		switch (quadrat) {
		case 1:
			theta=Math.atan(k);
			break;
		case 2:
			theta=Math.PI-Math.atan(k);
			break;
		case 3:
			theta=Math.PI+Math.atan(k);
			break;
		case 4:
			theta=Math.PI*2-Math.atan(k);
			break;
		case 5:
			theta=0.001*(Math.random()-0.5);
			break;
		case 6:
			theta=180+0.001*(Math.random()-0.5);
			break;
		case 7:
			theta=90+0.001*(Math.random()-0.5);
			break;
		case 8:
			theta=270+0.001*(Math.random()-0.5);
			break;
		case 9:
			theta=360*(Math.random());
		default:
			System.out.println("countAnglePeoAndExit err");
			break;
		}
		return Math.toDegrees(theta);
	}
}
