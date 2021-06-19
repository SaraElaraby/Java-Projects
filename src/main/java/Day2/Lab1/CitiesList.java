package Day2.Lab1;

import java.io.*;
import java.util.*;

public class CitiesList {

    public static void main(String[] args) throws IOException {
        List<Cities> cities = new ArrayList<>();
        List<Countries> countries = new ArrayList<>();
        BufferedReader brCi;
        BufferedReader brCo;

        brCi = new BufferedReader(new FileReader("/Users/saraelaraby/Documents/ITI-AI/JavaProjects/untitled/src/main/resources/Cities.CSV"));
        String line = brCi.readLine();
        do {
            line = brCi.readLine();
            if (line != null) {
                String[] attributes = line.split(",");
                Cities c = new Cities(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5]);
                cities.add(c);
            }
        } while (line != null);
        brCi.close();
        System.out.println();
        System.out.println("The List of Cities : ");
        System.out.println(cities);
        System.out.println("-----------------------------------------------");

        brCo = new BufferedReader(new FileReader("/Users/saraelaraby/Documents/ITI-AI/JavaProjects/untitled/src/main/resources/Countries.CSV"));
        String line1 = brCo.readLine();
        do {
            line1 = brCo.readLine();
            if (line1 != null) {
                String[] attributes = line1.split(",");
                Countries c = new Countries(attributes[0], attributes[1], attributes[2]);
                countries.add(c);
            }
        } while (line1 != null);
        brCo.close();
        System.out.println("The List of Countries : ");
        System.out.println(countries);
        System.out.println("-------------------------------------------------------------------------------------------");

//--------------------------- First Task (Mapping) ---------------------------//

        Map<String, List<Cities>> CountryMap = new HashMap<>();
        for (Countries c1 : countries) {
            List<Cities> cityList = new LinkedList<>();
            for (Cities c2 : cities) {
                if (c1.getCid().equals(c2.getCid())) {
                    cityList.add(c2);
                }
            }
            CountryMap.put(c1.getCid(), cityList);
        }
        System.out.print("The map of cities: ");
        System.out.println(CountryMap);
        System.out.println("--------------------------------------------------------------------------------------");


//-------------------------- Second Task (Sorting) ----------------------------//

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Cid : ");
        String cc = input.nextLine();
        CountryMap.get(cc).sort((x1, x2) -> {
            if (Integer.parseInt(x1.getPopulation()) < Integer.parseInt(x2.getPopulation())) //descending
                return 1;
            return -1;
        });
        input.close();
        System.out.println(CountryMap.get(cc));
        System.out.println("------------------------------------------------------------------------------------------");

    }
}

