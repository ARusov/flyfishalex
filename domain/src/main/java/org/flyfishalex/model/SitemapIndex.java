package org.flyfishalex.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 03.09.2015.
 */
@XmlRootElement(name = "sitemapindex")
@XmlAccessorType(XmlAccessType.FIELD)
public class SitemapIndex {
    private List<SitemapLoc> sitemap = new ArrayList<SitemapLoc>();

    public List<SitemapLoc> getSitemap() {
        return sitemap;
    }

    public void setSitemap(List<SitemapLoc> sitemap) {
        this.sitemap = sitemap;
    }
}
