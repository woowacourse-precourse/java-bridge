package bridge.view;

import bridge.controller.BridgeGame;
import bridge.domain.User;

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
    public void printMap(User user) {
        System.out.println(printBridge(user.getMapUpperBridge()));
        System.out.println(printBridge(user.getMapLowerBridge()));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, User user) {
        System.out.println("최종 게임 결과");
        System.out.println(printBridge(user.getMapUpperBridge()));
        System.out.println(printBridge(user.getMapLowerBridge()));
        System.out.println();

        System.out.print("게임 성공 여부: ");
        if(isSuccess)
            System.out.println("성공");
        if(!isSuccess)
            System.out.println("실패");

        System.out.println("총 시도한 횟수: " +user.getTryCount());
    }

    private String printBridge(List<String> bridge){
        String printWord = "[ ";
        for(int i=0; i<bridge.size(); i++) {
            printWord += bridge.get(i);
            if (i != bridge.size() - 1)
                System.out.print(" | ");
        }

        return printWord + " ]";
    }
}
