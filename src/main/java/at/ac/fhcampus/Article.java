package at.ac.fhcampus;

import java.util.Objects;

public class Article {
    private String author;
    private final String title;
    private final String description;
    private final String url;
    private final String urlToImage;
    private final String publishedAt;
    private final String content;
    private final Source source;

    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content, Source source) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.source = source;
    }
    public int getAuthorLength(){
        int length;
        length = author.length();
        return length;
    }

    public String getAuthor(){
        return author;
    }
    public Source getSource(){
        return source;
    }
    public int getTitleLength(){
        int length;
        length = title.length();
        return length;
    }

    public int getDescriptionLength(){
        int length;
        length = description.length();
        return length;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Article article)) return false;

        return Objects.equals(article.title, this.title) && Objects.equals(article.author, this.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public String toString() {
        if(author == null){
            this.author = "null";
        }
        return

               // System.lineSeparator() + "Source id: " + source.getId() +
                System.lineSeparator() + "Source: " + source.getName() + System.lineSeparator() +
                "Title: " + title + System.lineSeparator() +
                "Author: " + author + System.lineSeparator() +
                "Description: " + description + System.lineSeparator() +
                "Url: " + url + System.lineSeparator() +
                "Image: " + urlToImage + System.lineSeparator() +
                "Date: " + publishedAt + System.lineSeparator() +
                "Content: " + content + System.lineSeparator();
    }


}
