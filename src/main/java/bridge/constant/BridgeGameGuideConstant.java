package bridge.constant;

public enum BridgeGameGuideConstant {

    RUN("다리 건너기 게임을 시작합니다.\n\n"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요.\n"),
    INPUT_MOVE_DIRECTION("\n"
            + "이동할 칸을 선택해주세요. (위: U, 아래: D)\n"),
    INPUT_RETRY_QUESTION("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"),

    RESULT_OF_FINAL_GAME("\n최종 게임 결과\n"),
    GAME_SUCCESS("\n게임 성공 여부: 성공\n"),
    GAME_FAIL("\n게임 성공 여부: 실패\n"),
    TOTAL_ATTEMPT_NUMBER("총 시도한 횟수: ");
    final String message;

    BridgeGameGuideConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

