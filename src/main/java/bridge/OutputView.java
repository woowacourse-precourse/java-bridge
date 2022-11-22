package bridge;

import bridge.GameResult;
import bridge.MovingResult;

import java.util.List;


/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private List<String> bridge;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MovingResult movingResult) {
        StringBuilder upCurrent = new StringBuilder();
        StringBuilder downCurrent = new StringBuilder();

        for (String i : bridge) {
            if (movingResult.getMoving().equals("U")) {
                upCurrent.append("|").append(movingResult.getResult()).append("|");
                downCurrent.append("|").append(" ").append("|");
            }
            upCurrent.append("|").append(" ").append("|");
            downCurrent.append("|").append(movingResult.getResult()).append("|");
        }
        System.out.println("[" + upCurrent + "]");
        System.out.println("[" + downCurrent + "]");
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult, MovingResult movingResult) {
        StringBuilder totalResult = new StringBuilder();
        totalResult.append("게임 성공 여부").append(gameResult.getResult()).append(System.lineSeparator());
        totalResult.append("총 시도한 횟수").append(gameResult.getTryNumber()).append(System.lineSeparator());
        System.out.println("최종 게임 결과");
        printMap(movingResult);
        System.out.println(totalResult);


    }
}
