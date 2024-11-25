package mobelLoadStrategy.impl;

import mobelLoadStrategy.LoadStrategy;
import model.Model;
import model.validate.Validate;
import model.validate.ValidateMethods;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileStrategy implements LoadStrategy{
    String path;
    StringBuilder dataBuilder = new StringBuilder();
    List<String> dataList;

            /**
             * Делаю коммент в ДжаваДокс первый раз
             * Метод считывает с файла преобразуя в Лист
             * Даллее проверяем на пустые строки и каждую строку через метод валидирующего класса прогоняем
             * по регулярному выражению
             * Далее возвращаем копию Листа
             * @return
             */

    @Override
    public List<String> load() {
        try {
            List<String> data = Files.readAllLines(Path.of(path));
            if(data.isEmpty()){
                throw new Exception("В файле нет данных");
            } else {
                data.forEach(line -> dataBuilder.append(line + "\n"));
                for(String line : data){
                   ValidateMethods result = new ValidateMethods();
                     if(!result.validate(line)){
                        throw new Exception("Строка" + line + "не прошла валидацию");
                     }
                }
                 dataList = data;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return dataList;
    }
}
