package org.leorodrigues.guestbook;

import org.springframework.data.annotation.Id;

public class Guest {

    @Id private String id;

    private String name;

    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}