package Day3;

import tech.tablesaw.api.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Titanic {

    public static void main(String[] args) throws IOException {
        Table titanicData;
        String dataPath = "/Users/saraelaraby/Documents/ITI-AI/JavaProjects/untitled/src/main/resources/titanic.csv";

        /*System.out.println("------------- Data Analysis using joinery -------------");
        //Load and print data
        DataFrame< Object > df=DataFrame.readCsv(dataPath);
        System.out.println(df.toString());
        //print summary about data
        System.out.println(df.describe().toString());
        System.out.println("=============================================================================");*/

        System.out.println("------------- Data Analysis using TableSaw -------------");
        //Load and print data
        titanicData = Table.read().csv(dataPath);
        System.out.println(titanicData.toString());
        //getting the Structure of the data
        System.out.println(titanicData.structure().toString());
        //getting Data summery
        System.in.read();
        String summary=titanicData.summary().toString();
        System.out.println(summary);
        System.in.read();

        // Adding date Column
        int rowCount = titanicData.rowCount();
        List< LocalDate > dateList = new ArrayList< LocalDate >();
        for (int i=0;i< rowCount; i++) {
        dateList.add(LocalDate.of(2021,3,i%31==0?1:i%31));
        }
        DateColumn dateColumn = DateColumn.create("Fake Date",dateList);
        titanicData.insertColumn(titanicData.columnCount(),dateColumn);
        System.out.println(titanicData.toString());
        System.out.println("=============================================================================");

        //Merge two Dataframes
        titanicData.removeColumns("Fake Date");
        System.out.println(titanicData.toString());

        int rowCount1=titanicData.rowCount();
        int[] col=new int[rowCount1];
        for (int i=1;i<=rowCount1;i++) {
            col[i-1]=i;
        }
        IntColumn fcol= IntColumn.create("Fake Id",col);
        Table tempTable = Table.create("Temp Table",fcol,dateColumn);
        System.out.println("------------- The table we want to merge with Titanic table ------------");
        System.out.println(tempTable.toString());
        System.out.println("-------------------------- After merging the tables ----------------------");
        titanicData.concat(tempTable);
        System.out.println(titanicData);;
        System.out.println("===================================================================");

        //Joining two Dataframes
        System.out.println("------------------------- After joining two Tables -----------------------------");
        titanicData.removeColumns("Fake Date");
        System.out.println(titanicData.toString());
        Table newTablesaw = titanicData.joinOn("Fake Id").inner(tempTable);
        System.out.println(newTablesaw);
        System.out.println("==============================================================================");

    }
}






