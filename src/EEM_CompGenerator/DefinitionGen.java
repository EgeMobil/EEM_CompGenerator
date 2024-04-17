package EEM_CompGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DefinitionGen extends CodeGenerator implements Namespaces, Functionallity {
   Definition defs;

   public DefinitionGen(String _compName) {
      super(_compName);
   }

   public DefinitionGen() {
      super("NOT_ENTERED");
   }

   public void setDefs(DataDefinition[] _data, StructureDefinition[] _struct, EnumDefinition[] _enum) {
      this.defs = new Definition();
      this.defs.setDatas(_data);
      this.defs.setStructures(_struct);
      this.defs.setEnums(_enum);
   }

   public String toString() {
      return "Definition file name: " + this.nameGeneration();
   }

   public String nameGeneration() {
      String fileName = null;
      fileName = this.getComponentName().toString() + "_definition.h";
      return fileName;
   }

   public void headerCommentPhase() {
      List<String> headerComment = new ArrayList<String>();
      this.setDate(LocalDate.now());
      headerComment.add("/* ");
      headerComment.add(" * " + this.nameGeneration());
      headerComment.add(" * ");
      headerComment.add(" *  Created on: " + String.valueOf(this.getDate()));
      headerComment.add(" *      Author: " + this.getAuthor());
      headerComment.add("*/ ");
      headerComment.add(" ");
      super.addLines(headerComment);
   }

   public void headerPhase() {
      List<String> phase = new ArrayList<String>();
      
      phase.add("#ifndef " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_H_");
      phase.add("#define " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_H_");
      phase.add(" ");
      
      this.activePhase(phase);
      
      phase.add(" ");
      phase.add("#endif /* " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_H_ */ ");
      super.addLines(phase);
   }

   public void activePhase(List<String> phase) {
	  
	  int loopVal=0;
	  
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

         for(loopVal = 0; loopVal < Math.min(str.getFieldTypes().length, str.getFields().length); ++loopVal) 
         {
            phase.add("    /* " + str.getDataComments()[loopVal] + " */");
            phase.add("    "    + str.getFieldTypes()[loopVal] + " " + str.getFields()[loopVal] + ";");
         }

         phase.add("}" + str.getStructureName() + "Type;");
         phase.add(" ");
      }

      EnumDefinition[] enms;
      int enmSize = (enms = this.defs.getEnums()).length;

      for(loopVal = 0; loopVal < enmSize; ++loopVal) {
         EnumDefinition enm = enms[loopVal];
         phase.add("/**");
         phase.add(" * @brief Enum definition ");
         phase.add(" * ");
         phase.add(" * " + enm.getEnumComment());
         phase.add(" */");
         phase.add("typedef enum ");
         phase.add("{");

         for(loopVal = 0; loopVal < enm.getFields().length; ++loopVal) {
            phase.add("    " + enm.getFields()[loopVal].toUpperCase() + " = " + loopVal + " ,");
         }

         phase.add("}" + enm.getEnumName() + "Type;");
         phase.add(" ");
      }

   }

   public void sourceCommentPhase() {
   }

   public void sourcePhase() {
   }
}
