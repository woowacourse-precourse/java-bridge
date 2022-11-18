package bridge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final HashMap<String, Integer> direction_to_index = new HashMap<>();
    private final List<List<String>> round_result;
    private int game_round = 0;

    public BridgeGame(List<String> bridge_scaffold) {
        direction_to_index.put("D", 1);
        direction_to_index.put("U", 0);
        round_result = makeRoundResult(bridge_scaffold);
    }

    private List<List<String>> makeRoundResult(List<String> bridge_scaffold) {
        List<List<String>> round_result = new ArrayList<>();
        round_result.add(new ArrayList<>(Collections.nCopies(bridge_scaffold.size(), " ")));
        round_result.add(new ArrayList<>(Collections.nCopies(bridge_scaffold.size(), " ")));

        for (int i = 0; i < bridge_scaffold.size(); i++) {
            int result_index = direction_to_index.get(bridge_scaffold.get(i));
            round_result.get(result_index).set(i,"O");
        }
        return round_result;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        boolean is_survive = checkSurvive(direction);

        System.out.println(is_survive);
//        printResult(is_survive);
        this.game_round++;

        return is_survive;
    }

    private boolean checkSurvive(String direction) {
        return "O".equals(round_result.get(direction_to_index.get(direction)).get(this.game_round));
    }

    private void printResult(boolean is_survive) {
//        for (int i = 0; i < game_turn; i++) {
//            this.round_result.get(i);
//        }
//        if(is_survive){
//
//        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        game_round = 0;
    }
}
