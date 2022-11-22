package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final String IS_SUCCESSFUL = "게임 성공 여부: ";
    static final String SUCCESS = "성공";
    static final String FAIL = "실패";
    static final String TOTAL_TRIES = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridgePattern) {
        for(List<String> row : bridgePattern){
            System.out.println(rowFormat(row));
        }
    }

    private String rowFormat(List<String> row) {
        String join = String.join(" | ", row);
        return "[ " + join + " ]";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStart(){
        System.out.println(Messages.START_MESSAGE);
    }
    public void printInputBridgeSize(){
        System.out.println(Messages.INPUT_BRIDGE_MESSAGE);
    }
    public void printInputMove(){
        System.out.println(Messages.INPUT_MOVE_MESSAGE);
    }
    public void printInputCommand(){
        System.out.println(Messages.RETRY_MESSAGE);
    }
    private void printSuccess(boolean isSuccess) {
        System.out.print(IS_SUCCESSFUL);
        if (isSuccess) {
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(FAIL);
    }
    private void printTries(int tries) {
        System.out.print(TOTAL_TRIES);
        System.out.println(tries);
    }
}
