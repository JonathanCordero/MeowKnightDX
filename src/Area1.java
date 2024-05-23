import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Area1 extends Area {
	
	int enemyCount = 3;
	boolean firstTime = true;
	Random random = new Random(); 
	
	Rect floor = new Rect(363,919,1075,37);
	
	Rect[] platform = {
			new Rect(378,664,247,20),
			new Rect(879,664,247,20),
			new Rect(1120,459,247,20),
	};
	Rect[] land = {
		new Rect(-88,170,87,805),
		new Rect(1,836,361,119),
		new Rect(1612,829,317,26),
	};
	
	Rect[] hill = {
			new Rect(1418,906,109,99),
			new Rect(1460,879,90,65),
			new Rect(1503,853,90,65),
			new Rect(1554,829,90,65),
	};
	
	Rect door = new Rect(1833,34,78,799);
	
	Foe Zombie = new Foe(500,500);
	Foe Zombie2 = new Foe (800, 300);
	Foe Zombie3 = new Foe (900, 200);

	ArrayList<Foe> foes = new ArrayList<Foe>();
	
	public Area1( boolean[] pressed) {
		super(pressed, "oak_woods_Area1.png");
	}
	
	public void inGameLoop() {
		
		if (firstTime) {
			foes.add(Zombie);
			foes.add(Zombie2);
			foes.add(Zombie3);
			foes.get(0).chase = true;
			foes.get(1).evade = true;
			foes.get(2).chase = true;
		}
		
		for (int k=0; k<foes.size(); k++) {
			foes.get(k).jump -=1; 
		}
		
		if (pressed[UP] && !MeowKnight.airborne) {
			MeowKnight.goUP(15);
			MeowKnight.airborne = true;
		}
		if (pressed[DN]) MeowKnight.goDN(10);
		if (pressed[LT]) MeowKnight.goLT(10);
		if (pressed[RT]) MeowKnight.goRT(10);
		if (pressed[A]) {
			MeowKnight.attack();
			
			for (int i=0; i<foes.size(); i++) {
				if (MeowKnight.slash.overlaps(foes.get(i)) && foes.get(i).health>0) {
					foes.get(i).damaged();
					enemyCount-=1;
					foes.remove(i);
				}
			}
			/*if (MeowKnight.slash.overlaps(Zombie) && Zombie.health>0) {
				Zombie.damaged();
				enemyCount-=1;
			}
			if (MeowKnight.slash.overlaps(Zombie2) && Zombie2.health>0) {
				Zombie2.damaged();
				enemyCount-=1;
			}
			if (MeowKnight.slash.overlaps(Zombie3) && Zombie3.health >0) {
				Zombie3.damaged();
				enemyCount-=1;
			}*/
		}
				
		MeowKnight.move();
		for (int k = 0; k < foes.size(); k++) {
			if (foes.get(k).health >0 && foes.get(k).chase)		foes.get(k).chase(MeowKnight, 3);
			if (foes.get(k).health >0 && foes.get(k).evade)		foes.get(k).evade(MeowKnight, 1);
		}
		
		for (int k = 0; k <foes.size(); k++) {
			if (MeowKnight.overlaps(foes.get(k)) && MeowKnight.invincibility == 0) {
				MeowKnight.damaged = true;
				MeowKnight.health -=1;
				MeowKnight.invincibility = 180;
			}
		}
		
		if (MeowKnight.overlaps(door))	{
			MeowKnight.pushOutof(door);
			MeowKnight.airborne = false;
		}
		
		for (int i=0; i<foes.size(); i++) {
			if (foes.get(i).overlaps(door)){
				foes.get(i).pushOutof(door);
				foes.get(i).airborne = false;
			}
		}
		
		for (int i= 0; i<land.length; i++) {
				
			if (MeowKnight.overlaps(land[i])) {
				MeowKnight.pushOutof(land[i]);
				MeowKnight.airborne = false;
			}
			for (int k=0; k<foes.size(); k++) {
				if(foes.get(k).overlaps(land[i])) {
					foes.get(k).pushOutof(land[i]);
					foes.get(k).airborne = false;
				}
			}
			/*if (Zombie.overlaps(land[i])) {
				Zombie.pushOutof(land[i]);
				Zombie.airborne = false;
			}
			
			if (Zombie2.overlaps(land[i])) {
				Zombie2.pushOutof(land[i]);
				Zombie2.airborne = false;
			}
			
			if (Zombie3.overlaps(land[i])) {
				Zombie3.pushOutof(land[i]);
				Zombie3.airborne = false;
			}*/
				
		}
		
		for (int i=0; i<platform.length; i++) {
			if (MeowKnight.overlaps(platform[i])){
				if (MeowKnight.cameFromAbove(platform[i])) {
					MeowKnight.pushBackAbove(platform[i]);
					MeowKnight.vx *= MeowKnight.F;
					MeowKnight.airborne = false;
				}
			}
			for (int k=0; k<foes.size(); k++) {
				if(foes.get(k).overlaps(platform[i])) {
					if(foes.get(k).cameFromAbove(platform[i])) {
						foes.get(k).pushBackAbove(platform[i]);
						foes.get(k).airborne = false;
						foes.get(k).vx *= foes.get(k).F; 
					}
				}
			}
		}
		
		for (int i=0; i<hill.length; i++) {
			if (MeowKnight.overlaps(hill[i])) {
				if(MeowKnight.cameFromAbove(hill[i]) || MeowKnight.cameFromleft(hill[i])) {
					MeowKnight.pushBackAbove(hill[i]);
					MeowKnight.vx *= MeowKnight.F;
					MeowKnight.airborne = false;
				}
				
			}
			for (int k=0; k<foes.size(); k++) {
				if (foes.get(k).overlaps(hill[i])) {
					if(foes.get(k).cameFromAbove(hill[i]) || foes.get(k).cameFromleft(hill[i])) {
						foes.get(k).pushBackAbove(hill[i]);
						foes.get(k).airborne = false;
						foes.get(k).vx *= foes.get(k).F; 
					}
				}
			}
		}
				
		if (MeowKnight.overlaps(floor))	{
			MeowKnight.pushOutof(floor);
			MeowKnight.airborne = false;
		}
		
		for (int k=0; k<foes.size(); k++) {
			if(foes.get(k).overlaps(floor)) {
				foes.get(k).pushOutof(floor);
				foes.get(k).airborne = false;
			}
		}
		
		if (MeowKnight.x > 1920) {
			MeowKnight.x = 0;
			MeowKnight.y = 645;
			Area.setCurrentAreaTo(2);
		}
		
		if (enemyCount == 0) {
			door.goUP(1000);
			door.move();
			enemyCount = 3;
		}
		
		for (int k=0; k<foes.size(); k++) {
			if (foes.get(k).jump <=0) {
				
				foes.get(k).jump = random.nextInt(600-300)+300;
				foes.get(k).goUP(15);
				foes.get(k).move();
			}
		}
				
		if (MeowKnight.invincibility > 0) {
			MeowKnight.invincibility -= 1;
			MeowKnight.damaged = true;
		}
		firstTime = false;
		//Zombie.chase(MeowKnight, 7);
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		background.draw(g);
		
		MeowKnight.draw(g);
		for (int k=0; k<foes.size(); k++) {
			foes.get(k).draw(g);
		}
		floor.draw(g);
		door.draw(g);
		
		for(int i=0 ; i<land.length;i++) {
			land[i].draw(g);
		}
		
		for(int i=0; i<hill.length; i++) {
			hill[i].draw(g);
		}
		
		for (int i=0; i<platform.length; i++) {
			platform[i].draw(g);
		}
	}

}
