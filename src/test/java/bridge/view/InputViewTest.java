package bridge.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

	private InputView inputView = new InputView();
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private OutputView outputView = new OutputView();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));

		String text = " ";
		InputStream in = new ByteArrayInputStream(text.getBytes());
		System.setIn(in);
	}

	@DisplayName("readBridgeSize 메서드 출력및 입력 테스트")
	@Test
	void readBridgeSize() {
		//given
		String bridgeSizePhrase = InputView.BRIDGE_SIZE_PHRASE;

		//when
		inputView.readBridgeSize();

		//then
		Assertions.assertThat(outContent.toString()).contains(bridgeSizePhrase);
	}

	@DisplayName("readMoving 메서드 출력및 입력 테스트")
	@Test
	void readMoving() {
		//given
		String chooseMoveSpacePhrase = InputView.CHOOSE_MOVE_SPACE_PHRASE;

		//when
		inputView.readMoving();

		//then
		Assertions.assertThat(outContent.toString()).contains(chooseMoveSpacePhrase);
	}

	@DisplayName("readGameCommand 메서드 출력및 입력 테스트")
	@Test
	void readGameCommand() {
		//given
		String restartOrQuitPhrase = InputView.RESTART_OR_QUIT_PHRASE;

		//when
		inputView.readGameCommand();

		//then
		Assertions.assertThat(outContent.toString()).contains(restartOrQuitPhrase);
	}
}
