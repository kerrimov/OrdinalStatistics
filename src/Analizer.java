import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

public class Analizer {
	private double[] numbers;

	public Analizer(double[] Array) {
		this.numbers = Array;
	}

	public static Analizer extruder(JEditorPane field) { 

		Scanner scr = new Scanner(field.getText());  
		ArrayList<Double> numbs = new ArrayList<>();

		while (scr.hasNext()) {                        
			numbs.add(Double.parseDouble(scr.next()));
		}
		scr.close();
		double[] numbers = new double[numbs.size()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbs.get(i).doubleValue();
		}
		Arrays.sort(numbers);
		Analizer analizer = new Analizer(numbers);
		return analizer;

	}

	public String FindStatistic(int stat){
		try{
			return (new Double(this.numbers[stat-1])).toString();
		}
		catch (Exception e){
				JOptionPane.showMessageDialog(null, "Ошибка при вводе данных. Повторите, пожалуйста, ввод", "Error",
				JOptionPane.ERROR_MESSAGE);
			}
		return "Error";
		}
	

	
	public String FindStatistic2(int stat){
		try{
			return (new Double(this.numbers[numbers.length-stat])).toString();
		}
		catch (Exception e){
				JOptionPane.showMessageDialog(null, "Ошибка при вводе данных. Повторите, пожалуйста, ввод", "Error",
				JOptionPane.ERROR_MESSAGE);
			}
		return "Error";
		}
	


//КОРМЕН ИЛИ АХО ЗА Н (А НЕ ЗА ЛОГАРИФМ)

public String LinTime(int k){
	try{
		int stat = MedianaMedian(this.numbers, 0, this.numbers.length, k);
		return stat + " ";
	}
    catch (Exception e){
    	JOptionPane.showMessageDialog(null, "Ошибка при вводе данных. Повторите, пожалуйста, ввод", "Error",
				JOptionPane.ERROR_MESSAGE);
    }
	return "Error";
}

	private static int MedianaMedian(double[] numbers, int ind1, int length, int k) {   
    if (length == 1) {
       return (int) numbers[ind1];
    }
    int median = poiskMedian(numbers, ind1, length);
    int pivot = MedianaMedian(numbers, ind1, median, (median - 1) / 2 + 1);
    int[] pos = QuickSelect(numbers, ind1, length, pivot);
    if (ind1 + k - 1 >= pos[0] && ind1 + k - 1 < pos[1]) {
        return pivot; 
    } else if (ind1 + k - 1 < pos[0]) {
        return MedianaMedian(numbers, ind1, pos[0] - ind1, k);
    } else {
        return MedianaMedian(numbers, pos[1], length - (pos[1] - ind1), k - (pos[1] - ind1));
    }
    }
	
	 private static int[] QuickSelect(double[] numbers, int ind1, int length, int pivot) {
		    int i = ind1, n = ind1, r = ind1 + length - 1;
		    while (n <= r) {
		        if (numbers[n] < pivot) {
		            int tmp = (int) numbers[n];
		            numbers[n++] = numbers[i];
		            numbers[i++] = tmp;
		        } else if (numbers[n] > pivot) {
		            int tmp = (int) numbers[n];
		            numbers[n] = numbers[r];
		            numbers[r--] = tmp;
		        } else {
		            n++;
		        }
		    }
		    return new int[] {i, n};
		    }

    private static int poiskMedian (double[] numbers, int ind1, int length) {
    final int median = (length + 4) / 5; 
    for (int m = 0; m < median; m++) {
        final int mbegin = ind1 + 5 * m; 
        final int mend = ind1 + Math.min(5 * (m + 1), length); 

        for (int i = mbegin, j = mbegin; i < mend - 1; j = i++) {  
            int tmp = (int) numbers[i + 1];
            while (j >= mbegin && numbers[j] > tmp) {
                numbers[j + 1] = numbers[j--];
            }
            numbers[j + 1] = tmp;
        }
        
        final int mid = (mbegin + mend) / 2; 
        int tmp = (int) numbers[ind1 + m];
        numbers[ind1 + m] = numbers[mid];
        numbers[mid] = tmp;
    }
    return median;
    }
    
   

    
}
