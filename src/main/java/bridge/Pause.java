package bridge;

public class Pause {
	private static boolean paused = false;
	private static int unPauseCount = 0;

	public static void setPause() {
		if (whenNotPaused()) {
			paused = true;
		}
	}

	public static void unsetPause() {
		if (whenPaused()) {
			paused = false;
			unPauseCount++;
		}
	}

	private static boolean whenNotPaused() {
		return !paused;
	}

	private static boolean whenPaused() {
		return paused;
	}

	public static boolean isPaused() {
		return paused;
	}

	public static int getAttemptCount() {
		return getUnPauseCount() + 1;
	}

	private static int getUnPauseCount() {
		return unPauseCount;
	}
}
