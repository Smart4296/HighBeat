package cf.kuiprux.spbeat.gui.effect;

import org.newdawn.slick.Graphics;

public interface IDrawEffect {

	// 시스템 시간 사용
	long getStartTime();
	// 보관용
	float getStartValue();
	
	int getDuration();
	
	long getEndTime();
	
	boolean isEnded(long currentTime);
	
	//effect 시작시 발동
	void onStart();
	
	//effect 종료시 발동
	void onEnded();
	void applyAt(long currentTime, Graphics graphics);

	void setStartTime(long startTime);
}
