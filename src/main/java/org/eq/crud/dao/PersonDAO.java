package org.eq.crud.dao;

import jdk.internal.jline.internal.Nullable;
import org.eq.crud.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Класс общается со списком и извлекает людей из списка (сейчас).
 * 2. Записывать и извлекать людей из БД.
 */
@Component
public class PersonDAO {

    private static int COUNTER;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++COUNTER, "Herman"));
        people.add(new Person(++COUNTER, "Tomas"));
        people.add(new Person(++COUNTER, "Mike"));
        people.add(new Person(++COUNTER, "Dean"));
    }

    public List<Person> index() {
        return people;
    }

    public void save(Person person) {
        person.setId(++COUNTER);
        people.add(person);
    }

    @Nullable
    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
