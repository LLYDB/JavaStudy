package study.java.jdks.version1_6.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * StAX ��ģʽ
 * @author hadoop2
 *
 */
public class StAXReadTest {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
       //����InputStream
       InputStream in = new FileInputStream("E:\\eclipse_luna\\aidefaultws\\JavaStudy\\src\\study\\java\\jdks\\version1_6\\stax\\student.xml");
       XMLInputFactory xif = XMLInputFactory.newInstance();//����StAX��������
       XMLStreamReader reader = xif.createXMLStreamReader(in);//����������
       while(reader.hasNext())//����
       {
           int event = reader.next();//��ȡ��һ���¼�
           if(event == XMLStreamReader.START_ELEMENT)//�������¼���Ԫ�ؿ�ʼ
           {
              if("student_id".equals(reader.getLocalName()))//�ж�Ԫ���ǲ���student_id
              {//�����student_id�����Ԫ�ص��ı�����
                  System.out.print(reader.getLocalName()+" : ");
                  System.out.println(reader.getElementText());
              }                   
           }
       }
    }
}

