package EEM_CompGenerator;

import java.util.Arrays;
import java.util.List;

public class SourceGen extends CodeGenerator implements Namespaces, Functionallity {
   private String[] runableNames;
   private String[] runabeleFileNames;

   public String[] getRunableNames() {
      return this.runableNames;
   }

   public void setRunableNames(String[] runnableNames) {
      this.runableNames = runnableNames;
   }

   public SourceGen(String _compName, String[] _runableNames, String[] _runableFileNames) {
      super(_compName);
      this.runableNames = _runableNames;
      this.runabeleFileNames = _runableFileNames;
   }

   public SourceGen(String _compName, String[] _runableNames) {
      super(_compName);
      this.runableNames = _runableNames;
      this.runnableNamesGeneration();
   }

   public SourceGen(String[] _runableNames) {
      super("NOT_ENTERED");
      this.runableNames = _runableNames;
      this.runnableNamesGeneration();
   }

   public void runnableNamesGeneration() {
      this.runabeleFileNames = new String[this.runableNames.length];

      for(int loopVal = 0; loopVal < this.runableNames.length; ++loopVal) {
         String[] var10000 = this.runabeleFileNames;
         String var10002 = super.getComponentName().toString();
         var10000[loopVal] = var10002 + "_ru" + this.runableNames[loopVal] + ".c";
      }

   }

   public String toString() {
      return "Runnable file names: " + Arrays.toString(this.runabeleFileNames);
   }

   public String nameGeneration() {
      String fileName = null;
      fileName = this.getComponentName().toString() + ".c";
      return fileName;
   }

   public void headerCommentPhase() {
   }

   public void headerPhase() {
   }

   public void sourceCommentPhase() {
   }

   public void sourcePhase() {
   }

   public void activePhase(List<String> phase) {
   }
}
