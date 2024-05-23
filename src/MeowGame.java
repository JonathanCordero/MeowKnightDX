import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MeowGame extends GameBase {
	
	/*Rect2 floor = new Rect2(363,919,1075,37);
	
	Rect2[] platform = {
			new Rect2(378,664,247,20),
			new Rect2(879,664,247,20),
			new Rect2(1120,459,247,20),
	};
	Rect2[] land = {
		new Rect2(-88,170,87,805),
		new Rect2(1,836,361,119),
		new Rect2(1612,829,317,26),
	};
	
	Rect2[] hill = {
			new Rect2(1418,906,109,99),
			new Rect2(1460,879,90,65),
			new Rect2(1503,853,90,65),
			new Rect2(1554,829,90,65),
	};
	
	Rect2 door = new Rect2(1833,34,78,799);*/
	
	//ImageLayer rock = new ImageLayer("rock_1.png", 0, 0, 1);
	//ImageLayer fen1 = new ImageLayer("fence_1.png", 0, 0, 1);
	//ImageLayer fen2 = new ImageLayer("fence_2.png",0, 0, 1);
		
	Area1 Area1 = new Area1(pressed);
	Area2 Area2 = new Area2(pressed);
	
	public void initialize() {
		Area.setCurrentAreaTo(1);
	}
	
	public void inGameLoop() {
		Area.inGameLoopStatic();		
	}

	public void paint(Graphics g) {
		Area.paintStatic(g);
		g.setColor(Color.black);
		
		/*floor.draw(g);
		
		for(int i=0 ; i<land.length;i++) {
			land[i].draw(g);
		}
		
		for(int i=0; i<hill.length; i++) {
			hill[i].draw(g);
		}
		
		door.draw(g);*/
	}
	
	/*public void keyPressed(KeyEvent e) {
		
		super.keyPressed(e);
		
		if (pressed[P]) {
			for (int i =0; i<land.length; i++) {
				System.out.println("new Rect2(" + land[i] +"),");
			}
			for (int i =0; i<hill.length; i++) {
				System.out.println("new Rect2(" + hill[i] +"),");
			}
			for (int i =0; i<platform.length; i++) {
				System.out.println("new Rect2(" + platform[i] +"),");
			}
			System.out.println("new Rect2(" + floor +")");
			System.out.println("new Rect2(" + door +")");
		}
		System.out.println();
	}
		
	public void mousePressed(MouseEvent e) {
		
		super.mousePressed(e);
		
		for (int i= 0; i <land.length; i++) {
			if (land[i].contains(mx,my)) land[i].grabbed();
			if (land[i].resizer.contains(mx, my)) land[i].resizer.grabbed();
		}
		for (int i= 0; i <hill.length; i++) {
			if (hill[i].contains(mx,my)) hill[i].grabbed();
			if (hill[i].resizer.contains(mx, my)) hill[i].resizer.grabbed();
		}
		for (int i= 0; i <platform.length; i++) {
			if (platform[i].contains(mx,my)) platform[i].grabbed();
			if (platform[i].resizer.contains(mx, my)) platform[i].resizer.grabbed();
		}
		if (floor.contains(mx, my)) floor.grabbed();
		if (floor.resizer.contains(mx, my)) floor.resizer.grabbed();
		
		if (door.contains(mx, my)) door.grabbed();
		if (door.resizer.contains(mx, my)) door.resizer.grabbed();
	}
		
	public void mouseReleased(MouseEvent e) {
		
	for (int i= 0; i <land.length; i++) {
			land[i].dropped();
			land[i].resizer.dropped();
		}
	for (int i= 0; i <hill.length; i++) {
		hill[i].dropped();
		hill[i].resizer.dropped();
	}
	for (int i= 0; i <platform.length; i++) {
		platform[i].dropped();
		platform[i].resizer.dropped();
	}
	
	floor.dropped();
	floor.resizer.dropped();
	
	door.dropped();
	door.resizer.dropped();
	}
		
	public void mouseDragged(MouseEvent e) {
		int nx = e.getX();
		int ny = e.getY();
		
		int dx = nx-mx;
		int dy = ny-my;
		
		for (int i = 0; i<land.length;i++) {
			if (land[i].held) land[i].moveBy(dx, dy);
			if (land[i].resizer.held) land[i].resizeBy(dx,dy);
		}
		for (int i = 0; i<hill.length;i++) {
			if (hill[i].held) hill[i].moveBy(dx, dy);
			if (hill[i].resizer.held) hill[i].resizeBy(dx,dy);
		}
		for (int i = 0; i<platform.length;i++) {
			if (platform[i].held) platform[i].moveBy(dx, dy);
			if (platform[i].resizer.held) platform[i].resizeBy(dx,dy);
		}
		
		if(floor.held) floor.moveBy(dx, dy);
		if(floor.resizer.held) floor.resizeBy(dx, dy);
		
		if(door.held) door.moveBy(dx, dy);
		if(door.resizer.held) door.resizeBy(dx, dy);
		
		mx = nx;
		my = ny;
	}*/
	
}
