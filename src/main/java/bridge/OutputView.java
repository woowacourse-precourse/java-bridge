package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OutputView {
    public List<String> upSide = new ArrayList<>();
    public List<String> downSide = new ArrayList<>();

    private void setMap1(String input) {
        if (Objects.equals(input, "U")) {
            upSide.add("X");
            downSide.add(" ");
        }
        if (Objects.equals(input, "D")) {
            upSide.add(" ");
            downSide.add("X");
        }
    }

    private void setMap2(String input) {
        if (Objects.equals(input, "U")) {
            upSide.add("O");
            downSide.add(" ");
        }
        if (Objects.equals(input, "D")) {
            upSide.add(" ");
            downSide.add("O");
        }
    }

    public void setResult (String input , BridgeGame bridgeGame){

    }
    public void printMap(String input , BridgeGame bridgeGame) {
        if (bridgeGame.inputResult) setMap2(input);
        if (!bridgeGame.inputResult) setMap1(input);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
