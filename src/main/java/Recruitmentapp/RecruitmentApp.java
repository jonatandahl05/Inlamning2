package Recruitmentapp;

import java.util.*;
import static Recruitmentapp.CandidateService.printCandidates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class RecruitmentApp {

    private static final Logger logger = LoggerFactory.getLogger(RecruitmentApp.class);


    private static final Scanner scanner = new Scanner(System.in);
    private static final CandidateService service = new CandidateService(new CandiateRepository());

    public static void main(String[] args) {

        System.out.println("Vill du kägga till standardkandidater? (ja/nej): ");
        String answer = scanner.nextLine().trim().toLowerCase();
//Ger användaren en möjlighet att börja med färdig data
        if(answer.equals("ja"))
        {
            service.loadDefaultCandidates();
        } else {
            System.out.println("Inga kandidater har lagts till ännu. \n");
        }


        boolean running = true;

//Huvud loopen för hela progammet
        while(running)
        {
            try {
                showMainMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        showManageCandidatesMenu();
                        break;
                    case 2:
                        showManageFilterAndSortedMenu();
                        break;
                    case 3:
                        service.loadDefaultCandidates();
                        break;
                    case 4:
                        System.out.println("Programmet avslutas... Tack för att du använde systemet!");
                        logger.info("Programmet avslutades av användaren.");
                        running = false;
                        break;
                    default:
                        System.out.println("Ogiltigt val, försök igen.");
                }
            }catch (InputMismatchException e)
            {
                System.out.println("Ange endast siffror när du väljer menyval. \n");
                logger.warn("Felaktig menymatning i huvudmenyn", e);
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ett oväntat fel inträffade i huvudmenyn. \n");
                logger.error("Oväntat fel i main()", e);
            }
        }
    }
   private static void showMainMenu()
   {

       System.out.println("---> Välkommen till Jonatans rekryteringssystem <---");
       System.out.println("1. Hantera kandidater");
       System.out.println("2. Filtrera / Sortera kandidater");
       System.out.println("3. Lägg till standardkandidater");
       System.out.println("4. Avsluta");
       System.out.println("Välj ett alternativ (1-4)");

   }

    private static void showManageCandidatesMenu()
    {
        boolean back = false;

        while (!back)
        {
//Menyn för att hantera kandidater
            System.out.println("---> Hantera kandidater <---");
            System.out.println("1. Lägg till ny kandidat");
            System.out.println("2. Visa alla kandidater");
            System.out.println("3. Ta bort kandidat");
            System.out.println("4. Gå tillbaka");
            System.out.println("Välj ett alternativ (1-4)");

            try
            {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice)
                {
                    case 1:
                        addCandidate();
                        break;
                    case 2:
                        showAllCandidates();
                        break;
                    case 3:
                        removeCandidate();
                        break;
                    case 4:
                        back = true;
                        break;
                    default:
                        System.out.println("Ogiltigt val, försök igen.\n");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Ange ett giltigt nummer (1–4).\n");
                logger.warn("Felaktig inmatning i Hantera kandidater-menyn", e);
                scanner.nextLine(); // rensa bort fel input så loopen kan fortsätta
            }
            catch (Exception e)
            {
                System.out.println("Ett oväntat fel inträffade i Hantera kandidater-menyn.\n");
                logger.error("Oväntat fel i showManageCandidatesMenu()", e);
            }
        }
    }
    private static void showManageFilterAndSortedMenu()
    {
        boolean back = false;

        while (!back)
        {
//Menyn för att filtrera och sortera kandidater
            System.out.println("---> Sortera / Filtrera kandidater <---");
            System.out.println("1. Filtrera efter bransch");
            System.out.println("2. Filtrera efter år av erfarenhet");
            System.out.println("3. Visa topp 3 mest erfarna kandidater");
            System.out.println("4. Gå tillbaka");
            System.out.println("Välj ett alternativ (1-4)");
            try
            {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice)
                {
                    case 1:
                        filterByIndustryMenu();
                        break;
                    case 2:
                        sortByExperience();
                        break;
                    case 3:
                        showTopExperiencedCandidates();
                        break;
                    case 4:
                        back = true;
                        break;
                    default:
                        System.out.println("Ogiltigt val. Försök igen.\n");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Ange ett giltigt nummer (1–4).\n");
                logger.warn("Felaktig inmatning i Sortera/Filtrera-menyn", e);
                scanner.nextLine(); // rensar fel input
            }
            catch (Exception e)
            {
                System.out.println("Ett oväntat fel inträffade i Sortera/Filtrera-menyn.\n");
                logger.error("Oväntat fel i showManageFilterAndSortedMenu()", e);
            }
        }
    }

