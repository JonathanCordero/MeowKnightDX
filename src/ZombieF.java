import java.awt.Graphics;

public class ZombieF extends Sprite {

	int health;
	
	public static String[] pose = {"Idleleft", "Idle", "WalkLeft", "Walk",
									"AttackLeft", "Attack", "DeadLeft", "Dead"};
	
	public ZombieF(int x, int y) {
		super("Zombie-fm", pose, x, y, 5, 15);
	}
	//3/28
	//4/9
	//4/11

	public void attack() {
		
	}
	
	public void damaged() {
		health -=1;
	}
	
	public void draw(Graphics g) {
		if (health == 0) {	
			if (facingleft) action = 6;
			else action = 7;
			g.drawImage(animation[action].nextImage(), x, y, w, h, null);
			g.drawRect(x, y, w, h);
		}
		else super.draw(g);
	}
}
