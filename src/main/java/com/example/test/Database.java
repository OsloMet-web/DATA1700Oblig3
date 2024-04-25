package com.example.test;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Billett> alleBilletter = new ArrayList<>();
    public static void leggInn(Billett billett) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost: 3306/sys", "root", "StrongPassword.123");

        Statement statement = connection.createStatement();

        PreparedStatement st = connection.prepareStatement(
                "insert into kinobillett(id, navn, antall, film, telefonnr, epost)" +
                "values (?, ?, ?, ?, ?; ?)");

        ResultSet rs = statement.executeQuery("SELECT MAX(ID) FROM kinobillett");

        int latestID = 0;
        if (rs.next()) {
            latestID = rs.getInt(1);
        }

        rs.close();
        statement.close();

        st.setString(1, billett.getAntall());

        st.setString(2, billett.getFornavn());

        st.setString(3, billett.getEtternavn());

        st.setString(4, billett.getFilm());

        st.setString(5, billett.getTelefon());

        st.setString(6, billett.getEpost());

        st.executeUpdate();
    }

    public static List<Billett> hent() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost: 3306/sys", "root", "StrongPassword.123");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from kinobillett");



        while(resultSet.next()){
            Billett billett = new Billett("","","","","","");

            billett.setAntall(resultSet.getString(1));
            billett.setFilm(resultSet.getString(2));
            billett.setFornavn(resultSet.getString(3));
            billett.setEtternavn(resultSet.getString(4));
            billett.setTelefon(resultSet.getString(5));
            billett.setEpost(resultSet.getString(6));

            alleBilletter.add(billett);

        }



        return alleBilletter;
    }

    public static void slett() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost: 3306/sys", "root", "StrongPassword.123");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("delete from kinobillett");
    }



}
