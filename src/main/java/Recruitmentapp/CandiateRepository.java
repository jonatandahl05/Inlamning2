package Recruitmentapp;

import java.util.*;
import java.util.stream.Collectors;

public class CandiateRepository {

    private Map<Integer, Candidate> candidates = new HashMap<>();
    private int nextId = 1;

    public boolean addCandidate(Candidate candidate) {
        // Stream används för att loopa igenom alla kandidater och se om en likadan redan finns
        boolean exists = candidates.values().stream()
                .anyMatch(c ->
                        c.getName().equalsIgnoreCase(candidate.getName()) &&
                                c.getIndustry().equalsIgnoreCase(candidate.getIndustry())
                );

        if (exists) {
            return false; // kandidaten finns redan, lägg inte till
        }

        candidate.setId(nextId++);
        candidates.put(candidate.getId(), candidate);
        return true;
    }


    public boolean removeCandidate(int id) {
        if (candidates.containsKey(id)) {
            candidates.remove(id);
            return true;
        }
        return false;
    }

    public List<Candidate> getAllCandidates()
    {
        return new ArrayList<>(candidates.values());
    }

    public Optional<Candidate> getCandidateById(int id)
    {
        return Optional.ofNullable(candidates.get(id));
    }

    public boolean isEmpty()
    {
        return candidates.isEmpty();
    }

}
