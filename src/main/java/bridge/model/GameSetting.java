package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import bridge.dto.GameResultDto;

import java.util.List;

public class GameSetting {
	private static final int FIRST_TRY = 1;

	public List<String> setDataForStartGame(int bridgeLength) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		return bridgeMaker.makeBridge(bridgeLength);
	}

	public int setDataForRestartGame() {
		return FIRST_TRY;
	}

	public GameResultDto setDataForEndGame(int totalTry, boolean successFlag) {
		return new GameResultDto(totalTry, successFlag);
	}
}
