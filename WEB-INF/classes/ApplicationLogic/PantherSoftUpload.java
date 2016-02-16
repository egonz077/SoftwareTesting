package ApplicationLogic;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by IntelliJ IDEA.
 * User: alain
 * Date: Nov 28, 2006
 * Time: 12:05:16 AM
 */

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author cbalearn
 *         <p/>
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PantherSoftUpload extends DefaultHandler {

    private String tempCourse, action, fragValue, date;
    private String webctID, familyName, givenName, birthDay, fiu_email, phone, prefix;
    private String sex;
    private StringBuffer textBuffer;
    private final String snapshotPath = "/opt/upload/SNAPSHOT.XML";
    //	private final String snapshotPath = "C:\\SNAPSHOT.XML";
    private boolean onlineCourse, membership, member, id, useridCourse, email, comments, role, firstXMLParse, tel;
    private boolean person, lastName, firstName, gender, dob, useridPerson, existentStudent, existentProfessor, datetime;
    private boolean professor = false;
    private boolean group, longDescription, begin, end;
    private boolean firstGroup = true;
    private String courseTitle, beginDate, endDate;
    private static Map members = new HashMap();
    private static ArrayList courses;
    //private Section currentSection;
    private Term currentTerm;
    //private Logs programLogs;
    private String term;


    public PantherSoftUpload(String term) {

        //........

    }

    public String parseXMLFile() {
        try {

            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(this);
            xr.setErrorHandler(this);
            FileReader r = new FileReader(snapshotPath);
            xr.parse(new InputSource(r));
            return "SNAPSHOT.XML file parsed";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Errors parsing the SNAPSHOT.XML file";
        }
    }


    //Handle opened tags in the XML throughout the two XML Parses
    public void startElement(String uri, String name, String qName, Attributes atts) throws SAXException {
        String eName = name; // element name

        if ("".equals(eName)) {
            eName = qName; // not namespaceAware
        }

        if (eName.equals("group")) group = true;
        else if (eName.equals("membership")) membership = true;
        else if (eName.equals("person")) person = true;
        //....
    }

    //Handle ending tags in the XML throughout the two XML Parses
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String eName = localName; // element name

        if ("".equals(eName)) {
            eName = qName; // not namespaceAware
        }

        if (eName.equals("group")) {
            //....
        }
        if (eName.equals("membership")) {
            //.....
        }

    }

    //Take tag's value and stored it in the tex
    public void characters(char ch[], int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (textBuffer == null) textBuffer = new StringBuffer(value);
        else textBuffer.append(value);
    }


    private String echoText() throws SAXException {
        if (textBuffer == null) return "";
        String s = "" + textBuffer;
        //emit(s);
        textBuffer = null;
        return s;
    }


    public void endDocument() {
        System.out.println("XML Parse Done");

    }
}