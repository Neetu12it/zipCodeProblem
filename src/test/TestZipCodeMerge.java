package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zipcodeRangeMerge.ZipCode;
import com.zipcodeRangeMerge.ZipCodeMerge;

class TestZipCodeMerge {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMergeZipCodeRange1() {

		ZipCode arr[]=new ZipCode[4]; 
		arr[0]=new ZipCode(94330, 94339);
		arr[1]=new ZipCode(94530, 94639);
		arr[2]=new ZipCode(94230, 94439);
		arr[3]=new ZipCode(94830, 94939);
		arr= sortArray(arr); 
		ZipCodeMerge obj= new ZipCodeMerge();
		List<ZipCode>arr1=obj.mergeZipCodeRange(arr);
		assertNotNull(arr1);
		assertEquals(arr1.get(0).zipCodeStart,94230 );
		assertEquals(arr1.get(0).zipCodeEnd,94439 );
		}
	@Test
	void testMergeZipCodeRange2() {
		ZipCode arr[]=new ZipCode[8]; 
		arr[0]=new ZipCode(94130, 94239);
		arr[1]=new ZipCode(94230, 94339);
		arr[2]=new ZipCode(94430, 94539);
		arr[3]=new ZipCode(94530, 94639);
		arr[4]=new ZipCode(94000, 94349);
		arr[5]=new ZipCode(94640, 94700);
		arr[6]=new ZipCode(94769, 94839);
		arr[7]=new ZipCode(94840, 94939);
		arr= sortArray(arr);
		ZipCodeMerge obj= new ZipCodeMerge();
		List<ZipCode>arr1=obj.mergeZipCodeRange(arr);
		assertNotNull(arr1);
		assertEquals(arr1.get(0).zipCodeStart,94000 );
		assertEquals(arr1.get(0).zipCodeEnd,94349 );
		assertEquals(arr1.get(4).zipCodeStart,94840 );
		assertEquals(arr1.get(4).zipCodeEnd,94939 );
		}
	
	static ZipCode[] sortArray(ZipCode arr[]){
	Arrays.sort(arr,new Comparator<ZipCode>(){ 
		public int compare(ZipCode i1,ZipCode i2) 
			{ 
				return i1.zipCodeStart-i2.zipCodeStart; 
			} 
	});
	return arr;

}
	void testMergeZipCodeRange3() {
		ZipCode arr[]=null; 
		ZipCodeMerge obj= new ZipCodeMerge();
		List<ZipCode>arr1=obj.mergeZipCodeRange(arr);
		assertNull(arr1);
		
		}
}
