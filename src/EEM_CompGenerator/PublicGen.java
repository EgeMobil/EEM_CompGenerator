package EEM_CompGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PublicGen extends CodeGenerator implements Namespaces, Functionallity {

	public PublicGen(String _compName , String _author , String[] _otherComps, Runable _runable) {
       super(_compName, _author, _otherComps, _runable);
    }
    
    public PublicGen() {
       super("NOT_ENTERED", null, null, null);
    }

   public String toString() {
      return "Public file name: " + this.nameGeneration();
   }

   public String nameGeneration() {
      String fileName = null;
      fileName = this.getComponentName().toString() + "_public.h";
      return fileName;
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
	   
   }

   public void headerPhase(List<String> phase) {
	   
	   phase.add("#ifndef " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_PUBLIC_H_");
	   phase.add("#define " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_PUBLIC_H_");
	   phase.add(" ");
	   
	   this.activePhase(phase);
	   
	   phase.add(" ");
	   phase.add("#endif /* " + this.getComponentName().toUpperCase() + "_INC_" + this.getComponentName().toUpperCase() + "_PUBLIC_H_ */ ");
	   
   }

   @Override
	public void activePhase(List<String> phase) {
	   
	   int loopVal	= 0 ;
	   int loopVal2	= 0 ;   
	   
	   phase.add(PREPROCESSOR + INCLUDE + " \"" + super.getComponentName().toString() + "_" + DEFINITION + HEADER + "\" " );  
	   phase.add(" ");
	
	   String[] runableNames;
	   int runableNameSize = ( runableNames = this.runables.getRunableNames()).length;
	   
	   for(loopVal = 0 ; loopVal < runableNameSize ; loopVal++) 
	   {
		   String runableName = this.getComponentName() + "_ru" + runableNames[loopVal];
		   String returnType = this.runables.getRunableReturnTypes()[loopVal];
		   
		   StringBuilder runableVar = new StringBuilder();
		   
		   String[] runableVarTypes = null;
		   String[] runableVarNames = null;
		   
		   int runableVarTypeSize = ( runableVarTypes = this.runables.getRunableVarTypes()[loopVal] ).length;
		   int runableVarNameSize = ( runableVarNames = this.runables.getRunableVarNames()[loopVal] ).length;
		   
		   int runableVarSize = Math.min( runableVarTypeSize, runableVarNameSize ); 
		   
		   char endline = ' ';
		   
		   for( loopVal2 = 0 ; loopVal2 < runableVarSize ; loopVal2++ )
		   {
			   
			   if( loopVal2 == (runableVarSize - 1) ) {
				   endline = ' ';
			   }
			   else
			   {
				   endline = ',';
			   }
			   
			   runableVar.append( " " + runableVarTypes[loopVal2] + " " + runableVarNames[loopVal2] + endline );	
		   }
		   
		   phase.add(EXTERN + "FUNC" + BRACELEFT + returnType + "," + runableName + BRACERIGHT + BRACELEFT + runableVar + BRACERIGHT + SEMICOLON);	
		   
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
