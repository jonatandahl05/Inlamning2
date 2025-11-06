
# 🧑‍💼 Rekryteringssystem – Java

Ett rekryteringssystem skrivet i Java där man kan lägga till, ta bort och visa kandidater via en meny i konsolen.

Programmet har stöd för:
- Lägg till nya kandidater
- Visa alla kandidater
- Ta bort kandidater
- Filtrera efter bransch
- Sortera efter erfarenhet
- Visa topp 3 mest erfarna
- Ladda in färdiga kandidater så slipper man skriva själv
---

## ⚙️ Kort om hur det funkar
Programmet är uppdelat i flera klasser för att hålla det tydligt och följa SOLID-principerna:
- **RecruitmentApp** → sköter menyer och användargränssnitt
- **CandidateService** → innehåller logiken, filtrering och sortering
- **CandiateRepository (och ICandidateRepository)** → lagrar och hanterar kandidater
- **CandidateFilter + IndustryFilter** → visar hur man kan bygga vidare med Open/Closed-principen

All inmatning är skyddad med `try-catch` och programmet loggar händelser med **SLF4J**.

---

### 🧪 Tester
Jag har även lagt till enhetstester med **JUnit 5** och **Mockito** som testar:
- Att kandidater läggs till korrekt
- Att filtrering och sortering fungerar

---

### 🧩 Struktur & SOLID
Jag har delat upp systemet i flera klasser för att hålla det tydligt och följa SOLID:
- **RecruitmentApp** – sköter menyer och användargränssnitt
- **CandidateService** – hanterar logiken
- **CandiateRepository (och ICandidateRepository)** – sköter lagringen
- **CandidateFilter + IndustryFilter** – visar hur man kan bygga vidare med Open/Closed-principen

Service-klassen tar emot ett interface istället för en konkret klass → följer **Dependency Inversion Principle**  
Och filterklasserna visar **Open/Closed Principle** – jag kan lägga till fler filter utan att ändra befintlig kod.


---

### 🤖 Prompt Engineering och AI-stöd

Jag använde ChatGPT vid några tillfällen under utvecklingen för att få hjälp att förstå vissa delar av uppgiften bättre.  
Till exempel använde jag AI-stöd när jag skulle:
- komma på tydliga och beskrivande namn till mina JUnit-tester,
- förstå hur Mockito fungerar för att skapa mockade objekt,
- och få en förklaring på hur jag kunde strukturera CandidateService och CandiateRepository enligt SOLID-principer.
- Få en fin readme fil :)

Jag märkte snabbt att resultaten blev mycket bättre när jag skrev mer specifika prompts.  
Till exempel gav “hur testar jag min Addcandidate metod i java?” ett mer användbart svar  
än bredare frågor som “hur gör man enhetstester i Java?”.  
Det hjälpte mig att förstå grunderna i prompt-engineering, att ställa tydliga frågor och använda svaren som stöd för eget lärande.

🧠 Skapat av **Jonatan Dahl** – Individuell Labb 2 (Kompetenskontroll 2)
=======
# Inlamning2
>>>>>>> 
