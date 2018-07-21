package cf.kuiprux.spbeat;

import java.util.logging.Level;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import cf.kuiprux.spbeat.game.MapManager;
import cf.kuiprux.spbeat.game.PlayManager;
import cf.kuiprux.spbeat.game.controller.FallbackController;
import cf.kuiprux.spbeat.game.controller.GameController;
import cf.kuiprux.spbeat.game.controller.IControllerListener;
import cf.kuiprux.spbeat.game.controller.SpbeatController;
import cf.kuiprux.spbeat.game.gui.ButtonPanel;
import cf.kuiprux.spbeat.game.gui.LoadingScreen;
import cf.kuiprux.spbeat.game.gui.ScreenManager;
import cf.kuiprux.spbeat.gui.AlignMode;
import cf.kuiprux.spbeat.gui.element.Square;

public class SpBeAt extends SimpleGame implements IControllerListener {
	
	public static final String TITLE = "SpBeAt";
	
	private GameController controller;
	
	private MapManager mapManager;
	
	private ButtonPanel panel;
	private ScreenManager screenManager;
	private PlayManager playManager;
	
	public SpBeAt() {
		this(TITLE);
	}
	
	public SpBeAt(String title) {
		super(title);
		
		this.panel = new ButtonPanel();
		this.controller = new SpbeatController();
		this.screenManager = new ScreenManager(this);
		this.mapManager = new MapManager(this);
		this.playManager = new PlayManager(this);
	}
	
	@Override
	public void init(GameContainer container) throws SlickException {
		super.init(container);
		
		//입력 장치 초기화
		try {
			getController().listen();
		} catch (Exception e) {
			getLogManager().log(Level.WARNING, "장치 초기화 실패, fallback 컨트롤러를 사용합니다", e);
			
			this.controller = new FallbackController();
			
			try {
				getController().listen();
			} catch (Exception e1) {
				getLogManager().log(Level.WARNING, "fallback 장치 초기화 실패 입력을 받을 수 없습니다", e);
			}
		}
		
		getController().addListener(this);
		getController().addListener(getScreenManager());
		
		addChild(getPanel());
		
		//로딩 화면 시작
		getScreenManager().setCurrentScreen(new LoadingScreen());
	}
	
	public ButtonPanel getPanel() {
		return panel;
	}
	
	public GameController getController() {
		return controller;
	}
	
	public ScreenManager getScreenManager() {
		return screenManager;
	}

	public MapManager getMapManager() {
		return mapManager;
	}

	//프로그램 종료시 호출
	@Override
	public boolean closeRequested() {
		if (!super.closeRequested())
			return false;
		
		getController().close();

		return true;
	}

	//업데이트 함수
	@Override
	protected void updateInternal(int delta) {
		getScreenManager().update(delta);
	}

	//그리기 함수
	@Override
	protected void drawInternal(Graphics graphics) {
		graphics.setAntiAlias(true);
	}

	@Override
	public void onPress(int keyIndex) {
		
	}

	@Override
	public void onUp(int keyIndex) {
		// TODO Auto-generated method stub
		
	}
}
