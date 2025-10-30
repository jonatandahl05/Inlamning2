package Recruitmentapp;
import java.util.*;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CandidateService {
    private CandiateRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(CandidateService.class);

    public CandidateService(CandiateRepository repository) {
        this.repository = repository;
    }

    public boolean addCandidate(Candidate candidate)
    {
        return  repository.addCandidate(candidate);
    }

    public boolean removeCandidate(int id)
    {
     return repository.removeCandidate(id);
    }

    public List<Candidate> getAllCandidates()
    {
        return repository.getAllCandidates();
    }

    public Optional<Candidate> getCandidateById(int id) {
        return repository.getCandidateById(id);
    }


// Standard kandidater så man slipper skriva in flera stycken och det blir lätt att se att programmet fungerar (chatgpt underlättade här då man inte orkar :D)
    public void loadDefaultCandidates()
// Skyddar mot dubbletter genom att kolla om repository redan innehåller kandidater
    { if(!repository.isEmpty()) {
        System.out.println("Det finns redan kandidater i systemet. Standardkandidater laddas inte igen. \n");
        logger.warn("Försök att ladda default candidates när listan redan innehåller kandidater");
    }
        repository.addCandidate(new Candidate("IT", "Erik Andersson", 26, 5));
        repository.addCandidate(new Candidate("Ekonomi", "Sara Lind", 31, 7));
        repository.addCandidate(new Candidate("HR", "Maja Holm", 28, 3));
        repository.addCandidate(new Candidate("Design", "Elias Berg", 25, 2));
        repository.addCandidate(new Candidate("Marknadsföring", "Anna Sjöström", 30, 6));
        repository.addCandidate(new Candidate("IT", "Anders Nilsson", 45, 18));
        repository.addCandidate(new Candidate("Ekonomi", "Karin Svensson", 52, 25));
        repository.addCandidate(new Candidate("HR", "Lars Persson", 48, 20));
        repository.addCandidate(new Candidate("Design", "Maria Gustafsson", 41, 15));
        repository.addCandidate(new Candidate("Marknadsföring", "Olof Johansson", 50, 22));
        repository.addCandidate(new Candidate("Bygg", "Stefan Larsson", 39, 14));
        repository.addCandidate(new Candidate("Utbildning", "Helena Bergqvist", 43, 19));
        repository.addCandidate(new Candidate("Transport", "Jonas Olsson", 37, 12));
        repository.addCandidate(new Candidate("Sjukvård", "Eva Lund", 55, 30));

        System.out.println("Standardkandidater har lagts till.\n");
        logger.info("Standardkandidater har lagts till");

    }
//Filtrerar kandidater efter vald bransch
    public List<Candidate> filterByIndustry(String industry)
    {
        return repository.getAllCandidates().stream()
                .filter(c -> c.getIndustry().equalsIgnoreCase(industry))
                .collect(Collectors.toList());
    }
//Sorterar kandidater efter antal år av erfarenhet (flest år ->)
    public List<Candidate> sortByExperience ()
    {
        return repository.getAllCandidates().stream()
                .sorted(Comparator.comparing(Candidate::getYearsOfExperience).reversed())
                .toList();
    }

//Skriver ut kandidater i konsolen lite snyggt, samt visar ett meddelande om listan är tom.
    public static void printCandidates(List<Candidate> candidates)
    {
        if (candidates.isEmpty())
        {
            System.out.println("Det finns inga registrerade kandidater ännu. \n");
        } else {


            for(Candidate c : candidates)
            {
                System.out.println(c);
            }
        }
    }

    public Set<String> getAllIndustries()
    {
        return repository.getAllCandidates().stream()
                .map(Candidate::getIndustry)
                .filter(Objects::nonNull)
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(TreeSet::new, Set::add, Set::addAll);
    }

    public List<Candidate> getTopexperiencedCandidates (int topN)
    {
        return repository.getAllCandidates().stream()
                .sorted(Comparator.comparing(Candidate::getYearsOfExperience).reversed())
                .limit(topN)
                .toList();
    }



}
