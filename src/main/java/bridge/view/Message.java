package bridge.view;

import bridge.model.game.Command;
import bridge.model.game.Direction;

public enum Message {
    GAME_START("다리 건너기 게임을 시작합니다.\n"),
    GET_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    CHOOSE_UP_OR_DOWN("이동할 칸을 선택해주세요. " + Direction.info()),
    CHOOSE_RETRY("게임을 다시 시도할지 여부를 입력해주세요. " + Command.info()),
    FINAL_STATE("최종 게임 결과"),
    GAME_SUCCESS("게임 성공 여부: "),
    NUMBER_OF_TRY("총 시도한 횟수: ");

    private final String msg;

    Message(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return this.msg;
    }
}
