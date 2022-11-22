package bridge.View;

public enum Message {
    START_GAME("다리 건너기 게임을 시작합니다.%n%n"),
    CHOICE_BRIDGE_SIZE("다리의 길이를 입력해주세요.%n"),
    CHOICE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)%n"),
    CHOICE_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)%n"),
    RESULT("최종 게임 결과%n"),
    SUCCESS_OR_NOT("게임 성공 여부: "),
    PLAY_COUNT("%n총 시도한 횟수: "),
    ERROR_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.%n%n게임을 다시 재개합니다. 제대로 입력해주세요.%n"),
    ERROR_MOVE("[ERROR] 이동할 칸은 위: U, 아래: D 대문자만 입력 가능합니다.%n게임을 다시 재개합니다. 제대로 입력해주세요.%n%n"),
    ERROR_RETRY("[ERROR] 재시작: R, 종료: Q 대문자만 입력 가능합니다.%n%n게임을 다시 재개합니다. 제대로 입력해주세요.%n");


    private final String view;

    Message(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }


}
