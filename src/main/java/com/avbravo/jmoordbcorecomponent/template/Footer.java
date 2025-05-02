/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.template;

import com.avbravo.jmoordbcorecomponent.HrefInfo;
import com.avbravo.jmoordbcorecomponent.ImageInfo;

/**
 *
 * @author avbravo
 */
public class Footer {

    private String privacyPolicy;
    private String privacyPolicyURL;
    private String termsOfUse;
    private String termsOfUseURL;
    private String applicationTitle;
    private String by;
    private HrefInfo companyHrefInfo;
    private ImageInfo imageInfo;

    public Footer() {
    }

    public Footer(String privacyPolicy, String privacyPolicyURL, String termsOfUse, String termsOfUseURL, String applicationTitle, String by, HrefInfo companyHrefInfo, ImageInfo imageInfo) {
        this.privacyPolicy = privacyPolicy;
        this.privacyPolicyURL = privacyPolicyURL;
        this.termsOfUse = termsOfUse;
        this.termsOfUseURL = termsOfUseURL;
        this.applicationTitle = applicationTitle;
        this.by = by;
        this.companyHrefInfo = companyHrefInfo;
        this.imageInfo = imageInfo;
    }

   
  

   

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public String getPrivacyPolicyURL() {
        return privacyPolicyURL;
    }

    public void setPrivacyPolicyURL(String privacyPolicyURL) {
        this.privacyPolicyURL = privacyPolicyURL;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public String getTermsOfUseURL() {
        return termsOfUseURL;
    }

    public void setTermsOfUseURL(String termsOfUseURL) {
        this.termsOfUseURL = termsOfUseURL;
    }

    public String getApplicationTitle() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle = applicationTitle;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public HrefInfo getCompanyHrefInfo() {
        return companyHrefInfo;
    }

    public void setCompanyHrefInfo(HrefInfo companyHrefInfo) {
        this.companyHrefInfo = companyHrefInfo;
    }

   
    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

   
    
    
    

    public static class Builder {

        String privacyPolicy;
        String privacyPolicyURL;
        String termsOfUse;
        String termsOfUseURL;
        String applicationTitle;
        String by;
 HrefInfo companyHrefInfo;
       ImageInfo imageInfo;

        public Builder privacyPolicy(String privacyPolicy) {
            this.privacyPolicy = privacyPolicy;
            return this;
        }

        public Builder by(String by) {
            this.by = by;
            return this;
        }

        public Builder applicationTitle(String applicationTitle) {
            this.applicationTitle = applicationTitle;
            return this;
        }

        public Builder privacyPolicyURL(String privacyPolicyURL) {
            this.privacyPolicyURL = privacyPolicyURL;
            return this;
        }

        public Builder termsOfUse(String termsOfUse) {
            this.termsOfUse = termsOfUse;
            return this;
        }

        public Builder termsOfUseURL(String termsOfUseURL) {
            this.termsOfUseURL = termsOfUseURL;
            return this;
        }

        public Builder companyHrefInfo( HrefInfo companyHrefInfo) {
            this.companyHrefInfo = companyHrefInfo;
            return this;
        }

      
        public Builder imageInfo(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
            return this;
        }


        public Footer build() {
            return new Footer(privacyPolicy, privacyPolicyURL, termsOfUse, termsOfUseURL, applicationTitle, by, companyHrefInfo, imageInfo);

        }

    }

}
