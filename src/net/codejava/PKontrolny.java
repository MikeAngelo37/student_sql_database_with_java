package net.codejava;

public class PKontrolny {

    String komenda;

    public PKontrolny(String pol)
    {
        this.komenda = pol;
    }

    // Edycja studenta
    public String szablonEdytujS(int opcja, String zmiana, String id)
    {// opcja - co edytowac, zmiana - wprowadzane dane, id - id studenta
        switch(opcja){
            case 1:
                komenda = "UPDATE studenci SET imie='"+zmiana+"' WHERE id_studenta='"+id+"';";
                return komenda;
            case 2:
                komenda = "UPDATE studenci SET nazwisko='"+zmiana+"' WHERE id_studenta='"+id+"';";
                return komenda;
            case 3:
                komenda = "UPDATE studenci SET stan_studenta='"+zmiana+"' WHERE id_studenta='"+id+"';";
                return komenda;
            case 4:
                komenda = "UPDATE studenci SET rok_urodzenia='"+zmiana+"' WHERE id_studenta='"+id+"';";
                return komenda;
            case 5:
                komenda = "UPDATE studenci SET ilosc_punktow='"+zmiana+"' WHERE id_studenta='"+id+"';";
                return komenda;
            default:
                komenda = "Error";
                return komenda;
        }
    }

    // Edycja grupy
    public String szablonEdytujG(int opcja, String zmiana, String id)
    {
        switch(opcja){
            case 1:
                komenda = "UPDATE grupy SET nazwa_grupy='"+zmiana+"' WHERE id='"+id+"';";
                return komenda;
            case 2:
                komenda = "UPDATE grupy SET max_il_studentow='"+zmiana+"' WHERE id='"+id+"';";
                return komenda;
            default:
                komenda = "Error";
                return komenda;
        }
    }

    // Usuwanie studenta
    public String szablonUsunS(String id)
    {
        komenda = "DELETE FROM studenci WHERE id_studenta='"+id+"';";
        return komenda;
    }

    // Usuwanie grupy
    public String szablonUsunG(String id)
    {
        komenda = "DELETE FROM grupy WHERE id='"+id+"';";
        return komenda;
    }

    // Wyszukanie studenta
    public String szablonSzukajS(String nazw)
    {
        komenda = "SELECT * FROM studenci WHERE nazwisko='"+nazw+"';";
        return komenda;
    }
}


// <> Wyszukanie <>
// SELECT * FROM studenci where nazwisko='';

// <> Edycja studenta <>
// UPDATE studenci SET imie='' WHERE id_studenta='';
// UPDATE studenci SET nazwisko='' WHERE id_studenta='';
// UPDATE studenci SET stan_studenta='' WHERE id_studenta='';
// UPDATE studenci SET rok_urodzenia='' WHERE id_studenta='';
// UPDATE studenci SET ilosc_punktow='' WHERE id_studenta='';

// <> Usuwanie studenta <>
// DELETE FROM studenci WHERE id_studenta='';