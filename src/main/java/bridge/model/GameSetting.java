package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import bridge.dto.GameResultDto;

import java.util.List;

public class GameSetting {
	public static final int START_STEP = 0;
	public static final int FIRST_TRY = 1;
	public static final boolean GAME_FAIL = false;

	public static List<String> setBridgeForStartGame(int bridgeLength) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		return bridgeMaker.makeBridge(bridgeLength);
	}

	public static GameResultDto setDataForRetryGame(int totalTry, boolean gameClear) {
		return new GameResultDto(totalTry, gameClear);
	}
}
