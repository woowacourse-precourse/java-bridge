package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeRandomNumberGeneratorTest {

	private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

	@DisplayName("생성된 숫자가 0 또는 1인지 확인하는 테스트")
	@Test
	void generate() {
		//when
		List<Integer> bridge = new ArrayList<>();

		//when
		for (int i = 0; i < 4; i++) {
			bridge.add(bridgeRandomNumberGenerator.generate());
		}

		//then
		bridge.stream().forEach(i -> assertThat(i).isIn(0, 1));
	}
}
