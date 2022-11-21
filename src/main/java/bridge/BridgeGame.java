package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int END_GAME = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String move() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String nextMove = Console.readLine();
        if(ErrorCheck.isValidUpOrDown(nextMove));
        System.out.println("nextMove : " + nextMove);

        return nextMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static int retry(int gameCnt, String answerOfRetry, int BRIDGE_LENGTH) {
        if(answerOfRetry.equals("Q")) {
            retryAnswerIsQuit(gameCnt);
            return END_GAME;
        }
        System.out.println("BridgeGame BRIDGE_LENGTH : " + BRIDGE_LENGTH);
        return BRIDGE_LENGTH;
    }

    public static void retryAnswerIsQuit(int gameCnt) {
        System.out.println("최종 게임 결과");
        OutputView.printUpBridge();
        OutputView.printDownBridge();
        System.out.println("총 시도한 횟수: " + gameCnt);
    }
}
