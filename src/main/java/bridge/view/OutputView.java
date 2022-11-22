package bridge.view;

import bridge.model.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeToInput() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printPlayerMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printMap(BridgeGame bridgeGame) {
        printUpMap(bridgeGame);
        printDownMap(bridgeGame);
    }

    public void printUpMap(BridgeGame bridgeGame) {
        System.out.print("[");
        for (int i = 0; i < bridgeGame.getUpMove().size(); i++) {
            System.out.print(bridgeGame.getUpMove().get(i));
            if (i + 1 < bridgeGame.getUpMove().size())
                System.out.print("|");
        }
        System.out.println("]");
    }

    public void printDownMap(BridgeGame bridgeGame) {
        System.out.print("[");
        for (int i = 0; i < bridgeGame.getDownMove().size(); i++) {
            System.out.print(bridgeGame.getDownMove().get(i));
            if (i + 1 < bridgeGame.getDownMove().size())
                System.out.print("|");
        }
        System.out.println("]");
    }

    public void printProgress() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);

        printGameSuccess(bridgeGame.isGameSuccess());
        System.out.println("총 시도한 횟수: " + bridgeGame.getGameCnt());
    }

    public void printGameSuccess(boolean success) {
        if(success)
            System.out.println("게임 성공 여부: 성공");

        if(!success)
            System.out.println("게임 성공 여부: 실패");
    }
}
