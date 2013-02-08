package org.purl.wf4ever.checklist.client;

import java.net.URI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChecklistEvaluationServiceTest {

    private static final URI SERVICE_URI = URI.create("http://sandbox.wf4ever-project.org/roevaluate/");

    private static final URI MINIM_URI = URI
            .create("http://sandbox.wf4ever-project.org/rodl/ROs/Y2Demo-test/workflow-experiment-checklist.rdf");

    private ChecklistEvaluationService service;


    @Before
    public final void setUp() {
        this.service = new ChecklistEvaluationService(SERVICE_URI, MINIM_URI);
    }


    @Test
    public final void testEvaluate() {
        URI roUri = URI.create("http://sandbox.wf4ever-project.org/rodl/ROs/Pack387/");
        String purpose = "ready-to-release";
        EvaluationResult result = service.evaluate(roUri, purpose);
        Assert.assertNotNull(result);
    }
}
