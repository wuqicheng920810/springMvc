package com.myorder.model;

import java.util.ArrayList;
import java.util.List;

public class TBPersmission {

    private Integer id;


    private String pername;


    private String perurl;


    private Integer fatherid;

    private List<TBPersmission> persmissionList=new ArrayList<TBPersmission>();

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_persmission.id
     *
     * @param id the value for tb_persmission.id
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_persmission.perName
     *
     * @return the value of tb_persmission.perName
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public String getPername() {
        return pername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_persmission.perName
     *
     * @param pername the value for tb_persmission.perName
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public void setPername(String pername) {
        this.pername = pername == null ? null : pername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_persmission.perUrl
     *
     * @return the value of tb_persmission.perUrl
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public String getPerurl() {
        return perurl;
    }

    
    public List<TBPersmission> getPersmissionList() {
		return persmissionList;
	}

	public void setPersmissionList(List<TBPersmission> persmissionList) {
		this.persmissionList = persmissionList;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_persmission.perUrl
     *
     * @param perurl the value for tb_persmission.perUrl
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public void setPerurl(String perurl) {
        this.perurl = perurl == null ? null : perurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_persmission.fatherId
     *
     * @return the value of tb_persmission.fatherId
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public Integer getFatherid() {
        return fatherid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_persmission.fatherId
     *
     * @param fatherid the value for tb_persmission.fatherId
     *
     * @mbggenerated Tue Jul 19 19:17:13 CST 2016
     */
    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }
}