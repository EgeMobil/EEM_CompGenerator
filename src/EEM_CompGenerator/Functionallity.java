package EEM_CompGenerator;

import java.util.List;

public interface Functionallity {
   String PREPROCESSOR = "#";
   String ANGLEBRAKELETLEFT = "<";
   String ANGLEBRAKELETRIGHT = ">";
   String SEMICOLON = ";";
   String BRACELEFT = "(";
   String BRACERIGHT = ")";
   String CURLYLEFT = "{";
   String CURLYRIGHT = "}";

   void headerCommentPhase();

   void headerPhase();

   void sourceCommentPhase();

   void sourcePhase();

   void activePhase(List<String> var1);
}
