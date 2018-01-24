package com.aws.poc.sqlserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "POCTable")
public class POCTable extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "StoreDcId")
    private int storeDcId;
	
    @Column(name = "StoreId")
    private String storeId;

    @Column(name = "DcCode")
    private String dcCode;

    @Column(name = "DCName")
    private String dcName;
    
    @Column(name = "OwnerId")
    private String ownerId;

    
    public int getStoreDcId() {
		return storeDcId;
	}

	public void setStoreDcId(int storeDcId) {
		this.storeDcId = storeDcId;
	}
	
	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getDcCode() {
		return dcCode;
	}

	public void setDcCode(String dcCode) {
		this.dcCode = dcCode;
	}

	public String getDcName() {
		return dcName;
	}

	public void setDcName(String dcName) {
		this.dcName = dcName;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
    
}
