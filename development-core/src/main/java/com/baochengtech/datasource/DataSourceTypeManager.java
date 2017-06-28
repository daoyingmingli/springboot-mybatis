package com.baochengtech.datasource;

/**
 * Created by liming on 17-3-1.
 */

public class DataSourceTypeManager {

    private static final ThreadLocal<DataSourcesEnum> dataSourceTypes = new ThreadLocal();

    public DataSourceTypeManager() {
    }

    public static DataSourcesEnum get() {
        return dataSourceTypes.get();
    }

    public static void set(DataSourcesEnum dataSourceType) {
        dataSourceTypes.set(dataSourceType);
    }
}
