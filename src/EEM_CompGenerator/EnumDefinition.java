package EEM_CompGenerator;

public class EnumDefinition implements Namespaces {
   private String enumName;
   private String[] fields;
   private String enumComment;

   public EnumDefinition(String _enumName, String[] fields) {
      this.enumName = _enumName;
      this.fields = fields;
   }

   public String getEnumName() {
      return this.enumName;
   }

   public void setEnumName(String _enumName) {
      this.enumName = _enumName;
   }

   public String[] getFields() {
      return this.fields;
   }

   public void setFields(String[] fields) {
      this.fields = fields;
   }

   public String getEnumComment() {
      return this.enumComment;
   }

   public void setEnumComment(String enumComment) {
      this.enumComment = enumComment;
   }

   public String nameGeneration() {
      return null;
   }
}
