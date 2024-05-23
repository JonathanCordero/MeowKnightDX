import java.awt.Graphics;

public class Foe extends Sprite {


	int health;
	int jump = 600;
	
	public static String[] pose = {"Idleleft", "Idle", "WalkLeft", "Walk",
									"AttackLeft", "Attack", "DeathLeft", "Dead"};
	
	int death = 80;
	
	public Foe(int x, int y) {
		super("Zombie", pose, x, y, 8, 10);
		health =1;
	}

	public void attack() {
		
	}
	
	public void damaged () {
		health -=1;
	}
	
	public void goUP(int dy) {
		super.goUP(dy);
		if (facingleft) action =2;
		else action =3;
		moving = true;
	}
	
	public void draw(Graphics g) {
		if (death != 0) {
			if (health <= 0) {
				if (facingleft) action = 6;
				else action = 7;
				g.drawImage(animation[action].nextImage(), x, y, w, h, null);
				g.drawRect(x, y, w, h);
				death -=1;
			}
			else super.draw(g);
		}
	}
	
}
