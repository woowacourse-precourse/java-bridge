package bridge.UI;

import bridge.businesslogic.Bridge;

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
    public void printMap(List<String> getAlreadyCrossedBridge, boolean isLastPickIsRight) {
        int mapLength = getAlreadyCrossedBridge.size();
        int[][] bridgeStatus = createBridgeStatus(getAlreadyCrossedBridge);

        if(!isLastPickIsRight){
            bridgeStatus[0][mapLength] = checkAndChangeToFalse(bridgeStatus[0][mapLength]);
            bridgeStatus[1][mapLength] = checkAndChangeToFalse(bridgeStatus[1][mapLength]);
        }
        printOneLine(bridgeStatus[0]);
        printOneLine(bridgeStatus[1]);
    }

    private int[][] createBridgeStatus(List<String> getAlreadyCrossedBridge){
        int bridgeLength = getAlreadyCrossedBridge.size();
        int[][] bridgeStatus = new int[2][bridgeLength];

        for(int bridgeIndex = 0; bridgeIndex < bridgeLength; bridgeIndex++){
            setOneBridgeStatus(bridgeStatus,getAlreadyCrossedBridge.get(bridgeIndex),bridgeIndex);
        }
        return bridgeStatus;
    }

    private void setOneBridgeStatus(int[][] bridgeStatus, String userSelect,int bridgeIndex){
        boolean choiceUp = (userSelect.equals("U"));
        if(choiceUp){
            bridgeStatus[0][bridgeIndex] = 1;
            bridgeStatus[1][bridgeIndex] = 0;
            return;
        }
        bridgeStatus[0][bridgeIndex] = 0;
        bridgeStatus[1][bridgeIndex] = 1;
    }

    private int checkAndChangeToFalse(int currentStatus){
        if(currentStatus == 1){
            return 2;
        }
        return 0;
    }
    private void printOneLine(int[] oneLine){
        System.out.print("[ ");
        printInsides(oneLine);
        printLastOne(oneLine[oneLine.length-1]);
        System.out.println(" ]");
    }
    private void printInsides(int[] oneLine){
        for(int i = 0; i < oneLine.length-1; i++){
            if(oneLine[i] == 1){
                System.out.print("O");
                System.out.print(" | ");
                continue;
            }
            System.out.print(" ");
            System.out.print(" | ");
        }
    }
    private void printLastOne(int lastData){
        if(lastData == 0){
            System.out.print(" ");
        }
        if(lastData == 1){
            System.out.print("O");
        }
        if(lastData == 2){
            System.out.print("X");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge currentBridge, boolean isGameSuccess, int gameCount) {
        System.out.println("최종 게임 결과");
        printMap(currentBridge.getAlreadyCrossedBridge(),isGameSuccess);

        String gameResult = convertResult(isGameSuccess);
        System.out.printf("게임 성공 여부 : %s\n",gameResult);
        System.out.printf("총 시도한 횟수 : %d", gameCount);
    }

    private String convertResult(boolean gameResult){
        if(gameResult){
            return "성공";
        }
        return "실패";
    }

    public void printStatement(String output){
        System.out.println(output);
    }
    public void printRequestHowToMove(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRequestStartAgain(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q");
    }
}
