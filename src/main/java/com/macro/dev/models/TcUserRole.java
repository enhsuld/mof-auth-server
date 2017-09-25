package com.macro.dev.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TC_USER_ROLE database table.
 * 
 */
@Entity
@Table(name="TC_USER_ROLE")
@NamedQuery(name="TcUserRole.findAll", query="SELECT t FROM TcUserRole t")
public class TcUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="REG_DTM")
	private String regDtm;

	@Column(name="REG_ID")
	private String regId;

	//bi-directional many-to-one association to TcRole
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private TcRole tcRole;

	//bi-directional many-to-one association to TcUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private TcUser tcUser;

	public TcUserRole() {
	}

	public String getRegDtm() {
		return this.regDtm;
	}

	public void setRegDtm(String regDtm) {
		this.regDtm = regDtm;
	}

	public String getRegId() {
		return this.regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public TcRole getTcRole() {
		return this.tcRole;
	}

	public void setTcRole(TcRole tcRole) {
		this.tcRole = tcRole;
	}

	public TcUser getTcUser() {
		return this.tcUser;
	}

	public void setTcUser(TcUser tcUser) {
		this.tcUser = tcUser;
	}

}