schedule a periodic task
java.util.Timer.scheduleAtFixedRate
------
Do something every one second
Timer timer = new Timer();
timer.schedule(new TimerTask() {
    @Override
    public void run() {
        //code
    }
}, 0, 1000);
------


---------------------------------------------------------------
Einfach irgendwo mit aufrufen
scheduler.ScheduledExecutorServiceBeeper beep = new scheduler.ScheduledExecutorServiceBeeper();
	beep.beepForAnHour();

package scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class ScheduledExecutorServiceBeeper {
  private final ScheduledExecutorService scheduler =    Executors.newScheduledThreadPool(1);
  private int counter =0;

  public void beepForAnHour() {
		final Runnable beeper = new Runnable() {
			public void run() {
				counter++;
				System.out.println("This is a scheduler beep!: " + counter);
			}
		};
    
    final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(beeper, 10, 10,  TimeUnit.SECONDS);
    scheduler.schedule(new Runnable() {
      public void run() { beeperHandle.cancel(true); }
    }, 	1 * 60, TimeUnit.SECONDS);
  }
}
