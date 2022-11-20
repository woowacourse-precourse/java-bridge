package bridge.domain.bridgemaking;

public enum Space {
    DOWN(0), UP(1);

    private final int index;

    Space(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static int getOtherSpaceIndex(int index) {
        if (index == DOWN.getIndex()) {
            return UP.getIndex();
        }
        return DOWN.getIndex();
    }

    public static int getIndexByRepresented(String represented) {
        if (represented.equals("D")) {
            return DOWN.getIndex();
        }
        return UP.getIndex();
    }
}
