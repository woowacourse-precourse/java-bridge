package bridge;

public class Pause {
	private static boolean paused = false;
	private static int unPauseCount = 0;

	public static void setPause() {
		if (isNotPaused()) {
			paused = true;
		}
	}

	public static void unsetPause() {
		if (isPaused()) {
			paused = false;
			unPauseCount++;
		}
	}

	public static boolean isPaused() {
		return paused;
	}

	public static boolean isNotPaused() {
		return !paused;
	}

	public static int getAttemptCount() {
		return getUnPauseCount() + 1;
	}

	private static int getUnPauseCount() {
		return unPauseCount;
	}
}
