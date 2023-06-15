User(UserID [PK], Username, Password, Role)
Case(CaseID [PK], Name, Gender, Age, Contact, Diagnosis, Treatment, Isolation)
Test(TestID [PK], CaseID [FK], TestTime, TestResult, TestFacility)
ContactPerson(ContactID [PK], CaseID [FK], Name, Gender, Age, Contact)
