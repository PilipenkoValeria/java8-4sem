package ru.omsu;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ReflectionDemo {
    //1)Дан список объектов произвольных типов. Найдите количество элементов списка,
    //которые являются объектами типа Human или его подтипами.
    public static int getAmountOfHumansInList(ArrayList<Object> list) {
        int sum = 0;
        for (Object object : list) {
            if (object instanceof Human) {
                sum++;
            }
        }
        return sum;
    }

    //2)Для объекта получить список имен его открытых методов.
    public static ArrayList<String> getOpenMethodsNames(Object object) {
        Method[] methods = object.getClass().getMethods();
        ArrayList<String> listPublicMethod = new ArrayList<>(methods.length);
        for (Method method : methods) {
            listPublicMethod.add(method.getName());
        }
        return listPublicMethod;
    }

    //3)Для объекта получить список (в виде списка строк) имен всех его суперклассов до класса Object включительно.
    public static ArrayList<String> getAllSuperclassesNames(Object object) {
        ArrayList<String> nameOfSuperClass = new ArrayList<>();
        Class cl = object.getClass().getSuperclass();
        while (!(cl == null)) {
            nameOfSuperClass.add(cl.getSimpleName());
            cl = cl.getSuperclass();
        }
        return nameOfSuperClass;
    }

    //4)метод, который для списка объектов находит его элементы, реализующие этот
    //интерфейс, и выполняет в таких объектах метод execute(). Метод возвращает количество
    //найденных элементов.
    public static int listUseExecute(ArrayList<Object> list) {
        int sum = 0;
        for (Object object : list) {
            if (object instanceof Executable) {
                ((Executable) object).execute();
                sum++;
            }
        }
        return sum;
    }

    public static boolean getter(Method method) {
        return (Modifier.isPublic(method.getModifiers()) &&
                !(Modifier.isStatic(method.getModifiers())) &&
                method.getParameters().length == 0 &&
                method.getName().startsWith("get") &&
                !(method.getReturnType().equals(void.class)));
    }

    public static boolean setter(Method method) {
        return (Modifier.isPublic(method.getModifiers()) &&
                !(Modifier.isStatic(method.getModifiers())) &&
                method.getParameters().length == 1 &&
                method.getName().startsWith("set") &&
                method.getReturnType().equals(void.class));
    }

    //5)Для объекта получить список его геттеров и сеттеров (в виде списка строк)
    public static ArrayList<String> getListOfGettersAndSetters(Object object) {
        ArrayList<String> listGetAndSet = new ArrayList<>();
        for (Method method : object.getClass().getMethods()) {
            if (getter(method) || setter(method)) {
                listGetAndSet.add(method.getName());
            }
        }
        return listGetAndSet;
    }
}


