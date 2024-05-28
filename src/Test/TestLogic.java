package Test;

import static org.junit.Assert.*;

import baseClasses.Date;
import baseClasses.Person;
import org.junit.Test;

public class TestLogic {
    @Test
    public void test1(){
        assertEquals(511492,new Date(1401,5,3).days());
    }
    @Test
    public void check_name(){
        Person person = new Person("allah");
        assertEquals("not true","allah",person.getName());
    }
}
