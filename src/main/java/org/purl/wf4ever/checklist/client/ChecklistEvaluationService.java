package org.purl.wf4ever.checklist.client;

import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;

import org.apache.log4j.Logger;
import org.openrdf.rio.RDFFormat;
import org.purl.wf4ever.checklist.client.vocabulary.ROE;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.shared.JenaException;
import com.sun.jersey.api.client.Client;

public class ChecklistEvaluationService implements Serializable {

    /** id. */
    private static final long serialVersionUID = -8999917522891485806L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(ChecklistEvaluationService.class);

    private String uriTemplate;
    private URI minimModelUri;

    /** web client. */
    private transient Client client;
    private String checklistString;
    private String trafficlightJsonString;


    public ChecklistEvaluationService(URI serviceUri, URI minimModelUri) {
        this.minimModelUri = minimModelUri;
        try {
            InputStream serviceDesc = getClient().resource(serviceUri).accept(RDFFormat.RDFXML.getDefaultMIMEType())
                    .get(InputStream.class);
            Model model = ModelFactory.createDefaultModel();
            model.read(serviceDesc, serviceUri.toString());
            Resource service = model.getResource(serviceUri.toString());
            this.checklistString = service.listProperties(ROE.checklist).next().getObject().asLiteral().getString();
            this.trafficlightJsonString = service.listProperties(ROE.trafficlightJson).next().getObject().asLiteral()
                    .getString();
        } catch (JenaException e) {
            LOG.warn("Could not initialize the checklist evaluation service client: " + e.getLocalizedMessage());
        }
    }


    /**
     * Return an HTTP client, creating it if necessary.
     * 
     * @return an HTTP client
     */
    private Client getClient() {
        if (client == null) {
            client = Client.create();
        }
        return client;
    }


    public EvaluationResult evaluate(URI researchObjectUri, String purpose) {
        return null;
    }
}
