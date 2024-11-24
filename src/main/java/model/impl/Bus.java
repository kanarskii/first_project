package model.impl;

import model.Model;

/**
 * Класс автобус со свойствами <b>number</b>, <b>model</b> и <b>mileage</b>.
 * @autor Виктор Дробышевский
 * @version 1.0
 */
public class Bus implements Model {
    /** Поле номер*/
    private final String number;
    /** Поле модель*/
    private final String model;
    /** Поле пробег*/
    private final Integer mileage;

    /** Конструктор - создание нового объекта класса Bus
     * @param number номер
     * @param model модель
     * @param mileage пробег
     */
    public Bus(String number, String model, Integer mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public Integer getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Автобус регистрационный номер: " + number + " модель " + model + " с пробегом: " + mileage;
    }
    /**
     * Создание объекта Bus по паттерну Builder
     * @see Bus
     * @return BusBuilder
     */
    public static BusBuilder builder (){
        return new BusBuilder();
    }

    public static class BusBuilder{
        private String number;
        private String model;
        private Integer mileage;
        /**
         * Задаёт номер автобусу
         * @see Bus
         * @param number строка
         * @return BusBuilder
         */
        public BusBuilder number(String number){
            this.number=number;
            return this;
        }
        /**
         * Задаёт модель автобуса
         * @see Bus
         * @param model строка
         * @return BusBuilder
         */
        public BusBuilder model (String model){
            this.model=model;
            return this;
        }
        /**
         * Задаёт пробег автобуса
         * @see Bus
         * @param mileage целое число
         * @return BusBuilder
         */
        public BusBuilder mileage (Integer mileage){
            this.mileage=mileage;
            return this;
        }
        /** Отправа на создание нового объекта класса Bus
         * @see Bus#Bus(String, String, Integer)
         * @return Bus
         */
        public Bus build(){
            return new Bus(number, model, mileage);
        }
    }

}
