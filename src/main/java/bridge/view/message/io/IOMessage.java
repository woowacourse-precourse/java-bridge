package bridge.view.message.io;

public interface IOMessage {
    String MESSAGE_START= "다리 건너기 게임을 시작합니다.";
    String MESSAGE_INPUT_LENGTH = "다리의 길이를 입력해주세요.";
    String MESSAGE_INPUT_MOVING = "이동할 칸을 선택해 주세요. (위: U, 아래: D)";
    String MESSAGE_INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    String MESSAGE_RESULT = "최종 게임 결과";
    String MESSAGE_CLEAR = "게임 성공 여부: 성공";
    String MESSAGE_FAIL = "게임 성공 여부: 실패";
    String MESSAGE_RETRY = "총 시도한 횟수: ";
    String MESSAGE_BRIDGE_PREFIX = "[";
    String MESSAGE_BRIDGE_SUFFIX = "]";
    String MESSAGE_BRIDGE_CORRECT = " O ";
    String MESSAGE_BRIDGE_WRONG = " X ";
    String MESSAGE_BRIDGE_EMPTY = "   ";
    String MESSAGE_BRIDGE_MIDDLE = "|";
}
