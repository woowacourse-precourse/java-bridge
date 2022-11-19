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

    public void printGameStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param bridgeGame 결과를 출력할 게임 입력
     * @param player     결과를 출력할 사용자 입력
     */
    public void printMap(BridgeGame bridgeGame, Player player) {
        StringBuilder totalBridgeMapBuilder = new StringBuilder();

        for (Tile tile : Tile.values()) {
            totalBridgeMapBuilder.append(generateTileMap(tile, bridgeGame, player));
        }

        System.out.println(totalBridgeMapBuilder.toString());
    }

    private String generateTileMap(Tile tile, BridgeGame bridgeGame, Player player) {
        StringBuilder bridgeMapBuilder = new StringBuilder(BRIDGE_START_SIGN);
        int index = 0;
        while (player.isPassedPosition(index)) {
            Tile playerTile = player.getMovingLogOf(index);
            bridgeMapBuilder.append(tile.toFormatString(playerTile, bridgeGame.checkBridgeTileAt(index++, playerTile)));
            bridgeMapBuilder.append(BRIDGE_DIVIDE_SIGN);
        }
        bridgeMapBuilder.replace(bridgeMapBuilder.length() - 1, bridgeMapBuilder.length(), BRIDGE_END_SIGN);

        return bridgeMapBuilder.toString();
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
