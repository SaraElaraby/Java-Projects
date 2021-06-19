package Day1.Lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO {
    ArrayList<Pyramid> pyramids;
    String line;
     
    public PyramidCSVDAO() {
     }

    public List<Pyramid> readPyramidsFromCSV (String fileName) throws IOException {
        // read from csv file
        BufferedReader br;
        br = new BufferedReader (new FileReader(fileName));
        // read the headline
        br.readLine();
        // list to store data
        pyramids = new ArrayList<Pyramid>();
        // loop untill get all lines are read
        do {
            line = br.readLine();
            if (line != null) {
                String[] attributes = line.split(",");
                String[] metadata = {attributes[0], attributes[2], attributes[4], attributes[7]};
                pyramids.add(createPyramid(metadata));
                }
        } while (line != null);
        br.close();
        return pyramids;
    }

    public Pyramid createPyramid (String[] metadata) {
        Double height;
        try {
            height = Double.parseDouble(metadata[3]);
        } catch (Exception exception) {
            height = Double.NaN;
        }
        Pyramid p = new Pyramid (metadata[0], metadata[1], metadata[2], height);
        return  p;
    }
}
