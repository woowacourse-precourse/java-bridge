package bridge.config;

public enum CharacterConfiguration {

    ENTER("\n");

    private final String config;

    CharacterConfiguration(String config) {
        this.config = config;
    }

    public String getConfig() {
        return config;
    }
}
