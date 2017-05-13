package CA;

import java.util.ArrayList;

public class RunFunction {
	public static void main(String[] args) {
		Data data=new Data();
		Rule rule=new Rule();
		View view=new View();
		int m=data.M;
		DrawFirst DF=new DrawFirst();
		ArrayList<Block> BMap=new ArrayList<Block>();
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
		Wall exit=new Wall(data.EXIT_X,data.EXIT_Y,100);
		BMap.add(exit);
//		for(int i=0;i<10;i++){
//			People pp=new People((int)(Math.random()*8)+2,(int)(Math.random()*8)+2,1);
//			BMap.add(pp);
//		}
		People peo1=new People(3, 3, 1);
		People peo2=new People(5,3,1);
		BMap.add(peo1);
		BMap.add(peo2);
		DF.onColor(BMap);
		while(true){
			for(int i=0;i<BMap.size();i++){
				if(BMap.get(i).logo==1){
					People p=(People) BMap.get(i);
					int direction = view.countPeopleAndExit(p);
					System.out.println(direction+"direction");
					if(rule.checkCrashWall(p)){
						System.out.println("crash the wall");
					}
					else{
//						if(rule.checkCrashOhters(BMap, p, direction)){
//							
//						}
//						else{
//							
//							
//						}
						p.move(direction);
					}
					
					
				}
				
			}
			
			 try {
	             Thread.sleep(1000);
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
			
			 DF.onColor(BMap);

		}
		
	}
	
}
