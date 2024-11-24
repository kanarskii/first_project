package mobelLoadStrategy.impl;

import mobelLoadStrategy.LoadStrategy;
import model.Model;
import model.validate.Validate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileStrategy implements LoadStrategy, Validate {
    String path;
    StringBuilder dataBuilder = new StringBuilder();
    List<String> dataList;

    @Override
    public List<String> load() {
        try {
            List<String> data = Files.readAllLines(Path.of(path));
            if(data.isEmpty()){
                throw new Exception("В файле нет данных");
            } else {
                data.forEach(line -> dataBuilder.append(line + "\n"));
                for(String line : data){
                    if(validate(line) == false){
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

    @Override
    public boolean validate(String str) {
        return false;
    }
}
