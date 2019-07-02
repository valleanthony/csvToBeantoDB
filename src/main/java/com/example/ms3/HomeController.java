package com.example.ms3;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    DataRepo dataRepo;

    LoggingController logme = new LoggingController();


    @RequestMapping("/")
    public String adminView(){

        OpenCsv openCsv = new OpenCsv();

        ArrayList<Data> userData;

        userData = openCsv.CsvReader();

        for (Data user: userData) {
            dataRepo.save(user);
            System.out.println("New User saved " + user.getId());
        }
        //Logging Section
        String goodNumber= Integer.toString(userData.size()-1);
        logme.logger.info("Number of records successful "+ goodNumber);

        ArrayList<Data> badData = openCsv.writeInBadCSV();
        String badNumber=Integer.toString(badData.size());
        logme.logger.info("Number of Failed Records "+ badNumber);

        String alldata = openCsv.sendBackDataPoint();
        logme.logger.info("Number of All Records "+ alldata);



        return "index";
    }



}
