package bridge;

public class Constant {
    private static String gameStart = "다리 건너기 게임을 시작합니다.";
    private static String bridgeSize = "다리의 길이를 입력해주세요.";
    private static String error = "[ERROR]";
    private static String moving = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static String reGame = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static String getGameStart() {
        return gameStart;
    }

    public static String getBridgeSize() {
        return bridgeSize;
    }

    public static String getError() {
        return error;
    }

    public static String getMoving() {
        return moving;
    }

    public static String getReGame() {
        return reGame;
    }


}
