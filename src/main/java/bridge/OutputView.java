package bridge;

import org.w3c.dom.ls.LSOutput;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    public void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame.toString());

    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
        if (bridgeGame.getMoveResult() == 1) {
            System.out.println("게임 성공 여부: " + "성공");
        }
        if (bridgeGame.getMoveResult() != 1) {
            System.out.println("게임 성공 여부: " + "실패");
        }
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryNumber());
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeMake() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printException(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
