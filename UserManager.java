import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class UserManager 
{
    //Format "Username: name, Level: 1" all are string
    public static void handleNewUser(String input) 
    {
        //try catch example
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usernames.txt", true))) 
        {
            writer.write("Username: "+input+", Level: 1\n"); // Default level is 1 for new users
            System.out.println("Username saved with level 1!");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static int findAndDisplayUserInfo(String username) 
    {
        int userLevel = -1; // Initialize to -1 by default, isnt accepted as valid number
        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("usernames.txt"))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                if (line.contains("Username: " + username)) 
                {
                    System.out.println(line);
                    String[] parts = line.split(", ");
                    for (String part : parts) {
                        if (part.startsWith("Level:")) 
                        {
                            String userLevelStr = part.split(":")[1].trim();
                            userLevel = Integer.parseInt(userLevelStr); // Update userLevel to return
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (!found) 
            {
                System.out.println("User: "+username+" not found.");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace(); //prints errors if any
        }
        return userLevel; // Return userLevel to main to use
    }

    public static void changeLevel(String userName, int newLevel) 
    {
        String line;
        StringBuilder content = new StringBuilder();
    
        try (BufferedReader reader = new BufferedReader(new FileReader("usernames.txt"))) 
        {
            while ((line = reader.readLine()) != null) 
            {
                if (line.contains("Username: " + userName)) //find current user
                {
                    line = "Username: "+userName+", Level: "+newLevel; //new info that is to be written
                }
                content.append(line).append(System.lineSeparator()); //combine info into string
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usernames.txt"))) 
        {
            writer.write(content.toString());    //write to string
            //writer.write(line.toString());     //doesnt work
            //System.out.println("File edited"); //to print for testing
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}


