package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
	@DisplayName("선택한 칸이 이동 가능한 칸인지 확인")
	@Test
	void isMovable() {
		// given
		BridgeGame bridgeGame = new BridgeGame();
		List<String> bridgeLetters = List.of("U", "D", "U", "D", "U");
		String userSelectedCell = "U";

		// when
		bridgeGame.move(userSelectedCell);

		// then
		assertThat(bridgeGame.isMovable(bridgeLetters, userSelectedCell)).isTrue();
	}
}
