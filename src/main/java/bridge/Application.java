package bridge;

public class Application {

    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(
        new BridgeRandomNumberGenerator()
    );

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다");
        BridgeGame game = makeGame();
        playGames(game);
        output.printResult();
    }

    private static BridgeGame makeGame() {
        while (true) {
            try {
                int size = input.readBridgeSize();
                return new BridgeGame(bridgeMaker.makeBridge(size));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 다리 크기는 3이상 20이하이어야 합니다.");
            }
        }
    }

    private static void playGames(final BridgeGame game) {
        while (!game.isSuccessEndGame()) {
            playGame(game);
            if (game.isSuccessEndGame() || !checkRetry(game)) {
                break;
            }
        }
    }

    private static void playGame(final BridgeGame game) {
        boolean resultMoving = true;
        while (resultMoving && !game.isSuccessEndGame()) {
            String line = input.readMoving();
            PropertyMove moving = convertPropertyMoveByLine(line);
            resultMoving = game.move(moving);
            output.printMap(game);
        }
    }

    private static PropertyMove convertPropertyMoveByLine(String line) {
        if (line.equals("U")) {
            return PropertyMove.UP;
        }
        if (line.equals("D")) {
            return PropertyMove.DOWN;
        }
        throw new IllegalStateException();
    }

    private static boolean checkRetry(BridgeGame game) {
        String command = input.readGameCommand();
        if (command.equals("Q")) {
            return false;
        }
        game.retry();
        return true;
    }
}
