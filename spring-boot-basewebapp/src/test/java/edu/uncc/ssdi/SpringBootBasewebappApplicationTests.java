package edu.uncc.ssdi;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBasewebappApplicationTests {
	
	@Test
	public void contextLoads() {
		//Collection collection = new ArrayList();
		//assertTrue(collection.isEmpty());

		ArrayList arrayList = mock(ArrayList.class);
		 
        // program the mock object to return "hello world" when get(0) is called
        given(arrayList.get(0)).willReturn("Mock- Health Care Heroes");
 
        // this will output "hello world", since that was what the mock object was told to return
        System.out.println(arrayList.get(0));
		
	}

	@Test
	public void testEmptyCollection() {
		//System.out.println("Test Case 1");

		Collection collection = new ArrayList();
		assertTrue(collection.isEmpty());
	}
	
	
	  public static junit.framework.Test suite() {
	        return new junit.framework.JUnit4TestAdapter(SpringBootBasewebappApplicationTests.class);
	    }
	  
	  
	  public static void main(String args[]) {
	      org.junit.runner.JUnitCore.main("edu.uncc.ssdi.SpringBootBasewebappApplicationTests");
	    }

}
