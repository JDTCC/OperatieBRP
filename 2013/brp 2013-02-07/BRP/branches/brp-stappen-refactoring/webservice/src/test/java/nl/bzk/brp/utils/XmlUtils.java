/**
 * This file is copyright 2017 State of the Netherlands (Ministry of Interior Affairs and Kingdom Relations).
 * It is made available under the terms of the GNU Affero General Public License, version 3 as published by the Free Software Foundation.
 * The project of which this file is part, may be found at https://github.com/MinBZK/operatieBRP.
 */

package nl.bzk.brp.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public final class XmlUtils {

    /**
     * Deze static variabele kunnen we gebruiken omdat onze unit testen niet multitreading zijn.
     * Dit versnelt het testen, omdat ze niet elke keer aangemaakt hoeven worden.
     */
    private static DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder documentBuilder = null;
    private static TransformerFactory factory = TransformerFactory.newInstance();
    private static Transformer transformer = null;
    private static XPath xpath = null;
    private static boolean useNamespace = true;

    private static NamespaceContext ns = new NamespaceContext() {
        private final String prefix_brp = "brp";
        private final String uri_brp = "http://www.bprbzk.nl/BRP/0100";

        private final String prefix_stuf = "stuf";
        private final String uri_stuf = "http://www.kinggemeenten.nl/StUF/StUF0302";

        private final String prefix_ns = "ns";
        private final String uri_ns = "http://www.bprbzk.nl/BRP/0100";

        private final Map<String, String> namespaceEnPrefix = new HashMap<String, String>() {
            {
                put(prefix_brp, uri_brp);
                put(prefix_stuf, uri_stuf);
                put(prefix_ns, uri_ns);

                put(uri_brp, prefix_brp);
                put(uri_stuf, prefix_stuf);
                put(uri_ns, prefix_ns);
            }
        };

        @Override
        public Iterator getPrefixes(final String namespaceURI) {
            return Arrays.asList(namespaceEnPrefix.get(namespaceURI)).iterator();
        }

        @Override
        public String getPrefix(final String namespaceURI) {
            return namespaceEnPrefix.get(namespaceURI);
        }

        @Override
        public String getNamespaceURI(final String prefix) {
            return namespaceEnPrefix.get(prefix);
        }
    };


    /**
     * private constructor, omdat het om een final class gaat.
     */
    private XmlUtils() {

    }

    private static void initXpath() {
        if (null == xpath) {
            xpath = XPathFactory.newInstance().newXPath();
            if (useNamespace) {
                xpath.setNamespaceContext(ns);
            }
        }
    }

    /**
     * Deze methode converteert een DOMtree object naar een XML string, zodat
     * dit menselijk leesbaar wordt en eventueel later naar een echte DOM
     * document geconverteerd kan worden.
     *
     * @param node de "root node"
     * @return een XML string of null als er iets fout gaat.
     */
    public static String toXmlString(final Node node) throws TransformerException {
        if (null == transformer) {
            transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        }
        Source source = new DOMSource(node);
        StringWriter stringWriter = new StringWriter();
        Result result = new StreamResult(stringWriter);
        transformer.transform(source, result);

        return stringWriter.getBuffer().toString();
    }

    /**
     * Deze methode converteert een SOAPMessage object naar een XML string, zodat
     * dit menselijk leesbaar wordt. Letop dat dit niet ge-indent (geformatteerd is).
     *
     * @param msg de SOAPMsg bericht
     * @return de string respresentatie (of null value als msg is null)
     * @throws IOException   als iets fout gaat
     * @throws SOAPException als iets fout gaat
     */
    public static String toXmlString(final SOAPMessage msg) throws IOException, SOAPException {
        String soapMsgAsXml = null;
        if (msg != null) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            msg.writeTo(out);
            soapMsgAsXml = new String(out.toByteArray());
            out.close();
        }
        return soapMsgAsXml;
    }

    /**
     * Maakt een DOM Document object gebaseerd opeen xml string
     *
     * @param xmlString de xml string
     * @return het Document
     * @throws ParserConfigurationException in geval val misconfiguratie
     * @throws SAXException                 in geval van geen geldige xml
     * @throws IOException                  IO string buffer fouten
     */
    public static Document bouwDocument(final String xmlString) throws ParserConfigurationException, SAXException,
            IOException
    {
        if (null == documentBuilder) {
            documentFactory.setNamespaceAware(true);
            documentBuilder = documentFactory.newDocumentBuilder();
        }
        return documentBuilder.parse(new InputSource(new StringReader(xmlString)));
    }

    public static Document bouwDocumentVanBestand(final String berichtBestand) throws ParserConfigurationException,
            SAXException, IOException
    {
        InputStream is = XmlUtils.class.getResourceAsStream(berichtBestand);
        if (null == is) {
            throw new IOException("Can't find file " + berichtBestand);
        }
        return documentBuilder.parse(is);
    }

    public static Document bouwDocumentVanBestand(final InputStream is) throws ParserConfigurationException,
            SAXException, IOException
    {
        return documentBuilder.parse(is);
    }

    /**
     * Geeft de string representatie van een element (plus alle onderliggende elementen)
     *
     * @param xpathExpression de xpath expressie
     * @param document        het DOM Document
     * @return de text, lege string als het pad niet bestaat.
     * @throws XPathExpressionException ongeldige expressie.
     */
    public static String getNodeWaarde(final String xpathExpression, final Document document)
            throws XPathExpressionException
    {
        initXpath();
        return (String) xpath.evaluate(xpathExpression, document, XPathConstants.STRING);
    }

    /**
     * Geeft de waarde van een attribuut uit een node. Indien de opgegeven expressie meer dan een enkele node
     * vindt, dan zal zal van de eerste node de attribuutwaarde worden geretourneerd. Indien er geen node of het
     * attribuut niet op de node kan worden gevonden, dan zal er <code>null</code> worden geretourneerd.
     *
     * @param xpathExpression de xpath expressie
     * @param attribuutNaam   de naam van het attribuut (inclusief namespace prefix opgeven)
     * @param document        het DOM Document
     * @return de waarde van het attribuut.
     * @throws XPathExpressionException ongeldige expressie.
     */
    public static String getAttribuutWaarde(final String xpathExpression, final String attribuutNaam,
                                            final Document document)
            throws XPathExpressionException
    {
        String attribuutWaarde = null;

        initXpath();
        NodeList nodes = (NodeList) xpath.evaluate(xpathExpression, document, XPathConstants.NODESET);
        if (nodes.getLength() > 0) {
            Node attribuutNode = nodes.item(0).getAttributes().getNamedItem(attribuutNaam);
            if (attribuutNode != null) {
                attribuutWaarde = attribuutNode.getNodeValue();
            }
        }
        return attribuutWaarde;
    }

    /**
     * Heet het aantal noden dat voldoet aan de xpath expressie.
     *
     * @param xpathExpression de xpath expressie
     * @param document        het DOM document
     * @return het aantal nodes (0 als niet gevonden)
     * @throws XPathExpressionException
     */
    public static Integer getNodeCount(final String xpathExpression, final Document document)
            throws XPathExpressionException
    {
        initXpath();
        return ((Double) xpath.evaluate(xpathExpression, document, XPathConstants.NUMBER)).intValue();
    }

    /**
     * Test of een node bestaat.
     *
     * @param nodePath de xpath expressie
     * @param document het DOM document
     * @return true als de node bestaat, false anders.
     * @throws XPathExpressionException
     */
    public static boolean isNodeAanwezig(final String nodePath, final Document document)
            throws XPathExpressionException
    {
        initXpath();
        Object o = xpath.evaluate(nodePath, document, XPathConstants.NODE);
        return (null != o);
    }

    /**
     * Valideert de opgegeven output XML tegen het schema. Middels assertions ({@link Assert#fail(String)}) worden
     * eventuele fouten aan de unit testing framework doorgegeven.
     *
     * @param outputXml     de output xml die gevalideerd moet worden.
     * @param schemaBestand de relatieve locatie (classpath) + bestandsnaam van de xsd.
     */
    public static void valideerOutputTegenSchema(final String outputXml, final String schemaBestand) {
        try {
            final SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(
                    new File(XmlUtils.class.getResource(schemaBestand).toURI())));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(outputXml)));
        } catch (SAXException e) {
            Assert.fail(e.getMessage());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        } catch (URISyntaxException e) {
            Assert.fail(e.getMessage());
        }
    }

}
