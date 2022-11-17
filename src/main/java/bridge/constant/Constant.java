package bridge.constant;

public enum Constant {
	DOWN_BRIDGE_COMMAND("D"),
	UP_BRIDGE_COMMAND("U"),
	RETRY_COMMAND("R"),
	QUIT_COMMAND("Q"),
	BLANK_SPACE(" "),
	POSSIBLE_SPACE("O"),
	IMPOSSIBLE_SPACE("X"),
	CLEAR("성공"),
	FAIL("실패"),
	PREFIX("[ "),
	DELIMITER(" | "),
	SUFFIX(" ]");


	private final String constant;

	Constant(String constant) {
		this.constant = constant;
	}

	public String getConstant() {
		return constant;
	}
}
