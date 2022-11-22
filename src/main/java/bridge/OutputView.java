package bridge;

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
    public void printMap(BridgeGame game) {
        List<Direction> bridgeMap = game.getBridgeMap();
        List<Direction> track = game.getTrack();
        List<String> outputMap = makeOutputMap(bridgeMap, track);
        printOutputMap(outputMap);
    }


    private List<String> makeOutputMap(List<Direction> bridgeMap, List<Direction> track) {
        List<String> outputMap = new ArrayList<>();
        initMapToPrint(outputMap);
        for (int i = 0; i < track.size(); i++) {
            fillOutputMap(outputMap, bridgeMap.get(i), track.get(i));
            if (i < track.size() - 1) {
                addSplitterToMap(outputMap);
            }
        }
        completeMapToPrint(outputMap);
        return outputMap;
    }

    private void initMapToPrint(List<String> mapToPrint) {
        mapToPrint.add("");
        mapToPrint.add("");
        mapToPrint.set(0, "[ ");
        mapToPrint.set(1, "[ ");
    }


    private void fillOutputMap(List<String> outputMap, Direction whichDirectionIsSafe,
        Direction trackDirection) {
        if (trackDirection == Direction.UP && whichDirectionIsSafe == Direction.UP) {
            fillMapIfUserShouldGoUpAndSuccess(outputMap);
        } else if (trackDirection == Direction.UP && whichDirectionIsSafe == Direction.DOWN) {
            fillMapIfUserShouldGoDownButFail(outputMap);
        } else if (trackDirection == Direction.DOWN && whichDirectionIsSafe == Direction.DOWN) {
            fillMapIfUserShouldGoDownAndSuccess(outputMap);
        } else if (trackDirection == Direction.DOWN && whichDirectionIsSafe == Direction.UP) {
            fillMapIfUserShouldGoUpButFail(outputMap);
        }
    }

    private void fillMapIfUserShouldGoUpAndSuccess(List<String> mapToPrint) {
        mapToPrint.set(0, mapToPrint.get(0) + "O");
        mapToPrint.set(1, mapToPrint.get(1) + " ");
    }

    private void fillMapIfUserShouldGoDownAndSuccess(List<String> mapToPrint) {
        mapToPrint.set(0, mapToPrint.get(0) + " ");
        mapToPrint.set(1, mapToPrint.get(1) + "O");
    }

    private void fillMapIfUserShouldGoDownButFail(List<String> mapToPrint) {
        mapToPrint.set(0, mapToPrint.get(0) + "X");
        mapToPrint.set(1, mapToPrint.get(1) + "O");
    }

    private void fillMapIfUserShouldGoUpButFail(List<String> mapToPrint) {
        mapToPrint.set(0, mapToPrint.get(0) + "O");
        mapToPrint.set(1, mapToPrint.get(1) + "X");
    }

    private void addSplitterToMap(List<String> mapToPrint) {
        mapToPrint.set(0, mapToPrint.get(0) + " | ");
        mapToPrint.set(1, mapToPrint.get(1) + " | ");
    }

    private void completeMapToPrint(List<String> mapToPrint) {
        mapToPrint.set(0, mapToPrint.get(0) + " ]");
        mapToPrint.set(1, mapToPrint.get(1) + " ]");
    }

    private void printOutputMap(List<String> outputMap) {
        for (String row : outputMap) {
            System.out.println(row);
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        if (game.getGameResult() == GameResult.USER_WIN) {
            System.out.println("게임 성공 여부: 성공");
        } else if (game.getGameResult() == GameResult.USER_LOSE) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.printf("총 시도한 횟수: %d\n", game.getTryCount());
    }

    public void printGameStartLine() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
