package CA;

import java.lang.annotation.Documented;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewInCome {
	Data data=new Data();
	PeoInCome peoIn=new PeoInCome();
	double exitX=data.EXIT_X;
	double exitY=data.EXIT_Y;
//	public int countPeopleAndExit(People people){
//		int d;
//		ArrayList<Direction> viewInComeAll=outPutDirection(people);
//		d=viewInComeAll.get(0).getDirection();
////		for(int i=0;i<viewInComeAll.size();i++){
////			System.out.println(viewInComeAll.get(i).getDirection()+"---"+viewInComeAll.get(i).getInCome());
////		}
//		System.out.println("d="+d);
//		return d;	
//	}
	
	
	
	
	
	
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
	public double anticlock(double theta){
		double thetaMid=theta+data.VIEW_ANGLE;
		double theta1;
		if(thetaMid>=360){
			theta1=thetaMid-360;
		}
		else{
			theta1=thetaMid;
		}
		return theta1;
	}
	public double clock(double theta){
		double thetaMid=theta-data.VIEW_ANGLE;
		double theta2;
		if(thetaMid<0){
			theta2=360+thetaMid;
		}
		else{
			theta2=thetaMid;
		}
		return theta2;
	}
	public Map<Integer,Double> countTheta1(double theta1,Map<Integer,Double>viewInCome1){
		if(theta1<157.5 & theta1 >=112.5){
			viewInCome1.put(1, (theta1-112.5)/45);
		}
		if(theta1<112.5 & theta1 >=67.5){
			viewInCome1.put(2, (theta1-67.5)/45);
		}
		if(theta1<67.5 & theta1 >=22.5){
			viewInCome1.put(3, (theta1-22.5)/45);
		}
		if(theta1<202.5 & theta1 >=157.5){
			viewInCome1.put(4, (theta1-157.5)/45);
		}
		if(theta1<22.5 & theta1 >=0){
			viewInCome1.put(6, (theta1+22.5)/45);
		}
		if(theta1<360 & theta1 >=337.5){
			viewInCome1.put(6, (theta1-337.5)/45);
		}
		if(theta1<247.5 & theta1 >=202.5){
			viewInCome1.put(7, (theta1-202.5)/45);
		}
		if(theta1<292.5 & theta1 >=247.5){
			viewInCome1.put(8, (theta1-247.5)/45);
		}
		if(theta1<337.5 & theta1 >=292.5){
			viewInCome1.put(9, (theta1-292.5)/45);
		}
		return viewInCome1;
	}
	//count the income of theta2
	public Map<Integer,Double> countTheta2(double theta2,Map<Integer,Double>viewInCome2){
		if(theta2<157.5 & theta2 >=112.5){
			viewInCome2.put(1, (157.5-theta2)/45);
		}
		if(theta2<112.5 & theta2 >=67.5){
			viewInCome2.put(2, (112.5-theta2)/45);
		}
		if(theta2<67.5 & theta2 >=22.5){
			viewInCome2.put(3, (67.5-theta2)/45);
		}
		if(theta2<202.5 & theta2 >=157.5){
			viewInCome2.put(4, (202.5-theta2)/45);
		}
		if(theta2<22.5 & theta2 >=0){
			viewInCome2.put(6, (22.5-theta2)/45);
		}
		if(theta2<360 & theta2 >=337.5){
			viewInCome2.put(6, (382.5-theta2)/45);
		}
		if(theta2<247.5 & theta2 >=202.5){
			viewInCome2.put(7, (247.5-theta2)/45);
		}
		if(theta2<292.5 & theta2 >=247.5){
			viewInCome2.put(8, (292.5-theta2)/45);
		}
		if(theta2<337.5 & theta2 >=292.5){
			viewInCome2.put(9, (337.5-theta2)/45);
		}
		return viewInCome2;
	}
	//count the gird complete in theta1 and  theta2
	public Map<Integer,Double> isCompleteInTheta(double theta1,double theta2,Map<Integer,Double>viewInComeCom){
		if(theta1>=157.5 & theta2<=112.5){
			viewInComeCom.put(1,1.01);
		}
		if(theta1>=112.5 & theta2<=67.5){
			viewInComeCom.put(2,1.01);
		}
		if(theta1>=67.5 & (theta2<=22.5 | theta2>theta1)){
			viewInComeCom.put(3,1.01);
		}
		if(theta1>=202.5 & theta2<=157.5){
			viewInComeCom.put(4,1.01);
		}
		if(theta1>=22.5 & theta2>=337.5){
			viewInComeCom.put(6,1.01);
		}
		if(theta1>=247.5 & theta2<=202.5){
			viewInComeCom.put(7,1.01);
		}
		if(theta1>=292.5 & theta2<=247.5){
			viewInComeCom.put(8,1.01);
		}
		if(theta1>=337.5 & theta2<=292.5){
			viewInComeCom.put(9,1.01);
		}
		return viewInComeCom;
	}
	public ArrayList addViemInCome(Map<Integer,Double> viewInCome1,Map<Integer,Double> viewInCome2,Map<Integer,Double> viewInComeCom,Map<Integer,Double> seeExitInCome){
		ArrayList<Direction> viewInComeAll=new ArrayList<>();
		for(int i=0;i<10;i++){
			Direction d=new Direction();
			viewInComeAll.add(d);
		}
		for(int i=0;i<viewInCome1.size();i++){
			Direction dir=new Direction();
			dir.setDirection(i);
			dir.setInCome(viewInCome1.get(i)+viewInCome2.get(i)+viewInComeCom.get(i)+0.00001*Math.random());
			viewInComeAll.add(dir);
		}
		return viewInComeAll;
	
	}
	public ArrayList<Direction> addAllInCome(ArrayList<Direction> viewInComeAll,ArrayList<Direction> peoInComeAll){
		ArrayList<Direction> inComeAll=new ArrayList<Direction>();
		for(int i=0;i<viewInComeAll.size();i++){
			for(int j=0;j<peoInComeAll.size();j++){
				if(viewInComeAll.get(i).getDirection()==peoInComeAll.get(j).getDirection()){
					Direction d=new Direction();
					d.setDirection(viewInComeAll.get(i).getDirection());
					d.setInCome(viewInComeAll.get(i).getInCome()+peoInComeAll.get(j).getDirection());
					inComeAll.add(d);
				}
			}
		}
		return inComeAll;
	}
	public ArrayList<Direction> outPutDirection(People people,ArrayList<Block> BMap){
		Map<Integer,Double> viewInCome1=new HashMap<Integer,Double>();
		Map<Integer,Double> viewInCome2=new HashMap<Integer,Double>();
		Map<Integer,Double> viewInComeCom=new HashMap<Integer,Double>();
		Map<Integer,Double> seeExitInCome=new HashMap<Integer,Double>();
		
		ArrayList<Direction> viewInComeAll=new ArrayList<>();
		ArrayList<Direction> inComeAll=new ArrayList<>();
		ArrayList<Direction> peoInComeAll=new ArrayList<>();
		peoInComeAll=peoIn.countPeoInCome(people, BMap);
		for(int i=0;i<10;i++){
			viewInCome1.put(i, 0.0);
			viewInCome2.put(i, 0.0);
			viewInComeCom.put(i, 0.0);
			seeExitInCome.put(i, 0.0);
		}
		int x=people.getX();
		int y=people.getY();
		double parallel=exitY-people.getY();
		double vertical=exitX-people.getX();
		int quadrat=judeQuadrat(parallel, vertical);
		double theta=countAngelPeopleAndExit(quadrat, parallel, vertical);
		double theta1=anticlock(theta);
		double theta2=clock(theta);
		viewInCome1=countTheta1(theta1, viewInCome1);
		viewInCome2=countTheta2(theta2, viewInCome2);
		viewInComeCom=isCompleteInTheta(theta1, theta2, viewInComeCom);
		viewInComeAll=addViemInCome(viewInCome1, viewInCome2, viewInComeCom, seeExitInCome);
		inComeAll=addAllInCome(viewInComeAll, peoInComeAll);
		for(int i=0;i<inComeAll.size();i++){
			if(inComeAll.get(i)==null | inComeAll.get(i).getDirection()==0){
				inComeAll.remove(i);
				--i;
			}
		}
		for(int i=0;i<inComeAll.size()-1;i++){
			for(int j=0;j<inComeAll.size()-1;j++){
				if(inComeAll.get(j).getInCome()<inComeAll.get(j+1).getInCome()){
					Direction d1=inComeAll.get(j);
					Direction d2=inComeAll.get(j+1);
					inComeAll.set(j, d2);
					inComeAll.set(j+1,d1);
				}
			}
		}
		return inComeAll;
	}
}
