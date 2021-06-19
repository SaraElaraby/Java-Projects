package Day2.Lab3.ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Countries {
    private int Cid;
    private String Name,Continent;
    
    public Countries (int Cid, String Name, String Continent) {
        this.Cid = Cid;
        this.Name = Name;
        this.Continent = Continent;
    }
    
    public int getCid() {
        return Cid;
    }
    public void setCid(int Cid) {
        this.Cid = Cid;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getContinent() {
        return Continent;
    }
    public void setContinent(String Continent) {
        this.Continent = Continent;
    }
    public String toString() {
        return Name;
    }

    public static List<Countries> readCountriesFile (String path) throws IOException {
        List<Countries> countries = new LinkedList<>();
        BufferedReader br;
        br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        do {
            line = br.readLine();
            if (line != null) {
                String[] attributes = line.split(",");
                Countries c = new Countries(0, null, null);
                if (!(attributes[0].isEmpty()))
                    c.setCid(Integer.parseInt(attributes[0]));
                c.setName(attributes[1]);
                c.setContinent(attributes[2]);
                countries.add(c);
            }
        } while (line != null);
        br.close();
        return countries;
    }

}
