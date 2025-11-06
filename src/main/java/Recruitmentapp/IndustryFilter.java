package Recruitmentapp;
import java.util.*;
import java.util.stream.Collectors;

// Visar hur man kan bygga vidare på systemet utan att då ändra befintlig kod.
public class IndustryFilter implements CandidateFilter {
    private String industry;

    public IndustryFilter(String industry) {
        this.industry = industry;
    }

    @Override
    public List<Candidate> filter(List<Candidate> candidates) {
        return candidates.stream()
                .filter(c-> c.getIndustry().equalsIgnoreCase(industry))
                .collect(Collectors.toList());
    }
}
