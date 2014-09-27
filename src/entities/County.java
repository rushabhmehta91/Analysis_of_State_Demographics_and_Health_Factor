package entities;

/**
 *
 * @Filename County.java
 *
 * @Version $Id: County.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */


/**
 * <p/>
 * Entity for County
 *
 * @author Harsimrat Parmar
 */
public class County {

    private String county_name;
    private String state;
    private int year;
    double poverty;
    private int population;
    private double per_capita_income;
    private int total_no_of_stores;
    private int total_no_of_restaurants;
    private double num_of_death;
    private double num_of_birth;


    // Parametrized constructor
    public County(String county_name, String state, int year) {

        this.county_name = county_name;
        this.state = state;
        this.year = year;
    }


    // Parametrized constructor
    public County(String county_name, String state, int year, double poverty, int population, double per_capita_income,
                  int total_no_of_stores, int total_no_of_restaurants, double num_of_death, double num_of_birth) {

        this.poverty = poverty;
        this.population = population;
        this.per_capita_income = per_capita_income;
        this.total_no_of_stores = total_no_of_stores;
        this.total_no_of_restaurants = total_no_of_restaurants;
        this.num_of_death = num_of_death;
        this.num_of_birth = num_of_birth;
    }

    /**
     * getter
     *
     * @return String
     */
    public String getCounty_name() {
        return county_name;
    }

    /**
     * @param county_name
     */
    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    /**
     * getter
     *
     * @return double
     */
    public double getNum_of_birth() {
        return num_of_birth;
    }

    /**
     * setter
     *
     * @param num_of_birth
     */
    public void setNum_of_birth(double num_of_birth) {
        this.num_of_birth = num_of_birth;
    }

    /**
     * double
     *
     * @return double
     */
    public double getNum_of_death() {
        return num_of_death;
    }

    /**
     * num_of_death
     *
     * @param num_of_death
     */
    public void setNum_of_death(double num_of_death) {
        this.num_of_death = num_of_death;
    }

    /**
     * per capita
     *
     * @return double
     */
    public double getPer_capita_income() {
        return per_capita_income;
    }

    /**
     * @param per_capita_income
     */
    public void setPer_capita_income(double per_capita_income) {
        this.per_capita_income = per_capita_income;
    }

    /**
     * getter
     *
     * @return int
     */
    public int getPopulation() {
        return population;
    }

    /**
     * setter
     *
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * getter
     *
     * @return double
     */
    public double getPoverty() {
        return poverty;
    }

    /**
     * setter
     *
     * @param poverty
     */
    public void setPoverty(double poverty) {
        this.poverty = poverty;
    }

    /**
     * getstate
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * state
     * 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * gettotalrest number
     * @return
     */
    public int getTotal_no_of_restaurants() {
        return total_no_of_restaurants;
    }

    /**
     * 
     * @param total_no_of_restaurants
     */
    public void setTotal_no_of_restaurants(int total_no_of_restaurants) {
        this.total_no_of_restaurants = total_no_of_restaurants;
    }

    /**
     * getter
     * 
     * @return int
     */
    public int getTotal_no_of_stores() {
        return total_no_of_stores;
    }

    /**
     * 
     * @param total_no_of_stores
     */
    public void setTotal_no_of_stores(int total_no_of_stores) {
        this.total_no_of_stores = total_no_of_stores;
    }

    /**
     * 
     * @return int
     */
    public int getYear() {
        return year;
    }

    /**
     * 
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 
     * @return string
     */
    @Override
    public String toString() {
        return "County{" +
                "county_name='" + county_name + '\'' +
                ", state='" + state + '\'' +
                ", year=" + year +
                ", poverty=" + poverty +
                ", population=" + population +
                ", per_capita_income=" + per_capita_income +
                ", total_no_of_stores=" + total_no_of_stores +
                ", total_no_of_restaurants=" + total_no_of_restaurants +
                ", num_of_death=" + num_of_death +
                ", num_of_birth=" + num_of_birth +
                '}';
    }
}
