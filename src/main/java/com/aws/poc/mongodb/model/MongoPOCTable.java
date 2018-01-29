package com.aws.poc.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "POCTable")
public class MongoPOCTable{

	@Id
    private int storeDcId;
	
    private String storeId;

    private String dcCode;

    private String dcName;
    
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
