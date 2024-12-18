package mobelLoadStrategy.impl;

import mobelLoadStrategy.LoadStrategy;
import model.ModelType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomStrategy implements LoadStrategy {
    private final Random r = new Random();
    private final List<String> loadString = new ArrayList<>();


    @Override
    public List<String> load(ModelType type) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число N элементов (в случае некорректного значения, коллекция будет заполнена случайным количеством элементов)");
        String count = in.next();
        int iteration;
        if (count.trim().matches("\\d+")) {
            iteration = Integer.parseInt(count);
        } else {
            iteration = r.nextInt(5);
            System.out.println("Введено некорректное значение, коллекция будет содержать " + iteration + " элементов");
        }

        switch (type){
            case USER -> {
                for (int i = 1; i<=iteration; i++ )
                    loadString.add(randomWord() + ";" +randomWord() + ";" + randomEmail());
            }
            case STUDENT -> {
                for (int i = 1; i<=iteration; i++ )
                    loadString.add(randomWord() + ";" + randomDouble() + ";" + randomInteger());
            }
            case BUS -> {
                for (int i = 1; i <= iteration; i++)
                    loadString.add(randomWord() + ";" + randomWord() + ";" + randomInteger());
            }
        }
        return loadString;
    }

    private StringBuilder  randomWord () {
        StringBuilder builder = new StringBuilder();
        int lenght = r.nextInt(6)+4;
        for (int j = 0; j < lenght; j++) {
            char code = (char) (r.nextInt(25) + 97);
            builder.append(Character.toString(code));
        }
        return builder;
    }

    private StringBuilder  randomEmail() {
        StringBuilder builder = new StringBuilder();
        int lenght = r.nextInt(6)+4;
        for (int j = 0; j < lenght; j++) {
            char code = (char) (r.nextInt(25) + 97);
            builder.append(Character.toString(code));
        }
        builder.append("@");
        lenght = r.nextInt(6)+4;
        for (int j = 0; j < lenght; j++) {
            char code = (char) (r.nextInt(25) + 97);
            builder.append(Character.toString(code));
        }
        builder.append(".");
        lenght = r.nextInt(1)+2;
        for (int j = 0; j < lenght; j++) {
            char code = (char) (r.nextInt(25) + 97);
            builder.append(Character.toString(code));
        }
        return builder;
    }

    private StringBuilder  randomDouble () {
        StringBuilder builder = new StringBuilder();
        builder.append(randomNumber (1));
        builder.append(".");
        builder.append(randomNumber (1));
        return builder;
    }

    private StringBuilder  randomInteger () {
        StringBuilder builder = new StringBuilder();
            builder.append(randomNumber(5));
        return builder;
    }

    private StringBuilder randomNumber (int i) {
        int lenght = r.nextInt(i)+1;
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < lenght; j++) {
            builder.append(r.nextInt(9));
        }
        return builder;
    }

}
