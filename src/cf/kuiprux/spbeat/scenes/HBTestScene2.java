package cf.kuiprux.spbeat.scenes;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import cf.kuiprux.spbeat.SpBeAt;

public class HBTestScene2 implements HBScene {

	public void update(GameContainer gc, int g) {
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_A)) {
			((SpBeAt)gc).getWindow().setScene(new HBTestScene());
		}
	}
	public void render(GameContainer gc, Graphics g) {
		g.drawString("Hello!", 50, 50);
	}

}