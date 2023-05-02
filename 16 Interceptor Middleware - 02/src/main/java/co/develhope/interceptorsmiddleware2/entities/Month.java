package co.develhope.interceptorsmiddleware2.entities;


public class Month {
    private int monthNumber;
    private String italianName;
    private String englishName;
    private String germanName;

    public Month(){
    }

    public Month(int monthNumber,String italianName,String englishName,String germanName){
        this.monthNumber = monthNumber;
        this.italianName = italianName;
        this.englishName = englishName;
        this.germanName = germanName;
    }

    public int getMonthNumber(){
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber){
        this.monthNumber = monthNumber;
    }

    public String getItalianName(){
        return italianName;
    }

    public void setItalianName(String italianName){
        this.italianName = italianName;
    }

    public String getEnglishName(){
        return englishName;
    }

    public void setEnglishName(String englishName){
        this.englishName = englishName;
    }

    public String getGermanName(){
        return germanName;
    }

    public void setGermanName(String germanName){
        this.germanName = germanName;
    }
}

