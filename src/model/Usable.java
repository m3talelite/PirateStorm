package model;

public abstract class Usable {

	protected int ammount;
	protected boolean isInstant;
	protected int damage;
	
	protected Location2D loc;
	protected Size2D size;
	protected Image2D image;
	
	
	public boolean hasLeft(){
		return ammount < 1 ? false : true;
	}
	
}
