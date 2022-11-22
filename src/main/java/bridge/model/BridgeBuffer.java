package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeBuffer {
    private enum Element {

        START("["),
        CONTOUR("|"),
        END("]"),
        RIGHT(" O "),
        WRONG(" X "),
        BLANK("   ");

        private final String letter;
        Element(String letter) {
            this.letter = letter;
        }
    }
    private List<List<String>> buffer;

    public BridgeBuffer(){
        initialize();
    }
    public void clear(){
        buffer.clear();
    }
    public void initialize(){
        buffer = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            buffer.add(new ArrayList<>());
            buffer.get(i).add(Element.START.letter);
        }
    }

    public void add(Column answer){
        if(buffer.get(0).get(buffer.get(0).size()-1) == Element.END.letter){
            setLastBufferToContour();
        }
        buffer.get(answer.getIndex()).add(Element.RIGHT.letter);
        buffer.get(answer.getOppositeIndex()).add(Element.BLANK.letter);
        addLastBufferToContour();
    }

    public List<List<String>> getCurrent(){
        setLastBufferToEnd();
        return buffer;
    }

    public List<List<String>> getResult(){
        return buffer;
    }
    public List<List<String>> addFailLetter(int step, BridgeGame bridgeGame){
        if (buffer.get(0).get(buffer.get(0).size()-1) != Element.END.letter){
            return addFailLetterAtFirst(step,bridgeGame);
        }
        setLastBufferToContour();
        buffer.get(bridgeGame.getIndexByColumns(step)).add(Element.BLANK.letter);
        buffer.get(bridgeGame.getOppositeIndexByColumns(step)).add(Element.WRONG.letter);
        addLastBufferToEnd();
        return buffer;
    }

    public List<List<String>> addFailLetterAtFirst(int step, BridgeGame bridgeGame){
        buffer.get(bridgeGame.getIndexByColumns(step)).add(Element.WRONG.letter);
        buffer.get(bridgeGame.getOppositeIndexByColumns(step)).add(Element.BLANK.letter);
        addLastBufferToEnd();
        return buffer;
    }

    private void addLastBufferToContour(){
        buffer.get(0).add(Element.CONTOUR.letter);
        buffer.get(1).add(Element.CONTOUR.letter);
    }
    private void setLastBufferToContour(){
        buffer.get(0).set(buffer.get(0).size()-1,Element.CONTOUR.letter);
        buffer.get(1).set(buffer.get(1).size()-1,Element.CONTOUR.letter);
    }
    private void addLastBufferToEnd(){
        buffer.get(0).add(Element.END.letter);
        buffer.get(1).add(Element.END.letter);
    }
    private void setLastBufferToEnd(){
        buffer.get(0).set(buffer.get(0).size()-1,Element.END.letter);
        buffer.get(1).set(buffer.get(1).size()-1,Element.END.letter);
    }
}
