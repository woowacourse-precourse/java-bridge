package bridge.domain.dto;

public class MovingResult {
	private String direction;
	private boolean answer;

	public MovingResult(String direction, boolean answer) {
		this.direction = direction;
		this.answer = answer;
	}

	public String getDirection() {
		return this.direction;
	}

	public boolean getAnswer() {
		return this.answer;
	}
}
