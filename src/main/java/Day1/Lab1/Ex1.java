package Day1.Lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;


public class Ex1 {
    public String All_content = "";
   
    public void getData() throws IOException {
        // read from console until user write stop
        InputStreamReader r = new InputStreamReader(System.in);
        System.out.println("Enter data: ");
        BufferedReader br = new BufferedReader(r);
        String data = br.readLine();
        System.out.println("data is: " + data);
        if (data.equalsIgnoreCase("stop")) { 
            dataToFile();  
        } else {
            this.All_content += data + '\n';
            getData();
        }
    }
 
    public void dataToFile() {
        // write the entered data to file
        try {
            FileWriter writer = new FileWriter("OutputFile.txt");
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(this.All_content);
            buffer.close();
            System.out.println("BUILD SUCCESSFUL");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Ex1 start = new Ex1();
        start.getData();                
    }
}