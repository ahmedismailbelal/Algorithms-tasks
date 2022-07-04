package p12;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Divide and Conquer to get the cloest pair of points
 * 
 * O(nlogn) time complexity
 *
 */
public class pair_of_points {

	public static void main(String[] args) {

		Point[] points = new Point[6];

		points[0] = new Point(2, 3);
		points[1] = new Point(12, 30);
		points[2] = new Point(40, 50);
		points[3] = new Point(5, 1);
		points[4] = new Point(12, 10);
		points[5] = new Point(3, 4);

		double minDist = closest_pair_of_points(points);
		//System.out.println(minDist);
		double minDistBruteForce = min_distance(points);
		System.out.println("The closest distance between two pairs is " +minDistBruteForce);

	}

	
	private static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
	}

	
	public static double min_distance(Point[] P) {
		double minimum = Double.MAX_VALUE;
		int number = P.length;
		for (int i = 0; i < number; i++) {
			for (int j = i + 1; j < number; j++) {
				minimum = Math.min(minimum, distance(P[i], P[j]));
			}
		}
		return minimum;
	}

	
	public static double closest_pair_of_points(Point[] P) {
		System.out.println("Before sorting:");
		System.out.println(Arrays.toString(P));
		Arrays.sort(P, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.x - p2.x;
			}
		});
		System.out.println("After sorting in x axis:");
		System.out.println(Arrays.toString(P));

		return closest_recurtion(P, 0, P.length - 1);
	}
	
	private static double strip_Closest_Points(Point[] strip, int stripLen,double dist_Min) {
		
		Arrays.sort(strip, 0, stripLen, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.y - p2.y;
			}
		});

		System.out.println("After sorting in y axis for strip:");
		System.out.println(Arrays.toString(strip));
		
		double new_Min = dist_Min;
		
		
		for (int i=0; i<stripLen; i++) {
			for(int j=i+1; j<stripLen && (strip[j].y - strip[i].y < new_Min); j++) {
				new_Min = Math.min(new_Min, distance(strip[i], strip[j]));
			}
		}
		
		return new_Min;
	}

	
	private static double closest_recurtion(Point[] P, int begin_Of_Array, int end_Of_Array) {
		int number = end_Of_Array - begin_Of_Array + 1;
		if (number <= 3) {	
			return min_distance(P);
		}

		int middle = number/2;		
		Point mid_Point = P[middle];

		
		double left = closest_recurtion(P, begin_Of_Array, middle);
		double right = closest_recurtion(P, middle, end_Of_Array);

		
		double dist_Min = Math.min(left, right);
		Point[] strip_Area = new Point[number];
		int strip_Len = 0;
		
		
		for (int i = 0; i < number; i++) {
			if (Math.abs(P[i].x - mid_Point.x) < dist_Min) {
				strip_Area[strip_Len] = P[i];
				strip_Len++;
			}
		}

		
		return Math.min(dist_Min, strip_Closest_Points(strip_Area, strip_Len, dist_Min));
		}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}

}