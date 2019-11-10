package dao.impl;

import dao.api.IReadable;
import model.Candy;
import model.CandyWithFilling;
import model.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromXmlDOM implements IReadable {

    @Override
    public List<Candy> read() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        List<Candy> candies = new ArrayList<>();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(Constants.PATH_TO_INPUT_XML));
            doc.getDocumentElement().normalize();
            NodeList candyNodeList = doc.getElementsByTagName("candies");
            NodeList childNodes = candyNodeList.item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) childNodes.item(i);
                    if (element.getTagName() == "candy") {
                        candies.add(getCandy(element));
                    }
                    if (element.getTagName() == "candyWithFilling") {
                        candies.add(getCandyWithFilling(element));
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return candies;
    }

    private static Candy getCandy(Element element) {
        Candy candy = new Candy();
        candy.setName(getTagValue("name", element, 0));
        candy.setMainIngredient(getTagValue("mainIngredient", element, 0));
        candy.setWeight(Integer.parseInt(getTagValue("weight", element, 0)));
        candy.setPrice(Double.parseDouble(getTagValue("price", element, 0)));
        return candy;
    }

    private static Candy getCandyWithFilling(Element element) {
        CandyWithFilling candyWithFilling = new CandyWithFilling();
        candyWithFilling.setName(getTagValue("name", element, 0));
        candyWithFilling.setMainIngredient(getTagValue("mainIngredient", element, 0));
        candyWithFilling.setWeight(Integer.parseInt(getTagValue("weight", element, 0)));
        candyWithFilling.setPrice(Double.parseDouble(getTagValue("price", element, 0)));
        NodeList fillings = element.getElementsByTagName("fillings");
        Element fillingsElement = (Element) fillings.item(0);
        NodeList fillingList = element.getElementsByTagName("filling");
        List<String> filling = new ArrayList<>();
        for (int i = 0; i < fillingList.getLength(); i++) {
            filling.add(getTagValue("filling", fillingsElement, i));
        }
        candyWithFilling.setFilling(filling);
        return candyWithFilling;
    }

    private static String getTagValue(String tag, Element element, int index) {
        NodeList nodeList = element.getElementsByTagName(tag).item(index).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
