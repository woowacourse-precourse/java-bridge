package view;

import model.Result;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private Result result;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        printUpMap();
        System.out.println("");
        printDownMap();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }

    public void printUpMap() {
        List<Integer> upPosition = result.extractUpPosition();
        System.out.print("[ ");
        for (int i = 0; i < result.movingResultSize(); i++) {
            if (upPosition.contains(i))
                System.out.print(result.getResultAt(i));
            System.out.print("| ");
        }
        System.out.print(" ]");
    }

    public void printDownMap(){
        List<Integer> upPosition = result.extractDownPosition();
        System.out.print("[ ");
        for (int i = 0; i < result.movingResultSize(); i++) {
            if (upPosition.contains(i))
                System.out.print(result.getResultAt(i));
            System.out.print("| ");
        }
        System.out.print(" ]");
    }
}
