package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import static model.BridgeGameConstants.MOVING_FAIL_WRONG_MOVING;

import camp.nextstep.edu.missionutils.test.NsTest;
import model.BridgeGame;
import view.InputView;
import view.OutputView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	void 다리_생성_테스트() {
		BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
		BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(3);
		assertThat(bridge).containsExactly("U", "D", "D");
	}

	@Test
	void 기능_테스트() {
		assertRandomNumberInRangeTest(() -> {
			run("3", "U", "D", "U");
			assertThat(output()).contains("최종 게임 결과", "[ O |   | O ]", "[   | O |   ]", "게임 성공 여부: 성공", "총 시도한 횟수: 1");

			int upSideIndex = output().indexOf("[ O |   | O ]");
			int downSideIndex = output().indexOf("[   | O |   ]");
			assertThat(upSideIndex).isLessThan(downSideIndex);
		}, 1, 0, 1);
	}

	@Test
	void 예외_테스트() {
		assertSimpleTest(() -> {
			runException("a");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}

	static class TestNumberGenerator implements BridgeNumberGenerator {

		private final List<Integer> numbers;

		TestNumberGenerator(List<Integer> numbers) {
			this.numbers = numbers;
		}

		@Override
		public int generate() {
			return numbers.remove(0);
		}
	}

	@Nested
	@DisplayName("view 도메인로직 단위 테스트")
	class ViewTest {

		private ByteArrayOutputStream outputStream;
		private OutputView outputView = new OutputView();
		private InputView inputView = new InputView();
		private BridgeGame bridgeGame;

		@BeforeEach
		void setOutputStreamBeforeEach() {
			outputStream = new ByteArrayOutputStream();
			System.setOut(new PrintStream(outputStream));
		}

		@AfterEach
		void printMapClearAndRestoreOutputStream() {
			outputView.clearGameStateMap();
			System.setOut(System.out);
		}

		@Test
		@DisplayName("다리건너기 게임 시작, 다리 길이 입력, 이동할 칸 선택, 게임 상태 출력, 게임 재시작 여부 통합 테스트")
		void viewDomainTest() {

			String expectedPrintMap = "다리의 길이를 입력해주세요.\r\n"
//					+ "3\r\n"
					+ "\r\n" + "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n"
//					+ "U\r\n"
					+ "[ O ]\r\n" + "[   ]\r\n" + "\r\n" + "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n"
//					+ "U\r\n"
					+ "[ O | X ]\r\n" + "[   |   ]\r\n" + "\r\n" + "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\r\n"
//					+ "R\r\n"
					+ "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n"
//					+ "U\r\n"
					+ "[ O ]\r\n" + "[   ]\r\n" + "\r\n" + "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n"
//					+ "D\r\n"
					+ "[ O |   ]\r\n" + "[   | O ]\r\n" + "\r\n" + "이동할 칸을 선택해주세요. (위: U, 아래: D)\r\n"
//					+ "D\r\n"
					+ "[ O |   |   ]\r\n" + "[   | O | O ]\r\n" + "\r\n";
			// given
			List<String> bridge = List.of("U", "D", "D");
			bridgeGame = new BridgeGame(bridge);
			String bridgeSize = "3";
			List<String> movingCommandsRoundOne = List.of("U", "U");
			List<String> movingCommandsRoundTwo = List.of("U", "D", "D");

			// when: 다리길이 입력
			readLine(bridgeSize);
			inputView.readBridgeSize();

			for (int moveCount = 0; moveCount < movingCommandsRoundOne.size(); moveCount++) {
				String moving = movingCommandsRoundOne.get(moveCount);
				// when: 이동할 칸 선택
				readLine(moving);
				inputView.readMoving();

				int movingResult = bridgeGame.move(moving);

				outputView.printMap(moving, movingResult);

				if (movingResult == MOVING_FAIL_WRONG_MOVING) {
					readLine("R");
					inputView.readGameCommand();
					outputView.clearGameStateMap();
					bridgeGame.retry();
				}
			}

			// when: moving 실패
			for (int moveCount = 0; moveCount < movingCommandsRoundTwo.size(); moveCount++) {
				String moving = movingCommandsRoundTwo.get(moveCount);
				readLine(moving);
				inputView.readMoving();

				int movingResult = bridgeGame.move(moving);

				outputView.printMap(moving, movingResult);
			}
			assertThat(outputStream.toString()).isEqualTo(expectedPrintMap);
		}

		private void readLine(String playerInput) {
			InputStream in = new ByteArrayInputStream(playerInput.getBytes());
			System.setIn(in);
		}

	}

}
