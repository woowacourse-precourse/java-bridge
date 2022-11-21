package bridge.view.message.io;

public interface IOMessage {
    String GAME_START = "다리 건너기 게임을 시작합니다.";
    String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    String INPUT_BRIDGE_MOVING = "이동할 칸을 선택해 주세요. (위: U, 아래: D)";
    String GAME_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    String GAME_RESULT = "최종 게임 결과";
    String STATISTICS_CLEAR = "게임 성공 여부";
    String GAME_CLEAR = "성공";
    String GAME_FAIL = "실패";
    String STATISTICS_GAME_COUNT = "총 시도한 횟수";
}
