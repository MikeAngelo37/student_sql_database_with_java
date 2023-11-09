package net.codejava;

public class menuSzablon {

    Integer pom;

    public menuSzablon(int num)
    {
        this.pom = num;
    }

    void mainMenu()
    {
        System.out.println("");
        System.out.println("Menu glowne:");
        System.out.println("1 - studenci");
        System.out.println("2 - grupy");
        System.out.println("3 - wyszukaj studenta");
        System.out.println("0 - wyjscie");
    }

    void basicMenu(String pom)
    {
        System.out.println("");
        System.out.println(pom);
        System.out.println("1 - edycja");
        System.out.println("2 - usuwanie");
        System.out.println("inna - powrot");
    }

    void deleteMenu()
    {
        System.out.println("Czy napewno? (Wcisnij 1 aby potwierdzic)");
    }
}
