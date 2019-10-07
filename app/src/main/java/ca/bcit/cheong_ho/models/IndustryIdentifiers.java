package ca.bcit.cheong_ho.models;

public class IndustryIdentifiers {
    private String type;

    private String identifier;

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
    public void setIdentifier(String identifier){
        this.identifier = identifier;
    }
    public String getIdentifier(){
        return this.identifier;
    }
}
