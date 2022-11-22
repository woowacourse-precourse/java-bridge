package dto;

import bridge.PlayCount;

public class PlayCountResponseDto {
	private final int playCount;

	public PlayCountResponseDto(PlayCount playCount) {
		this.playCount = playCount.getCount();
	}

	public int getPlayCount() {
		return playCount;
	}
}
