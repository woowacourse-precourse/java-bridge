package bridge;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
	@DisplayName("선택한 칸이 이동 가능한 칸인지 확인")
	@Test
	void isMovable() {
		// given
		Bridge bridgeLetters = new Bridge(List.of("U", "D", "U", "D", "U"));
		BridgeGame bridgeGame = new BridgeGame(bridgeLetters, 5);
		String userSelectedCell = "U";

		// when
		boolean isMovable = bridgeGame.isMovable(bridgeLetters, userSelectedCell);

		// then
		assertThat(isMovable).isTrue();
	}

	@DisplayName("한 칸 이동한 뒤, 선택한 칸이 이동 불가능한 칸인 경우")
	@Test
	void isNotMovable() {
		// given
		Bridge bridgeLetters = new Bridge(List.of("U", "D", "U", "D", "U"));
		BridgeGame bridgeGame = new BridgeGame(bridgeLetters, 5);
		String userSelectedCell = "U";
		bridgeGame.move(userSelectedCell);
		userSelectedCell = "U";

		// when
		boolean isMovable = bridgeGame.isMovable(bridgeLetters, userSelectedCell);

		// then
		assertAll(
			() -> assertThat(isMovable).isFalse(),
			() -> assertThat(Pause.paused).isTrue()
		);
	}

	@DisplayName("게임 재시작 여부 확인")
	@Test
	void isRetry() {
		// given
		Bridge bridgeLetters = new Bridge(List.of("U", "D", "U", "D", "U"));
		BridgeGame bridgeGame = new BridgeGame(bridgeLetters, 5);
		String userSelectedCell = "D";
		bridgeGame.move(userSelectedCell);

		// when
		if (Pause.paused) {
			bridgeGame.retry();
		}
		String nextUserSelectedCell = "U";

		// then
		assertAll(
			() -> assertThat(bridgeGame.isMovable(bridgeLetters, nextUserSelectedCell)).isTrue(),
			() -> assertThat(Pause.paused).isFalse()
		);
	}
}
