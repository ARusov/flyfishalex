package org.flyfishalex.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 03.09.2015.
 */
@XmlRootElement(name = "urlset")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sitemap {
    private List<SitemapURL> url = new ArrayList<SitemapURL>();

    public List<SitemapURL> getUrl() {
        return url;
    }

    public void setUrl(List<SitemapURL> url) {
        this.url = url;
    }
}
