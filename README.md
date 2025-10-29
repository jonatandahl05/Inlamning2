# 🧑‍💼 Rekryteringssystem – Java

Ett rekryteringssystem skrivet i Java där man kan lägga till, ta bort och visa kandidater via en meny i konsolen.

Programmet har stöd för:
- Lägg till nya kandidater
- Visa alla kandidater
- Ta bort kandidater
- Filtrera efter bransch
- Sortera efter erfarenhet
- Visa topp 3 mest erfarna
- Ladda in färdiga kandidater för test

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

### 💬 Kort reflektion
Jag lärde mig mycket om hur man delar upp ansvar i klasser, använder `Stream API`,  
och hur viktigt det är med felhantering och tester för att göra ett stabilt program.

---

🧠 Skapat av **Jonatan Dahl** – Individuell Labb 2 (Kompetenskontroll 2)
