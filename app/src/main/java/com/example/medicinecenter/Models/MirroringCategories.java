package com.example.medicinecenter.Models;

public class MirroringCategories {

    int id;

    String doc_name;
    String doc_surname;
    String WorkHours;
    String EntryTime;

    public MirroringCategories(String doc_name, String doc_surname, String workHours, String entryTime) {
        this.doc_name = doc_name;
        this.doc_surname = doc_surname;
        WorkHours = workHours;
        EntryTime = entryTime;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_surname() {
        return doc_surname;
    }

    public void setDoc_surname(String doc_surname) {
        this.doc_surname = doc_surname;
    }

    public String getWorkHours() {
        return WorkHours;
    }

    public void setWorkHours(String workHours) {
        WorkHours = workHours;
    }

    public String getEntryTime() {
        return EntryTime;
    }

    public void setEntryTime(String entryTime) {
        EntryTime = entryTime;
    }
}
