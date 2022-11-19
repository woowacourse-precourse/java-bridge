package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class BrideMakerTest extends NsTest {

	@DisplayName("randomNumber가 1이면 U, 0이면 D로 설정 테스트")
	@Test
	void setUOrD_메서드_테스트() {
		List<String> bridge = new ArrayList<>();
		List<Integer> randomNumbers = new ArrayList<>(List.of(1, 1, 1, 0, 0, 0));

		BridgeMaker.setUOrD(bridge, randomNumbers);

		Assertions.assertThat(bridge).isEqualTo(List.of("U", "U", "U", "D", "D", "D"));
	}

	@DisplayName("bridge 생성 테스트")
	@Test
	void makeBridge_메서드_테스트() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		int size = 6;

		assertRandomNumberInRangeTest(
			() -> {
				assertThat(bridgeMaker.makeBridge(size)).isEqualTo((List.of("U", "U", "U", "D", "D", "D")));
			}, 1, 1, 1, 0, 0, 0);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
