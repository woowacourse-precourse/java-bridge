package dto;

public class CorrectDto {
	private final boolean isCorrect;

	public CorrectDto(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public boolean isCorrect() {
		return isCorrect;
	}
}
