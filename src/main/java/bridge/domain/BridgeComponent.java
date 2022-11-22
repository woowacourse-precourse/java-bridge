package bridge.domain;

public enum BridgeComponent {
    UP(1,"U"),
    DOWN(0,"D"),
    NOTHING(2,"NOTHING");

    private final int componentNumber;
    private final String componentLetter;

    BridgeComponent(int componentNumber, String componentLetter) {
        this.componentNumber = componentNumber;
        this.componentLetter = componentLetter;
    }

    public int getComponentNumber(){
        return componentNumber;
    }

    public String getComponentLetter(){
        return componentLetter;
    }
}
