package sample.models;

public class CurrencyList {

    public String currencyName="";
    public int id=0;

    public CurrencyList(String currencyName, int id) {
        this.currencyName = currencyName;
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return currencyName;
    }
}
