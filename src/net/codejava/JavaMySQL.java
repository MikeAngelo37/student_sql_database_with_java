package net.codejava;

import java.sql.*;
import java.util.Scanner;

public class JavaMySQL {
    public static void main(String[] args) {
        System.out.println("Start");
        String url = "jdbc:mysql://localhost:3306/mlb4";
        String username = "Mlb4";
        String password = "1234";

        try{
            Connection connection = DriverManager.getConnection(url, username, password);

            // Panel kontrolny
            Scanner scanner = new Scanner(System.in);
            int opcjaInt = 1;

            String op0 = "SELECT * FROM studenci";
            String op1 = "SELECT * FROM `studenci` ORDER BY `studenci`.`nazwisko` ASC ";
            String op2 = "SELECT * FROM `studenci` ORDER BY `studenci`.`ilosc_punktow` DESC ";

            //System.out.println("Wybierz operacje (inna liczba wypisze dane w sposob domyslny):");
            //System.out.println("1. Sortuj po nazwisku");
            //System.out.println("2. Sortuj po liczbie punkow");

            String sql;
            //opcjaInt = scanner.nextInt();
            Statement statement = connection.createStatement();
            ResultSet result;
/*
            // Stare menu

            switch(opcjaInt){
                case 1:
                    result = statement.executeQuery(op1);
                    break;
                case 2:
                    result = statement.executeQuery(op2);
                    break;
                default:
                    result = statement.executeQuery(op0);
                    break;
            }


            //String sql = "SELECT * FROM studenci";
            //String sql = "SELECT * FROM `studenci` ORDER BY `studenci`.`nazwisko` ASC ";
            //Statement statement = connection.createStatement();
            //ResultSet result = statement.executeQuery(sql);

            int count = 0;

            System.out.println("\n<><> studenci <><>");
            while (result.next()) {
                String imie = result.getString("imie");
                String nazwisko = result.getString("nazwisko");
                //int stan_studenta; // Work in progress...
                int rok_urodzenia = result.getInt("rok_urodzenia");
                float ilosc_punktow = result.getFloat("ilosc_punktow");
                count++;

                System.out.println("<>\t"+imie+" "+nazwisko);
                System.out.println("\t"+rok_urodzenia);
                System.out.println("\tIlosc punktow: "+ilosc_punktow);
                System.out.println(" ");
            }
*/
            // Nowe menu
            PKontrolny szablon = new PKontrolny("debug");
            menuSzablon tekst = new menuSzablon(1);

            while(opcjaInt!=0)
            {
                //System.out.println("Menu glowne:");
                //System.out.println("1 - studenci");
                //System.out.println("2 - grupy");
                //System.out.println("3 - wyszukaj studenta");
                //System.out.println("0 - wyjscie");

                tekst.mainMenu();
                opcjaInt = scanner.nextInt();

                String id;
                int opt;
                String zmiana;
                int count;

                switch(opcjaInt){
                    case 1:
                        sql = "SELECT * FROM studenci";
                        result = statement.executeQuery(sql);

                        count = 0;
                        System.out.println("\n<><> studenci <><>");
                        while (result.next()) {
                            String imie = result.getString("imie");
                            String nazwisko = result.getString("nazwisko");
                            //int stan_studenta; // Work in progress...
                            int rok_urodzenia = result.getInt("rok_urodzenia");
                            float ilosc_punktow = result.getFloat("ilosc_punktow");
                            count++;

                            System.out.println("<"+count+">\t"+imie+" "+nazwisko);
                            System.out.println("\t"+rok_urodzenia);
                            System.out.println("\tIlosc punktow: "+ilosc_punktow);
                            System.out.println(" ");
                        }

                        //System.out.println("-studenci-");
                        //System.out.println("1 - edycja");
                        //System.out.println("2 - usuwanie");
                        //System.out.println("inna - powrot");

                        tekst.basicMenu("studenci");
                        opcjaInt = scanner.nextInt();

                        switch(opcjaInt){
                            case 1:
                                System.out.println("Podaj id studenta:");
                                id = scanner.nextLine();
                                id = scanner.nextLine();
                                System.out.println("Co chcesz zmodyfikowac?");
                                System.out.println("1 - imie, 2 - nazwisko, 3 - stan studenta, 4 - rok urodzenia, 5 - punkty:");
                                opt = scanner.nextInt();
                                System.out.println("Wprowadz zmiane:");
                                zmiana = scanner.nextLine();
                                zmiana = scanner.nextLine();

                                sql = szablon.szablonEdytujS(opt, zmiana, id);
                                System.out.println("OUT: \t"+sql);  // Do debugowania
                                statement.executeUpdate(sql);
                                break;
                            case 2:
                                System.out.println("Podaj id studenta:");
                                id = scanner.nextLine();
                                System.out.println("Czy napewno chcesz usunac studenta? (wcisnij '1')");
                                opt = scanner.nextInt();
                                if(opt==1)
                                {
                                    sql = szablon.szablonUsunS(id);
                                    System.out.println("OUT: \t"+sql);  // Do debugowania
                                    statement.executeUpdate(sql);
                                }

                                break;
                            default:
                                break;
                        }
                        break;

                    case 2:
                        sql = "SELECT * FROM grupy";
                        result = statement.executeQuery(sql);

                        count = 0;
                        System.out.println("\n<><> grupy <><>");
                        while (result.next()) {
                            String nazwa_grupy = result.getString("nazwa_grupy");
                            Integer maksymalna_il_st = result.getInt("max_il_studentow");
                            count++;

                            System.out.println("<"+count+">\t"+nazwa_grupy);
                            System.out.println("\tMaksymalna liczba studentow: "+maksymalna_il_st);
                            System.out.println(" ");
                        }

                        tekst.basicMenu("-grupy-");
                        opcjaInt = scanner.nextInt();

                        switch(opcjaInt){
                            case 1:
                                System.out.println("Podaj id grupy:");
                                id = scanner.nextLine();
                                id = scanner.nextLine();
                                System.out.println("Co chcesz zmodyfikowac?");
                                System.out.println("1 - nazwe, 2 - max liczbe studentow:");
                                opt = scanner.nextInt();
                                System.out.println("Wprowadz zmiane:");
                                zmiana = scanner.nextLine();
                                zmiana = scanner.nextLine();

                                sql = szablon.szablonEdytujG(opt, zmiana, id);
                                System.out.println("OUT: \t"+sql);  // Do debugowania
                                statement.executeUpdate(sql);
                                break;
                            case 2:
                                System.out.println("Podaj id grupy:");
                                id = scanner.nextLine();
                                System.out.println("Czy napewno chcesz usunac grupe? (wcisnij '1')");
                                opt = scanner.nextInt();
                                if(opt==1)
                                {
                                    sql = szablon.szablonUsunG(id);
                                    System.out.println("OUT: \t"+sql);  // Do debugowania
                                    statement.executeUpdate(sql);
                                }

                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Podaj nazwisko szukanego studenta:");
                        id = scanner.nextLine();
                        id = scanner.nextLine();

                        sql = szablon.szablonSzukajS(id);
                        System.out.println("OUT: \t"+sql);  // Do debugowania

                        result = statement.executeQuery(sql);

                        count = 0;
                        System.out.println("\n<><> wyniki <><>");
                        while (result.next()) {
                            String imie = result.getString("imie");
                            String nazwisko = result.getString("nazwisko");
                            //int stan_studenta; // Work in progress...
                            int rok_urodzenia = result.getInt("rok_urodzenia");
                            float ilosc_punktow = result.getFloat("ilosc_punktow");
                            count++;

                            System.out.println("<"+count+">\t"+imie+" "+nazwisko);
                            System.out.println("\t"+rok_urodzenia);
                            System.out.println("\tIlosc punktow: "+ilosc_punktow);
                            System.out.println(" ");
                        }

                        break;
                    case 0:
                        System.out.println("-Zamykanie-");
                        break;
                    default:
                        System.out.println("-Nieznana komenda-");
                        break;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error! Who put bugs in my code?");
            e.printStackTrace();
        }
    }
}





// PAOiM_spring
