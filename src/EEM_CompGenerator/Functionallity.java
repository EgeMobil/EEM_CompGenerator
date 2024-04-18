package EEM_CompGenerator;

import java.util.List;

public abstract interface Functionallity {
   public String PREPROCESSOR = "#";
   public String ANGLEBRAKELETLEFT = "<";
   public String ANGLEBRAKELETRIGHT = ">";
   public String SEMICOLON = ";";
   public String BRACELEFT = "(";
   public String BRACERIGHT = ")";
   public String CURLYLEFT = "{";
   public String CURLYRIGHT = "}";

   public void headerCommentPhase(List<String> phase);
   public void headerPhase(List<String> phase);
   public void sourceCommentPhase(List<String> phase);
   public void sourcePhase(List<String> phase);
   public void activePhase(List<String> phase);
     
}
