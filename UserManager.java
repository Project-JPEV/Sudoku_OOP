import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class UserManager 
{

    public static void handleNewUser(String input) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usernames.txt", true))) 
        {
            writer.write("Username: " + input + ", Level: 1\n"); // Default level is 1 for new users
            System.out.println("Username saved with level 1!");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void findAndDisplayUserInfo(String username) 
    {
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
                            String userLevel = part.split(": ")[1];
                            System.out.println("Level: " + userLevel);
                            
                            found = true;
                            break;
                        }
                    }
                }
            }
            if (!found) 
            {
                System.out.println("User '" + username + "' not found.");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}