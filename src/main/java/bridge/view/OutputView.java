package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.domain.Tile;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String FINISH_GAME_INFO_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_OR_NOT_MESSAGE_FORMAT = "게임 성공 여부: %s";
    private static final String GAME_TRY_COUNT_MESSAGE_FORMAT = "총 시도한 횟수: %d";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";

    private static final String BRIDGE_START_SIGN = "[";
    private static final String BRIDGE_END_SIGN = "]\n";
    private static final String BRIDGE_DIVIDE_SIGN = "|";


    /**
     * 게임 시작 안내메시지를 출력한다.
     */
    public void printGameStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    /**
     * 줄바꿈을 위해 공백라인을 출력한다.
     */
    public void printEmptyLine() {
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param bridgeGame 결과를 출력할 게임 입력
     * @param player     결과를 출력할 사용자 입력
     */
    public void printMap(BridgeGame bridgeGame, Player player) {
        StringBuilder totalMapBuilder = new StringBuilder();

        for (Tile tile : Tile.values()) {
            totalMapBuilder.append(generateTileMap(tile, bridgeGame, player));
        }

        System.out.println(totalMapBuilder.toString());
    }

    private StringBuilder generateTileMap(Tile baseTile, BridgeGame bridgeGame, Player player) {
        StringBuilder mapBuilder = new StringBuilder(BRIDGE_START_SIGN);
        for(int position = 0; player.isPassedPosition(position); position++){
            Tile passedTile = player.getPassedTileLogOf(position);
            mapBuilder.append(baseTile.toMapString(passedTile, bridgeGame.checkBridgeTileAt(position, passedTile)));
            mapBuilder.append(BRIDGE_DIVIDE_SIGN);
        }

        return mapBuilder.replace(mapBuilder.length() - 1, mapBuilder.length(), BRIDGE_END_SIGN);
    }

    /**
     * "최종 게임 결과"
     * 메시지 출력
     */
    public void printFinishGameInfoMessage() {
        System.out.println(FINISH_GAME_INFO_MESSAGE);
    }

    /**
     * 게임의 최종 성공 여부와 시도 횟수를 출력
     *
     * @param isWin          성공시 true, 실패시 false 입력
     * @param playerTryCount 총 시도 횟수 입력
     */
    public void printResult(boolean isWin, int playerTryCount) {
        System.out.println(getSuccessOrNotMessage(isWin));
        System.out.println(String.format(GAME_TRY_COUNT_MESSAGE_FORMAT, playerTryCount));
    }

    private String getSuccessOrNotMessage(boolean isWin) {
        if (isWin) {
            return String.format(GAME_SUCCESS_OR_NOT_MESSAGE_FORMAT, SUCCESS_MESSAGE);
        }
        return String.format(GAME_SUCCESS_OR_NOT_MESSAGE_FORMAT, FAIL_MESSAGE);
    }
}
