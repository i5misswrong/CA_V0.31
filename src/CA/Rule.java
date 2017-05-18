package CA;

import java.util.ArrayList;

public class Rule {
	Data data=new Data();
	ViewInCome view=new ViewInCome();
	PeoInCome PInCome=new PeoInCome();
	public boolean checkCrashWall(People peo,int d){
		boolean flag=false;
		int x=peo.getX();
		int y=peo.getY();
		int px=x;
		int py=y;
		switch (d) {
		case 1:
			px=x-1;
			py=y-1;
			break;
		case 2:
			px=x-1;
			break;
		case 3:
			px=x-1;
			py=y+1;
			break;
		case 4:
			py=y-1;
			break;
		case 5:
			break;
		case 6:
			py=y+1;
			break;
		case 7:
			px=x+1;
			py=y-1;
			break;
		case 8:
			px=x+1;
			break;
		case 9:
			px=x+1;
			py=y+1;
			break;
		default:
			break;
		}
		if(isExitOK(peo, d)){
			flag=false;
		}
		else{
			if((peo.getX()<=1 | peo.getX()>data.M-2 | peo.getY()<=1 | peo.getY()>data.M-2)){
				flag=true;
			}
			if(px<1 | px>data.M-2 | py<1 | py>data.M-2){
				if(isExitOK(peo, d)){
					flag=false;
				}
				else{
					flag=true;
				}
				
			}
		}
		
		return flag;
	}
	
	
	public boolean isCrashOthers(ArrayList<Block> BMap,People people,int d){
		boolean flag=true;
		int x=people.getX();
		int y=people.getY();
		int px=x;
		int py=y;
		switch (d) {
		case 1:
			px=x-1;
			py=y-1;
			break;
		case 2:
			px=x-1;
			break;
		case 3:
			px=x-1;
			py=y+1;
			break;
		case 4:
			py=y-1;
			break;
		case 5:
			break;
		case 6:
			py=y+1;
			break;
		case 7:
			px=x+1;
			py=y-1;
			break;
		case 8:
			px=x+1;
			break;
		case 9:
			px=x+1;
			py=y+1;
			break;
		default:
			break;
		}
		for(int i=0;i<BMap.size();i++){
			if(BMap.get(i).getLogo()==1){
				if(BMap.get(i).getX()==x & BMap.get(i).getY()==y){
					//System.out.println("this is itserf");
				}
				else{
					if(px==BMap.get(i).getX() & py==BMap.get(i).getY()){
						flag=false;
					}
				}
			}
			
		}
		return flag;
	}
	public int  getCorrectDirection(ArrayList<Block> BMap,People people){
		ArrayList<Direction> arrDir=new ArrayList<Direction>();
		ArrayList<Direction> arrDirOnlyPeo=new ArrayList<Direction>();
		arrDir=view.outPutDirection(people,BMap);
		arrDirOnlyPeo=PInCome.sortPeoInCome(people, BMap);
		int direction=0;
		int h=0;
		boolean ff=false;
		if(people.getX()>data.EXIT_X & people.getX()<=data.EXIT_X+2 & people.getY()>=data.EXIT_Y-1 & people.getY()<=data.EXIT_Y+1){
			direction=forceDirection(people);
			if(!isCrashOthers(BMap, people, direction)){
				direction=5;
			}
		}
		else{
			if(isInViewRange(BMap, people)){
				while((!isCrashOthers(BMap, people, arrDir.get(h).getDirection()))|(checkCrashWall(people,arrDir.get(h).getDirection()))){
					h++;
					if(h>8){
						ff=true;
						break;
					}
				}
				if(ff){
					direction=5;
				}
				else{
					direction=arrDir.get(h).getDirection();
				}
			}
			else{
				while((!isCrashOthers(BMap, people, arrDirOnlyPeo.get(h).getDirection()))|(checkCrashWall(people,arrDirOnlyPeo.get(h).getDirection()))){
					h++;
					if(h>8){
						ff=true;
						break;
					}
				}
				if(ff){
					direction=5;
				}
				else{
					direction=arrDirOnlyPeo.get(h).getDirection();
				}
			}
			
		}
		
		return direction;
	}
	public boolean isExitOK(People people,int d){//there have problem
		int x=people.getX();
		int y=people.getY();
		int px=x;
		int py=y;
		boolean flag=false;
		switch (d) {
		case 1:
			px=x-1;
			py=y-1;
			break;
		case 2:
			px=x-1;
			break;
		case 3:
			px=x-1;
			py=y+1;
			break;
		case 4:
			py=y-1;
			break;
		case 5:
			break;
		case 6:
			py=y+1;
			break;
		case 7:
			px=x+1;
			py=y-1;
			break;
		case 8:
			px=x+1;
			break;
		case 9:
			px=x+1;
			py=y+1;
			break;
		default:
			break;
		}
		if(px==data.EXIT_X & py==data.EXIT_Y){
			flag=true;
		}
		return flag;
	}
	public boolean deletePeople(People people){
		boolean flag=false;
		if(people.getX()==data.EXIT_X+1 & people.getY()==data.EXIT_Y){
			flag=true;
		}
		return flag;
	}
	public int forceDirection(People people){
		int direction=0;
		if(people.getX()==data.EXIT_X+1 & people.getY()==data.EXIT_Y-1){
			direction=6;
		}
		else if(people.getX()==data.EXIT_X+2 & people.getY()==data.EXIT_Y-1){
			direction=3;
		}
		else if(people.getX()==data.EXIT_X+2 & people.getY()==data.EXIT_Y){
			direction=2;
		}
		else if(people.getX()==data.EXIT_X+2 & people.getY()==data.EXIT_Y+1){
			direction=1;
		}
		else if(people.getX()==data.EXIT_X+1 & people.getY()==data.EXIT_Y+1){
			direction=4;
		}
		return direction;
	}
	public int changeFive(ArrayList<Block> BMap,People people,int d){
		int dir=d;
		if(d==5){
			dir=(int)Math.random()*9;
			int h=0;
			boolean flag=true;
			while(((isCrashOthers(BMap, people, dir)|(!checkCrashWall(people,dir)))) & flag){
				dir=(int)(Math.random()*10);
				h++;
				if(h>100){
					flag=false;
				}
				
			}
			if(!flag){
				dir=5;
			}
		}
		return dir;
	}
	
