import java.awt.Graphics;

public class Rect {

	int x;
	int y;
	
	int w;
	int h;
	
	int a;
	
	
	double vx = 0;
	double vy = 0;
	
	double ay = G;
	
	static double G = .6;
	static double F = 0;
		
	boolean held = false;
	boolean harm = false;
	boolean damaged = false;
	boolean airborne = false;
	boolean chase = false;
	boolean evade = false;
	
	public Rect(int x, int y, int w, int h) {
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void grabbed() {
		held = true;
	}
	
	public void dropped() {
		held = false;
	}
	
	public void draw(Graphics g) {
		g.drawRect(x, y, w, h);
	}
	
	public void goLT(int vx) {
		 this.vx = -vx;
	}
	
	public void goRT(int vx) {
		this.vx = +vx;
	}
	
	public void goUP(int vy) {
		this.vy = -vy;
	}
	
	public void goDN(int vy) {
		this.vy = +vy;
	}
	
	public void move() {
		x += vx;
		y += vy + G/2;
		
		vy += G;
	}
	
	/*public void jump(int h) {
		vy = -h;
	}*/
	
	public void moveBy(int dx, int dy) {
		
		x += dx;
		y += dy;
		
	}
	
	public void resizeBy(int dw, int dh) {
		w += dw;
		h += dh;
	}
	
	public boolean overlaps(Rect r) {
		return	(x+w >= r.x) && 
				(r.x+r.w >= x) && 
				(y+h >= r.y) && 
				(r.y +r.h >= y);
	}
	
	public void pushOutof(Rect r) {
		 if (cameFromAbove(r)) pushBackAbove(r);
		 if (cameFromBelow(r)) pushBackBelow(r);
		 if (cameFromleft(r))  pushbackLeft(r);
		 if (cameFromRight(r)) pushbackRight(r);
		
		vx *= F; //ice physics.
		if (Math.abs(vx) <=1) vx = 0;    //A clamp.
	}
	
	public void Bounce(Rect r) {
		if (cameFromAbove(r) || cameFromBelow(r)) vy = -vy;
		if (cameFromleft(r)  || cameFromRight(r)) vx = -vx;
		
		vx *= F; //ice physics modifier.
		if (Math.abs(vx) <=1) vx = 0;    //A clamp.
	}
	
	public boolean cameFromleft(Rect r) {
		return x - vx + w < r.x;
	}
	
	public boolean cameFromRight(Rect r) {
		return r.x +r.w < x - vx;
	}
	
	public boolean cameFromAbove(Rect r) {
		return y - vy + h < r.y;
	}
	
	public boolean cameFromBelow(Rect r) {
		return r.y + r.h < y - vy;
	}
	
	public void pushbackLeft(Rect r) {
	 	x = r.x - w - 1;
	}
	
	public void pushbackRight(Rect r) {
		x = r.x + r.w + 1; 
	}
	
	public void pushBackAbove(Rect r) {
		y = r.y - h - 1;
		
		vy = 0;
	}
	
	public void pushBackBelow(Rect r) {
		y = r.y + h +1;
	}
	
	public boolean isLeftOf(Rect r)
	{
		return x+w < r.x;
	}
	
	public boolean isRightOf(Rect r) {
		return r.x +r.w <x;
	}
	
	public boolean isAbove(Rect r) {
		return y+h <r.y;
	}
	
	public boolean isBelow(Rect r) {
		return r.y +r.h <y;
	}
	
	public boolean contains (int mx, int my) {
		return (mx>= x) &&
				(mx <= x+w) &&
				(my >= y) &&
				(my <= y+h);
	}
	
	public String toString() {
		return "" + x + "," + y + "," + w + "," + h;
	}
	
}
 