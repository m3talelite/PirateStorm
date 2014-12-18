package model;

public class Location2D {
	public float x;
	public float y;
	
	public Location2D(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Location2D(Location2D l){
		this.x = l.x;
		this.y = l.y;
	}
}
