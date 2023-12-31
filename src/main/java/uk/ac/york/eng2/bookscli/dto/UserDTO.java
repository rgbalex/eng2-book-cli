package uk.ac.york.eng2.bookscli.dto;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class UserDTO {
    private String name;
    private Integer age;

    public UserDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
