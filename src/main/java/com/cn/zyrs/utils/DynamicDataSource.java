package com.cn.zyrs.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	public static final String DATA_SOURCE_1 = "dataSource1";
    public static final String DATA_SOURCE_2 = "dataSource2";
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static void setCustomerType(String customerType) {
            contextHolder.set(customerType);
    }
    public static String getCustomerType() {
            return contextHolder.get();
    }
    public static void clearCustomerType() {
            contextHolder.remove();
    }
    @Override
    protected Object determineCurrentLookupKey() {
            return getCustomerType();
    }

}
