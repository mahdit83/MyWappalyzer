package ir.mtajik.android.mywappalyzer.dto;

import java.io.Serializable;
import java.util.List;

public class CompanyDto implements Serializable {

    private String Id;
    private String Title;
    private String CEOName;
    private String sLogan;
    private String remark;
    private String MainOfficeCountry;
    private String MainOfficeProvince;
    private String MainOfficeCity;
    private String MainOfficeAddress;
    private String MainOfficePostalCode;
    private String MainOfficeLat;
    private String MainOfficeLng;
    private String FoundDate;
    private String Personels;
    private String Website;
    private String Tel;
    private String Fax;
    private String Email;
    private String Logo;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getCEOName() {
        return CEOName;
    }

    public void setCEOName(String CEOName) {
        this.CEOName = CEOName;
    }

    public String getsLogan() {
        return sLogan;
    }

    public void setsLogan(String sLogan) {
        this.sLogan = sLogan;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMainOfficeCountry() {
        return MainOfficeCountry;
    }

    public void setMainOfficeCountry(String mainOfficeCountry) {
        this.MainOfficeCountry = mainOfficeCountry;
    }

    public String getMainOfficeProvince() {
        return MainOfficeProvince;
    }

    public void setMainOfficeProvince(String mainOfficeProvince) {
        this.MainOfficeProvince = mainOfficeProvince;
    }

    public String getMainOfficeCity() {
        return MainOfficeCity;
    }

    public void setMainOfficeCity(String mainOfficeCity) {
        this.MainOfficeCity = mainOfficeCity;
    }

    public String getMainOfficeAddress() {
        return MainOfficeAddress;
    }

    public void setMainOfficeAddress(String mainOfficeAddress) {
        this.MainOfficeAddress = mainOfficeAddress;
    }

    public String getMainOfficePostalCode() {
        return MainOfficePostalCode;
    }

    public void setMainOfficePostalCode(String mainOfficePostalCode) {
        this.MainOfficePostalCode = mainOfficePostalCode;
    }

    public String getMainOfficeLat() {
        return MainOfficeLat;
    }

    public void setMainOfficeLat(String mainOfficeLat) {
        this.MainOfficeLat = mainOfficeLat;
    }

    public String getMainOfficeLng() {
        return MainOfficeLng;
    }

    public void setMainOfficeLng(String mainOfficeLng) {
        this.MainOfficeLng = mainOfficeLng;
    }

    public String getFoundDate() {
        return FoundDate;
    }

    public void setFoundDate(String foundDate) {
        this.FoundDate = foundDate;
    }

    public String getPersonels() {
        return Personels;
    }

    public void setPersonels(String personels) {
        this.Personels = personels;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        this.Website = website;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        this.Tel = tel;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        this.Fax = fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        this.Logo = logo;
    }

}
