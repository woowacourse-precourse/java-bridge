package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeMaker 클래스")
class BridgeMakerTest {

	@Nested
	@DisplayName("makeBridge 메소드는")
	class Describe_makeBridge {

		@Nested
		@DisplayName("랜덤 숫자 생성기가 생성한 임의의 숫자가 0이라면")
		class Context_BridgeRandomNumberGenerator_create_number_zero {
			private bridge.BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new bridge.BridgeRandomNumberGenerator() {
				@Override
				public int generate() {
					return Randoms.pickNumberInRange(0, 0);
				}
			};

			@Test
			@DisplayName("해당 다리의 칸에 D를 생성한다.")
			void it_create_list_includes_D() {
				int size = 1;
				BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
				List<String> bridge = bridgeMaker.makeBridge(size);
				List<String> expected = new ArrayList<>(Arrays.asList("D"));
				assertThat(bridge).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("랜덤 숫자 생성기가 생성한 임의의 숫자가 1이라면")
		class Context_BridgeRandomNumberGenerator_create_number_one {
			private bridge.BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new bridge.BridgeRandomNumberGenerator() {
				@Override
				public int generate() {
					return Randoms.pickNumberInRange(1, 1);
				}
			};

			@Test
			@DisplayName("해당 다리의 칸에 U를 생성한다.")
			void it_create_list_includes_U() {
				int size = 1;
				BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
				List<String> bridge = bridgeMaker.makeBridge(size);
				List<String> expected = new ArrayList<>(Arrays.asList("U"));
				assertThat(bridge).isEqualTo(expected);
			}
		}
	}
}

