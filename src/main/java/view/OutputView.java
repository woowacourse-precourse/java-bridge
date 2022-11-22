package view;

import java.util.List;

import static message.GameMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridgeMap) {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < bridgeMap.get(0).size(); j++) {
                System.out.print(bridgeMap.get(i).get(j));
            }
            System.out.println(" ]");
        }
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> bridgeMap, int totalTry, boolean isSuccess) {
        System.out.println(Result.getMessage());
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < bridgeMap.get(0).size(); j++) {
                System.out.print(bridgeMap.get(i).get(j));
            }
            System.out.println(" ]");
        }
        printSuccess(isSuccess);
        System.out.println(Total_Try.getMessage() + totalTry);
    }

    public void printSuccess(boolean isSuccess) {
        if(isSuccess) {
            System.out.println(Success.getMessage() + "성공");
            return;
        }
        System.out.println(Success.getMessage() + "실패");
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
