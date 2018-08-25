package cn.attackme.busappointment.model;

public class Station {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column station.id
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column station.name
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column station.description
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column station.disabled
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    private Boolean disabled;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column station.area
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    private Boolean area;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column station.id
     *
     * @return the value of station.id
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column station.id
     *
     * @param id the value for station.id
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column station.name
     *
     * @return the value of station.name
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column station.name
     *
     * @param name the value for station.name
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column station.description
     *
     * @return the value of station.description
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column station.description
     *
     * @param description the value for station.description
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column station.disabled
     *
     * @return the value of station.disabled
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column station.disabled
     *
     * @param disabled the value for station.disabled
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column station.area
     *
     * @return the value of station.area
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public Boolean getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column station.area
     *
     * @param area the value for station.area
     *
     * @mbg.generated Wed Jul 18 14:09:37 CST 2018
     */
    public void setArea(Boolean area) {
        this.area = area;
    }
}