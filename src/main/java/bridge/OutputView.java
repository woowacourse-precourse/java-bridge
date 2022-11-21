package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int current, boolean correct) {
        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();
        up.append("[");
        down.append("[");
        for (int i = 0; i < current + 1; i++) {
            if (i != 0) {
                up.append("|");
                down.append("|");
            }
            if (bridge.get(i).equals("D")) {
                up.append("   ");
                down.append(" O ");
            }
            if (bridge.get(i).equals("U")) {
                up.append(" O ");
                down.append("   ");
            }
        }
        if (correct == false) {
            if (bridge.get(current).equals("D")) {
                up.setLength(up.length() - 1);
                down.setLength(down.length() - 1);
                up.append("   ");
                down.append(" X ");
            }
            if (bridge.get(current).equals("U")) {
                up.setLength(up.length() - 1);
                down.setLength(down.length() - 1);
                up.append(" X ");
                down.append("   ");
            }
        }
        up.append("]");
        down.append("]");

        System.out.println(up.toString());
        System.out.println(down.toString());
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, int count, int current, boolean gameEnd) {
        if(gameEnd){
            System.out.println(OutputMessage.finalGameResult.getMessage());
            printMap(bridge, current-1, true);
            System.out.println(OutputMessage.gameResultClear.getMessage());
            System.out.print(OutputMessage.gameTryCount.getMessage());
            System.out.println(count);
        }
        if (!gameEnd) {
            System.out.println(OutputMessage.finalGameResult.getMessage());
            printMap(bridge, current, false);
            System.out.println(OutputMessage.gameResultFail.getMessage());
            System.out.print(OutputMessage.gameTryCount.getMessage());
            System.out.println(count);
        }
    }

    public void printGameStart(){
        System.out.println(OutputMessage.gameStartMessage.getMessage() + "\n");
    }

    public void printGetBridgeSize(){
        System.out.println(OutputMessage.getBridgeSize.getMessage());
    }

    public void printMoveCommand(){
        System.out.println(OutputMessage.getMoveCommand.getMessage());
    }
    public void printGameRetry(){
        System.out.println(OutputMessage.getRetryGame.getMessage());
    }
    public void printFinalGameResult(){
        System.out.println(OutputMessage.finalGameResult.getMessage());
    }
    public void printResultClear(){
        System.out.println(OutputMessage.gameResultClear.getMessage());
    }

}
