package bridge;

import bridge.enums.UpDown;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


class BridgeMakerTest {
	private BridgeMaker bridgeMaker;

	@BeforeEach
	void beforeEach(){
		bridgeMaker = new BridgeMaker(new BridgeOnlyZeroGenerator());
	}

	@DisplayName("다리가 정상적으로 생성된다.")
	@Test
	void makeBridgeValueTest() {
		List<String> bridge = bridgeMaker.makeBridge(5);
		Assertions.assertThat(bridge).containsOnly("D");
	}

	@DisplayName("생성된 다리에는 U 와 D 만 있어야 한다.")
	@Test
	void bridgeValueTest() {
		List<String> bridge = bridgeMaker.makeBridge(5);
		int count = (int) bridge.stream()
				.filter(value -> UpDown.getDirectionValues().contains(value))
				.count();
		Assertions.assertThat(count).isEqualTo(bridge.size());
	}

	@DisplayName("다리 생성 길이는 3이상 20 이하여야 한다.")
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
	void makeBridgeSizeTest(int size) {
		List<String> bridge = bridgeMaker.makeBridge(size);
		Assertions.assertThat(bridge.size()).isEqualTo(size);
	}

	@DisplayName("다리 생성 길이 범위를 벗어나는 경우 테스트")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 1, 2, 21, 50, 100})
	void makeBridgeSizeExceptionTest(int size) {
		Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
				.isInstanceOf(IllegalArgumentException.class);
	}

	class BridgeOnlyZeroGenerator implements BridgeNumberGenerator {
		@Override
		public int generate() {
			return 0;
		}
	}
}