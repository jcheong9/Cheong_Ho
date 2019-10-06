package ca.bcit.cheong_ho;

public class ReadingModes {
    private boolean text;

    private boolean image;

    public void setText(boolean text){
        this.text = text;
    }
    public boolean getText(){
        return this.text;
    }
    public void setImage(boolean image){
        this.image = image;
    }
    public boolean getImage(){
        return this.image;
    }
}
