package self.demo.geo;

import java.util.Comparator;
public class SortByPointDistance implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Point s1 = (Point) o1;
		Point s2 = (Point) o2;
		  if (s1.getDistance() > s2.getDistance()){
			  return 1;  
		  }
		   
		return 0;
	}

}
