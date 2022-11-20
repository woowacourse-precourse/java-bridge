package bridge.bridgegame;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.Pause;

public class RetryTest {
	Bridge bridgeLetters = new Bridge(List.of("U", "D", "U", "D", "U"));
	BridgeGame bridgeGame = new BridgeGame(bridgeLetters, 5);

	@DisplayName("게임 재시작 여부 확인")
	@Test
	void isRetry() {
		// given
		String userSelectedCell = "D";
		bridgeGame.move(userSelectedCell);

		// when
		if (Pause.isPaused()) {
			bridgeGame.retry();
		}
		String nextUserSelectedCell = "U";

		// then
		assertAll(
			() -> assertThat(bridgeGame.isMovable(bridgeLetters, nextUserSelectedCell)).isTrue(),
			() -> assertThat(Pause.isPaused()).isFalse()
		);
	}
}
