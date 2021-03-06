/*
 * Copyright (c) 2017 Lightful. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Lightful.
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 */

package net.impacthub.app.model.features.jobs;

/**
 * @author Filippo Ash
 * @version 1.0
 * @date 8/9/2017.
 */

public class Company {

    private String Twitter__c;
    private String Website;
    private String Logo_Image_Url__c;
    private String Instagram__c;
    private String Name;
    private String Company_About_Us__c;
    private String Number_of_Employees__c;
    private String Banner_Image_Url__c;
    private Attributes attributes;
    private String Company_Summary__c;
    private String Sector_Industry__c;
    private String Facebook__c;
    private String LinkedIn__c;
    private String Impact_Hub_Cities__c;

    public String getTwitter__c() {
        return Twitter__c;
    }

    public String getWebsite() {
        return Website;
    }

    public String getLogo_Image_Url__c() {
        return Logo_Image_Url__c;
    }

    public String getInstagram__c() {
        return Instagram__c;
    }

    public String getName() {
        return Name;
    }

    public String getAbout_Us__c() {
        return Company_About_Us__c;
    }

    public String getNumber_of_Employees__c() {
        return Number_of_Employees__c;
    }

    public String getBanner_Image_Url__c() {
        return Banner_Image_Url__c;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public String getCompany_Summary__c() {
        return Company_Summary__c;
    }

    public String getSector_Industry__c() {
        return Sector_Industry__c;
    }

    public String getFacebook__c() {
        return Facebook__c;
    }

    public String getLinkedIn__c() {
        return LinkedIn__c;
    }

    public String getImpact_Hub_Cities__c() {
        return Impact_Hub_Cities__c;
    }

    @Override
    public String toString() {
        return "Company [Twitter__c = " + Twitter__c + ", Website = " + Website + ", Logo_Image_Url__c = " + Logo_Image_Url__c + ", Instagram__c = " + Instagram__c + ", Name = " + Name + ", About_Us__c = " + Company_About_Us__c + ", Number_of_Employees__c = " + Number_of_Employees__c + ", Banner_Image_Url__c = " + Banner_Image_Url__c + ", attributes = " + attributes + ", Company_Summary__c = " + Company_Summary__c + ", Sector_Industry__c = " + Sector_Industry__c + ", Facebook__c = " + Facebook__c + ", LinkedIn__c = " + LinkedIn__c + ", Impact_Hub_Cities__c = " + Impact_Hub_Cities__c + "]";
    }
}
