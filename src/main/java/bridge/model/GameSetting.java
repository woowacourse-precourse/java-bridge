package bridge.model;

import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class GameSetting {
	public static final int FIRST_STEP = 0;
	public static final int FIRST_TRY = 1;
	public static final boolean GAME_FAIL = false;

	public static List<String> makeBridge(int bridgeSize) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		return bridgeMaker.makeBridge(bridgeSize);
	}
}
