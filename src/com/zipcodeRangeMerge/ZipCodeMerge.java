package com.zipcodeRangeMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ZipCodeMerge {
	public  List<ZipCode> mergeZipCodeRange(ZipCode arr[]) {
		List<ZipCode> mergedCodes=null;
		if(arr.length>0) {
			mergedCodes = new ArrayList<ZipCode>();
		mergedCodes.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			ZipCode top = mergedCodes.get(mergedCodes.size() - 1);
			if (top.zipCodeEnd < arr[i].zipCodeStart)
				mergedCodes.add(arr[i]);
			else if (top.zipCodeEnd < arr[i].zipCodeEnd) {
				top.zipCodeEnd = arr[i].zipCodeEnd;
				mergedCodes.remove(mergedCodes.size() - 1);
				mergedCodes.add(top);
			}
		}
		return mergedCodes;
		}else {
			return mergedCodes;
		}
	}
	public static void main(String args[]) {
		ZipCode[] arr = getZipCodesRanges();
		ZipCodeMerge obj= new ZipCodeMerge();
		List<ZipCode> mergerdZip = obj.mergeZipCodeRange(arr);
		getMergedRanges(mergerdZip);
	}

	private static ZipCode[] getZipCodesRanges() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the size for the zip code");
		int numberElements = sc.nextInt();
		int start = 0;
		int end = 0;
		ZipCode arr[] = new ZipCode[numberElements];
		for (int i = 0; i < numberElements; i++) {
			System.out.println("Please enter LowerBound");
			start = Integer.parseInt(sc.next());
			System.out.println("Please enter UpperBound");
			end= Integer.parseInt(sc.next());
			arr[i] = new ZipCode(start, end);
		}
		Arrays.sort(arr, new Comparator<ZipCode>() {
			public int compare(ZipCode z1, ZipCode z2) {
				return z1.zipCodeStart - z2.zipCodeStart;
			}
		});
		return arr;
	}
	private static void getMergedRanges(List<ZipCode> mergerdZip) {
		Iterator<ZipCode> iterator = mergerdZip.iterator();
		while (iterator.hasNext()) {
			ZipCode iterrateValue = iterator.next();
			System.out.println("[" + iterrateValue.zipCodeStart + "," + iterrateValue.zipCodeEnd + "] ");
		}
	}
}
