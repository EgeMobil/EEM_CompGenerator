package EEM_CompGenerator;

public class DataDefinition implements Namespaces {
   private String dataName;
   private String dataType;
   private String dataComment;

   /* Constructor */
   public DataDefinition(String _dataName, String _dataType, String _dataComment) {
	   this.dataName = _dataName;
	   this.dataType = _dataType;
	   this.dataComment = _dataComment;
   }

/* Get/Set Methods */
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
