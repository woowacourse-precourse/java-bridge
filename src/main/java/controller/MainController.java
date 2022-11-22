package controller;

import bridge.BridgeDirect;
import model.UserStatus;
import model.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import model.User;
import view.InputView;
import view.OutputView;

public class MainController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run(){
        startGame();

        User user = createUser();
        int bridgeSize = getBridgeSize();
        Bridge bridge = makeBridge(bridgeSize);

        playGames(user, bridge);
        printResult(user);
    }

    private User createUser() {
        return new User();
    }

    private void printResult(User user) {
        if (isGameExit(user)) {
            outputView.printResult(user);
        }
    }
    private boolean isGameExit(User user) {
        return user.getStatus().equals(UserStatus.WIN_STATUS) || user.getCommand().equals(User.COMMAND_QUIT);
    }
    private void playGames(User user, Bridge bridge) {
        oneGame(user, bridge);

        if (isEnd(user)) {
            String command = askRetry();
            user.updateCommand(command);
            retryGame(user, bridge, command);
        }
    }

    private void retryGame(User user, Bridge bridge, String command) {
        if (command.equals(User.COMMAND_RETRY)) {
            bridgeGame.retry(user);
            playGames(user, bridge);
        }
    }

    private boolean isEnd(User user){
        return user.getStatus().equals(UserStatus.END_STATUS);
    }


    private String askRetry() {
        outputView.printRetry();
        String command;
        try {
            command = inputView.readGameCommand();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return askRetry();
        }
        return command;
    }


    private void oneGame(User user, Bridge bridge) {
        do {
            oneStairsMove(bridge, user);
            outputView.printMap(user);
            UserStatus userStatus = bridgeGame.getNowStatus(bridge, user);
            user.updateStatus(userStatus);
        } while (user.getStatus().equals(UserStatus.PLAYING_STATUS));
    }

    private void oneStairsMove(Bridge bridge, User user) {
        String userOneStairs = getUserOneStairs();
        bridgeGame.move(bridge, user, BridgeDirect.valueOfDirection(userOneStairs));
    }

    private Bridge makeBridge(int bridgeSize){
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridge);
    }

    private void startGame(){
        outputView.printStartGame();
    }

    private int getBridgeSize() {
        printReceiveBridgeSize();
        int bridgeSize = receiveBridgeSize();
        return bridgeSize;
    }

    private int receiveBridgeSize() {
        int bridgeSize=-1;
        bridgeSize = validateReadBridgeSize();
        return bridgeSize;
    }

    private int validateReadBridgeSize() {
        int bridgeSize;
        try {
            bridgeSize = readBridgeSize();
            BridgeMaker.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            bridgeSize = getBridgeSize();
        }
        return bridgeSize;
    }

    private void printReceiveBridgeSize(){
        outputView.printReceiveBridgeSize();
    }

    private int readBridgeSize(){
        return inputView.readBridgeSize();
    }

    private String getUserOneStairs(){
        outputView.printSelectMove();
        String usersOneStairs = inputView.readMoving();
        String validUsersOneStairs=validUsersOneStairs(usersOneStairs);
        return validUsersOneStairs;
    }

    private String validUsersOneStairs(String usersInput) {
        try {
            inputView.validateCharacter(usersInput);
            User.validateUserInput(usersInput);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            usersInput=getUserOneStairs();
        }
        return usersInput;
    }
}
