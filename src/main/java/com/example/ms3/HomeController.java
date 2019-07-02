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



    @RequestMapping("/")
    public String adminView(){

        OpenCsv openCsv = new OpenCsv();

        ArrayList<Data> userData;

        userData = openCsv.CsvReader();

        for (Data user: userData) {
            dataRepo.save(user);
            System.out.println("New User saved " + user.getId());
        }






        return "index";
    }



}
