package view;

import model.GameResult;
import model.MovingResult;

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
    public void printMap(MovingResult movingResult) {
        printUpMap(movingResult);
        System.out.println("");
        printDownMap(movingResult);
        System.out.println("");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult gameResult, MovingResult movingResult) {
        System.out.println(GameMessage.TOTAL_MESSAGE.getGameMessage());
        printMap(movingResult);
        System.out.println(GameMessage.SUCCESS_MESSAGE.getGameMessage() + gameResult.isSuccess());
        System.out.println(GameMessage.TRY_MESSAGE.getGameMessage() + gameResult.getRetry());
    }

    private void printUpMap(MovingResult movingResult) {
        System.out.print("[ ");
        for (int i = 0; i < movingResult.sizeUpResult(); i++) {
            System.out.print(movingResult.upResultAt(i));
            if (movingResult.sizeUpResult() > 1 && i < movingResult.sizeUpResult() - 1)
                System.out.print(" | ");
        }
        System.out.print(" ]");
    }

    private void printDownMap(MovingResult movingResult) {
        System.out.print("[ ");
        for (int i = 0; i < movingResult.sizeDownResult(); i++) {
            System.out.print(movingResult.downResultAt(i));
            if (movingResult.sizeDownResult() > 1 && i < movingResult.sizeDownResult() - 1)
                System.out.print(" | ");
        }
        System.out.print(" ]");
    }
}
