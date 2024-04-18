package EEM_CompGenerator;

public class Definition {
   private DataDefinition[] datas;
   private StructureDefinition[] structures;
   private EnumDefinition[] enums;

   public Definition(DataDefinition[] _datas , StructureDefinition[] _structures , EnumDefinition[] _enums )
   {
	   this.datas = _datas;
	   this.structures = _structures;
	   this.enums = _enums;
   }
   
   public DataDefinition[] getDatas() {
      return this.datas;
   }

   public void setDatas(DataDefinition[] datas) {
      this.datas = datas;
   }

   public StructureDefinition[] getStructures() {
      return this.structures;
   }

   public void setStructures(StructureDefinition[] structures) {
      this.structures = structures;
   }

   public EnumDefinition[] getEnums() {
      return this.enums;
   }

   public void setEnums(EnumDefinition[] enums) {
      this.enums = enums;
   }
}
