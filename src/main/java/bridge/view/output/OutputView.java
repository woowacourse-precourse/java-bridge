package bridge.view.output;

import bridge.constant.Constants;
import bridge.dto.BridgeGameDto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView extends OutputViewText {

    private BridgeGameDto dto;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGameDto dto) {
        this.dto = dto;
        printRoad(Constants.UP);
        printRoad(Constants.DOWN);
    }

    private void printRoad(String road) {
        List<String> route = dto.getRoute();
        String output = IntStream.range(0, route.size())
                .mapToObj(index -> getSign(index, road))
                .collect(Collectors.joining(BRIDGE_DELIMITER, BRIDGE_PREFIX, BRIDGE_SUFFIX));
        print(output);
    }

    private String getSign(int index, String road) {
        if (!dto.getRoute().get(index).equals(road)) {
            return NOTHING;
        }
        if (dto.getBridge().get(index).equals(road)) {
            return MOVE_CORRECT;
        }
        return MOVE_WRONG;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameDto dto) {
        print(FINAL_GAME_RESULT);
        printMap(dto);
        print(SUCCESS_OR_NOT + getSuccessInfo(dto));
        print(COUNT_OF_TRY + dto.getCountOfTry());
    }

    private String getSuccessInfo(BridgeGameDto dto) {
        if (dto.isSuccess()) {
            return SUCCESS;
        }
        return FAIL;
    }

    public void printStartGame() {
        print(START_GAME);
    }

    private void print(String string) {
        System.out.println(string);
    }
}
