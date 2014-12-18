package model;

public class Size2D {
	public float width;
	public float height;
	
	public Size2D(float w, float h){
		this.width = w;
		this.height = h;
	}
	
	public Size2D(Size2D s){
		this.width = s.width;
		this.height = s.height;
	}
}
