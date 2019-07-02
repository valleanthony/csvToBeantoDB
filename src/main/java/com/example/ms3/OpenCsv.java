package com.example.ms3;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class OpenCsv {


    @Autowired
    DataRepo dataRepo;


    private static final String myCSV = "./falseData.csv";

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
        return mybool;
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
        ArrayList<Data> badData = new ArrayList<Data>();

        //Counters
        int dataid = 1;
        int badcounter = 0;

        boolean tempOne = false;


        while (csvUserIterator.hasNext()) {
            Data data = csvUserIterator.next();
            System.out.println(nullValueChecker(data));
            tempOne = nullValueChecker(data); // This will check if any of the objects have variables that are null.
            if (tempOne == true) {
                badcounter++;
                badData.add(data);
                System.out.println(badcounter);
                System.out.println("Line of bad data added to arraylist ID: " + data.getId());

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
        
        return goodData;
    }
}









