package com.Gypsee.bdd.integrations.common_utils;



public class UtilManager {

    private static UtilManager utilMan = null;

    private UtilManager() {

    }

    public static UtilManager getUtilManagerInstance() {
        if (utilMan == null) {
            utilMan = new UtilManager();
        }
        return utilMan;
    }

    public ExcelUtils getExcelUtils(){
        return new ExcelUtils();
    }
}
