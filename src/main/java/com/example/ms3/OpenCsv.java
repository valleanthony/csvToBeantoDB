package com.example.ms3;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;



public class OpenCsv {

    private static final String myCSV = "./ms3interview.csv";
    private static final String badDataCSV ="./badData.csv";
    private  ArrayList<Data> badData = new ArrayList<Data>();
    private int alldataPoints=0;


    public boolean nullValueChecker(Data data) { /// Test to see if any data objects contains
        boolean mybool = false;

        if (data.getNameOne().equalsIgnoreCase("")) {
            mybool = true;
        } else if (data.getNameTwo().equalsIgnoreCase("")) {
            mybool = true;
        } else if (data.getEmail().equalsIgnoreCase("")) {
            mybool = true;
        } else if (data.getGender().equalsIgnoreCase("")) {
            mybool = true;
        } else if (data.getImageLink().equalsIgnoreCase("")) {
            mybool = true;
        } else if (data.getCardProcessor().equalsIgnoreCase("")) {
            mybool = true;
        } else if (data.getCashValue().equalsIgnoreCase("")) {
            mybool = true;
        } else if (data.getBooleanOne().equalsIgnoreCase("")) {
            mybool = true;
        } else if (data.getBooleanTwo().equalsIgnoreCase("")) {
            mybool = true;
        }
        else{
            mybool=false;
        }
        return mybool;
    }

    public ArrayList<Data> writeInBadCSV(Data data){

        badData.add(data);

        return badData;
    }

    public ArrayList<Data> writeInBadCSV(){


        return badData;
    }

    public void writeCSV(ArrayList<Data> bad){
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(badDataCSV));

            StatefulBeanToCsv ant = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                    .build();
            bad = writeInBadCSV();
            ant.write(bad);
            writer.close();
        }catch (Exception ee){
            ee.printStackTrace();
        }

            //csvWriter = new CSVWriter(new FileWriter("bad-data.csv"));

    }

    public ArrayList<Data> CsvReader() {
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(myCSV));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvToBean<Data> csvToBean = new CsvToBeanBuilder(reader)
                .withSkipLines(1)
                .withType(Data.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withFieldAsNull(CSVReaderNullFieldIndicator.NEITHER)
                .build();

        Iterator<Data> csvUserIterator = csvToBean.iterator();

        ArrayList<Data> goodData = new ArrayList<Data>();


        //Counters
        int dataid = 1;
        int badcounter = 0;


        boolean tempOne = false;


        while (csvUserIterator.hasNext()) {
            Data data = csvUserIterator.next();
                alldataPoints++;
            if (nullValueChecker(data)==true) {
                badcounter++;
                data.setId(badcounter);
                writeInBadCSV(data);
                System.out.println(badcounter);


            } else {
                data.setId(dataid++); //Generates an ID for the DB
                System.out.println("Data saved for the below:");
                System.out.println("Name One : " + data.getNameOne());
                System.out.println("Image link: " + data.getImageLink());
                System.out.println("Country : " + data.getCity());
                System.out.println("==========================");
                goodData.add(data); // will save all data to this arraylist
                //System.out.println(data);

            }
        }





        writeCSV(writeInBadCSV()); //Writes csv with all the bad data



        return goodData;
    }

    public String sendBackDataPoint(int alldataPoints){
       String allpoints= Integer.toString(alldataPoints);

        return allpoints;
    }

    public String sendBackDataPoint(){
        String allpoints= Integer.toString(alldataPoints);

        return allpoints;
    }


}









