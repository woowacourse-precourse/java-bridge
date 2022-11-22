package bridge.domain;

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

	@DisplayName("다리 초기화 검사")
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
		// assertThat(bridgeGameInitialization.initBridge().showBridge()).contains("U", "D");
	}
}
