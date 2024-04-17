package EEM_CompGenerator;

import java.util.List;

public class PublicGen extends CodeGenerator implements Namespaces, Functionallity {
   public PublicGen(String _compName) {
      super(_compName);
   }

   public PublicGen() {
      super("NOT_ENTERED");
   }

   public String toString() {
      return "Public file name: " + this.nameGeneration();
   }

   public String nameGeneration() {
      String fileName = null;
      fileName = this.getComponentName().toString() + "_public.h";
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
