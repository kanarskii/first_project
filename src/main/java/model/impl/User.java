package model.impl;

import model.Model;

import java.util.Objects;

/**
 * Класс поьзователь со свойствами <b>name</b>, <b>pass</b> и <b>email</b>.
 * @autor Виктор Дробышевский
 * @version 1.0
 */
public class User extends Model {
    /** Поле имя*/
    private final String name;
    /** Поле пароль*/
    private final String pass;
    /** Поле почта*/
    private final String email;

    /** Конструктор - создание нового объекта класса User
     * @param name имя
     * @param pass пароль
     * @param email почта
     */
    private User(String name, String pass, String email) {
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
        return "Пользователь " + name + " пароль " + pass + " e-mail: " + email;
    }

    @Override
    public int compareTo(Model o) {
        return this.name.compareTo(((User) o).getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(pass, user.pass) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pass, email);
    }

    /**
     * Создание объекта User по паттерну Builder
     * @see User
     * @return UserBuilder
     */
    public static UserBuilder builder (){
        return new UserBuilder();
    }


    public static class UserBuilder{
        private String name;
        private String pass;
        private String email;

        /**
         * Задаёт имя пользователя
         * @see User
         * @param name строка
         * @return UserBuilder
         */
        public UserBuilder name(String name){
            this.name=name;
            return this;
        }
        /**
         * Задаёт пароль пользователя
         * @see User
         * @param pass строка
         * @return UserBuilder
         */
        public UserBuilder pass (String pass){
            this.pass=pass;
            return this;
        }
        /**
         * Задаёт e-mail пользователя
         * @see User
         * @param email строка
         * @return UserBuilder
         */
        public UserBuilder email (String email){
            this.email=email;
            return this;
        }
        /** Отправа на создание нового объекта класса User
         * @see User#User(String, String, String)
         * @return User
         */
        public User build(){
            return new User(name, pass, email);
        }
    }

}
