package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.domain.Bridge;
import bridge.domain.BridgeResult;
import bridge.domain.BridgeStatus;
import bridge.service.BridgeMaker;
import bridge.service.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest extends NsTest {

	@Test
	@DisplayName("다리 생성 예외 테스트 3~20인지 확인 (경계값)")
	void 다리_생성예외_테스트() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

		assertThatThrownBy(() -> new Bridge(bridgeMaker.makeBridge(21)))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> new Bridge(bridgeMaker.makeBridge(2)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("다리 이동시 이동 가능한지 테스트")
	void 다리_이동가능_테스트() {
		Bridge bridge = new Bridge(List.of("U", "D", "D"));
		BridgeStatus bridgeStatus = bridge.isBridgeStatus("U", 0);
		BridgeStatus bridgeStatus2 = bridge.isBridgeStatus("U", 1);
		BridgeStatus bridgeStatus3 = bridge.isBridgeStatus("D", 2);

		assertThat(bridgeStatus).isEqualTo(BridgeStatus.SUCCESS);
		assertThat(bridgeStatus2).isEqualTo(BridgeStatus.FAIL);
		assertThat(bridgeStatus3).isEqualTo(BridgeStatus.SUCCESS);
	}


	@Test
	@DisplayName("다리 이동 건너기 테스트")
	void 다리_이동출력_테스트() {
		BridgeResult bridgeResult = new BridgeResult();

		bridgeResult.crossOneBridge(BridgeStatus.SUCCESS, "U");
		bridgeResult.crossOneBridge(BridgeStatus.SUCCESS, "D");
		bridgeResult.crossOneBridge(BridgeStatus.SUCCESS, "U");
		bridgeResult.crossOneBridge(BridgeStatus.FAIL, "D");

		System.out.println(bridgeResult);

		assertThat(output()).contains(
			"[ O |   | O |   ]",
			"[   | O |   | X ]"
		);
	}


	@Override
	protected void runMain() {

	}
}
