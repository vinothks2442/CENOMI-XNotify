package com.xnotify.bdd.integrations.common_utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.File;

public class ExcelUtils {

    public Connection createConnection(String filePath){
        Fillo fillo = new Fillo();
        Connection connection=null;
        try {
            connection = fillo.getConnection(filePath);
        }catch(FilloException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    public String getData(File file, int rowNum, int cellNum){
        return null;
    }

    public Recordset getData(String filePath, String query){
        Connection connection = createConnection(filePath);
        Recordset rs=null;
        try{
            rs = connection.executeQuery(query);
        }catch(FilloException ex){
            ex.printStackTrace();
        }
        return rs;
    }

    public void writeData(){

    }
}

