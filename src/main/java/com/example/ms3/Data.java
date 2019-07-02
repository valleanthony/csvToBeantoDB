package com.example.ms3;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor @ToString
@Entity
public class Data {

    @Id
    private int id;

    @CsvBindByPosition(position = 0)
    private String nameOne;
    @CsvBindByPosition(position = 1)
    private String nameTwo;
    @CsvBindByPosition(position = 2)
    private String email;
    @CsvBindByPosition(position = 3)
    private String gender;
    @CsvBindByPosition(position = 4)
    @Lob
    private String imageLink;
    @CsvBindByPosition(position = 5)
    private String cardProcessor;
    @CsvBindByPosition(position = 6)
    private String cashValue;
    @CsvBindByPosition(position = 7)
    private String booleanOne;
    @CsvBindByPosition(position = 8)
    private String booleanTwo;
    @CsvBindByPosition(position = 9)
    private String city;




}
