package bridge.domain;

public class Player {

	private PlayerStatus playerStatus;
	private int location;

	public Player() {
		playerStatus = PlayerStatus.ALIVE;
		location = 0;
	}

	public void die() {
		playerStatus = PlayerStatus.DEAD;
	}

	public boolean isAlive() {
		return playerStatus == PlayerStatus.ALIVE;
	}

	public boolean isDead() {
		return playerStatus == PlayerStatus.DEAD;
	}

	public int getCurrentLocation() {
		return location;
	}

	public void move() {
		location++;
	}
}
