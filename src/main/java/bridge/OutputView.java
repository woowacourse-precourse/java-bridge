package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final BridgeGame game) {
        System.out.println(game);
        StringBuilder builder = new StringBuilder();
        addMap(game, PropertyMove.UP, builder);
        addMap(game, PropertyMove.DOWN, builder);
        System.out.println(builder);
    }

    private void addMap(final BridgeGame game, final PropertyMove move,
        final StringBuilder builder) {
        builder.append("[");
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
    public void printResult() {
    }
}
