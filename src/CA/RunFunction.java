package CA;

import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

public class RunFunction {
	public static void main(String[] args) {
		Data data=new Data();
		Rule rule=new Rule();
		ViewInCome viewInCome=new ViewInCome();
		DrawFirst DF=new DrawFirst();
		ArrayList<Block> BMap=new ArrayList<Block>(); //包含所有的地图数据
		ArrayList<People>PMap=new ArrayList<People>();//包含行人数据
		int h=0;//循环次数计数器
		int wallNumber=0;//墙的数量
		int m=data.M;
		//------------绘出四周的墙壁-------------------------
		for(int i=0;i<m;i++){
				Wall wallL=new Wall(i,0,10);
				Wall wallR=new Wall(i,m-1,10);
				Wall wallU=new Wall(0,i,10);
				Wall wallD=new Wall(m-1,i,10);
				BMap.add(wallD);
				BMap.add(wallU);
				BMap.add(wallL);
				BMap.add(wallR);
		}
		//-------------------------------------------
		//------------------绘制出口-----------------------
		Wall exit=new Wall(data.EXIT_X,data.EXIT_Y,100);
		BMap.add(exit);
		//-------------------------------------------------
		//------------------绘制记忆点-------------------------
//		View view1=new View(10, 10, 50);
//		View view2=new View(15, 8, 50);
//		View view3=new View(1, 9, 50);
//		View view4=new View(3, 2, 50);
//		BMap.add(view1);
//		BMap.add(view2);
//		BMap.add(view3);
//		BMap.add(view4);
		//-------------------------------------------------
		for(int i=0;i<BMap.size();i++){
			if(BMap.get(i).getLogo()!=1){
				wallNumber++;//计算墙的数量
			}
		}
		//--------------这里是产生随机行人的代码--------------------------
		while(BMap.size()-wallNumber<45){//产生不重复的随机的行人
			boolean flag=true;
			int rx=(int)(Math.random()*18)+2;//随机x y坐标
			int ry=(int)(Math.random()*18)+2;
			for(int i=0;i<BMap.size();i++){
				if(BMap.get(i).getX()==rx & BMap.get(i).getY()==ry){//如果有重复的
					flag=false;
				}
			}
			if(flag){
				People pp=new People(rx, ry, 1);//产生行人数据并添加到地图数据
				BMap.add(pp);
			}
		}
		//--------------------------------------------------------------
		
		//----------------这里是产生指定行人的代码--------------------------------
//		People peo1=new People(3, 28, 1);
//		//People peo2=new People(5,3,1);
//		BMap.add(peo1);
//		//BMap.add(peo2);
		//--------------------------------------------------------------
		
		DF.onColor(BMap);//首先绘出初始地图
		for(int i=0;i<BMap.size();i++){
			if(BMap.get(i).getLogo()==1){
				PMap.add((People) BMap.get(i));//将行人数据添加到行人集合
			}
		}
		while(true){
			ArrayList<People> peopleNext=new ArrayList<>();
//				People pse=new People(0, 0, 25);
//				peopleNext.add(pse);
			for(int i=0;i<BMap.size();i++){//遍历所有地图数据
				if(BMap.get(i).logo==1){//如果是行人
					//People p=(People) BMap.get(i);//得到该行人对象
					int direction=rule.getCorrectDirection(BMap, (People) BMap.get(i));//获取方向
					direction=rule.changeFive(BMap,(People) BMap.get(i), direction);//如果方向是5 则尝试产生一个随机方向，避免一直在原地
//					if(rule.isPeopleNext( peopleNext, (People) BMap.get(i), direction)){
//						rule.changePeoNext(peopleNext,(People) BMap.get(i), direction);
//					}
//					else{
//						direction=5;
//					}
					 ((People) BMap.get(i)).setDirection(direction);
					((People) BMap.get(i)).setX(moveX((People) BMap.get(i), direction));
					((People) BMap.get(i)).setY(moveY((People) BMap.get(i), direction));
//					if(rule.deletePeople((People) BMap.get(i))){//如果到达出口
//						BMap.remove(i);//从地图数据上移除行人
//						//PMap.remove(i);
//						--i;//i-1
//					}
				}
			}
			 try {
	             Thread.sleep(1000);
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
			 h++;//计数器加1
			 int peoNumber=BMap.size()-wallNumber;
			 //System.out.println("after---"+h+"---times,surplus---"+peoNumber+"---people");
			 DF.onColor(BMap);
		}
	}
	public static int moveX(People people,int d){
		int x=people.getX();
		switch (d) {
		case 1:
			x=x-1;
			break;
		case 2:
			x=x-1;
			break;
		case 3:
			x=x-1;
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			x=x+1;
			break;
		case 8:
			x=x+1;
			break;
		case 9:
			x=x+1;
			break;
		default:
			break;
		}
		return x;
	}
	public static int moveY(People people,int d){
		int y=people.getY();
		switch (d) {
		case 1:
			y=y-1;
			break;
		case 2:
			break;
		case 3:
			y=y+1;
			break;
		case 4:
			y=y-1;
			break;
		case 5:
			break;
		case 6:
			y=y+1;
			break;
		case 7:
			y=y-1;
			break;
		case 8:
			break;
		case 9:
			y=y+1;
			break;
		default:
			break;
		}
		return y;
	}
}
