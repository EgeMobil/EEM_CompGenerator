package EEM_CompGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefinitionGen extends CodeGenerator implements Namespaces, Functionallity {
   
   private Definition defs;

   public DefinitionGen(String _compName , String _author , String[] _otherComps) {
      super(_compName, _author, _otherComps, null );
   }
    
   public DefinitionGen() {
      super("NOT_ENTERED", null, null, null);
   }

   public void setDefs(Definition _def) {
      
	  this.defs = _def; 
	  
      EnumDefinition baseEnum = new EnumDefinition(
			  "dt" + super.getComponentName() + "Return", 
			  super.getComponentName() + "Base Return Type Definition" ,
			  new String[]{
					  super.getComponentName().toUpperCase() + "_" + ERR + " = 0 ,", 
					  super.getComponentName().toUpperCase() + "_" + EOK + " ,", 
					  super.getComponentName().toUpperCase() + "_" + UNKNOWN + " ,", 
					  }
			  );
           
      this.appendBaseEnum(baseEnum);   
      
   }

   public String toString() {
      return "Definition file name: " + this.nameGeneration();
   }

   public String nameGeneration() {
      String fileName = null;
      fileName = this.getComponentName().toString() + "_definition.h";
      return fileName;
   }
   
	public void appendBaseEnum(EnumDefinition newEnum) {
    	
    	EnumDefinition[] newFields = new EnumDefinition[ this.defs.getEnums().length + 1];
	    newFields[0] = newEnum;

	    System.arraycopy( this.defs.getEnums(), 0, newFields, 1, this.defs.getEnums().length );

	    this.defs.setEnums( newFields );
	}

   public void headerCommentPhase(List<String> phase) {
	   
      this.setDate(LocalDate.now());
      phase.add("/* ");
      phase.add(" * " + this.nameGeneration());
      phase.add(" * ");
      phase.add(" *  Created on: " + String.valueOf(this.getDate()));
      phase.add(" *      Author: " + this.getAuthor());
      phase.add("*/ ");
      phase.add(" ");
      super.addLines(phase);
   }

   public void headerPhase(List<String> phase) {
      
      phase.add("#ifndef " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_DEFINITION_H_");
      phase.add("#define " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_DEFINITION_H_");
      phase.add(" ");
      
      this.activePhase(phase);
      
      phase.add(" ");
      phase.add("#endif /* " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_DEFINITION_H_ */ ");
      super.addLines(phase);
   }

   public void activePhase(List<String> phase) {
	  
	  int loopVal=0;
	  int loopVal2=0;
	  
      DataDefinition[] datas;
      int dataSize = (datas = this.defs.getDatas()).length;

      for(loopVal = 0; loopVal < dataSize; ++loopVal) {
         DataDefinition data = datas[loopVal];
         phase.add("/**");
         phase.add(" * @brief Data definition ");
         phase.add(" * ");
         phase.add(" * " + data.getDataComment());
         phase.add(" */");
         phase.add( data.getDataType() + " " + data.getDataName() + ";");
         phase.add(" ");
      }

      StructureDefinition[] strs;
      int strSize = (strs = this.defs.getStructures()).length;
      
      for(loopVal = 0; loopVal < strSize; ++loopVal) {
         StructureDefinition str = strs[loopVal];
         phase.add("/**");
         phase.add(" * @brief Struct definition ");
         phase.add(" * ");
         phase.add(" * " + str.getStructComment());
         phase.add(" */");
         phase.add("typedef struct ");
         phase.add("{");

         for(loopVal2 = 0; loopVal2 < Math.min(str.getFieldTypes().length, str.getFields().length); ++loopVal2) 
         {
            phase.add("    /* " + str.getDataComments()[loopVal2] + " */");
            phase.add("    "    + str.getFieldTypes()[loopVal2] + " " + str.getFields()[loopVal2] + ";");
         }

         phase.add("}" + str.getStructureName() + "Type;");
         phase.add(" ");
      }

      EnumDefinition[] enms;
      int enmSize = (enms = this.defs.getEnums()).length;
      
      for(loopVal = 0; loopVal < enmSize; ++loopVal) 
      {
         EnumDefinition enm = enms[loopVal];
         phase.add("/**");
         phase.add(" * @brief Enum definition ");
         phase.add(" * ");
         phase.add(" * " + enm.getEnumComment());
         phase.add(" */");
         phase.add("typedef enum ");
         phase.add("{");
         
         for(loopVal2 = 0; loopVal2 < enm.getFields().length; ++loopVal2) {
            phase.add("    " + enm.getFields()[loopVal2].toUpperCase() + " = " + loopVal2 + " ,");
         }

         phase.add("}" + enm.getEnumName() + "Type;");
         phase.add(" ");
      }

   }

   public void sourceCommentPhase(List<String> phase) {
	   
   }
   public void sourcePhase(List<String> phase) {
   }
   
   public String build()
   {	 
	   List<String> phase = new ArrayList<String>();
	   phase.add("/*************START OF FILE*********************/");
	   this.headerCommentPhase(phase);
	   this.headerPhase(phase);
	   this.sourceCommentPhase(phase);
	   this.sourcePhase(phase);
	   phase.add("/*************END OF FILE***********************/");
	   super.addLines(phase);
	   
	   return super.build();   
   }
   
}
