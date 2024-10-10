package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DoubleLinkedList;
import main.Station;

class StudentDLLTest {
	DoubleLinkedList<Station> DDL;
	Station s;

	@Test
	void initTest() {
		DDL = new DoubleLinkedList<Station>();
		assertTrue(DDL.head==null);
		assertTrue(DDL.tail==null);
	}
	
	@Test
	void insertTest() {
		DDL = new DoubleLinkedList<Station>();
		s = new Station("s");
		DDL.insert(s);
		assertTrue(DDL.head.data.equals(s));
		assertTrue(DDL.tail.data.equals(s));
		assertTrue(DDL.size==1);
		DDL.delete(s);
		assertTrue(DDL.get(s) == null);
	}

}
