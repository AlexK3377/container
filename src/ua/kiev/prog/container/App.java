package ua.kiev.prog.container;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Container container = new Container("Forza Ferrari");
        Saver saver = new Saver();
        Class<? extends Container> containerClass = container.getClass();
        Field[] declaredFields = containerClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(Save.class)) {
                declaredField.setAccessible(true);
                Save saveAnnotation = declaredField.getAnnotation(Save.class);
                Method saveMethod = saver.getClass().getMethod(saveAnnotation.method(), String.class, String.class);
                saveMethod.invoke(saver, saveAnnotation.path(), (String) declaredField.get(container));
            }
        }
    }
}
