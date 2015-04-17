package org.flyfishalex.parser.swimbox;

import org.flyfishalex.model.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by arusov on 3/27/2015.
 */
public class SwimboxParser {

    private File file = new File("C:/Projects/flyfishalex/converter/input/swimbox_yml.xml");

    public static void main(String[] args) {

        SwimboxParser swimboxParser = new SwimboxParser();
        List<SwimboxCategory> categories = swimboxParser.getCategories();
        List<SwimboxModel> offers = swimboxParser.getOffers();
        List<Product> products= new ArrayList<Product>();
        for (SwimboxModel offer : offers) {
            if (offer != null) {
                Product product = new Product();

                product.setArticul("swimbox" + offer.getId());
                product.setName("\"" + offer.getModel() + "\"");
                product.setType("\""+swimboxParser.getCategory(offer.getCategoryId(), categories)+"\"");
                product.setPrice(offer.getPrice());

                products.add(product);
                System.out.println(offer.getCategoryId());
                System.out.println(product);
            }
        }


        File file = new File("C:/Projects/flyfishalex/converter/output/swimbox.csv");


        try {
            if (file.exists()) {
                file.delete();
            }
            FileWriter writer = new FileWriter(file);
//            Writer writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream(file), Charset.forName("UTF-8").newEncoder()));
            writer.append("\"Артикул\"");
            writer.append(Product.SPLIT);
            writer.append("\"Товар\"");
            writer.append(Product.SPLIT);
            writer.append("\"Цена\"");
            writer.append(Product.SPLIT);
            writer.append("\"Категория\"");
            writer.append(Product.SPLIT);
            writer.append("\"Вариант\"");
            writer.append(Product.SPLIT);
            writer.append("\"Описание\"");
            writer.append(Product.SPLIT);
            writer.append("\"Адрес\"");
            writer.append(Product.SPLIT);
            writer.append("\"Изображения\"");
            writer.append(Product.SPLIT);
            writer.append("\"Описание\"");
            writer.append(Product.SPLIT);
            writer.append("\"Склад\"");

            writer.append("\n");
            for (Product product : products) {
                writer.append(product.toString());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private String getCategory(int categoryId, List<SwimboxCategory> categories) {
        int categ = categoryId;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while (categ != 0) {

            for (SwimboxCategory category : categories) {
                if (category.getId() == categ) {

                    String name = category.getName().replaceAll("\n", "");
                    if (flag) {
                        sb.insert(0, name + "/");
                    } else {
                        sb.insert(0, name);
                        flag = true;
                    }

                    categ = category.getParentId();

                }
            }
        }
        sb.insert(0,"Гермо/");
        return sb.toString();
    }

    private List<SwimboxModel> getOffers() {
        List<SwimboxModel> swimboxes = new ArrayList<SwimboxModel>();
        try {

            JAXBContext jc = JAXBContext.newInstance(SwimboxModel.class);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(file);
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);


            Unmarshaller unmarshaller = jc.createUnmarshaller();
            while (xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
                if (xsr.isStartElement() && "offer".equals(xsr.getLocalName())) {
                    SwimboxModel swimbox = (SwimboxModel) unmarshaller.unmarshal(xsr);
                    swimboxes.add(swimbox);

                }
                xsr.next();
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return swimboxes;
    }

    public List<SwimboxCategory> getCategories() {
        List<SwimboxCategory> categories = new ArrayList<SwimboxCategory>();
        try {
            JAXBContext jc = JAXBContext.newInstance(SwimboxCategory.class);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            StreamSource xml = new StreamSource(file);
            XMLStreamReader xsr = xif.createXMLStreamReader(xml);


            Unmarshaller unmarshaller = jc.createUnmarshaller();
            while (xsr.getEventType() != XMLStreamReader.END_DOCUMENT) {
                if (xsr.isStartElement() && "category".equals(xsr.getLocalName())) {

                    SwimboxCategory swimbox = (SwimboxCategory) unmarshaller.unmarshal(xsr);
                    categories.add(swimbox);

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
