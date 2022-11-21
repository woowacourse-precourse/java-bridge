package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.controller.BridgeController;

public class BridgeControllerTest {

	@DisplayName("max_정상범위")
	@Test
	void createMaxNumber() {
		int size = 20;

		assertThat(new BridgeController()
				.checkBrideSizeRange(size))
				.isEqualTo(size);
	}

	@DisplayName("범위보다 미만인 경우")
	@Test
	void createUnderNumber() {
		int size = 2;

		assertThatThrownBy(() -> new BridgeController()
				.checkBrideSizeRange(size))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("범위를 초과한 경우")
	@Test
	void createOverNumber() {
		int size = 21;

		assertThatThrownBy(() -> new BridgeController()
				.checkBrideSizeRange(size))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자를 입력한 경우")
	@Test
	void createCharacter() {
		assertThatThrownBy(() -> new BridgeController()
				.checkBrideSizeRange(Integer.parseInt("a")))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("지정된 문자 외 다른문자 입력한 경우")
	@Test
	void createDifferenceCharacter() {
		String gameCommand = "U";

		assertThatThrownBy(() -> new BridgeController()
				.checkGameCommand(gameCommand))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("소문자로 입력한 경우")
	@Test
	void createLowerCharacters() {
		String gameCommand = "q";

		assertThatThrownBy(() -> new BridgeController()
				.checkGameCommand(gameCommand))
				.isInstanceOf(IllegalArgumentException.class);
	}

}
