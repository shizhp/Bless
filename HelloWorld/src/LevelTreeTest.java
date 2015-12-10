import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LevelTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLevelofTreeTreeNodeInt()throws Exception {
		LevelTree levelTreeTest = new LevelTree();
		assertEquals("A",levelTreeTest.levelofTree(levelTreeTest.createTree("ABG##H##DC##F##"), 1));
		levelTreeTest.setIndex();
		assertEquals("BD",levelTreeTest.levelofTree(levelTreeTest.createTree("ABG##H##DC##F##"), 2));
		levelTreeTest.setIndex();
		assertEquals("GHCF",levelTreeTest.levelofTree(levelTreeTest.createTree("ABG##H##DC##F##"), 3));
		//levelTreeTest.setIndex();
		//assertEquals("Exception",levelTreeTest.levelofTree(levelTreeTest.createTree("ABG##H##DC##F##"), 0));
		//levelTreeTest.setIndex();
		//assertEquals("A",levelTreeTest.levelofTree(levelTreeTest.createTree(""), 1));
		levelTreeTest.setIndex();
		assertEquals("A",levelTreeTest.levelofTree(levelTreeTest.createTree("A#B#C##"), 1));
		levelTreeTest.setIndex();
		assertEquals("B",levelTreeTest.levelofTree(levelTreeTest.createTree("A#B#C##"), 2));
		levelTreeTest.setIndex();
		assertEquals("C",levelTreeTest.levelofTree(levelTreeTest.createTree("A#B#C##"), 3));
	}

}
