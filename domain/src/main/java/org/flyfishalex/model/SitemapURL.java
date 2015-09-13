package org.flyfishalex.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by arusov on 03.09.2015.
 */
@XmlRootElement(name = "url")
@XmlAccessorType(XmlAccessType.FIELD)
public class SitemapURL {

    private String loc;

    private String lastmod;

    private String changefreq="weekly";

    private Double priority=1.0;

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getLastmod() {

        return lastmod;
    }

    public void setLastmod(String lastmod) {
        this.lastmod = lastmod;
    }

    public String getChangefreq() {
        return changefreq;
    }

    public void setChangefreq(String changefreq) {
        this.changefreq = changefreq;
    }

    public Double getPriority() {
        return priority;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }
}
