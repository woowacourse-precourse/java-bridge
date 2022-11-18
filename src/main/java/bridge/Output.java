package bridge;

public enum Output {

    gameStart("다리 건너기 게임을 시작합니다."),
    bridgeLengthInputRequest("다리의 길이를 입력해주세요."),
    whereToGoInputRequest("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    continueOrEndRequest("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    winOrLoseResult("게임 성공 여부: "),
    howManyAttempts("총 시도한 횟수: ");

    private final String output;

    Output(String output) {
        this.output = output;
    }

    String getOutput() {
        return output;
    }
}
