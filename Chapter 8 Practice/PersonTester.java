import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PersonTester
{
    public static void main(String[] args)
    {
        Scanner s1 = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<Person>();
        for(int i = 0;
            i < 10;
            i ++)
        {
            System.out.print("Name: ");
            persons.add(new Person(s1.next()));
        }
        
        
        Collections.sort(persons);
        
        System.out.println(persons.get(0).compareTo(persons.get(persons.size()-1)));
        
    }
}
