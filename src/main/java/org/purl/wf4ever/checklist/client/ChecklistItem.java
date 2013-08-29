package org.purl.wf4ever.checklist.client;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * JSON representation of a single minim model requirement (item).
 * 
 * @author piotrekhol
 * 
 */
@XmlRootElement
public class ChecklistItem implements Serializable {

    /** id. */
    private static final long serialVersionUID = 8349089228173544208L;

    private URI itemUri;

    private String itemLabel;

    private URI itemLevel;

    private boolean itemSatisfied;

    private List<String> itemClasses;


    @XmlElement(name = "itemuri")
    public URI getItemUri() {
        return itemUri;
    }


    public void setItemUri(URI itemUri) {
        this.itemUri = itemUri;
    }


    @XmlElement(name = "itemlabel")
    public String getItemLabel() {
        return itemLabel;
    }


    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }


    @XmlElement(name = "itemlevel")
    public URI getItemLevel() {
        return itemLevel;
    }


    public void setItemLevel(URI itemLevel) {
        this.itemLevel = itemLevel;
    }


    @XmlElement(name = "itemsatisfied")
    public boolean isItemSatisfied() {
        return itemSatisfied;
    }


    public void setItemSatisfied(boolean itemSatisfied) {
        this.itemSatisfied = itemSatisfied;
    }


    @XmlElement(name = "itemclass")
    public List<String> getEvalResultClasses() {
        return itemClasses;
    }


    public void setEvalResultClasses(List<String> evalResultClasses) {
        this.itemClasses = evalResultClasses;
    }

}
