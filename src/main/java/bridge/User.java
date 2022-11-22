package bridge;

import ui.Block;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String BLOCK_START = "[";
    private final String BLOCK_END = "]";
    private final String BLOCK_SEP = "|";
    private List<String> userHistory;
    private List<Integer> userUpMap;
    private List<Integer> userDownMap;
    private boolean moveFinished = false;
    private boolean lastMoveSucceed = true;

    public User() {
        userHistory = new ArrayList<>();
        userUpMap = new ArrayList<>();
        userDownMap = new ArrayList<>();
    }

    private void validNoChoice() {
        if (userHistory.isEmpty()) {
            throw new IllegalArgumentException("이동을 해주세요");
        }
    }

    public void crossingBlock(String block) {
        userHistory.add(block);
    }

    public boolean isMoveFinished() {
        return moveFinished;
    }

    public boolean isMoveSucceed() {
        return lastMoveSucceed;
    }

    private int historySize() {
        validNoChoice();
        return userHistory.size();
    }

    private void drawSuccessMap() {
        if (isLastMoveUp()) {
            userUpMap.add(1);
            userDownMap.add(0);
            return;
        }
        userUpMap.add(0);
        userDownMap.add(1);
    }

    private void drawFailMap() {
        if (isLastMoveUp()) {
            userUpMap.add(-1);
            userDownMap.add(0);
            return;
        }
        userUpMap.add(0);
        userDownMap.add(-1);
    }

    private boolean isLastMoveUp() {
        return userHistory.get(historySize() - 1).equals("U");
    }

    private void updateUserStatus(Bridge gameBridge) {
        checkLastMove(gameBridge);
        checkFinished(gameBridge);
    }

    private void checkLastMove(Bridge gameBridge) {
        String userBlock = userHistory.get(historySize() - 1);
        String gameBlock = gameBridge.getBridgeComponent().get(historySize() - 1);
        lastMoveSucceed = userBlock.equals(gameBlock);
    }

    private void checkFinished(Bridge gameBridge) {
        moveFinished = (userHistory.size() == gameBridge.getBridgeLength());
    }

    public void drawMap(Bridge gameBridge) {
        updateUserStatus(gameBridge);
        if (lastMoveSucceed) {
            drawSuccessMap();
            return;
        }
        drawFailMap();
    }

    private String makeBlock(int index) {
        return " " + Block.getMessage(index) + " ";
    }

    private String makeLine(List<Integer> line) {
        String result = BLOCK_START;
        for (int i = 0; i < line.size(); i++) {
            result += makeBlock(line.get(i));
            if (i != line.size() - 1) {
                result += BLOCK_SEP;
            }
        }
        return result + BLOCK_END;
    }

    public String mapToString() {
        return makeLine(userUpMap) + "\n" + makeLine(userDownMap) + "\n";
    }
}
