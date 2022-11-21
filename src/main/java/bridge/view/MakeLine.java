package bridge.view;

import bridge.model.BridgeGame;

public class MakeLine {

    public String makeLine(BridgeGame game, String type) {
        String line = PrintSentence.LEFT_WALL.getSentence();
        for (int i = 0; i < game.getNowPosition() + 1; i++) {
            line += checkUpOrNot(game, i, type);
            line += checkLast(game, i);
        }
        line += PrintSentence.RIGHT_WALL.getSentence();
        return line;
    }
    private String checkUpOrNot(BridgeGame game, int index, String type) {
        String line = "";
        if (game.getBridge().get(index).equals(LineType.valueOf(type).getValue1())) {
            line += LineType.valueOf(type).getValue3();
        }
        if (game.getBridge().get(index).equals(LineType.valueOf(type).getValue2())) {
            line += " ";
        }
        return line;
    }
    private String checkLast(BridgeGame game, int index) {
        if (index < game.getNowPosition()) {
            return PrintSentence.MIDDLE_WALL.getSentence();
        }
        return "";
    }

    public String makeLineIncorrect(BridgeGame game, String type) {
        String line = PrintSentence.LEFT_WALL.getSentence();
        for (int i = 0; i < game.getNowPosition(); i++) {
            line += checkUpOrNot(game, i, type);
            line += checkLast(game, i);
        }
        line += makeLineIncorrectLastValue(game, type);
        line += PrintSentence.RIGHT_WALL.getSentence();
        return line;
    }

    public String makeLineIncorrectLastValue(BridgeGame game, String type) {
        if (type.equals("UP")) {
            return checkUpOrNot(game, game.getNowPosition(), "UP_FAIL");
        }
        return checkUpOrNot(game, game.getNowPosition(), "DOWN_FAIL");
    }
}
