package bridge.view;

import bridge.dto.BridgeRouteDto;
import bridge.dto.ResultDto;
import bridge.type.Direction;
import bridge.type.GuideMessage;
import bridge.type.MapType;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public void printGreetingMessage() {
        System.out.println(GuideMessage.BRIDGE_GAME_START.getMessage());
        System.out.println();
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printMap(BridgeRouteDto bridgeRouteDto) {
        List<String> resultMapInfo = makeResultMapInfo(bridgeRouteDto.getBridge(), bridgeRouteDto.getMoveHistory());
        StringBuilder top = new StringBuilder();
        StringBuilder bottom = new StringBuilder();
        makeTopResultMap(top, resultMapInfo);
        makeBottomResultMap(bottom, resultMapInfo);
        System.out.println(top);
        System.out.println(bottom);
        System.out.println();
    }

    private List<String> makeResultMapInfo(List<String> bridge, List<String> movingHistory) {
        List<String> resultMapInfo = new ArrayList<>();
        for (int i=0; i<movingHistory.size(); i++) {
            if (movingHistory.get(i).equals(Direction.UP.getLetter())) {
                makeUpDirection(bridge.get(i), resultMapInfo);
                continue;
            }
            makeDownDirection(bridge.get(i), resultMapInfo);
        }
        return resultMapInfo;
    }

    private void makeUpDirection(String answer, List<String> resultMapInfo) {
        if (answer.equals(Direction.UP.getLetter())) {
            resultMapInfo.add(MapType.UP_CORRECT.getSign());
            return;
        }
        resultMapInfo.add(MapType.UP_WRONG.getSign());
    }

    private void makeDownDirection(String answer, List<String> resultMapInfo) {
        if (answer.equals(Direction.DOWN.getLetter())) {
            resultMapInfo.add(MapType.DOWN_CORRECT.getSign());
            return;
        }
        resultMapInfo.add(MapType.DOWN_WRONG.getSign());
    }

    private void makeTopResultMap(StringBuilder top, List<String> resultMapInfo) {
        top.append(MapType.START.getSign());
        for (int i=0; i<resultMapInfo.size(); i++) {
            String result = resultMapInfo.get(i);
            addEachResultForTop(result, top);
            if (i != resultMapInfo.size()-1) {
                top.append(MapType.SEPARATOR.getSign());
            }
        }
        top.append(MapType.END.getSign());
    }

    private void addEachResultForTop(String result, StringBuilder top) {
        if (result.equals(MapType.UP_CORRECT.getSign())) {
            top.append(MapType.CORRECT.getSign());
            return;
        }
        if (result.equals(MapType.UP_WRONG.getSign())) {
            top.append(MapType.WRONG.getSign());
            return;
        }
        top.append(MapType.BLANK.getSign());
    }

    private void makeBottomResultMap(StringBuilder bottom, List<String> resultMapInfo) {
        bottom.append(MapType.START.getSign());
        for (int i=0; i<resultMapInfo.size(); i++) {
            String result = resultMapInfo.get(i);
            addEachResultForBottom(result, bottom);
            if (i != resultMapInfo.size()-1) {
                bottom.append(MapType.SEPARATOR.getSign());
            }
        }
        bottom.append(MapType.END.getSign());
    }

    private void addEachResultForBottom(String result, StringBuilder bottom) {
        if (result.equals(MapType.DOWN_CORRECT.getSign())) {
            bottom.append(MapType.CORRECT.getSign());
            return;
        }
        if (result.equals(MapType.DOWN_WRONG.getSign())) {
            bottom.append(MapType.WRONG.getSign());
            return;
        }
        bottom.append(MapType.BLANK.getSign());
    }

    public void printResult(ResultDto resultDto) {
        System.out.println(GuideMessage.GAME_RESULT.getMessage());
        printMap(resultDto.getBridgeRouteDto());
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
}
