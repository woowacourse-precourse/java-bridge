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
    public boolean printMap(List<String> passBridge, String moveInput) {
        boolean checkTryUp = printMapUpAndDown(passBridge, moveInput, "U");
        boolean checkTryDown = printMapUpAndDown(passBridge, moveInput, "D");
        if(!checkTryUp || !checkTryDown)
            return false;
        return  true;
    }

    public boolean printMapUpAndDown(List<String> passBridge, String moveInput, String upAndDown) {
        boolean tryGame = true;
        printMapLine(passBridge, upAndDown);
        if(moveInput.equals(upAndDown))
            tryGame = printMapLastLocation(passBridge, moveInput);
        if(!moveInput.equals(upAndDown))
            System.out.println("   ]");
        return tryGame;
    }

    public void printMapLine(List<String> passBridge, String upAndDown) {
        System.out.print("[");
        for(int i = 0; i < passBridge.size() - 1; i++) {
            if(passBridge.get(i).equals(upAndDown))
                System.out.print(" O |");
            if(!passBridge.get(i).equals(upAndDown))
                System.out.print("   |");
        }
    }

    public boolean printMapLastLocation(List<String> passBridge, String moveInput) {
        if(passBridge.get(passBridge.size() - 1).equals(moveInput)) {
            System.out.println(" O ]");
            return true;
        }
        System.out.println(" X ]");
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> passBridge, String moveInput) {
        System.out.println("최종 게임 결과");
        printMap(passBridge, moveInput);
    }
}
