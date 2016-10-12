package com.shecc.eoms.core.model;

import java.io.Serializable;

/**
 * 
 * 字典
 * @author zxc
 * @version 0.1
 */
public class Dic implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private Integer id;

	/** dic_val. */
	private Integer dicVal;//字典值

	/** dic_txt. */
	private String dicTxt;//字典内容

	/** type. */
	private Integer type;//字典类型

	/** note. */
	private String note;//字典备注
	
	private Integer state;//是否可修改 1，可修改，0，不可修改
	
	private Integer dicId;//数据值
	
	private Integer isDefault;//是否为默认值，1为默认值

	

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * Constructor.
	 */
	public Dic() {
	}

	/**
	 * Set the id.
	 * 
	 * @param id
	 *            id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set the dic_val.
	 * 
	 * @param dicVal
	 *            dic_val
	 */
	public void setDicVal(Integer dicVal) {
		this.dicVal = dicVal;
	}

	/**
	 * Get the dic_val.
	 * 
	 * @return dic_val
	 */
	public Integer getDicVal() {
		return this.dicVal;
	}

	/**
	 * Set the dic_txt.
	 * 
	 * @param dicTxt
	 *            dic_txt
	 */
	public void setDicTxt(String dicTxt) {
		this.dicTxt = dicTxt;
	}

	/**
	 * Get the dic_txt.
	 * 
	 * @return dic_txt
	 */
	public String getDicTxt() {
		return this.dicTxt;
	}

	/**
	 * Set the type.
	 * 
	 * @param type
	 *            type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * Get the type.
	 * 
	 * @return type
	 */
	public Integer getType() {
		return this.type;
	}

	/**
	 * Set the note.
	 * 
	 * @param note
	 *            note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Get the note.
	 * 
	 * @return note
	 */
	public String getNote() {
		return this.note;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Dic other = (Dic) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	public Integer getDicId() {
		return dicId;
	}

	public void setDicId(Integer dicId) {
		this.dicId = dicId;
	}
}
