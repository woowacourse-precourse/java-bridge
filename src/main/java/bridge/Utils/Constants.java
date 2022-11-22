package bridge.Utils;

public class Constants {
    public enum MoveInputAndNextInput {
        UP_O(0, "O", "U"),
        DOWN_O(1, "O", "D"),
        UP_X(0, "X", "U"),
        DOWN_X(1, "X", "D");

        private final int index;
        private final String oOrX;
        private final String upDown;

        MoveInputAndNextInput(int index, String oOrX, String upDown) {
            this.index = index;
            this.oOrX = oOrX;
            this.upDown = upDown;
        }

        public int getIndex() {
            return index;
        }

        public String getOorX() {
            return oOrX;
        }

        public String upDown() {
            return upDown;
        }

    }
}
