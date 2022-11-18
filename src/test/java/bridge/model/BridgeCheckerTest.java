package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeCheckerTest {
	@DisplayName("정상적으로 이동하는 경우") @Test public void 이동가능테스트() {
		int userInputLength = 3;
		BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(userInputLength);

		int gameTurn;
		boolean movableFlag = false;
		for (gameTurn = 0; gameTurn < userInputLength; gameTurn++) {
			movableFlag = BridgeChecker.isNotMovableStep(bridge, "U", gameTurn);
			if (movableFlag) {
				System.out.println("게임이 끝난 턴 : " + (gameTurn + 1));
				Assertions.assertThat(gameTurn).isNotEqualTo(bridge.size());
				break;
			}
		}

		if (!movableFlag) {
			System.out.println("게임이 끝난 턴 : " + gameTurn);
			Assertions.assertThat(gameTurn).isEqualTo(bridge.size());
		}
	}
}
