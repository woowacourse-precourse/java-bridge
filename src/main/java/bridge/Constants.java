package bridge;

public class Constants {
    public enum MapMark {
        CORRECT("O"),
        WRONG("X"),
        NOTHING(" ");

        private final String letter;

        MapMark(String letter) { this.letter = letter; }
        public String mark() { return letter; }
    }

    public enum MoveMark {
        UP("U"),
        DOWN("D");

        private final String letter;

        MoveMark(String letter) { this.letter = letter; }
        public String mark() { return letter; }
    }

    public enum CommandMark {
        RETRY("R"),
        QUIT("Q");

        private final String letter;

        CommandMark(String letter) { this.letter = letter; }
        public String mark() { return letter; }
    }
}
