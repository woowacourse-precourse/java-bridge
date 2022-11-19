package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

//todo : 테스트코드 간결하고 정확하게 고치자!
public class BridgeCheckerTest {
	@DisplayName("정상적으로 이동하는 경우") @Test public void 이동가능테스트2() {
		int userInputLength = 3;
		BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(userInputLength);

		int gameTurn = 0;
		while(true) {
			if (BridgeChecker.isEndGame(bridge, gameTurn)) {
				break;
			}

			if (!BridgeChecker.isMovableLocation(bridge, "U", gameTurn)) {
				System.out.println("게임이 끝난 턴 : " + (gameTurn + 1));
				Assertions.assertThat(gameTurn).isNotEqualTo(bridge.size());
				break;
			}
			gameTurn++;
		}

		if (BridgeChecker.isMovableLocation(bridge, "U", gameTurn)) {
			System.out.println("게임이 끝난 턴 : " + gameTurn);
			Assertions.assertThat(gameTurn).isEqualTo(bridge.size());
		}
	}
}
