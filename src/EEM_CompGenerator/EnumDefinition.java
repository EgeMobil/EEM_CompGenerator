package EEM_CompGenerator;

public class EnumDefinition implements Namespaces {
   protected String enumName;
   protected String[] fields;
   protected String enumComment;

   public EnumDefinition(String _enumName, String _enumComment, String[] fields) {
      this.enumName = _enumName;
      this.enumComment = _enumComment;
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
