package bridge;

public enum OutputMessage {
    gameStartMessage("다리 건너기 게임을 시작합니다"),
    getBridgeSize("다리의 길이를 입력해주세요."),
    getMoveCommand("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    getRetryGame("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q"),
    finalGameResult("최종 게임 결과"),
    gameResultClear("게임 성공 여부: 성공"),
    gameResultFail("게임 성공 여부 : 실패"),
    gameTryCount("총 시도한 횟수: ")
    ;

    private final String message;

    OutputMessage(String msg){
        this.message = msg;
    }
    public String getMessage(){
        return message;
    }
}
