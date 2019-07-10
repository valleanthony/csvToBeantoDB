package com.example.ms3;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public String getNameTwo() {
        return nameTwo;
    }

    public void setNameTwo(String nameTwo) {
        this.nameTwo = nameTwo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getCardProcessor() {
        return cardProcessor;
    }

    public void setCardProcessor(String cardProcessor) {
        this.cardProcessor = cardProcessor;
    }

    public String getCashValue() {
        return cashValue;
    }

    public void setCashValue(String cashValue) {
        this.cashValue = cashValue;
    }

    public String getBooleanOne() {
        return booleanOne;
    }

    public void setBooleanOne(String booleanOne) {
        this.booleanOne = booleanOne;
    }

    public String getBooleanTwo() {
        return booleanTwo;
    }

    public void setBooleanTwo(String booleanTwo) {
        this.booleanTwo = booleanTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Data() {
    }


}
