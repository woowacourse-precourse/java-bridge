package bridge;

import java.util.List;

import static bridge.utils.constant.Phrase.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printGameStart() {
        System.out.println(PHRASE_START_GAME.getPhrase());
    }
    public void printBridgeSize() {
        System.out.println(PHRASE_INPUT_BRIDGE_SIZE.getPhrase());
    }

    public void printMap(List<List<String>> bridges) {
        StringBuilder sb = new StringBuilder();
        for(List<String> bridge : bridges) {
            String output = bridge.toString();
            output = output.replaceAll(", ","|");
            output = output.replaceAll("", " ");
            sb.append(output).append("\n");
        }
        System.out.println(sb);
    }

    public void printWhereToMove() {
        System.out.println(PHRASE_WHERE_TO_MOVE.getPhrase());
    }

    public void askRestartGame() {
        System.out.println(PHRASE_RESTART_THE_GAME.getPhrase());
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> bridges) {
        System.out.println(PHRASE_RESULT_OF_THE_GAME.getPhrase());
        printMap(bridges);
    }
    public void gameAttemptCount(String result, int attempt) {
        if(result.equals("성공")) {
            System.out.println(PHRASE_GAME_SUCCESS.getPhrase());
        }
        if(result.equals("실패")) {
            System.out.println(PHRASE_GAME_FAILED.getPhrase());
        }
        System.out.println(PHRASE_GAME_ATTEMPT.getPhrase() + attempt);
    }

}
