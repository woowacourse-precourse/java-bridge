package bridge;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BrideMakerTest {

	@DisplayName("랜덤으로 뽑은 숫자가 0에서 1사이인지 테스트")
	@Test
	void makeBridgeRandomNumber_메서드_테스트() {
		List<Integer> randomNumbers = BridgeMaker.makeBridgeRandomNumber(6);

		boolean isRangeException = false;

		for (Integer randomNumber : randomNumbers) {
			if (randomNumber < 0 || randomNumber > 1) {
				isRangeException = true;
			}
		}

		Assertions.assertThat(isRangeException).isFalse();
	}

	@DisplayName("randomNumber가 1이면 U, 0이면 D로 설정 테스트")
	@Test
	void setUOrD_메서드_테스트() {
		List<String> bridge = new ArrayList<>();
		List<Integer> randomNumbers = new ArrayList<>(List.of(1, 1, 1, 0, 0, 0));

		BridgeMaker.setUOrD(bridge, randomNumbers);

		Assertions.assertThat(bridge).isEqualTo(List.of("U", "U", "U", "D", "D", "D"));
	}
}
