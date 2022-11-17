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
		Bridge bridgeLetters = new Bridge(List.of("U", "D", "U", "D", "U"));
		BridgeGame bridgeGame = new BridgeGame(bridgeLetters, 5);
		String userSelectedCell = "U";

		// when
		boolean isMovable = bridgeGame.isMovable(bridgeLetters, userSelectedCell);

		// then
		assertThat(isMovable).isTrue();
	}
}
