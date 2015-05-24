package org.flyfishalex.model.dto;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.flyfishalex.model.Category;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by arusov on 4/6/2015.
 */
public class Demo {



    public static void main(String[] args) throws Exception {

//        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//        CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
        Demo d = new Demo();

        Categories1c c = d.getCategories1c();
//        d.transform1c(c, 0);


        HttpClient httpClient= new HttpClient();
        PostMethod postMethod = new PostMethod("http://localhost:8080/flyfishalex/import/import1c");
        StringWriter writer = new StringWriter();
        JAXBContext jc=JAXBContext.newInstance(Categories1c.class);
        Marshaller marshaller=jc.createMarshaller();
        marshaller.marshal(c,writer);
        postMethod.setRequestEntity(new StringRequestEntity(writer.toString(),"application/xml","UTF-8"));
        System.out.println(writer.toString());
        System.out.println(httpClient.executeMethod(postMethod));

    }


    public void transform1c(Categories1c categories1c, long root) {

        if (categories1c != null) {
            List<Category1c> rootCats1c = categories1c.getCategories();
            if (rootCats1c == null) {
                return;
            }


            for (Category1c item : rootCats1c) {
                Category category = new Category();
                category.setName(item.getName());
                category.setParentId(root);
//                categoryDao.createCategory(category);
                System.out.println(item.getName() + "---" + root);
                transform1c(item.getCategories(), category.getId());

            }
        }
    }


    public Categories1c getCategories1c() throws Exception {

        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("C:\\Projects\\flyfishalex\\domain\\src\\main\\resources\\import_1.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        while (xsr.hasNext()) {
            if (xsr.isStartElement() && xsr.getLocalName().equals("Группы")) {
                break;
            }
            xsr.next();
        }
        System.out.println(xsr.getLocalName());


        JAXBContext jc = JAXBContext.newInstance(Categories1c.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        JAXBElement<Categories1c> jaxbElement = unmarshaller.unmarshal(xsr, Categories1c.class);
//        Categories1c a = (Categories1c) unmarshaller.unmarshal(xsr,Categories1c.class);
        Categories1c a = jaxbElement.getValue();
        return a;
    }
}
