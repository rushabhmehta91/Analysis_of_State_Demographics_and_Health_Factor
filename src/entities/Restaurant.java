package entities;

/**
 *
 * @Filename Restaurant.java
 *
 * @Version $Id: Restaurant.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */


/**
 * <p/>
 * Entity for Restaurant
 *
 * @author Harsimrat Parmar
 */
public class Restaurant {


    private String county_name;
    private String state;
    private String type;
    private int count;
    private int year;

    /**
     * constructor
     */
    public Restaurant() {
    }


    // Parametrized constructor
    public Restaurant(String county_name, String state, String type, int year) {
        this.county_name = county_name;
        this.state = state;
        this.type = type;
        this.year = year;
    }

    // Parametrized constructor
    public Restaurant(int count, String county_name, String state, String type, int year) {
        this.count = count;
        this.county_name = county_name;
        this.state = state;
        this.type = type;
        this.year = year;
    }

    /**
     * getter
     *
     * @return int
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter
     *
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * State getter
     *
     * @return String
     */
    public String getState() {
        return state;
    }

    /**
     * Setter
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * County Name
     *
     * @return String
     */
    public String getCounty_name() {
        return county_name;
    }

    /**
     * setter
     *
     * @param county_name
     */
    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    /**
     * Getter
     *
     * @return counter
     */
    public int getCount() {
        return count;
    }

    /**
     * Counter setter
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }


    /**
     * toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Restaurant{" +
                "count=" + count +
                ", county_name='" + county_name + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                '}';
    }
}

