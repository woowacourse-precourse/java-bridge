package bridge.constant;

public final class Bridge {
    public static final class GameConstants {

        public static final String GAME_SUCCESS = "성공";
        public static final String GAME_FAILURE = "실패";
        public static final String GAME_RETRY = "R";
        public static final String GAME_QUIT = "Q";
        public static final int INITIAL_VALUE_OF_ATTEMPTS_NUMBER = 1;

        private GameConstants() {}
    }

    public static final class MapConstants {

        public static final String SUCCESSFUL_MOVE_FORMAT = "O";
        public static final String FAILED_MOVE_MARK = "X";
        public static final String NEVER_STEPPED_MARK = " ";
        public static final int UP_SIDE_INDEX = 0;
        public static final int DOWN_SIDE_INDEX = 1;

        private MapConstants() {}
    }

    public static final class Checker {

        public static final int MAXIMUM_BRIDGE_SIZE = 20;
        public static final int MINIMUM_BRIDGE_SIZE = 3;

        private Checker() {}
    }
}
