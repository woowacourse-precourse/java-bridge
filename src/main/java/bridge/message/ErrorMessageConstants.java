package bridge.message;

public interface ErrorMessageConstants {

	String USER_INPUT_ERROR_MESSAGE = "[ERROR] 잘못된 입력입니다.\n";
	String RANGE_ERROR_MESSAGE_FORMAT = "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다.\n";
	String UP_OR_DOWN_COMMAND_ERROR_MESSAGE_FORMAT = "[ERROR] 명령어는 %s 또는 %s 입니다.\n";
	String RESTART_OR_EXIT_COMMAND_ERROR_MESSAGE = "[ERROR] 게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";
}
