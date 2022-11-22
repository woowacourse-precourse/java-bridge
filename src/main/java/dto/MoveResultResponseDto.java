package dto;

import bridge.MoveResult;

public class MoveResultResponseDto {
	private final boolean isCorrect;
	private final boolean isSuccess;

	public MoveResultResponseDto(MoveResult moveResult) {
		this.isCorrect = moveResult.isCorrect();
		this.isSuccess = moveResult.isSuccess();
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
}
