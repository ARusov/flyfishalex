package org.flyfishalex.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 03.09.2015.
 */
@XmlRootElement(name = "sitemap")
@XmlAccessorType(XmlAccessType.FIELD)
public class SitemapLoc {
    private String loc;

    public SitemapLoc(String loc) {
        this.loc = loc;
    }

    public SitemapLoc() {
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
