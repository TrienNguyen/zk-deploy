package main;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.*;

public class Clock extends SelectorComposer<Component> {
	@Wire
	private Label timeLabel;

	@Wire
	private Timer countdownTimer;

	private int secondsLeft = 10;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		updateLabel();
		countdownTimer.start();
	}

	@Command("tick")
	public void onTimerTick() {
		secondsLeft--;
		updateLabel();

		if (secondsLeft <= 0) {
			countdownTimer.stop();
			Clients.showNotification("Hết giờ!", "info", timeLabel, "middle_center", 2000);
		}
	}

	private void updateLabel() {
		timeLabel.setValue("Còn lại: " + secondsLeft + " giây");
	}
}