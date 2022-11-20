package bridge;

public class Pause {
	private static boolean paused = false;

	public void setPause() {
		if (whenNotPaused()) {
			paused = true;
		}
	}

	public void unsetPause() {
		if (whenPaused()) {
			paused = false;
		}
	}

	private boolean whenNotPaused() {
		return !paused;
	}

	private boolean whenPaused() {
		return paused;
	}

	public boolean isPaused() {
		return paused;
	}
}
