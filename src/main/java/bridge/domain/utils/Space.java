package bridge.domain.utils;

public enum Space {
    /**
    * 사용자의 현재 다리 상태를 저장하고 있는 List<List<String>> currentBridge에서
    * currentBridge.get(0)은 아래 칸의 정보, currentBridge.get(1)은 위 칸의 정보입니다.
    */
    DOWN(0, "D"), UP(1, "U");

    private final int index;
    private final String represented;

    Space(int index, String represented) {
        this.index = index;
        this.represented = represented;
    }

    public int getIndex() {
        return index;
    }

    public String getRepresented() {
        return represented;
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
