import Recruitmentapp.CandiateRepository;
import Recruitmentapp.Candidate;
import Recruitmentapp.CandidateService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import java.util.*;


public class CandidateServiceTest {

    @Test
    void addCandidate_shouldReturnTrueWhenAddedSuccessfully()
    {
        CandiateRepository mockRepo = Mockito.mock(CandiateRepository.class);
        CandidateService candidateService = new CandidateService(mockRepo);
        Candidate candidate = new Candidate("IT", "Jonatan Dahl", 20, 2);

        Mockito.when(mockRepo.addCandidate(candidate)).thenReturn(true);

        boolean result = candidateService.addCandidate(candidate);

        assertTrue(result);
        Mockito.verify(mockRepo).addCandidate(candidate);

        System.out.println("Test passed: addCandidate_shouldReturnTrueWhenAddedSuccessfully()");

    }

    @Test
    void filterByIndustry_ShouldReturnOnlyMatchingCandidates()
    {
        CandiateRepository mockRepo = Mockito.mock(CandiateRepository.class);
        CandidateService service = new CandidateService(mockRepo);

        List<Candidate> mockCandidates = List.of(
                new Candidate("IT", "Jonatan Dahl", 20, 2),
                new Candidate("Ekonomi", "Adam Svensson", 23, 4),
                new Candidate("IT", "Sara Pettersson", 27, 4)
        );
        Mockito.when(mockRepo.getAllCandidates()).thenReturn((mockCandidates));

        List<Candidate> result = service.filterByIndustry("IT");

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(c-> c.getIndustry().equalsIgnoreCase("IT")));
        System.out.println("Test passed: filterByIndustry_shouldReturnOnlyMatchingCandidates()");
    }

    @Test
    void sortByExperience_shouldSortCandidatesDescendingByExperience()
    {
        CandiateRepository mockRepo = Mockito.mock(CandiateRepository.class);
        CandidateService service = new CandidateService(mockRepo);

        List<Candidate> mockCandidates = List.of(
                new Candidate("IT", "Jonatan", 25, 3),
                new Candidate("IT", "Sara", 30, 7),
                new Candidate("IT", "Adam", 28, 5)
        );

        Mockito.when(mockRepo.getAllCandidates()).thenReturn(mockCandidates);

        List<Candidate> sorted = service.sortByExperience();

        assertEquals("Sara", sorted.get(0).getName());
        assertEquals("Adam", sorted.get(1).getName());
        assertEquals("Jonatan", sorted.get(2).getName());
        System.out.println("Test passed: sortByExperience_shouldSortCandidatesDescendingByExperience()");
    }

}
