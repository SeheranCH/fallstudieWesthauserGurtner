package ch.course223.helloworldIvo.domainModells.article.dto;


public class ArticleDTO {

    private String id;

    private String name;

    private double value;

    public ArticleDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
