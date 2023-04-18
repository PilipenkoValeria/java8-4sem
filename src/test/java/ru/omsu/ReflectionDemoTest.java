package ru.omsu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class ReflectionDemoTest {
    Human human = new Human("Evdokimov", "Alexandr", "Victorovich", 43);
    Student student = new Student("Pervushina", "Alexandra", "Pavlovna", 20, "TPU");
    private ReflectionDemo actual = new ReflectionDemo();
    private ArrayList<Object> list = new ArrayList<>();
    private ArrayList<String> expected = new ArrayList<>();

    @Test
    public void getAmountOfHumansInListTest() {
        ArrayList<Object> list = new ArrayList<>(Arrays.asList
                (human, student, 544, 33, 28, 23.4));
        int amountOfHumansInList = ReflectionDemo.getAmountOfHumansInList(list);
        assertEquals(2, amountOfHumansInList);
    }

    @Test
    public void getOpenMethodsNamesTest() {
        ArrayList<String> actualList = ReflectionDemo.getOpenMethodsNames(actual);
        Collections.sort(actualList);
        Collections.addAll(expected, "getAllSuperclassesNames", "getAmountOfHumansInList",
                "getListOfGettersAndSetters", "getOpenMethodsNames", "getter", "listUseExecute", "setter");
        assertEquals(expected, actualList);

    }

    @Test
    public void getAllSuperclassesNamesTest() {
        Collections.addAll(expected, "Human", "Object");
        assertEquals(expected, ReflectionDemo.getAllSuperclassesNames(student));
    }

    @Test
    public void testListUseExecute() {
        ReflectionDemo reflectionDemo = new ReflectionDemo();
        Collections.addAll(list, human, student);
        assertEquals(1, ReflectionDemo.listUseExecute(list));
    }

    @Test
    public void getListOfGettersAndSettersTest0() {
        ArrayList actualList = ReflectionDemo.getListOfGettersAndSetters(human);
        Collections.sort(actualList);
        Collections.addAll(expected, "getAge", "getClass", "getName", "getPatronymic", "getSurname",
                "setAge", "setName", "setPatronymic", "setSurname");
        assertEquals(expected, actualList);

    }

    @Test
    public void getListOfGettersAndSettersTest1() {
        ArrayList actualList = ReflectionDemo.getListOfGettersAndSetters(student);
        Collections.sort(actualList);
        Collections.addAll(expected, "getAge", "getClass", "getName", "getPatronymic",
                "getSurname", "getUniversity", "setAge", "setName", "setPatronymic", "setSurname", "setUniversity");
        assertEquals(expected, actualList);
    }
}
