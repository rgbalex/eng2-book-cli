package uk.ac.york.eng2.bookscli.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class BookDTO {
    private String title;
    private Integer year;

    public BookDTO(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
