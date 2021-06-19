package Day1.Lab2;

import java.io.IOException;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws IOException {
       
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("/Users/saraelaraby/Downloads/untitled/src/main/resources/pyramids.csv");

        // let's print all the pyramids read from csv file
        int i = 0;
        for (Pyramid p : pyramids) {
            System.out.println("#" + (i++) + p);
        }
    }   
}