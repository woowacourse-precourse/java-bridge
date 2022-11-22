package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    
    private String firstLayer; // 다리의 모습 중, 윗 부분
    private String secondLayer; // 다리의 모습 중, 아래 부분

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<String> bridge, int currentStep, boolean die) {
        refreshLayers();
        makeFirstLayer(bridge, currentStep);
        makeSecondLayer(bridge, currentStep);

        if(die) {
            return makeLastDieLayer(bridge, currentStep);
        }

        return makeLastLayer(bridge, currentStep);
    }

    /**
     * 사용자가 죽지 않았을 시, 마지막 다리의 모습을 그려주는 메서드
     */
    private String makeLastLayer(List<String> bridge, int currentStep) {
        if(bridge.get(currentStep - 1).equals("U")) {
            firstLayer += " O ]";
            secondLayer += "   ]";
            return firstLayer + "\n" + secondLayer +"\n";
        }

        firstLayer += "   ]";
        secondLayer += " O ]";
        return firstLayer + "\n" + secondLayer +"\n";
    }

    /**
     * 사용자가 죽었을 시, 마지막 다리의 모습을 그려주는 메서드
     */
    private String makeLastDieLayer(List<String> bridge, int currentStep) {
        if(bridge.get(currentStep - 1).equals("U")) {
            firstLayer += "   ]";
            secondLayer += " X ]";
            return firstLayer + "\n" + secondLayer + "\n";
        }

        firstLayer += " X ]";
        secondLayer += "   ]";
        return firstLayer + "\n" + secondLayer + "\n";
    }

    /**
     * 사용자가 건너온 다리의 모습 중, 맨 윗 라인을 그려주는 메서드
     */
    private void makeFirstLayer(List<String> bridge, int currentStep) {
        for(int i = 0; i < currentStep - 1; i++) {
            if(bridge.get(i).equals("U")) {
                firstLayer += " O |";
                continue;
            }
            firstLayer += "   |";
        }
    }

    /**
     * 사용자가 건너온 다리의 모습 중, 맨 아래 라인을 그려주는 메서드
     */
    private void makeSecondLayer(List<String> bridge, int currentStep) {
        for(int i = 0; i < currentStep - 1; i++) {
            if(bridge.get(i).equals("U")) {
                secondLayer += "   |";
                continue;
            }
            secondLayer += " O |";
        }
    }

    /**
     * 사용자가 건너온 다리의 모습을 초기화시키는 메서드
     */
    private void refreshLayers() {
        this.firstLayer = "[";
        this.secondLayer = "[";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, int currentStep, boolean die) {
        System.out.println("최종 게임 결과");
        printMap(bridge, currentStep, die);

        if(die) {
            System.out.println("게임 성공 여부: 실패");
            return;
        }

        System.out.println("게임 성공 여부: 성공");
    }

}
