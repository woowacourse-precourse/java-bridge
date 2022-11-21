package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeMapComponent {
    private static final String DELIMITER = " | ";
    private final List<String> bridgeMapComponent;

    public BridgeMapComponent()
    {
        this.bridgeMapComponent = new ArrayList<>();
    }

    public void removeLast() throws IndexOutOfBoundsException
    {
        int lastIndex = bridgeMapComponent.size()-1;
        if(lastIndex < 0) return;
        bridgeMapComponent.remove(lastIndex);
    }

    public void add(String pixel)
    {
        bridgeMapComponent.add(pixel);
    }

    @Override
    public String toString()
    {
        return "[ " + String.join(DELIMITER,bridgeMapComponent) + " ]\n";
    }


}
