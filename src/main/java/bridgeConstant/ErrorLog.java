package bridgeConstant;

public enum ErrorLog {
	ERROR_MARK("[ERROR]"),
	LENGTH_IS_NOT_MATCHED_EXCEPTION("다리의 길이가 입력받은 길이와 같지 않습니다."),
	INVALID_LENGTH_RANGE_EXCEPTION("다리의 길이는 3부터 20 사이여야 합니다."),
	NOT_NATURAL_NUMBER_EXCEPTION("다리의 길이는 자연수여야 합니다."),
	NOT_CAPITAL_LETTER_EXCEPTION("입력은 알파벳 대문자 하나여야 합니다."),
	INVALID_MOVING_INPUT_EXCEPTION("입력은 U와 D 둘 중 하나여야 합니다."),
	INVALID_BRIDGE_COMPONENT_EXCEPTION("다리는 U와 D로 이루어져야 합니다."),
	INVALID_GAME_COMMAND_EXCEPTION("입력은 R과 Q 둘 중 하나여야 합니다."),
	SPACE(" ");
	private final String log;
	ErrorLog(String log) {
		this.log = log;
	}

	public String log() {
		return ERROR_MARK.log
			+ SPACE.log
			+ log;
	}
}
