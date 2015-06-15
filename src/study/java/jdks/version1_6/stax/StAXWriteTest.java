package study.java.jdks.version1_6.stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

 

public class StAXWriteTest {

    public static void writeXML(XMLStreamWriter writer) throws XMLStreamException
    {
       writer.writeStartDocument("UTF-8", "1.0");//��ʼд�ĵ�
       writer.writeStartElement("", "students");//д��һЩ����
           writer.writeStartElement("student");
              writer.writeStartElement("student_id");
                  writer.writeCharacters("S09080709");
              writer.writeEndElement();
              writer.writeStartElement("student_name");
                  writer.writeCharacters("mary");
              writer.writeEndElement();
           writer.writeEndElement();
           writer.writeStartElement("student");
           writer.writeStartElement("student_id");
              writer.writeCharacters("S0900121");
           writer.writeEndElement();
           writer.writeStartElement("student_name");
              writer.writeCharacters("Lord");
           writer.writeEndElement();
       writer.writeEndElement();
       writer.writeEndElement();         
       writer.writeEndDocument();//�ĵ�д������
       writer.flush();//ˢ�»���
    }
    public static void main(String[] args) throws XMLStreamException {
       XMLOutputFactory xof = XMLOutputFactory.newInstance();//�����������   
       XMLStreamWriter writer = xof.createXMLStreamWriter(System.out,"UTF-8");//����XMLд����
       writer.setPrefix("", "");//û�ṩ�����ǰ׺
       writeXML(writer);//ִ��д��һЩXML��Ϣ
       writer.close();//�ر�д����
    }
}

