package bridge;

public class Pause {
	public static boolean paused = false;

	public static void setPause() {
		if (whenNotPaused()) {
			paused = true;
		}
	}

	public static void unsetPause() {
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
