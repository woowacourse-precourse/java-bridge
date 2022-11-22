package bridge.service;

import java.util.List;

public enum UserInput {
    MOVING(List.of(InputLetter.MOVING_UP.getLetter(), InputLetter.MOVING_DOWN.getLetter())),
    GAME_COMMAND(List.of(InputLetter.GAME_RESTART.getLetter(), InputLetter.GAME_QUIT.getLetter()));

    private final List<String> letters;

    UserInput(List<String> letters) {
        this.letters = letters;
    }

    public List<String> getLetters() {
        return letters;
    }

    public enum InputLetter {
        MOVING_UP("U"),
        MOVING_DOWN("D"),
        GAME_RESTART("R"),
        GAME_QUIT("Q");

        private final String letter;

        InputLetter(String letter) {
            this.letter = letter;
        }

        public String getLetter() {
            return letter;
        }
    }
}
