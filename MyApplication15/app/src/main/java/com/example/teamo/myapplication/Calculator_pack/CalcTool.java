package com.example.teamo.myapplication.Calculator_pack;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CalcTool {
    public static String getCacluteMain(String str) {
        String[] str1 = str.split("[+-]");
        for (int i = 0; i < str1.length; i++) {
            if (str1[i].indexOf("/") > 0 || str1[i].indexOf("*") > 0) {
                str1[i] = getCaculateUnder(str1[i]);
            }
        }
        char stdfc[] = str.toCharArray();
        char stdf[] = new char[50];
        int j = 0;
        for (int i = 0; i < stdfc.length; i++) {
            if (stdfc[i] == '+') {
                stdf[j] = '+';
                j++;

            }
            if (stdfc[i] == '-') {
                stdf[j] = '-';
                j++;

            }
        }
        float stdd[] = new float[50];
        for (int i = 0; i < str1.length; i++)

            if (!str1[i].equals("")) {
                stdd[i] = Float.parseFloat(str1[i]);
            }
        for (int i = 1; i < stdf.length; i++) {
            if (stdf[i - 1] == '+')
                stdd[0] = sum(stdd[0], stdd[i]);
            //stdd[0] += stdd[i];
            if (stdf[i - 1] == '-')
                stdd[0] = sub(stdd[0], stdd[i]);
            //stdd[0] -= stdd[i];
        }
        Float d = Float.valueOf(stdd[0]);
        String result = d.toString();
        return result;
    }

    private static String getCaculateUnder(String str) {

        char stdf[] = new char[50];
        float stdd[] = new float[50];
        String stds[] = str.split("[/*]");
        for (int i = 0; i < stds.length; i++)
            stdd[i] = Float.parseFloat(stds[i]);
        char stdfc[] = str.toCharArray();
        int j = 0, count = 1;
        for (int i = 0; i < stdfc.length; i++) {
            if (stdfc[i] == '/') {
                stdf[j] = '/';
                j++;
                count++;
            }
            if (stdfc[i] == '*') {
                stdf[j] = '*';
                j++;
                count++;
            }
        }
        for (int i = 1; i < count; i++) {
            if (stdf[i - 1] == '/')
                stdd[0] = div(stdd[0], stdd[i]);
            //stdd[0] /= stdd[i];
            if (stdf[i - 1] == '*')
                stdd[0] = mul(stdd[0], stdd[i]);
            //stdd[0] *= stdd[i];
        }
        Float d = Float.valueOf(stdd[0]);
        String result = d.toString();
        return result;
    }

    public static String getCaculateHigh(String str) {
        String[] str1;
        str1 = str.split("[(]");
        String str2;
        str2 = getCacluteMain(str1[str1.length - 1]);
        String str3;
        str3 = "(" + str1[str1.length - 1];
        str = str.replace(str3, str2);
        return str;
    }

    public static boolean isTrue(String str) {
        boolean mFlag = false;
        if (str.length() >= 0) {
            String[] mFrist = str.split("[+-]");
            if (mFrist.length > 0) {

                for (int i = 0; i < mFrist.length; i++) {
                    if (mFrist[i].contains("*") || mFrist[i].contains

                            ("/")) {
                        String[] mSencond = mFrist[i].split("[/*]");
                        for (int j = 0; j < mSencond.length; j++) {
                            if (mSencond[j].indexOf(".") ==

                                    mSencond[j].lastIndexOf(".")) {
                                mFlag = true;
                            } else {
                                mFlag = false;
                                break;
                            }
                        }

                    } else {
                        if (mFrist[i].indexOf(".") == mFrist[i]
                                .lastIndexOf(".")) {
                            mFlag = true;
                        } else {
                            mFlag = false;
                            break;
                        }
                    }
                }
            }

        } else {
            return false;
        }
        return mFlag;

    }

    public static boolean isDigitEnd(String str) {
        if (str.contains("=")) {
            return true;
        } else {
            return false;
        }
    }

    private static Float sum(float d1, float d2) {
        BigDecimal bd1 = new BigDecimal(Float.toString(d1));
        BigDecimal bd2 = new BigDecimal(Float.toString(d2));
        return bd1.add(bd2).floatValue();
    }

    private static Float sub(float d1, float d2) {
        BigDecimal bd1 = new BigDecimal(Float.toString(d1));
        BigDecimal bd2 = new BigDecimal(Float.toString(d2));
        return bd1.subtract(bd2).floatValue();
    }

    private static Float mul(float d1, float d2) {
        BigDecimal bd1 = new BigDecimal(Float.toString(d1));
        BigDecimal bd2 = new BigDecimal(Float.toString(d2));
        return bd1.multiply(bd2).floatValue();
    }

    private static Float div(float d1, float d2) {
        int scale = 6;
        BigDecimal bd1 = new BigDecimal(Float.toString(d1));
        BigDecimal bd2 = new BigDecimal(Float.toString(d2));
        return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }

    public static double Sin(double d) {
        return Math.sin(d);
    }

    public static double Cos(double d) {
        return Math.cos(d);
    }

    public static double Tan(double d) {
        return Math.tan(d);
    }

    public static double Squ(double d) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d));
        return bd1.multiply(bd1).doubleValue();
    }

    public static double Cube(double d) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d));
        BigDecimal bd2 = new BigDecimal(bd1.multiply(bd1).doubleValue());
        return bd2.multiply(bd1).doubleValue();
    }

    public static String Twice(StringBuffer str) {
        String d = str.toString();
        return Integer.toBinaryString(Integer.parseInt(d));
    }
    public static double Sqrt(double d) {
        if (d == 0) {
            return 0;
        } else {
            return Math.sqrt(d);
        }
    }
}