package model;

import bridge.BridgeDirect;
import bridge.BridgeStatus;
import java.util.ArrayList;
import java.util.List;
import util.ErrorMessage;

public class User {
    public static final String COMMAND_RETRY = "R";
    public static final String COMMAND_QUIT = "Q";

    private List<UserProgress> userProgresses;
    private UserStatus userStatus;
    private int retryCount;
    private String command;

    public User() {
        userProgresses = new ArrayList<>();
        userStatus = UserStatus.PLAYING_STATUS;
        retryCount=1;
        command=null;
    }

    public void updateStatus(UserStatus userStatus){
        this.userStatus = userStatus;
    }

    public static void validateUserInput(String userInput) {
        if (!isCorrectInput(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.STAIRS_U_OR_D);
        }
    }

    private static boolean isCorrectInput(String userInput) {
        if (userInput.equals(BridgeDirect.UP.getDirection()) || userInput.equals(BridgeDirect.DOWN.getDirection())) {
            return true;
        }
        return false;
    }

    public void updateUsersProgress(BridgeDirect userInput, BridgeStatus userStatus) {
        this.userProgresses.add(new UserProgress(userInput, userStatus));
    }


    public List<UserProgress> getUserProgress() {
        return userProgresses;
    }

    public UserStatus getStatus() {
        return userStatus;
    }

    public void setRetry() {
        reset();
        retryCount++;
        command = null;
    }

    private void reset() {
        userProgresses = new ArrayList<>();
        userStatus = UserStatus.PLAYING_STATUS;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void updateCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
