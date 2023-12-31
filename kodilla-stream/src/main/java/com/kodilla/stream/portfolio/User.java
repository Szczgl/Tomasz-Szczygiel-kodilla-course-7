package com.kodilla.stream.portfolio;

public final class User {

    private final String username;
    private final String realName;

    public User(final String username, final String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User user)) return false;

        return getUsername() != null ? getUsername().equals(user.getUsername()) : user.getUsername() == null;
    }
}