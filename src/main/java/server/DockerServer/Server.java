package server.DockerServer;

import java.io.File;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Server
{
    @GetMapping("/{fileName}")
    public String hello(@PathVariable String fileName)
    {
        File file = new File(fileName);
        String returnStrings = "ERROR";
        try 
        {
            Scanner reader = new Scanner(file);
            StringBuilder strs = new StringBuilder();
            while(reader.hasNextLine())
            {
                strs.append(reader.nextLine());
            }

            reader.close();
            returnStrings = strs.toString();
        } catch (Exception e) 
        {
        }
        return returnStrings;
    }
}