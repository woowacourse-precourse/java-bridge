package bridge;

import bridge.Enums.OutputMessage;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printReadBridgeSize(){
        OutputMessage.GAME_START_MESSAGE.println();
    }

    public static void printReadMoving(){
        OutputMessage.READ_MOVING_MESSAGE.println();
    }

    public static void printReadCommand(){
        OutputMessage.READ_COMMAND_MESSAGE.println();
    }

    public static String parseHistory(String currentBridgeDirection, String currentInput, String direction){
        if (currentInput.equals(currentBridgeDirection)){
            if (currentBridgeDirection.equals(direction)){ return "O"; }
            if (!currentBridgeDirection.equals(direction)){ return " "; }
        }
        if (!currentInput.equals(currentBridgeDirection)){
            if (currentBridgeDirection.equals(direction)){ return "X"; }
            if (!currentBridgeDirection.equals(direction)){ return " "; }
        }
        return " ";
    }

    public static void printEachDirection(List<String> bridgePattern, List<String>currentInputHistory, String direction){
        StringBuffer sb = new StringBuffer();

        sb.append("[ ");
        for (int i = 0; i < currentInputHistory.size(); ++i){
            sb.append(parseHistory(bridgePattern.get(i), currentInputHistory.get(i), direction));
            sb.append(" | ");
        }

        int sbLastIndex = sb.length()-1;
        sb.delete(sbLastIndex-2,sbLastIndex);
        sb.append("]");
        System.out.println(sb);
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridgePattern, List<String>currentInputHistory) {
        printEachDirection(bridgePattern, currentInputHistory, "U");
        printEachDirection(bridgePattern, currentInputHistory, "D");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridgePattern, List<String>currentInputHistory, String successOrNot, int retryCount) {

    }
}
