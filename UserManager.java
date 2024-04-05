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
    
    public static Integer findAndDisplayUserInfo(String username) {
        //new
        Integer val = -1;
        boolean found = false;
        //new
        String userLevel = "";
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
                            //changedb
                         userLevel = part.split(":")[1];
                           // String level = part.split(": ")[1];
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
        //new if found
        try{ 
        if(found) 
        {
            val = Integer.parseInt(userLevel); 
        }}
        catch(Exception e){
            System.out.println("nnnn");
        }
       
        return val;
    }
    
}