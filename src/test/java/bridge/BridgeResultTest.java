package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.domain.BridgeResult;

public class BridgeResultTest {
	final int count = 0;

	@DisplayName("게임이 성공했는지 확인")
	@Test
	void createSuccessGame() {
		String message = "[ O |   ]\n[   | X ]";
		boolean result = false;

		assertThat(new BridgeResult(message, count).getIsClear()).isEqualTo(result);
	}

	@DisplayName("게임이 실패했는지 확인")
	@Test
	void createFailGame() {
		String message = "[ O |   ]\n[   | O ]";
		boolean result = true;

		assertThat(new BridgeResult(message, count).getIsClear()).isEqualTo(result);
	}

}
