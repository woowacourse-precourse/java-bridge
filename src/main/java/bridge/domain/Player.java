package bridge.domain;

public class Player {

	private PlayerStatus playerStatus;
	private int location;

	public Player() {
		playerStatus = PlayerStatus.ALIVE;
		location = 0;
	}

	public void move() {
		validateAlive();
		location++;
	}

	private void validateAlive() {
		if (isDead()) {
			throw new IllegalStateException();
		}
	}

	public boolean isDead() {
		return playerStatus.equals(PlayerStatus.DEAD);
	}

	public boolean isAlive() {
		return playerStatus.equals(PlayerStatus.ALIVE);
	}

	public int getCurrentLocation() {
		return location;
	}

	public void die() {
		playerStatus = PlayerStatus.DEAD;
	}
}
