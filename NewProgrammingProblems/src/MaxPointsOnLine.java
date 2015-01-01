import java.util.HashMap;

  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
public class MaxPointsOnLine {

    public static int maxPoints(Point[] points) {
        if(points==null||points.length==0) return 0;
        HashMap<Double,Integer> map = new HashMap<Double, Integer>();
        int global = 0;
        for(int j = 0; j < points.length; ++j){
        	map.clear();
        	int local = 0;
            int addition = 0;
            for(int i = 0; i < points.length; ++i){
                if(points[i].x==points[j].x && points[i].y==points[j].y){
                    addition++;
                    continue;
                }
                double key = Double.MAX_VALUE;
                if(points[i].y!=points[j].y){
                	if(points[i].x==points[j].x){
                		key = 0.0;
                	}else{
                		key = (double)(points[i].x - points[j].x)/(double)(points[i].y- points[j].y);
                	}
                }
                if(map.containsKey(key)){
                    map.put(key, map.get(key)+1);
                    local = Math.max(local, map.get(key));
                }else{
                    map.put(key, 1);
                }
            }
            global = Math.max(global, local+addition);
        }
        return global;
    }	
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] input = {new Point(0,9),new Point(138,429),new Point(115,359),new Point(115,359),new Point(-30,-102),new Point(230,709),new Point(-150,-686),new Point(-135,-613),new Point(-60,-248),new Point(-161,-481),new Point(207,639),new Point(23,79),new Point(-230,-691),new Point(-115,-341),new Point(92,289),new Point(60,336),new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),new Point(150,774)};
		System.out.println(maxPoints(input));
	}

}
