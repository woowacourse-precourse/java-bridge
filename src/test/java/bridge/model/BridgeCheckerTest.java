package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeCheckerTest {
	private static List<String> bridge;

	@BeforeEach void initialize() {
		int userInputLength = 3;
		BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		bridge = bridgeMaker.makeBridge(userInputLength);
	}

	@DisplayName("정상적으로 이동하는 경우") @Test public void bridgeCheckerTest1() {
		int currentStep = 0;
		while (true) {
			if (BridgeChecker.isGameClear(bridge, currentStep)) {
				break;
			}

			if (!BridgeChecker.isMovableLocation(bridge, "U", currentStep)) {
				System.out.println("게임이 끝난 턴 : " + (currentStep + 1));
				Assertions.assertThat(currentStep).isNotEqualTo(bridge.size());
				break;
			}
			currentStep++;
		}

		if (BridgeChecker.isMovableLocation(bridge, "U", currentStep)) {
			System.out.println("게임이 끝난 턴 : " + currentStep);
			Assertions.assertThat(currentStep).isEqualTo(bridge.size());
		}
	}
}
