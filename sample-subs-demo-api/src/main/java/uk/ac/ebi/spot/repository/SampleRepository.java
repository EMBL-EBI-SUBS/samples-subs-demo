package uk.ac.ebi.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uk.ac.ebi.spot.model.Sample;

/**
 * Created by tburdett on 08/03/2016.
 */
public interface SampleRepository extends PagingAndSortingRepository<Sample, Integer> {
}
