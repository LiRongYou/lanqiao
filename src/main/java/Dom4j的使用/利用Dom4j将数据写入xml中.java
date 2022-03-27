package Dom4j的使用;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Text;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 使用 Dom4j 将数据生成 XML 文档
 */
public class 利用Dom4j将数据写入xml中 {
    public static void main(String[] args) {
    new 利用Dom4j将数据写入xml中().createXmlFile("src/Dom4j的使用/persons.xml");
}

    public void createXmlFile(String filename){
        // 创建工厂类对象
        DocumentFactory factory = new DocumentFactory();

        // 创建文档对象
        Document document = factory.createDocument();

        // 创建根元素
        Element root = factory.createElement("persons");
        // 将根元素放入到文档对象中
        document.add(root);

        // 获取 Person 数据信息
        List<Person> persons = Person.getPersons();
        for (Person p : persons) {
            //创建子元素
            Element person = factory.createElement("person");
            //将子元素放入到根元素中
            root.add(person);

            // 创建属性，并同时设置属性名和属性值
            Attribute attrid = factory.createAttribute(person, "id", p.getId());
            // 将属性对象放入子元素中
            person.add(attrid);

            //创建子元素对象
            Element personname = factory.createElement("name");
            person.add(personname);
            //创建文本对象
            Text name = factory.createText(p.getName());
            //将文本字符数据放入到子元素中
            personname.add(name);

            Element personsex = factory.createElement("sex");
            person.add(personsex);
            Text sex = factory.createText(p.getSex());
            personsex.add(sex);

            Element personage = factory.createElement("age");
            person.add(personage);
            Text age = factory.createText(String.valueOf(p.getAge()));
            personage.add(age);

        }
        // 设置写入xml文档样式
        OutputFormat format = OutputFormat.createPrettyPrint();
        // OutputFormat format = OutputFormat.createCompactFormat();

        //将文档写入到指定的xml文件中
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new FileWriter(filename), format);
            writer.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                try {
                    // 关闭流
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
