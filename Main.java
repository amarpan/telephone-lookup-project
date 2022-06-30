/*
File Name: main.java
Name: Amar Panjwani
Description: This program reads in data from a file and uses a binary search to find either a name or phone number.
Date: 05/03/21
Email: panjwania@student.vvc.edu
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
  /*
    Performs a binary search for a matching string.
    @param - value - the string to match/find
    @param - list - the array list to look through
    @param - low - the low value of the size of the array list
    @param - high - the size of the array list
    @return - int - the location/index of the matching string
  */
  public static int binarySearch(String value, ArrayList<Person> list, int low, int high)
  {
    int mid = low + (high - low) / 2;

    if(mid >= 0 && mid <= high)
    {
      if(list.get(mid).getLastName().equals(value))
      {
        return mid;
      }
      if(list.get(mid).getLastName().compareTo(value) > 0)
      {
        return binarySearch(value,list,low,mid-1);
      }
      else
      {
        return binarySearch(value,list,mid+1,high);
      }
    }
    return -1;
  }

  public static void main(String[] args) throws FileNotFoundException
  {
    File inputFile = new File("data.csv");
    Scanner in = new Scanner(inputFile);
    int line_number = 0;
    ArrayList<Person> telephoneList = new ArrayList<Person>();
    ArrayList<Person> telephoneList2 = new ArrayList<Person>();

    while (in.hasNext())
    {
      if(line_number != 0)
      {
        String line = in.nextLine();
        String[] field = line.split(",");
      
        telephoneList.add(new Person(field[2]));
        telephoneList.get(line_number-1).setPhoneNumber(field[3]);
        telephoneList.get(line_number-1).setFirstName(field[1]);
        telephoneList2.add(new Person(field[3]));
        telephoneList2.get(line_number-1).setPhoneNumber(field[2]);
        telephoneList2.get(line_number-1).setFirstName(field[1]);
      }
      line_number++;
      
    }
    
    Collections.sort(telephoneList);
    Collections.sort(telephoneList2);
    int index = 0;
    
    int choice = 0;
    String lastNameVal = "";
    String phoneNumberVal = "";
    while (choice != -1)
    {
      Scanner f = new Scanner(System.in);
      System.out.print("Enter 1 to search by last name, 2 to search by phone number, and -1 to quit: ");
      choice = f.nextInt();
      if (choice == 1)
      {
        index = 0;
        System.out.print("Enter a last name (ex. Woods): ");
        lastNameVal = f.next();

        for(Person p : telephoneList)
        {
         System.out.println(" " + index + ": " + p.getLastName() + " " + p.getFirstName() + " " + p.getPhoneNumber());
         index++;
        }

        System.out.println(binarySearch(lastNameVal,telephoneList,0,telephoneList.size()-1));
      }
      else if(choice == 2)
      {
        index = 0;
        System.out.print("Enter a phone number (ex. 311-324-7807): ");
        phoneNumberVal = f.next();

        for(Person p : telephoneList2)
        {
         System.out.println(" " + index + ": " + p.getLastName() + " " + " " + p.getPhoneNumber() + " " + p.getFirstName());
         index++;
        }

        System.out.println(binarySearch(phoneNumberVal,telephoneList2,0,telephoneList.size()-1));
      }
      else
      {
        System.out.println("Incorrect selection, please try again.");
      }
      }
  }
}