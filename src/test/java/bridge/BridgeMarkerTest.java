package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeMarkerTest {

	@DisplayName("generate는 0이나 1을 랜덤하게 반환한다")
	@Test
	void generate() {
		BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
		int number = generator.generate();

		assertThat(number).isIn(0, 1);
	}

}
