package bridge;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BrideMakerTest {

	@DisplayName("랜덤으로 뽑은 숫자가 0에서 1사이인지 테스트")
	@Test
	void makeBridgeRandomNumber_메서드_테스트() {
		int randomNumber = BridgeMaker.makeBridgeRandomNumber();

		boolean isRangeException = false;
		if (randomNumber < 0 || randomNumber > 1) {
			isRangeException = true;
		}

		Assertions.assertThat(isRangeException).isFalse();
	}
}
