package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int bridgesize_len;
    public static String gameRestart;
    private int bridegeLen;

    public InputView() {
    }

    public InputView(BridgeGame bridgeGame) {
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리 길이 입력: ");
        String bridgeSize = readLine();
        Error error = new Error();
        bridgesize_len = error.validBridegeLen(Integer.parseInt(bridgeSize));
        return bridgesize_len;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("어디로 이동하시겠습니까? -> 위: U, 아래: D");
        String userMove = readLine();
//        new Error().validUOrD();
        return userMove;
//        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 재 시작하겠습니까? -> 재시도: R, 종료: Q");
        String returnGame = readLine();
        new Error().validRetry(returnGame);
        return returnGame;

//        return null;
    }
}