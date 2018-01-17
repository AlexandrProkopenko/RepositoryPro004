package concurrencyapi.lesson06.reflectionapi;

import java.lang.reflect.*;

public class ReflectionAPI {

    public static void main(String[] args) throws ClassNotFoundException {
        //Ссілка на класс
        ValueEx valueEx = new ValueEx(17);
        System.out.println(valueEx.getClass().getName());
        Class cls = Class.forName(valueEx.getClass().getName());

        Class cl = ValueEx.class;

        //Получение объявленных в классе полей
        System.out.println("Polya Klacca");
        Field[] pubFields = cl.getFields(); //только public поля
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                System.out.print("private ");
            }
            System.out.print(field.getType() + " ");
            System.out.println(field.getName());
        }

        //Методы
        System.out.println("Методы");
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getParameterCount());
            if (method.getParameterCount() > 0) {
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.getType());
                    System.out.println(parameter.getName());
                }
            }
            System.out.println(method.getReturnType());
        }

        //Конструктор
        System.out.println("Конструкторы");
        Constructor[] constructors = cl.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getParameterCount());
        }
    }
}
