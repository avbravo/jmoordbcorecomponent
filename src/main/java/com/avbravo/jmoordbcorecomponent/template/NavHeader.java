/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jmoordbcorecomponent.template;

import com.avbravo.jmoordbcorecomponent.HrefInfo;
import com.avbravo.jmoordbcorecomponent.ImageInfo;
import java.util.List;

/**
 *
 * @author avbravo
 */
public class NavHeader {

    private String title;
    private String message;
    private HrefInfo hrefInfo;
    private ImageInfo imageInfo;
    private List<ImageInfo> imageInfos;

    public NavHeader() {
    }

    public NavHeader(String title, String message, HrefInfo hrefInfo, ImageInfo imageInfo, List<ImageInfo> imageInfos) {
        this.title = title;
        this.message = message;
        this.hrefInfo = hrefInfo;
        this.imageInfo = imageInfo;
        this.imageInfos = imageInfos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HrefInfo getHrefInfo() {
        return hrefInfo;
    }

    public void setHrefInfo(HrefInfo hrefInfo) {
        this.hrefInfo = hrefInfo;
    }

    public ImageInfo getImageInfo() {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo imageInfo) {
        this.imageInfo = imageInfo;
    }

    public List<ImageInfo> getImageInfos() {
        return imageInfos;
    }

    public void setImageInfos(List<ImageInfo> imageInfos) {
        this.imageInfos = imageInfos;
    }

    
    
    
    
    public static class Builder {
private String title;
    private String message;
    private HrefInfo hrefInfo;
    private ImageInfo imageInfo;
    private List<ImageInfo> imageInfos;

        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder hrefInfo(HrefInfo hrefInfo) {
            this.hrefInfo = hrefInfo;
            return this;
        }
        public Builder imageInfo(ImageInfo imageInfo) {
            this.imageInfo = imageInfo;
            return this;
        }
        public Builder imageInfos(List<ImageInfo> imageInfos) {
            this.imageInfos = imageInfos;
            return this;
        }
        
        
        public NavHeader build() {
            return new NavHeader(title, message, hrefInfo, imageInfo, imageInfos);

        }
    }
    
    
        
        
        
}
