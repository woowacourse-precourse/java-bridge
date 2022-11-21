package bridge;

import bridge.enums.Direction;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    // 변수명 변경 필요
    public void printMap(BridgeGame bridgeGame) {
        List<Guess> guesses = bridgeGame.getGuess();
        List<List<String>> parsedResult = getParsedResult(guesses);

        for (int i = parsedResult.size() - 1; i > -1; i--) {
            System.out.println("[" + String.join("|", parsedResult.get(i)) + "]");
        }
        System.out.println();
    }

    private List<List<String>> getParsedResult(List<Guess> guesses) {
        List<List<String>> layers = init();

        for (Guess guess : guesses) {
            Integer code = Direction.getCodeByAbbr(guess.getGuess());
            for (int i = 0; i < Direction.values().length; i++) {
                if (i == code) {
                    layers.get(i).add(" " + guess.getResult() + " ");
                } else {
                    layers.get(i).add("   ");
                }
            }
        }

        return layers;
    }

    private List<List<String>> init() {
        List<List<String>> layers = new ArrayList<>();

        for (int i = 0; i < Direction.values().length; i++) {
            layers.add(new ArrayList<>());
        }

        return layers;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
