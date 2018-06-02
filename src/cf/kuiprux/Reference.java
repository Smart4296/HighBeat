package cf.kuiprux;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Reference {

	//Screen size
	public static final double ORIGINAL_WIDTH = 268.1;
	public static final double ORIGINAL_HEIGHT = 476.6;
	
	public static final int ORIGINAL_BUTTON_WIDTH = 55;
	public static final int ORIGINAL_BUTTON_HEIGHT = 55;
	
	public static final double ORIGINAL_BUTTON_GAP = 11.8;
	public static final double ORIGINAL_FRAME_GAP = 6.3;
	public static final int ORIGINAL_PANEL_GAP = 14;

	//Gui size
	//public static final int WIDTH = 800;
	//public static final int HEIGHT = 600;
	public static final int WIDTH = 1080/3;
	public static final int HEIGHT = 1920/3;//����Ʈ��..?

	public static final double BUTTON_WIDTH = (double) ORIGINAL_BUTTON_WIDTH*WIDTH/ORIGINAL_WIDTH;
	public static final double BUTTON_HEIGHT = (double) ORIGINAL_BUTTON_HEIGHT*HEIGHT/ORIGINAL_HEIGHT;
	
	public static final double BUTTON_GAP_WIDTH = (double) ORIGINAL_BUTTON_GAP*WIDTH/ORIGINAL_WIDTH;
	public static final double BUTTON_GAP_HEIGHT = (double) ORIGINAL_BUTTON_GAP*HEIGHT/ORIGINAL_HEIGHT;
	public static final double FRAME_GAP_WIDTH = (double) ORIGINAL_FRAME_GAP*WIDTH/ORIGINAL_WIDTH;
	public static final double FRAME_GAP_HEIGHT = (double) ORIGINAL_FRAME_GAP*HEIGHT/ORIGINAL_HEIGHT;
	public static final double PANEL_GAP_HEIGHT = (double) ORIGINAL_PANEL_GAP*HEIGHT/ORIGINAL_HEIGHT;
	
	public static final double BUTTON_START = (double) HEIGHT-(BUTTON_HEIGHT*4)-(BUTTON_GAP_HEIGHT*3)-(PANEL_GAP_HEIGHT);
	public static final double PANEL_HEIGHT = (double) BUTTON_START-PANEL_GAP_HEIGHT;
	
	//Button images
	private static Image BUTTON_BASE, BUTTON_AVAILABLE, BUTTON_SELECTED;
	
	static {
		try {
			BUTTON_BASE = new Image("res/texture/button/base/background.png");
			BUTTON_AVAILABLE = new Image("res/texture/button/base/available.png");
			BUTTON_SELECTED = new Image("res/texture/button/base/selected.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public static Image getButtonBase() {
		return BUTTON_BASE;
	}

	public static Image getButtonAvailable() {
		return BUTTON_AVAILABLE;
	}

	public static Image getButtonSelected() {
		return BUTTON_SELECTED;
	}
	
}