package dto;

import bridge.MoveResult;

public class MoveResultResponseDto {
	private final String map;
	private final int numberOfCorrect;
	private final boolean isSuccess;

	public MoveResultResponseDto(MoveResult moveResult) {
		this.map = moveResult.getMap();
		this.numberOfCorrect = moveResult.getNumberOfCorrect();
		this.isSuccess = moveResult.getIsSuccess();
	}

	public String getMap() {
		return map;
	}

	public int getNumberOfCorrect() {
		return numberOfCorrect;
	}

	public boolean isSuccess() {
		return isSuccess;
	}
}
