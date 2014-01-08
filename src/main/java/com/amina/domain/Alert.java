package com.amina.domain;

public class Alert {

    private String productName;
    private String aisleName;
    private Integer productQuantity;
    private Integer productThreshold;
    
    
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Integer getProductThreshold() {
		return productThreshold;
	}

	public void setProductThreshold(Integer productThreshold) {
		this.productThreshold = productThreshold;
	}

	public String getAisleName() {
		return aisleName;
	}

	public void setAisleName(String aisleName) {
		this.aisleName = aisleName;
	}

	@Override
    public String toString() {
            return "Alert [productName=" + productName + ", productAisle = " + aisleName+ ", productQuantity=" + productQuantity + ", productThreshold="+ productThreshold+"] \n";
    }
    
    
}