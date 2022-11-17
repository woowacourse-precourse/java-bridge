package bridge.UI;

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
    public void printMap(List<String> getAlreadyCrossedBridge) {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isGameSuccess, int gameCount) {
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
    public void printRequestStartAgain(){

    }
}
