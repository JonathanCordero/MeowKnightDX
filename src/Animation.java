import java.awt.Image;
import java.awt.Toolkit;

public class Animation {

	private Image[] image;
	private int next;
	
	private int duration;
	private int delay;
	
	public Animation(String name, int count, int duration) {
		image = new Image[count];
		
		for (int i = 0; i< count; i++) {
			image[i] = Toolkit.getDefaultToolkit().getImage(name + "." + (i+1) +".png");
		}
		this.duration = duration;
		
		delay = duration;
	}
	
	public Image stillImage() {
		return image[0];
	}
	
	public Image nextImage() {
		
		if (delay == 0) {
			next ++;
			if (next == image.length) next =  0;
			delay = duration;
		}
		
		delay--;
		return image[next];
	}
	
}
