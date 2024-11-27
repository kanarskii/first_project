package service;

public class ServiceImpl  {

    /*private final List<Model> modelList = new ArrayList<>();
    private Comparator comparator;

    public List<Model> getModelList() {
        return modelList;
    }

    @Override
    public List<Model> loadModels(StrategyType strategy, ModelType type) {

        System.out.println(strategy + " " + type);
        LoadStrategy load = null;
        switch (strategy) {
            case FILE -> load = new FileStrategy();

            case USER -> load = new UserStrategy();

            case RANDOM -> load = new RandomStrategy();
        }


        load.load(type).forEach(System.out::println);

            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(1).build());
            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(2).build());
            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(3).build());
            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(15382).build());
            modelList.add(Student.builder().gpa(7.5).group("AZ-00").number(30).build());
        // тут должна быть валидация которая обрабатывает List<String> и возвращает List<Model>
        // валидация применяется вне зависимости от того какой стратегией мы воспользовались
        // по хорошему в валидации должен быть метод isExp возвращающий список не валидных значений

        if (!isEmpty()) {
        quickSort(modelList, 0, (modelList.size() - 1));
        }
        return modelList;
    }

    @Override
    public Model searchModel(ModelType model, String str) {
        int index = -1;
        switch (model) {
            case BUS -> {
                Bus bus = Bus.builder().number(str).build();
                index = Search.binarySearch(modelList,bus, Comparator.comparing(Bus::getModel));
            }
            case STUDENT -> {
                Student student = Student.builder().number(Integer.parseInt(str)).build();
                index = Search.binarySearch(modelList,student, Comparator.comparingInt(Student::getNumber));
            }
            case USER -> {
                User user = User.builder().name(str).build();
                index = Search.binarySearch(modelList,user, Comparator.comparing(User::getName));
            }
        }
        if (index<0) return null;
        return modelList.get(index);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }*/

   /* @Override
    public Model searchModel(String str) {
        //ToDo Возможно вынести выше. И использовать этот компоратор и для сортировки
        if(!modelList.isEmpty()) {
            var tmp = modelList.get(0);
            Model obj = null;
            if (tmp instanceof Student) {
                comparator = Comparator.comparingInt(Student::getNumber);
                obj = Student.builder().number(Integer.parseInt(str)).build();
            } else if (tmp instanceof User) {
                comparator = Comparator.comparing(User::getEmail);
                obj = User.builder().email(str).build();
            } else if (tmp instanceof Bus) {
                comparator = Comparator.comparing(Bus::getNumber);
                obj = Bus.builder().number(str).build();
            }
            var resSearch = Search.binarySearch(modelList, obj, comparator);
            if (resSearch >= 0) {
                return modelList.get(resSearch);
            }
        }
        return null; //ToDo куда пойдет результат поиска
    }*/
}
