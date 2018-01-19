package concurrencyapi.lesson06.reflectionapi;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class IgnorePrivateReflectionAPI {

    public static void main(String[] args) throws IllegalAccessException {
        class SomeClass {
            private String privateParam = "node";

            public String getNode() {
                return privateParam;
            }
        }

        SomeClass cls = new SomeClass();
        System.out.println(cls.getNode());

        Field[] fields =
                cls.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
                field.set(cls, new String("publicNODE"));
                field.setAccessible(false);
            }
            /*if (Modifier.isFinal(field.getModifiers())) {
                field.setAccessible(true);
                field.set(cls, new String("finalNODE"));
                field.setAccessible(false);
            }*/
        }
        System.out.println(cls.getNode());
    }
}
