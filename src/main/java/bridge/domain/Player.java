package bridge.domain;

public class Player {

	private PlayerStatus playerStatus;
	private int location;

	public Player() {
		playerStatus = PlayerStatus.ALIVE;
		location = 0;
	}

	void move() {
		validateAlive();
		location++;
	}

	private void validateAlive() {
		if (isDead()) {
			throw new IllegalStateException();
		}
	}

	boolean isDead() {
		return playerStatus.equals(PlayerStatus.DEAD);
	}

	boolean isAlive() {
		return playerStatus.equals(PlayerStatus.ALIVE);
	}

	int getCurrentLocation() {
		return location;
	}

	void die() {
		playerStatus = PlayerStatus.DEAD;
	}
}
