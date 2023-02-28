package com.clinicapp.connector.dbPatient;

import com.clinicapp.classes.Patient;
import com.clinicapp.connector.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;

public class GetPatients extends DatabaseConnector {
    public static ArrayList<Patient> get(){
        // shows all patients in database
        ArrayList<Patient> patients = new ArrayList<Patient>();
        try {

            String sql = "select * from pacjenci";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("imie");
                String surname = rs.getString("nazwisko");
                String phone = rs.getString("nr_telefonu");
                String pesel = rs.getString("pesel");
                String height = rs.getString("wzrost");
                String weight = rs.getString("waga");
                String addId = rs.getString("id_adresu");
                Patient pat = new Patient(name, surname, phone, pesel, weight, height, addId);
                patients.add(pat);
            }
            rs.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }
}
