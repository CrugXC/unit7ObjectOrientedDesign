

public class Person implements Comparable<Person>
{
    private String name;
    
    public Person(String inputName)
    {
        this.name = inputName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int compareTo(Person other)
    {
        return name.compareTo(other.name);
    }
}
