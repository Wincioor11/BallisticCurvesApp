package ballisticcurvesapp;

/**
 * Class for storing input data and for calculating the maximum range.
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B12FEA69-8FAE-A662-A66B-0B634BB283FF]
// </editor-fold> 
public class Data{
    /** Stores the mass input value of the throwing object*/
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.51F8F0B5-8E03-C0C2-D792-6A7D2312F6C3]
    // </editor-fold> 
    protected static double mass;
    /** Stores the angle input value*/
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A7275270-5CDE-B645-6CA1-86B792D6540E]
    // </editor-fold> 
    protected static double angle;
    /** Stores the k factor input value*/
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FC9AEA37-94B1-B55B-06F6-189554009BBE]
    // </editor-fold> 
    protected static double kFactor;
    /** Stores the initial velocity input value*/
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C7795E2B-4887-8ED4-7732-6FC03630DFCA]
    // </editor-fold> 
    protected static double velocity;
    /** Stores the maximum range value calculated by calculate method*/
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A52851A4-3743-BB97-4E3C-C202F2FF21B1]
    // </editor-fold> 
    protected static double range;
    /**Constructor */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6744ABC3-C843-FF16-2FD1-8531EF67E150]
    // </editor-fold> 
    public Data () {
    }

 /**
 *
 * This method calculates the maximum range of the ballistic curve. It takes
  parameters from class variables.
 * @return double range 
 */
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.12CC8E9A-F088-B77D-0CD9-15869700A1AD]
    // </editor-fold> 
    protected static double calculate () {
        return (Math.pow(velocity, 2) * Math.sin(2*Math.toRadians(Data.angle)) / 9.81);
    }

}

