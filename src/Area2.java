import java.awt.*;

public class Area2 extends Area {
	
	Rect2 floor = new Rect2(-15,745,1975,34);
	
	Foe Zombie = new Foe(300,600);

	public Area2( boolean[] pressed) {
		super(pressed, "oak_woods_Area2.png");
	}
	
	public void inGameLoop() {
		
		if (pressed[UP]) MeowKnight.goUP(10);
		if (pressed[DN]) MeowKnight.goDN(10);
		if (pressed[LT]) MeowKnight.goLT(10);
		if (pressed[RT]) MeowKnight.goRT(10);
		if (pressed[A]) {
			MeowKnight.attack();
			if (MeowKnight.slash.overlaps(Zombie)) {
				Zombie.damaged();
			}
		}
				
		MeowKnight.move();
		
		
		if (Zombie.health >0)		Zombie.evade(MeowKnight, 3);
				
		if (MeowKnight.overlaps(floor))	{
			//MeowKnight.x = 1800-30; teleport across screen. or shouldnt have put this on the floor.
			//if (MeowKnight.x 1950) MeowKnight.x = -50 and so on.
			MeowKnight.pushOutof(floor);
		}
		if (Zombie.overlaps(floor)) {
			Zombie.pushOutof(floor);
		}
		
		if (MeowKnight.x < -50) {
			MeowKnight.x = 1900;
			MeowKnight.y = 725;
			Area.setCurrentAreaTo(1);
		}
				
		//Zombie.chase(MeowKnight, 7);
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		background.draw(g);
		
		MeowKnight.draw(g);
		Zombie.draw(g);
		
		floor.draw(g);
	}

}
