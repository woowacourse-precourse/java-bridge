package domain;

import java.util.ArrayList;
import java.util.List;

public class Validate {
	private String errorMessage;
	private List<String> sizeList = new ArrayList<>();

	public Validate() {
		setSizeList();
	}

	private void setSizeList() {
		for (int i = 3; i < 21; i++) {
			sizeList.add(i + "");
		}
	}

	public void validateSize(String size) {
		if (!sizeList.contains(size)) {
			errorMessage = ErrorMessage.WRONG_SIZE.getErrorMessage();
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public void validateMove(String move) {
		if (!move.equals("U") && !move.equals("D")) {
			errorMessage = ErrorMessage.WRONG_MOVING.getErrorMessage();
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public void validateGameCommand(String gameCommand) {
		if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
			errorMessage = ErrorMessage.WRONG_COMMAND.getErrorMessage();
			throw new IllegalArgumentException(errorMessage);
		}
	}
}