//lägger till en ny kandidat med validering och felhantering
   private static void addCandidate()
   {
       try {

       System.out.println("Namn: ");
       String name = scanner.nextLine();

       System.out.println("Ålder: ");
       int age = Integer.parseInt(scanner.nextLine());

       System.out.println("Branch: ");
       String industry = scanner.nextLine();

       System.out.println("År av erfarenhet: ");
       int yearsOfExperience = Integer.parseInt(scanner.nextLine());
// Validering av tomma fält
       if(name.isEmpty() || industry.isEmpty())
       {
           System.out.println("\n Namn och branch får inte vara tomma");
           logger.warn("Försök att lägga till kandidat med tomma fält (name: {}, industry: {})", name, industry);
           return;
       }
// Validering av negativa värden
       if (age <= 0 || yearsOfExperience < 0)
       {
               System.out.println("Ålder och erfarenhet måste vara positiva siffror.\n");
               logger.warn("Felaktiga värden för kandidat: age={}, experience={}", age, yearsOfExperience);
               return;
       }
       Candidate candidate = new Candidate(industry, name, age, yearsOfExperience);
       boolean success = service.addCandidate(candidate);
       if(success)
       {
           System.out.println("Kandidat " + name + " är nu tillagd.\n");
           logger.info("Ny kandidat tillagd: " +name);
       } else {
           System.out.println("En kandidat med samma namn och branch finns redan i systemet! \n");
           logger.warn("Försök att lägga till en dubblett: {} ({})", name, industry);
       }

   } catch (Exception e)
       {
           System.out.println("Ett oväntat fel inträffade vid tilläg av kandidat. \n");
           logger.error("Oväntat fel i addCandidate()" +e);
       }
   }

//Skriver ut alla kandidater som finns i systemet
   public static void showAllCandidates()
   {
       List<Candidate> candidates = service.getAllCandidates();
       System.out.println("---> Kandidater i systemet (" + candidates.size() + " st) <---");
       printCandidates(candidates);
   }

// Tar bort en kandidat baserat på id, med bekräftelse från användaren
   private static void removeCandidate()
   {
       List<Candidate> candidates = service.getAllCandidates();
       if(candidates.isEmpty())
       {
           System.out.println("Det finns inga kandidater att ta bort");
           return;
       }

       printCandidates(candidates);

       try {

           System.out.println("Vänligen ange ID på kandidaten du vill ta bort");
           int id = scanner.nextInt();
           scanner.nextLine();

           Optional<Candidate> candidateOpt = service.getCandidateById(id);

           if (candidates.isEmpty()) {
               System.out.println("Ingen kandidat hittades med ID: " + id + "\n");
               logger.warn("Försök att ta bort kandidat med ogiltigt ID: {}", id);
               return;
           }

           Candidate candidate = candidateOpt.get();
//Användaren måste bekräfta borrtagningen
           System.out.printf("Är du säker på att du vill ta bort %s (ID: %d)? (ja/nej): ",
                   candidate.getName(), candidate.getId());
           String confirm = scanner.nextLine().trim().toLowerCase();

           if (!confirm.equals("ja")) {
               System.out.println("Åtgärd avbruten");
               return;
           }

           boolean success = service.removeCandidate(id);
           if (success) {
               System.out.println("Kandidat " + candidate.getName() + " borttagen");
               logger.info("Kandidat borttagen: {} (ID: {})", candidate.getName(), candidate.getId());
           } else {
               System.out.println("Något gick fel - Kandidaten kunde inte tas bort");
               logger.error("Fel vid borttagning av kandidat: {} (ID: {})", candidate.getName(), candidate.getId());
           }
       }catch (Exception e)
       {
           System.out.println("Ett oväntat fel inträffade vid borttagning.\n");
           logger.error("Oväntat fel i removeCandidate()", e);
       }

   }

// Sorterar kandidater efter erfarenhet (flest år först)
   public static void  sortByExperience()
   {
       List<Candidate> sorted = service.sortByExperience();
       printCandidates(sorted);

   }

// Filtrerar kandidater efter bransch och visar resultatet
   private static void filterByIndustryMenu()
   {
       Set<String> indutries = service.getAllIndustries();

       if(indutries.isEmpty())
       {
           System.out.println("Det finns inga registrerade brancher ännu");
           return;
       }

       System.out.println("---> Tillgängliga branscher <---");
       List<String> industrylist = new ArrayList<>(indutries);

       for (int i = 0; i < industrylist.size(); i++)
       {
           System.out.println((i +1) + ". " + capitalize(industrylist.get(i)));
       }

       System.out.println("Välj en branch (1-" + industrylist.size() + "): ");

       int choice;
       try
       {
           choice = scanner.nextInt();
           scanner.nextLine();
       } catch (InputMismatchException e) {
           System.out.println("Ange ett giltigt nummer!");
           scanner.nextLine();
           return;
       }

       String selected = industrylist.get(choice -1 );
       List<Candidate> filtered = service.filterByIndustry(selected);

       System.out.println("\n--> Kandidater i branschen: " + capitalize(selected) + " <--");
       printCandidates(filtered);
   }

   private static String capitalize (String text)
   {
       if (text == null || text.isEmpty())
       {
           return "";
       }
       text = text.trim();
       return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
   }

   private static void showTopExperiencedCandidates()
   {
       List<Candidate> top = service.getTopexperiencedCandidates(3);
       System.out.println("\n ---> Topp 3 mest erfarna kandidater <---");
       printCandidates(top);
       System.out.println("");
   }






}
