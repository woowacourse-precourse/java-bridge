package bridge.model;

public enum DrawType {
    SUCCESS("O"), FAIL("X"), BLANK(" ");

    private final String drawCharacter;

    DrawType(String drawCharacter) {
        this.drawCharacter = drawCharacter;
    }

    public String getDrawCharacter() {
        return drawCharacter;
    }
}
