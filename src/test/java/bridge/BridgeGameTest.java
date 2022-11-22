package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {
	BridgeGame test = new BridgeGame();
	@DisplayName("입력받은 int 값에 대해 정확한 크기의 bridge 를 생성하는지")
	@Test
	void makeBridgeOnInputSize() {
		test.makeBridge(5);
		assertThat(test.bridge.size()).isEqualTo(5);
	}

	@DisplayName("만들어진 bridge list 가 정해진 value 만을 포함하고 있는지")
	@Test
	void verifyBridgeCorrectValue() {
		test.makeBridge(20);
		for (int i = 0; 20 > i; i ++) {
			assertThat(Objects.equals(test.bridge.get(i), "U") || Objects.equals(test.bridge.get(i), "D")).isTrue();
		}
	}

	@DisplayName("move 메서드가 입력받은 값으로 정확히 현재좌표를 표시하고있는지")
	@Test
	void verifyMoveAndCurrentCoordinate() {
		test.makeBridge(3);
		test.move("U");
		test.move("D");
		test.move("D");
		ArrayList<String> testArray = new ArrayList<>();
		testArray.add("U");
		testArray.add("D");
		testArray.add("D");
		assertThat(test.currentCoordinate).isEqualTo(testArray);
	}

	@DisplayName("gameOver 후 Q를 입력시, 정상적으로 retry 가 false 값을 가지는지")
	@Test
	void verifyRetryQuit() {
		test.bridge.add("D");
		test.move("U");
		test.retry("Q");
		assertThat((!test.retry)).isTrue();
	}

	@DisplayName("gameOver 후 R을 입력시, 정상적으로 retry 가 true 값을 가지는지")
	@Test
	void verifyRetry() {
		test.bridge.add("D");
		test.move("U");
		test.retry("R");
		assertThat((test.retry)).isTrue();
	}

}