	public boolean isInViewRange(ArrayList<Block> BMap,People people){
		boolean flag=false;
		int x=people.getX();
		int y=people.getY();
		for(int i=0;i<BMap.size();i++){
			if(BMap.get(i).getLogo()==50){
				double parallel=BMap.get(i).getY()-y;
				double vartical=BMap.get(i).getX()-x;
				double distance=Math.sqrt(parallel*parallel+vartical*vartical);
				if(distance<data.VIEW_RANGE){
					flag=true;
				}
			}
		}
		return flag;
	}
	public boolean isPeopleNext(ArrayList<People> peopleNext,People people,int d){
		int x=people.getX();
		int y=people.getY();
		int px=x;
		int py=y;
		boolean flag=true;
		switch (d) {
		case 1:
			px=x-1;
			py=y-1;
			break;
		case 2:
			px=x-1;
			break;
		case 3:
			px=x-1;
			py=y+1;
			break;
		case 4:
			py=y-1;
			break;
		case 5:
			break;
		case 6:
			py=y+1;
			break;
		case 7:
			px=x+1;
			py=y-1;
			break;
		case 8:
			px=x+1;
			break;
		case 9:
			px=x+1;
			py=y+1;
			break;
		default:
			break;
		}
		for(int i=0;i<peopleNext.size();i++){
			if(peopleNext.get(i).getX()==px & peopleNext.get(i).getY()==py){
				flag=false;
			}
			else{
				flag=true;
			}
		}
		
		return flag;
	}
	public ArrayList<People> changePeoNext(ArrayList<People> peoNext,People people,int d){
		int x=people.getX();
		int y=people.getY();
		int px=x;
		int py=y;
		switch (d) {
		case 1:
			px=x-1;
			py=y-1;
			break;
		case 2:
			px=x-1;
			break;
		case 3:
			px=x-1;
			py=y+1;
			break;
		case 4:
			py=y-1;
			break;
		case 5:
			break;
		case 6:
			py=y+1;
			break;
		case 7:
			px=x+1;
			py=y-1;
			break;
		case 8:
			px=x+1;
			break;
		case 9:
			px=x+1;
			py=y+1;
			break;
		default:
			break;
		}
		People p=new People(px,py,1);
		peoNext.add(p);
		for(int i=0;i<peoNext.size();i++){
			if(peoNext.get(i).getX()==x & peoNext.get(i).getY()==y){
				peoNext.remove(i);
				--i;
			}
		}
		return peoNext;
		
	}
	public int moveX(People people,int d){
		int x=people.getX();
		int px=x;
		switch (d) {
		case 1:
			px=x-1;
			break;
		case 2:
			px=x-1;
			break;
		case 3:
			px=x-1;
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			px=x+1;
			break;
		case 8:
			px=x+1;
			break;
		case 9:
			px=x+1;
			break;
		default:
			break;
		}
		return px;
	}
	public int moveY(People people,int d){
		int y=people.getY();
		int py=y;
		switch (d) {
		case 1:
			py=y-1;
			break;
		case 2:
			break;
		case 3:
			py=y+1;
			break;
		case 4:
			py=y-1;
			break;
		case 5:
			break;
		case 6:
			py=y+1;
			break;
		case 7:
			py=y-1;
			break;
		case 8:
			break;
		case 9:
			py=y+1;
			break;
		default:
			break;
		}
		return py;
	}
}
