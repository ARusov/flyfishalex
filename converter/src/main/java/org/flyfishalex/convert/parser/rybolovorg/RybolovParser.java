package org.flyfishalex.convert.parser.rybolovorg;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by arusov on 3/27/2015.
 */
public class RybolovParser {
//    private final File file = new File("C:\\tmp\\yml_rybolov.xml");
    private final File file = new File("/home/tmp/yml_rybolov.xml");

    public static void main(String[] args) throws IOException {


        RybolovParser rybolovParser = new RybolovParser();
        List<RybolovCategory> categories = rybolovParser.getCategories();
//        for (RybolovCategory rybolovCategory : categories) {
//            System.out.println(rybolovCategory.getName());
//        }
        List<RybolovModel> offers = rybolovParser.getOffers();
        for (RybolovModel offer : offers) {
            if (offer != null) {
                if (offer.getName() != null) {
                    System.out.println(offer.getId() + "____" + offer.getName() + "____" + offer.getModel());
                }
            }
        }
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

//    private String getCategory(int categoryId, List<SwimboxCategory> categories) {
//        int categ = categoryId;
//        boolean flag = false;
//        StringBuilder sb = new StringBuilder();
//        while (categ != 0) {
//
//            for (SwimboxCategory category : categories) {
//                if (category.getId() == categ) {
//
//                    String name = category.getName().replaceAll("\n", "");
//                    if (flag) {
//                        sb.insert(0, name + "/");
//                    } else {
//                        sb.insert(0, name);
//                        flag = true;
//                    }
//
//                    categ = category.getParentId();
//
//                }
//            }
//        }
//        sb.insert(0, "Гермо/");
//        return sb.toString();
//    }

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
