package cf.kuiprux.spbeat.scenes.temp;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import cf.kuiprux.spbeat.SpBeAt;
import cf.kuiprux.spbeat.beatmap.BeatMap;
import cf.kuiprux.spbeat.beatmap.object.Pos;
import cf.kuiprux.spbeat.scenes.ButtonPanel;

public class HBMapsScene extends ButtonPanel {

	boolean[][] buttonAvailables = new boolean[4][4];
	Image[][] buttonImages = new Image[4][4];
	
	BeatMap[][] maps;
	
	int index;
	
	HBMapsScene(int index) {
		super();
		this.index = index;
		this.maps = SpBeAt.instance.getMapHandler().getMaps(index);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 3; j++) {
				if(maps[i][j] != null) {
					buttonAvailables[j][i] = true;
					buttonImages[j][i] = maps[i][j].getIcon();
				}
			}
		}
		try {
			buttonAvailables[3][0] = true;
			buttonAvailables[3][1] = true;
			buttonAvailables[3][2] = true;
			buttonAvailables[3][3] = true;
			buttonImages[3][0] = new Image(ROOT+"previous.png");
			buttonImages[3][1] = new Image(ROOT+"play.png");
			buttonImages[3][2] = new Image(ROOT+"edit.png");
			buttonImages[3][3] = new Image(ROOT+"next.png");
			setProperties(buttonAvailables, buttonImages);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(GameContainer gc, int g) {
		super.update(gc, g);
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_ENTER)) {
			Pos selected = getSelected();
			if(selected.x < 3) {
				
			} else {
				switch(selected.y) {
				case 0:
					SpBeAt.instance.getWindow().setScene(new HBMapsScene((index == 0) ? SpBeAt.instance.getMapHandler().getSize()-1 : index-1));
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					SpBeAt.instance.getWindow().setScene(new HBMapsScene((index+1 == SpBeAt.instance.getMapHandler().getSize()) ? 0 : index+1));
				}
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		// TODO Auto-generated method stub
		super.render(gc, g);
		
	}

}