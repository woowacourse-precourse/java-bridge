package bridge.view;

import bridge.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printBridgeSizeRequest() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMovingRequest(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printGameStatusRequest() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }


    public void printMap(char[][] movingLog) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <movingLog.length ; i++) {
            stringBuilder.append("[ ");
            for (int j = 0; j <movingLog[i].length ; j++) {
                stringBuilder.append(movingLog[i][j] + " ");
                if (j < movingLog[i].length - 1) {
                    stringBuilder.append("| ");
                }
            }
            stringBuilder.append("]\n");
        }
        System.out.print(stringBuilder.toString());
    }


    public void printResult(int count, BridgeGame bridgeGame) {
        printSuccess(bridgeGame.survival);
        printCountGame(count);
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.log);
    }

    private void printCountGame(int count) {
        System.out.println("총 시도한 횟수: "+count);
    }


    private void printSuccess(boolean win) {
        if (win) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");

    }
}
