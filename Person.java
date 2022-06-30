public class Person implements Comparable<Person>
{
  private String lastname;
  private String firstName;
  private String phoneNumber;

  /*
    Constructor to set last name when initializing an object.
    @param - lastname - the last name to assign/set
  */
  public Person(String lastname)
  {
    this.lastname = lastname;
  }

  /*
    Gets the last name of an object.
    @return - the last name
  */
  public String getLastName()
  {
    return this.lastname;
  }

  /*
    Gets the phone number of an object.
    @returns - the phone number
  */
  public String getPhoneNumber()
  {
    return this.phoneNumber;
  }

  /*
    Gets the first name of an object.
    @return - the first name
  */
  public String getFirstName()
  {
    return this.firstName;
  }

  /*
    Sets the last name of an object.
    @param - lastname - the last name to set
  */
  public void setLastName(String lastname)
  {
    this.lastname = lastname;
  }

  /*
    Sets the phone number of an object.
    @param - phoneNumber - the phone number to set/assign.
  */
  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  /*
    Sets the first name of an object.
    @param - firstName - the first name to set
  */
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  /*
  Yields a string describing the object.
  @returns - lastname - the last name 
  */
  public String toString()
  {
    return this.lastname;
  }

  /*
    Compares the last name of two Persons.
    @param - p - person to compare to
    @return - int - matching, higher, or lower numeric value
  */
  public int compareTo(Person p)
  {
    return lastname.compareTo(p.lastname);
  }
}