package ca.bcit.cheong_ho;

public class PanelizationSummary {
    private boolean containsEpubBubbles;

    private boolean containsImageBubbles;

    public void setContainsEpubBubbles(boolean containsEpubBubbles){
        this.containsEpubBubbles = containsEpubBubbles;
    }
    public boolean getContainsEpubBubbles(){
        return this.containsEpubBubbles;
    }
    public void setContainsImageBubbles(boolean containsImageBubbles){
        this.containsImageBubbles = containsImageBubbles;
    }
    public boolean getContainsImageBubbles(){
        return this.containsImageBubbles;
    }
}
