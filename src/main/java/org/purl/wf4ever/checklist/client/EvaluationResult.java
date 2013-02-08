package org.purl.wf4ever.checklist.client;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class EvaluationResult implements Serializable {

    /** id. */
    private static final long serialVersionUID = -4284772318903005226L;

    private URI roUri;

    private String roId;

    private String title;

    private String description;

    private URI checklistUri;

    private URI checklistTarget;

    private String checklistTargetLabel;

    private String checklistPurpose;

    private URI evalResult;

    private String evalResultLabel;

    private List<String> evalResultClasses;

    private List<ChecklistItem> checklistItems;


    @XmlElement(name = "rouri")
    public URI getRoUri() {
        return roUri;
    }


    public void setRoUri(URI roUri) {
        this.roUri = roUri;
    }


    @XmlElement(name = "roid")
    public String getRoId() {
        return roId;
    }


    public void setRoId(String roId) {
        this.roId = roId;
    }


    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    @XmlElement(name = "checklisturi")
    public URI getChecklistUri() {
        return checklistUri;
    }


    public void setChecklistUri(URI checklistUri) {
        this.checklistUri = checklistUri;
    }


    @XmlElement(name = "checklisttarget")
    public URI getChecklistTarget() {
        return checklistTarget;
    }


    public void setChecklistTarget(URI checklistTarget) {
        this.checklistTarget = checklistTarget;
    }


    @XmlElement(name = "checklisttargetlabel")
    public String getChecklistTargetLabel() {
        return checklistTargetLabel;
    }


    public void setChecklistTargetLabel(String checklistTargetLabel) {
        this.checklistTargetLabel = checklistTargetLabel;
    }


    @XmlElement(name = "checklistpurpose")
    public String getChecklistPurpose() {
        return checklistPurpose;
    }


    public void setChecklistPurpose(String checklistPurpose) {
        this.checklistPurpose = checklistPurpose;
    }


    @XmlElement(name = "evalresult")
    public URI getEvalResult() {
        return evalResult;
    }


    public void setEvalResult(URI evalResult) {
        this.evalResult = evalResult;
    }


    @XmlElement(name = "evalresultlabel")
    public String getEvalResultLabel() {
        return evalResultLabel;
    }


    public void setEvalResultLabel(String evalResultLabel) {
        this.evalResultLabel = evalResultLabel;
    }


    @XmlElement(name = "evalresultclass")
    public List<String> getEvalResultClasses() {
        return evalResultClasses;
    }


    public void setEvalResultClasses(List<String> evalResultClasses) {
        this.evalResultClasses = evalResultClasses;
    }


    @XmlElement(name = "checklistitems")
    public List<ChecklistItem> getChecklistItems() {
        return checklistItems;
    }


    public void setChecklistItems(List<ChecklistItem> checklistItems) {
        this.checklistItems = checklistItems;
    }


    /**
     * Return a score as a percentage of all checklist items that are satisfied.
     * 
     * @return a value between 0 (worst) and 100 (best)
     */
    @XmlTransient
    public int getEvaluationScore() {
        int score = 0;
        for (ChecklistItem item : checklistItems) {
            if (item.isItemSatisfied()) {
                score++;
            }
        }
        return (int) Math.round((double) score * 100 / checklistItems.size());
    }

}
