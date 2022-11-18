package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
	List<String> bridge;
	BridgeGame bridgeGame;

	@BeforeEach
	void beforeEach() {
		bridge = List.of("U", "D", "D", "U");
		bridgeGame = new BridgeGame(bridge);
	}

	@Test
	void 이동테스트_정답() {
		List<String> userInput = List.of("U", "D", "D", "U");
		for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
			assertThat(bridgeGame.move(userInput.get(i), i)).isEqualTo(true);
		}

		assertThat(bridgeGame.move("D", 0)).isEqualTo(false);
	}

	@Test
	void 이동테스트_오답() {
		assertThat(bridgeGame.move("D", 0)).isEqualTo(false);
	}
}