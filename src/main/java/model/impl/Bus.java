package model.impl;

import model.Model;

public class Bus implements Model {
    private final String number;
    private final String model;
    private final Integer mileage;

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

    public static BusBuilder builder (){
        return new BusBuilder();
    }

    public static class BusBuilder{
        private String number;
        private String model;
        private Integer mileage;

        public BusBuilder number(String number){
            this.number=number;
            return this;
        }
        public BusBuilder model (String model){
            this.model=model;
            return this;
        }
        public BusBuilder mileage (Integer mileage){
            this.mileage=mileage;
            return this;
        }

        public Bus build(){
            return new Bus(number, model, mileage);
        }
    }

}
