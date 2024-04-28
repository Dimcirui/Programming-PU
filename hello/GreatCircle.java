public class GreatCircle {
    public static void main(String[] args) {
        double r = 6371.0;
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double sqrsinx = Math.sin((x2-x1)/2) * Math.sin((x2-x1)/2);
        double sqrsiny = Math.sin((y2-y1)/2) * Math.sin((y2-y1)/2);
        double dist = 2 * r * Math.asin(Math.sqrt(sqrsinx + Math.cos(x1)*Math.cos(x2)*sqrsiny));

        System.out.println(dist + " kilometers");
    }
}