package Day2.Lab3.ex1;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainClass {

    public static void main(String[] args) throws IOException {
        // read cities file
        List<Cities> cities = new ArrayList<>();
        cities = Cities.readCitiesFile("/Users/saraelaraby/Documents/ITI-AI/JavaProjects/untitled/src/main/resources/Cities.CSV");
        // read countries file
        List<Countries> countries = new ArrayList<>();
        countries = Countries.readCountriesFile("/Users/saraelaraby/Documents/ITI-AI/JavaProjects/untitled/src/main/resources/Countries.CSV");

        Map<Countries, List<Cities>> CountryMap = new HashMap<>();
        for (Countries co : countries) {
            List<Cities> citiesList = new LinkedList<>();
            for (Cities ci : cities) {
                if (co.getCid() == (ci.getCid())) {
                    citiesList.add(ci);
                }
            }
            CountryMap.put(co, citiesList);
        }
        //System.out.println("======================= The map of cities ============================= ");
        //System.out.println(CountryMap);
        //System.out.println();
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("================= The highest population city of each country =====================");
        cities.stream().collect(Collectors.groupingBy(city -> city.getCid(),Collectors.maxBy((i1,i2)->
                (i1.getPopulation()>i2.getPopulation())?1:-1)))
                .forEach((Cid,maxCity)-> System.out.println("Country id : " + Cid + "\t" +
                        "Highest population city is : " + maxCity.get()));
        System.out.println();
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("================ The highest population city by continent =====================");
        cities.stream().collect(Collectors.groupingBy(city -> city.getCid(),Collectors.maxBy((i1,i2)->
                (i1.getPopulation()>i2.getPopulation())?1:-1)));

        System.out.println();
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("====================== The highest population capital =============================");
        Double maxPopulationCap = cities.stream().filter(city -> city.getCapital())
                .mapToDouble(Cities::getPopulation).max().getAsDouble();
        cities.stream().filter(city -> city.getCapital() && city.getPopulation().equals(maxPopulationCap))
                .forEach(city -> System.out.print("The highest population capital is : " + city.getName()));
    }
}