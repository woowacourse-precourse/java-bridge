package bridge.domain;

import bridge.ErrorMessages;

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
			throw new IllegalStateException(ErrorMessages.DEAD_MAN_NO_WALK);
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
