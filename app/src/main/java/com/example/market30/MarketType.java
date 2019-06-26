package com.example.market30;

public class MarketType {
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public ProductInfomation getMarketInformation() {
        return marketInformation;
    }

    public void setMarketInformation(ProductInfomation marketInformation) {
        this.marketInformation = marketInformation;
    }

    private ProductInfomation marketInformation;
}