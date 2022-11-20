package bridge.domain;

public class Player {

	private PlayerStatus playerStatus;

	public Player() {
		playerStatus = PlayerStatus.ALIVE;
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

}
