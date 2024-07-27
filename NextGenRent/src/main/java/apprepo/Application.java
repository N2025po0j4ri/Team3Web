package apprepo;

public class Application {
    private String name;
    private String description;
    private String organization;
    private String platforms;
    private String[] links;
    private String price;
    
    // Getters and Setters
    // Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Organization
    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    // Platforms
    public String getPlatforms() {
        return platforms;
    }
    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }
    
    // Links
    public String[] getLinks() {
        return links;
    }
    public void setLinks(String[] links) {
        this.links = links;
    }
    
    // Price
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
