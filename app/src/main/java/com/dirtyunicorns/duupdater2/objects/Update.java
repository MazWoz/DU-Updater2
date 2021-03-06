package com.dirtyunicorns.duupdater2.objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by mazwoz on 10/12/16.
 */

public class Update {

    protected int majorVersion;
    protected int minorVersion;
    protected String androidVersion;
    protected String buildType;
    protected Date buildDate;
    protected boolean isOffical;
    protected boolean isWeekly;
    protected boolean isTest;

    protected String GetProp() {
        String retProp = null;

        try {
            Process p = new ProcessBuilder("/system/bin/getprop", "ro.du.version").redirectErrorStream(true).start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line=br.readLine()) != null){
                retProp = line;
            }
            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retProp;
    }

    public String getBuildType() {
        return buildType;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public boolean isOfficial() {
        return isOffical;
    }

    public boolean isWeekly() {
        return isWeekly;
    }

    public boolean isTest() {
        return isTest;
    }
}
