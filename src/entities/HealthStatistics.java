package entities;

/**
 *
 * @Filename HealthStatistics.java
 *
 * @Version $Id: Demographics.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */


/**
 * <p/>
 * Entity for HealthStatistics
 *
 * @author Harsimrat Parmar
 */
public class HealthStatistics {

    private String county_name;
    private String state;
    private int year;
    private double obesity_rate;
    private double diabetes_rate;
    private double excercise_rate;
    private int no_of_hospitals;


    /**
     * Constructor
     */
    public HealthStatistics() {

    }

    // Parametrized constructor
    public HealthStatistics(String county_name, String state, int year) {
        this.county_name = county_name;
        this.state = state;
        this.year = year;
    }

    // Parametrized constructor
    public HealthStatistics(String county_name, double diabetes_rate, double excercise_rate, int no_of_hospitals, double obesity_rate, String state, int year) {
        this.county_name = county_name;
        this.diabetes_rate = diabetes_rate;
        this.excercise_rate = excercise_rate;
        this.no_of_hospitals = no_of_hospitals;
        this.obesity_rate = obesity_rate;
        this.state = state;
        this.year = year;
    }

    /**
     * getter
     *
     * @return
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
     * @return double
     */
    public double getDiabetes_rate() {
        return diabetes_rate;
    }

    /**
     * @param diabetes_rate
     */
    public void setDiabetes_rate(double diabetes_rate) {
        this.diabetes_rate = diabetes_rate;
    }

    /**
     * @return double
     */
    public double getExcercise_rate() {
        return excercise_rate;
    }

    /**
     * @param excercise_rate
     */
    public void setExcercise_rate(double excercise_rate) {
        this.excercise_rate = excercise_rate;
    }

    /**
     * @return int
     */
    public int getNo_of_hospitals() {
        return no_of_hospitals;
    }

    /**
     * @param no_of_hospitals
     */
    public void setNo_of_hospitals(int no_of_hospitals) {
        this.no_of_hospitals = no_of_hospitals;
    }

    /**
     * @return double
     */
    public double getObesity_rate() {
        return obesity_rate;
    }

    /**
     * obesity rate
     *
     * @param obesity_rate
     */
    public void setObesity_rate(double obesity_rate) {
        this.obesity_rate = obesity_rate;
    }

    /**
     * @return string
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return int
     */
    public int getYear() {
        return year;
    }

    /**
     * setter
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }


    /**
     * tostring
     *
     * @return string
     */
    @Override
    public String toString() {
        return "HealthStatistics{" +
                "county_name='" + county_name + '\'' +
                ", state='" + state + '\'' +
                ", year=" + year +
                ", obesity_rate=" + obesity_rate +
                ", diabetes_rate=" + diabetes_rate +
                ", excercise_rate=" + excercise_rate +
                ", no_of_hospitals=" + no_of_hospitals +
                '}';
    }
}
