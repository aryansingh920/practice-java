import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

   public static void main(String[] args) {
        String[] names = new String[] { "John", "Carl", "Jerry" };
        
        List<String> StringNameList = new ArrayList<>();
        for (String name : names) {
            StringNameList.add(name);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            for (String name : names) {
                writer.write("\n" + name);
            }
            for (String name : StringNameList) {
                writer.write(name);
            }
            // writer.write("Writing to a file.");
            writer.close();
        } catch (IOException e) {
            // e.printStackTrace();
        }


        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String currentLine;
            
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
            reader.close();
        } catch (IOException e) {
            // e.printStackTrace();
        }
    }
}
