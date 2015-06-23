package study.java.jdks.version1_6.desktop_systemtray;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DesktopTray {
    private static Desktop desktop;
    private static SystemTray st;
    private static PopupMenu pm;
    public static void main(String[] args) {
        if(Desktop.isDesktopSupported()){//�жϵ�ǰƽ̨�Ƿ�֧��Desktop��
            desktop = Desktop.getDesktop();
        }
        if(SystemTray.isSupported()){//�жϵ�ǰƽ̨�Ƿ�֧��ϵͳ����
            st = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("E:\\eclipse_luna\\aidefaultws\\JavaStudy\\src\\study\\java\\jdks\\version1_6\\desktop_systemtray\\asiainfo.png");//��������ͼ���ͼƬ            
            createPopupMenu();
            TrayIcon ti = new TrayIcon(image, "Desktop Demo Tray", pm);
            try {
                st.add(ti);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void sendMail(String mail){
        if(desktop!=null && desktop.isSupported(Desktop.Action.MAIL)){
            try {
                desktop.mail(new URI(mail));
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
        }            
    }
    
    public static void  openBrowser(String url){
        if(desktop!=null && desktop.isSupported(Desktop.Action.BROWSE)){
            try {
                desktop.browse(new URI(url));
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void  edit(String fileName){
        if(desktop!=null && desktop.isSupported(Desktop.Action.EDIT)){
            try {
                File txtFile = new File(fileName);
                if(!txtFile.exists()){
                    txtFile.createNewFile();
                }
                desktop.edit(txtFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            } 
        }
    }
    
    public static void createPopupMenu(){
       pm = new PopupMenu();
        MenuItem openBrowser = new MenuItem("�򿪹ٷ���վ");
        openBrowser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openBrowser("http://www.asiainfo.com.cn");
            }
        });
        
        MenuItem sendMail = new MenuItem("�����ʼ�����");
        sendMail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMail("mailto:fucheng@asiainfo.com");
            }
        });
        
        MenuItem edit = new MenuItem("�༭�ı��ļ�");
        edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edit("fucheng.txt");
            }
        });
        
        MenuItem editDoc = new MenuItem("�༭office�ļ�");
        editDoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                edit("fucheng.docx");
            }
        });
        
        MenuItem exitMenu = new MenuItem("�˳�");
        exitMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pm.add(openBrowser);
        pm.add(sendMail);
        pm.add(edit);
        pm.add(editDoc);
        pm.addSeparator();
        pm.add(exitMenu);    
    }
} 

