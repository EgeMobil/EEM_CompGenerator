package EEM_CompGenerator;

public class DataDefinition implements Namespaces {
   private String dataName;
   private String dataType;
   private String dataComment;

   public String getDataName() {
      return this.dataName;
   }

   public void setDataName(String dataName) {
      this.dataName = dataName;
   }

   public String getDataType() {
      return this.dataType;
   }

   public void setDataType(String dataType) {
      this.dataType = dataType;
   }

   public String getDataComment() {
      return this.dataComment;
   }

   public void setDataComment(String dataComment) {
      this.dataComment = dataComment;
   }

   public String nameGeneration() {
      return null;
   }
}
