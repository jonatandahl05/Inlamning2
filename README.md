
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

### ⚙️ Kort om hur det funkar
Koden är uppdelad i tre delar:
- **RecruitmentApp** → sköter menyer och användargränssnitt
- **CandidateService** → logiken, filtrering och sortering
- **CandiateRepository** → lagring och hantering av kandidater

All inmatning är skyddad med `try-catch` och programmet loggar händelser med **SLF4J**.

---

### 🧪 Tester
Jag har även lagt till enhetstester med **JUnit 5** och **Mockito** som testar:
- Att kandidater läggs till korrekt
- Att filtrering och sortering fungerar

---

### 🧩 Klassval och SOLID-principer
Jag valde att skapa `CandidateService` för att separera logiken från användargränssnittet,  
vilket följer Single Responsibility Principle – varje klass har ett tydligt ansvar.  
`CandiateRepository` skapades för att hantera datalagring och operationer,  
vilket gör programmet lättare att underhålla och följer **Open/Closed Principle**,  
eftersom jag kan lägga till nya sätt att spara data utan att ändra befintlig kod.  
Dessutom används **Dependency Inversion Principle** när `CandidateService` tar emot  
ett repository som parameter – det gör klasserna oberoende och lätta att testa.


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
