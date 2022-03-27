import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;

/**
 * @作者 黎荣右
 * @时间 2021/11/22 21:47
 */
public class ConfigReader {
    public static String getClassName(){
        try {
            SAXReader reader=new SAXReader();//SAXReader 无参构造器来创建 SAX 解析对象
            InputStream in=Class.forName("ConfigReader").getResourceAsStream("/config.xml");
            Document document=reader.read(in);//获取文档对象 Document
            Node node=document.selectSingleNode("/animals/animal");//获取元素对象
            String className=node.getStringValue();
            return className;
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
