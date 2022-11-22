package bridge;

public enum Map {
    MAP_START("[ "),
    MAP_END(" ]"),
    MAP_SEPARATOR(" | "),
    MAP_RIGHT("O"),
    MAP_WRONG("X"),
    MAP_BLANK(" ");

    private String stringToAdd;

    Map(String stringToAdd){
        this.stringToAdd = stringToAdd;
    }

    public String getStringToAdd() {
        return stringToAdd;
    }

}

