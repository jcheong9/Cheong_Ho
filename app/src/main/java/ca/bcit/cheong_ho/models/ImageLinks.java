package ca.bcit.cheong_ho.models;

public class ImageLinks {
    private String smallThumbnail;

    private String thumbnail;

    public void setSmallThumbnail(String smallThumbnail){
        this.smallThumbnail = smallThumbnail;
    }
    public String getSmallThumbnail(){
        return this.smallThumbnail;
    }
    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }
    public String getThumbnail(){
        return this.thumbnail;
    }
}
