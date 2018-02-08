package me.pabloestrada.beargamemovement;

import java.util.Timer;
import java.util.TimerTask;

public class Movement {
	
	private Timer timer;
	
	public Movement() {
		timer = new Timer();
	}
	
	private void launchMovementEngine() {
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}}, 0, 500);
	}
	
}
