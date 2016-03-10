package uk.ac.ebi.spot.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import uk.ac.ebi.spot.model.Sample;

/**
 * Created by tburdett on 09/03/2016.
 */
@Service
public class SampleReceiver {
    @RabbitListener(queues = Channels.SAMPLE_CREATION)
    public void handleSampleCreation(Sample sample) {
        System.out.println("Received a newly created sample: accession = " + sample.getAccession() + ", name = " + sample.getName());
    }

//    @RabbitListener(queues = Channels.SAMPLE_SAVE)
//    public void handleSampleSave(Sample sample) {
//        System.out.println("Received an update to an existing sample: accession = " + sample.getAccession() + ", name = " + sample.getName());
//    }

}
