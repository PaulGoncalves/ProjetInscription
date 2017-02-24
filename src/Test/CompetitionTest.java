package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

import static inscriptions.Inscriptions.*;

public class CompetitionTest {

 @Test
 public void testCompetition() {
  
  
 }

 @Test
 public void testGetNom() {
  inscriptions.Inscriptions inscriptions = getInscriptions();
  Competition compet = inscriptions.createCompetition("x", null, true);
  assertEquals("x", compet.getNom());
 }

 @Test
 public void testSetNom() {
  inscriptions.Inscriptions inscriptions = getInscriptions();
  Competition compet = inscriptions.createCompetition("x", null, true);
  compet.setNom("op");
  assertEquals("op", compet.getNom());
 }

 @Test
 public void testInscriptionsOuvertes() {
  
  Inscriptions inscriptions = Inscriptions.getInscriptions();
  Competition compet = inscriptions.createCompetition("P", LocalDate.now().plusDays(3), true);
  assertTrue(compet.inscriptionsOuvertes());
 }

 @Test
 public void testGetDateCloture() {
  Inscriptions inscriptions = Inscriptions.getInscriptions();
  Competition compet = inscriptions.createCompetition("", LocalDate.now(), false); 
  assertEquals(LocalDate.now(),compet.getDateCloture());
 }

 @Test
 public void testEstEnEquipe() {
  
  Inscriptions inscriptions = Inscriptions.getInscriptions();
  Competition compet = inscriptions.createCompetition("P", LocalDate.now().plusDays(20), true); 
  assertEquals(true,compet.estEnEquipe());
  
 }

 @Test
 public void testSetDateCloture() {
  LocalDate date = LocalDate.now().plusDays(10);
  LocalDate  date1 = LocalDate.now().plusDays(20);
  Inscriptions inscriptions = Inscriptions.getInscriptions();
  Competition compet = inscriptions.createCompetition("x", date, true);
  compet.setDateCloture(date1);
  assertEquals(date1,compet.getDateCloture());
 }
 

 @Test
 public void testAddPersonne() {
  
  Inscriptions inscriptions = Inscriptions.getInscriptions();
  LocalDate date = LocalDate.now().plusDays(20);
  Competition compet = inscriptions.createCompetition("test", date, false);
  Personne personne = inscriptions.createPersonne("test", "prenom", "mail");
  compet.add(personne);
  assertTrue(compet.getCandidats().contains(personne));
 }

 @Test
 public void testRemove() {
  Inscriptions inscri = Inscriptions.getInscriptions();
  LocalDate date = LocalDate.now().plusDays(20);
  Competition compet = inscri.createCompetition("test", date,false);
  Personne Personne = inscri.createPersonne("nom", "prenom", "mail");
  Personne Personne2 = inscri.createPersonne("nom", "prenom", "mail");
  compet.add(Personne);
  compet.add(Personne2);
  int sizeBefore = compet.getCandidats().size();
  compet.remove(Personne);
  int sizeAfter = compet.getCandidats().size();
  assertEquals(sizeBefore-1,sizeAfter);
 }

 



}