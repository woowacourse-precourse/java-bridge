package bridge.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
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
class InputTest {
	Input input = new Input();

	@Nested
	@DisplayName("bridgeSize 메소드는")
	class Describe_bridgeSize {

		@Nested
		@DisplayName("만약 입력한 다리 길이가 3에서 20 사이의 숫자가 아니라면")
		class Context_input_bridge_size_boundary_is_not_three_to_twenty {
			List<String> inputSizes = new ArrayList<>(Arrays.asList("a", "3"));
			int expected = 3;

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
							BridgeSize bridgeSize = input.bridgeSize();
							assertThat(bridgeSize.getSize()).isEqualTo(expected);
						} catch (NoSuchElementException error) {
							assertThat(out.toString()).contains("[ERROR]");
						}
					});
			}
		}
	}

	@Nested
	@DisplayName("moving 메소드는")
	class Describe_moving {

		@Nested
		@DisplayName("만약 입력한 이동할 칸의 방향이 U나 D가 아니라면")
		class Context_input_moving_direction_is_not_U_or_D {
			List<String> inputSizes = new ArrayList<>(Arrays.asList("a", "U"));
			String expected = "U";

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
							Moving moving = input.moving();
							assertThat(moving.getMoving()).isEqualTo(expected);
						} catch (NoSuchElementException error) {
							assertThat(out.toString()).contains("[ERROR]");
						}
					});
			}
		}
	}

	@Nested
	@DisplayName("gameCommand 메소드는")
	class Describe_gameCommand {

		@Nested
		@DisplayName("만약 입력한 재시작 명령이 R이나 Q가 아니라면")
		class Context_input_command_is_not_R_or_Q {
			List<String> inputSizes = new ArrayList<>(Arrays.asList("a", "R"));
			String expected = "R";

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
							GameCommand gameCommand = input.gameCommand();
							assertThat(gameCommand.getCommand()).isEqualTo(expected);
						} catch (NoSuchElementException error) {
							assertThat(out.toString()).contains("[ERROR]");
						}
					});
			}
		}
	}
}
