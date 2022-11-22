package model;

import java.util.ArrayList;
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
		@DisplayName("moving 성공한 경우 테스트")
		void moveSuccessTest() {
			// given
			final List<String> bridge = newArrayList("U", "D", "U", "U");
			BridgeGame bridgeGame = new BridgeGame(bridge);

			// when
			List<String> movings = newArrayList("U", "D", "U");

			// then
			for (String moving : movings) {
				assertThat(bridgeGame.move(moving)).isEqualTo(MOVING_SUCCESS);
			}
		}

		@Test
		@DisplayName("moving 성공으로 다리 끝에 도달한 경우 테스트")
		void moveSuccessGameEndTest() {
			// given
			final List<String> bridge = newArrayList("U", "D", "D", "U", "D");
			BridgeGame bridgeGame = new BridgeGame(bridge);

			// when
			List<String> movings = newArrayList("U", "D", "D", "U");
			String lastMoving = "D";

			// then
			for (String moving : movings) {
				assertThat(bridgeGame.move(moving)).isEqualTo(MOVING_SUCCESS);
			}
			assertThat(bridgeGame.move(lastMoving)).isEqualTo(MOVING_SUCCESS_GAME_END);

		}
	}

	@Nested
	@DisplayName("다리 건너기 실패 테스트 클래스")
	class FailTest {

		@Test
		@DisplayName("잘못된 moving으로 인해 X칸을 중간에 밟았을 경우 테스트")
		void wrongMovingTest() {
			// given
			final List<String> bridge = newArrayList("U", "D", "U", "U", "U", "D", "U");
			BridgeGame bridgeGame = new BridgeGame(bridge);

			// when
			List<String> wrongMovings = newArrayList("U", "D", "D", "U", "U", "U", "D");
			List<Integer> movingResults = new ArrayList<>();

			for (String moving : wrongMovings) {
				int movingResult = bridgeGame.move(moving);
				if (movingResult == MOVING_FAIL_WRONG_MOVING) {
					break;
				}
				movingResults.add(movingResult);
			}

			// then
			assertThat(movingResults).containsExactly(MOVING_SUCCESS, MOVING_SUCCESS);
		}

		@Test
		@DisplayName("잘못된 moving으로 인해 X칸을 마지막에 밝았을 경우 테스트")
		void wrongMovingEndTest() {
			// given
			final List<String> bridge = newArrayList("U", "D", "U", "U", "U", "D", "U");
			BridgeGame bridgeGame = new BridgeGame(bridge);

			// when
			List<String> wrongMovings = newArrayList("U", "D", "U", "U", "U", "D", "D");
			List<Integer> movingResults = new ArrayList<>();

			for (String moving : wrongMovings) {
				int movingResult = bridgeGame.move(moving);
				if (movingResult == MOVING_FAIL_WRONG_MOVING) {
					break;
				}
				movingResults.add(movingResult);
			}

			// then
			assertThat(movingResults).containsExactly(MOVING_SUCCESS, MOVING_SUCCESS, MOVING_SUCCESS, MOVING_SUCCESS,
					MOVING_SUCCESS, MOVING_SUCCESS);
		}
	}
}
