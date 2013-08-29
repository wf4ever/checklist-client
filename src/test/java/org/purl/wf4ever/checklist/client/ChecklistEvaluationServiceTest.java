package org.purl.wf4ever.checklist.client;

import java.net.URI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A basic test of the checklist service client.
 * 
 * This test uses remote resources (service, RO) so it's rather volatile.
 * 
 * @author piotrekhol
 * 
 */
public class ChecklistEvaluationServiceTest {

    /** URI of the service that is used. */
    private static final URI SERVICE_URI = URI.create("http://sandbox.wf4ever-project.org/roevaluate/");

    /** URI of the minim model, used in Y2 review. */
    private static final URI MINIM_URI = URI
            .create("http://rawgithub.com/wf4ever/ro-catalogue/master/v0.1/Timbus-demo-test/simpleRO-checklist.rdf");

    /** Purpose of the evaluation. */
    private static final String PURPOSE = "ready-to-release";

    /** The service client instance. */
    private ChecklistEvaluationService service;


    /**
     * Prepare the client that will be tested.
     */
    @Before
    public final void setUp() {
        this.service = new ChecklistEvaluationService(SERVICE_URI, MINIM_URI);
    }


    /**
     * Test that an evaluation can be properly retrieved.
     */
    @Test
    public final void testEvaluate() {
        URI roUri = URI.create("http://sandbox.wf4ever-project.org/rodl/ROs/Pack387/");
        EvaluationResult result = service.evaluate(roUri, PURPOSE);
        Assert.assertNotNull(result);
        //TODO add field verification
    }


    /**
     * Test that the evaluation score is calculated properly.
     */
    @Test
    public final void testGetEvaluationScore() {
        URI roUri = URI.create("http://sandbox.wf4ever-project.org/rodl/ROs/Pack387/");
        EvaluationResult result = service.evaluate(roUri, PURPOSE);
        Assert.assertEquals(88, result.getEvaluationScore());
    }
}
