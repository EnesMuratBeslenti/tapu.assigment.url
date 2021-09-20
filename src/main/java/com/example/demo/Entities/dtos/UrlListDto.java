package com.example.demo.Entities.dtos;

public class UrlListDto {

    public UrlListDto(Long id,String url, String shortUrl) {
        this.id = id;
        this.url = url;
        this.shortUrl = shortUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    private Long id;
    private String url;
    private String shortUrl;

}
