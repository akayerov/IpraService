package com.akayerov.ipraservice.jpa.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the prg database table.
 * 
 */
@Entity
@Table(name="mse4")

public class Mse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="snils", columnDefinition="bpchar")
	private String snils;

	@Column(name="fname", columnDefinition="bpchar")
	private String fname;

	@Column(name="sname", columnDefinition="bpchar")
	private String sname;

	@Column(name="lname", columnDefinition="bpchar")
	private String lname;


	@Temporal(TemporalType.DATE)
	private Date bdate;
	
	@Column(name="id_mo")
	private Integer idMo;

	@Temporal(TemporalType.DATE)
	private Date dt;

	@Column(name="nmfile", columnDefinition="bpchar")
	private String nmfile;

	@Temporal(TemporalType.DATE)
	private Date prgdate;

	private boolean complete;
	@Column(name="mseid", columnDefinition="bpchar")
	private String mseid;


	public Mse() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBdate() {
		return this.bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public Date getDt() {
		return this.dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}



	public Integer getMo() {
		return this.idMo;
	}

	public void setPrg(Integer mo) {
		this.idMo = mo;
	}


	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSnils() {
		return this.snils;
	}

	public void setSnils(String snils) {
		this.snils = snils;
	}

	public Integer getIdMo() {
		return idMo;
	}

	public void setIdMo(Integer idMo) {
		this.idMo = idMo;
	}

	public String getNameFile() {
		return nmfile;
	}

	public void setNameFile(String nameFile) {
		this.nmfile = nameFile;
	}

	
	public String getNmfile() {
		return nmfile;
	}

	public void setNmfile(String nmfile) {
		this.nmfile = nmfile;
	}

	public Date getPrgdate() {
		return prgdate;
	}

	public void setPrgdate(Date prgdate) {
		this.prgdate = prgdate;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	

	public String getMseid() {
		return mseid;
	}

	public void setMseid(String mseid) {
		this.mseid = mseid;
	}

	@Override
     public String toString(){
	       return "id="+id+", fname="+fname + ", sname="+sname +", lname="+lname;
   }

}