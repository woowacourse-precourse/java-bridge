package model;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.*;
import static model.BridgeGameConstants.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

	@Nested
	@DisplayName("다리 건너기 성공 테스트 클래스")
	class SuccessTest {

		@Test
		void moveTest() {
			// given
			final List<String> bridge = newArrayList("U", "D", "U", "U");
			BridgeGame bridgeGame = new BridgeGame(bridge);

			// when
			List<String> movings = newArrayList("U", "D", "U", "U");

			// then
			for (String moving : movings) {
				assertThat(bridgeGame.move(moving)).isEqualTo(MOVING_SUCCESS);
			}
		}
	}

	@Nested
	@DisplayName("다리 건너기 실패 테스트 클래스")
	class FailTest {

	}
}
