package CA;

public class View extends Block{
	Data data=new Data();
	int x;
	int y;
	int logo;
	View(int x,int y,int logo){
		super(x,y,logo);
		this.x=x;
		this.y=y;
		this.logo=logo;
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
	
}
