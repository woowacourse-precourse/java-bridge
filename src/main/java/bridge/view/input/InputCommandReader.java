package bridge.view.input;

import bridge.domain.player.BridgeSizeCommand;
import bridge.domain.player.CommandReader;
import bridge.domain.player.GameProceedCommand;
import bridge.domain.player.MovementCommand;
import bridge.view.output.OutputView;

import java.util.Arrays;

public class InputCommandReader {

	private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
	private static final String REQUEST_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String REQUEST_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	private final Object command;

	private InputCommandReader(String objectName) {
		this.command = readObject(objectName);
	}

	public static InputCommandReader read(String object) {
		return new InputCommandReader(object);
	}

	private Object readObject(String objectName) {
		return Arrays.stream(ObjectCommand.values())
				.filter(targetObject -> targetObject.objectName.equals(objectName))
				.findFirst()
				.orElse(ObjectCommand.NoneObject)
				.commandReader
				.read();
	}

	public Object command() {
		return command;
	}

	private enum ObjectCommand {

		BridgeSize("BridgeSize", new CommandReader() {
			@Override
			public BridgeSizeCommand read() {
				OutputView.withContentOf(REQUEST_BRIDGE_SIZE, false, false).ConsoleMessage();
				try {
					return BridgeSizeCommand.valueOf(new InputView().input());
				} catch (IllegalArgumentException ignored) {
					return read();
				}
			}
		}),

		Movement("Movement", new CommandReader() {
			@Override
			public MovementCommand read() {
				OutputView.withContentOf(REQUEST_MOVEMENT, true, false).ConsoleMessage();
				try {
					return MovementCommand.valueOf(new InputView().input());
				} catch (IllegalArgumentException ignored) {
					return read();
				}
			}
		}),

		GameProceed("GameProceed", new CommandReader() {
			@Override
			public GameProceedCommand read() {
				OutputView.withContentOf(REQUEST_RETRY, true, false).ConsoleMessage();
				try {
					return GameProceedCommand.valueOf(new InputView().input());
				} catch (IllegalArgumentException ignored) {
					return read();
				}
			}
		}),

		NoneObject("", () -> {
			return new InputView().input();
		});

		private final String objectName;
		private final CommandReader commandReader;

		ObjectCommand(String objectName, CommandReader commandReader) {
			this.objectName = objectName;
			this.commandReader = commandReader;
		}
	}
}
