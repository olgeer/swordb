package com.sword.base.log;

import com.alibaba.fastjson.JSON;
import com.sword.base.datasource.CommonExample;
import com.sword.base.datasource.TableInfo;

/**
 * Created by Max on 2017/1/9.
 */
public class ResultSetParameter {
    private int total = 0;
    private TableInfo tableInfo = null;
    private CommonExample commonExample = null;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public TableInfo getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
    }

    public CommonExample getCommonExample() {
        return commonExample;
    }

    public void setCommonExample(CommonExample commonExample) {
        this.commonExample = commonExample;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
