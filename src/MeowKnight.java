import java.awt.Graphics;

public class MeowKnight extends Sprite {
	
	Rect slash = new Rect (-50, -50, 0, 0);
	int health = 3;
	int invincibility;
	int death = 60;
	
	public static String[] pose = {"IdleLeft", "Idle", "RunLeft", "Run",
									"AttackLeft_1","Attack_1","DeathLeft", "Death",
									"Take_DamageLeft", "Take_Damage", "AttackLeft_2","Attack_2",
									"DodgeLeft", "Dodge", "JumpLeft","Jump",
									"ReflectLeft","Reflect"};
	
	public MeowKnight(int x, int y) {
		super("Meow-Knight", pose, x, y, 4, 15);
		invincibility = 0;
	}

	public void attack() {
		    if (facingleft) {
				slash = new Rect (x-50, y+30, 80, 30);
				slash.harm = true;
				action = 4;
				
			}
			else {
				slash = new Rect (x+50, y+30, 30, 30);
				slash.harm = true;
				action = 5;
			}
		moving = true;
		
	}
	
	public void damaged() {
		if (facingleft) action =8;
		else action = 9;
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
		
			else {
				if(damaged) {
					damaged();
					g.drawImage(animation[action].nextImage(), x, y, w, h, null);
					damaged = false;
				}
		
				else {
					if (!moving) {
						still();
						g.drawImage(animation[action].nextImage(), x, y, w, h, null);
					}
					else {
						g.drawImage(animation[action].nextImage(), x, y, w, h, null);
						if (slash.harm) {
						slash.draw(g);
						slash.harm = false;
						}
					moving = false;
					}
				}
				g.drawRect(x,y,w,h);
			}
		}
	}
}
