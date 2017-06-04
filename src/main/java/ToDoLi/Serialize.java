package ToDoLi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Serialize implements Serializable 
{ 
    static void saveDat(ArrayList YourObject, String filePath) throws IOException 
    { 
        ObjectOutputStream outputStream = null; 
        try 
        { 
            outputStream = new ObjectOutputStream(new FileOutputStream(filePath)); 
            outputStream.writeObject(YourObject); 
        } 
        catch(FileNotFoundException ex) 
        { 
            ex.printStackTrace(); 
        } 
        catch(IOException ex) 
        { 
            ex.printStackTrace(); 
        } 
        finally 
        { 
            try 
            { 
                if(outputStream != null) 
                { 
                    outputStream.flush(); 
                    outputStream.close(); 
                } 
            } 
            catch(IOException ex) 
            { 
                ex.printStackTrace(); 
            } 
        } 
    } 

    public static ArrayList loadDat(String filePath) throws IOException { 
        try { 
            FileInputStream fileIn = new FileInputStream(filePath); 
            ObjectInputStream in = new ObjectInputStream(fileIn); 
            return (ArrayList) in.readObject();
         
        } 
        catch(Exception ex) { 
            ex.printStackTrace();
            return null;
        } 
    } 
      
    } 
