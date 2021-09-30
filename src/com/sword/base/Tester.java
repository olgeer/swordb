package com.sword.base;

import com.sword.base.datasource.CommonDAO;
import com.sword.base.datasource.CommonExample;
import com.sword.base.datasource.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by Max on 2017/12/20.
 */
public class Tester {
    public Tester() {
    }

    public static void main(String[] args){
        Connection conn=DataSource.newInstance().getConn();
        CommonDAO commonDAO=new CommonDAO("common_test",conn);
        //CommonExample commonExample=new CommonExample();
        //commonExample.createCriteria();
        //commonExample.setPageSize(0);
        ResultSet rs=commonDAO.selectByExample();
        System.out.println("get record:"+commonDAO.resultSet2Json(rs,commonDAO.getTableInfo()));
    }
}
