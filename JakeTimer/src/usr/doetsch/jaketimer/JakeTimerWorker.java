package usr.doetsch.jaketimer;

import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class JakeTimerWorker extends SwingWorker<Boolean, Long> {

	private long refreshRate;
	private TheoryTimer timer;
	private JTextField timerField;
	
	JakeTimerWorker (long refreshRate, long duration, JTextField timerField) {
		super();
		this.refreshRate = refreshRate;
		this.timer = new TheoryTimer(duration);
		this.timerField = timerField;
	}
	
	@Override
	protected Boolean doInBackground() throws Exception {

		timer.start();
		
		while (!isCancelled() && !timer.isFinished()) {		
			Thread.sleep(refreshRate);
			
			publish(timer.update());
						
		}
		
		timer.pause();
		publish(timer.update());
		
		return true;
	}
	
	protected void process (List<Long> times) {
		long time = times.get(times.size() - 1);
		this.timerField.setText(TheoryTimer.format(time));
	}

}
