package br.com.danilocerne.springboot.example.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.danilocerne.springboot.example.data.vo.v1.PersonVO;
import br.com.danilocerne.springboot.example.data.vo.v2.PersonVOV2;
import br.com.danilocerne.springboot.example.models.Person;

public class MockPerson {


    public Person mockEntity() {
    	return mockEntity(1);
    }
    
    public PersonVO mockVO() {
    	return mockVO(0);
    }
    
    public List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    private Person mockEntity(Integer number) {
    	Person person = new Person();
    	person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public PersonVO mockVO(Integer number) {
    	PersonVO person = new PersonVO();
    	person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }
    
    public PersonVOV2 mockVOV2(Integer number) {
    	PersonVOV2 person = new PersonVOV2();
    	person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

}
