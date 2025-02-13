package pl.edu.pw.ee;

import java.util.ArrayList;
import java.util.List;

import pl.edu.pw.ee.services.Sorting;

public class QuickSort implements Sorting {

	@Override
	public void sort(double[] nums) {
		if (nums == null) {
			throw new IllegalArgumentException("Nums array cannot be null");
		}

		quicksort(nums);
	}

	private void quicksort(double[] data) {
		List<Integer> starts = new ArrayList<>();
		List<Integer> ends = new ArrayList<>();

		Integer left = 0;
		Integer right = data.length - 1;

		starts.add(left);
		ends.add(right);

		int n = 1;
		int pivot = 0;
		int count = 0;

		if (left < right) {

			while (n > 0) {
				n--;
				left = starts.get(count - n); // wprowadzowadzamy ,,count,, jako dodatnia zmienna poniwaz cykl jest
												// nieskonczony
				right = ends.get(count - n); // i jest nizbedne dodanie jakiegos elemuntu ktory moglby poruszac liste
												// dalej dla jej separacji
				pivot = splitData(data, left, right);

				if (pivot - 1 > left) {
					starts.add(left);
					ends.add(pivot - 1);
					n++;
					count++;
				}

				if (pivot + 1 < right) {
					starts.add(pivot + 1);
					ends.add(right);
					n++;
					count++;
				}
			}
		}
	}

	private int splitData(double[] data, int start, int end) {
		int left = start + 1;
		int right = end;

		while (left < right) {
			while (left < right && data[left] < data[start]) {
				left++;
			}

			while (left < right && data[right] >= data[start]) {
				right--;
			}

			swap(data, left, right);
		}

		if (data[left] >= data[start]) {
			left--;
		}

		swap(data, start, left);

		return left;
	}

	private void swap(double[] data, int firstId, int secondId) {
		if (firstId != secondId) {
			double firstValue = data[firstId];
			data[firstId] = data[secondId];
			data[secondId] = firstValue;
		}
	}

}