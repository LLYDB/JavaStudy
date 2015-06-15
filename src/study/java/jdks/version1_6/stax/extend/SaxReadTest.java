package study.java.jdks.version1_6.stax.extend;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Sax ������ģʽ����ģʽ
 * @author hadoop2
 *
 */
public class SaxReadTest {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		SAXParserFactory spf = SAXParserFactory.newInstance();// ����SAX����������
		spf.setNamespaceAware(true);// �������ƿռ�����
		SAXParser sp = spf.newSAXParser();// ����������
		// ��ʼ����
		sp.parse(new File("E:\\eclipse_luna\\aidefaultws\\JavaStudy\\src\\study\\java\\jdks\\version1_6\\stax\\student.xml"),

		new DefaultHandler() {
			boolean isStudentId = false;// �Ƿ���ѧ����Ϣ

			@Override
			public void startElement(String uri, String localName,
					String qName, Attributes attributes) throws SAXException {
				super.startElement(uri, localName, qName, attributes);
				//System.out.println(uri+"==="+ localName+"==="+ qName);
				if ("student_id".equals(localName))// ������յ���Ԫ����student_id
				{
					isStudentId = true;// ��������ѧ����Ϣ���ڽ����ַ���Ϣʱ��Ҫ���ѧ��
					System.out.print(localName + " : ");// ���Ԫ������
				}
			}

			@Override
			public void characters(char[] ch, int start, int length)// ���յ��ַ���Ϣ
					throws SAXException {
				super.characters(ch, start, length);
				if (isStudentId)// �����ǰ��Ϣ��ѧ��
				{
					System.out.println(new String(ch, start, length));// ������ѧ��
				}
			}

			@Override
			public void endElement(String uri, String localName, String qName)// Ԫ����ֹ
					throws SAXException {
				super.endElement(uri, localName, qName);
				isStudentId = false;// ��ǵ�ǰԪ�ز���ѧ��
			}
		});
	}
}
