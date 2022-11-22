package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameInitializationTest {
	private static final BridgeGameInitialization bridgeGameInitialization = new BridgeGameInitialization();

	// @BeforeAll
	// static void beforeAll() {
	// 	bridgeGameInitialization = new BridgeGameInitialization();
	// }

	@DisplayName("올바른 다리 생성 여부 테스트")
	@Test
	void initBridge() {
		//	given
		BridgeGameInitialization bridgeGameInitialization = new BridgeGameInitialization();

		String notNumber = "3a";
		String outboundRange = "25";
		String correct = "5";

		//	when
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		InputStream in = new ByteArrayInputStream(correct.getBytes());
		System.setIn(in);

		// then
		assertThat(bridgeGameInitialization.initBridge().getBridgeSize()).isEqualTo(Integer.parseInt(correct));
	}
}
