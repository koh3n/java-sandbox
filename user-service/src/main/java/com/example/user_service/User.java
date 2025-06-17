package com.example.user_service;

public class User {
    private String name;
    private Integer id;

    public User() {
    }

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof User)) {return false;}

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) {return false;}
        return id != null ? id.equals(user.id) : user.id == null;
    }
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
