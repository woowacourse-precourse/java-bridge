package bridge.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
import bridge.utils.Controller.InputController;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Input 클래스")
class InputControllerTest {
	private final String ERROR_MESSAGE = "[ERROR]";
	private InputController inputController = new InputController();

	@Nested
	@DisplayName("getBridgeSize 메소드는")
	class Describe_getBridgeSize {

		@Nested
		@DisplayName("만약 입력한 다리 길이가 3에서 20 사이의 숫자가 아니라면")
		class Context_input_bridge_size_boundary_is_not_three_to_twenty {
			private List<String> inputSizes = new ArrayList<>(Arrays.asList("a", "3"));
			private int expected = 3;

			@Test
			@DisplayName("에러를 출력하고 다시 입력받는다.")
			void it_inputs_again() {
				OutputStream out = new ByteArrayOutputStream();
				System.setOut(new PrintStream(out));

				inputSizes.stream()
					.forEach(inputSize -> {
						try {
							InputStream in = new ByteArrayInputStream(inputSize.getBytes());
							System.setIn(in);
							BridgeSize bridgeSize = inputController.getBridgeSize();
							assertThat(bridgeSize.getSize()).isEqualTo(expected);
						} catch (NoSuchElementException error) {
							assertThat(out.toString()).contains(ERROR_MESSAGE);
						}
					});
			}
		}
	}

	@Nested
	@DisplayName("getMoving 메소드는")
	class Describe_getMoving {

		@Nested
		@DisplayName("만약 입력한 이동할 칸의 방향이 U나 D가 아니라면")
		class Context_input_moving_direction_is_not_U_or_D {
			private List<String> inputSizes = new ArrayList<>(Arrays.asList("a", "U"));
			private String expected = "U";

			@Test
			@DisplayName("에러를 출력하고 다시 입력받는다.")
			void it_inputs_again() {
				OutputStream out = new ByteArrayOutputStream();
				System.setOut(new PrintStream(out));

				inputSizes.stream()
					.forEach(inputSize -> {
						try {
							InputStream in = new ByteArrayInputStream(inputSize.getBytes());
							System.setIn(in);
							Moving moving = inputController.getMoving();
							assertThat(moving.getMoving()).isEqualTo(expected);
						} catch (NoSuchElementException error) {
							assertThat(out.toString()).contains(ERROR_MESSAGE);
						}
					});
			}
		}
	}

	@Nested
	@DisplayName("getGameCommand 메소드는")
	class Describe_getGameCommand {

		@Nested
		@DisplayName("만약 입력한 재시작 명령이 R이나 Q가 아니라면")
		class Context_input_command_is_not_R_or_Q {
			private List<String> inputSizes = new ArrayList<>(Arrays.asList("a", "R"));
			private String expected = "R";

			@Test
			@DisplayName("에러를 출력하고 다시 입력받는다.")
			void it_inputs_again() {
				OutputStream out = new ByteArrayOutputStream();
				System.setOut(new PrintStream(out));

				inputSizes.stream()
					.forEach(inputSize -> {
						try {
							InputStream in = new ByteArrayInputStream(inputSize.getBytes());
							System.setIn(in);
							GameCommand gameCommand = inputController.getGameCommand();
							assertThat(gameCommand.getCommand()).isEqualTo(expected);
						} catch (NoSuchElementException error) {
							assertThat(out.toString()).contains(ERROR_MESSAGE);
						}
					});
			}
		}
	}
}
