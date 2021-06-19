package Day2.Lab3.ex2;

import Day1.Lab2.Pyramid;
import Day1.Lab2.PyramidCSVDAO;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

    public static Double getMedian (List<Double> list) {
        Double median;
        if (list.size() % 2 == 0) {
            median = list.stream().skip(list.size() / 2 - 1).limit(2)
                    .mapToDouble(Double::doubleValue).average().getAsDouble();
            return median;
        } else {
            median = list.stream().skip(list.size() / 2).findFirst().get();
            return median;
        }
    }

    public static List<Double> getHeight() throws IOException {
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        List<Pyramid> pyramids = null;
        pyramids = pDAO.readPyramidsFromCSV("src/main/resources/pyramids.csv");
        List<Double> listOfHeights = pyramids.stream().filter(i -> i.getHeight() > 0)
                .map(Pyramid::getHeight).sorted().collect(Collectors.toList());
       return  listOfHeights;
    }

    public static void main(String[] args) throws IOException {
        Double quartile1, quratile3;
        List<Double> heights = getHeight();
        Double median = getMedian(heights);

        if (heights.size() % 2 == 0) {
            quartile1 = getMedian(heights.subList(0, heights.size()/2));
            quratile3 = getMedian(heights.subList(heights.size()/2, heights.size()));
        } else {
            quartile1 = getMedian(heights.subList(0, heights.size()/2));
            quratile3 = getMedian(heights.subList(heights.size()/2+1, heights.size()));
        }
        System.out.println("The Median= " + median + "\n"
                + "The First Quartile= " + quartile1 + "\n" + "The Third Quartile= " + quratile3);
    }
}

