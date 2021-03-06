package ua.khpi.bibik.hospital_system.entity.user;

import ua.khpi.bibik.hospital_system.entity.Entity;

public class User extends Entity {

	protected String login;
	protected String password;
	protected String name;
	protected String type;
	protected String dob;

	/**
	 * user surname
	 */
	protected String sname;

	/**
	 * user middlename
	 */
	protected String mname;

	protected String phoneNum;

	public User() {
		super();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (mname == null) {
			if (other.mname != null)
				return false;
		} else if (!mname.equals(other.mname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNum == null) {
			if (other.phoneNum != null)
				return false;
		} else if (!phoneNum.equals(other.phoneNum))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		return true;
	}

	public String getDob() {
		return dob;
	}

	public String getLogin() {
		return login;
	}

	public String getMname() {
		return mname;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getSname() {
		return sname;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mname == null) ? 0 : mname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNum == null) ? 0 : phoneNum.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		return result;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", name=" + name + ", type=" + type + ", sname="
				+ sname + ", mname=" + mname + ", phoneNum=" + phoneNum + "]";
	}

	

}
