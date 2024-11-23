package model.impl;

import model.Model;

public class User implements Model {

    private final String name;
    private final String pass;
    private final String email;

    public User(String name, String pass, String email) {
        this.name = name;
        this.pass = pass;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Пользователь " + name + " пароль " + pass + " e-mail: " + email + '\'' +
                '}';
    }

    public static UserBuilder builder (){
        return new UserBuilder();
    }

    public static class UserBuilder{
        private String name;
        private String pass;
        private String email;

        public UserBuilder name(String name){
            this.name=name;
            return this;
        }
        public UserBuilder pass (String pass){
            this.pass=pass;
            return this;
        }
        public UserBuilder email (String email){
            this.email=email;
            return this;
        }

        public User build(){
            return new User(name, pass, email);
        }
    }

}
