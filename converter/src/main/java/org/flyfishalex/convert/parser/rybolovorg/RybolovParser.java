package org.flyfishalex.convert.parser.rybolovorg;


import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 3/27/2015.
 */
public class RybolovParser {


    private File file;

    public RybolovParser(File file) {
        this.file=file;
    }

    public static void main(String[] args) throws IOException {

        URL url= new URL("http://www.rybolov.org/YML-public/yml_rybolov.xml");
        File file=new File("yml_rybolov.xml");
        FileUtils.copyURLToFile(url, file);

//         File file = new File("/home/tmp/yml_rybolov.xml");
        RybolovParser rybolovParser = new RybolovParser(file);
        List<RybolovCategory> categories = rybolovParser.getCategories();
//        for (RybolovCategory rybolovCategory : categories) {
//            System.out.println(rybolovCategory.getName());
//        }
        List<RybolovModel> offers = rybolovParser.getOffers();
        for (RybolovModel offer : offers) {
            if (offer != null) {
                    System.out.println(offer.getId() + "____" + offer.getName() + "____" + offer.getModel());
            }
        }
    }



    public List<RybolovModel> getOffers() {
        List<RybolovModel> rybolovModels = new ArrayList<RybolovModel>();
        try {

            JAXBContext jc = JAXBContext.newInstance(RybolovModel.class);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(file);
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);


            Unmarshaller unmarshaller = jc.createUnmarshaller();
            while (xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
                if (xsr.isStartElement() && "offer".equals(xsr.getLocalName())) {
                    RybolovModel rybolovModel = (RybolovModel) unmarshaller.unmarshal(xsr);
                    rybolovModels.add(rybolovModel);

                }
                xsr.next();
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return rybolovModels;
    }

    public List<RybolovCategory> getCategories() {
        List<RybolovCategory> categories = new ArrayList<RybolovCategory>();
        try {
            JAXBContext jc = JAXBContext.newInstance(RybolovCategory.class);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(file);
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);


            Unmarshaller unmarshaller = jc.createUnmarshaller();
            while (xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
                if (xsr.isStartElement() && "category".equals(xsr.getLocalName())) {

                    RybolovCategory rybolovCategory = (RybolovCategory) unmarshaller.unmarshal(xsr);
                    categories.add(rybolovCategory);

                }
                xsr.next();
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
