package com.myorder.model;

public class tbRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_role.id
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_role.roleName
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    private String rolename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_role.bearingId
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    private Integer bearingid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_role.id
     *
     * @return the value of tb_role.id
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_role.id
     *
     * @param id the value for tb_role.id
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_role.roleName
     *
     * @return the value of tb_role.roleName
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_role.roleName
     *
     * @param rolename the value for tb_role.roleName
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_role.bearingId
     *
     * @return the value of tb_role.bearingId
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public Integer getBearingid() {
        return bearingid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_role.bearingId
     *
     * @param bearingid the value for tb_role.bearingId
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public void setBearingid(Integer bearingid) {
        this.bearingid = bearingid;
    }
}