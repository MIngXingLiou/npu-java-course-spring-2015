/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

/**
 *Please do not strictly View
 * Please have a cross-like
 * Please let me pass
 * @author STP
 */


/**
 * The model class of the calculator application.
 */
public class Calculator extends java.util.Observable {
    String s = "",addend;
    int count,count2;
 
    /**
     * The available operators of the calculator.
     */
  
    public enum Operator {
        CLEAR,       // C
        CLEAR_ENTRY, // CE
        BACKSPACE,   // ⌫
        EQUAL,       // =
        PLUS,        // +
        MINUS,       // -
        TIMES,       // ×
        OVER,        // ⁄
        PLUS_MINUS,  // ±
        RECIPROCAL,  // 1/x
        PERCENT,     // %
        SQRT,        // √
        MEM_CLEAR,   // MC
        MEM_SET,     // MS
        MEM_PLUS,    // M+
        MEM_MINUS,   // M-
        MEM_RECALL   // MR
    }
    /**
     * Digital Append method
     * @param digit 
     */
    public void appendDigit(int digit) {
        s += String.valueOf(digit);
        getDisplay();
    }
    /**
     * The additional dot display
     * @param dot 
     */
    public void appendDot(String dot) {
        s += dot;
         getDisplay();
        
    }
    /**Join four arithmetic
     * 
     * @param operator 
     */
    public void performOperation(Operator operator) {
        if(operator == Operator.PLUS)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          addend = "+";
        }
        if(operator == Operator.CLEAR)
        {
          s= "";
          getDisplay() ;
          
        }
        if(operator == Operator.MINUS)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          addend = "-";
         
        }
        
         if(operator == Operator.TIMES)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          addend = "*";
        }
         
         if(operator == Operator.OVER)
        {
          count = Integer.parseInt(s);
          s= "";
          getDisplay() ;
          addend = "/";
        }
        /**
         * Enter "equal" four computing application
         */
       
        if(operator == Operator.EQUAL)
        {
            if("+".equals(addend))
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count+count2);
                getDisplay();
                
            }
            
            
            if("-".equals(addend))
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count-count2);
                getDisplay();
                
            }
           
             if("*".equals(addend))
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count*count2);
                getDisplay();
                //s= "";
            }
          
              if("/".equals(addend))
            {
                count2 = Integer.parseInt(s);
                s = String.valueOf(count/count2);
                getDisplay();
                
            }
           
            
        }
    
        
        
    }
    /**
     * Reception display processing
     * @return 
     */
    public String getDisplay() {
        setChanged();
	notifyObservers(s);
        return null;
    }
   
}