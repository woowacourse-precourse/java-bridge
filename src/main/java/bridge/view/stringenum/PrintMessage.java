package bridge.view.stringenum;

import bridge.domain.bridgeenum.MovePosition;
import bridge.domain.bridgeenum.Restart;

public enum PrintMessage {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    MOVE(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
            MovePosition.UPPER.getPosition(), MovePosition.LOWER.getPosition())),
    RESTART(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
            Restart.RESTART.getCommand(), Restart.END.getCommand())),
    RESULT("게임 성공 여부: %s"),
    TRY("총 시도한 횟수: %d"),
    END("최종 게임 결과"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String print() {
        return this.message;
    }

    public String print(boolean isSuccess) {
        if (isSuccess) {
            return String.format(message, SUCCESS.message);
        }
        return String.format(message, FAIL.message);
    }

    public String print(int tryCount) {
        return String.format(message, tryCount);
    }
}
