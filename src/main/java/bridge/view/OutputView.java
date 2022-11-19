package bridge.view;

import bridge.dto.BridgeRouteDto;
import bridge.dto.ResultDto;
import bridge.type.Direction;
import bridge.type.GuideMessage;
import bridge.type.MapType;

import java.util.ArrayList;
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
    public void printMap(BridgeRouteDto bridgeRouteDto) {
        List<String> resultMap = makeResultMap(bridgeRouteDto.getBridge(), bridgeRouteDto.getMovingHistory());
        StringBuilder top = new StringBuilder();
        StringBuilder bottom = new StringBuilder();
        makeTopResultMap(top, resultMap);
        makeBottomResultMap(bottom, resultMap);
        System.out.println(top);
        System.out.println(bottom);
        System.out.println();
    }

    private void makeTopResultMap(StringBuilder top, List<String> resultMap) {
        top.append(MapType.START.getSign());
        for (int i=0; i<resultMap.size(); i++) {
            String result = resultMap.get(i);
            addEachResultForTop(result, top);
            if (i != resultMap.size()-1) {
                top.append(MapType.SEPARATOR.getSign());
            }
        }
        top.append(MapType.END.getSign());
    }

    private void addEachResultForTop(String result, StringBuilder top) {
        if (result.equals("UO")) {
            top.append("O");
            return;
        }
        if (result.equals("UX")) {
            top.append("X");
            return;
        }
        top.append(" ");
    }

    private void makeBottomResultMap(StringBuilder bottom, List<String> resultMap) {
        bottom.append(MapType.START.getSign());
        for (int i=0; i<resultMap.size(); i++) {
            String result = resultMap.get(i);
            addEachResultForBottom(result, bottom);
            if (i != resultMap.size()-1) {
                bottom.append(MapType.SEPARATOR.getSign());
            }
        }
        bottom.append(MapType.END.getSign());

    }

    private void addEachResultForBottom(String result, StringBuilder bottom) {
        if (result.equals("DO")) {
            bottom.append("O");
            return;
        }
        if (result.equals("DX")) {
            bottom.append("X");
            return;
        }
        bottom.append(" ");
    }


    private List<String> makeResultMap(List<String> bridge, List<String> movingHistory) {
        List<String> resultMap = new ArrayList<>();
        for (int i=0; i<movingHistory.size(); i++) {
            if (movingHistory.get(i).equals(Direction.UP.getLetter())) {
                makeUpDirection(bridge.get(i), resultMap);
                continue;
            }
            makeBottomDirection(bridge.get(i), resultMap);
        }
        return resultMap;
    }

    private void makeBottomDirection(String answer, List<String> resultMap) {
        if (answer.equals(Direction.DOWN.getLetter())) {
            resultMap.add("DO");
            return;
        }
        resultMap.add("DX");
    }

    private void makeUpDirection(String answer, List<String> resultMap) {
        if (answer.equals(Direction.UP.getLetter())) {
            resultMap.add("UO");
            return;
        }
        resultMap.add("UX");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(ResultDto resultDto) {
        System.out.println(GuideMessage.GAME_RESULT.getMessage());
        printMap(resultDto.getCurrentPositionDto());
        printGameStatus(resultDto.getIsComplete());
        System.out.println(GuideMessage.TRY_COUNT.getMessage() + resultDto.getTryCount());
    }

    private void printGameStatus(boolean isComplete) {
        if (isComplete) {
            System.out.println(GuideMessage.GAME_SUCCESS.getMessage());
            return;
        }
        System.out.println(GuideMessage.GAME_FAIL.getMessage());
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printGreetingMessage() {
        System.out.println(GuideMessage.BRIDGE_GAME_START.getMessage());
        System.out.println();
    }
}
