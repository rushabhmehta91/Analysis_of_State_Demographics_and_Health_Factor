package entities;

/**
 *
 * @Filename Stores.java
 *
 * @Version $Id: Stores.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */


/**
 * <p/>
 * Entity for Stores
 *
 * @author Harsimrat Parmar
 */
public class Stores {


    private String county_name;
    private String state;
    private String type;
    private int count;
    private int year;

    /**
     * Parameters
     */
    public Stores() {
    }


    // Parametrized constructor
    public Stores(String county_name, String state, String type, int year) {
        this.county_name = county_name;
        this.state = state;
        this.type = type;
        this.year = year;
    }

    // Parametrized constructor
    public Stores(int count, String county_name, String state, String type, int year) {
        this.count = count;
        this.county_name = county_name;
        this.state = state;
        this.type = type;
        this.year = year;
    }

    /**
     * getter
     * 
     * @return  int
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
     * @return getType
     */
    public String getType() {
        return type;
    }

    /**
     * Setter
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * String
     *
     * @return String
     */
    public String getState() {
        return state;
    }

    /**
     * setter
     * 
     * @param state
     */
    public void setState(String state) {
        this.state = state;
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
     * setter
     * 
     * @param county_name
     */
    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    /**
     * getter
     * 
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * setter
     * 
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }


    /**
     * toString
     * 
     * @return
     */
    @Override
    public String toString() {
        return "Stores{" +
                "count=" + count +
                ", county_name='" + county_name + '\'' +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                '}';
    }
}
