package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.service.BridgeMaker;
import bridge.service.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	@DisplayName("다리 생성 예외 테스트 3~20인지 확인")
	void 다리_생성예외_테스트() {
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

		try {
			List<String> bridge = bridgeMaker.makeBridge(2);
		} catch (IllegalArgumentException e) {}

		assertThat(output()).contains(ERROR_MESSAGE);
	}
	@Override
	protected void runMain() {

	}
}
