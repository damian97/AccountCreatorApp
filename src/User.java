import java.util.Random;

public class User {
    private String fName, sName, nickName, pass, day, year;
    private int month, gender;

    public User() {

        Random rand = new Random();
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        char[] lowerCase = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] upperCase = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] specialCharacters = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '.', '?'};


        String[] firstNames = {"Adam", "Agnieszka", "Aleksandra", "Andrzej", "Aneta",
                "Barbara", "Bartosz", "Beata", "Bogdan", "Bozena",
                "Damian", "Danuta", "Dariusz", "Dawid", "Dorota",
                "Ewa", "Fabian", "Frantisek", "Grzegorz", "Halina",
                "Iga", "Iwona", "Jakub", "Jan", "Joanna",
                "Jozef", "Kamil", "Karol", "Katarzyna", "Krzysztof",
                "Krystyna", "Lech", "Ludwik", "Lukasz", "Marek",
                "Mariusz", "Marta", "Mateusz", "Michal", "Natalia"};

        String[] secondNames = {"Nowak", "Kowalski", "Wisniewski", "Dabrowski", "Lewandowski", "Wojcik", "Kaminski", "Kowalczyk", "Zielinski", "Szymanski", "Wozniak", "Kaczmarek", "Krol", "Czarnecki", "Mazur", "Kubiak", "Wieczorek", "Piotrowski", "Pawlowski", "Kwiatkowski", "Krawczyk", "Nowakowski", "Dudek", "Adamczyk", "Sikora", "Tomaszewski", "Pietrzak", "Zajac", "Pawlik", "Michalski", "Szewczyk", "Wrobel", "Wasilewski", "Mroz", "Jankowski", "Baran", "Sadowski", "Zawadzki", "Olszewski", "Chmielewski"};


        this.fName = firstNames[rand.nextInt(firstNames.length)];
        this.sName = secondNames[rand.nextInt(secondNames.length)];
        this.nickName = String.valueOf(rand.nextInt(800) + 250);
        this.pass = this.sName + numbers[rand.nextInt(numbers.length)] + numbers[rand.nextInt(numbers.length)] + upperCase[rand.nextInt(upperCase.length)] + upperCase[rand.nextInt(upperCase.length)] + numbers[rand.nextInt(numbers.length)] + lowerCase[rand.nextInt(lowerCase.length)];
        this.day = String.valueOf(rand.nextInt(25) + 1);
        this.month = rand.nextInt(12) + 1;
        int lowerBound = 1965;
        int upperBound = 2007;
        int randomNum = rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;   //zakres 1965-2007
        this.year = String.valueOf(randomNum);
        setGender();
    }

    public User(String fName, String sName, String nickName, String pass, String day, int month, String year, int gender) {
        this.fName = fName;
        this.sName = sName;
        this.nickName = nickName;
        this.pass = pass;
        this.day = day;
        this.month = month;
        this.year = year;
        this.gender = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getNickName() {
        return fName.toLowerCase() + "." + sName.toLowerCase() + nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getGender() {
        return gender;
    }

    public void setGender() {
        if (fName.charAt(fName.length()-1) == 'a') {
            this.gender = 2;
        } else {
            this.gender = 1;
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", nickName='" + getNickName() + '\'' +
                ", pass='" + pass + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", gender=" + gender +
                '}';
    }

    public void printUser() {
        System.out.println(this);
    }
}
