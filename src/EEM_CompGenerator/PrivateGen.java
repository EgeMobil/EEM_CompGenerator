package EEM_CompGenerator;

import java.util.List;

public class PrivateGen extends CodeGenerator implements Namespaces, Functionallity {
   public int publicHeaderCount;

   public PrivateGen(String _compName) {
      super(_compName);
   }

   public PrivateGen() {
      super("NOT_ENTERED");
   }

   public String toString() {
      return "Private file name: " + this.nameGeneration();
   }

   public String nameGeneration() {
      String fileName = null;
      fileName = this.getComponentName().toString() + "_private.h";
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
