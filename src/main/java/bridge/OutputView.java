package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private int maxBridge = -1;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final BridgeGame game) {
        System.out.println(game);
        maxBridge = Math.max(maxBridge, game.getCurrentBridge());
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        addMap(game, PropertyMove.UP, builder);
        builder.append("[");
        addMap(game, PropertyMove.DOWN, builder);
        System.out.println(builder);
    }

    private void addMap(final BridgeGame game, final PropertyMove move,
        final StringBuilder builder) {
        if (game.isGameOver()) {
            addMapGameOverUntilCurrentBridge(game, move, builder);
            addMapGameOverCurrentBridge(game, move, builder);
            return;
        }
        addMapNotGameOverUntilCurrentBridge(game, move, builder);
        addMapNotGameOverCurrentBridge(game, move, builder);
    }

    private void addMapGameOverCurrentBridge(final BridgeGame game, final PropertyMove move,
        final StringBuilder builder) {
        if (game.getBridge().get(game.getCurrentBridge() + 1).equals(move.getValue())) {
            builder.append("   ]\n");
            return;
        }
        builder.append(" X ]\n");
    }

    private void addMapGameOverUntilCurrentBridge(final BridgeGame game, final PropertyMove move,
        final StringBuilder builder) {
        for (int i = 0; i <= game.getCurrentBridge(); i++) {
            if (game.getBridge().get(i).equals(move.getValue())) {
                builder.append(" O |");
                continue;
            }
            builder.append("   |");
        }
    }

    private void addMapNotGameOverUntilCurrentBridge(final BridgeGame game, final PropertyMove move,
        final StringBuilder builder) {
        for (int i = 0; i < game.getCurrentBridge(); i++) {
            if (game.getBridge().get(i).equals(move.getValue())) {
                builder.append(" O |");
                continue;
            }
            builder.append("   |");
        }
    }

    private void addMapNotGameOverCurrentBridge(final BridgeGame game, final PropertyMove move,
        final StringBuilder builder) {
        if (game.getBridge().get(game.getCurrentBridge()).equals(move.getValue())) {
            builder.append(" O ]\n");
            return;
        }
        builder.append("   ]\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final BridgeGame game) {
        System.out.println("최종 게임 결과");
        if (game.isSuccessEndGame()) {
            printMap(game);
            printIsSuccessAndCountPlayGame(game);
            return;
        }
        printResultGameOver(game);
        printIsSuccessAndCountPlayGame(game);
    }

    private void printResultGameOver(final BridgeGame game) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        addMapGameOverUntilMaxBridge(game, PropertyMove.UP, builder);
        addMapGameOverMaxBridge(game, PropertyMove.UP, builder);
        builder.append("[");
        addMapGameOverUntilMaxBridge(game, PropertyMove.DOWN, builder);
        addMapGameOverMaxBridge(game, PropertyMove.DOWN, builder);
        System.out.println(builder);
    }

    private void addMapGameOverUntilMaxBridge(final BridgeGame game, final PropertyMove move,
        final StringBuilder builder) {
        for (int i = 0; i <= maxBridge; i++) {
            if (game.getBridge().get(i).equals(move.getValue())) {
                builder.append(" O |");
                continue;
            }
            builder.append("   |");
        }
    }

    private void addMapGameOverMaxBridge(final BridgeGame game, final PropertyMove move,
        final StringBuilder builder) {
        if (game.getBridge().get(maxBridge + 1).equals(move.getValue())) {
            builder.append("   ]\n");
            return;
        }
        builder.append(" X ]\n");
    }

    private void printIsSuccessAndCountPlayGame(BridgeGame game) {
        System.out.println("게임 성공 여부: " + getIsSuccessGame(game.isSuccessEndGame()));
        System.out.println("총 시도한 횟수: " + game.getCountPlayGame());
    }

    private String getIsSuccessGame(boolean isSuccessEndGame) {
        if (isSuccessEndGame) {
            return "성공";
        }
        return "실패";
    }

}
