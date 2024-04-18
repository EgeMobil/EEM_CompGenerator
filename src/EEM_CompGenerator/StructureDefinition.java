package EEM_CompGenerator;

public class StructureDefinition implements Namespaces {
   
   private String structComment;
   private String structureName;
   
   private String[] fieldTypes;
   private String[] fields;
   private String[] dataComments;

   public StructureDefinition(String _structureName, String _structComment , String[] _fieldTypes, String[] _fields, String[] _dataComments) {
	   this.structureName = _structureName;
	   this.structComment = _structComment;
	   this.fieldTypes = _fieldTypes;
	   this.fields = _fields;
	   this.dataComments = _dataComments;
   }

public String getStructureName() {
      return this.structureName;
   }

   public void setStructureName(String structureName) {
      this.structureName = structureName;
   }

   public String[] getFieldTypes() {
      return this.fieldTypes;
   }

   public void setFieldTypes(String[] _fieldTypes) {
      this.fieldTypes = _fieldTypes;
   }

   public String[] getFields() {
      return this.fields;
   }

   public void setFields(String[] fields) {
      this.fields = fields;
   }

   public String getStructComment() {
      return this.structComment;
   }

   public String[] getDataComments() {
      return this.dataComments;
   }

   public void setDataComments(String[] dataComments) {
      this.dataComments = dataComments;
   }

   public void setStructComment(String structComment) {
      this.structComment = structComment;
   }

   public String nameGeneration() {
      return null;
   }
}
