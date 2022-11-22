package bridge.view.input;

import bridge.domain.player.BridgeSizeCommand;
import bridge.domain.player.CommandReader;
import bridge.domain.player.GameProceedCommand;
import bridge.domain.player.MovementCommand;

import java.util.Arrays;

public class InputCommandReader {

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
