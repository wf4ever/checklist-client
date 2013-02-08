package org.purl.wf4ever.checklist.client.vocabulary;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.util.FileManager;

/**
 * RO evaluation ontology.
 * 
 * @author piotrekhol
 * 
 */
public final class ROE {

    /** namespace. */
    public static final String NAMESPACE = "http://purl.org/ro/service/evaluate/";

    /** ontology model. */
    public static final OntModel ONT_MODEL = ModelFactory.createOntologyModel(new OntModelSpec(OntModelSpec.OWL_MEM),
        FileManager.get().loadModel(NAMESPACE));

    /** roe:checklist. */
    public static final Property checklist = ONT_MODEL.getProperty(NAMESPACE + "checklist");

    /** roe:trafficlight_json. */
    public static final Property trafficlightJson = ONT_MODEL.getProperty(NAMESPACE + "trafficlight_json");


    /**
     * Constructor.
     */
    private ROE() {
        //nope
    }

}
