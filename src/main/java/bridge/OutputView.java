package bridge;

import java.util.List;
import java.util.ArrayList;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String CORRECT = "O";
    private static final String WRONG = "X";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        List<String> answer = getAnswer(Application.bridge, BridgeGame.playerStep);
        printBridge(answer, BridgeGame.playerStep);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        printFinalGame();
        System.out.println();
        printGameSuccessOrFail();
        printGameTryCount();
    }

    private void printFinalGame(){
        System.out.println(Message.GAME_FINAL_RESULT);
        List<String> answer = getAnswer(Application.bridge, BridgeGame.playerStep);
        printBridge(answer, BridgeGame.playerStep);
    }

    private void printGameTryCount() {
        String str = String.format(Message.TOTAL_TRY_COUNT, Application.tryCount);
        System.out.println(str);
    }

    private void printGameSuccessOrFail() {
        System.out.println(GameResult());
    }

    private String GameResult() {
        if(Application.stepCorrect)
            return Message.GAME_SUCCESS;

        return Message.GAME_FAIL;
    }


    private List<String> getAnswer(List<String> bridge, List<String> step){
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < step.size(); i++){
            answer.add(compareStair(bridge.get(i), step.get(i)));
        }

        return answer;
    }

    private void printBridge(List<String> answer, List<String> step){
        System.out.println(Step.U.toStringStair(answer, step));
        System.out.println(Step.D.toStringStair(answer, step));
    }

    private String compareStair(String bridge, String move){
        if(bridge.equals(move))
            return CORRECT;

        return WRONG;
    }

    public static void printError(String errorMessage){
        System.out.println(Message.ERROR + errorMessage);
    }
}
