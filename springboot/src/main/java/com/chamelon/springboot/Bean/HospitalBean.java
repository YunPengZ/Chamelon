package com.chamelon.springboot.Bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class HospitalBean {
    private String ProviderId;
    private String HospitalName;
    private String Address;
    private String City;
    private String State;
    private String Zipcode;
    private String Countryname;
    private String PhoneNumber;
    private String HospitalType;
    private String HospitalOwner;
    private String EmergencyService;
    private String Condition;
    private String MeasureCode;
    private String MeasureName;
    private String Score;
    private String StateAvg;
    public HashMap<String,String> map;

    public HospitalBean(String[] args) {
        this.ProviderId = args[0];
        this.HospitalName = args[1];
        //this.Address = args[2];
        this.City = args[2];
        this.State = args[3];
        this.Zipcode = args[4];
        this.Countryname = args[5];
        this.PhoneNumber = args[6];
        this.HospitalType = args[7];
        this.HospitalOwner = args[8];
        this.EmergencyService = args[9];
        this.Condition = args[10];
        this.MeasureCode = args[11];
        this.MeasureName = args[12];
        this.Score = args[13];
        this.StateAvg = args[14];
    }

    public String get(String para) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        String getter = "get"+para.substring(0,1).toUpperCase()+para.substring(1);
        Method method = this.getClass().getMethod(getter,null);//设置方法的形参类型
        String value = (String) method.invoke(this,null);//this.get
        return value;
    }
    @Override
    public String toString() {
        return "HospitalBean{" +
                "ProviderId='" + ProviderId + '\'' +
                ", HospitalName='" + HospitalName + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Zipcode=" + Zipcode +
                ", Countryname='" + Countryname + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", HospitalType='" + HospitalType + '\'' +
                ", HospitalOwner='" + HospitalOwner + '\'' +
                ", EmergencyService='" + EmergencyService + '\'' +
                ", Condition='" + Condition + '\'' +
                ", MeasureCode='" + MeasureCode + '\'' +
                ", MeasureName='" + MeasureName + '\'' +
                ", Score='" + Score + '\'' +
                ", StateAvg='" + StateAvg + '\'' +
                '}';
    }

    public String getProviderId() {
        return ProviderId;
    }

    public void setProviderId(String providerId) {
        ProviderId = providerId;
    }

    public String getHospitalName() {
        return HospitalName;
    }

    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getCountryname() {
        return Countryname;
    }

    public void setCountryname(String countryname) {
        Countryname = countryname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getHospitalType() {
        return HospitalType;
    }

    public void setHospitalType(String hospitalType) {
        HospitalType = hospitalType;
    }

    public String getHospitalOwner() {
        return HospitalOwner;
    }

    public void setHospitalOwner(String hospitalOwner) {
        HospitalOwner = hospitalOwner;
    }

    public String getEmergencyService() {
        return EmergencyService;
    }

    public void setEmergencyService(String emergencyService) {
        EmergencyService = emergencyService;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getMeasureCode() {
        return MeasureCode;
    }

    public void setMeasureCode(String measureCode) {
        MeasureCode = measureCode;
    }

    public String getMeasureName() {
        return MeasureName;
    }

    public void setMeasureName(String measureName) {
        MeasureName = measureName;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }
}

