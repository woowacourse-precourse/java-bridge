package bridge;

import bridge.Bridge;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

	@Test
	void 제대로_된_값() {
		List<String> input = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));

		Bridge bridge = new Bridge(input);
	}

	@Test
	void 예외_U_D_이외의_값() {
		List<String> input = new ArrayList<>();
		input.add("U");
		input.add("D");
		input.add("A");

		assertThatThrownBy(() -> new Bridge(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}