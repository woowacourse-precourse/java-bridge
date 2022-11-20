package model;

public interface BridgeGameExceptions {

    String OUT_OF_RANGE = "범위를 벗어난 숫자입니다. 다리 길이는 3 ~ 20 사이의 수여야 합니다.";
    String NOT_A_NUMBER = "입력값은 숫자로 주어져야 합니다";
    String NOT_A_MOVE_CHOICE = "위로 이동하려면 U, 아래로 이동하려면 D를 입력해야 합니다.";
    String NOT_A_RETRY_INTENTION = "다시 게임을 시작하려면 R, 게임을 종료하려면 Q를 입력해야합니다.";
    String BLANK = "입력값은 공백이 될 수 없습니다.";

}
