package bridge.view;

import bridge.domain.User;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String CORRECT = "O";
    private static final String WRONG = "X";
    private static final String SPACE = " ";
    private static final String PARTITION = " | ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BEGIN_MAP = "[ ";
    private static final String END_MAP = " ]";

    private StringBuilder firstMap = new StringBuilder();
    private StringBuilder secondMap = new StringBuilder();

    public void initMap(){
        firstMap = new StringBuilder();
        secondMap = new StringBuilder();
    }

    public void startBridgeGame(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void askBridgeSize(){
        System.out.println("다리의 길이를 입력해주세요");
    }

    public void askMovement(){
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D");
    }

    public void askDecision(){
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도:R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int blockIndex, String movement, boolean isCorrect) {
        if(blockIndex >= 1){
            firstMap.append(PARTITION);
            secondMap.append(PARTITION);
        }
        showMovement(movement, isCorrect);
        printCurrentResult();
    }

    public void showMovement(String movement, boolean isCorrect){
        if(movement.equals(UP)){
            appendFirstMap(isCorrect);
        }
        if(movement.equals(DOWN)){
            appendSecondMap(isCorrect);
        }
    }

    public void appendFirstMap(boolean isCorrect){
        if(isCorrect){
            firstMap.append(CORRECT);
        }
        if(!isCorrect){
            firstMap.append(WRONG);
        }
        secondMap.append(SPACE);
    }

    public void appendSecondMap(boolean isCorrect){
        if(isCorrect){
            secondMap.append(CORRECT);
        }
        if(!isCorrect){
            secondMap.append(WRONG);
        }
        firstMap.append(SPACE);
    }

    public void printCurrentResult(){
        System.out.println(BEGIN_MAP + firstMap + END_MAP);
        System.out.println(BEGIN_MAP + secondMap + END_MAP);
    }

    public void printResult(User user) {
        /**
         * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
         * <p>
         * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
         */
        System.out.println("최종 게임 결과");
        printCurrentResult();
        System.out.println("\n게임 성공 여부: " + getStatus(user.isSuccessful()));
        System.out.println("총 시도한 횟수: " + user.getTrial());
    }

    public String getStatus(boolean isSuccess){
        if(isSuccess){
            return "성공";
        }
        return "실패";
    }
}
