package ca.bcit.cheong_ho.models;

import java.util.List;

import ca.bcit.cheong_ho.enums.ReadingModes;


public class VolumeInfo
{
    private String title;

    private List<String> authors;

    private String publisher;

    private String publishedDate;

    private String description;

    private IndustryIdentifier industryIdentifier;

    private ReadingModes readingModes;

    private int pageCount;

    private String printType;

    private List<String> categories;

    private int averageRating;

    private int ratingsCount;

    private String maturityRating;

    private boolean allowAnonLogging;

    private String contentVersion;

    private PanelizationSummary panelizationSummary;

    private ImageLinkInfo imageLinkInfo;

    private String language;

    private String previewLink;

    private String infoLink;

    private String canonicalVolumeLink;

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setAuthors(List<String> authors){
        this.authors = authors;
    }
    public List<String> getAuthors(){
        return this.authors;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public void setPublishedDate(String publishedDate){
        this.publishedDate = publishedDate;
    }
    public String getPublishedDate(){
        return this.publishedDate;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setIndustryIdentifier(IndustryIdentifier industryIdentifier){
        this.industryIdentifier = industryIdentifier;
    }
    public IndustryIdentifier getIndustryIdentifier(){
        return this.industryIdentifier;
    }
    public void setReadingModes(ReadingModes readingModes){
        this.readingModes = readingModes;
    }
    public ReadingModes getReadingModes(){
        return this.readingModes;
    }
    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
    }
    public int getPageCount(){
        return this.pageCount;
    }
    public void setPrintType(String printType){
        this.printType = printType;
    }
    public String getPrintType(){
        return this.printType;
    }
    public void setCategories(List<String> categories){
        this.categories = categories;
    }
    public List<String> getCategories(){
        return this.categories;
    }
    public void setAverageRating(int averageRating){
        this.averageRating = averageRating;
    }
    public int getAverageRating(){
        return this.averageRating;
    }
    public void setRatingsCount(int ratingsCount){
        this.ratingsCount = ratingsCount;
    }
    public int getRatingsCount(){
        return this.ratingsCount;
    }
    public void setMaturityRating(String maturityRating){
        this.maturityRating = maturityRating;
    }
    public String getMaturityRating(){
        return this.maturityRating;
    }
    public void setAllowAnonLogging(boolean allowAnonLogging){
        this.allowAnonLogging = allowAnonLogging;
    }
    public boolean getAllowAnonLogging(){
        return this.allowAnonLogging;
    }
    public void setContentVersion(String contentVersion){
        this.contentVersion = contentVersion;
    }
    public String getContentVersion(){
        return this.contentVersion;
    }
    public void setPanelizationSummary(PanelizationSummary panelizationSummary){
        this.panelizationSummary = panelizationSummary;
    }
    public PanelizationSummary getPanelizationSummary(){
        return this.panelizationSummary;
    }
    public void setImageLinkInfo(ImageLinkInfo imageLinkInfo){
        this.imageLinkInfo = imageLinkInfo;
    }
    public ImageLinkInfo getImageLinkInfo(){
        return this.imageLinkInfo;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return this.language;
    }
    public void setPreviewLink(String previewLink){
        this.previewLink = previewLink;
    }
    public String getPreviewLink(){
        return this.previewLink;
    }
    public void setInfoLink(String infoLink){
        this.infoLink = infoLink;
    }
    public String getInfoLink(){
        return this.infoLink;
    }
    public void setCanonicalVolumeLink(String canonicalVolumeLink){
        this.canonicalVolumeLink = canonicalVolumeLink;
    }
    public String getCanonicalVolumeLink(){
        return this.canonicalVolumeLink;
    }
}

