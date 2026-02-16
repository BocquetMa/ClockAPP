package appli;

import static org.junit.jupiter.api.Assertions.*;

import model.*;

import exception.ExceptionListeTableauPleine;
import exception.ExceptionMauvaisIndex;
import exception.ExceptionMauvaisNombreDElements;
import org.junit.jupiter.api.Test;

class TestListeTableau {
	@Test
	void test1DuConstructeur() throws ExceptionMauvaisNombreDElements {
		ListeTableau<String> lst;
		lst = new ListeTableau<String>(5);
		assertTrue(lst.estVide());
		assertEquals(0, lst.taille());
	}
	@Test
	void test2DuConstructeur() {
		Exception e = assertThrows(ExceptionMauvaisNombreDElements.class, () -> new ListeTableau<String>(0));
		assertEquals("Le nombre d'éléments (0) n'est pas supérieur à 0 !", e.getMessage());
	}
	@Test
	void test1DAjoutEtElement() throws ExceptionMauvaisNombreDElements, ExceptionListeTableauPleine, ExceptionMauvaisIndex {
		ListeTableau<String> lst;
		lst = new ListeTableau<String>(3);
		lst.ajoute("un");
		assertEquals(1, lst.taille());
		assertEquals("un", lst.element(0));
		lst.ajoute("deux");
		assertEquals(2, lst.taille());
		assertEquals("deux", lst.element(1));
		lst.ajoute("trois");
		assertEquals(3, lst.taille());
		assertEquals("trois", lst.element(2));
	}
	@Test
	void test2DAjout() throws ExceptionMauvaisNombreDElements, ExceptionListeTableauPleine {
		ListeTableau<String> lst;
		lst = new ListeTableau<String>(2);
		lst.ajoute("un");
		lst.ajoute("deux");
		Exception e = assertThrows(ExceptionListeTableauPleine.class, () -> lst.ajoute("trois"));
		assertEquals("La liste ne contient plus aucun emplacement disponible !", e.getMessage());
	}
	@Test
	void test1DeRetraitEtElement() throws ExceptionMauvaisNombreDElements, ExceptionListeTableauPleine, ExceptionMauvaisIndex {
		ListeTableau<String> lst;
		lst = new ListeTableau<String>(3);
		lst.ajoute("un");
		lst.ajoute("deux");
		lst.ajoute("trois");
		lst.retire(0);
		assertEquals(2, lst.taille());
		assertEquals("deux", lst.element(0));
		assertEquals("trois", lst.element(1));
	}
	@Test
	void test2DeRetrait() throws ExceptionMauvaisNombreDElements, ExceptionListeTableauPleine, ExceptionMauvaisIndex {
		ListeTableau<String> lst;
		lst = new ListeTableau<String>(3);
		lst.ajoute("un");
		lst.ajoute("deux");
		lst.ajoute("trois");
		Exception e = assertThrows(ExceptionMauvaisIndex.class, () -> lst.retire(3));
		assertEquals("L'index (3) n'est pas compris entre 0 et 2 inclus", e.getMessage());
	}
	@Test
	void testDAppartenance() throws ExceptionMauvaisNombreDElements, ExceptionListeTableauPleine, ExceptionMauvaisIndex {
		ListeTableau<String> lst;
		lst = new ListeTableau<String>(3);
		assertFalse(lst.contient("zero"));
		lst.ajoute("un");
		assertTrue(lst.contient("un"));
		lst.ajoute("deux");
		assertTrue(lst.contient("un"));
		assertTrue(lst.contient("deux"));
		lst.ajoute("trois");
		assertTrue(lst.contient("un"));
		assertTrue(lst.contient("deux"));
		assertTrue(lst.contient("trois"));
		assertFalse(lst.contient("quatre"));
	}
}
