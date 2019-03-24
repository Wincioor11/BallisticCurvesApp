package ballisticcurvesapp;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;

/**
 *
 * Class which makes the graphical interpretation of the ballistic curve with 
  user's parameters taken from Data class variables.
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D4E13BE5-C37A-C90F-8D39-03CEA045826C]
// </editor-fold> 
public class DrawPanel{
    /** Stores the value of gravity wchich is used in calculations*/
    static double g = 9.81; //gravity
    /** Constructor*/
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DDF95BD8-3CBE-360A-AA9E-902009CB777E]
    // </editor-fold> 
    public DrawPanel () {
        //constructor
    }
 /**
 *
 * This method creates the final graph using other methods from this class 
  to do it.
 * @return JPanel with is the final graph which will be displayed by MainClass.
 */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B3752281-FC2C-7ABF-7FDD-453E9C6E7937]
    // </editor-fold> 
    public static JPanel createFinalPanel () {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
    
 /**
 *
 * This method creates plot and sets its features such as plot legend 
  and background.
 * @param XYDataset wchich is calculated and returned by the createDataset method.
 * @return JFreeChart wchich is a plot.
 */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FAE62BA0-C20C-D913-B455-47ADADD3379B]
    // </editor-fold> 
    private static JFreeChart createChart (XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Ballistic Curve", "X [m]", 
                "Y [m]", dataset, PlotOrientation.VERTICAL,
                false, false, false);
        chart.setBackgroundPaint(Color.GRAY);
        
        return chart;
    }
/**
 *
 * This method calculates y value for each x in equal intervals. 
  It's the mathematical basis for drawing a graph.
 * @return XYDataset wich is dataset of x and y values of ballistic curve.
 */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A8314115-9F2A-A9EA-CF3F-EAF594E19A77]
    // </editor-fold> 
    private static XYDataset createDataset () {
        double beta = Data.kFactor/Data.mass;
        double rad = Math.toRadians(Data.angle);
        
        XYSeries Ser = new XYSeries("Krzywa");
        
       double v_0x = Data.velocity * Math.cos(rad);
        double v_0y = Data.velocity * Math.sin(rad);
        
        
        double x =0;
        double y =0;
        for(double t = 0; t  <= (2*v_0y / g) ; t+=0.001){
            x =  Math.log(1+ (v_0x * beta *t)) / beta;
            y =  ((-g*t)/beta) + ((v_0y + g/beta)/beta) * (1 - Math.pow(Math.E, -beta*t));
            if(y >= 0){
                //System.out.println("x = "+x+"  y = "+y);
                Ser.add(x, y);
            }
        }
        
        
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(Ser);
        
        return dataset;
    }

}
