package bridge.etc;

public enum GameState {
    CONTINUE {
        @Override
        public String getLastBlockState(Boolean isRightDirection) {
            if (isRightDirection) {
                return String.format(" %s ", PassState.RIGHT);
            }
            return String.format(" %s ", PassState.NO_CHOICE);
        }
    },
    CLEAR {
        @Override
        public String getLastBlockState(Boolean isRightDirection) {
            if (isRightDirection) {
                return String.format(" %s ", PassState.RIGHT);
            }
            return String.format(" %s ", PassState.NO_CHOICE);
        }
    },
    FAIL {
        @Override
        public String getLastBlockState(Boolean isRightDirection) {
            if (isRightDirection) {
                return String.format(" %s ", PassState.NO_CHOICE);
            }
            return String.format(" %s ", PassState.FAIL);
        }
    },
    EXIT {
        @Override
        public String getLastBlockState(Boolean isRightDirection) {
            return "";
        }
    };

    public abstract String getLastBlockState(Boolean isRightDirection);
}
