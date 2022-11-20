package bridge;

public class Constants {
    public enum MapMark {
        CORRECT("O"),
        WRONG("X"),
        NOTHING(" ");

        private final String letter;

        MapMark(String letter) {
            this.letter = letter;
        }

        public String mark() {
            return letter;
        }
    }
}
