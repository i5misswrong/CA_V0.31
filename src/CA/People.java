package CA;

public class People extends Block{
	Data data=new Data();
	int x;
	int y;
	int logo;
	int direction;
	double viewInCome[][]=new double[data.M][data.M];
	People(int x,int y,int logo){
		super(x,y,logo);
		this.x=x;
		this.y=y;
		this.logo=logo;
	}
	
	
	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public double[][] getViewInCome() {
		return viewInCome;
	}


	public void setViewInCome(double[][] viewInCome) {
		this.viewInCome = viewInCome;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLogo() {
		return logo;
	}

	public void setLogo(int logo) {
		this.logo = logo;
	}

	public void move(int d){
		switch (d) {
		case 1:
			x=x-1;
			y=y-1;
			break;
		case 2:
			x=x-1;
			break;
		case 3:
			x=x-1;
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
			x=x+1;
			y=y-1;
			break;
		case 8:
			x=x+1;
			break;
		case 9:
			x=x+1;
			y=y+1;
			break;
		default:
			break;
		}
		setX(x);
		setY(y);
		//System.out.println(x+"--"+y);
	}
	
}
