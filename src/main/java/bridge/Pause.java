package bridge;

public class Pause {
	static boolean paused = false;

	public static void setPause() {
		if (whenNotPaused()) {
			paused = true;
		}
	}

	public static void setUnpause() {
		if (whenPaused()) {
			paused = false;
		}
	}

	private static boolean whenNotPaused() {
		return !paused;
	}

	private static boolean whenPaused() {
		return paused;
	}
}
