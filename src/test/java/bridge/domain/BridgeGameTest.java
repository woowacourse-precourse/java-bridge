package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import bridge.domain.BridgeGame;

public class BridgeGameTest {

	private static final int BRIDGE_SIZE = 3;
	private BridgeGame game;

	@BeforeEach
	void beforeEach() {
		game = new BridgeGame(BRIDGE_SIZE);
	}

	@DisplayName("BridgeGame은 생성시 입력받은 size 만큼의 List를 가진 Bridge를 생성한다")
	@Test
	void createBridgeGame() {
		List<String> result = game.getBridge().getBoards();

		assertThat(result).hasSize(3);
	}

	@DisplayName("move는 주어진 다리 발판 BridgeRecord의 boards에 추가하고 정답여부를 반환한다")
	@Test
	void move() {
		String board = game.getBridge().getBoards().get(0);
		boolean result = game.move(board);

		assertThat(result).isTrue();
	}

	@DisplayName("retry는")
	@Nested
	class Retry {

		@DisplayName("retry는 R을 입력받으면 BridgeRecord의 deleteBoard와 increaseTry를 호출하고 false를 반환한다")
		@Test
		void retryCommand() {
			game.move("U");
			boolean result = game.retry("R");

			assertThat(game.getRecord().getBoards()).hasSize(0);
			assertThat(game.getRecord().getTryCount()).isEqualTo(2);
			assertThat(result).isFalse();
		}

		@DisplayName("retry는 Q을 입력받으면 true를 반환한다")
		@Test
		void quitCommand() {
			boolean result = game.retry("Q");

			assertThat(result).isTrue();
		}
	}

	@DisplayName("isFinish는")
	@Nested
	class IsFinish {

		@DisplayName("bridge와 record의 길이가 같으면 true를 반환한다")
		@Test
		void retryCommand() {
			for (int i = 0; i < BRIDGE_SIZE; i++) {
				game.move("U");
			}
			boolean result = game.isFinish();

			assertThat(result).isTrue();
		}

		@DisplayName("bridge와 record의 길이가 같으면 false를 반환한다")
		@Test
		void quitCommand() {
			for (int i = 0; i < BRIDGE_SIZE - 1; i++) {
				game.move("U");
			}
			boolean result = game.isFinish();

			assertThat(result).isFalse();
		}
	}

}
