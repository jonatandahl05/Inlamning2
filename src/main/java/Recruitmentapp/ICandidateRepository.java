package Recruitmentapp;
import java.util.*;
public interface ICandidateRepository {
    boolean addCandidate(Candidate candidate);
    boolean removeCandidate(int id);
    List<Candidate> getAllCandidates();
    Optional<Candidate> getCandidateById (int id);
    boolean isEmpty();
}
