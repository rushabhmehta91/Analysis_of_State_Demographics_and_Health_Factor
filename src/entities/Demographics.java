package entities;

/**
 *
 * @Filename Demographics.java
 *
 * @Version $Id: Demographics.java,v 1.0 2014/02/25 09:23:00 $
 *
 * @Revisions
 *     Initial Revision
 */


/**
 * <p/>
 * Entity for Demographics
 *
 * @author Harsimrat Parmar
 */
public class Demographics {

    private String county_name;
    private String state;
    private String year;
    private double African_American;
    private double American_Indian_Alaskan_Native;
    private double asian;
    private double hispanic;
    private double pacific_highlander;
    private double _18_younger;
    private double senior_citizen;

    /**
     * Constructor
     */
    public Demographics() {

    }

    // Parametrized constructor
    public Demographics(String county_name, String state, String year, double African_American, double American_Indian_Alaskan_Native,
                        double asian, double hispanic, double pacific_highlander, double _18_younger, double senior_citizen) {

        this.county_name = county_name;
        this.state = state;
        this.year = year;
        this.African_American = African_American;
        this.American_Indian_Alaskan_Native = American_Indian_Alaskan_Native;
        this.asian = asian;
        this.hispanic = hispanic;
        this.pacific_highlander = pacific_highlander;
        this._18_younger = _18_younger;
        this.senior_citizen = senior_citizen;
    }

    // Parametrized constructor
    public Demographics(String county_name, String state, String year) {

        this.county_name = county_name;
        this.state = state;
        this.year = year;
    }

    /**
     *
     * @return
     */
    public double get_18_younger() {
        return _18_younger;
    }

    /**
     *
     * @param _18_younger
     */
    public void set_18_younger(double _18_younger) {
        this._18_younger = _18_younger;
    }

    /**
     * 
     * @return
     */
    public double getAfrican_American() {
        return African_American;
    }

    /**
     * 
     * @param african_American
     */
    public void setAfrican_American(double african_American) {
        African_American = african_American;
    }

    /**
     * 
     * @return
     */
    public double getAmerican_Indian_Alaskan_Native() {
        return American_Indian_Alaskan_Native;
    }

    /**
     * 
     * @param american_Indian_Alaskan_Native
     */
    public void setAmerican_Indian_Alaskan_Native(double american_Indian_Alaskan_Native) {
        American_Indian_Alaskan_Native = american_Indian_Alaskan_Native;
    }

    /**
     * 
     * @return
     */
    public double getAsian() {
        return asian;
    }

    /**
     * 
     * @param asian
     */
    public void setAsian(double asian) {
        this.asian = asian;
    }

    /**
     *
     * @return
     */
    public String getCounty_name() {
        return county_name;
    }

    /**
     *
     * @param county_name
     */
    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    /**
     *
     * @return
     */
    public double getHispanic() {
        return hispanic;
    }

    /**
     *
     * @param hispanic
     */
    public void setHispanic(double hispanic) {
        this.hispanic = hispanic;
    }

    /**
     *
     * @return
     */
    public double getPacific_highlander() {
        return pacific_highlander;
    }

    /**
     *
     * @param pacific_highlander
     */
    public void setPacific_highlander(double pacific_highlander) {
        this.pacific_highlander = pacific_highlander;
    }

    /**
     *
     * @return
     */
    public double getSenior_citizen() {
        return senior_citizen;
    }

    /**
     *
     * @param senior_citizen
     */
    public void setSenior_citizen(double senior_citizen) {
        this.senior_citizen = senior_citizen;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Demographics{" +
                "_18_younger=" + _18_younger +
                ", county_name='" + county_name + '\'' +
                ", state='" + state + '\'' +
                ", year='" + year + '\'' +
                ", African_American=" + African_American +
                ", American_Indian_Alaskan_Native=" + American_Indian_Alaskan_Native +
                ", asian=" + asian +
                ", hispanic=" + hispanic +
                ", pacific_highlander=" + pacific_highlander +
                ", senior_citizen=" + senior_citizen +
                '}';
    }
}
