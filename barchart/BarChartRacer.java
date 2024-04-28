import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        In in = new In(filename);
        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        in.readLine();
        BarChart chart = new BarChart(title, xAxis, source);

        while (in.hasNextLine()) {
            StdDraw.clear();

            int num = Integer.parseInt(in.readLine());
            String year = "";
            Bar[] bars = new Bar[num];

            for (int i = 0; i < num; i++) {
                String line = in.readLine();
                String[] sep = line.split(",");
                year = sep[0];
                String name = sep[1];
                String country = sep[2];
                int value = Integer.parseInt(sep[3]);
                String category = sep[4];

                bars[i] = new Bar(name, value, category);
            }
            in.readLine();

            chart.setCaption(year);
            // sort() is ascend order
            Arrays.sort(bars);
            for (int i = num - 1; i > num - 1 - k; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            
            chart.draw();
            StdDraw.show();
            StdDraw.pause(1000);
            chart.reset();
        }
    }
}
